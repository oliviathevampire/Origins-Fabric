package generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringEscapeUtils;
import team.abnormals.origins.Origins;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceUtils {

    public static final Path RESOURCES_PATH = Paths.get("src", "main", "resources");
    public static final Path ASSETS_PATH = RESOURCES_PATH.resolve("assets");
    public static final Path DATA_PATH = RESOURCES_PATH.resolve("data");
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().setLenient().create();

    public static Path getAssetsModPath(String modId) {
        return ASSETS_PATH.resolve(modId);
    }

    public static Path getDataPath(String modId) {
        return DATA_PATH.resolve(modId);
    }

    public static Path getBlockStatesPath(String modId) {
        Path path = getAssetsModPath(modId).resolve("blockstates");
        createPath(path.toFile());
        return path;
    }

    public static Path getBlockModelsPath(String modId) {
        Path path = getAssetsModPath(modId).resolve("models").resolve("block");
        createPath(path.toFile());
        return path;
    }

    public static Path getLangPath(String modId) {
        Path path = getAssetsModPath(modId).resolve("lang");
        createPath(path.toFile());
        return path;
    }

    public static Path getItemModelsPath(String modId) {
        Path path = getAssetsModPath(modId).resolve("models").resolve("item");
        createPath(path.toFile());
        return path;
    }

    public static Path getLootTablesPath(String modId) {
        Path path = getDataPath(modId).resolve("loot_tables");
        createPath(path.toFile());
        return path;
    }

    public static Path getBlockTagsPath(String modId) {
        return getDataPath(modId).resolve("tags").resolve("blocks");
    }

    public static void createPath(File file) {
        if(!file.exists())
            file.mkdirs();
    }

    public static void writeJsonToFile(File file, JsonObject json) {
        writeStringToFile(file, StringEscapeUtils.unescapeJson(GSON.toJson(json)));
    }

    public static void writeStringToFile(File file, String text) {
        try {
            FileUtils.writeStringToFile(file, text, CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.printf("Error creating file %s.json" + "\n", file.getAbsolutePath());
        }
    }

    public static Identifier extendedModdedIdentifier(String name, String suffix) {
        return extendIdentifier(new Identifier(Origins.MOD_ID, name), suffix);
    }

    public static Identifier extendedVanillaIdentifier(String name, String suffix) {
        return new Identifier(name + suffix);
    }

    public static Identifier extendIdentifier(Identifier identifier, String suffix) {
        return new Identifier(Origins.MOD_ID, identifier.getPath() + suffix);
    }

}
