package org.slf4j.helpers;

import java.io.PrintStream;

public final class Util {
    public static ClassContextSecurityManager SECURITY_MANAGER;
    public static boolean SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED;

    public static final class ClassContextSecurityManager extends SecurityManager {
        public ClassContextSecurityManager(AnonymousClass1 r1) {
        }

        public Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    public static final void report(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static final void report(String str) {
        PrintStream printStream = System.err;
        printStream.println("SLF4J: " + str);
    }
}
