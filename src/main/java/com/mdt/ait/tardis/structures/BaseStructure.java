package com.mdt.ait.tardis.structures;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.AITBlocks;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.TargetBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;
import org.lwjgl.system.CallbackI;

import javax.sound.midi.SysexMessage;
import java.util.*;


public class BaseStructure {
    private final ServerWorld tardisWorld;
    private final String name;
    private final String fileName;
    private List<ResourceLocation> structureList = new ArrayList<>();
//    public ArrayList<String> structureNameList = new ArrayList<>();
    public static String[] structureNameList = {"baker_corridor_straight","baker_corridor_fourway","baker_left_bend","baker_right_bend","baker_bedroom","ars_tree_room","downstairs_corridor","gardening_room","left_corridor_bend","long_corridor","medium_corridor","right_corridor_bend","short_corridor","upstairs_corridor"}; // TO ADD A NEW STRUCTURE, PUT ITS FILE NAME HERE PLEASE
    private Block[] blockIgnoreList = {AITBlocks.ARS_GENERATE_BLOCK.get(),AITBlocks.ARS_CENTRE_BLOCK.get()}; // blocks that will be ignored if found in the check

    private final String filePrefix = "rooms/";
    private final String directoryToFiles = "resources/data/ait/structures/rooms";
    private final Template structure_template;
    private final String fallback_structure = "baker_corridor_straight";

    /*
    ** READ ME **
    To add new structures to this file, its simple.
    BUT remember to read *ALL* the comments that regard advice on building first, as otherwise it may not function properly
    Simply drag and drop your .nbt file into resources/data/ait/structures/rooms
    Then, add its file name to the end of the structureNameList variable
    Example:
    * if my room was called "example_building.nbt"
    * and the variable was {"aaasa","sadsad"} before
    * i would add "example_building" to the variable and it would become
    * {"aasa","sadsad","example_building}
    GOOD LUCK
     */

    // Building Comments :

    // @TODO WARNING - WALLS ***MUST*** BE 5*5 WITH THE GENERATOR BLOCK ONE ABOVE THE MIDDLE, SEE EXAMPLE BELOW:
    // ALSO ENCASE YOUR ENTIRE STRUCTURE WITH STRUCTURE VOID BLOCKS, OR IT DELETES STUFF. ONLY INTERIOR SHOULD BE AIR.
    /*
    key: [] - any block :: - ars generator
    [] [] [] [] []
    [] [] [] [] []
    [] [] [] [] []
    [] [] :: [] []
    [] [] [] [] []
    UNDERSTAND? OTHERWISE IT GENERATES FUNKY
     */

    // @TODO WARNING - THE EMPTY WALL WHICH YOU ENTER THE ROOM FROM MUST BE THE NORTHERMOST POINT OF THE STRUCTURE, SEE EXAMPLE BELOW.
    /*
    key: ----- = EMPTY 5*5 WALL
       N
     -----
    E     W

       S
     */

    // @TODO WARNING - ENTRANCE MUST BE LIKE SHOWN, SEE EXAMPLE BELOW:
    /*
    key: [] - air block :: - ars centre block
    [] [] [] [] []
    [] [] [] [] []
    [] [] [] [] []
    [] [] :: [] []
    [] [] [] [] []
    OR YO STRUCTURE GONNA BE FONKAY
     */

    public BaseStructure(ServerWorld tardisWorld, String structureName) {
        this.tardisWorld = tardisWorld;
        this.name = structureName;
        this.fileName = filePrefix + structureName;
        //addFilesToStructureNameList(directoryToFiles);
        populateStructureList();
        structure_template = tardisWorld.getStructureManager().get(getStructureLocation(structureName));
    }

    public void placeStructure(ServerWorld destinationWorld, BlockPos destinationBlockPos, Direction destinationDirection, PlayerEntity player) {
        BlockPos centreBlockPos = findTargetBlockPosInTemplate(destinationBlockPos,destinationDirection,AITBlocks.ARS_CENTRE_BLOCK.get());
        BlockPos cornerBlockPos = getCornerPos(centreBlockPos, destinationDirection,true);
        if (cornerBlockPos == null || !safeToPlace(cornerBlockPos, destinationDirection, destinationWorld)) { // checks if the blockpos is broken or if the safe to place check returned false
            sendPlayerChat(false,player,null);
            return;
        }

        structure_template.placeInWorld(destinationWorld, cornerBlockPos, new PlacementSettings().setRotation(directionToRotation(destinationDirection)), destinationWorld.getRandom());
        destinationWorld.destroyBlock(findTargetBlockInPlacedStructure(getCornerPos(destinationBlockPos, destinationDirection,false),destinationDirection,destinationWorld,AITBlocks.ARS_CENTRE_BLOCK.get()),false);
        sendPlayerChat(true,player,null);
    }


