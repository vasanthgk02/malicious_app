package com.userexperior.utilities;

import android.app.Application;
import android.content.Context;
import com.userexperior.c.c.e;
import com.userexperior.c.c.f;
import com.userexperior.e.h;
import com.userexperior.models.recording.enums.d;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4260a = "a";

    public static Context a() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static f a(Context context) {
        List synchronizedList = Collections.synchronizedList(new ArrayList());
        File file = new File(j.f(context));
        if (!file.exists() || !file.isDirectory() || file.listFiles() == null || file.listFiles().length == 0) {
            return null;
        }
        for (File file2 : file.listFiles()) {
            if (file2 == null) {
                b.a(Level.INFO, "Z file does not exist or is null");
            } else if (!file2.exists() || !file2.isFile() || !file2.getName().endsWith(".zip")) {
                StringBuilder sb = new StringBuilder();
                sb.append(file);
                sb.append(File.separator);
                sb.append(file2.getName());
                sb.append(" skipped");
            } else if (h.a(new Date(file2.lastModified()).getTime(), System.currentTimeMillis(), TimeUnit.MINUTES) > 2880) {
                boolean delete = file2.delete();
                b.a(Level.INFO, "Deleting the s (z)- older than xx hours......");
                b.a(Level.INFO, "delete = ".concat(String.valueOf(delete)));
            } else {
                synchronizedList.add(new e(file2.getPath(), d.USER_SCREEN_SHOTS));
                h.c(file2);
            }
        }
        return new f(synchronizedList);
    }
}
