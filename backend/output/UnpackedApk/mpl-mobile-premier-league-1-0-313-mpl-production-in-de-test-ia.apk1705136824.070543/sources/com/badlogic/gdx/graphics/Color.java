package com.badlogic.gdx.graphics;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import sfs2x.client.entities.invitation.InvitationReply;

public class Color {
    public static final Color BLACK = new Color(0.0f, 0.0f, 0.0f, 1.0f);
    public static final Color BLUE = new Color(0.0f, 0.0f, 1.0f, 1.0f);
    public static final Color BROWN = new Color(-1958407169);
    public static final Color CHARTREUSE = new Color(2147418367);
    public static final Color CLEAR = new Color(0.0f, 0.0f, 0.0f, 0.0f);
    public static final Color CORAL = new Color(-8433409);
    public static final Color CYAN = new Color(0.0f, 1.0f, 1.0f, 1.0f);
    public static final Color DARK_GRAY = new Color(1061109759);
    public static final Color FIREBRICK = new Color(-1306385665);
    public static final Color FOREST = new Color(579543807);
    public static final Color GOLD = new Color(-2686721);
    public static final Color GOLDENROD = new Color(-626712321);
    public static final Color GRAY = new Color(2139062271);
    public static final Color GREEN = new Color(16711935);
    public static final Color LIGHT_GRAY = new Color(-1077952513);
    public static final Color LIME = new Color(852308735);
    public static final Color MAGENTA = new Color(1.0f, 0.0f, 1.0f, 1.0f);
    public static final Color MAROON = new Color(-1339006721);
    public static final Color NAVY = new Color(0.0f, 0.0f, 0.5f, 1.0f);
    public static final Color OLIVE = new Color(1804477439);
    public static final Color ORANGE = new Color(-5963521);
    public static final Color PINK = new Color(-9849601);
    public static final Color PURPLE = new Color(-1608453889);
    public static final Color RED = new Color(-16776961);
    public static final Color ROYAL = new Color(1097458175);
    public static final Color SALMON = new Color(-92245249);
    public static final Color SCARLET = new Color(-13361921);
    public static final Color SKY = new Color(-2016482305);
    public static final Color SLATE = new Color(1887473919);
    public static final Color TAN = new Color(-759919361);
    public static final Color TEAL = new Color(0.0f, 0.5f, 0.5f, 1.0f);
    public static final Color VIOLET = new Color(-293409025);
    public static final Color WHITE = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    public static final float WHITE_FLOAT_BITS = WHITE.toFloatBits();
    public static final Color YELLOW = new Color(-65281);

    /* renamed from: a  reason: collision with root package name */
    public float f3306a;

    /* renamed from: b  reason: collision with root package name */
    public float f3307b;
    public float g;
    public float r;

    public Color() {
    }

    public static void abgr8888ToColor(Color color, float f2) {
        int floatToIntColor = k.floatToIntColor(f2);
        color.f3306a = ((float) ((-16777216 & floatToIntColor) >>> 24)) / 255.0f;
        color.f3307b = ((float) ((16711680 & floatToIntColor) >>> 16)) / 255.0f;
        color.g = ((float) ((65280 & floatToIntColor) >>> 8)) / 255.0f;
        color.r = ((float) (floatToIntColor & InvitationReply.EXPIRED)) / 255.0f;
    }

    public static int alpha(float f2) {
        return (int) (f2 * 255.0f);
    }

