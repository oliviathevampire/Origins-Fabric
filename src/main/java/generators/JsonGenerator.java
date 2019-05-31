package generators;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;

public class JsonGenerator {

    protected static Set<Identifier> fences = new HashSet<>();
    protected static Set<Identifier> walls = new HashSet<>();

    public static void finish() {
        genFencesTag();
        fences.clear();
        genWallsTag();
        walls.clear();
    }

    public static void main(String[] args) {
        for(DyeColor dyeColor : DyeColor.values()) {
            genStair(ResourceUtils.extendedModdedIdentifier(String.format("%s_terracotta", dyeColor.asString()), "_stairs"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_terracotta"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_terracotta"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_terracotta"));

            genSlab(ResourceUtils.extendedModdedIdentifier(String.format("%s_terracotta", dyeColor.asString()), "_slab"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_terracotta"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_terracotta"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_terracotta"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_terracotta"));

            genWall(ResourceUtils.extendedModdedIdentifier(String.format("%s_terracotta", dyeColor.asString()), "_wall"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_terracotta"));

            genStair(ResourceUtils.extendedModdedIdentifier(String.format("%s_concrete", dyeColor.asString()), "_stairs"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_concrete"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_concrete"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_concrete"));

            genSlab(ResourceUtils.extendedModdedIdentifier(String.format("%s_concrete", dyeColor.asString()), "_slab"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_concrete"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_concrete"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_concrete"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_concrete"));

            genWall(ResourceUtils.extendedModdedIdentifier(String.format("%s_concrete", dyeColor.asString()), "_wall"),
                    ResourceUtils.extendedVanillaIdentifier(dyeColor.asString(), "_concrete"));
        }

        finish();
    }

    public static void genStair(Identifier identifier, Identifier bottomTexture, Identifier topTexture, Identifier sideTexture) {
        String text = JsonTemplates.STAIRS_STATES.replace("modid", identifier.getNamespace())
                .replace("block_model", identifier.getPath());
        ResourceUtils.writeStringToFile(ResourceUtils.getBlockStatesPath(identifier.getNamespace()).resolve(identifier.getPath() + ".json").toFile(), text);

        genStairBlockJson(identifier, bottomTexture, topTexture, sideTexture);
        genStairItemModel(identifier);
    }

    public static void genStairBlockJson(Identifier identifier, Identifier bottomTexture, Identifier topTexture, Identifier sideTexture) {
        JsonObject textures = new JsonObject();
        textures.addProperty("bottom", String.format("%s:block/%s", bottomTexture.getNamespace(), bottomTexture.getPath()));
        textures.addProperty("top", String.format("%s:block/%s", topTexture.getNamespace(), topTexture.getPath()));
        textures.addProperty("side", String.format("%s:block/%s", sideTexture.getNamespace(), sideTexture.getPath()));

        JsonObject root = new JsonObject();
        root.addProperty("parent", "block/stairs");
        root.add("textures", textures);

        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + ".json").toFile(), root);

        root = new JsonObject();
        root.addProperty("parent", "block/inner_stairs");
        root.add("textures", textures);

        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + "_inner.json").toFile(), root);

        root = new JsonObject();
        root.addProperty("parent", "block/outer_stairs");
        root.add("textures", textures);

        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + "_outer.json").toFile(), root);
    }

