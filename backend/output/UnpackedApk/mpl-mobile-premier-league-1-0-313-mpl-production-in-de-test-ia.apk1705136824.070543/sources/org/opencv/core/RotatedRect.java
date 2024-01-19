package org.opencv.core;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMap;

public class RotatedRect {
    public double angle;
    public Point center;
    public Size size;

    public RotatedRect() {
        this.center = new Point(0.0d, 0.0d);
        this.size = new Size(0.0d, 0.0d);
        this.angle = 0.0d;
    }

    public Rect boundingRect() {
        Point[] pointArr = new Point[4];
        points(pointArr);
        Rect rect = new Rect((int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].x, pointArr[1].x), pointArr[2].x), pointArr[3].x)), (int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].y, pointArr[1].y), pointArr[2].y), pointArr[3].y)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].x, pointArr[1].x), pointArr[2].x), pointArr[3].x)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].y, pointArr[1].y), pointArr[2].y), pointArr[3].y)));
        rect.width -= rect.x - 1;
        rect.height -= rect.y - 1;
        return rect;
    }

    public Object clone() throws CloneNotSupportedException {
        return new RotatedRect(this.center, this.size, this.angle);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RotatedRect)) {
            return false;
        }
        RotatedRect rotatedRect = (RotatedRect) obj;
        if (!this.center.equals(rotatedRect.center) || !this.size.equals(rotatedRect.size) || this.angle != rotatedRect.angle) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.center.x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.center.y);
        long doubleToLongBits3 = Double.doubleToLongBits(this.size.width);
        long doubleToLongBits4 = Double.doubleToLongBits(this.size.height);
        long doubleToLongBits5 = Double.doubleToLongBits(this.angle);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
    }

    public void points(Point[] pointArr) {
        double d2 = (this.angle * 3.141592653589793d) / 180.0d;
        double cos = Math.cos(d2) * 0.5d;
        double sin = Math.sin(d2) * 0.5d;
        Point point = this.center;
        double d3 = point.x;
        Size size2 = this.size;
        double d4 = size2.height;
        double d5 = size2.width;
        pointArr[0] = new Point((d3 - (sin * d4)) - (cos * d5), ((d4 * cos) + point.y) - (d5 * sin));
        Point point2 = this.center;
        double d6 = point2.x;
        Size size3 = this.size;
        double d7 = size3.height;
        double d8 = (sin * d7) + d6;
        double d9 = size3.width;
        pointArr[1] = new Point(d8 - (cos * d9), (point2.y - (cos * d7)) - (sin * d9));
        Point point3 = this.center;
        pointArr[2] = new Point((point3.x * 2.0d) - pointArr[0].x, (point3.y * 2.0d) - pointArr[0].y);
        Point point4 = this.center;
        pointArr[3] = new Point((point4.x * 2.0d) - pointArr[1].x, (point4.y * 2.0d) - pointArr[1].y);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{ ");
        outline73.append(this.center);
        outline73.append(CMap.SPACE);
        outline73.append(this.size);
        outline73.append(" * ");
        outline73.append(this.angle);
        outline73.append(" }");
        return outline73.toString();
    }

    public RotatedRect(double[] dArr) {
        double d2 = 0.0d;
        this.center = new Point(0.0d, 0.0d);
        Size size2 = new Size(0.0d, 0.0d);
        this.size = size2;
        this.angle = 0.0d;
        if (dArr != null) {
            this.center.x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.center.y = dArr.length > 1 ? dArr[1] : 0.0d;
            this.size.width = dArr.length > 2 ? dArr[2] : 0.0d;
            this.size.height = dArr.length > 3 ? dArr[3] : 0.0d;
            this.angle = dArr.length > 4 ? dArr[4] : d2;
            return;
        }
        Point point = this.center;
        point.x = 0.0d;
        point.x = 0.0d;
        size2.width = 0.0d;
        size2.height = 0.0d;
        this.angle = 0.0d;
    }

    public RotatedRect(Point point, Size size2, double d2) {
        this.center = new Point(point.x, point.y);
        this.size = new Size(size2.width, size2.height);
        this.angle = d2;
    }
}
