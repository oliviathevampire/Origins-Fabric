package team.abnormals.origins.init;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;
import net.minecraft.entity.mob.EvokerEntity;
import team.abnormals.origins.client.entity.renderer.EvokerEntityRenderer;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(EvokerEntity.class, (manager, context) -> new EvokerEntityRenderer(manager));
    }
}
