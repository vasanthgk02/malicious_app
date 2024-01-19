package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import java.util.Arrays;

public class Table extends WidgetGroup {
    public static Value backgroundBottom = new Value() {
        public float get(Actor actor) {
            Drawable drawable = ((Table) actor).background;
            if (drawable == null) {
                return 0.0f;
            }
            return drawable.getBottomHeight();
        }
    };
    public static Value backgroundLeft = new Value() {
        public float get(Actor actor) {
            Drawable drawable = ((Table) actor).background;
            if (drawable == null) {
                return 0.0f;
            }
            return drawable.getLeftWidth();
        }
    };
    public static Value backgroundRight = new Value() {
        public float get(Actor actor) {
            Drawable drawable = ((Table) actor).background;
            if (drawable == null) {
                return 0.0f;
            }
            return drawable.getRightWidth();
        }
    };
    public static Value backgroundTop = new Value() {
        public float get(Actor actor) {
            Drawable drawable = ((Table) actor).background;
            if (drawable == null) {
                return 0.0f;
            }
            return drawable.getTopHeight();
        }
    };
    public static final Pool<Cell> cellPool = new Pool<Cell>() {
        public Object newObject() {
            return new Cell();
        }
    };
    public static float[] columnWeightedWidth;
    public static Color debugActorColor = new Color(0.0f, 1.0f, 0.0f, 1.0f);
    public static Color debugCellColor = new Color(1.0f, 0.0f, 0.0f, 1.0f);
    public static Color debugTableColor = new Color(0.0f, 0.0f, 1.0f, 1.0f);
    public static float[] rowWeightedHeight;
    public int align = 1;
    public Drawable background;
    public final Cell cellDefaults;
    public final Array<Cell> cells = new Array<>(true, 4);
    public final Array<Cell> columnDefaults = new Array<>(true, 2);
    public float[] columnMinWidth;
    public float[] columnPrefWidth;
    public float[] columnWidth;
    public int columns;
    public Debug debug = Debug.none;
    public Array<DebugRect> debugRects;
    public float[] expandHeight;
    public float[] expandWidth;
    public boolean implicitEndRow;
    public Value padBottom = backgroundBottom;
    public Value padLeft = backgroundLeft;
    public Value padRight = backgroundRight;
    public Value padTop = backgroundTop;
    public boolean round = true;
    public Cell rowDefaults;
    public float[] rowHeight;
    public float[] rowMinHeight;
    public float[] rowPrefHeight;
    public int rows;
    public boolean sizeInvalid = true;
    public float tableMinHeight;
    public float tableMinWidth;
    public float tablePrefHeight;
    public float tablePrefWidth;

    public enum Debug {
        none,
        all,
        table,
        cell,
        actor
    }

    public static class DebugRect extends Rectangle {
        public static Pool<DebugRect> pool = Pools.get(DebugRect.class);
        public Color color;
    }

    public Table() {
        Cell cell = (Cell) cellPool.obtain();
        if (cell != null) {
            this.cellDefaults = cell;
            this.transform = false;
            this.touchable = Touchable.childrenOnly;
            return;
        }
        throw null;
    }

    public <T extends Actor> Cell<T> add(T t) {
        Cell<T> cell = (Cell) cellPool.obtain();
        if (cell != null) {
            cell.actor = t;
            if (this.implicitEndRow) {
                this.implicitEndRow = false;
                this.rows--;
                ((Cell) this.cells.peek()).endRow = false;
            }
            Array<Cell> array = this.cells;
            int i = array.size;
            if (i > 0) {
                Cell cell2 = (Cell) array.peek();
                if (!cell2.endRow) {
                    cell.column = cell2.colspan.intValue() + cell2.column;
                    cell.row = cell2.row;
                } else {
                    cell.column = 0;
                    cell.row = cell2.row + 1;
                }
                if (cell.row > 0) {
                    T[] tArr = this.cells.items;
                    loop0:
                    while (true) {
                        i--;
                        if (i < 0) {
                            break;
                        }
                        Cell cell3 = (Cell) tArr[i];
                        int i2 = cell3.column;
                        int intValue = cell3.colspan.intValue() + i2;
                        while (true) {
                            if (i2 < intValue) {
                                if (i2 == cell.column) {
                                    cell.cellAboveIndex = i;
                                    break loop0;
                                }
                                i2++;
                            }
                        }
                    }
                }
            } else {
                cell.column = 0;
                cell.row = 0;
            }
            this.cells.add(cell);
            cell.set(this.cellDefaults);
            int i3 = cell.column;
            Array<Cell> array2 = this.columnDefaults;
            if (i3 < array2.size) {
                cell.merge((Cell) array2.get(i3));
            }
            cell.merge(this.rowDefaults);
            if (t != null) {
                addActor(t);
            }
            return cell;
        }
        throw null;
    }

    public final void addDebugRect(float f2, float f3, float f4, float f5, Color color) {
        DebugRect debugRect = (DebugRect) DebugRect.pool.obtain();
        debugRect.color = color;
        debugRect.set(f2, f3, f4, f5);
        this.debugRects.add(debugRect);
    }

    public void clearChildren() {
        Array<Cell> array = this.cells;
        T[] tArr = array.items;
        for (int i = array.size - 1; i >= 0; i--) {
            Actor actor = ((Cell) tArr[i]).actor;
            if (actor != null) {
                Group group = actor.parent;
                if (group != null) {
                    group.removeActor(actor, true);
                }
            }
        }
        cellPool.freeAll(this.cells);
        this.cells.clear();
        this.rows = 0;
        this.columns = 0;
        Cell cell = this.rowDefaults;
        if (cell != null) {
            cellPool.free(cell);
        }
        this.rowDefaults = null;
        this.implicitEndRow = false;
        super.clearChildren();
    }

