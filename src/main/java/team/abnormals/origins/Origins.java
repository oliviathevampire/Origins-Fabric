package team.abnormals.origins;

import net.fabricmc.api.ModInitializer;
import team.abnormals.module_api.ModuleManager;
import team.abnormals.origins.modules.decoration.DecorationsModule;
import team.abnormals.origins.modules.deeper.DeeperModule;
import team.abnormals.origins.modules.surface.SurfaceModule;
import team.abnormals.origins.modules.variations.VariationsModule;

public class Origins implements ModInitializer {

    public static final String MOD_ID = "origins";

    @Override
    public void onInitialize() {

        ModuleManager.registerModule(MOD_ID, new SurfaceModule(), "surface");
        ModuleManager.registerModule(MOD_ID, new DecorationsModule(), "decorations");
        ModuleManager.registerModule(MOD_ID, new VariationsModule(), "variations");
        ModuleManager.registerModule(MOD_ID, new DeeperModule(), "deeper");

    }

}
