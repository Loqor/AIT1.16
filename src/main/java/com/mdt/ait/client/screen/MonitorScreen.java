package com.mdt.ait.client.screen;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.network.NetworkHandler;
import com.mdt.ait.network.packets.tardis_monitor.TardisMonitorC2SExteriorChangePacket;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import io.mdt.ait.tardis.TARDIS;
import io.mdt.ait.tardis.TARDISManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.gui.widget.Slider;

import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class MonitorScreen extends Screen {
    private static final ResourceLocation MONITOR_GUI = new ResourceLocation(AIT.MOD_ID, "textures/screens/monitor_screen.png");
    private static final ResourceLocation EXTERIOR_SELECTION_TEST = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/exterior_screen_test.png");
    private static final ResourceLocation EXTERIOR_SELECTION_TEST2 = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/exterior_screen_test2.png");
    private static final ResourceLocation BASIC_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/basic_exterior_screen.png");
    private static final ResourceLocation BAKER_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/baker_exterior_screen.png");
    private static final ResourceLocation HELLBENT_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/hellbent_exterior_screen.png");
    private static final ResourceLocation CUSHING_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/cushing_exterior_screen.png");
    private static final ResourceLocation CLASSIC_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/classic_exterior_screen.png");
    private static final ResourceLocation HARTNELL_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/hartnell_exterior_screen.png");
    private static final ResourceLocation HUDOLIN_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/hudolin_exterior_screen.png");
    private static final ResourceLocation TARDIM_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/tardim_exterior_screen.png");
    private static final ResourceLocation FALLOUT_SHELTER_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/fallout_shelter_exterior_screen.png");
    private static final ResourceLocation RANI_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/rani_exterior_screen.png");
    private static final ResourceLocation CLOCK_EXTERIOR_SCREEN = new ResourceLocation(AIT.MOD_ID, "textures/gui/exterior_selections/clock_exterior_screen.png");

    private int imageHeight;
    private int imageWidth;
    public UUID tardisID;
    public ResourceLocation SelectedTardis;
    public TARDIS tardis;
    private Screen nestedScreen;

    public MonitorScreen(ITextComponent label, UUID tardisid, World world) {
        super(label);
        ++this.imageHeight;
        this.imageWidth = 231;
        this.imageHeight = 150;
        this.tardisID = tardisid;
        this.SelectedTardis = BASIC_EXTERIOR_SCREEN;
        if(!world.isClientSide) {
            tardis = TARDISManager.findTARDIS(this.tardisID);
        }
    }

    //@TODO I know this is confusing, it's basically getting the next exterior type.
    public void switchScreenTexture() {
        this.SelectedTardis = BASIC_EXTERIOR_SCREEN; // Fixme: this
        /*if (tardis != null) {
            if (tardis.getExteriorType() == EnumExteriorType.BASIC_BOX) {
                this.SelectedTardis = BASIC_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.MINT_BOX) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.CORAL_BOX) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.POSTER_BOX) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.BAKER_BOX) {
                this.SelectedTardis = BAKER_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.TYPE_40_TT_CAPSULE) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.HELLBENT_TT_CAPSULE) {
                this.SelectedTardis = HELLBENT_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.NUKA_COLA_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.ARCADE_CABINET_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.CUSHING_EXTERIOR) {
                this.SelectedTardis = CUSHING_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.CLASSIC_EXTERIOR) {
                this.SelectedTardis = CLASSIC_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.HARTNELL_EXTERIOR) {
                this.SelectedTardis = HARTNELL_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.HUDOLIN_EXTERIOR) {
                this.SelectedTardis = HUDOLIN_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.TX3_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.TARDIM_EXTERIOR) {
                this.SelectedTardis = TARDIM_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.SHALKA_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.BOOTH_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.STEVE_EXTERIOR) {
                this.SelectedTardis = EXTERIOR_SELECTION_TEST;
            }
            if (tardis.getExteriorType() == EnumExteriorType.FALLOUT_SHELTER_EXTERIOR) {
                this.SelectedTardis = FALLOUT_SHELTER_EXTERIOR_SCREEN;
            }
            if (tardis.getExteriorType() == EnumExteriorType.RANI_EXTERIOR) {
                this.SelectedTardis = RANI_EXTERIOR_SCREEN;
            }
            if(tardis.getExteriorType() == EnumExteriorType.CLOCK_EXTERIOR) {
                this.SelectedTardis = CLOCK_EXTERIOR_SCREEN;
            }
        }*/
    }

    @Override public void render(MatrixStack matrixStack, int pMouseX, int pMouseY, float pPartialTicks) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.renderBackground(matrixStack);
        this.renderTardisSelection(matrixStack);
        super.render(matrixStack, pMouseX, pMouseY, pPartialTicks);
        createText(matrixStack,"to Nested Screen",i+10,j+110,0x59d7e3);
        switchScreenTexture();
    }

    @Override
    public void renderBackground(MatrixStack pMatrixStack) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(MONITOR_GUI);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(pMatrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override protected void init() {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.addButton(
                new Button (i + 207, j + 60, 20, 20,
                        new StringTextComponent(">"),
                        (button) -> onPressRightButton()));
        this.addButton(
                new Button (i + 5, j + 60, 20, 20,
                        new StringTextComponent("<"),
                        (button) -> onPressLeftButton()));
        this.addWidget(
                new Widget(i+10,j+110,getStringWidth("to Nested Screen"),30, new StringTextComponent("type here maybe?")) {
                    @Override
                    public void onClick(double pMouseX, double pMouseY) {
                        super.onClick(pMouseX, pMouseY);
                        openNestedScreen(onBackClick());
                    }
                }
        );
//        Slider slider;
//        this.addButton(
//                slider = createSlider(this,i+5,j+60,20,128,new StringTextComponent("Slider 1: "),StringTextComponent.EMPTY,0d,128d,0d,false,true,(button) -> System.out.println())
//        );
//        slider.updateSlider();
    }

    public Screen onBackClick() {
        return this;
    }

    // use this to create sliders you fucking bitch ass btich boy loqor fuck you its 3ami  have school at 8 you know FUCK YOU WORK slave
    /*
    EXAMPLE USAGE:
    Slider slider;
    this.addButton(
        slider = createSlider(paramsHere)
    );
    slider.updateSlider();
    inside of a Screen class such as this one.
    */
    public static Slider createSlider(Screen screen, int xPos, int yPos, int width, int height, ITextComponent prefix, ITextComponent suf, double minVal, double maxVal, double currentVal, boolean showDec, boolean drawStr, Button.IPressable handler) {
        Slider slider;
        slider = new Slider(xPos,yPos,width,height,prefix,suf,minVal,maxVal,currentVal,showDec,drawStr,handler);
        return slider;
    }

    // does basically nothing you could just do the whole Minecraft.getinstance blah blah but this is easier to type
    public static void createText(MatrixStack matrixStack, String label, int xPos, int yPos, int colour) {
        FontRenderer font = Minecraft.getInstance().font;
        font.draw(matrixStack,label,xPos,yPos,colour);
    }
    // gets the width of a text
    // example uses - for turning texts into buttons via widgets, where you need to get the length of the text.
    private int getStringWidth(String label) {
        FontRenderer font = Minecraft.getInstance().font;
        return font.width(label);
    }


//    private void handleSlider(Slider slider, Button button) {
//        slider.updateSlider();
//    }

    public void renderTardisSelection(MatrixStack matrixStack) {
        matrixStack.pushPose();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(this.SelectedTardis);
        int i = (this.width - 64);
        int j = (this.height - 64);
        matrixStack.scale(0.5f, 0.5f, 0.5f);
        this.blit(matrixStack, i  + 16, j - 64, 0, 0, 256, 256);
        matrixStack.popPose();
    }

    private void onPressRightButton() {
        NetworkHandler.CHANNEL.sendToServer(new TardisMonitorC2SExteriorChangePacket(this.tardisID, true));
    }

    private void onPressLeftButton() {
        NetworkHandler.CHANNEL.sendToServer(new TardisMonitorC2SExteriorChangePacket(this.tardisID, false));
    }

    private void openNestedScreen(Screen currentScreen) {
        Screen nextScreen = new NestedScreenEXAMPLE(new TranslationTextComponent("Nested Monitor"),currentScreen);
        Minecraft.getInstance().setScreen(nextScreen);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
