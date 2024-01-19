package com.badlogic.gdx.math;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class Rectangle implements Serializable {
    public static final long serialVersionUID = 5733252015138115702L;
    public static final Rectangle tmp = new Rectangle();
    public static final Rectangle tmp2 = new Rectangle();
    public float height;
    public float width;
    public float x;
    public float y;

    public Rectangle() {
    }

    public float area() {
        return this.width * this.height;
    }

    public boolean contains(float f2, float f3) {
        float f4 = this.x;
        if (f4 <= f2 && f4 + this.width >= f2) {
            float f5 = this.y;
            if (f5 <= f3 && f5 + this.height >= f3) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return Float.floatToRawIntBits(this.height) == Float.floatToRawIntBits(rectangle.height) && Float.floatToRawIntBits(this.width) == Float.floatToRawIntBits(rectangle.width) && Float.floatToRawIntBits(this.x) == Float.floatToRawIntBits(rectangle.x) && Float.floatToRawIntBits(this.y) == Float.floatToRawIntBits(rectangle.y);
    }

    public Rectangle fitInside(Rectangle rectangle) {
        float aspectRatio = getAspectRatio();
        if (aspectRatio < rectangle.getAspectRatio()) {
            float f2 = rectangle.height;
            setSize(aspectRatio * f2, f2);
        } else {
            float f3 = rectangle.width;
            setSize(f3, f3 / aspectRatio);
        }
        setPosition(((rectangle.width / 2.0f) + rectangle.x) - (this.width / 2.0f), ((rectangle.height / 2.0f) + rectangle.y) - (this.height / 2.0f));
        return this;
    }

    public Rectangle fitOutside(Rectangle rectangle) {
        float aspectRatio = getAspectRatio();
        if (aspectRatio > rectangle.getAspectRatio()) {
            float f2 = rectangle.height;
            setSize(aspectRatio * f2, f2);
        } else {
            float f3 = rectangle.width;
            setSize(f3, f3 / aspectRatio);
        }
        setPosition(((rectangle.width / 2.0f) + rectangle.x) - (this.width / 2.0f), ((rectangle.height / 2.0f) + rectangle.y) - (this.height / 2.0f));
        return this;
    }

    public Rectangle fromString(String str) {
        int indexOf = str.indexOf(44, 1);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(44, i);
        int i2 = indexOf2 + 1;
        int indexOf3 = str.indexOf(44, i2);
        if (!(indexOf == -1 || indexOf2 == -1 || indexOf3 == -1 || str.charAt(0) != '[' || str.charAt(str.length() - 1) != ']')) {
            try {
                return set(Float.parseFloat(str.substring(1, indexOf)), Float.parseFloat(str.substring(i, indexOf2)), Float.parseFloat(str.substring(i2, indexOf3)), Float.parseFloat(str.substring(indexOf3 + 1, str.length() - 1)));
            } catch (NumberFormatException unused) {
            }
        }
        throw new GdxRuntimeException(GeneratedOutlineSupport.outline50("Malformed Rectangle: ", str));
    }

    public float getAspectRatio() {
        float f2 = this.height;
        if (f2 == 0.0f) {
            return Float.NaN;
        }
        return this.width / f2;
    }

    public Vector2 getCenter(Vector2 vector2) {
        vector2.x = (this.width / 2.0f) + this.x;
        vector2.y = (this.height / 2.0f) + this.y;
        return vector2;
    }

    public float getHeight() {
        return this.height;
    }

    public Vector2 getPosition(Vector2 vector2) {
        float f2 = this.x;
        float f3 = this.y;
        vector2.x = f2;
        vector2.y = f3;
        return vector2;
    }

    public Vector2 getSize(Vector2 vector2) {
        float f2 = this.width;
        float f3 = this.height;
        vector2.x = f2;
        vector2.y = f3;
        return vector2;
    }

    public float getWidth() {
        return this.width;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public int hashCode() {
        return ((((((Float.floatToRawIntBits(this.height) + 31) * 31) + Float.floatToRawIntBits(this.width)) * 31) + Float.floatToRawIntBits(this.x)) * 31) + Float.floatToRawIntBits(this.y);
    }

    public Rectangle merge(Rectangle rectangle) {
        float min = Math.min(this.x, rectangle.x);
        float max = Math.max(this.x + this.width, rectangle.x + rectangle.width);
        this.x = min;
        this.width = max - min;
        float min2 = Math.min(this.y, rectangle.y);
        float max2 = Math.max(this.y + this.height, rectangle.y + rectangle.height);
        this.y = min2;
        this.height = max2 - min2;
        return this;
    }

    public boolean overlaps(Rectangle rectangle) {
        float f2 = this.x;
        float f3 = rectangle.x;
        if (f2 < rectangle.width + f3 && f2 + this.width > f3) {
            float f4 = this.y;
            float f5 = rectangle.y;
            if (f4 < rectangle.height + f5 && f4 + this.height > f5) {
                return true;
            }
        }
        return false;
    }

    public float perimeter() {
        return (this.width + this.height) * 2.0f;
    }

    public Rectangle set(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
        return this;
    }

    public Rectangle setCenter(float f2, float f3) {
        setPosition(f2 - (this.width / 2.0f), f3 - (this.height / 2.0f));
        return this;
    }

    public Rectangle setHeight(float f2) {
        this.height = f2;
        return this;
    }

    public Rectangle setPosition(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
        return this;
    }

    public Rectangle setSize(float f2, float f3) {
        this.width = f2;
        this.height = f3;
        return this;
    }

    public Rectangle setWidth(float f2) {
        this.width = f2;
        return this;
    }

    public Rectangle setX(float f2) {
        this.x = f2;
        return this;
    }

    public Rectangle setY(float f2) {
        this.y = f2;
        return this;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(this.x);
        outline73.append(",");
        outline73.append(this.y);
        outline73.append(",");
        outline73.append(this.width);
        outline73.append(",");
        outline73.append(this.height);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }

    public Rectangle(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    public boolean contains(Vector2 vector2) {
        return contains(vector2.x, vector2.y);
    }

    public Rectangle setCenter(Vector2 vector2) {
        setPosition(vector2.x - (this.width / 2.0f), vector2.y - (this.height / 2.0f));
        return this;
    }

    public boolean contains(Circle circle) {
        throw null;
    }

    public Rectangle setPosition(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        return this;
    }

    public Rectangle setSize(float f2) {
        this.width = f2;
        this.height = f2;
        return this;
    }

    public boolean contains(Rectangle rectangle) {
        float f2 = rectangle.x;
        float f3 = rectangle.width + f2;
        float f4 = rectangle.y;
        float f5 = rectangle.height + f4;
        float f6 = this.x;
        if (f2 > f6) {
            float f7 = this.width;
            if (f2 < f6 + f7 && f3 > f6 && f3 < f6 + f7) {
                float f8 = this.y;
                if (f4 > f8) {
                    float f9 = this.height;
                    if (f4 < f8 + f9 && f5 > f8 && f5 < f8 + f9) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Rectangle set(Rectangle rectangle) {
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
        return this;
    }

    public Rectangle(Rectangle rectangle) {
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    public Rectangle merge(float f2, float f3) {
        float min = Math.min(this.x, f2);
        float max = Math.max(this.x + this.width, f2);
        this.x = min;
        this.width = max - min;
        float min2 = Math.min(this.y, f3);
        float max2 = Math.max(this.y + this.height, f3);
        this.y = min2;
        this.height = max2 - min2;
        return this;
    }

    public Rectangle merge(Vector2 vector2) {
        return merge(vector2.x, vector2.y);
    }

    public Rectangle merge(Vector2[] vector2Arr) {
        float f2 = this.x;
        float f3 = this.width + f2;
        float f4 = this.y;
        float f5 = this.height + f4;
        for (Vector2 vector2 : vector2Arr) {
            f2 = Math.min(f2, vector2.x);
            f3 = Math.max(f3, vector2.x);
            f4 = Math.min(f4, vector2.y);
            f5 = Math.max(f5, vector2.y);
        }
        this.x = f2;
        this.width = f3 - f2;
        this.y = f4;
        this.height = f5 - f4;
        return this;
    }
}
