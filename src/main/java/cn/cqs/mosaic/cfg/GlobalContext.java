package cn.cqs.mosaic.cfg;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

@Getter
@Slf4j
@Component("CTX")
public class GlobalContext implements ApplicationContextAware {
    public GlobalContext() {
        this.groups = new ArrayList<>(1 << 3);
        this.groups.add(Constants.GROUP_DEFAULT_NAME);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // Define the final directory for file storage
        String storeDir = applicationContext.getEnvironment().getProperty(Constants.ARGS_STORE_NAME);
        this.store = storeDir != null ? Path.of(storeDir).normalize().toAbsolutePath()
                : Path.of(System.getProperty("user.dir"), Constants.ARGS_STORE_NAME).toAbsolutePath();
        log.info("Final file store directory -> [{}]", this.store);
        try {
            File storeDirF = this.store.toFile();
            // make sure the store directory file ok.
            FileUtils.forceMkdir(storeDirF);
            // make sure the default group exist.
            FileUtils.forceMkdir(this.store.resolve(Constants.GROUP_DEFAULT_NAME).toFile());
            // make sure the cache dir work.
            FileUtils.forceMkdir(this.store.resolve(Constants.CACHE_DIR_NAME).toFile());
            this.updateGroups();
        } catch (IOException e) {
            log.error("Cannot read or create the specified store directory files.");
            throw new RuntimeException(e);
        }
    }

    private Path store;

    private final ArrayList<String> groups;

    public void addGroup(String name) {
        groups.add(name);
    }

    /**
     * refresh this groups' values by reread all local group directories file names.
     */
    public void updateGroups() throws IOException {
        this.groups.clear();
        this.groups.add(Constants.GROUP_DEFAULT_NAME);
        Files.walk(this.store, 1)
                .filter(Files::isDirectory)
                .map(p -> p.getFileName().toString())
                .filter(dn -> !dn.startsWith("."))
                .forEach(this.groups::add);
    }
}
