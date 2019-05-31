/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Team Abnormals
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package team.abnormals.origins.modules.decoration;

import me.sargunvohra.mcmods.autoconfig1.ConfigData;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import team.abnormals.abnormalib.blocks.BaseModBlock;
import team.abnormals.module_api.api.Module;
import team.abnormals.origins.Origins;
import team.abnormals.origins.block.sapling.PalmSaplingGenerator;
import team.abnormals.origins.utils.registry.WoodRegistry;

public class DecorationsModule extends Module {

    public Block COCONUT;
    public Block DIAMOND_PILLAR, EMERALD_PILLAR, IRON_PILLAR, GOLD_PILLAR;
    public Block DIAMOND_BRICKS, EMERALD_BRICKS, IRON_BRICKS, GOLD_BRICKS;
    public Block ANDESITE_BRICKS, GRANITE_BRICKS, DIORITE_BRICKS;
    public Block ANDESITE_PILLAR, GRANITE_PILLAR, DIORITE_PILLAR;
    public Block GRATE, IRON_GRATE, GOLD_GRATE;
    public Block PACKED_ICE_BRICKS, PACKED_ICE_PILLAR, ICE_TILES;
    public Block STICK_BUNDLE, CHORUS_BUNDLE, SUGAR_CANE_BUNDLE, BAMBOO_BUNDLE, NETHER_WART_SACK, COCOA_BEAN_SACK, GUNPOWDER_SACK,
            EGG_CRATE, BEETROOT_CRATE, POTATO_CRATE, CARROT_CRATE, APPLE_CRATE, GOLDEN_APPLE_CRATE, CACTUS_BUNDLE;
    public Block BAMBOO_PLANKS, BAMBOO_SIGN, BAMBOO_WALL_SIGN, BAMBOO_TORCH, BAMBOO_DOOR, BAMBOO_TRAPDOOR, THATCH;
    public Block POTTED_BEETROOT, POTTED_CARROTS, POTTED_CHORUS, POTTED_GRASS, POTTED_LILAC, POTTED_MELON, POTTED_NETHER_WART, POTTED_PEONY,
            POTTED_POTATOES, POTTED_PUMPKIN, POTTED_ROSE_BUSH, POTTED_SUGAR_CANE, POTTED_SUNFLOWER, POTTED_TALL_GRASS, POTTED_LARGE_FERN, POTTED_WHEAT;

    public static  WoodRegistry PALM;
    public static WoodRegistry WILLOW;

    @Override
    public Class<? extends ConfigData> getConfig() {
        return DecorationsModuleConfig.class;
    }

    @Override
    public void init() {
        PALM = new WoodRegistry.Builder(new Identifier(Origins.MOD_ID, "palm"), new PalmSaplingGenerator())
                .planks().log().log(new BaseModBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F)
                        .sounds(BlockSoundGroup.WOOD).build()), "palm_log_top").strippedLog().wood().strippedWood().door().trapdoor().leaves()
                .sapling().fence().fenceGate().slab().stairs().build();
        WILLOW = new WoodRegistry.Builder(new Identifier(Origins.MOD_ID, "willow"))
                .planks().log().strippedLog().wood().strippedWood().door().trapdoor().leaves().waterloggedSapling().sapling().build();
    }

    @Override
    public void initClient() {

    }

}