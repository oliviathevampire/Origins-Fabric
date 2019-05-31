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

package team.abnormals.origins.init;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import team.abnormals.abnormalib.utils.registry.EntityRegistryBuilder;
import team.abnormals.origins.Origins;
import team.abnormals.origins.entity.FlyingLanternEntity;

public class OEntityTypes {

    public static final EntityType<FlyingLanternEntity> FLYING_LANTERN;

    static {
        FLYING_LANTERN = EntityRegistryBuilder
                .<FlyingLanternEntity>createBuilder(new Identifier(Origins.MOD_ID, "flying_lantern"))
                .entity(FlyingLanternEntity::new)
                .category(EntityCategory.MISC)
                .size(EntitySize.constant(1.0F, 1.0F))
                .hasEgg(false)
                .build();
    }

}