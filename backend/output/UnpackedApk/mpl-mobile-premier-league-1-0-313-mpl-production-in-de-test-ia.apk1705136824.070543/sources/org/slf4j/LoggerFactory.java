package org.slf4j;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOPLogger;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.helpers.Util.ClassContextSecurityManager;
import org.slf4j.impl.StaticLoggerBinder;

public final class LoggerFactory {
    public static final String[] API_COMPATIBILITY_LIST = {"1.6", "1.7"};
    public static boolean DETECT_LOGGER_NAME_MISMATCH;
    public static volatile int INITIALIZATION_STATE;
    public static final NOPLoggerFactory NOP_FALLBACK_FACTORY = new NOPLoggerFactory();
    public static String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";
    public static final SubstituteLoggerFactory SUBST_FACTORY = new SubstituteLoggerFactory();

    static {
        boolean z;
        String str = null;
        try {
            str = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
        }
        if (str == null) {
            z = false;
        } else {
            z = str.equalsIgnoreCase(BaseParser.TRUE);
        }
        DETECT_LOGGER_NAME_MISMATCH = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        if (r3.contains("org.slf4j.impl.StaticLoggerBinder") != false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void bind() {
        /*
            java.lang.String r0 = "Failed to instantiate SLF4J LoggerFactory"
            r1 = 2
            boolean r2 = isAndroid()     // Catch:{ NoClassDefFoundError -> 0x004e, NoSuchMethodError -> 0x002c, Exception -> 0x001e }
            if (r2 != 0) goto L_0x0011
            java.util.Set r2 = findPossibleStaticLoggerBinderPathSet()     // Catch:{ NoClassDefFoundError -> 0x004e, NoSuchMethodError -> 0x002c, Exception -> 0x001e }
            reportMultipleBindingAmbiguity(r2)     // Catch:{ NoClassDefFoundError -> 0x004e, NoSuchMethodError -> 0x002c, Exception -> 0x001e }
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            org.slf4j.impl.StaticLoggerBinder.getSingleton()     // Catch:{ NoClassDefFoundError -> 0x004e, NoSuchMethodError -> 0x002c, Exception -> 0x001e }
            r3 = 3
            INITIALIZATION_STATE = r3     // Catch:{ NoClassDefFoundError -> 0x004e, NoSuchMethodError -> 0x002c, Exception -> 0x001e }
            reportActualBinding(r2)     // Catch:{ NoClassDefFoundError -> 0x004e, NoSuchMethodError -> 0x002c, Exception -> 0x001e }
            goto L_0x007d
        L_0x001c:
            r0 = move-exception
            goto L_0x0087
        L_0x001e:
            r2 = move-exception
            INITIALIZATION_STATE = r1     // Catch:{ all -> 0x001c }
            org.slf4j.helpers.Util.report(r0, r2)     // Catch:{ all -> 0x001c }
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Unexpected initialization failure"
            r0.<init>(r1, r2)     // Catch:{ all -> 0x001c }
            throw r0     // Catch:{ all -> 0x001c }
        L_0x002c:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x004d
            java.lang.String r3 = "org.slf4j.impl.StaticLoggerBinder.getSingleton()"
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x004d
            INITIALIZATION_STATE = r1     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "slf4j-api 1.6.x (or later) is incompatible with this binding."
            org.slf4j.helpers.Util.report(r1)     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Your binding is version 1.5.5 or earlier."
            org.slf4j.helpers.Util.report(r1)     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Upgrade your binding to version 1.6.x."
            org.slf4j.helpers.Util.report(r1)     // Catch:{ all -> 0x001c }
        L_0x004d:
            throw r0     // Catch:{ all -> 0x001c }
        L_0x004e:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()     // Catch:{ all -> 0x001c }
            r4 = 0
            if (r3 != 0) goto L_0x0057
            goto L_0x0069
        L_0x0057:
            java.lang.String r5 = "org/slf4j/impl/StaticLoggerBinder"
            boolean r5 = r3.contains(r5)     // Catch:{ all -> 0x001c }
            if (r5 == 0) goto L_0x0060
            goto L_0x0068
        L_0x0060:
            java.lang.String r5 = "org.slf4j.impl.StaticLoggerBinder"
            boolean r3 = r3.contains(r5)     // Catch:{ all -> 0x001c }
            if (r3 == 0) goto L_0x0069
        L_0x0068:
            r4 = 1
        L_0x0069:
            if (r4 == 0) goto L_0x0081
            r0 = 4
            INITIALIZATION_STATE = r0     // Catch:{ all -> 0x001c }
            java.lang.String r0 = "Failed to load class \"org.slf4j.impl.StaticLoggerBinder\"."
            org.slf4j.helpers.Util.report(r0)     // Catch:{ all -> 0x001c }
            java.lang.String r0 = "Defaulting to no-operation (NOP) logger implementation"
            org.slf4j.helpers.Util.report(r0)     // Catch:{ all -> 0x001c }
            java.lang.String r0 = "See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details."
            org.slf4j.helpers.Util.report(r0)     // Catch:{ all -> 0x001c }
        L_0x007d:
            postBindCleanUp()
            return
        L_0x0081:
            INITIALIZATION_STATE = r1     // Catch:{ all -> 0x001c }
            org.slf4j.helpers.Util.report(r0, r2)     // Catch:{ all -> 0x001c }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0087:
            postBindCleanUp()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.slf4j.LoggerFactory.bind():void");
    }

    public static Set<URL> findPossibleStaticLoggerBinderPathSet() {
        Enumeration<URL> enumeration;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = LoggerFactory.class.getClassLoader();
            if (classLoader == null) {
                enumeration = ClassLoader.getSystemResources(STATIC_LOGGER_BINDER_PATH);
            } else {
                enumeration = classLoader.getResources(STATIC_LOGGER_BINDER_PATH);
            }
            while (enumeration.hasMoreElements()) {
                linkedHashSet.add(enumeration.nextElement());
            }
        } catch (IOException e2) {
            Util.report("Error getting resources from path", e2);
        }
        return linkedHashSet;
    }

    public static ILoggerFactory getILoggerFactory() {
        if (INITIALIZATION_STATE == 0) {
            synchronized (LoggerFactory.class) {
                if (INITIALIZATION_STATE == 0) {
                    INITIALIZATION_STATE = 1;
                    bind();
                    if (INITIALIZATION_STATE == 3) {
                        versionSanityCheck();
                    }
                }
            }
        }
        int i = INITIALIZATION_STATE;
        if (i == 1) {
            return SUBST_FACTORY;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        } else if (i == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        } else {
            if (i == 4) {
                return NOP_FALLBACK_FACTORY;
            }
            throw new IllegalStateException("Unreachable code");
        }
    }

    public static Logger getLogger(String str) {
        return getILoggerFactory().getLogger(str);
    }

    public static boolean isAndroid() {
        String str;
        try {
            str = System.getProperty("java.vendor.url");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            return false;
        }
        return str.toLowerCase().contains("android");
    }

    public static void postBindCleanUp() {
        synchronized (SUBST_FACTORY) {
            SUBST_FACTORY.postInitialization = true;
            SubstituteLoggerFactory substituteLoggerFactory = SUBST_FACTORY;
            if (substituteLoggerFactory != null) {
                Iterator it = new ArrayList(substituteLoggerFactory.loggers.values()).iterator();
                while (it.hasNext()) {
                    SubstituteLogger substituteLogger = (SubstituteLogger) it.next();
                    substituteLogger._delegate = getLogger(substituteLogger.name);
                }
            } else {
                throw null;
            }
        }
        LinkedBlockingQueue<SubstituteLoggingEvent> linkedBlockingQueue = SUBST_FACTORY.eventQueue;
        int size = linkedBlockingQueue.size();
        ArrayList arrayList = new ArrayList(128);
        int i = 0;
        while (linkedBlockingQueue.drainTo(arrayList, 128) != 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SubstituteLoggingEvent substituteLoggingEvent = (SubstituteLoggingEvent) it2.next();
                if (substituteLoggingEvent != null) {
                    SubstituteLogger substituteLogger2 = substituteLoggingEvent.logger;
                    String str = substituteLogger2.name;
                    if (substituteLogger2._delegate == null) {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    } else if (!(substituteLogger2._delegate instanceof NOPLogger)) {
                        if (!substituteLogger2.isDelegateEventAware()) {
                            Util.report(str);
                        } else if (substituteLogger2.isDelegateEventAware()) {
                            try {
                                substituteLogger2.logMethodCache.invoke(substituteLogger2._delegate, new Object[]{substituteLoggingEvent});
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i2 = i + 1;
                if (i == 0) {
                    if (substituteLoggingEvent.logger.isDelegateEventAware()) {
                        Util.report("A number (" + size + ") of logging calls during the initialization phase have been intercepted and are");
                        Util.report("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        Util.report("See also http://www.slf4j.org/codes.html#replay");
                    } else if (!(substituteLoggingEvent.logger._delegate instanceof NOPLogger)) {
                        Util.report("The following set of substitute loggers may have been accessed");
                        Util.report("during the initialization phase. Logging calls during this");
                        Util.report("phase were not honored. However, subsequent logging calls to these");
                        Util.report("loggers will work as normally expected.");
                        Util.report("See also http://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i = i2;
            }
            arrayList.clear();
        }
        SubstituteLoggerFactory substituteLoggerFactory2 = SUBST_FACTORY;
        substituteLoggerFactory2.loggers.clear();
        substituteLoggerFactory2.eventQueue.clear();
    }

    public static void reportActualBinding(Set<URL> set) {
        if (set != null) {
            boolean z = true;
            if (set.size() <= 1) {
                z = false;
            }
            if (z) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Actual binding is of type [");
                outline73.append(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr());
                outline73.append(CMapParser.MARK_END_OF_ARRAY);
                Util.report(outline73.toString());
            }
        }
    }

    public static void reportMultipleBindingAmbiguity(Set<URL> set) {
        boolean z = true;
        if (set.size() <= 1) {
            z = false;
        }
        if (z) {
            Util.report("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                Util.report("Found binding in [" + it.next() + CMapParser.MARK_END_OF_ARRAY);
            }
            Util.report("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static final void versionSanityCheck() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z = false;
            for (String startsWith : API_COMPATIBILITY_LIST) {
                if (str.startsWith(startsWith)) {
                    z = true;
                }
            }
            if (!z) {
                Util.report("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(API_COMPATIBILITY_LIST).toString());
                Util.report("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            Util.report("Unexpected problem occured during version sanity check", th);
        }
    }

    public static Logger getLogger(Class<?> cls) {
        Logger logger = getLogger(cls.getName());
        if (DETECT_LOGGER_NAME_MISMATCH) {
            ClassContextSecurityManager classContextSecurityManager = Util.SECURITY_MANAGER;
            Class cls2 = null;
            if (classContextSecurityManager == null) {
                if (Util.SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED) {
                    classContextSecurityManager = null;
                } else {
                    try {
                        classContextSecurityManager = new ClassContextSecurityManager(null);
                    } catch (SecurityException unused) {
                        classContextSecurityManager = null;
                    }
                    Util.SECURITY_MANAGER = classContextSecurityManager;
                    Util.SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = true;
                }
            }
            if (classContextSecurityManager != null) {
                Class[] classContext = classContextSecurityManager.getClassContext();
                String name = Util.class.getName();
                int i = 0;
                while (i < classContext.length && !name.equals(classContext[i].getName())) {
                    i++;
                }
                if (i < classContext.length) {
                    int i2 = i + 2;
                    if (i2 < classContext.length) {
                        cls2 = classContext[i2];
                    }
                }
                throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
            }
            if (cls2 != null && (!cls2.isAssignableFrom(cls))) {
                Util.report(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[]{logger.getName(), cls2.getName()}));
                Util.report("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return logger;
    }
}
