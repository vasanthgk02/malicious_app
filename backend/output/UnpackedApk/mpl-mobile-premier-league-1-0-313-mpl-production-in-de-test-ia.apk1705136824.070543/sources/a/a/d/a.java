package a.a.d;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public char f2459a;

    /* renamed from: b  reason: collision with root package name */
    public char f2460b;

    /* renamed from: c  reason: collision with root package name */
    public float f2461c;

    /* renamed from: d  reason: collision with root package name */
    public float f2462d;

    /* renamed from: f  reason: collision with root package name */
    public int f2463f;
    public boolean g;
    public boolean h;
    public boolean i;
    public String j;

    public void a(char c2) {
        this.f2459a = c2;
    }

    public void a(String str) {
        this.j = str;
    }

    public void b(char c2) {
        this.f2460b = c2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CardEntity{rank=");
        outline73.append(this.f2459a);
        outline73.append(", suit=");
        outline73.append(this.f2460b);
        outline73.append(", positionX=");
        outline73.append(this.f2461c);
        outline73.append(", positionY=");
        outline73.append(this.f2462d);
        outline73.append(", isFourColor=");
        outline73.append(false);
        outline73.append(", stackIndex=");
        outline73.append(this.f2463f);
        outline73.append(", isValid=");
        outline73.append(this.g);
        outline73.append(", isSelected=");
        outline73.append(this.h);
        outline73.append(", userID='");
        GeneratedOutlineSupport.outline99(outline73, this.j, ExtendedMessageFormat.QUOTE, ", isDragged='");
        outline73.append(this.i);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append('}');
        return outline73.toString();
    }
}
