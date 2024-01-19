package io.hansel.userjourney;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.userjourney.models.PromptGoalEventInfo;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class j {

    public class a implements FileFilter {
        public boolean accept(File file) {
            return file.getName().endsWith("_deleted_px");
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f5435a;

        public b(List list) {
            this.f5435a = list;
        }

        public void run() {
            try {
                for (File file : this.f5435a) {
                    if (file != null) {
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, "Something went wrong. While Hansel sdk is trying to delete the file.", LogGroup.PT);
            }
        }
    }

    public static ArrayList<File> a(Context context) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] listFiles = context.getDir("HSLData", 0).listFiles(new a());
        if (listFiles != null) {
            arrayList.addAll(Arrays.asList(listFiles));
        }
        return arrayList;
    }

    public static Set<String> a(Context context, String str) {
        return context.getSharedPreferences("promptEventHashJourneyIdMapSharedPref", 0).getStringSet(str, null);
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("promptEventHashJourneyIdMapSharedPref", 0);
        Editor edit = sharedPreferences.edit();
        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        edit.putStringSet(str, hashSet);
        edit.apply();
    }

    public static void a(Context context, String str, HashMap<String, HashMap<String, PromptGoalEventInfo>> hashMap) {
        c(context, str);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(context.getDir("HSLData", 0), str)));
            objectOutputStream.writeObject(hashMap);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static void a(List<File> list) {
        if (!list.isEmpty()) {
            new Thread(new b(list)).start();
        }
    }

    public static HashMap<String, Set<String>> b(Context context) {
        try {
            return (HashMap) context.getSharedPreferences("promptEventHashJourneyIdMapSharedPref", 0).getAll();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            return null;
        }
    }

    public static HashMap<String, HashMap<String, PromptGoalEventInfo>> b(Context context, String str) {
        try {
            Object readObject = new ObjectInputStream(new FileInputStream(new File(context.getDir("HSLData", 0), str))).readObject();
            if (readObject != null) {
                return (HashMap) readObject;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return null;
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("promptEventHashJourneyIdMapSharedPref", 0);
        Set<String> stringSet = sharedPreferences.getStringSet(str, null);
        if (stringSet != null) {
            Editor edit = sharedPreferences.edit();
            HashSet hashSet = new HashSet(stringSet);
            hashSet.remove(str2);
            edit.putStringSet(str, hashSet);
            edit.apply();
        }
    }

    public static void c(Context context, String str) {
        try {
            File file = new File(context.getDir("HSLData", 0), str);
            if (file.exists()) {
                File dir = context.getDir("HSLData", 0);
                file.renameTo(new File(dir, str + "_" + System.currentTimeMillis() + "_deleted_px"));
            }
            a((List<File>) a(context));
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }
}
