package com.userexperior.d.b;

import com.userexperior.a.a.f;
import com.userexperior.utilities.b;
import com.userexperior.utilities.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3909a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public com.userexperior.c.a.a f3910b;

    /* renamed from: c  reason: collision with root package name */
    public String f3911c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3912d;

    /* renamed from: e  reason: collision with root package name */
    public f f3913e = new f();

    public a(com.userexperior.c.a.a aVar, String str) {
        this.f3910b = aVar;
        this.f3911c = str;
    }

    public void run() {
        FileOutputStream fileOutputStream;
        try {
            if (!(this.f3910b == null || this.f3911c == null)) {
                new StringBuilder("adding: ").append(this.f3910b.f3796b);
                File file = new File(this.f3911c.substring(0, this.f3911c.lastIndexOf(File.separator)));
                if (!file.exists()) {
                    new StringBuilder("directory created ").append(file.mkdirs());
                }
                if (this.f3911c == null) {
                    this.f3911c = j.i(com.userexperior.utilities.a.a()) + File.separator + "events.json";
                }
                try {
                    File file2 = new File(this.f3911c);
                    if (file2.exists()) {
                        fileOutputStream = new FileOutputStream(file2, true);
                        this.f3912d = false;
                    } else {
                        new StringBuilder("file is created ").append(file2.createNewFile());
                        fileOutputStream = new FileOutputStream(file2);
                        this.f3912d = true;
                    }
                    String str = this.f3913e.a((Object) this.f3910b) + ",";
                    if (this.f3912d) {
                        fileOutputStream.write("[".getBytes());
                    }
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    b.a(Level.SEVERE, "error while writing event to file: " + e2.getMessage());
                    StringBuilder sb = new StringBuilder("Cause: ");
                    sb.append(e2.getCause());
                    sb.append("Message: ");
                    sb.append(e2.getMessage());
                } catch (Exception e3) {
                    b.a(Level.SEVERE, "Ex : AER - addEvent : " + e3.getMessage());
                    e3.getMessage();
                }
            }
        } catch (Exception e4) {
            new StringBuilder("Exception : AddEventRunnable - ").append(e4.getMessage());
        }
    }
}
