package com.userexperior.utilities;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4261a = true;

    /* renamed from: b  reason: collision with root package name */
    public static String f4262b = "UserExperiorLogs";

    /* renamed from: c  reason: collision with root package name */
    public static Logger f4263c = Logger.getLogger("UserExperiorLogs");

    public static void a(Level level, String str) {
        f4263c.log(level, str);
    }
}