    public static void genStairItemModel(Identifier identifier) {
        JsonObject root = new JsonObject();
        root.addProperty("parent", identifier.getNamespace() + ":block/" + identifier.getPath());

        ResourceUtils.writeJsonToFile(ResourceUtils.getItemModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + ".json").toFile(), root);
    }

    public static void genSlab(Identifier identifier, Identifier fullBlock, Identifier topTextureLocation, Identifier sideTextureLocation, Identifier bottomTextureLocation) {
        JsonObject root = new JsonObject();

        JsonObject variants = new JsonObject();

        JsonObject bottom = new JsonObject();
        bottom.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath());
        variants.add("type=bottom", bottom);

        JsonObject top = new JsonObject();
        top.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_top");
        variants.add("type=top", top);

        JsonObject doubleSlab = new JsonObject();
        doubleSlab.addProperty("model", fullBlock.getNamespace() + ":block/" + fullBlock.getPath());
        variants.add("type=double", doubleSlab);

        root.add("variants", variants);

        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockStatesPath(identifier.getNamespace()).resolve(identifier.getPath() + ".json").toFile(), root);

        genSlabBlockModel(identifier, topTextureLocation, sideTextureLocation, bottomTextureLocation);
        genSimpleBlockItemModel(identifier);
    }

    public static void genSlabBlockModel(Identifier identifier, Identifier topTextureLocation, Identifier sideTextureLocation, Identifier bottomTextureLocation) {
        JsonObject root = new JsonObject();
        root.addProperty("parent", "minecraft:block/slab");

        JsonObject textures = new JsonObject();
        textures.addProperty("bottom", bottomTextureLocation.getNamespace() + ":block/" + bottomTextureLocation.getPath());
        textures.addProperty("side", sideTextureLocation.getNamespace() + ":block/" + sideTextureLocation.getPath());
        textures.addProperty("top", topTextureLocation.getNamespace() + ":block/" + topTextureLocation.getPath());
        root.add("textures", textures);

        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + ".json").toFile(), root);

        root.addProperty("parent", "minecraft:block/slab_top");
        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + "_top.json").toFile(), root);
    }

    public static void genFence(Identifier identifier, Identifier textureName) {
        JsonObject root = new JsonObject();

        JsonArray multipart = new JsonArray();

        JsonObject pole = new JsonObject();

        JsonObject applyPost = new JsonObject();
        applyPost.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_post");
        pole.add("apply", applyPost);

        multipart.add(pole);

        JsonObject sideNorth = new JsonObject();

        JsonObject whenNorth = new JsonObject();
        whenNorth.addProperty("north", "true");
        sideNorth.add("when", whenNorth);

        JsonObject applyNorth = new JsonObject();
        applyNorth.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_side");
        applyNorth.addProperty("uvlock", true);
        sideNorth.add("apply", applyNorth);

        multipart.add(sideNorth);

        JsonObject sideEast = new JsonObject();

        JsonObject whenEast = new JsonObject();
        whenEast.addProperty("east", "true");
        sideEast.add("when", whenEast);

        JsonObject applyEast = new JsonObject();
        applyEast.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_side");
        applyEast.addProperty("uvlock", true);
        applyEast.addProperty("y", 90);
        sideEast.add("apply", applyEast);

        multipart.add(sideEast);

        JsonObject sideSouth = new JsonObject();

        JsonObject whenSouth = new JsonObject();
        whenSouth.addProperty("south", "true");
        sideSouth.add("when", whenSouth);

        JsonObject applySouth = new JsonObject();
        applySouth.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_side");
        applySouth.addProperty("uvlock", true);
        applySouth.addProperty("y", 180);
        sideSouth.add("apply", applySouth);

        multipart.add(sideSouth);

        JsonObject sideWest = new JsonObject();

        JsonObject whenWest = new JsonObject();
        whenWest.addProperty("west", "true");
        sideWest.add("when", whenWest);

        JsonObject applyWest = new JsonObject();
        applyWest.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_side");
        applyWest.addProperty("uvlock", true);
        applyWest.addProperty("y", 270);
        sideWest.add("apply", applyWest);

        multipart.add(sideWest);

        root.add("multipart", multipart);

        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockStatesPath(identifier.getNamespace()).resolve(identifier.getPath() + ".json").toFile(), root);

        fences.add(identifier);

        genFenceModel(identifier, textureName);
        genBlockItemModel(identifier, new Identifier(identifier.getNamespace(), identifier.getPath() + "_inventory"));
    }

    public static void genFenceModel(Identifier identifier, Identifier textureName) {
        JsonObject root = new JsonObject();

        JsonObject textures = new JsonObject();

        root.addProperty("parent", "block/fence_post");
        textures.addProperty("texture", textureName.getNamespace() + ":block/" + textureName.getPath());
        root.add("textures", textures);
        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + "_post.json").toFile(), root);

        root.addProperty("parent", "block/fence_side");
        textures.addProperty("texture", textureName.getNamespace() + ":block/" + textureName.getPath());
        root.add("textures", textures);
        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + "_side.json").toFile(), root);

        root.addProperty("parent", "block/fence_inventory");
        textures.addProperty("texture", textureName.getNamespace() + ":block/" + textureName.getPath());
        root.add("textures", textures);
        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + "_inventory.json").toFile(), root);
    }

    public static void genWall(Identifier identifier, Identifier textureName) {
        JsonObject root = new JsonObject();

        JsonArray multipart = new JsonArray();

        JsonObject pole = new JsonObject();

        JsonObject whenUp = new JsonObject();
        whenUp.addProperty("up", "true");
        pole.add("when", whenUp);

        JsonObject applyPost = new JsonObject();
        applyPost.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_post");
        pole.add("apply", applyPost);

        multipart.add(pole);

        JsonObject sideNorth = new JsonObject();

        JsonObject whenNorth = new JsonObject();
        whenNorth.addProperty("north", "true");
        sideNorth.add("when", whenNorth);

        JsonObject applyNorth = new JsonObject();
        applyNorth.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_side");
        applyNorth.addProperty("uvlock", true);
        sideNorth.add("apply", applyNorth);

        multipart.add(sideNorth);

        JsonObject sideEast = new JsonObject();

        JsonObject whenEast = new JsonObject();
        whenEast.addProperty("east", "true");
        sideEast.add("when", whenEast);

        JsonObject applyEast = new JsonObject();
        applyEast.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_side");
        applyEast.addProperty("uvlock", true);
        applyEast.addProperty("y", 90);
        sideEast.add("apply", applyEast);

        multipart.add(sideEast);

        JsonObject sideSouth = new JsonObject();

        JsonObject whenSouth = new JsonObject();
        whenSouth.addProperty("south", "true");
        sideSouth.add("when", whenSouth);

        JsonObject applySouth = new JsonObject();
        applySouth.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_side");
        applySouth.addProperty("uvlock", true);
        applySouth.addProperty("y", 180);
        sideSouth.add("apply", applySouth);

        multipart.add(sideSouth);

        JsonObject sideWest = new JsonObject();

        JsonObject whenWest = new JsonObject();
        whenWest.addProperty("west", "true");
        sideWest.add("when", whenWest);

        JsonObject applyWest = new JsonObject();
        applyWest.addProperty("model", identifier.getNamespace() + ":block/" + identifier.getPath() + "_side");
        applyWest.addProperty("uvlock", true);
        applyWest.addProperty("y", 270);
        sideWest.add("apply", applyWest);

        multipart.add(sideWest);

        root.add("multipart", multipart);

        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockStatesPath(identifier.getNamespace()).resolve(identifier.getPath() + ".json").toFile(), root);

        walls.add(identifier);

        genWallModel(identifier, textureName);
        genBlockItemModel(identifier, new Identifier(identifier.getNamespace(), identifier.getPath() + "_inventory"));
    }

    public static void genWallModel(Identifier identifier, Identifier textureName) {
        JsonObject root = new JsonObject();

        JsonObject textures = new JsonObject();

        root.addProperty("parent", "block/template_wall_post");
        textures.addProperty("wall", textureName.getNamespace() + ":block/" + textureName.getPath());
        root.add("textures", textures);
        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + "_post.json").toFile(), root);

        root.addProperty("parent", "block/template_wall_side");
        textures.addProperty("wall", textureName.getNamespace() + ":block/" + textureName.getPath());
        root.add("textures", textures);
        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + "_side.json").toFile(), root);

        root.addProperty("parent", "block/wall_inventory");
        textures.addProperty("wall", textureName.getNamespace() + ":block/" + textureName.getPath());
        root.add("textures", textures);
        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + "_inventory.json").toFile(), root);
    }

    public static void genSimpleBlockItemModel(Identifier identifier) {
        genBlockItemModel(identifier, identifier);
    }

    public static void genBlockItemModel(Identifier identifier, Identifier blockModelIdentifier) {
        JsonObject root = new JsonObject();
        root.addProperty("parent", blockModelIdentifier.getNamespace() + ":block/" + blockModelIdentifier.getPath());

        ResourceUtils.writeJsonToFile(ResourceUtils.getItemModelsPath(identifier.getNamespace()).resolve(identifier.getPath() + ".json").toFile(), root);
    }

    protected static void genFencesTag() {
        JsonObject root = new JsonObject();
        root.addProperty("replace", false);
        JsonArray values = new JsonArray();
        fences.forEach(identifier -> values.add(identifier.toString()));
        root.add("values", values);

        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockTagsPath("minecraft").resolve("fences.json").toFile(), root);
    }

    protected static void genWallsTag() {
        JsonObject root = new JsonObject();
        root.addProperty("replace", false);
        JsonArray values = new JsonArray();
        walls.forEach(identifier -> values.add(identifier.toString()));
        root.add("values", values);

        ResourceUtils.writeJsonToFile(ResourceUtils.getBlockTagsPath("minecraft").resolve("walls.json").toFile(), root);
    }

}