    public Rotation directionToRotation(Direction direction) {
        if (direction == Direction.NORTH) {
            return Rotation.CLOCKWISE_180;
        }
        if (direction == Direction.SOUTH) {
            return Rotation.NONE;
        }
        if (direction == Direction.EAST) {
            return Rotation.COUNTERCLOCKWISE_90;
        }
        if (direction == Direction.WEST) {
            return Rotation.CLOCKWISE_90;
        }
        return Rotation.NONE; // just return NONE if fail.
    }


    // get where the entrance is expected to be : expected_y
    // remainder_y = size_y - expected_y
    // output_y -= remainder_y

    // @TODO FIX Y POS PROBLEMS :/
    private BlockPos getCornerPos(BlockPos pos,Direction direction,boolean excludeFirstRow) {
        BlockPos structure_size = structure_template.getSize(directionToRotation(direction));
        int size_x = structure_size.getX();
        int size_y = structure_size.getY();
        int size_z = structure_size.getZ();
        int centre_y = findTargetBlockPosInTemplate(pos,direction, AITBlocks.ARS_CENTRE_BLOCK.get()).getY();
        size_y -= centre_y;
        int remainder_y = pos.getY()-(pos.getY()-size_y);
        int output_y = 0;
        int update_y_count = 0;
        int new_pos_y = pos.getY();
        int new_pos_x = pos.getX();
        int new_pos_z = pos.getZ();

//        for (int i =0;pos.getY()-size_y == pos.getY();i++) {
//            if (pos.getY()-size_y > pos.getY()) {
//                size_y -= 1;
//                update_y_count -= 1;
//            }
//            if (pos.getY()-size_y < pos.getY()) {
//                size_y += 1;
//                update_y_count += 1;
//            }
//            System.out.println(update_y_count);
//            System.out.println(size_y);
//            System.out.println(pos.getY()-size_y);
//            System.out.println(pos.getY());
//        }
//        output_y += pos.getY() - remainder_y - 103;
//        System.out.println(remainder_y);
//        System.out.println(output_y);

        output_y = new_pos_y - 4;

        if (direction == Direction.NORTH) {
            new_pos_x += size_x + 1;
            if (excludeFirstRow) {
                new_pos_z += 1;
            }
        }
        if (direction == Direction.SOUTH) {
            new_pos_x -= size_x - 1;
            if (excludeFirstRow) {
                new_pos_z -= 1;
            }

        }
        if (direction == Direction.EAST) {
            new_pos_z += size_z + 1;
            if (excludeFirstRow) {
                new_pos_x -= 1;
            }
        };
        if (direction == Direction.WEST) {
            new_pos_z -= size_z - 1;
            if (excludeFirstRow) {
                new_pos_x += 1;
            }
        }
        if (direction == Direction.UP || direction == Direction.DOWN) {
            return null;
        }
        BlockPos new_pos = new BlockPos(new_pos_x, output_y,new_pos_z);
        return new_pos;
    }

    private BlockPos findTargetBlockPosInTemplate(BlockPos pos, Direction direction, Block targetBlock) {
        List<Template.BlockInfo> list = structure_template.filterBlocks(pos,new PlacementSettings().setRotation(directionToRotation(direction)),targetBlock);
        return list.get(0).pos;
    }

