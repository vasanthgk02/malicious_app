package io.sentry.config;

import io.sentry.SystemOutLogger;
import java.util.ArrayList;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class PropertiesProviderFactory {
    public static PropertiesProvider create() {
        SystemOutLogger systemOutLogger = new SystemOutLogger();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SystemPropertyPropertiesProvider());
        arrayList.add(new EnvironmentVariablePropertiesProvider());
        String property = System.getProperty("sentry.properties.file");
        if (property != null) {
            Properties load = new FilesystemPropertiesLoader(property, systemOutLogger).load();
            if (load != null) {
                arrayList.add(new SimplePropertiesProvider(load));
            }
        }
        String str = System.getenv("SENTRY_PROPERTIES_FILE");
        if (str != null) {
            Properties load2 = new FilesystemPropertiesLoader(str, systemOutLogger).load();
            if (load2 != null) {
                arrayList.add(new SimplePropertiesProvider(load2));
            }
        }
        Properties load3 = new ClasspathPropertiesLoader(systemOutLogger).load();
        if (load3 != null) {
            arrayList.add(new SimplePropertiesProvider(load3));
        }
        Properties load4 = new FilesystemPropertiesLoader("sentry.properties", systemOutLogger).load();
        if (load4 != null) {
            arrayList.add(new SimplePropertiesProvider(load4));
        }
        return new CompositePropertiesProvider(arrayList);
    }
}
