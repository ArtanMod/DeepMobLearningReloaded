package jp.artan.dmlreloaded.screen.buttons;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
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
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pXSelTex, selected, pResourceLocation, pTextureWidth, pTextureHeight, pOnPress, TextComponent.EMPTY);
    }

    public SelectButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, int pXSelTex, boolean selected, ResourceLocation pResourceLocation, int pTextureWidth, int pTextureHeight, Button.OnPress pOnPress, Component pMessage) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pXSelTex, selected, pResourceLocation, pTextureWidth, pTextureHeight, pOnPress, NO_TOOLTIP, pMessage);
    }

    public SelectButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, int pXSelTex, boolean selected,ResourceLocation pResourceLocation, int pTextureWidth, int pTextureHeight, Button.OnPress pOnPress, Button.OnTooltip pOnTooltip, Component pMessage) {
        super(pX, pY, pWidth, pHeight, pMessage, pOnPress, pOnTooltip);
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
        this.x = pX;
        this.y = pY;
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

    public void renderButton(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, this.resourceLocation);
        int i = this.yTexStart;
        int o = this.xTexStart;
        if (this.isHoveredOrFocused()&& !this.selected) {
            i += this.yDiffTex;
        }
        else if(this.selected) {
            o += this.xSelTex;
        }

        RenderSystem.enableDepthTest();
        blit(pPoseStack, this.x, this.y, (float)o, (float)i, this.width, this.height, this.textureWidth, this.textureHeight);
        if (this.isHovered) {
            this.renderToolTip(pPoseStack, pMouseX, pMouseY);
        }

    }
}