    private BlockPos findTargetBlockInPlacedStructure(BlockPos pos, Direction direction, World world, Block target_block) {
        BlockPos structure_size = structure_template.getSize(directionToRotation(direction));
        int size_x = structure_size.getX();
        int size_y = structure_size.getY();
        int size_z = structure_size.getZ();
        int x = pos.getX();
        int z = pos.getZ();
        int y = pos.getY();
        BlockPos checkPos = pos;


        if (direction == Direction.NORTH) {
            for (x=x; x >= pos.getX() - size_x; x--) {
                y = pos.getY();
                for (y=y; y <= pos.getY() + size_y; y++) {
                    z = pos.getZ() + 1;
                    checkPos = new BlockPos(x, y, z);
                    Block block = world.getBlockState(checkPos).getBlock();
                    if (block == target_block) {
                        return checkPos;
                    }
                }
            }
        }
        else if (direction == Direction.SOUTH){
            for (x=x; x <= pos.getX() + size_x; x++) {
                y = pos.getY();
                for (y=y; y <= pos.getY() + size_y; y++) {
                    z = pos.getZ() - 1;
                    checkPos = new BlockPos(x, y,z);
                    Block block = world.getBlockState(checkPos).getBlock();
                    if (block == target_block) {
                        return checkPos;
                    }
                }
            }
        }
        else if (direction == Direction.EAST) {
            for (z=z; z <= pos.getZ() + size_z - 1; z++) {
                y = pos.getY();
                for (y=y; y <= pos.getY() + size_y; y++) {
                    checkPos = new BlockPos(x, y, z);
                    Block block = world.getBlockState(checkPos).getBlock();
                    if (block == target_block) {
                        return checkPos;
                    }
                }
            }
        }
        else if (direction == Direction.WEST) {
            for (z=z; z >= pos.getZ() - size_z - 1; z--) {
                y = pos.getY();
                for (y=y; y <= pos.getY() + size_y; y++) {
                    checkPos = new BlockPos(x, y, z);
                    Block block = world.getBlockState(checkPos).getBlock();
                    if (block == target_block) {
                        return checkPos;
                    }
                }
            }
        }

        return null;
    }

