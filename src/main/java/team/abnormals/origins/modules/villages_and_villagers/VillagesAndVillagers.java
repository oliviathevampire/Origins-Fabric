package team.abnormals.origins.modules.villages_and_villagers;

import me.sargunvohra.mcmods.autoconfig1.ConfigData;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import team.abnormals.abnormalib.utils.registry.RegistryUtils;
import team.abnormals.module_api.api.Module;
import team.abnormals.origins.Origins;
import team.abnormals.origins.modules.villages_and_villagers.items.VillagerItem;

public class VillagesAndVillagers extends Module {

    @Override
    public Class<? extends ConfigData> getConfig() {
        return VaVModuleConfig.class;
    }

    @Override
    public void init() {
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.HEAD), new Identifier(Origins.MOD_ID, "armorer_mask"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "armorer_apron"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.HEAD), new Identifier(Origins.MOD_ID, "butcher_headband"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "butcher_apron"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.HEAD), new Identifier(Origins.MOD_ID, "cartographer_monocle"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "cartographer_satchel"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "cleric_cloak"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.HEAD), new Identifier(Origins.MOD_ID, "farmer_straw_hat"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.HEAD), new Identifier(Origins.MOD_ID, "fisherman_hat"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "fisherman_vest"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.HEAD), new Identifier(Origins.MOD_ID, "fletcher_hat"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "fletcher_vest"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "leather_worker_apron"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.HEAD), new Identifier(Origins.MOD_ID, "librarian_book_and_glasses"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "librarian_garb"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "mason_vest"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.HEAD), new Identifier(Origins.MOD_ID, "shepherd_hat"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "shepherd_cloak"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "toolsmith_overalls"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.HEAD), new Identifier(Origins.MOD_ID, "weaponsmith_eyepatch"));
        RegistryUtils.registerItem(new VillagerItem(EquipmentSlot.CHEST), new Identifier(Origins.MOD_ID, "weaponsmith_overalls"));
    }

    @Override
    public void initClient() {

    }

}