package team.abnormals.origins.modules.variations;

import me.sargunvohra.mcmods.autoconfig1.ConfigData;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.abnormals.abnormalib.utils.registry.BlockRegistryBuilder;
import team.abnormals.module_api.api.Module;
import team.abnormals.origins.Origins;

public class VariationsModule extends Module {
    @Override
    public Class<? extends ConfigData> getConfig() {
        return VariationsModuleConfig.class;
    }

    @Override
    public void init() {
        for(DyeColor dyeColor : DyeColor.values()) {
            BlockRegistryBuilder.getInstance(new Identifier(Origins.MOD_ID, String.format("%s_terracotta", dyeColor.asString())),
                    Registry.BLOCK.get(new Identifier(String.format("%s_terracotta", dyeColor.asString())))).slab().stair().wall();
            BlockRegistryBuilder.getInstance(new Identifier(Origins.MOD_ID, String.format("%s_concrete", dyeColor.asString())),
                    Registry.BLOCK.get(new Identifier(String.format("%s_concrete", dyeColor.asString())))).slab().stair().wall();
        }
    }

    @Override
    public void initClient() {

    }
}
