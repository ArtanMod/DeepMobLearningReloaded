package jp.artan.dmlreloaded.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.network.ServerboundResultingItemPacket;
import jp.artan.dmlreloaded.config.EnergyCostConfig;
import jp.artan.dmlreloaded.container.ExtractionChamberContainer;
import jp.artan.dmlreloaded.init.PacketHandler;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import jp.artan.dmlreloaded.screen.buttons.SelectButton;
import jp.artan.dmlreloaded.util.MathHelper;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.registries.ForgeRegistries;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExtractionChamberScreen extends AbstractContainerScreen<ExtractionChamberContainer> {

    private static final ResourceLocation base = new ResourceLocation(DeepMobLearningReloaded.MOD_ID, "textures/gui/extraction_chamber_base.png");
    private static final ResourceLocation extras = new ResourceLocation(DeepMobLearningReloaded.MOD_ID, "textures/gui/buttons/button_select.png");
    private static final ResourceLocation defaultGui = new ResourceLocation(DeepMobLearningReloaded.MOD_ID, "textures/gui/default_gui.png");
    boolean elementsAdded = false;
    private int startIndex;
    private NonNullList<SelectButton> buttons = NonNullList.create();
    private int selectedIndex;
    private boolean tileSelectData;
    private boolean scrolling;
    private float scrollOffs;

    public ExtractionChamberScreen(ExtractionChamberContainer pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        pMenu.handler.registerUpdateListener(this::containerChanged);
    }

    @Override
    protected void renderBg(PoseStack pose, float pPartialTick, int pMouseX, int pMouseY) {
        int left = getGuiLeft();
        int top = getGuiTop();
        int x = pMouseX - getGuiLeft();
        int y = pMouseY - getGuiTop();
        selectedIndex = this.menu.data.get(3);
        tileSelectData = this.menu.data.get(4)==1 ? true: false;

        // Render base
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, base);
        blit(pose, left , top , 0, 0, 178, 83);

        // Render scrollbar
        int k = (int)(41.0F * this.scrollOffs);
        int o = 0;
        if(12+k <= y && y < 31+k) {
            if(76 <= x && x < 82) {
                if(isScrollBarActive()) {
                    o=6;
                }
            }
        }
        blit(pose, left + 76, top + 12 + k, 178 + (this.isScrollBarActive() ? 0 : 12)+o, 0, 6, 19);


        // Render current energy
        int energyBarHeight = MathHelper.ensureRange((int) ((float) this.menu.data.get(1) / (this.menu.data.get(2) - EnergyCostConfig.FECOSTEXTRACTIONCHAMBER.get()) * 53), 0, 53);
        int energyBarOffset = 53 - energyBarHeight;
        blit(pose, left + 6,  top + 10 + energyBarOffset, 0, 83, 7, energyBarHeight);

        // Render crafting progress
        int craftingBarHeight = (int) (((float) this.menu.data.get(0) / 50 * 36));
        int craftingBarOffset = 36 - craftingBarHeight;
        blit(pose, left + 86,  top + 22 + craftingBarOffset, 7, 83, 6, craftingBarHeight);

        // Render playerInv
        RenderSystem.setShaderTexture(0, defaultGui);
        blit(pose, left + 0, top + 111, 0, 0, 176, 90);

        NumberFormat f = NumberFormat.getNumberInstance(Locale.ENGLISH);

        final int progress = this.menu.data.get(0);
        final int energyStored = this.menu.data.get(1);
        final int maxEnergy = this.menu.data.get(2);


        if(10 <= y && y < 63) {
            if(6 <= x && x < 13) {
                // Tooltip for energy
                List<Component> tooltip = new ArrayList<>();
                tooltip.add(Component.translatable("dmlreloaded.gui.energy.energystored", f.format(energyStored), f.format(maxEnergy)));
                tooltip.add(Component.translatable("dmlreloaded.gui.extraction_chamber.opcost", f.format(EnergyCostConfig.FECOSTEXTRACTIONCHAMBER.get())));
                renderComponentTooltip(pose, tooltip, pMouseX + 1, pMouseY - 11);
            }
        }
        if (23 <= y && y < 58) {
            if(84 <= x && x < 90) {
                List<Component> tooltip = new ArrayList<>();
                tooltip.add(Component.literal(progress + "/" + 100));
                renderComponentTooltip(pose, tooltip, pMouseX - 1, pMouseY - 11);
            }
        }
        if(!getPristine().isEmpty()) {
            renderLootList();
            if(!elementsAdded) {
                renderButtons();
                this.elementsAdded = true;
            }
        } else {
            if(elementsAdded) {
                buttons.forEach((Button btn) -> {
                    removeWidget(btn);
                });
                this.elementsAdded = false;
            }
        }
    }

    private ItemStack getPristine() {
        return this.menu.getPristine();
    }

    private void renderButtons() {
        for(int i = this.startIndex ; i < this.startIndex + 9 && i < getLootFromPristine().size(); i++) {
            int j = i - this.startIndex;
            int l = j / 3 * 19;
            int k = j % 3 * 19;
            int resultingIndex = i;
            SelectButton btn;
            // System.out.println(getLootFromPristine().size());
            if(selectedIndex == resultingIndex && tileSelectData) {
                btn = new SelectButton(getGuiLeft()+ 16 + k, 8 + getGuiTop() + l, 18, 18, 0, 0, 18, 18, true, extras, button -> {
                    if(!((SelectButton) button).isSelected()) {
                        PacketHandler.INSTANCE.sendToServer(new ServerboundResultingItemPacket(this.menu.pos, getItemFromList(resultingIndex), resultingIndex, true));
                        buttons.forEach((SelectButton buuton) -> {
                            buuton.setSelected(false);
                        });
                        ((SelectButton) button).selection();
                        this.scrolling = false;
                    } else if(((SelectButton) button).isSelected()){
                        PacketHandler.INSTANCE.sendToServer(new ServerboundResultingItemPacket(this.menu.pos, ItemStack.EMPTY, resultingIndex, false));
                        ((SelectButton) button).selection();
                    }

                });
            } else {
                btn = new SelectButton(getGuiLeft()+ 16 + i % 3 * 19, 8 + getGuiTop() + l, 18, 18, 0, 0, 18, 18, extras, button -> {
                    if(!((SelectButton) button).isSelected()) {
                        PacketHandler.INSTANCE.sendToServer(new ServerboundResultingItemPacket(this.menu.pos, getItemFromList(resultingIndex), resultingIndex, true));
                        buttons.forEach((SelectButton buuton) -> {
                            buuton.setSelected(false);
                        });
                        ((SelectButton) button).selection();
                        this.scrolling = false;
                    } else if(((SelectButton) button).isSelected()){
                        PacketHandler.INSTANCE.sendToServer(new ServerboundResultingItemPacket(this.menu.pos, ItemStack.EMPTY, resultingIndex, false));
                        ((SelectButton) button).selection();
                        this.scrolling = false;
                    }
                });
            }
            buttons.add(btn);
            addRenderableWidget(btn);
        }
    }

    protected int getOffscreenRows() {
        return (getLootFromPristine().size() + 2 - 1) / 2 - 1;
    }

    private boolean isScrollBarActive() {
        return !getPristine().isEmpty() && getLootFromPristine().size() > 9;
    }


    private void renderLootList() {
        for(int i = this.startIndex ;i < this.startIndex + 9 && i < getLootFromPristine().size(); i++) {
            int j = i - this.startIndex;
            int l = j / 3 * 19;
            int k = j % 3 * 19;
            ItemStack itemStack = getItemFromList(i);
            renderItemStackWithCount(itemStack, 17 + getGuiLeft() + k, 8 + getGuiTop() + l, itemStack.getCount());
        }
    }

    private ItemStack getItemFromList(int index) {
        if(index >= 0 && index < getLootFromPristine().size()) {
            return getLootFromPristine().get(index);
        } else {
            return ItemStack.EMPTY;
        }
    }

    private NonNullList<ItemStack> getLootFromPristine() {
        ItemStack stack = getPristine();

        if(stack.getItem() instanceof ItemPristineMatter pristine) {
            NonNullList<ItemStack> result = NonNullList.create();
            List<NonNullSupplier<ItemStack>> loots = pristine.getMobKey().getLoot();
            for(int i = 0; i < loots.size(); i++) {
                result.add(loots.get(i).get());
            }
            return result;
        } else {
            return NonNullList.create();
        }
    }

    private void renderItemStackWithCount(ItemStack stack, int x, int y, int count) {
        getMinecraft().getItemRenderer().renderAndDecorateItem(stack, x, y);
        getMinecraft().getItemRenderer().renderGuiItemDecorations(font, stack, x - 1, y - 1, count != 1 ? count + ""  : "");
    }

    /**
     * Called every time this screen's container is changed (is marked as dirty).
     */
    private void containerChanged() {
        if (getPristine().isEmpty()) {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
        }
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        int k = (int)(41.0F * this.scrollOffs);
        double x = pMouseX - getGuiLeft();
        double y = pMouseY - getGuiTop();
        if(12+k <= y && y < 31+k) {
            if(76 <= x && x < 82) {
                this.scrolling = true;
            }
        }
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    @Override
    public boolean mouseDragged(double pMouseX, double pMouseY, int pButton, double pDragX, double pDragY) {
        if (this.scrolling && this.isScrollBarActive()) {
            int i = this.topPos + 14;
            int j = i + 54;
            this.scrollOffs = ((float)pMouseY - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollOffs * (float)this.getOffscreenRows()) + 0.5D) * 3;
            buttons.forEach((Button btn) -> {
                removeWidget(btn);
            });
            this.elementsAdded = false;
            return true;
        } else {
            return super.mouseDragged(pMouseX, pMouseY, pButton, pDragX, pDragY);
        }
    }

    @Override
    public boolean mouseScrolled(double pMouseX, double pMouseY, double pDelta) {
        if (this.isScrollBarActive()) {
            int i = this.getOffscreenRows();
            float f = (float)pDelta / (float)i;
            this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollOffs * (float)i) + 0.5D) * 3;
            buttons.forEach((Button btn) -> {
                removeWidget(btn);
            });
            this.elementsAdded = false;
        }
        return true;
    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY) {
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

}
