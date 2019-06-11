package team.abnormals.origins.modules.villages_and_villagers.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class VillagerItem extends ArmorItem {

    public VillagerItem(EquipmentSlot equipmentSlot) {
        super(ArmorMaterials.LEATHER, equipmentSlot, new Item.Settings().group(ItemGroup.COMBAT));
    }

}