package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.SnapshotArray;

public class HorizontalGroup extends WidgetGroup {
    public int align = 8;
    public float fill;
    public float prefHeight;
    public float prefWidth;
    public boolean round = true;
    public boolean sizeInvalid = true;
    public float space;

    public HorizontalGroup() {
        this.touchable = Touchable.childrenOnly;
    }

    public final void computeSize() {
        this.sizeInvalid = false;
        SnapshotArray<Actor> snapshotArray = this.children;
        int i = snapshotArray.size;
        this.prefHeight = 0.0f;
        this.prefWidth = (this.space * ((float) (i - 1))) + 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            Actor actor = (Actor) snapshotArray.get(i2);
            if (actor instanceof Layout) {
                Layout layout = (Layout) actor;
                this.prefWidth = layout.getPrefWidth() + this.prefWidth;
                this.prefHeight = Math.max(this.prefHeight, layout.getPrefHeight());
            } else {
                this.prefWidth += actor.width;
                this.prefHeight = Math.max(this.prefHeight, actor.height);
            }
        }
        this.prefHeight += 0.0f;
        if (this.round) {
            this.prefWidth = (float) Math.round(this.prefWidth);
            this.prefHeight = (float) Math.round(this.prefHeight);
        }
    }

    public void drawDebugBounds(ShapeRenderer shapeRenderer) {
        super.drawDebugBounds(shapeRenderer);
        if (this.debug) {
            shapeRenderer.set(ShapeType.Line);
            Stage stage = this.stage;
            if (stage != null) {
                shapeRenderer.setColor(stage.debugColor);
            }
            shapeRenderer.rect(this.x + 0.0f, this.y + 0.0f, this.originX, this.originY, (this.width - 0.0f) - 0.0f, (this.height - 0.0f) - 0.0f, this.scaleX, this.scaleY, this.rotation);
        }
    }

    public float getPrefHeight() {
        if (this.sizeInvalid) {
            computeSize();
        }
        return this.prefHeight;
    }

    public float getPrefWidth() {
        if (this.sizeInvalid) {
            computeSize();
        }
        return this.prefWidth;
    }

    public void invalidate() {
        this.needsLayout = true;
        this.sizeInvalid = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r18 = this;
            r0 = r18
            boolean r1 = r0.sizeInvalid
            if (r1 == 0) goto L_0x0009
            r18.computeSize()
        L_0x0009:
            boolean r1 = r0.round
            int r2 = r0.align
            float r3 = r0.space
            float r4 = r0.fill
            float r5 = r0.prefHeight
            r6 = 0
            float r5 = r5 - r6
            float r5 = r5 - r6
            r7 = r2 & 16
            r8 = 1073741824(0x40000000, float:2.0)
            if (r7 == 0) goto L_0x0023
            float r7 = r0.width
            float r9 = r0.prefWidth
            float r7 = r7 - r9
        L_0x0021:
            float r7 = r7 + r6
            goto L_0x002f
        L_0x0023:
            r7 = r2 & 8
            if (r7 != 0) goto L_0x002e
            float r7 = r0.width
            float r9 = r0.prefWidth
            float r7 = r7 - r9
            float r7 = r7 / r8
            goto L_0x0021
        L_0x002e:
            r7 = 0
        L_0x002f:
            r9 = r2 & 4
            if (r9 == 0) goto L_0x0035
            r2 = 0
            goto L_0x0045
        L_0x0035:
            r2 = r2 & 2
            if (r2 == 0) goto L_0x003e
            float r2 = r0.height
            float r2 = r2 - r6
            float r2 = r2 - r5
            goto L_0x0045
        L_0x003e:
            float r2 = r0.height
            float r2 = r2 - r6
            float r2 = r2 - r6
            float r2 = r2 - r5
            float r2 = r2 / r8
            float r2 = r2 + r6
        L_0x0045:
            com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> r9 = r0.children
            int r10 = r9.size
            r11 = 0
        L_0x004a:
            if (r11 == r10) goto L_0x00b7
            java.lang.Object r12 = r9.get(r11)
            com.badlogic.gdx.scenes.scene2d.Actor r12 = (com.badlogic.gdx.scenes.scene2d.Actor) r12
            r13 = 0
            boolean r14 = r12 instanceof com.badlogic.gdx.scenes.scene2d.utils.Layout
            if (r14 == 0) goto L_0x0063
            r13 = r12
            com.badlogic.gdx.scenes.scene2d.utils.Layout r13 = (com.badlogic.gdx.scenes.scene2d.utils.Layout) r13
            float r14 = r13.getPrefWidth()
            float r15 = r13.getPrefHeight()
            goto L_0x0067
        L_0x0063:
            float r14 = r12.width
            float r15 = r12.height
        L_0x0067:
            int r16 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r16 <= 0) goto L_0x006d
            float r15 = r5 * r4
        L_0x006d:
            if (r13 == 0) goto L_0x0084
            float r8 = r13.getMinHeight()
            float r15 = java.lang.Math.max(r15, r8)
            float r8 = r13.getMaxHeight()
            int r17 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r17 <= 0) goto L_0x0084
            int r17 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r17 <= 0) goto L_0x0084
            r15 = r8
        L_0x0084:
            float r8 = r5 - r15
            r16 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r16
            float r8 = r8 + r2
            if (r1 == 0) goto L_0x00a5
            int r6 = java.lang.Math.round(r7)
            float r6 = (float) r6
            int r8 = java.lang.Math.round(r8)
            float r8 = (float) r8
            int r0 = java.lang.Math.round(r14)
            float r0 = (float) r0
            int r15 = java.lang.Math.round(r15)
            float r15 = (float) r15
            r12.setBounds(r6, r8, r0, r15)
            goto L_0x00a8
        L_0x00a5:
            r12.setBounds(r7, r8, r14, r15)
        L_0x00a8:
            float r14 = r14 + r3
            float r7 = r7 + r14
            if (r13 == 0) goto L_0x00af
            r13.validate()
        L_0x00af:
            int r11 = r11 + 1
            r0 = r18
            r6 = 0
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x004a
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup.layout():void");
    }
}