    public static int argb8888(float f2, float f3, float f4, float f5) {
        return (((int) (f2 * 255.0f)) << 24) | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 8) | ((int) (f5 * 255.0f));
    }

    public static int argb8888(Color color) {
        return ((int) (color.f3307b * 255.0f)) | (((int) (color.f3306a * 255.0f)) << 24) | (((int) (color.r * 255.0f)) << 16) | (((int) (color.g * 255.0f)) << 8);
    }

    public static void argb8888ToColor(Color color, int i) {
        color.f3306a = ((float) ((-16777216 & i) >>> 24)) / 255.0f;
        color.r = ((float) ((16711680 & i) >>> 16)) / 255.0f;
        color.g = ((float) ((65280 & i) >>> 8)) / 255.0f;
        color.f3307b = ((float) (i & InvitationReply.EXPIRED)) / 255.0f;
    }

    public static int luminanceAlpha(float f2, float f3) {
        return (((int) (f2 * 255.0f)) << 8) | ((int) (f3 * 255.0f));
    }

    public static int rgb565(float f2, float f3, float f4) {
        return (((int) (f2 * 31.0f)) << 11) | (((int) (f3 * 63.0f)) << 5) | ((int) (f4 * 31.0f));
    }

    public static int rgb565(Color color) {
        return ((int) (color.f3307b * 31.0f)) | (((int) (color.r * 31.0f)) << 11) | (((int) (color.g * 63.0f)) << 5);
    }

    public static void rgb565ToColor(Color color, int i) {
        color.r = ((float) ((63488 & i) >>> 11)) / 31.0f;
        color.g = ((float) ((i & 2016) >>> 5)) / 63.0f;
        color.f3307b = ((float) ((i & 31) >>> 0)) / 31.0f;
    }

    public static int rgb888(float f2, float f3, float f4) {
        return (((int) (f2 * 255.0f)) << 16) | (((int) (f3 * 255.0f)) << 8) | ((int) (f4 * 255.0f));
    }

    public static int rgb888(Color color) {
        return ((int) (color.f3307b * 255.0f)) | (((int) (color.r * 255.0f)) << 16) | (((int) (color.g * 255.0f)) << 8);
    }

    public static void rgb888ToColor(Color color, int i) {
        color.r = ((float) ((16711680 & i) >>> 16)) / 255.0f;
        color.g = ((float) ((65280 & i) >>> 8)) / 255.0f;
        color.f3307b = ((float) (i & InvitationReply.EXPIRED)) / 255.0f;
    }

    public static int rgba4444(float f2, float f3, float f4, float f5) {
        return (((int) (f2 * 15.0f)) << 12) | (((int) (f3 * 15.0f)) << 8) | (((int) (f4 * 15.0f)) << 4) | ((int) (f5 * 15.0f));
    }

    public static int rgba4444(Color color) {
        return ((int) (color.f3306a * 15.0f)) | (((int) (color.r * 15.0f)) << 12) | (((int) (color.g * 15.0f)) << 8) | (((int) (color.f3307b * 15.0f)) << 4);
    }

    public static void rgba4444ToColor(Color color, int i) {
        color.r = ((float) ((61440 & i) >>> 12)) / 15.0f;
        color.g = ((float) ((i & 3840) >>> 8)) / 15.0f;
        color.f3307b = ((float) ((i & 240) >>> 4)) / 15.0f;
        color.f3306a = ((float) (i & 15)) / 15.0f;
    }

    public static int rgba8888(float f2, float f3, float f4, float f5) {
        return (((int) (f2 * 255.0f)) << 24) | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 8) | ((int) (f5 * 255.0f));
    }

    public static int rgba8888(Color color) {
        return ((int) (color.f3306a * 255.0f)) | (((int) (color.r * 255.0f)) << 24) | (((int) (color.g * 255.0f)) << 16) | (((int) (color.f3307b * 255.0f)) << 8);
    }

    public static void rgba8888ToColor(Color color, int i) {
        color.r = ((float) ((-16777216 & i) >>> 24)) / 255.0f;
        color.g = ((float) ((16711680 & i) >>> 16)) / 255.0f;
        color.f3307b = ((float) ((65280 & i) >>> 8)) / 255.0f;
        color.f3306a = ((float) (i & InvitationReply.EXPIRED)) / 255.0f;
    }

    public static int toIntBits(int i, int i2, int i3, int i4) {
        return i | (i2 << 8) | (i3 << 16) | (i4 << 24);
    }

    public static Color valueOf(String str) {
        return valueOf(str, new Color());
    }

    public Color add(Color color) {
        this.r += color.r;
        this.g += color.g;
        this.f3307b += color.f3307b;
        this.f3306a += color.f3306a;
        return clamp();
    }

    public Color clamp() {
        float f2 = this.r;
        if (f2 < 0.0f) {
            this.r = 0.0f;
        } else if (f2 > 1.0f) {
            this.r = 1.0f;
        }
        float f3 = this.g;
        if (f3 < 0.0f) {
            this.g = 0.0f;
        } else if (f3 > 1.0f) {
            this.g = 1.0f;
        }
        float f4 = this.f3307b;
        if (f4 < 0.0f) {
            this.f3307b = 0.0f;
        } else if (f4 > 1.0f) {
            this.f3307b = 1.0f;
        }
        float f5 = this.f3306a;
        if (f5 < 0.0f) {
            this.f3306a = 0.0f;
        } else if (f5 > 1.0f) {
            this.f3306a = 1.0f;
        }
        return this;
    }

    public Color cpy() {
        return new Color(this);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || Color.class != obj.getClass()) {
            return false;
        }
        if (toIntBits() != ((Color) obj).toIntBits()) {
            z = false;
        }
        return z;
    }

    public Color fromHsv(float f2, float f3, float f4) {
        float f5 = ((f2 / 60.0f) + 6.0f) % 6.0f;
        int i = (int) f5;
        float f6 = f5 - ((float) i);
        float f7 = (1.0f - f3) * f4;
        float f8 = (1.0f - (f3 * f6)) * f4;
        float f9 = (1.0f - ((1.0f - f6) * f3)) * f4;
        if (i == 0) {
            this.r = f4;
            this.g = f9;
            this.f3307b = f7;
        } else if (i == 1) {
            this.r = f8;
            this.g = f4;
            this.f3307b = f7;
        } else if (i == 2) {
            this.r = f7;
            this.g = f4;
            this.f3307b = f9;
        } else if (i == 3) {
            this.r = f7;
            this.g = f8;
            this.f3307b = f4;
        } else if (i != 4) {
            this.r = f4;
            this.g = f7;
            this.f3307b = f8;
        } else {
            this.r = f9;
            this.g = f7;
            this.f3307b = f4;
        }
        return clamp();
    }

    public int hashCode() {
        float f2 = this.r;
        int i = 0;
        int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
        float f3 = this.g;
        int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.f3307b;
        int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
        float f5 = this.f3306a;
        if (f5 != 0.0f) {
            i = Float.floatToIntBits(f5);
        }
        return floatToIntBits3 + i;
    }

    public Color lerp(Color color, float f2) {
        float f3 = this.r;
        this.r = GeneratedOutlineSupport.outline3(color.r, f3, f2, f3);
        float f4 = this.g;
        this.g = GeneratedOutlineSupport.outline3(color.g, f4, f2, f4);
        float f5 = this.f3307b;
        this.f3307b = GeneratedOutlineSupport.outline3(color.f3307b, f5, f2, f5);
        float f6 = this.f3306a;
        this.f3306a = GeneratedOutlineSupport.outline3(color.f3306a, f6, f2, f6);
        return clamp();
    }

    public Color mul(Color color) {
        this.r *= color.r;
        this.g *= color.g;
        this.f3307b *= color.f3307b;
        this.f3306a *= color.f3306a;
        return clamp();
    }

    public Color premultiplyAlpha() {
        float f2 = this.r;
        float f3 = this.f3306a;
        this.r = f2 * f3;
        this.g *= f3;
        this.f3307b *= f3;
        return this;
    }

    public Color set(Color color) {
        this.r = color.r;
        this.g = color.g;
        this.f3307b = color.f3307b;
        this.f3306a = color.f3306a;
        return this;
    }

    public Color sub(Color color) {
        this.r -= color.r;
        this.g -= color.g;
        this.f3307b -= color.f3307b;
        this.f3306a -= color.f3306a;
        return clamp();
    }

    public float toFloatBits() {
        return k.intToFloatColor((((int) (this.f3306a * 255.0f)) << 24) | (((int) (this.f3307b * 255.0f)) << 16) | (((int) (this.g * 255.0f)) << 8) | ((int) (this.r * 255.0f)));
    }

    public float[] toHsv(float[] fArr) {
        float max = Math.max(Math.max(this.r, this.g), this.f3307b);
        float min = Math.min(Math.min(this.r, this.g), this.f3307b);
        float f2 = max - min;
        if (f2 == 0.0f) {
            fArr[0] = 0.0f;
        } else {
            float f3 = this.r;
            if (max == f3) {
                fArr[0] = ((((this.g - this.f3307b) * 60.0f) / f2) + 360.0f) % 360.0f;
            } else {
                float f4 = this.g;
                if (max == f4) {
                    fArr[0] = (((this.f3307b - f3) * 60.0f) / f2) + 120.0f;
                } else {
                    fArr[0] = (((f3 - f4) * 60.0f) / f2) + 240.0f;
                }
            }
        }
        if (max > 0.0f) {
            fArr[1] = 1.0f - (min / max);
        } else {
            fArr[1] = 0.0f;
        }
        fArr[2] = max;
        return fArr;
    }

    public int toIntBits() {
        return (((int) (this.f3306a * 255.0f)) << 24) | (((int) (this.f3307b * 255.0f)) << 16) | (((int) (this.g * 255.0f)) << 8) | ((int) (this.r * 255.0f));
    }

    public String toString() {
        String hexString = Integer.toHexString((((int) (this.r * 255.0f)) << 24) | (((int) (this.g * 255.0f)) << 16) | (((int) (this.f3307b * 255.0f)) << 8) | ((int) (this.f3306a * 255.0f)));
        while (hexString.length() < 8) {
            hexString = GeneratedOutlineSupport.outline50("0", hexString);
        }
        return hexString;
    }

    public Color(int i) {
        rgba8888ToColor(this, i);
    }

    public static Color valueOf(String str, Color color) {
        if (str.charAt(0) == '#') {
            str = str.substring(1);
        }
        color.r = ((float) Integer.parseInt(str.substring(0, 2), 16)) / 255.0f;
        color.g = ((float) Integer.parseInt(str.substring(2, 4), 16)) / 255.0f;
        color.f3307b = ((float) Integer.parseInt(str.substring(4, 6), 16)) / 255.0f;
        color.f3306a = str.length() != 8 ? 1.0f : ((float) Integer.parseInt(str.substring(6, 8), 16)) / 255.0f;
        return color;
    }

    public static float toFloatBits(int i, int i2, int i3, int i4) {
        return k.intToFloatColor(i | (i2 << 8) | (i3 << 16) | (i4 << 24));
    }

    public Color(float f2, float f3, float f4, float f5) {
        this.r = f2;
        this.g = f3;
        this.f3307b = f4;
        this.f3306a = f5;
        clamp();
    }

    public static float toFloatBits(float f2, float f3, float f4, float f5) {
        return k.intToFloatColor(((int) (f2 * 255.0f)) | (((int) (f3 * 255.0f)) << 8) | (((int) (f4 * 255.0f)) << 16) | (((int) (f5 * 255.0f)) << 24));
    }

    public Color set(float f2, float f3, float f4, float f5) {
        this.r = f2;
        this.g = f3;
        this.f3307b = f4;
        this.f3306a = f5;
        return clamp();
    }

    public Color add(float f2, float f3, float f4, float f5) {
        this.r += f2;
        this.g += f3;
        this.f3307b += f4;
        this.f3306a += f5;
        return clamp();
    }

    public Color lerp(float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.r;
        this.r = GeneratedOutlineSupport.outline3(f2, f7, f6, f7);
        float f8 = this.g;
        this.g = GeneratedOutlineSupport.outline3(f3, f8, f6, f8);
        float f9 = this.f3307b;
        this.f3307b = GeneratedOutlineSupport.outline3(f4, f9, f6, f9);
        float f10 = this.f3306a;
        this.f3306a = GeneratedOutlineSupport.outline3(f5, f10, f6, f10);
        return clamp();
    }

    public Color mul(float f2) {
        this.r *= f2;
        this.g *= f2;
        this.f3307b *= f2;
        this.f3306a *= f2;
        return clamp();
    }

    public Color sub(float f2, float f3, float f4, float f5) {
        this.r -= f2;
        this.g -= f3;
        this.f3307b -= f4;
        this.f3306a -= f5;
        return clamp();
    }

    public Color(Color color) {
        set(color);
    }

    public Color set(int i) {
        rgba8888ToColor(this, i);
        return this;
    }

    public Color mul(float f2, float f3, float f4, float f5) {
        this.r *= f2;
        this.g *= f3;
        this.f3307b *= f4;
        this.f3306a *= f5;
        return clamp();
    }

    public Color fromHsv(float[] fArr) {
        return fromHsv(fArr[0], fArr[1], fArr[2]);
    }
}