    public final void clearDebugRects() {
        if (this.debugRects == null) {
            this.debugRects = new Array<>();
        }
        DebugRect.pool.freeAll(this.debugRects);
        this.debugRects.clear();
    }

    public final void computeSize() {
        float f2;
        this.sizeInvalid = false;
        Array<Cell> array = this.cells;
        T[] tArr = array.items;
        int i = array.size;
        if (i > 0 && !((Cell) tArr[i - 1]).endRow) {
            int i2 = 0;
            for (int i3 = i - 1; i3 >= 0; i3--) {
                Cell cell = (Cell) tArr[i3];
                if (cell.endRow) {
                    break;
                }
                i2 += cell.colspan.intValue();
            }
            this.columns = Math.max(this.columns, i2);
            this.rows++;
            ((Cell) this.cells.peek()).endRow = true;
            this.implicitEndRow = true;
        }
        int i4 = this.columns;
        int i5 = this.rows;
        float[] ensureSize = ensureSize(this.columnMinWidth, i4);
        this.columnMinWidth = ensureSize;
        float[] ensureSize2 = ensureSize(this.rowMinHeight, i5);
        this.rowMinHeight = ensureSize2;
        float[] ensureSize3 = ensureSize(this.columnPrefWidth, i4);
        this.columnPrefWidth = ensureSize3;
        float[] ensureSize4 = ensureSize(this.rowPrefHeight, i5);
        this.rowPrefHeight = ensureSize4;
        this.columnWidth = ensureSize(this.columnWidth, i4);
        this.rowHeight = ensureSize(this.rowHeight, i5);
        float[] ensureSize5 = ensureSize(this.expandWidth, i4);
        this.expandWidth = ensureSize5;
        float[] ensureSize6 = ensureSize(this.expandHeight, i5);
        this.expandHeight = ensureSize6;
        int i6 = 0;
        float f3 = 0.0f;
        while (i6 < i) {
            Cell cell2 = (Cell) tArr[i6];
            int i7 = cell2.column;
            int i8 = cell2.row;
            int i9 = i;
            int intValue = cell2.colspan.intValue();
            int i10 = i6;
            Actor actor = cell2.actor;
            float[] fArr = ensureSize2;
            if (cell2.expandY.intValue() != 0 && ensureSize6[i8] == 0.0f) {
                ensureSize6[i8] = (float) cell2.expandY.intValue();
            }
            if (intValue == 1 && cell2.expandX.intValue() != 0 && ensureSize5[i7] == 0.0f) {
                ensureSize5[i7] = (float) cell2.expandX.intValue();
            }
            float[] fArr2 = ensureSize6;
            cell2.computedPadLeft = cell2.padLeft.get(actor) + (i7 == 0 ? 0.0f : Math.max(0.0f, cell2.spaceLeft.get(actor) - f3));
            float f4 = cell2.padTop.get(actor);
            cell2.computedPadTop = f4;
            int i11 = cell2.cellAboveIndex;
            if (i11 != -1) {
                cell2.computedPadTop = Math.max(0.0f, cell2.spaceTop.get(actor) - ((Cell) tArr[i11]).spaceBottom.get(actor)) + f4;
            }
            float f5 = cell2.spaceRight.get(actor);
            cell2.computedPadRight = cell2.padRight.get(actor) + (i7 + intValue == i4 ? 0.0f : f5);
            cell2.computedPadBottom = cell2.padBottom.get(actor) + (i8 == i5 + -1 ? 0.0f : cell2.spaceBottom.get(actor));
            float f6 = cell2.prefWidth.get(actor);
            float f7 = cell2.prefHeight.get(actor);
            float f8 = f5;
            float f9 = cell2.minWidth.get(actor);
            int i12 = i5;
            float f10 = cell2.minHeight.get(actor);
            int i13 = i4;
            float f11 = cell2.maxWidth.get(actor);
            float[] fArr3 = ensureSize5;
            float f12 = cell2.maxHeight.get(actor);
            if (f6 < f9) {
                f6 = f9;
            }
            if (f7 < f10) {
                f7 = f10;
            }
            if (f11 <= 0.0f || f6 <= f11) {
                f11 = f6;
            }
            if (f12 <= 0.0f || f7 <= f12) {
                f12 = f7;
            }
            if (this.round) {
                f10 = (float) Math.ceil((double) f10);
                f11 = (float) Math.ceil((double) f11);
                f12 = (float) Math.ceil((double) f12);
                f9 = (float) Math.ceil((double) f9);
            }
            if (intValue == 1) {
                float f13 = cell2.computedPadLeft + cell2.computedPadRight;
                ensureSize3[i7] = Math.max(ensureSize3[i7], f11 + f13);
                ensureSize[i7] = Math.max(ensureSize[i7], f9 + f13);
            }
            float f14 = cell2.computedPadTop + cell2.computedPadBottom;
            ensureSize4[i8] = Math.max(ensureSize4[i8], f12 + f14);
            fArr[i8] = Math.max(fArr[i8], f10 + f14);
            i6 = i10 + 1;
            i = i9;
            ensureSize2 = fArr;
            ensureSize6 = fArr2;
            f3 = f8;
            i5 = i12;
            i4 = i13;
            ensureSize5 = fArr3;
        }
        int i14 = i4;
        int i15 = i5;
        float[] fArr4 = ensureSize2;
        float[] fArr5 = ensureSize5;
        int i16 = i;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (int i17 = 0; i17 < i16; i17++) {
            Cell cell3 = (Cell) tArr[i17];
            int i18 = cell3.column;
            int intValue2 = cell3.expandX.intValue();
            if (intValue2 != 0) {
                int intValue3 = cell3.colspan.intValue() + i18;
                int i19 = i18;
                while (true) {
                    if (i19 >= intValue3) {
                        int i20 = i18;
                        while (i20 < intValue3) {
                            fArr5[i20] = (float) intValue2;
                            i20++;
                            intValue3 = intValue3;
                        }
                    } else if (fArr5[i19] != 0.0f) {
                        break;
                    } else {
                        i19++;
                    }
                }
            }
            if (cell3.uniformX == Boolean.TRUE && cell3.colspan.intValue() == 1) {
                float f19 = cell3.computedPadLeft + cell3.computedPadRight;
                f17 = Math.max(f17, ensureSize[i18] - f19);
                f15 = Math.max(f15, ensureSize3[i18] - f19);
            }
            if (cell3.uniformY == Boolean.TRUE) {
                float f20 = cell3.computedPadTop + cell3.computedPadBottom;
                f18 = Math.max(f18, fArr4[cell3.row] - f20);
                f16 = Math.max(f16, ensureSize4[cell3.row] - f20);
            }
        }
        int i21 = (f15 > 0.0f ? 1 : (f15 == 0.0f ? 0 : -1));
        if (i21 > 0 || f16 > 0.0f) {
            for (int i22 = 0; i22 < i16; i22++) {
                Cell cell4 = (Cell) tArr[i22];
                if (i21 > 0 && cell4.uniformX == Boolean.TRUE && cell4.colspan.intValue() == 1) {
                    float f21 = cell4.computedPadLeft + cell4.computedPadRight;
                    int i23 = cell4.column;
                    ensureSize[i23] = f17 + f21;
                    ensureSize3[i23] = f21 + f15;
                }
                if (f16 > 0.0f && cell4.uniformY == Boolean.TRUE) {
                    float f22 = cell4.computedPadTop + cell4.computedPadBottom;
                    int i24 = cell4.row;
                    fArr4[i24] = f18 + f22;
                    ensureSize4[i24] = f22 + f16;
                }
            }
        }
        for (int i25 = 0; i25 < i16; i25++) {
            Cell cell5 = (Cell) tArr[i25];
            int intValue4 = cell5.colspan.intValue();
            if (intValue4 != 1) {
                int i26 = cell5.column;
                Actor actor2 = cell5.actor;
                float f23 = cell5.minWidth.get(actor2);
                float f24 = cell5.prefWidth.get(actor2);
                float f25 = cell5.maxWidth.get(actor2);
                if (f24 < f23) {
                    f24 = f23;
                }
                if (f25 <= 0.0f || f24 <= f25) {
                    f25 = f24;
                }
                if (this.round) {
                    f23 = (float) Math.ceil((double) f23);
                    f25 = (float) Math.ceil((double) f25);
                }
                float f26 = -(cell5.computedPadLeft + cell5.computedPadRight);
                int i27 = i26 + intValue4;
                float f27 = f26;
                float f28 = 0.0f;
                for (int i28 = i26; i28 < i27; i28++) {
                    f26 += ensureSize[i28];
                    f27 += ensureSize3[i28];
                    f28 += fArr5[i28];
                }
                float max = Math.max(0.0f, f23 - f26);
                float max2 = Math.max(0.0f, f25 - f27);
                while (i26 < i27) {
                    if (f28 == 0.0f) {
                        f2 = 1.0f / ((float) intValue4);
                    } else {
                        f2 = fArr5[i26] / f28;
                    }
                    ensureSize[i26] = (max * f2) + ensureSize[i26];
                    ensureSize3[i26] = (f2 * max2) + ensureSize3[i26];
                    i26++;
                }
            }
        }
        float f29 = this.padRight.get(this) + this.padLeft.get(this);
        float f30 = this.padBottom.get(this) + this.padTop.get(this);
        this.tableMinWidth = f29;
        this.tablePrefWidth = f29;
        int i29 = i14;
        for (int i30 = 0; i30 < i29; i30++) {
            this.tableMinWidth += ensureSize[i30];
            this.tablePrefWidth += ensureSize3[i30];
        }
        this.tableMinHeight = f30;
        this.tablePrefHeight = f30;
        int i31 = i15;
        for (int i32 = 0; i32 < i31; i32++) {
            this.tableMinHeight += fArr4[i32];
            this.tablePrefHeight = Math.max(fArr4[i32], ensureSize4[i32]) + this.tablePrefHeight;
        }
        this.tablePrefWidth = Math.max(this.tableMinWidth, this.tablePrefWidth);
        this.tablePrefHeight = Math.max(this.tableMinHeight, this.tablePrefHeight);
    }

