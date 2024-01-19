package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;

public class ShapeRenderer implements Disposable {
    public boolean autoShapeType;
    public final Color color;
    public final Matrix4 combinedMatrix;
    public float defaultRectLineWidth;
    public boolean matrixDirty;
    public final Matrix4 projectionMatrix;
    public final ImmediateModeRenderer renderer;
    public ShapeType shapeType;
    public final Vector2 tmp;
    public final Matrix4 transformMatrix;

    public enum ShapeType {
        Point(0),
        Line(1),
        Filled(4);
        
        public final int glType;

        /* access modifiers changed from: public */
        ShapeType(int i) {
            this.glType = i;
        }

        public int getGlType() {
            return this.glType;
        }
    }

    public ShapeRenderer() {
        this(5000);
    }

    private void check(ShapeType shapeType2, ShapeType shapeType3, int i) {
        ShapeType shapeType4 = this.shapeType;
        if (shapeType4 == null) {
            throw new IllegalStateException("begin must be called first.");
        } else if (shapeType4 == shapeType2 || shapeType4 == shapeType3) {
            if (this.matrixDirty) {
                ShapeType shapeType5 = this.shapeType;
                end();
                begin(shapeType5);
            } else if (this.renderer.getMaxVertices() - this.renderer.getNumVertices() < i) {
                ShapeType shapeType6 = this.shapeType;
                end();
                begin(shapeType6);
            }
        } else if (this.autoShapeType) {
            end();
            begin(shapeType2);
        } else if (shapeType3 == null) {
            throw new IllegalStateException("Must call begin(ShapeType." + shapeType2 + ").");
        } else {
            throw new IllegalStateException("Must call begin(ShapeType." + shapeType2 + ") or begin(ShapeType." + shapeType3 + ").");
        }
    }

    public void arc(float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2;
        float f8 = f3;
        float f9 = f4;
        float f10 = f5;
        float f11 = f6;
        arc(f7, f8, f9, f10, f11, Math.max(1, (int) ((f6 / 360.0f) * ((float) Math.cbrt((double) f4)) * 6.0f)));
    }

    public void begin() {
        if (this.autoShapeType) {
            begin(ShapeType.Line);
            return;
        }
        throw new IllegalStateException("autoShapeType must be true to use this method.");
    }

