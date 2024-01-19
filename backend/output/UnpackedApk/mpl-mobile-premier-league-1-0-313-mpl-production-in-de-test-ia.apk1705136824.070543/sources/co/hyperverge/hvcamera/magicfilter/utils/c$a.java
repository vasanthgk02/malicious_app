package co.hyperverge.hvcamera.magicfilter.utils;

import android.util.Size;
import java.util.Comparator;

public class c$a implements Comparator<Size> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2924a;

    public c$a(int i) {
        this.f2924a = i;
    }

    public int compare(Object obj, Object obj2) {
        Size size = (Size) obj;
        Size size2 = (Size) obj2;
        return Math.abs((size.getHeight() * size.getWidth()) - this.f2924a) - Math.abs((size2.getHeight() * size2.getWidth()) - this.f2924a);
    }
}
