package jp.artan.dmlreloaded.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.container.DeepLearnerContainer;
import jp.artan.dmlreloaded.item.ItemDeepLearner;
import jp.artan.dmlreloaded.util.DataModelHelper;
import jp.artan.dmlreloaded.util.RenderHelper;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.text.DecimalFormat;

public class DeepLearnerScreen extends AbstractContainerScreen<DeepLearnerContainer> {

    public static final int WIDTH =  338;
    public static final int HEIGHT = 235;
    protected ItemStack deepLearner;
    private InteractionHand hand;
    private MobMetaData meta;
    private Level world;
    private NonNullList<ItemStack> validDataModels;
    private int currentItem = 0;
    private PoseStack pose;
    private ImageButton imgBtnPrev;
    private ImageButton imgBtnNext;
    private static final ResourceLocation base = new ResourceLocation(DeepMobLearningReloaded.MOD_ID, "textures/gui/deeplearner_base.png");
    private static final ResourceLocation netherite_base = new ResourceLocation(DeepMobLearningReloaded.MOD_ID, "textures/gui/netherite_deeplearner_base.png");
    private static final ResourceLocation extras = new ResourceLocation(DeepMobLearningReloaded.MOD_ID, "textures/gui/deeplearner_extras.png");
    private static final ResourceLocation defaultGui = new ResourceLocation(DeepMobLearningReloaded.MOD_ID, "textures/gui/default_gui.png");

    public DeepLearnerScreen(DeepLearnerContainer container, Inventory playerInv, Component component) {
        super(container, playerInv, component);
        this.world = playerInv.player.level;
        hand = playerInv.player.getMainHandItem().getItem() instanceof ItemDeepLearner ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        this.deepLearner = playerInv.player.getItemInHand(hand);
    }

    private ResourceLocation getBaseTexture() {
        int loopCount = ((ItemDeepLearner)this.deepLearner.getItem()).squareSlotSize;
        return switch(loopCount) {
            case 3 -> netherite_base;
            default -> base;
        };
    }

    @Override
    protected void renderBg(PoseStack pose, float partialTicks, int mouseX, int mouseY) {
        int left = getGuiLeft();
        int top = getGuiTop();
        this.pose = pose;

        //Render base
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, getBaseTexture());
        blit(pose, left - 41, top-36 , 0, 0, 256, 140);