    public void box(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = -f7;
        float floatBits = this.color.toFloatBits();
        ShapeType shapeType2 = this.shapeType;
        ShapeType shapeType3 = ShapeType.Line;
        if (shapeType2 == shapeType3) {
            check(shapeType3, ShapeType.Filled, 24);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f3, f4);
            this.renderer.color(floatBits);
            float f9 = f5 + f2;
            this.renderer.vertex(f9, f3, f4);
            this.renderer.color(floatBits);
            this.renderer.vertex(f9, f3, f4);
            this.renderer.color(floatBits);
            float f10 = f8 + f4;
            this.renderer.vertex(f9, f3, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f9, f3, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f3, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f3, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f3, f4);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f3, f4);
            this.renderer.color(floatBits);
            float f11 = f6 + f3;
            this.renderer.vertex(f2, f11, f4);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f11, f4);
            this.renderer.color(floatBits);
            this.renderer.vertex(f9, f11, f4);
            this.renderer.color(floatBits);
            this.renderer.vertex(f9, f11, f4);
            this.renderer.color(floatBits);
            this.renderer.vertex(f9, f11, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f9, f11, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f11, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f11, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f11, f4);
            this.renderer.color(floatBits);
            this.renderer.vertex(f9, f3, f4);
            this.renderer.color(floatBits);
            this.renderer.vertex(f9, f11, f4);
            this.renderer.color(floatBits);
            this.renderer.vertex(f9, f3, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f9, f11, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f3, f10);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f11, f10);
            return;
        }
        check(shapeType3, ShapeType.Filled, 36);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, f4);
        this.renderer.color(floatBits);
        float f12 = f5 + f2;
        this.renderer.vertex(f12, f3, f4);
        this.renderer.color(floatBits);
        float f13 = f6 + f3;
        this.renderer.vertex(f12, f13, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f13, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f13, f4);
        this.renderer.color(floatBits);
        float f14 = f8 + f4;
        this.renderer.vertex(f12, f3, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f13, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f13, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f13, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f13, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f13, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f13, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f3, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f3, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f13, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f3, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f13, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f13, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f13, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f13, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f13, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f13, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f13, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f13, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f3, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f3, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, f14);
        this.renderer.color(floatBits);
        this.renderer.vertex(f12, f3, f4);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, f4);
    }

    public void circle(float f2, float f3, float f4) {
        circle(f2, f3, f4, Math.max(1, (int) (((float) Math.cbrt((double) f4)) * 6.0f)));
    }

    public void cone(float f2, float f3, float f4, float f5, float f6) {
        cone(f2, f3, f4, f5, f6, Math.max(1, (int) (((float) Math.sqrt((double) f5)) * 4.0f)));
    }

    public void curve(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i) {
        float f10 = f8;
        float f11 = f9;
        int i2 = i;
        check(ShapeType.Line, null, (i2 * 2) + 2);
        float floatBits = this.color.toFloatBits();
        float f12 = 1.0f / ((float) i2);
        float f13 = f12 * f12;
        float f14 = f13 * f12;
        float f15 = f12 * 3.0f;
        float f16 = f13 * 3.0f;
        float f17 = f13 * 6.0f;
        float f18 = 6.0f * f14;
        float f19 = (f2 - (f4 * 2.0f)) + f6;
        float f20 = (f3 - (2.0f * f5)) + f7;
        float f21 = (((f4 - f6) * 3.0f) - f2) + f10;
        float f22 = (((f5 - f7) * 3.0f) - f3) + f11;
        float f23 = (f21 * f14) + (f19 * f16) + ((f4 - f2) * f15);
        float f24 = (f14 * f22) + (f16 * f20) + ((f5 - f3) * f15);
        float f25 = f21 * f18;
        float f26 = (f19 * f17) + f25;
        float f27 = f22 * f18;
        float f28 = (f20 * f17) + f27;
        float f29 = f3;
        int i3 = i2;
        float f30 = f2;
        while (true) {
            int i4 = i3 - 1;
            if (i3 > 0) {
                this.renderer.color(floatBits);
                this.renderer.vertex(f30, f29, 0.0f);
                f30 += f23;
                f29 += f24;
                f23 += f26;
                f24 += f28;
                f26 += f25;
                f28 += f27;
                this.renderer.color(floatBits);
                this.renderer.vertex(f30, f29, 0.0f);
                i3 = i4;
            } else {
                this.renderer.color(floatBits);
                this.renderer.vertex(f30, f29, 0.0f);
                this.renderer.color(floatBits);
                this.renderer.vertex(f10, f11, 0.0f);
                return;
            }
        }
    }

    public void dispose() {
        this.renderer.dispose();
    }

    public void ellipse(float f2, float f3, float f4, float f5) {
        ellipse(f2, f3, f4, f5, Math.max(1, (int) (((float) Math.cbrt((double) Math.max(f4 * 0.5f, 0.5f * f5))) * 12.0f)));
    }

    public void end() {
        this.renderer.end();
        this.shapeType = null;
    }

    public void flush() {
        ShapeType shapeType2 = this.shapeType;
        if (shapeType2 != null) {
            end();
            begin(shapeType2);
        }
    }

    public Color getColor() {
        return this.color;
    }

    public ShapeType getCurrentType() {
        return this.shapeType;
    }

    public Matrix4 getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public ImmediateModeRenderer getRenderer() {
        return this.renderer;
    }

    public Matrix4 getTransformMatrix() {
        return this.transformMatrix;
    }

    public void identity() {
        this.transformMatrix.idt();
        this.matrixDirty = true;
    }

    public boolean isDrawing() {
        return this.shapeType != null;
    }

    public final void line(float f2, float f3, float f4, float f5, float f6, float f7) {
        Color color2 = this.color;
        line(f2, f3, f4, f5, f6, f7, color2, color2);
    }

    public void point(float f2, float f3, float f4) {
        ShapeType shapeType2 = this.shapeType;
        if (shapeType2 == ShapeType.Line) {
            float f5 = this.defaultRectLineWidth * 0.5f;
            line(f2 - f5, f3 - f5, f4, f2 + f5, f3 + f5, f4);
        } else if (shapeType2 == ShapeType.Filled) {
            float f6 = this.defaultRectLineWidth;
            float f7 = 0.5f * f6;
            box(f2 - f7, f3 - f7, f4 - f7, f6, f6, f6);
        } else {
            check(ShapeType.Point, null, 1);
            this.renderer.color(this.color);
            this.renderer.vertex(f2, f3, f4);
        }
    }

    public void polygon(float[] fArr, int i, int i2) {
        float f2;
        float f3;
        if (i2 < 6) {
            throw new IllegalArgumentException("Polygons must contain at least 3 points.");
        } else if (i2 % 2 == 0) {
            check(ShapeType.Line, null, i2);
            float floatBits = this.color.toFloatBits();
            float f4 = fArr[0];
            float f5 = fArr[1];
            int i3 = i + i2;
            while (i < i3) {
                float f6 = fArr[i];
                float f7 = fArr[i + 1];
                int i4 = i + 2;
                if (i4 >= i2) {
                    f3 = f4;
                    f2 = f5;
                } else {
                    f3 = fArr[i4];
                    f2 = fArr[i + 3];
                }
                this.renderer.color(floatBits);
                this.renderer.vertex(f6, f7, 0.0f);
                this.renderer.color(floatBits);
                this.renderer.vertex(f3, f2, 0.0f);
                i = i4;
            }
        } else {
            throw new IllegalArgumentException("Polygons must have an even number of vertices.");
        }
    }

    public void polyline(float[] fArr, int i, int i2) {
        if (i2 < 4) {
            throw new IllegalArgumentException("Polylines must contain at least 2 points.");
        } else if (i2 % 2 == 0) {
            check(ShapeType.Line, null, i2);
            float floatBits = this.color.toFloatBits();
            int i3 = (i2 + i) - 2;
            while (i < i3) {
                float f2 = fArr[i];
                float f3 = fArr[i + 1];
                int i4 = i + 2;
                float f4 = fArr[i4];
                float f5 = fArr[i + 3];
                this.renderer.color(floatBits);
                this.renderer.vertex(f2, f3, 0.0f);
                this.renderer.color(floatBits);
                this.renderer.vertex(f4, f5, 0.0f);
                i = i4;
            }
        } else {
            throw new IllegalArgumentException("Polylines must have an even number of vertices.");
        }
    }

    public void rect(float f2, float f3, float f4, float f5) {
        check(ShapeType.Line, ShapeType.Filled, 8);
        float floatBits = this.color.toFloatBits();
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(floatBits);
            float f6 = f4 + f2;
            this.renderer.vertex(f6, f3, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f6, f3, 0.0f);
            this.renderer.color(floatBits);
            float f7 = f5 + f3;
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f7, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f7, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f3, 0.0f);
            return;
        }
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, 0.0f);
        this.renderer.color(floatBits);
        float f8 = f4 + f2;
        this.renderer.vertex(f8, f3, 0.0f);
        this.renderer.color(floatBits);
        float f9 = f5 + f3;
        this.renderer.vertex(f8, f9, 0.0f);
        this.renderer.color(floatBits);
        this.renderer.vertex(f8, f9, 0.0f);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f9, 0.0f);
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, 0.0f);
    }

    public void rectLine(float f2, float f3, float f4, float f5, float f6) {
        check(ShapeType.Line, ShapeType.Filled, 8);
        float floatBits = this.color.toFloatBits();
        Vector2 vector2 = this.tmp;
        vector2.x = f5 - f3;
        vector2.y = f2 - f4;
        vector2.nor();
        float f7 = f6 * 0.5f;
        float f8 = vector2.x * f7;
        float f9 = vector2.y * f7;
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(floatBits);
            float f10 = f2 + f8;
            float f11 = f3 + f9;
            this.renderer.vertex(f10, f11, 0.0f);
            this.renderer.color(floatBits);
            float f12 = f2 - f8;
            float f13 = f3 - f9;
            this.renderer.vertex(f12, f13, 0.0f);
            this.renderer.color(floatBits);
            float f14 = f4 + f8;
            float f15 = f5 + f9;
            this.renderer.vertex(f14, f15, 0.0f);
            this.renderer.color(floatBits);
            float f16 = f4 - f8;
            float f17 = f5 - f9;
            this.renderer.vertex(f16, f17, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f14, f15, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f10, f11, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f16, f17, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f12, f13, 0.0f);
            return;
        }
        this.renderer.color(floatBits);
        this.renderer.vertex(f2 + f8, f3 + f9, 0.0f);
        this.renderer.color(floatBits);
        float f18 = f2 - f8;
        float f19 = f3 - f9;
        this.renderer.vertex(f18, f19, 0.0f);
        this.renderer.color(floatBits);
        float f20 = f4 + f8;
        float f21 = f5 + f9;
        this.renderer.vertex(f20, f21, 0.0f);
        this.renderer.color(floatBits);
        this.renderer.vertex(f4 - f8, f5 - f9, 0.0f);
        this.renderer.color(floatBits);
        this.renderer.vertex(f20, f21, 0.0f);
        this.renderer.color(floatBits);
        this.renderer.vertex(f18, f19, 0.0f);
    }

    public void rotate(float f2, float f3, float f4, float f5) {
        Matrix4 matrix4 = this.transformMatrix;
        if (matrix4 != null) {
            if (f5 != 0.0f) {
                Matrix4.quat.setFromAxis(f2, f3, f4, f5);
                matrix4.rotate(Matrix4.quat);
            }
            this.matrixDirty = true;
            return;
        }
        throw null;
    }

    public void scale(float f2, float f3, float f4) {
        this.transformMatrix.scale(f2, f3, f4);
        this.matrixDirty = true;
    }

    public void set(ShapeType shapeType2) {
        ShapeType shapeType3 = this.shapeType;
        if (shapeType3 != shapeType2) {
            if (shapeType3 == null) {
                throw new IllegalStateException("begin must be called first.");
            } else if (this.autoShapeType) {
                end();
                begin(shapeType2);
            } else {
                throw new IllegalStateException("autoShapeType must be enabled.");
            }
        }
    }

    public void setAutoShapeType(boolean z) {
        this.autoShapeType = z;
    }

    public void setColor(Color color2) {
        this.color.set(color2);
    }

    public void setProjectionMatrix(Matrix4 matrix4) {
        this.projectionMatrix.set(matrix4);
        this.matrixDirty = true;
    }

    public void setTransformMatrix(Matrix4 matrix4) {
        this.transformMatrix.set(matrix4);
        this.matrixDirty = true;
    }

    public void translate(float f2, float f3, float f4) {
        this.transformMatrix.translate(f2, f3, f4);
        this.matrixDirty = true;
    }

    public void triangle(float f2, float f3, float f4, float f5, float f6, float f7) {
        check(ShapeType.Line, ShapeType.Filled, 6);
        float floatBits = this.color.toFloatBits();
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f4, f5, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f4, f5, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f2, f3, 0.0f);
            return;
        }
        this.renderer.color(floatBits);
        this.renderer.vertex(f2, f3, 0.0f);
        this.renderer.color(floatBits);
        this.renderer.vertex(f4, f5, 0.0f);
        this.renderer.color(floatBits);
        this.renderer.vertex(f6, f7, 0.0f);
    }

    public void updateMatrices() {
        this.matrixDirty = true;
    }

    public void x(float f2, float f3, float f4) {
        float f5 = f2 - f4;
        float f6 = f3 - f4;
        float f7 = f2 + f4;
        float f8 = f3 + f4;
        line(f5, f6, f7, f8);
        line(f5, f8, f7, f6);
    }

    public ShapeRenderer(int i) {
        this(i, null);
    }

    public void arc(float f2, float f3, float f4, float f5, float f6, int i) {
        if (i > 0) {
            float floatBits = this.color.toFloatBits();
            float f7 = ((f6 / 360.0f) * 6.2831855f) / ((float) i);
            float cos = MathUtils.cos(f7);
            float sin = MathUtils.sin(f7);
            float f8 = f5 * 0.017453292f;
            float cos2 = MathUtils.cos(f8) * f4;
            float sin2 = MathUtils.sin(f8) * f4;
            ShapeType shapeType2 = this.shapeType;
            ShapeType shapeType3 = ShapeType.Line;
            int i2 = 0;
            if (shapeType2 == shapeType3) {
                check(shapeType3, ShapeType.Filled, (i * 2) + 2);
                this.renderer.color(floatBits);
                this.renderer.vertex(f2, f3, 0.0f);
                this.renderer.color(floatBits);
                this.renderer.vertex(f2 + cos2, f3 + sin2, 0.0f);
                while (i2 < i) {
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f2 + cos2, f3 + sin2, 0.0f);
                    float f9 = (cos * cos2) - (sin * sin2);
                    sin2 = (sin2 * cos) + (cos2 * sin);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f2 + f9, f3 + sin2, 0.0f);
                    i2++;
                    cos2 = f9;
                }
                this.renderer.color(floatBits);
                this.renderer.vertex(cos2 + f2, sin2 + f3, 0.0f);
            } else {
                check(shapeType3, ShapeType.Filled, (i * 3) + 3);
                while (i2 < i) {
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f2, f3, 0.0f);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f2 + cos2, f3 + sin2, 0.0f);
                    float f10 = (cos * cos2) - (sin * sin2);
                    sin2 = (sin2 * cos) + (cos2 * sin);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f2 + f10, f3 + sin2, 0.0f);
                    i2++;
                    cos2 = f10;
                }
                this.renderer.color(floatBits);
                this.renderer.vertex(f2, f3, 0.0f);
                this.renderer.color(floatBits);
                this.renderer.vertex(cos2 + f2, sin2 + f3, 0.0f);
            }
            this.renderer.color(floatBits);
            this.renderer.vertex(f2 + 0.0f, f3 + 0.0f, 0.0f);
            return;
        }
        throw new IllegalArgumentException("segments must be > 0.");
    }

    public void circle(float f2, float f3, float f4, int i) {
        if (i > 0) {
            float floatBits = this.color.toFloatBits();
            float f5 = 6.2831855f / ((float) i);
            float cos = MathUtils.cos(f5);
            float sin = MathUtils.sin(f5);
            ShapeType shapeType2 = this.shapeType;
            ShapeType shapeType3 = ShapeType.Line;
            int i2 = 0;
            if (shapeType2 == shapeType3) {
                check(shapeType3, ShapeType.Filled, (i * 2) + 2);
                float f6 = f4;
                float f7 = 0.0f;
                while (i2 < i) {
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f2 + f6, f3 + f7, 0.0f);
                    float f8 = (cos * f6) - (sin * f7);
                    f7 = (f7 * cos) + (f6 * sin);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f2 + f8, f3 + f7, 0.0f);
                    i2++;
                    f6 = f8;
                }
                this.renderer.color(floatBits);
                this.renderer.vertex(f6 + f2, f7 + f3, 0.0f);
            } else {
                check(shapeType3, ShapeType.Filled, (i * 3) + 3);
                int i3 = i - 1;
                float f9 = f4;
                float f10 = 0.0f;
                while (i2 < i3) {
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f2, f3, 0.0f);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
                    float f11 = (cos * f9) - (sin * f10);
                    f10 = (f10 * cos) + (f9 * sin);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f2 + f11, f3 + f10, 0.0f);
                    i2++;
                    f9 = f11;
                }
                this.renderer.color(floatBits);
                this.renderer.vertex(f2, f3, 0.0f);
                this.renderer.color(floatBits);
                this.renderer.vertex(f9 + f2, f10 + f3, 0.0f);
            }
            this.renderer.color(floatBits);
            this.renderer.vertex(f2 + f4, f3 + 0.0f, 0.0f);
            return;
        }
        throw new IllegalArgumentException("segments must be > 0.");
    }

    public void cone(float f2, float f3, float f4, float f5, float f6, int i) {
        float f7;
        float f8;
        float f9 = f2;
        float f10 = f3;
        float f11 = f4;
        int i2 = i;
        if (i2 > 0) {
            check(ShapeType.Line, ShapeType.Filled, (i2 * 4) + 2);
            float floatBits = this.color.toFloatBits();
            float f12 = 6.2831855f / ((float) i2);
            float cos = MathUtils.cos(f12);
            float sin = MathUtils.sin(f12);
            int i3 = 0;
            if (this.shapeType == ShapeType.Line) {
                f8 = f5;
                f7 = 0.0f;
                while (i3 < i2) {
                    this.renderer.color(floatBits);
                    float f13 = f9 + f8;
                    float f14 = f10 + f7;
                    this.renderer.vertex(f13, f14, f11);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f9, f10, f11 + f6);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f13, f14, f11);
                    float f15 = (cos * f8) - (sin * f7);
                    f7 = (f7 * cos) + (f8 * sin);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f9 + f15, f10 + f7, f11);
                    i3++;
                    f8 = f15;
                }
                this.renderer.color(floatBits);
                this.renderer.vertex(f9 + f8, f10 + f7, f11);
            } else {
                int i4 = i2 - 1;
                float f16 = f5;
                float f17 = 0.0f;
                while (i3 < i4) {
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f9, f10, f11);
                    this.renderer.color(floatBits);
                    float f18 = f9 + f8;
                    float f19 = f10 + f7;
                    this.renderer.vertex(f18, f19, f11);
                    float f20 = (cos * f8) - (sin * f7);
                    f17 = (f7 * cos) + (f8 * sin);
                    this.renderer.color(floatBits);
                    float f21 = f9 + f20;
                    float f22 = f10 + f17;
                    this.renderer.vertex(f21, f22, f11);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f18, f19, f11);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f21, f22, f11);
                    this.renderer.color(floatBits);
                    this.renderer.vertex(f9, f10, f11 + f6);
                    i3++;
                    f16 = f20;
                }
                this.renderer.color(floatBits);
                this.renderer.vertex(f9, f10, f11);
                this.renderer.color(floatBits);
                this.renderer.vertex(f9 + f8, f10 + f7, f11);
            }
            this.renderer.color(floatBits);
            float f23 = f9 + f5;
            float f24 = 0.0f + f10;
            this.renderer.vertex(f23, f24, f11);
            if (this.shapeType != ShapeType.Line) {
                this.renderer.color(floatBits);
                this.renderer.vertex(f8 + f9, f7 + f10, f11);
                this.renderer.color(floatBits);
                this.renderer.vertex(f23, f24, f11);
                this.renderer.color(floatBits);
                this.renderer.vertex(f9, f10, f11 + f6);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("segments must be > 0.");
    }

    public void ellipse(float f2, float f3, float f4, float f5, int i) {
        if (i > 0) {
            check(ShapeType.Line, ShapeType.Filled, i * 3);
            float floatBits = this.color.toFloatBits();
            float f6 = 6.2831855f / ((float) i);
            float f7 = (f4 / 2.0f) + f2;
            float f8 = (f5 / 2.0f) + f3;
            int i2 = 0;
            if (this.shapeType == ShapeType.Line) {
                while (i2 < i) {
                    this.renderer.color(floatBits);
                    float f9 = f4 * 0.5f;
                    float f10 = ((float) i2) * f6;
                    float f11 = f5 * 0.5f;
                    this.renderer.vertex((MathUtils.cos(f10) * f9) + f7, (MathUtils.sin(f10) * f11) + f8, 0.0f);
                    this.renderer.color(floatBits);
                    i2++;
                    float f12 = ((float) i2) * f6;
                    this.renderer.vertex((MathUtils.cos(f12) * f9) + f7, (MathUtils.sin(f12) * f11) + f8, 0.0f);
                }
                return;
            }
            while (i2 < i) {
                this.renderer.color(floatBits);
                float f13 = f4 * 0.5f;
                float f14 = ((float) i2) * f6;
                float f15 = f5 * 0.5f;
                this.renderer.vertex((MathUtils.cos(f14) * f13) + f7, (MathUtils.sin(f14) * f15) + f8, 0.0f);
                this.renderer.color(floatBits);
                this.renderer.vertex(f7, f8, 0.0f);
                this.renderer.color(floatBits);
                i2++;
                float f16 = ((float) i2) * f6;
                this.renderer.vertex((MathUtils.cos(f16) * f13) + f7, (MathUtils.sin(f16) * f15) + f8, 0.0f);
            }
            return;
        }
        throw new IllegalArgumentException("segments must be > 0.");
    }

    public final void line(Vector3 vector3, Vector3 vector32) {
        float f2 = vector3.x;
        float f3 = vector3.y;
        float f4 = vector3.z;
        float f5 = vector32.x;
        float f6 = vector32.y;
        float f7 = vector32.z;
        Color color2 = this.color;
        line(f2, f3, f4, f5, f6, f7, color2, color2);
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
    }

    public ShapeRenderer(int i, ShaderProgram shaderProgram) {
        this.matrixDirty = false;
        this.projectionMatrix = new Matrix4();
        this.transformMatrix = new Matrix4();
        this.combinedMatrix = new Matrix4();
        this.tmp = new Vector2();
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.defaultRectLineWidth = 0.75f;
        if (shaderProgram == null) {
            this.renderer = new ImmediateModeRenderer20(i, false, true, 0);
        } else {
            ImmediateModeRenderer20 immediateModeRenderer20 = new ImmediateModeRenderer20(i, false, true, 0, shaderProgram);
            this.renderer = immediateModeRenderer20;
        }
        Matrix4 matrix4 = this.projectionMatrix;
        Graphics graphics = k.graphics;
        matrix4.setToOrtho2D(0.0f, 0.0f, (float) ((AndroidGraphics) graphics).width, (float) ((AndroidGraphics) graphics).height);
        this.matrixDirty = true;
    }

    public final void line(float f2, float f3, float f4, float f5) {
        Color color2 = this.color;
        line(f2, f3, 0.0f, f4, f5, 0.0f, color2, color2);
    }

    public void x(Vector2 vector2, float f2) {
        x(vector2.x, vector2.y, f2);
    }

    public void begin(ShapeType shapeType2) {
        if (this.shapeType == null) {
            this.shapeType = shapeType2;
            if (this.matrixDirty) {
                this.combinedMatrix.set(this.projectionMatrix);
                Matrix4.mul(this.combinedMatrix.val, this.transformMatrix.val);
                this.matrixDirty = false;
            }
            this.renderer.begin(this.combinedMatrix, this.shapeType.getGlType());
            return;
        }
        throw new IllegalStateException("Call end() before beginning a new shape batch.");
    }

    public final void line(Vector2 vector2, Vector2 vector22) {
        float f2 = vector2.x;
        float f3 = vector2.y;
        float f4 = vector22.x;
        float f5 = vector22.y;
        Color color2 = this.color;
        line(f2, f3, 0.0f, f4, f5, 0.0f, color2, color2);
    }

    public final void line(float f2, float f3, float f4, float f5, Color color2, Color color3) {
        line(f2, f3, 0.0f, f4, f5, 0.0f, color2, color3);
    }

    public void line(float f2, float f3, float f4, float f5, float f6, float f7, Color color2, Color color3) {
        Color color4 = color2;
        Color color5 = color3;
        if (this.shapeType == ShapeType.Filled) {
            rectLine(f2, f3, f5, f6, this.defaultRectLineWidth, color2, color3);
            return;
        }
        check(ShapeType.Line, null, 2);
        this.renderer.color(color4.r, color4.g, color4.f3307b, color4.f3306a);
        float f8 = f2;
        float f9 = f3;
        float f10 = f4;
        this.renderer.vertex(f2, f3, f4);
        this.renderer.color(color5.r, color5.g, color5.f3307b, color5.f3306a);
        float f11 = f5;
        float f12 = f6;
        float f13 = f7;
        this.renderer.vertex(f5, f6, f7);
    }

    public void polyline(float[] fArr) {
        polyline(fArr, 0, fArr.length);
    }

    public void polygon(float[] fArr) {
        polygon(fArr, 0, fArr.length);
    }

    public void ellipse(float f2, float f3, float f4, float f5, float f6) {
        ellipse(f2, f3, f4, f5, f6, Math.max(1, (int) (((float) Math.cbrt((double) Math.max(f4 * 0.5f, 0.5f * f5))) * 12.0f)));
    }

    public void ellipse(float f2, float f3, float f4, float f5, float f6, int i) {
        int i2 = i;
        if (i2 > 0) {
            check(ShapeType.Line, ShapeType.Filled, i2 * 3);
            float floatBits = this.color.toFloatBits();
            float f7 = 6.2831855f / ((float) i2);
            float f8 = (3.1415927f * f6) / 180.0f;
            float sin = MathUtils.sin(f8);
            float cos = MathUtils.cos(f8);
            float f9 = (f4 / 2.0f) + f2;
            float f10 = (f5 / 2.0f) + f3;
            float f11 = 0.5f;
            float f12 = f4 * 0.5f;
            int i3 = 0;
            if (this.shapeType == ShapeType.Line) {
                float f13 = f12;
                float f14 = 0.0f;
                while (i3 < i2) {
                    this.renderer.color(floatBits);
                    this.renderer.vertex(((cos * f13) + f9) - (sin * f14), (f14 * cos) + (f13 * sin) + f10, 0.0f);
                    i3++;
                    float f15 = ((float) i3) * f7;
                    float cos2 = MathUtils.cos(f15) * f12;
                    float sin2 = MathUtils.sin(f15) * f5 * f11;
                    this.renderer.color(floatBits);
                    this.renderer.vertex(((cos * cos2) + f9) - (sin * sin2), (cos * sin2) + (sin * cos2) + f10, 0.0f);
                    f11 = 0.5f;
                    float f16 = cos2;
                    f14 = sin2;
                    f13 = f16;
                }
                return;
            }
            float f17 = f12;
            float f18 = 0.0f;
            while (i3 < i2) {
                this.renderer.color(floatBits);
                this.renderer.vertex(((cos * f17) + f9) - (sin * f18), (f18 * cos) + (f17 * sin) + f10, 0.0f);
                this.renderer.color(floatBits);
                this.renderer.vertex(f9, f10, 0.0f);
                i3++;
                float f19 = ((float) i3) * f7;
                float cos3 = MathUtils.cos(f19) * f12;
                float sin3 = MathUtils.sin(f19) * f5 * 0.5f;
                this.renderer.color(floatBits);
                this.renderer.vertex(((cos * cos3) + f9) - (sin * sin3), (cos * sin3) + (sin * cos3) + f10, 0.0f);
                float f20 = cos3;
                f18 = sin3;
                f17 = f20;
            }
            return;
        }
        throw new IllegalArgumentException("segments must be > 0.");
    }

    public void triangle(float f2, float f3, float f4, float f5, float f6, float f7, Color color2, Color color3, Color color4) {
        check(ShapeType.Line, ShapeType.Filled, 6);
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(color2.r, color2.g, color2.f3307b, color2.f3306a);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.f3307b, color3.f3306a);
            this.renderer.vertex(f4, f5, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.f3307b, color3.f3306a);
            this.renderer.vertex(f4, f5, 0.0f);
            this.renderer.color(color4.r, color4.g, color4.f3307b, color4.f3306a);
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(color4.r, color4.g, color4.f3307b, color4.f3306a);
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.f3307b, color2.f3306a);
            this.renderer.vertex(f2, f3, 0.0f);
            return;
        }
        this.renderer.color(color2.r, color2.g, color2.f3307b, color2.f3306a);
        this.renderer.vertex(f2, f3, 0.0f);
        this.renderer.color(color3.r, color3.g, color3.f3307b, color3.f3306a);
        this.renderer.vertex(f4, f5, 0.0f);
        this.renderer.color(color4.r, color4.g, color4.f3307b, color4.f3306a);
        this.renderer.vertex(f6, f7, 0.0f);
    }

    public void rect(float f2, float f3, float f4, float f5, Color color2, Color color3, Color color4, Color color5) {
        check(ShapeType.Line, ShapeType.Filled, 8);
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(color2.r, color2.g, color2.f3307b, color2.f3306a);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.f3307b, color3.f3306a);
            float f6 = f4 + f2;
            this.renderer.vertex(f6, f3, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.f3307b, color3.f3306a);
            this.renderer.vertex(f6, f3, 0.0f);
            this.renderer.color(color4.r, color4.g, color4.f3307b, color4.f3306a);
            float f7 = f5 + f3;
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(color4.r, color4.g, color4.f3307b, color4.f3306a);
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(color5.r, color5.g, color5.f3307b, color5.f3306a);
            this.renderer.vertex(f2, f7, 0.0f);
            this.renderer.color(color5.r, color5.g, color5.f3307b, color5.f3306a);
            this.renderer.vertex(f2, f7, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.f3307b, color2.f3306a);
            this.renderer.vertex(f2, f3, 0.0f);
            return;
        }
        this.renderer.color(color2.r, color2.g, color2.f3307b, color2.f3306a);
        this.renderer.vertex(f2, f3, 0.0f);
        this.renderer.color(color3.r, color3.g, color3.f3307b, color3.f3306a);
        float f8 = f4 + f2;
        this.renderer.vertex(f8, f3, 0.0f);
        this.renderer.color(color4.r, color4.g, color4.f3307b, color4.f3306a);
        float f9 = f5 + f3;
        this.renderer.vertex(f8, f9, 0.0f);
        this.renderer.color(color4.r, color4.g, color4.f3307b, color4.f3306a);
        this.renderer.vertex(f8, f9, 0.0f);
        this.renderer.color(color5.r, color5.g, color5.f3307b, color5.f3306a);
        this.renderer.vertex(f2, f9, 0.0f);
        this.renderer.color(color2.r, color2.g, color2.f3307b, color2.f3306a);
        this.renderer.vertex(f2, f3, 0.0f);
    }

    public void rectLine(float f2, float f3, float f4, float f5, float f6, Color color2, Color color3) {
        check(ShapeType.Line, ShapeType.Filled, 8);
        float floatBits = color2.toFloatBits();
        float floatBits2 = color3.toFloatBits();
        Vector2 vector2 = this.tmp;
        vector2.x = f5 - f3;
        vector2.y = f2 - f4;
        vector2.nor();
        float f7 = f6 * 0.5f;
        float f8 = vector2.x * f7;
        float f9 = vector2.y * f7;
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(floatBits);
            float f10 = f2 + f8;
            float f11 = f3 + f9;
            this.renderer.vertex(f10, f11, 0.0f);
            this.renderer.color(floatBits);
            float f12 = f2 - f8;
            float f13 = f3 - f9;
            this.renderer.vertex(f12, f13, 0.0f);
            this.renderer.color(floatBits2);
            float f14 = f4 + f8;
            float f15 = f5 + f9;
            this.renderer.vertex(f14, f15, 0.0f);
            this.renderer.color(floatBits2);
            float f16 = f4 - f8;
            float f17 = f5 - f9;
            this.renderer.vertex(f16, f17, 0.0f);
            this.renderer.color(floatBits2);
            this.renderer.vertex(f14, f15, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f10, f11, 0.0f);
            this.renderer.color(floatBits2);
            this.renderer.vertex(f16, f17, 0.0f);
            this.renderer.color(floatBits);
            this.renderer.vertex(f12, f13, 0.0f);
            return;
        }
        this.renderer.color(floatBits);
        this.renderer.vertex(f2 + f8, f3 + f9, 0.0f);
        this.renderer.color(floatBits);
        float f18 = f2 - f8;
        float f19 = f3 - f9;
        this.renderer.vertex(f18, f19, 0.0f);
        this.renderer.color(floatBits2);
        float f20 = f4 + f8;
        float f21 = f5 + f9;
        this.renderer.vertex(f20, f21, 0.0f);
        this.renderer.color(floatBits2);
        this.renderer.vertex(f4 - f8, f5 - f9, 0.0f);
        this.renderer.color(floatBits2);
        this.renderer.vertex(f20, f21, 0.0f);
        this.renderer.color(floatBits);
        this.renderer.vertex(f18, f19, 0.0f);
    }

    public void rect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        Color color2 = this.color;
        rect(f2, f3, f4, f5, f6, f7, f8, f9, f10, color2, color2, color2, color2);
    }

    public void rect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Color color2, Color color3, Color color4, Color color5) {
        float f11 = f4;
        float f12 = f5;
        Color color6 = color2;
        Color color7 = color3;
        Color color8 = color4;
        Color color9 = color5;
        check(ShapeType.Line, ShapeType.Filled, 8);
        float cosDeg = MathUtils.cosDeg(f10);
        float sinDeg = MathUtils.sinDeg(f10);
        float f13 = -f11;
        float f14 = -f12;
        float f15 = f6 - f11;
        float f16 = f7 - f12;
        if (!(f8 == 1.0f && f9 == 1.0f)) {
            f13 *= f8;
            f14 *= f9;
            f15 *= f8;
            f16 *= f9;
        }
        float f17 = f2 + f11;
        float f18 = f3 + f12;
        float f19 = sinDeg * f14;
        float f20 = ((cosDeg * f13) - f19) + f17;
        float f21 = f14 * cosDeg;
        float f22 = (f13 * sinDeg) + f21 + f18;
        float f23 = cosDeg * f15;
        float f24 = (f23 - f19) + f17;
        float f25 = f15 * sinDeg;
        float f26 = f21 + f25 + f18;
        float f27 = (f23 - (sinDeg * f16)) + f17;
        float outline4 = GeneratedOutlineSupport.outline4(cosDeg, f16, f25, f18);
        float f28 = (f27 - f24) + f20;
        float f29 = outline4 - (f26 - f22);
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(color6.r, color6.g, color6.f3307b, color6.f3306a);
            this.renderer.vertex(f20, f22, 0.0f);
            this.renderer.color(color7.r, color7.g, color7.f3307b, color7.f3306a);
            this.renderer.vertex(f24, f26, 0.0f);
            this.renderer.color(color7.r, color7.g, color7.f3307b, color7.f3306a);
            this.renderer.vertex(f24, f26, 0.0f);
            this.renderer.color(color8.r, color8.g, color8.f3307b, color8.f3306a);
            this.renderer.vertex(f27, outline4, 0.0f);
            this.renderer.color(color8.r, color8.g, color8.f3307b, color8.f3306a);
            this.renderer.vertex(f27, outline4, 0.0f);
            this.renderer.color(color9.r, color9.g, color9.f3307b, color9.f3306a);
            float f30 = f28;
            float f31 = f29;
            this.renderer.vertex(f30, f31, 0.0f);
            this.renderer.color(color9.r, color9.g, color9.f3307b, color9.f3306a);
            this.renderer.vertex(f30, f31, 0.0f);
            this.renderer.color(color6.r, color6.g, color6.f3307b, color6.f3306a);
            this.renderer.vertex(f20, f22, 0.0f);
            return;
        }
        this.renderer.color(color6.r, color6.g, color6.f3307b, color6.f3306a);
        this.renderer.vertex(f20, f22, 0.0f);
        this.renderer.color(color7.r, color7.g, color7.f3307b, color7.f3306a);
        this.renderer.vertex(f24, f26, 0.0f);
        this.renderer.color(color8.r, color8.g, color8.f3307b, color8.f3306a);
        this.renderer.vertex(f27, outline4, 0.0f);
        this.renderer.color(color8.r, color8.g, color8.f3307b, color8.f3306a);
        this.renderer.vertex(f27, outline4, 0.0f);
        this.renderer.color(color9.r, color9.g, color9.f3307b, color9.f3306a);
        this.renderer.vertex(f28, f29, 0.0f);
        this.renderer.color(color6.r, color6.g, color6.f3307b, color6.f3306a);
        this.renderer.vertex(f20, f22, 0.0f);
    }

    public void rectLine(Vector2 vector2, Vector2 vector22, float f2) {
        rectLine(vector2.x, vector2.y, vector22.x, vector22.y, f2);
    }
}