    public Table debug(Debug debug2) {
        super.setDebug(debug2 != Debug.none);
        if (this.debug != debug2) {
            this.debug = debug2;
            if (debug2 == Debug.none) {
                clearDebugRects();
            } else {
                invalidate();
            }
        }
        return this;
    }

    public void draw(Batch batch, float f2) {
        validate();
        if (this.transform) {
            Matrix4 computeTransform = computeTransform();
            this.oldTransform.set(batch.getTransformMatrix());
            batch.setTransformMatrix(computeTransform);
            drawBackground(batch, f2, 0.0f, 0.0f);
            drawChildren(batch, f2);
            batch.setTransformMatrix(this.oldTransform);
            return;
        }
        drawBackground(batch, f2, this.x, this.y);
        super.draw(batch, f2);
    }

    public void drawBackground(Batch batch, float f2, float f3, float f4) {
        if (this.background != null) {
            Color color = this.color;
            batch.setColor(color.r, color.g, color.f3307b, color.f3306a * f2);
            this.background.draw(batch, f3, f4, this.width, this.height);
        }
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        if (this.transform) {
            Matrix4 computeTransform = computeTransform();
            this.oldTransform.set(shapeRenderer.getTransformMatrix());
            shapeRenderer.setTransformMatrix(computeTransform);
            shapeRenderer.flush();
            drawDebugRects(shapeRenderer);
            drawDebugChildren(shapeRenderer);
            shapeRenderer.setTransformMatrix(this.oldTransform);
            return;
        }
        drawDebugRects(shapeRenderer);
        super.drawDebug(shapeRenderer);
    }