   private boolean safeToPlace(BlockPos pos, Direction direction, World world) {
        BlockPos structure_size = structure_template.getSize(directionToRotation(direction));
        int size_x = structure_size.getX();
        int size_y = structure_size.getY();
        int size_z = structure_size.getZ();
        int x = pos.getX();
        int z = pos.getZ();
        int y = pos.getY();
        BlockPos checkPos = pos;


        // Long, lengthy check for directions as each direction needs to check a different way.
        // only way i know of doing this currently, if you know a better one PLEASE, let me know! :)
        if (direction == Direction.NORTH) {
            for (x=x; x >= pos.getX() - size_x; x--) {
                y = pos.getY();
                for (y=y; y <= pos.getY() + size_y; y++) {
                    z = pos.getZ()-2;
                    for (z=z; z >= pos.getZ() - size_z; z--) {
                        checkPos = new BlockPos(x, y, z);
                        Block block = world.getBlockState(checkPos).getBlock();
                        if (!(block instanceof AirBlock)) {
                            if (!isInIgnoreBlockList(block)) {
                                System.out.println("CHECK FAILED, FOUND BLOCK : " + world.getBlockState(checkPos).getBlock() + " AT POSITION: " + checkPos);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        else if (direction == Direction.SOUTH){
            for (x=x; x <= pos.getX() + size_x; x++) {
                y = pos.getY();
                for (y=y; y <= pos.getY() + size_y; y++) {
                    z = pos.getZ()+2;
                    for (z=z; z <= pos.getZ() + size_z; z++) {
                        checkPos = new BlockPos(x, y, z);
                        Block block = world.getBlockState(checkPos).getBlock();
                        if (!(block instanceof AirBlock)) {
                            if (!isInIgnoreBlockList(block)) {
                                System.out.println("CHECK FAILED, FOUND BLOCK : " + world.getBlockState(checkPos).getBlock() + " AT POSITION: " + checkPos);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        else if (direction == Direction.EAST) {
            x = pos.getX()+2;
            for (x=x; x <= pos.getX() + size_x; x++) {
                y = pos.getY();
                for (y=y; y <= pos.getY() + size_y; y++) {
                    z = pos.getZ()-2;
                    for (z=z; z >= pos.getZ() - size_z; z--) {
                        checkPos = new BlockPos(x, y, z);
                        Block block = world.getBlockState(checkPos).getBlock();
                        if (!(block instanceof AirBlock)) {
                            if (!isInIgnoreBlockList(block)) {
                                System.out.println("CHECK FAILED, FOUND BLOCK : " + world.getBlockState(checkPos).getBlock() + " AT POSITION: " + checkPos);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        else if (direction == Direction.WEST) {
            x = pos.getX()-2;
            for (x=x; x >= pos.getX() - size_x; x--) {
                y = pos.getY();
                for (y=y; y <= pos.getY() + size_y; y++) {
                    z = pos.getZ()-2;
                    for (z=z; z <= pos.getZ() + size_z; z++) {
                        checkPos = new BlockPos(x, y, z);
                        Block block = world.getBlockState(checkPos).getBlock();
                        if (!(block instanceof AirBlock)) {
                            if (!isInIgnoreBlockList(block)) {
                                System.out.println("CHECK FAILED, FOUND BLOCK : " + world.getBlockState(checkPos).getBlock() + " AT POSITION: " + checkPos);
                                return false;
                            }
                        }
                    }
                }
            }
        }


        else {
            return false;
        }

        return true;
    }

    private boolean isInIgnoreBlockList(Block block) {
        for (Block check_block : blockIgnoreList) {
            if (check_block == block) {
                return true;
            }
        }
        return false;
    }
    private ResourceLocation getStructureLocation(String name) {
        if (name == null) {
            name = fallback_structure;
        }
        name = "ait:" + filePrefix + name;
        for (ResourceLocation i : structureList) {
            if (i.toString().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public String getNextStructureName(String name) {
        name = filePrefix + name.toLowerCase();
        int name_location = 0;
        for (int i = 0; i <= structureNameList.length - 1; i++) {
            if (structureNameList[i] == name) {
                name_location = i;
                break;
            }
        }

        String new_name = structureNameList[name_location + 1];
        return new_name;
    }

    public String getPreviousStructureName(String name) {
        name = filePrefix + name.toLowerCase();
        int name_location = 0;
        for (int i = 0; i <= structureNameList.length - 1; i++) {
            if (structureNameList[i] == name) {
                name_location = i;
                break;
            }
        }

        String new_name = structureNameList[name_location - 1];
        return new_name;
    }

    /*private void addFilesToStructureNameList(String directory) {
        URL resource = AIT.class.getResource("/rooms");
        File fileDirectory;
        try {
            fileDirectory = new File(new File(resource.toURI()).getAbsolutePath());
        } catch (Exception e) {
            System.out.println("EXCEPTION WITH ADDING FILES TO BaseStructure: " + e);
            return;
        }
        System.out.println(fileDirectory.listFiles());
        File filesList[] = fileDirectory.listFiles();
        for (File file : filesList) {
            System.out.println(file.getName().substring(0,file.getName().length()-4));
            structureNameList.add(file.getName().substring(0,file.getName().length()-4));
        }
    }*/

    private void populateStructureList() {
        for (String i : structureNameList) {
            i = filePrefix + i;
            structureList.add(new ResourceLocation(AIT.MOD_ID,i));
        }
    }


    private void sendPlayerChat(boolean isSuccess, PlayerEntity player, String extra_information) {
        if (player != null) {
            if (isSuccess == false) {
                player.sendMessage(new TranslationTextComponent("FAILED to place structure: " + toStructureName(name)).setStyle(Style.EMPTY.withColor(TextFormatting.RED).withItalic(true)), UUID.randomUUID());
                if (extra_information != null) {
                    player.sendMessage(new TranslationTextComponent("Information: " + extra_information).setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW).withItalic(true)), UUID.randomUUID());
                }
            }
            if (isSuccess == true) {
                player.sendMessage(new TranslationTextComponent("Successfully placed structure: " + toStructureName(name)).setStyle(Style.EMPTY.withColor(TextFormatting.GREEN).withItalic(true)), UUID.randomUUID());
                if (extra_information != null) {
                    player.sendMessage(new TranslationTextComponent("Information: " + extra_information).setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW).withItalic(true)), UUID.randomUUID());
                }
            }
        }
    }

    public Template getTemplate() {
        return structure_template;
    }
    @Override
    public String toString() {
        return name;
    }
    public String toFileName() {
        return fileName;
    }

    /*
    Removes Underscores from the NBT file name
    Capitalises the first letter of every word
    Returns the new, more understandable, string.
     */
    public static String toStructureName(String name) {
        String spaced = name.replace("_", " ");
        String[] words = spaced.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            output.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1)).append(" ");
        }
        String capitalized = output.toString();
        return capitalized;
    }
}
