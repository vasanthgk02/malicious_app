package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class Animation<T> {
    public float animationDuration;
    public float frameDuration;
    public T[] keyFrames;
    public int lastFrameNumber;
    public float lastStateTime;
    public PlayMode playMode;

    /* renamed from: com.badlogic.gdx.graphics.g2d.Animation$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$badlogic$gdx$graphics$g2d$Animation$PlayMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|(2:7|8)|9|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0025 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.badlogic.gdx.graphics.g2d.Animation$PlayMode[] r0 = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$badlogic$gdx$graphics$g2d$Animation$PlayMode = r0
                r1 = 1
                com.badlogic.gdx.graphics.g2d.Animation$PlayMode r2 = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.NORMAL     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$badlogic$gdx$graphics$g2d$Animation$PlayMode     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.badlogic.gdx.graphics.g2d.Animation$PlayMode r2 = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r0 = 3
                r2 = 4
                int[] r3 = $SwitchMap$com$badlogic$gdx$graphics$g2d$Animation$PlayMode     // Catch:{ NoSuchFieldError -> 0x001e }
                com.badlogic.gdx.graphics.g2d.Animation$PlayMode r4 = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP_PINGPONG     // Catch:{ NoSuchFieldError -> 0x001e }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                r3 = 5
                int[] r4 = $SwitchMap$com$badlogic$gdx$graphics$g2d$Animation$PlayMode     // Catch:{ NoSuchFieldError -> 0x0025 }
                com.badlogic.gdx.graphics.g2d.Animation$PlayMode r5 = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP_RANDOM     // Catch:{ NoSuchFieldError -> 0x0025 }
                r4[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0025 }
            L_0x0025:
                int[] r2 = $SwitchMap$com$badlogic$gdx$graphics$g2d$Animation$PlayMode     // Catch:{ NoSuchFieldError -> 0x002b }
                com.badlogic.gdx.graphics.g2d.Animation$PlayMode r4 = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.REVERSED     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r1] = r3     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r1 = $SwitchMap$com$badlogic$gdx$graphics$g2d$Animation$PlayMode     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.badlogic.gdx.graphics.g2d.Animation$PlayMode r2 = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP_REVERSED     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 6
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.Animation.AnonymousClass1.<clinit>():void");
        }
    }

    public enum PlayMode {
        NORMAL,
        REVERSED,
        LOOP,
        LOOP_REVERSED,
        LOOP_PINGPONG,
        LOOP_RANDOM
    }

    public Animation(float f2, Array<? extends T> array) {
        this.playMode = PlayMode.NORMAL;
        this.frameDuration = f2;
        Object[] objArr = (Object[]) java.lang.reflect.Array.newInstance(array.items.getClass().getComponentType(), array.size);
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = array.get(i2);
        }
        setKeyFrames(objArr);
    }

    public float getAnimationDuration() {
        return this.animationDuration;
    }

    public float getFrameDuration() {
        return this.frameDuration;
    }

    public T getKeyFrame(float f2, boolean z) {
        PlayMode playMode2 = this.playMode;
        if (!z || !(playMode2 == PlayMode.NORMAL || playMode2 == PlayMode.REVERSED)) {
            if (!z) {
                PlayMode playMode3 = this.playMode;
                if (!(playMode3 == PlayMode.NORMAL || playMode3 == PlayMode.REVERSED)) {
                    if (playMode3 == PlayMode.LOOP_REVERSED) {
                        this.playMode = PlayMode.REVERSED;
                    } else {
                        this.playMode = PlayMode.LOOP;
                    }
                }
            }
        } else if (this.playMode == PlayMode.NORMAL) {
            this.playMode = PlayMode.LOOP;
        } else {
            this.playMode = PlayMode.LOOP_REVERSED;
        }
        T keyFrame = getKeyFrame(f2);
        this.playMode = playMode2;
        return keyFrame;
    }

    public int getKeyFrameIndex(float f2) {
        if (this.keyFrames.length == 1) {
            return 0;
        }
        int i = (int) (f2 / this.frameDuration);
        int ordinal = this.playMode.ordinal();
        if (ordinal == 0) {
            i = Math.min(this.keyFrames.length - 1, i);
        } else if (ordinal == 1) {
            i = Math.max((this.keyFrames.length - i) - 1, 0);
        } else if (ordinal == 2) {
            i %= this.keyFrames.length;
        } else if (ordinal == 3) {
            T[] tArr = this.keyFrames;
            i = (tArr.length - (i % tArr.length)) - 1;
        } else if (ordinal == 4) {
            T[] tArr2 = this.keyFrames;
            i %= (tArr2.length * 2) - 2;
            if (i >= tArr2.length) {
                i = (tArr2.length - 2) - (i - tArr2.length);
            }
        } else if (ordinal == 5) {
            if (((int) (this.lastStateTime / this.frameDuration)) != i) {
                i = MathUtils.random(this.keyFrames.length - 1);
            } else {
                i = this.lastFrameNumber;
            }
        }
        this.lastFrameNumber = i;
        this.lastStateTime = f2;
        return i;
    }

    public T[] getKeyFrames() {
        return this.keyFrames;
    }

    public PlayMode getPlayMode() {
        return this.playMode;
    }

    public boolean isAnimationFinished(float f2) {
        return this.keyFrames.length - 1 < ((int) (f2 / this.frameDuration));
    }

    public void setFrameDuration(float f2) {
        this.frameDuration = f2;
        this.animationDuration = ((float) this.keyFrames.length) * f2;
    }

    public void setKeyFrames(T... tArr) {
        this.keyFrames = tArr;
        this.animationDuration = ((float) tArr.length) * this.frameDuration;
    }

    public void setPlayMode(PlayMode playMode2) {
        this.playMode = playMode2;
    }

    public Animation(float f2, Array<? extends T> array, PlayMode playMode2) {
        this(f2, array);
        setPlayMode(playMode2);
    }

    public T getKeyFrame(float f2) {
        return this.keyFrames[getKeyFrameIndex(f2)];
    }

    public Animation(float f2, T... tArr) {
        this.playMode = PlayMode.NORMAL;
        this.frameDuration = f2;
        setKeyFrames(tArr);
    }
}
