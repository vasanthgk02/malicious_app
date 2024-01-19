package co.hyperverge.hypersnapsdk.f;

/* compiled from: GPSHelper */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static StringBuilder f3178a = new StringBuilder(20);

    public static final synchronized String a(double d2) {
        String sb;
        synchronized (c.class) {
            try {
                double abs = Math.abs(d2);
                int i = (int) abs;
                double d3 = (abs * 60.0d) - (((double) i) * 60.0d);
                int i2 = (int) d3;
                f3178a.setLength(0);
                f3178a.append(i);
                f3178a.append("/1,");
                f3178a.append(i2);
                f3178a.append("/1,");
                f3178a.append((int) (((d3 * 60.0d) - (((double) i2) * 60.0d)) * 1000.0d));
                f3178a.append("/1000");
                sb = f3178a.toString();
            }
        }
        return sb;
    }

    public static String b(double d2) {
        return d2 < 0.0d ? "S" : "N";
    }
}
