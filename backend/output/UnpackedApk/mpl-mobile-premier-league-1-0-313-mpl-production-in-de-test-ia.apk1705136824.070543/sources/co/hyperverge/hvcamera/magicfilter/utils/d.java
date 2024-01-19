package co.hyperverge.hvcamera.magicfilter.utils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f2925a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        f2925a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
