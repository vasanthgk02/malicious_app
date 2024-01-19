package com.userexperior.d.b;

import com.userexperior.a.a.f;
import com.userexperior.c.a.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3914a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public e f3915b;

    /* renamed from: c  reason: collision with root package name */
    public String f3916c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3917d;

    /* renamed from: e  reason: collision with root package name */
    public f f3918e = new f();

    public b(e eVar, String str) {
        this.f3915b = eVar;
        this.f3916c = str;
    }

    public void run() {
        FileOutputStream fileOutputStream;
        if (this.f3915b != null) {
            String str = this.f3916c;
            if (str != null) {
                File file = new File(this.f3916c.substring(0, str.lastIndexOf(File.separator)));
                if (!file.exists()) {
                    new StringBuilder("directory created ").append(file.mkdirs());
                }
                try {
                    File file2 = new File(this.f3916c);
                    String concat = this.f3918e.a((Object) this.f3915b).concat(",");
                    if (file2.exists()) {
                        fileOutputStream = new FileOutputStream(file2, true);
                        this.f3917d = false;
                    } else {
                        new StringBuilder("file is created ").append(file2.createNewFile());
                        fileOutputStream = new FileOutputStream(file2);
                        this.f3917d = true;
                    }
                    if (this.f3917d) {
                        fileOutputStream.write("[".getBytes());
                    }
                    fileOutputStream.write(concat.getBytes());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    Level level = Level.SEVERE;
                    com.userexperior.utilities.b.a(level, "error while writing event to file: " + e2.getMessage());
                    StringBuilder sb = new StringBuilder("Cause: ");
                    sb.append(e2.getCause());
                    sb.append("Message: ");
                    sb.append(e2.getMessage());
                } catch (Exception e3) {
                    Level level2 = Level.SEVERE;
                    com.userexperior.utilities.b.a(level2, "Ex : ARTER - addEvent : " + e3.getMessage());
                    e3.getMessage();
                }
            }
        }
    }
}
