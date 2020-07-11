/*
package team.abnormals.origins.utils.registry;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.abnormals.origins.Origins;

public class RegistryUtils {

    public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType.Builder<T> builder) {
        BlockEntityType<T> blockEntityType = builder.build(null);
        Registry.register(Registry.BLOCK_ENTITY, new Identifier(Origins.MOD_ID, name), blockEntityType);
        return blockEntityType;
    }

}
*/
