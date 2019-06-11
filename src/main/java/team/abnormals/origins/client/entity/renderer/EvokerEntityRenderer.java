package team.abnormals.origins.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.util.Identifier;

import javax.annotation.Nullable;

public class EvokerEntityRenderer extends MobEntityRenderer<EvokerEntity, EvokerEntityModel> {

    private static final Identifier EVOKER_TEXTURE = new Identifier("origins", "textures/entity/illager/evoker.png");

    public EvokerEntityRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
        super(entityRenderDispatcher_1, new EvokerEntityModel(), 0F);
    }

    @Nullable
    @Override
    protected Identifier getTexture(EvokerEntity var1) {
        return EVOKER_TEXTURE;
    }

}