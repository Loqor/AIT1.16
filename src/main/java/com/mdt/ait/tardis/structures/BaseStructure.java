package com.mdt.ait.tardis.structures;

import com.mdt.ait.AIT;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
import java.util.List;


public class BaseStructure {
    private final ServerWorld tardisWorld;
    private final String name;
    private List<ResourceLocation> structureList = new ArrayList<>();
    public static String[] structureArrayString = {"baker_corridor_straight","baker_corridor_fourway"}; // TO ADD A NEW STRUCTURE, PUT ITS FILE NAME HERE PLEASE
    private final Template structure_template;
    public BaseStructure(ServerWorld tardisWorld, String structureName) {
        this.tardisWorld = tardisWorld;
        this.name = structureName;
        generateStructureList();
        structure_template = tardisWorld.getStructureManager().get(getStructureLocation(structureName));
    }

    public void placeStructure(ServerWorld destinationWorld, BlockPos destinationBlockPos, Direction destinationDirection) {
        destinationBlockPos = getCornerWallPos(destinationBlockPos, destinationDirection);
        // @TODO CHECK IF IT IS SAFE TO PLACE BLOCK THERE
//        if (!safeToPlace(destinationBlockPos, destinationDirection, destinationWorld)) {
//            return;
//        }
        structure_template.placeInWorld(destinationWorld, destinationBlockPos, new PlacementSettings().setRotation(directionToRotation(destinationDirection)), destinationWorld.getRandom());
    }


    // @TODO WARNING - THE EMPTY WALL WHICH YOU ENTER THE ROOM FROM MUST BE THE NORTHERMOST POINT OF THE STRUCTURE, SEE EXAMPLE BELOW.
    // @TODO WARNING - THE ENTRANCE MUST BE IN LINE WITH THE CENTRE OF THE STRUCTURE, OR IT PLACES INCORRECTLY.
    /*
    key: ----- = EMPTY 4*4 WALL
       N
     -----
    E     W

       S
     */
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
    private BlockPos getCornerWallPos(BlockPos pos,Direction direction) {
        BlockPos new_pos = pos;
        new_pos = new BlockPos(new_pos.getX(), new_pos.getY() - 2, new_pos.getZ());
        if (direction == Direction.NORTH) {
            new_pos = new BlockPos(new_pos.getX()+(structure_template.getSize(directionToRotation(direction)).getX()/2), new_pos.getY(), new_pos.getZ()+1);
        }
        if (direction == Direction.SOUTH) {
            new_pos = new BlockPos(new_pos.getX()-(structure_template.getSize(directionToRotation(direction)).getX()/2), new_pos.getY(), new_pos.getZ()-1);
        }
        if (direction == Direction.EAST) {
            new_pos = new BlockPos(new_pos.getX()-1, new_pos.getY(), new_pos.getZ()+(structure_template.getSize(directionToRotation(direction)).getZ()/2));
        }
        if (direction == Direction.WEST) {
            new_pos = new BlockPos(new_pos.getX()+1, new_pos.getY(), new_pos.getZ()-(structure_template.getSize(directionToRotation(direction)).getZ()/2));
        }
        return new_pos;
    }


//    private boolean safeToPlace(BlockPos pos, Direction direction, World world) {
//        BlockPos structure_size = structure_template.getSize(directionToRotation(direction));
//        // this code is going to be VERY VERY MESSY, its 2:17am :)
//        if (direction == Direction.NORTH) {
//            for (int x = 0; x <= structure_size.getX(); x++) {
//                for (int y = 0; y <= structure_size.getY(); y++) {
//                    for (int z = 0; z <= structure_size.getZ(); z++) {
//                        BlockPos i = new BlockPos(pos.getX() - x, pos.getY() + y, pos.getZ() - z);
//                        System.out.println(world.getBlockState(i).getBlock().getName());
//                        if (!(world.getBlockState(i).getBlock() instanceof AirBlock)) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        if (direction == Direction.SOUTH) {
//            for (int x = 0; x <= structure_size.getX(); x++) {
//                for (int y = 0; y <= structure_size.getY(); y++) {
//                    for (int z = 0; z <= structure_size.getZ(); z++) {
//                        BlockPos i = new BlockPos(pos.getX() - x, pos.getY() + y, pos.getZ() + z);
//                        System.out.println(world.getBlockState(i).getBlock().getName());
//                        if (!(world.getBlockState(i).getBlock() instanceof AirBlock)) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        if (direction == Direction.EAST) {
//            for (int x = 0; x <= structure_size.getX(); x++) {
//                for (int y = 0; y <= structure_size.getY(); y++) {
//                    for (int z = 0; z <= structure_size.getZ(); z++) {
//                        BlockPos i = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
//                        System.out.println(world.getBlockState(i).getBlock().getName());
//                        if (!(world.getBlockState(i).getBlock() instanceof AirBlock)) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        if (direction == Direction.WEST) {
//            for (int x = 0; x <= structure_size.getX(); x++) {
//                for (int y = 0; y <= structure_size.getY(); y++) {
//                    for (int z = 0; z <= structure_size.getZ(); z++) {
//                        BlockPos i = new BlockPos(pos.getX() - x, pos.getY() + y, pos.getZ() - z);
//                        System.out.println(world.getBlockState(i).getBlock().getName());
//                        if (!(world.getBlockState(i).getBlock() instanceof AirBlock)) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }
    private ResourceLocation getStructureLocation(String name) {
        name = "ait:" + name;
        for (ResourceLocation i : structureList) {
            if (i.toString().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public String getNextStructureName(String name) {
        name = name.toLowerCase();
        int name_location = 0;
        for (int i = 0; i <= structureArrayString.length - 1; i++) {
            if (structureArrayString[i] == name) {
                name_location = i;
                break;
            }
        }

        String new_name = structureArrayString[name_location + 1];
        return new_name;
    }

    public String getPreviousStructureName(String name) {
        name = name.toLowerCase();
        int name_location = 0;
        for (int i = 0; i <= structureArrayString.length - 1; i++) {
            if (structureArrayString[i] == name) {
                name_location = i;
                break;
            }
        }

        String new_name = structureArrayString[name_location - 1];
        return new_name;
    }

    private void generateStructureList() {
        for (String i : structureArrayString) {
            structureList.add(new ResourceLocation(AIT.MOD_ID,i));
        }
    }
    public Template getTemplate() {
        return structure_template;
    }
    @Override
    public String toString() {
        return name;
    }

    /*
    Removes Underscores from the NBT file name
    Capitalises the first letter of every word @TODO
    Returns the new, more understandable, string.
     */
    public static String toStructureName(String name) {
        return name.replace("_", " ");
    }
}
