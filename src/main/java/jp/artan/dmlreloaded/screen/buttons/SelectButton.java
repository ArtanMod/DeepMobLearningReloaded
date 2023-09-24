package jp.artan.dmlreloaded.screen.buttons;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SelectButton extends Button {
    private final ResourceLocation resourceLocation;
    private final int xTexStart;
    private final int yTexStart;
    private final int yDiffTex;
    private final int xSelTex;
    private final int textureWidth;
    private final int textureHeight;
    private boolean selected;

    public SelectButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, int pXSelTex, ResourceLocation pResourceLocation, Button.OnPress pOnPress) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pXSelTex, false, pResourceLocation, pOnPress);
    }

    public SelectButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, int pXSelTex, boolean selected,ResourceLocation pResourceLocation, Button.OnPress pOnPress) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pXSelTex, selected, pResourceLocation, 256, 256, pOnPress);
    }

    public SelectButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, int pXSelTex, boolean selected, ResourceLocation pResourceLocation, int pTextureWidth, int pTextureHeight, Button.OnPress pOnPress) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pXSelTex, selected, pResourceLocation, pTextureWidth, pTextureHeight, pOnPress, MutableComponent.create(ComponentContents.EMPTY));
    }

    public SelectButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, int pXSelTex, boolean selected, ResourceLocation pResourceLocation, int pTextureWidth, int pTextureHeight, Button.OnPress pOnPress, Component pMessage) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pXSelTex, selected, pResourceLocation, pTextureWidth, pTextureHeight, pOnPress, DEFAULT_NARRATION, pMessage);
    }

    public SelectButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, int pXSelTex, boolean selected,ResourceLocation pResourceLocation, int pTextureWidth, int pTextureHeight, Button.OnPress pOnPress, Button.CreateNarration pCreateNarration, Component pMessage) {
        super(pX, pY, pWidth, pHeight, pMessage, pOnPress, pCreateNarration);
        this.textureWidth = pTextureWidth;
        this.textureHeight = pTextureHeight;
        this.xTexStart = pXTexStart;
        this.yTexStart = pYTexStart;
        this.yDiffTex = pYDiffTex;
        this.xSelTex = pXSelTex;
        this.resourceLocation = pResourceLocation;
        this.selected = selected;
    }

    public void setPosition(int pX, int pY) {
        this.setX(pX);
        this.setY(pY);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void selection() {
        if(this.selected) {
            this.selected = false;
        }else {
            this.selected=true;
        }
    }
}