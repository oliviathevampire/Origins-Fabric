package team.abnormals.origins.modules.villages_and_villagers.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class VillagerItem extends ArmorItem {

    public VillagerItem(EquipmentSlot equipmentSlot) {
        super(ArmorMaterials.LEATHER, equipmentSlot, new Item.Settings().group(ItemGroup.COMBAT));
    }

}