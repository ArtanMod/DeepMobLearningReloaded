package jp.artan.dmlreloaded.init;

import jp.artan.artansprojectcoremod.gen.BlockStateGen;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.block.BlockSimulationChamber;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.item.ItemDeepLearner;
import jp.artan.repack.registrate.providers.RegistrateRecipeProvider;
import jp.artan.repack.registrate.util.entry.BlockEntry;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;

public class BlockInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static final BlockEntry<BlockSimulationChamber> SIMULATION_CHAMBER = REGISTRATE.block("simulation_chamber", BlockSimulationChamber::new)
            .initialProperties(Material.STONE)
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
            .simpleItem()
            .lang("Simulation Chamber")
            .jpLang("シミュレーション室")
            .register();

    public static final BlockEntry<Block> INFUSED_INGOT_BLOCK = REGISTRATE.block("infused_ingot_block", Block::new)
            .initialProperties(Material.METAL)
            .properties(p -> p.strength(4f, 10.0f))
            .blockstate((c, p) -> BlockStateGen.cubeAll(c, p, "", "infused_ingot_blockface"))
            .simpleItem()
            .recipe((ctx, prov) -> {
                ShapelessRecipeBuilder.shapeless(ctx.get()).requires(ItemInit.GLITCH_INGOT.get(), 9)
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(ItemInit.GLITCH_INGOT.get()))
                        .save(prov);
            })
            .lang("Glitch Infused Block")
            .jpLang("グリッチが染み込んだブロック")
            .register();

    public static void register() {
    }
}
