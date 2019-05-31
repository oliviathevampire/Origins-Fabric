package team.abnormals.origins;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.item.Items;
import team.abnormals.abnormalib.blocks.BaseModBlock;
import team.abnormals.abnormalib.old.utils.ContentBuilder;
import team.abnormals.abnormalib.old.utils.ContentRegistryBuilder;
import team.abnormals.abnormalib.old.utils.registry.WoodTypeRegistry;
import team.abnormals.module_api.ModuleManager;
import team.abnormals.origins.modules.decoration.DecorationsModule;
import team.abnormals.origins.modules.deeper.DeeperModule;
import team.abnormals.origins.modules.surface.SurfaceModule;
import team.abnormals.origins.modules.variations.VariationsModule;

public class Origins implements ModInitializer {

    public static final String MOD_ID = "origins";

    private static ContentBuilder contentBuilder;

    public static ContentBuilder getContentBuilder() {
        return contentBuilder;
    }

    @Override
    public void onInitialize() {

        contentBuilder = new ContentRegistryBuilder(MOD_ID);

        WoodTypeRegistry.registerModdedTypeListener((woodType, hardness, resistance) -> {
            woodType.baseBlock = contentBuilder.newBaseBlock(woodType.getIdentifier().getPath() + "_planks", new BaseModBlock(
                    FabricBlockSettings.of(Material.WOOD, MaterialColor.WOOD).hardness(hardness).resistance(resistance)
            ));

            contentBuilder.setBaseName(woodType.getIdentifier());
            contentBuilder.slab();
            contentBuilder.stairs();
            contentBuilder.button(true);
            contentBuilder.pressurePlate(PressurePlateBlock.ActivationRule.EVERYTHING);
            contentBuilder.fence();
            contentBuilder.fenceGate();
            contentBuilder.door();
            contentBuilder.trapDoor();
            contentBuilder.setSecondaryItem(Items.STICK);
            contentBuilder.sign();
        });

        ModuleManager.registerModule(MOD_ID, new SurfaceModule(), "surface");
        ModuleManager.registerModule(MOD_ID, new DecorationsModule(), "decorations");
        ModuleManager.registerModule(MOD_ID, new VariationsModule(), "variations");
        ModuleManager.registerModule(MOD_ID, new DeeperModule(), "deeper");

        contentBuilder.finish();
    }

}
