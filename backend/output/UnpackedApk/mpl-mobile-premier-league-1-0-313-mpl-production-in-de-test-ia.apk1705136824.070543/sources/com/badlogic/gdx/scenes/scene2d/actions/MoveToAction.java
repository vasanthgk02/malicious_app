package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class MoveToAction extends TemporalAction {
    public int alignment = 12;
    public float endX;
    public float endY;
    public float startX;
    public float startY;

    public void begin() {
        Actor actor = this.target;
        int i = this.alignment;
        float f2 = actor.x;
        if ((i & 16) != 0) {
            f2 += actor.width;
        } else if ((i & 8) == 0) {
            f2 += actor.width / 2.0f;
        }
        this.startX = f2;
        Actor actor2 = this.target;
        int i2 = this.alignment;
        float f3 = actor2.y;
        if ((i2 & 2) != 0) {
            f3 += actor2.height;
        } else if ((i2 & 4) == 0) {
            f3 += actor2.height / 2.0f;
        }
        this.startY = f3;
    }

    public void reset() {
        super.reset();
        this.alignment = 12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(float r7) {
        /*
            r6 = this;
            r0 = 0
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x000a
            float r7 = r6.startX
            float r0 = r6.startY
            goto L_0x0028
        L_0x000a:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0015
            float r7 = r6.endX
            float r0 = r6.endY
            goto L_0x0028
        L_0x0015:
            float r0 = r6.startX
            float r1 = r6.endX
            float r0 = com.android.tools.r8.GeneratedOutlineSupport.outline3(r1, r0, r7, r0)
            float r1 = r6.startY
            float r2 = r6.endY
            float r7 = com.android.tools.r8.GeneratedOutlineSupport.outline3(r2, r1, r7, r1)
            r5 = r0
            r0 = r7
            r7 = r5
        L_0x0028:
            com.badlogic.gdx.scenes.scene2d.Actor r1 = r6.target
            int r2 = r6.alignment
            r3 = r2 & 16
            r4 = 1073741824(0x40000000, float:2.0)
            if (r3 == 0) goto L_0x0035
            float r3 = r1.width
            goto L_0x003c
        L_0x0035:
            r3 = r2 & 8
            if (r3 != 0) goto L_0x003d
            float r3 = r1.width
            float r3 = r3 / r4
        L_0x003c:
            float r7 = r7 - r3
        L_0x003d:
            r3 = r2 & 2
            if (r3 == 0) goto L_0x0044
            float r2 = r1.height
            goto L_0x004b
        L_0x0044:
            r2 = r2 & 4
            if (r2 != 0) goto L_0x004c
            float r2 = r1.height
            float r2 = r2 / r4
        L_0x004b:
            float r0 = r0 - r2
        L_0x004c:
            float r2 = r1.x
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x0058
            float r2 = r1.y
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x005c
        L_0x0058:
            r1.x = r7
            r1.y = r0
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.scenes.scene2d.actions.MoveToAction.update(float):void");
    }
}