    public void drawDebugBounds(ShapeRenderer shapeRenderer) {
    }

    public final void drawDebugRects(ShapeRenderer shapeRenderer) {
        float f2;
        if (this.debugRects != null && this.debug) {
            shapeRenderer.set(ShapeType.Line);
            Stage stage = this.stage;
            if (stage != null) {
                shapeRenderer.setColor(stage.debugColor);
            }
            float f3 = 0.0f;
            if (!this.transform) {
                f3 = this.x;
                f2 = this.y;
            } else {
                f2 = 0.0f;
            }
            int i = this.debugRects.size;
            for (int i2 = 0; i2 < i; i2++) {
                DebugRect debugRect = (DebugRect) this.debugRects.get(i2);
                shapeRenderer.setColor(debugRect.color);
                shapeRenderer.rect(debugRect.x + f3, debugRect.y + f2, debugRect.width, debugRect.height);
            }
        }
    }

    public final float[] ensureSize(float[] fArr, int i) {
        if (fArr == null || fArr.length < i) {
            return new float[i];
        }
        Arrays.fill(fArr, 0, i, 0.0f);
        return fArr;
    }

    public <T extends Actor> Cell<T> getCell(T t) {
        if (t != null) {
            Array<Cell> array = this.cells;
            T[] tArr = array.items;
            int i = array.size;
            for (int i2 = 0; i2 < i; i2++) {
                Cell<T> cell = (Cell) tArr[i2];
                if (cell.actor == t) {
                    return cell;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("actor cannot be null.");
    }

    public float getMinHeight() {
        if (this.sizeInvalid) {
            computeSize();
        }
        return this.tableMinHeight;
    }

    public float getMinWidth() {
        if (this.sizeInvalid) {
            computeSize();
        }
        return this.tableMinWidth;
    }

    public float getPrefHeight() {
        if (this.sizeInvalid) {
            computeSize();
        }
        float f2 = this.tablePrefHeight;
        Drawable drawable = this.background;
        return drawable != null ? Math.max(f2, drawable.getMinHeight()) : f2;
    }

    public float getPrefWidth() {
        if (this.sizeInvalid) {
            computeSize();
        }
        float f2 = this.tablePrefWidth;
        Drawable drawable = this.background;
        return drawable != null ? Math.max(f2, drawable.getMinWidth()) : f2;
    }

    public Actor hit(float f2, float f3, boolean z) {
        return super.hit(f2, f3, z);
    }

    public void invalidate() {
        this.sizeInvalid = true;
        this.needsLayout = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03c4  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03cc  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:221:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r30 = this;
            r6 = r30
            boolean r0 = r6.sizeInvalid
            if (r0 == 0) goto L_0x0009
            r30.computeSize()
        L_0x0009:
            float r0 = r6.width
            float r1 = r6.height
            int r2 = r6.columns
            int r3 = r6.rows
            float[] r4 = r6.columnWidth
            float[] r5 = r6.rowHeight
            com.badlogic.gdx.scenes.scene2d.ui.Value r7 = r6.padLeft
            float r7 = r7.get(r6)
            com.badlogic.gdx.scenes.scene2d.ui.Value r8 = r6.padRight
            float r8 = r8.get(r6)
            float r8 = r8 + r7
            com.badlogic.gdx.scenes.scene2d.ui.Value r9 = r6.padTop
            float r9 = r9.get(r6)
            com.badlogic.gdx.scenes.scene2d.ui.Value r10 = r6.padBottom
            float r10 = r10.get(r6)
            float r10 = r10 + r9
            float r11 = r6.tablePrefWidth
            float r12 = r6.tableMinWidth
            float r11 = r11 - r12
            r14 = 0
            int r15 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r15 != 0) goto L_0x003e
            float[] r11 = r6.columnMinWidth
            r17 = r9
            goto L_0x006d
        L_0x003e:
            float r12 = r0 - r12
            float r12 = java.lang.Math.max(r14, r12)
            float r12 = java.lang.Math.min(r11, r12)
            float[] r15 = columnWeightedWidth
            float[] r15 = r6.ensureSize(r15, r2)
            columnWeightedWidth = r15
            float[] r13 = r6.columnMinWidth
            float[] r14 = r6.columnPrefWidth
            r17 = r9
            r9 = 0
        L_0x0057:
            if (r9 >= r2) goto L_0x006c
            r18 = r14[r9]
            r19 = r13[r9]
            float r18 = r18 - r19
            float r18 = r18 / r11
            r19 = r13[r9]
            float r18 = r18 * r12
            float r18 = r18 + r19
            r15[r9] = r18
            int r9 = r9 + 1
            goto L_0x0057
        L_0x006c:
            r11 = r15
        L_0x006d:
            float r9 = r6.tablePrefHeight
            float r12 = r6.tableMinHeight
            float r9 = r9 - r12
            r12 = 0
            int r13 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r13 != 0) goto L_0x007c
            float[] r9 = r6.rowMinHeight
            r18 = r7
            goto L_0x00ad
        L_0x007c:
            float[] r13 = rowWeightedHeight
            float[] r13 = r6.ensureSize(r13, r3)
            rowWeightedHeight = r13
            float r14 = r6.tableMinHeight
            float r14 = r1 - r14
            float r14 = java.lang.Math.max(r12, r14)
            float r12 = java.lang.Math.min(r9, r14)
            float[] r14 = r6.rowMinHeight
            float[] r15 = r6.rowPrefHeight
            r18 = r7
            r7 = 0
        L_0x0097:
            if (r7 >= r3) goto L_0x00ac
            r19 = r15[r7]
            r20 = r14[r7]
            float r19 = r19 - r20
            float r19 = r19 / r9
            r20 = r14[r7]
            float r19 = r19 * r12
            float r19 = r19 + r20
            r13[r7] = r19
            int r7 = r7 + 1
            goto L_0x0097
        L_0x00ac:
            r9 = r13
        L_0x00ad:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.scenes.scene2d.ui.Cell> r7 = r6.cells
            T[] r12 = r7.items
            int r7 = r7.size
            r13 = 0
        L_0x00b4:
            if (r13 >= r7) goto L_0x0173
            r15 = r12[r13]
            com.badlogic.gdx.scenes.scene2d.ui.Cell r15 = (com.badlogic.gdx.scenes.scene2d.ui.Cell) r15
            int r14 = r15.column
            r20 = r12
            int r12 = r15.row
            r21 = r7
            com.badlogic.gdx.scenes.scene2d.Actor r7 = r15.actor
            r22 = r1
            java.lang.Integer r1 = r15.colspan
            int r1 = r1.intValue()
            r23 = r10
            int r10 = r14 + r1
            r25 = r0
            r24 = r3
            r0 = r14
            r3 = 0
        L_0x00d6:
            if (r0 >= r10) goto L_0x00df
            r26 = r11[r0]
            float r3 = r3 + r26
            int r0 = r0 + 1
            goto L_0x00d6
        L_0x00df:
            r0 = r9[r12]
            com.badlogic.gdx.scenes.scene2d.ui.Value r10 = r15.prefWidth
            float r10 = r10.get(r7)
            r26 = r9
            com.badlogic.gdx.scenes.scene2d.ui.Value r9 = r15.prefHeight
            float r9 = r9.get(r7)
            r27 = r11
            com.badlogic.gdx.scenes.scene2d.ui.Value r11 = r15.minWidth
            float r11 = r11.get(r7)
            r28 = r8
            com.badlogic.gdx.scenes.scene2d.ui.Value r8 = r15.minHeight
            float r8 = r8.get(r7)
            r29 = r2
            com.badlogic.gdx.scenes.scene2d.ui.Value r2 = r15.maxWidth
            float r2 = r2.get(r7)
            com.badlogic.gdx.scenes.scene2d.ui.Value r6 = r15.maxHeight
            float r6 = r6.get(r7)
            int r7 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r7 >= 0) goto L_0x0112
            r10 = r11
        L_0x0112:
            int r7 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x0117
            r9 = r8
        L_0x0117:
            r7 = 0
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x0121
            int r8 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0121
            goto L_0x0122
        L_0x0121:
            r2 = r10
        L_0x0122:
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x012b
            int r7 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x012b
            goto L_0x012c
        L_0x012b:
            r6 = r9
        L_0x012c:
            float r7 = r15.computedPadLeft
            float r7 = r3 - r7
            float r8 = r15.computedPadRight
            float r7 = r7 - r8
            float r2 = java.lang.Math.min(r7, r2)
            r15.actorWidth = r2
            float r2 = r15.computedPadTop
            float r2 = r0 - r2
            float r7 = r15.computedPadBottom
            float r2 = r2 - r7
            float r2 = java.lang.Math.min(r2, r6)
            r15.actorHeight = r2
            r2 = 1
            if (r1 != r2) goto L_0x0151
            r1 = r4[r14]
            float r1 = java.lang.Math.max(r1, r3)
            r4[r14] = r1
        L_0x0151:
            r1 = r5[r12]
            float r0 = java.lang.Math.max(r1, r0)
            r5[r12] = r0
            int r13 = r13 + 1
            r6 = r30
            r12 = r20
            r7 = r21
            r1 = r22
            r10 = r23
            r3 = r24
            r0 = r25
            r9 = r26
            r11 = r27
            r8 = r28
            r2 = r29
            goto L_0x00b4
        L_0x0173:
            r25 = r0
            r22 = r1
            r29 = r2
            r24 = r3
            r21 = r7
            r28 = r8
            r23 = r10
            r27 = r11
            r20 = r12
            float[] r0 = r6.expandWidth
            float[] r1 = r6.expandHeight
            r3 = r29
            r2 = 0
            r7 = 0
        L_0x018d:
            if (r7 >= r3) goto L_0x0195
            r8 = r0[r7]
            float r2 = r2 + r8
            int r7 = r7 + 1
            goto L_0x018d
        L_0x0195:
            r16 = 0
            int r7 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r7 <= 0) goto L_0x01cd
            float r7 = r25 - r28
            r8 = 0
        L_0x019e:
            if (r8 >= r3) goto L_0x01a6
            r9 = r4[r8]
            float r7 = r7 - r9
            int r8 = r8 + 1
            goto L_0x019e
        L_0x01a6:
            int r8 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x01cd
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x01ad:
            if (r9 >= r3) goto L_0x01c7
            r11 = r0[r9]
            int r11 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r11 != 0) goto L_0x01b6
            goto L_0x01c2
        L_0x01b6:
            r10 = r0[r9]
            float r10 = r10 * r7
            float r10 = r10 / r2
            r11 = r4[r9]
            float r11 = r11 + r10
            r4[r9] = r11
            float r8 = r8 + r10
            r10 = r9
        L_0x01c2:
            int r9 = r9 + 1
            r16 = 0
            goto L_0x01ad
        L_0x01c7:
            r0 = r4[r10]
            float r7 = r7 - r8
            float r7 = r7 + r0
            r4[r10] = r7
        L_0x01cd:
            r2 = r24
            r0 = 0
            r7 = 0
        L_0x01d1:
            if (r7 >= r2) goto L_0x01d9
            r8 = r1[r7]
            float r0 = r0 + r8
            int r7 = r7 + 1
            goto L_0x01d1
        L_0x01d9:
            r16 = 0
            int r7 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r7 <= 0) goto L_0x0211
            float r7 = r22 - r23
            r8 = 0
        L_0x01e2:
            if (r8 >= r2) goto L_0x01ea
            r9 = r5[r8]
            float r7 = r7 - r9
            int r8 = r8 + 1
            goto L_0x01e2
        L_0x01ea:
            int r8 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0211
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x01f1:
            if (r9 >= r2) goto L_0x020b
            r11 = r1[r9]
            int r11 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r11 != 0) goto L_0x01fa
            goto L_0x0206
        L_0x01fa:
            r10 = r1[r9]
            float r10 = r10 * r7
            float r10 = r10 / r0
            r11 = r5[r9]
            float r11 = r11 + r10
            r5[r9] = r11
            float r8 = r8 + r10
            r10 = r9
        L_0x0206:
            int r9 = r9 + 1
            r16 = 0
            goto L_0x01f1
        L_0x020b:
            r0 = r5[r10]
            float r7 = r7 - r8
            float r7 = r7 + r0
            r5[r10] = r7
        L_0x0211:
            r0 = r21
            r1 = 0
        L_0x0214:
            if (r1 >= r0) goto L_0x0255
            r7 = r20[r1]
            com.badlogic.gdx.scenes.scene2d.ui.Cell r7 = (com.badlogic.gdx.scenes.scene2d.ui.Cell) r7
            java.lang.Integer r8 = r7.colspan
            int r8 = r8.intValue()
            r9 = 1
            if (r8 != r9) goto L_0x0224
            goto L_0x0252
        L_0x0224:
            int r10 = r7.column
            int r11 = r10 + r8
            r12 = 0
        L_0x0229:
            if (r10 >= r11) goto L_0x0234
            r13 = r27[r10]
            r14 = r4[r10]
            float r13 = r13 - r14
            float r12 = r12 + r13
            int r10 = r10 + 1
            goto L_0x0229
        L_0x0234:
            float r10 = r7.computedPadLeft
            float r11 = r7.computedPadRight
            float r10 = r10 + r11
            r11 = 0
            float r10 = java.lang.Math.max(r11, r10)
            float r12 = r12 - r10
            float r10 = (float) r8
            float r12 = r12 / r10
            int r10 = (r12 > r11 ? 1 : (r12 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x0252
            int r7 = r7.column
            int r8 = r8 + r7
        L_0x0248:
            if (r7 >= r8) goto L_0x0252
            r10 = r4[r7]
            float r10 = r10 + r12
            r4[r7] = r10
            int r7 = r7 + 1
            goto L_0x0248
        L_0x0252:
            int r1 = r1 + 1
            goto L_0x0214
        L_0x0255:
            r7 = r28
            r1 = 0
        L_0x0258:
            if (r1 >= r3) goto L_0x0260
            r8 = r4[r1]
            float r7 = r7 + r8
            int r1 = r1 + 1
            goto L_0x0258
        L_0x0260:
            r3 = r23
            r1 = 0
        L_0x0263:
            if (r1 >= r2) goto L_0x026b
            r8 = r5[r1]
            float r3 = r3 + r8
            int r1 = r1 + 1
            goto L_0x0263
        L_0x026b:
            int r1 = r6.align
            r2 = r1 & 16
            r8 = 1073741824(0x40000000, float:2.0)
            if (r2 == 0) goto L_0x027a
            float r2 = r25 - r7
        L_0x0275:
            float r2 = r2 + r18
            r18 = r2
            goto L_0x0282
        L_0x027a:
            r2 = r1 & 8
            if (r2 != 0) goto L_0x0282
            float r2 = r25 - r7
            float r2 = r2 / r8
            goto L_0x0275
        L_0x0282:
            r2 = r1 & 4
            if (r2 == 0) goto L_0x028b
            float r1 = r22 - r3
        L_0x0288:
            float r9 = r1 + r17
            goto L_0x0295
        L_0x028b:
            r1 = r1 & 2
            if (r1 != 0) goto L_0x0293
            float r1 = r22 - r3
            float r1 = r1 / r8
            goto L_0x0288
        L_0x0293:
            r9 = r17
        L_0x0295:
            r10 = r9
            r2 = r18
            r1 = 0
        L_0x0299:
            if (r1 >= r0) goto L_0x03d9
            r11 = r20[r1]
            com.badlogic.gdx.scenes.scene2d.ui.Cell r11 = (com.badlogic.gdx.scenes.scene2d.ui.Cell) r11
            int r12 = r11.column
            java.lang.Integer r13 = r11.colspan
            int r13 = r13.intValue()
            int r13 = r13 + r12
            r14 = 0
        L_0x02a9:
            if (r12 >= r13) goto L_0x02b1
            r15 = r4[r12]
            float r14 = r14 + r15
            int r12 = r12 + 1
            goto L_0x02a9
        L_0x02b1:
            float r12 = r11.computedPadLeft
            float r13 = r11.computedPadRight
            float r13 = r13 + r12
            float r14 = r14 - r13
            float r2 = r2 + r12
            java.lang.Float r12 = r11.fillX
            float r12 = r12.floatValue()
            java.lang.Float r13 = r11.fillY
            float r13 = r13.floatValue()
            r15 = 0
            int r16 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r16 <= 0) goto L_0x02ef
            float r12 = r12 * r14
            com.badlogic.gdx.scenes.scene2d.ui.Value r8 = r11.minWidth
            com.badlogic.gdx.scenes.scene2d.Actor r15 = r11.actor
            float r8 = r8.get(r15)
            float r8 = java.lang.Math.max(r12, r8)
            r11.actorWidth = r8
            com.badlogic.gdx.scenes.scene2d.ui.Value r8 = r11.maxWidth
            com.badlogic.gdx.scenes.scene2d.Actor r12 = r11.actor
            float r8 = r8.get(r12)
            r12 = 0
            int r15 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x02f0
            float r15 = r11.actorWidth
            float r8 = java.lang.Math.min(r15, r8)
            r11.actorWidth = r8
            goto L_0x02f0
        L_0x02ef:
            r12 = 0
        L_0x02f0:
            int r8 = (r13 > r12 ? 1 : (r13 == r12 ? 0 : -1))
            if (r8 <= 0) goto L_0x0324
            int r8 = r11.row
            r8 = r5[r8]
            float r8 = r8 * r13
            float r12 = r11.computedPadTop
            float r8 = r8 - r12
            float r12 = r11.computedPadBottom
            float r8 = r8 - r12
            com.badlogic.gdx.scenes.scene2d.ui.Value r12 = r11.minHeight
            com.badlogic.gdx.scenes.scene2d.Actor r13 = r11.actor
            float r12 = r12.get(r13)
            float r8 = java.lang.Math.max(r8, r12)
            r11.actorHeight = r8
            com.badlogic.gdx.scenes.scene2d.ui.Value r8 = r11.maxHeight
            com.badlogic.gdx.scenes.scene2d.Actor r12 = r11.actor
            float r8 = r8.get(r12)
            r12 = 0
            int r13 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r13 <= 0) goto L_0x0325
            float r13 = r11.actorHeight
            float r8 = java.lang.Math.min(r13, r8)
            r11.actorHeight = r8
            goto L_0x0325
        L_0x0324:
            r12 = 0
        L_0x0325:
            java.lang.Integer r8 = r11.align
            int r8 = r8.intValue()
            r13 = r8 & 8
            if (r13 == 0) goto L_0x0332
            r11.actorX = r2
            goto L_0x0348
        L_0x0332:
            r13 = r8 & 16
            if (r13 == 0) goto L_0x033e
            float r13 = r2 + r14
            float r15 = r11.actorWidth
            float r13 = r13 - r15
            r11.actorX = r13
            goto L_0x0348
        L_0x033e:
            float r13 = r11.actorWidth
            float r13 = r14 - r13
            r15 = 1073741824(0x40000000, float:2.0)
            float r13 = r13 / r15
            float r13 = r13 + r2
            r11.actorX = r13
        L_0x0348:
            r13 = r8 & 2
            if (r13 == 0) goto L_0x0353
            float r8 = r11.computedPadTop
            r11.actorY = r8
        L_0x0350:
            r13 = 1073741824(0x40000000, float:2.0)
            goto L_0x0376
        L_0x0353:
            r8 = r8 & 4
            if (r8 == 0) goto L_0x0364
            int r8 = r11.row
            r8 = r5[r8]
            float r13 = r11.actorHeight
            float r8 = r8 - r13
            float r13 = r11.computedPadBottom
            float r8 = r8 - r13
            r11.actorY = r8
            goto L_0x0350
        L_0x0364:
            int r8 = r11.row
            r8 = r5[r8]
            float r13 = r11.actorHeight
            float r8 = r8 - r13
            float r13 = r11.computedPadTop
            float r8 = r8 + r13
            float r13 = r11.computedPadBottom
            float r8 = r8 - r13
            r13 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r13
            r11.actorY = r8
        L_0x0376:
            float r8 = r22 - r10
            float r15 = r11.actorY
            float r8 = r8 - r15
            float r15 = r11.actorHeight
            float r8 = r8 - r15
            r11.actorY = r8
            boolean r8 = r6.round
            if (r8 == 0) goto L_0x03ac
            float r8 = r11.actorWidth
            double r12 = (double) r8
            double r12 = java.lang.Math.ceil(r12)
            float r8 = (float) r12
            r11.actorWidth = r8
            float r8 = r11.actorHeight
            double r12 = (double) r8
            double r12 = java.lang.Math.ceil(r12)
            float r8 = (float) r12
            r11.actorHeight = r8
            float r8 = r11.actorX
            double r12 = (double) r8
            double r12 = java.lang.Math.floor(r12)
            float r8 = (float) r12
            r11.actorX = r8
            float r8 = r11.actorY
            double r12 = (double) r8
            double r12 = java.lang.Math.floor(r12)
            float r8 = (float) r12
            r11.actorY = r8
        L_0x03ac:
            com.badlogic.gdx.scenes.scene2d.Actor r8 = r11.actor
            if (r8 == 0) goto L_0x03be
            float r12 = r11.actorX
            float r13 = r11.actorY
            float r15 = r11.actorWidth
            r21 = r0
            float r0 = r11.actorHeight
            r8.setBounds(r12, r13, r15, r0)
            goto L_0x03c0
        L_0x03be:
            r21 = r0
        L_0x03c0:
            boolean r0 = r11.endRow
            if (r0 == 0) goto L_0x03cc
            int r0 = r11.row
            r0 = r5[r0]
            float r10 = r10 + r0
            r2 = r18
            goto L_0x03d1
        L_0x03cc:
            float r0 = r11.computedPadRight
            float r14 = r14 + r0
            float r14 = r14 + r2
            r2 = r14
        L_0x03d1:
            int r1 = r1 + 1
            r0 = r21
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x0299
        L_0x03d9:
            com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> r0 = r6.children
            T[] r1 = r0.items
            com.badlogic.gdx.scenes.scene2d.Actor[] r1 = (com.badlogic.gdx.scenes.scene2d.Actor[]) r1
            int r0 = r0.size
            r2 = 0
        L_0x03e2:
            if (r2 >= r0) goto L_0x03f2
            r4 = r1[r2]
            boolean r5 = r4 instanceof com.badlogic.gdx.scenes.scene2d.utils.Layout
            if (r5 == 0) goto L_0x03ef
            com.badlogic.gdx.scenes.scene2d.utils.Layout r4 = (com.badlogic.gdx.scenes.scene2d.utils.Layout) r4
            r4.validate()
        L_0x03ef:
            int r2 = r2 + 1
            goto L_0x03e2
        L_0x03f2:
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r0 = r6.debug
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r1 = com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.none
            if (r0 == r1) goto L_0x049e
            float r7 = r7 - r28
            float r8 = r3 - r23
            r30.clearDebugRects()
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r0 = r6.debug
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r1 = com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.table
            if (r0 == r1) goto L_0x0409
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r1 = com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.all
            if (r0 != r1) goto L_0x0420
        L_0x0409:
            r1 = 0
            r2 = 0
            float r3 = r6.width
            float r4 = r6.height
            com.badlogic.gdx.graphics.Color r5 = debugTableColor
            r0 = r30
            r0.addDebugRect(r1, r2, r3, r4, r5)
            com.badlogic.gdx.graphics.Color r5 = debugTableColor
            r1 = r18
            r2 = r9
            r3 = r7
            r4 = r8
            r0.addDebugRect(r1, r2, r3, r4, r5)
        L_0x0420:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.scenes.scene2d.ui.Cell> r0 = r6.cells
            int r7 = r0.size
            r8 = r18
            r13 = 0
        L_0x0427:
            if (r13 >= r7) goto L_0x049e
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.scenes.scene2d.ui.Cell> r0 = r6.cells
            java.lang.Object r0 = r0.get(r13)
            r10 = r0
            com.badlogic.gdx.scenes.scene2d.ui.Cell r10 = (com.badlogic.gdx.scenes.scene2d.ui.Cell) r10
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r0 = r6.debug
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r1 = com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.actor
            if (r0 == r1) goto L_0x043c
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r1 = com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.all
            if (r0 != r1) goto L_0x044b
        L_0x043c:
            float r1 = r10.actorX
            float r2 = r10.actorY
            float r3 = r10.actorWidth
            float r4 = r10.actorHeight
            com.badlogic.gdx.graphics.Color r5 = debugActorColor
            r0 = r30
            r0.addDebugRect(r1, r2, r3, r4, r5)
        L_0x044b:
            int r0 = r10.column
            java.lang.Integer r1 = r10.colspan
            int r1 = r1.intValue()
            int r1 = r1 + r0
            r12 = 0
        L_0x0455:
            if (r0 >= r1) goto L_0x045f
            float[] r2 = r6.columnWidth
            r2 = r2[r0]
            float r12 = r12 + r2
            int r0 = r0 + 1
            goto L_0x0455
        L_0x045f:
            float r0 = r10.computedPadLeft
            float r1 = r10.computedPadRight
            float r1 = r1 + r0
            float r12 = r12 - r1
            float r8 = r8 + r0
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r0 = r6.debug
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r1 = com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.cell
            if (r0 == r1) goto L_0x0470
            com.badlogic.gdx.scenes.scene2d.ui.Table$Debug r1 = com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.all
            if (r0 != r1) goto L_0x0488
        L_0x0470:
            float r0 = r10.computedPadTop
            float r2 = r9 + r0
            float[] r1 = r6.rowHeight
            int r3 = r10.row
            r1 = r1[r3]
            float r1 = r1 - r0
            float r0 = r10.computedPadBottom
            float r4 = r1 - r0
            com.badlogic.gdx.graphics.Color r5 = debugCellColor
            r0 = r30
            r1 = r8
            r3 = r12
            r0.addDebugRect(r1, r2, r3, r4, r5)
        L_0x0488:
            boolean r0 = r10.endRow
            if (r0 == 0) goto L_0x0496
            float[] r0 = r6.rowHeight
            int r1 = r10.row
            r0 = r0[r1]
            float r9 = r9 + r0
            r8 = r18
            goto L_0x049b
        L_0x0496:
            float r0 = r10.computedPadRight
            float r12 = r12 + r0
            float r12 = r12 + r8
            r8 = r12
        L_0x049b:
            int r13 = r13 + 1
            goto L_0x0427
        L_0x049e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.scenes.scene2d.ui.Table.layout():void");
    }

    public boolean removeActor(Actor actor) {
        return removeActor(actor, true);
    }

    public Actor removeActorAt(int i, boolean z) {
        Actor removeActorAt = super.removeActorAt(i, z);
        Cell cell = getCell(removeActorAt);
        if (cell != null) {
            cell.actor = null;
        }
        return removeActorAt;
    }

    public void setBackground(Drawable drawable) {
        if (this.background != drawable) {
            float f2 = this.padTop.get(this);
            float f3 = this.padLeft.get(this);
            float f4 = this.padBottom.get(this);
            float f5 = this.padRight.get(this);
            this.background = drawable;
            float f6 = this.padTop.get(this);
            float f7 = this.padLeft.get(this);
            float f8 = this.padBottom.get(this);
            float f9 = this.padRight.get(this);
            if (f2 + f4 != f6 + f8 || f3 + f5 != f7 + f9) {
                invalidateHierarchy();
            } else if (!(f2 == f6 && f3 == f7 && f4 == f8 && f5 == f9)) {
                invalidate();
            }
        }
    }

    public void setDebug(boolean z) {
        debug(z ? Debug.all : Debug.none);
    }

    public boolean removeActor(Actor actor, boolean z) {
        if (!super.removeActor(actor, z)) {
            return false;
        }
        Cell cell = getCell(actor);
        if (cell != null) {
            cell.actor = null;
        }
        return true;
    }
}
