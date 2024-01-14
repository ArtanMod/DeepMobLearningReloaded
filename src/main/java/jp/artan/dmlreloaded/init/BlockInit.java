package jp.artan.dmlreloaded.init;

import jp.artan.artansprojectcoremod.utils.BlockStateGenUtils;
import jp.artan.artansprojectcoremod.utils.SharedProperties;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.block.BlockExtractionChamber;
import jp.artan.dmlreloaded.block.BlockSimulationChamber;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.repack.registrate.providers.RegistrateRecipeProvider;
import jp.artan.repack.registrate.util.entry.BlockEntry;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;

public class BlockInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate().useCreativeTab(ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static final BlockEntry<Block> MACHINE_CASING = REGISTRATE.block("machine_casing", Block::new)
            .initialProperties(SharedProperties::stone)
            .blockstate((c, p) -> BlockStateGenUtils.cubeAll(c, p, "", "machine_base_up"))
            .simpleItem()
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ctx.get(), 8)
                        .define('#', ItemInit.SOOT_COVERED_PLATE.get())
                        .define('X', Items.IRON_INGOT)
                        .define('Y', ItemInit.SOOT_COVERED_REDSTONE.get())
                        .pattern("#X#")
                        .pattern("XYX")
                        .pattern("#X#")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(ItemInit.SOOT_COVERED_PLATE.get()))
                        .save(prov);
            })
            .lang("Machine Casing")
            .jpLang("機械の枠")
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .register();

    public static final BlockEntry<BlockSimulationChamber> SIMULATION_CHAMBER = REGISTRATE.block("simulation_chamber", BlockSimulationChamber::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(4f, 3000.0f).lightLevel(blockstate -> 7))
            .blockstate((ctx, prov) -> {
                ModelFile model = prov.models().getExistingFile(prov.modLoc("block/simulation_chamber"));

                prov.getVariantBuilder(ctx.get())
                        .forAllStates(state -> {
                            return ConfiguredModel.builder()
                                    .modelFile(model)
                                    .rotationY((((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180)) % 360)
                                    .build();
                        });

                prov.simpleBlockItem(ctx.get(), model);
            })
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ctx.get())
                        .define('#', Blocks.GLASS_PANE)
                        .define('X', Items.ENDER_PEARL)
                        .define('Y', MACHINE_CASING.get())
                        .define('A', Items.CYAN_DYE)
                        .define('B', Items.COMPARATOR)
                        .pattern(" # ")
                        .pattern("XYX")
                        .pattern("ABA")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(MACHINE_CASING.get()))
                        .save(prov);
            })
            .simpleItem()
            .lang("Simulation Chamber")
            .jpLang("シミュレーション室")
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .register();

    public static final BlockEntry<BlockExtractionChamber> EXTRACTION_CHAMBER = REGISTRATE.block("extraction_chamber", BlockExtractionChamber::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(4f, 10.0f).lightLevel(blockstate -> 15))
            .blockstate((ctx, prov) -> {
                ModelFile model = prov.models().getExistingFile(prov.modLoc("block/extraction_chamber"));

                prov.getVariantBuilder(ctx.get())
                        .forAllStates(state -> {
                            return ConfiguredModel.builder()
                                    .modelFile(model)
                                    .rotationY((((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180)) % 360)
                                    .build();
                        });

                prov.simpleBlockItem(ctx.get(), model);
            })
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ctx.get())
                        .define('#', Items.GOLD_INGOT)
                        .define('X', Items.DIAMOND)
                        .define('Y', MACHINE_CASING.get())
                        .define('A', Items.DANDELION)
                        .define('B', Items.COMPARATOR)
                        .pattern(" # ")
                        .pattern("XYX")
                        .pattern("ABA")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(MACHINE_CASING.get()))
                        .save(prov);
            })
            .simpleItem()
            .lang("Extraction Chamber")
            .jpLang("抽出室")
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .register();

    public static final BlockEntry<Block> INFUSED_INGOT_BLOCK = REGISTRATE.block("infused_ingot_block", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(4f, 10.0f))
            .blockstate((c, p) -> BlockStateGenUtils.cubeAll(c, p, "", "infused_ingot_blockface"))
            .simpleItem()
            .recipe((ctx, prov) -> {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ctx.get()).requires(ItemInit.GLITCH_INGOT.get(), 9)
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(ItemInit.GLITCH_INGOT.get()))
                        .save(prov);
            })
            .lang("Glitch Infused Block")
            .jpLang("グリッチが染み込んだブロック")
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .register();

    public static void register() {
    }
}
