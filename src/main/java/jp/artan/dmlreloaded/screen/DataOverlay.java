package jp.artan.dmlreloaded.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.config.ClientConfig;
import jp.artan.dmlreloaded.item.ItemDeepLearner;
import jp.artan.dmlreloaded.util.DataModelHelper;
import jp.artan.dmlreloaded.util.PlayerHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.text.DecimalFormat;

public class DataOverlay extends Screen {

    private Minecraft mc;
    private ItemStack deepLearner;
    private NonNullList<ItemStack> dataModels;
    private PlayerHelper playerH;
    private int componentHeight = 26;
    private int barSpacing = 12;
    private static final ResourceLocation experienceBar = new ResourceLocation(DeepMobLearningReloaded.MOD_ID, "textures/gui/experience_gui.png");

    public DataOverlay(Component pTitle) {
        super(pTitle);
        this.mc = Minecraft.getInstance();
    }

    @SubscribeEvent(priority=EventPriority.NORMAL)
    public void renderOverlay(RenderGuiOverlayEvent.Post event) {
//        if (event.getType() != RenderGuiOverlayEvent.ElementType.LAYER) {
//            return;
//        }

        if(!mc.isWindowActive()) {
            return;
        }

        this.playerH = new PlayerHelper(mc.player);
        if(!playerH.isHoldingDeepLearner()) {
            return;
        } else {
            this.deepLearner = playerH.getHeldDeepLearner();
            this.dataModels = DataModelHelper.getValidFromList(ItemDeepLearner.getContainedItems(deepLearner));
        }


        int x = ClientConfig.guiOverlayHorizontalSpacing.get();
        int y = ClientConfig.guiOverlayVerticalSpacing.get();
        int position = ClientConfig.guiOverlaySide.get();
        switch (position) {
            case 0:
                x = x + getLeftCornerX() + 18;
                y = y + 5;
                break;
            case 1:
                x = x + getRightCornerX();
                y = y + 5;
                break;
            case 2:
                x = x + getLeftCornerX() + 18;
                y = y + getBottomY(dataModels.size()) - 5;
                break;
            case 3:
                x = x + getRightCornerX();
                y = y + getBottomY(dataModels.size()) - 5;
                break;
            default:
                x = x + getLeftCornerX() + 18;
                y = y + 5;
                break;
        }

        for (int i = 0; i < dataModels.size(); i++) {
            ItemStack stack = dataModels.get(i);
            Component tierName = DataModelHelper.getTierName(stack, false);
            int tier = DataModelHelper.getTier(stack);
            double k = DataModelHelper.getKillsToNextTier(stack);
            double c = DataModelHelper.getCurrentTierKillCountWithSims(stack);
            int roof = DataModelHelper.getTierRoofAsKills(stack);
            PoseStack pose = event.getPoseStack();
            drawExperienceBar(pose, x, y, i, tierName, tier, k, c, roof, stack);
        }
    }

    private void drawExperienceBar(PoseStack pose, int x, int y, int index, Component tierName, int tier, double killsToNextTier, double currenKillCount, int tierRoof, ItemStack stack) {
        DecimalFormat f = new DecimalFormat("0.#");

        drawItemStack(x - 18, y - 2 + barSpacing + (index * componentHeight), stack);
        drawString(pose, mc.font, Component.translatable("dmlreloaded.gui.deep_learner.overlay",tierName), x - 14, y + (index * componentHeight) + 2, 0xFFFFFF);

        // Draw the bar
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, experienceBar);
        blit(pose, x, y + barSpacing + (index * componentHeight), 0, 0, 89, 12);

        if(tier == DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
            blit(pose, x + 1,  y + 1 + barSpacing + (index * componentHeight), 0, 12, 89, 11);
        } else {
            blit(pose, x + 1,  y + 1 + barSpacing + (index * componentHeight), 0, 12,
                    (int) (((float) currenKillCount / tierRoof * 89)), 11);
            drawString(pose, mc.font, f.format(killsToNextTier) + " to go", x + 3, y + 2 + barSpacing + (index * componentHeight), 0xFFFFFF);
        }
    }

    private void drawItemStack(int x, int y, ItemStack stack) {
        mc.getItemRenderer().renderAndDecorateFakeItem(stack, x, y);
    }

    private int getLeftCornerX() {
        return 5;
    }

    private int getRightCornerX() {
        return Minecraft.getInstance().getWindow().getGuiScaledWidth() - width - 5;
    }

    private int getBottomY(int numberOfBars) {
        return Minecraft.getInstance().getWindow().getGuiScaledHeight() - (numberOfBars * componentHeight);
    }

}