        //Render playerInv
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, defaultGui);
        blit(pose, left + 0, top + 111, 0, 0, 176, 90);

        // Get the meta for the first ItemDataModel in this deeplearner
        NonNullList<ItemStack> list = ItemDeepLearner.getContainedItems(deepLearner);
        this.validDataModels = DataModelHelper.getValidFromList(list);
        // Render cycle buttons if we have multiple models
        if(validDataModels.size() > 1) {
            if(renderables.size() < 2) {
                renderCycleButtons(pose, left, top);
            }
        }
        else {
            removeWidget(imgBtnNext);
            removeWidget(imgBtnPrev);

        }

        // If we have at least 1 valid data model
        if(validDataModels.size() >= 1 && currentItem <= validDataModels.size()) {
            int fixPos = (validDataModels.size()-1 - currentItem) < 0 ? validDataModels.size()-1 : validDataModels.size()-1 - currentItem;
            this.meta = DataModelHelper.getMobMetaData(validDataModels.get(validDataModels.size() >= 1 ? fixPos : currentItem));
            renderMetaDataText(meta, left, top, validDataModels.get(fixPos), pose);
            renderMobDisplayBox(pose, left, top);
            renderEntityInInventory(getGuiLeft() - 85, getGuiTop() + 52, meta, mouseX, mouseY, world);
        } else {
            renderDefaultScreen(pose);
        }
    }

    @Override
    public void render(PoseStack p_97795_, int p_97796_, int p_97797_, float p_97798_) {
        this.renderBackground(p_97795_);
        super.render(p_97795_, p_97796_, p_97797_, p_97798_);
        this.renderTooltip(p_97795_, p_97796_, p_97797_);
    }

    private void renderDefaultScreen(PoseStack pose) {
        int leftStart = getGuiLeft() - 32;
        int top = getGuiTop() - 32;
        int spacing = 12;
        drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.deep_learner.not_found"), leftStart, top + spacing, 0x55FFFF);
        drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.deep_learner.insert"), leftStart, top + (spacing*2), 0xFFFFFF);
        drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.deep_learner.collect_data"), leftStart, top + (spacing*3), 0xFFFFFF);
        drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.deep_learner.when_placed"), leftStart, top + (spacing*4), 0xFFFFFF);
        drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.deep_learner.in_order"), leftStart, top + (spacing*6), 0xFFFFFF);
        drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.deep_learner.killing_blow"), leftStart, top + (spacing*7), 0xFFFFFF);
    }

    private void renderMetaDataText(MobMetaData meta, int left, int top, ItemStack stack, PoseStack pose) {
        DecimalFormat f = new DecimalFormat("0.#");
        int leftStart = getGuiLeft() - 32;
        int topStart = top - 40;
        int spacing = 12;

        drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.name"), leftStart, topStart + spacing, 0x55FFFF);
        drawString(pose, font,  new TranslatableComponent("dmlreloaded.gui.mob_name", new TranslatableComponent(meta.getEntityId())), leftStart, topStart + (spacing *  2), 0xFFFFFF);
        drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.information"), leftStart, topStart + (spacing *  3), 0xFFFFFF);
        int mobTriviaLine = meta.getMobTriviaLine();
        for (int i = 0; i < mobTriviaLine; i++) {
            drawString(pose, font, meta.getMobTrivia(i), leftStart, topStart + (spacing * 3) + ((i + 1) * 12), 0xFFFFFF);
        }
        MutableComponent dataModelTier = DataModelHelper.getTierName(stack, false);
        MutableComponent nextTier = DataModelHelper.getTierName(stack, true);
        int totalKills = DataModelHelper.getTotalKillCount(stack);
        double killsToNextTier = DataModelHelper.getKillsToNextTier(stack);
        drawString(pose, font, new TranslatableComponent("dmlreloaded.tiers.tier", dataModelTier), leftStart, topStart + (spacing * 8), 0xFFFFFF);
        drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.defeated", new TranslatableComponent(meta.getEntityId()), totalKills), leftStart, topStart + (spacing * 9), 0xFFFFFF);
        if(DataModelHelper.getTier(stack) != DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
            drawString(pose, font, new TranslatableComponent("dmlreloaded.tiers.tier_next", f.format(killsToNextTier), nextTier), leftStart, topStart + (spacing * 10), 0xFFFFFF);
        } else {
            drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.deep_learner.max"), leftStart, topStart + (spacing * 10), 0xFFFFFF);
        }
        // Draw heart
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, getBaseTexture());
        blit(pose, left + 154, topStart + (spacing * 2) - 2, 0, 140, 9, 9);
        drawString(pose, font, new TranslatableComponent("dmlreloaded.gui.deep_learner.hp"), left + 154, topStart + spacing, 0x55FFFF);
        int numOfHearts = meta.getNumberOfHearts();
        if(numOfHearts == 0) {
            // Obfuscate if hearts is 0, use for models with multiple mobmetas
            drawString(pose, font, "�k10�r", left + 164, topStart + (spacing * 2) - 1, 0xFFFFFF);
        } else {
            drawString(pose, font, "" + meta.getNumberOfHearts(), left + 164, topStart + (spacing * 2) - 1, 0xFFFFFF);
        }
    }

    private void renderCycleButtons(PoseStack pose, int left, int top) {
        // Draw the buttons
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, extras);
        imgBtnPrev = new ImageButton(getGuiLeft() - 84, getGuiTop() + 70, 24, 24, 99, 0, 24, extras, 255, 255, btn -> {
            if(validDataModels.size() > 1) {
                this.currentItem = nextItemIndex();
            }
        });
        imgBtnNext = new ImageButton(getGuiLeft() - 110, getGuiTop() + 70, 24, 24, 75, 0, 24, extras, 255, 255, btn -> {
            if(validDataModels.size() > 1) {
                this.currentItem = previousItemIndex();
            }
        });
        addRenderableWidget(imgBtnNext);
        addRenderableWidget(imgBtnPrev);
    }

    private void renderMobDisplayBox(PoseStack pose, int left, int top) {
        // Draw the mob display box
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, extras);
        blit(pose, left -123, top-36, 0, 0, 75, 101);
    }


    @Override
    protected void renderLabels(PoseStack p_97808_, int p_97809_, int p_97810_) {
    }

    public NonNullList<ItemStack> getItemStacks() {
        NonNullList<ItemStack> list = NonNullList.create();
        int numOfSlots  = this.menu.getInternalSlotSize();
        for (int i = 0; i < numOfSlots; i++) {
            list.add(i, getMenu().getSlot(i).getItem());
        }
        return list;
    }

    @Override
    public Component getTitle() {
        return super.getTitle();
    }

    @Override
    protected void slotClicked(Slot slot, int dragType, int index, ClickType clickTypeIn) {
        this.validDataModels = DataModelHelper.getValidFromList(ItemDeepLearner.getContainedItems(deepLearner));
        if(validDataModels.size() >= 1 && currentItem < validDataModels.size()) {
            this.meta = DataModelHelper.getMobMetaData(validDataModels.get(currentItem));
            renderMetaDataText(meta, getGuiLeft(), getGuiTop(), validDataModels.get(currentItem), pose);
            if(slot!= null && slot.getItem().isEmpty()) {
                nextItemIndex();
            }
        }
        getMenu().getDeepInv().setChanged();
        super.slotClicked(slot, dragType, index, clickTypeIn);
    }

    @SuppressWarnings("deprecation")
    public static void renderEntityInInventory(int xPos, int yPos, MobMetaData meta, double mouseX, double mouseY, Level world) {
        LivingEntity entity = meta.getEntity(world);
        if(entity != null) {
            PoseStack poseStack = RenderSystem.getModelViewStack();
            float scale = getScale(entity);
            int offsetY = meta.getOffsetY(entity);
            RenderHelper.renderEntity(
                    poseStack,
                    xPos, yPos - offsetY, scale,
                    210 - mouseX,
                    120 - offsetY - mouseY,
                    entity,
                    meta
            );
        }
    }

    private static float getScale(LivingEntity livingEntity) {
        float width = livingEntity.getBbWidth();
        float height = livingEntity.getBbHeight();
        if (width <= height) {
            if (height < 0.9) return 50.0F;
            else if (height < 1) return 35.0F;
            else if (height < 1.8) return 33.0F;
            else if (height < 2) return 32.0F;
            else if (height < 3) return 24.0F;
            else if (height < 4) return 20.0F;
            else return 10.0F;
        } else {
            if (width < 1) return 38.0F;
            else if (width < 2) return 27.0F;
            else if (width < 3) return 13.0F;
            else return 9.0F;
        }
    }

    private int nextItemIndex() {
        int result;
        // If last in list go back to start of list
        if(currentItem == validDataModels.size() - 1) {
            result = 0;
        } else {
            result = currentItem + 1;
        }
        return result;
    }

    private int previousItemIndex() {
        int result;
        // If first in list
        if(currentItem == 0) {
            if(validDataModels.size() > 1) {
                result = validDataModels.size() - 1;
            } else {
                result = 0;
            }
        } else {
            result = currentItem - 1;
        }

        return result;
    }
}
