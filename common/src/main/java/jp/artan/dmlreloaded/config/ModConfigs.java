package jp.artan.dmlreloaded.config;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.electronwill.nightconfig.toml.TomlWriter;
import dev.architectury.platform.Platform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ModConfigs {

    private final Path configPath;

    protected ModConfigs(String filePath) {
        this.configPath = Paths.get(Platform.getConfigFolder().toString(), filePath);
    }

    public void read() {

        // 指定されたファイルのディレクトリが存在しない場合は作成する
        this.createDirectory();

        // ファイルが存在する場合は読み込む
        CommentedFileConfig config = CommentedFileConfig.builder(this.configPath).autosave().build();
        boolean exists = Files.exists(this.configPath);
        if(Files.exists(this.configPath)) {
            try {
                config.load();
            } catch(Exception e) {
                e.printStackTrace();
                config = CommentedFileConfig.builder(this.configPath).autosave().build();
                exists = false;
            }
        }
        this.read(config);
        if(!exists) {
            TomlWriter writer = new TomlWriter();
            writer.write(config, this.configPath.toFile(), WritingMode.REPLACE);
        }
    }

    private void createDirectory() {
        try {
            Files.createDirectories(this.configPath.getParent());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void read(CommentedFileConfig config);

    public static class ConfigEntry<T> {

        private final String path;
        private final T defaultValue;
        private final CommentedConfig config;

        public ConfigEntry(String path, T defaultValue, CommentedConfig config) {
            this.path = path;
            this.defaultValue = defaultValue;
            this.config = config;
            if(this.config.get(path) == null) this.config.set(path, defaultValue);
        }

        public ConfigEntry<T> comment(String comment) {
            this.config.setComment(this.path, comment);
            return this;
        }

        public T get() {
            return this.config.getOrElse(this.path, this.defaultValue);
        }
    }

    public static ConfigEntry<Boolean> defineEntry(String path, CommentedConfig config, Boolean defaultValue) {
        return new ConfigEntry<>(path, defaultValue, config);
    }

    public static ConfigEntry<Integer> defineEntry(String path, CommentedConfig config, Integer defaultValue) {
        return defineEntry(path, config, defaultValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static ConfigEntry<Integer> defineEntry(String path, CommentedConfig config, Integer defaultValue, int min, int max) {
        return new ConfigEntry<>(path, defaultValue, config) {

            @Override
            public Integer get() {
                Integer integer = super.get();
                if(integer < min) return min;
                if(integer > max) return max;
                return integer;
            }
        };
    }
}
