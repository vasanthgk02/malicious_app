package com.cfg.mendikot.api.d.a.a.a.b.q;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;

public class a implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static final a f2277c = new a(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public final int f2278a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2279b;

    public a(int i, int i2) {
        this.f2278a = i;
        this.f2279b = i2;
    }

    public Object clone() {
        return (a) super.clone();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[maxLineLength=");
        outline73.append(this.f2278a);
        outline73.append(", maxHeaderCount=");
        return GeneratedOutlineSupport.outline57(outline73, this.f2279b, CMapParser.MARK_END_OF_ARRAY);
    }
}
