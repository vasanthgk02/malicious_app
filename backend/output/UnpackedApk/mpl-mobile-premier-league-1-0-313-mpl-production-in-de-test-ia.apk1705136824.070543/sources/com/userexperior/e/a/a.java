package com.userexperior.e.a;

import java.io.IOException;
import java.io.InputStream;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f3924a = "UTF-8";

    /* renamed from: b  reason: collision with root package name */
    public InputStream f3925b;

    /* renamed from: c  reason: collision with root package name */
    public int f3926c;

    /* renamed from: d  reason: collision with root package name */
    public String f3927d;

    /* renamed from: e  reason: collision with root package name */
    public String f3928e;

    public final void a() {
        InputStream inputStream = this.f3925b;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
