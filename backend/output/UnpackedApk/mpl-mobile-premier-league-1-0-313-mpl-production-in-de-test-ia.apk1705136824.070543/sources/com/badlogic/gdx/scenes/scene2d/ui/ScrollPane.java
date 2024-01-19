package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;

public class ScrollPane extends WidgetGroup {
    public float amountX;
    public float amountY;
    public boolean cancelTouchFocus = true;
    public boolean clamp = true;
    public boolean disableX;
    public boolean disableY;
    public int draggingPointer = -1;
    public float fadeAlpha;
    public float fadeAlphaSeconds = 1.0f;
    public float fadeDelay;
    public float fadeDelaySeconds = 1.0f;
    public boolean fadeScrollBars = true;
    public boolean flickScroll = true;
    public ActorGestureListener flickScrollListener;
    public float flingTime = 1.0f;
    public float flingTimer;
    public final Rectangle hKnobBounds = new Rectangle();
    public final Rectangle hScrollBounds = new Rectangle();
    public boolean hScrollOnBottom = true;
    public final Vector2 lastPoint = new Vector2();
    public float maxX;
    public float maxY;
    public float overscrollDistance = 50.0f;
    public float overscrollSpeedMax = 200.0f;
    public float overscrollSpeedMin = 30.0f;
    public boolean overscrollX = true;
    public boolean overscrollY = true;
    public boolean scrollBarTouch = true;
    public boolean scrollX;
    public boolean scrollY;
    public boolean smoothScrolling = true;
    public ScrollPaneStyle style;
    public boolean touchScrollH;
    public boolean touchScrollV;
    public final Rectangle vKnobBounds = new Rectangle();
    public final Rectangle vScrollBounds = new Rectangle();
    public boolean vScrollOnRight = true;
    public boolean variableSizeKnobs = true;
    public float velocityX;
    public float velocityY;
    public float visualAmountX;
    public float visualAmountY;
    public Actor widget;
    public final Rectangle widgetArea = new Rectangle();
    public final Rectangle widgetCullingArea = new Rectangle();

    public static class ScrollPaneStyle {
        public Drawable background;
        public Drawable corner;
        public Drawable hScroll;
        public Drawable hScrollKnob;
        public Drawable vScroll;
        public Drawable vScrollKnob;
    }

    public ScrollPane(Actor actor) {
        ScrollPaneStyle scrollPaneStyle = new ScrollPaneStyle();
        this.style = scrollPaneStyle;
        setActor(actor);
        setSize(150.0f, 150.0f);
        AnonymousClass1 r4 = new InputListener() {
            public float handlePosition;

            public boolean mouseMoved(InputEvent inputEvent, float f2, float f3) {
                ScrollPane scrollPane = ScrollPane.this;
                if (!scrollPane.flickScroll) {
                    scrollPane.setScrollbarsVisible(true);
                }
                return false;
            }

            public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
                int i3 = -1;
                if (ScrollPane.this.draggingPointer != -1) {
                    return false;
                }
                if (i == 0 && i2 != 0) {
                    return false;
                }
                ScrollPane scrollPane = ScrollPane.this;
                Stage stage = scrollPane.stage;
                if (stage != null) {
                    stage.setScrollFocus(scrollPane);
                }
                ScrollPane scrollPane2 = ScrollPane.this;
                if (!scrollPane2.flickScroll) {
                    scrollPane2.setScrollbarsVisible(true);
                }
                ScrollPane scrollPane3 = ScrollPane.this;
                if (scrollPane3.fadeAlpha == 0.0f) {
                    return false;
                }
                if (!scrollPane3.scrollBarTouch || !scrollPane3.scrollX || !scrollPane3.hScrollBounds.contains(f2, f3)) {
                    ScrollPane scrollPane4 = ScrollPane.this;
                    if (!scrollPane4.scrollBarTouch || !scrollPane4.scrollY || !scrollPane4.vScrollBounds.contains(f2, f3)) {
                        return false;
                    }
                    inputEvent.stopped = true;
                    ScrollPane.this.setScrollbarsVisible(true);
                    if (ScrollPane.this.vKnobBounds.contains(f2, f3)) {
                        ScrollPane scrollPane5 = ScrollPane.this;
                        Vector2 vector2 = scrollPane5.lastPoint;
                        vector2.x = f2;
                        vector2.y = f3;
                        this.handlePosition = scrollPane5.vKnobBounds.y;
                        scrollPane5.touchScrollV = true;
                        scrollPane5.draggingPointer = i;
                        return true;
                    }
                    ScrollPane scrollPane6 = ScrollPane.this;
                    float f4 = scrollPane6.amountY;
                    float f5 = scrollPane6.widgetArea.height;
                    if (f3 < scrollPane6.vKnobBounds.y) {
                        i3 = 1;
                    }
                    scrollPane6.amountY = MathUtils.clamp((f5 * ((float) i3)) + f4, 0.0f, scrollPane6.maxY);
                    return true;
                }
                inputEvent.stopped = true;
                ScrollPane.this.setScrollbarsVisible(true);
                if (ScrollPane.this.hKnobBounds.contains(f2, f3)) {
                    ScrollPane scrollPane7 = ScrollPane.this;
                    Vector2 vector22 = scrollPane7.lastPoint;
                    vector22.x = f2;
                    vector22.y = f3;
                    this.handlePosition = scrollPane7.hKnobBounds.x;
                    scrollPane7.touchScrollH = true;
                    scrollPane7.draggingPointer = i;
                    return true;
                }
                ScrollPane scrollPane8 = ScrollPane.this;
                float f6 = scrollPane8.amountX;
                float f7 = scrollPane8.widgetArea.width;
                if (f2 >= scrollPane8.hKnobBounds.x) {
                    i3 = 1;
                }
                scrollPane8.amountX = MathUtils.clamp((f7 * ((float) i3)) + f6, 0.0f, scrollPane8.maxX);
                return true;
            }

            public void touchDragged(InputEvent inputEvent, float f2, float f3, int i) {
                ScrollPane scrollPane = ScrollPane.this;
                if (i == scrollPane.draggingPointer) {
                    if (scrollPane.touchScrollH) {
                        float f4 = this.handlePosition + (f2 - scrollPane.lastPoint.x);
                        this.handlePosition = f4;
                        float max = Math.max(scrollPane.hScrollBounds.x, f4);
                        ScrollPane scrollPane2 = ScrollPane.this;
                        Rectangle rectangle = scrollPane2.hScrollBounds;
                        float min = Math.min((rectangle.x + rectangle.width) - scrollPane2.hKnobBounds.width, max);
                        ScrollPane scrollPane3 = ScrollPane.this;
                        Rectangle rectangle2 = scrollPane3.hScrollBounds;
                        float f5 = rectangle2.width - scrollPane3.hKnobBounds.width;
                        if (f5 != 0.0f) {
                            scrollPane3.amountX = MathUtils.clamp((min - rectangle2.x) / f5, 0.0f, 1.0f) * scrollPane3.maxX;
                        }
                        Vector2 vector2 = ScrollPane.this.lastPoint;
                        vector2.x = f2;
                        vector2.y = f3;
                    } else if (scrollPane.touchScrollV) {
                        float f6 = this.handlePosition + (f3 - scrollPane.lastPoint.y);
                        this.handlePosition = f6;
                        float max2 = Math.max(scrollPane.vScrollBounds.y, f6);
                        ScrollPane scrollPane4 = ScrollPane.this;
                        Rectangle rectangle3 = scrollPane4.vScrollBounds;
                        float min2 = Math.min((rectangle3.y + rectangle3.height) - scrollPane4.vKnobBounds.height, max2);
                        ScrollPane scrollPane5 = ScrollPane.this;
                        Rectangle rectangle4 = scrollPane5.vScrollBounds;
                        float f7 = rectangle4.height - scrollPane5.vKnobBounds.height;
                        if (f7 != 0.0f) {
                            scrollPane5.amountY = MathUtils.clamp(1.0f - ((min2 - rectangle4.y) / f7), 0.0f, 1.0f) * scrollPane5.maxY;
                        }
                        Vector2 vector22 = ScrollPane.this.lastPoint;
                        vector22.x = f2;
                        vector22.y = f3;
                    }
                }
            }

            public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
                ScrollPane scrollPane = ScrollPane.this;
                if (i == scrollPane.draggingPointer) {
                    scrollPane.draggingPointer = -1;
                    scrollPane.touchScrollH = false;
                    scrollPane.touchScrollV = false;
                    scrollPane.flickScrollListener.detector.cancel();
                }
            }
        };
        if (!this.captureListeners.contains(r4, true)) {
            this.captureListeners.add(r4);
        }
        AnonymousClass2 r42 = new ActorGestureListener() {
            public void fling(InputEvent inputEvent, float f2, float f3, int i) {
                if (Math.abs(f2) > 150.0f) {
                    ScrollPane scrollPane = ScrollPane.this;
                    if (scrollPane.scrollX) {
                        scrollPane.flingTimer = scrollPane.flingTime;
                        scrollPane.velocityX = f2;
                        if (scrollPane.cancelTouchFocus) {
                            scrollPane.cancelTouchFocus();
                        }
                    }
                }
                if (Math.abs(f3) > 150.0f) {
                    ScrollPane scrollPane2 = ScrollPane.this;
                    if (scrollPane2.scrollY) {
                        scrollPane2.flingTimer = scrollPane2.flingTime;
                        scrollPane2.velocityY = -f3;
                        if (scrollPane2.cancelTouchFocus) {
                            scrollPane2.cancelTouchFocus();
                        }
                    }
                }
            }

            public boolean handle(Event event) {
                if (super.handle(event)) {
                    if (((InputEvent) event).type == Type.touchDown) {
                        ScrollPane.this.flingTimer = 0.0f;
                    }
                    return true;
                }
                if ((event instanceof InputEvent) && ((InputEvent) event).isTouchFocusCancel()) {
                    ScrollPane scrollPane = ScrollPane.this;
                    scrollPane.draggingPointer = -1;
                    scrollPane.touchScrollH = false;
                    scrollPane.touchScrollV = false;
                    scrollPane.flickScrollListener.detector.cancel();
                }
                return false;
            }

            public void pan(InputEvent inputEvent, float f2, float f3, float f4, float f5) {
                ScrollPane.this.setScrollbarsVisible(true);
                ScrollPane scrollPane = ScrollPane.this;
                scrollPane.amountX -= f4;
                scrollPane.amountY += f5;
                scrollPane.clamp();
                ScrollPane scrollPane2 = ScrollPane.this;
                if (!scrollPane2.cancelTouchFocus) {
                    return;
                }
                if ((scrollPane2.scrollX && f4 != 0.0f) || (ScrollPane.this.scrollY && f5 != 0.0f)) {
                    ScrollPane.this.cancelTouchFocus();
                }
            }
        };
        this.flickScrollListener = r42;
        addListener(r42);
        addListener(new InputListener() {
            public boolean scrolled(InputEvent inputEvent, float f2, float f3, float f4, float f5) {
                ScrollPane.this.setScrollbarsVisible(true);
                ScrollPane scrollPane = ScrollPane.this;
                if (!scrollPane.scrollY && !scrollPane.scrollX) {
                    return false;
                }
                ScrollPane scrollPane2 = ScrollPane.this;
                if (scrollPane2.scrollY) {
                    if (!scrollPane2.scrollX && f5 == 0.0f) {
                        f5 = f4;
                        ScrollPane scrollPane3 = ScrollPane.this;
                        float f6 = scrollPane3.amountY;
                        float f7 = scrollPane3.widgetArea.height;
                        scrollPane3.amountY = MathUtils.clamp((Math.min(f7, Math.max(f7 * 0.9f, scrollPane3.maxY * 0.1f) / 4.0f) * f4) + f6, 0.0f, scrollPane3.maxY);
                        ScrollPane scrollPane4 = ScrollPane.this;
                        float f8 = scrollPane4.amountX;
                        float f9 = scrollPane4.widgetArea.width;
                        scrollPane4.amountX = MathUtils.clamp((Math.min(f9, Math.max(0.9f * f9, scrollPane4.maxX * 0.1f) / 4.0f) * f5) + f8, 0.0f, scrollPane4.maxX);
                        return true;
                    }
                } else if (scrollPane2.scrollX && f4 == 0.0f) {
                    f4 = f5;
                    ScrollPane scrollPane32 = ScrollPane.this;
                    float f62 = scrollPane32.amountY;
                    float f72 = scrollPane32.widgetArea.height;
                    scrollPane32.amountY = MathUtils.clamp((Math.min(f72, Math.max(f72 * 0.9f, scrollPane32.maxY * 0.1f) / 4.0f) * f4) + f62, 0.0f, scrollPane32.maxY);
                    ScrollPane scrollPane42 = ScrollPane.this;
                    float f82 = scrollPane42.amountX;
                    float f92 = scrollPane42.widgetArea.width;
                    scrollPane42.amountX = MathUtils.clamp((Math.min(f92, Math.max(0.9f * f92, scrollPane42.maxX * 0.1f) / 4.0f) * f5) + f82, 0.0f, scrollPane42.maxX);
                    return true;
                }
                float f10 = f5;
                f5 = f4;
                f4 = f10;
                ScrollPane scrollPane322 = ScrollPane.this;
                float f622 = scrollPane322.amountY;
                float f722 = scrollPane322.widgetArea.height;
                scrollPane322.amountY = MathUtils.clamp((Math.min(f722, Math.max(f722 * 0.9f, scrollPane322.maxY * 0.1f) / 4.0f) * f4) + f622, 0.0f, scrollPane322.maxY);
                ScrollPane scrollPane422 = ScrollPane.this;
                float f822 = scrollPane422.amountX;
                float f922 = scrollPane422.widgetArea.width;
                scrollPane422.amountX = MathUtils.clamp((Math.min(f922, Math.max(0.9f * f922, scrollPane422.maxX * 0.1f) / 4.0f) * f5) + f822, 0.0f, scrollPane422.maxX);
                return true;
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void act(float r10) {
        /*
            r9 = this;
            super.act(r10)
            com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener r0 = r9.flickScrollListener
            com.badlogic.gdx.input.GestureDetector r0 = r0.detector
            boolean r0 = r0.isPanning()
            float r1 = r9.fadeAlpha
            r2 = 1
            r3 = 0
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0033
            boolean r4 = r9.fadeScrollBars
            if (r4 == 0) goto L_0x0033
            if (r0 != 0) goto L_0x0033
            boolean r4 = r9.touchScrollH
            if (r4 != 0) goto L_0x0033
            boolean r4 = r9.touchScrollV
            if (r4 != 0) goto L_0x0033
            float r4 = r9.fadeDelay
            float r4 = r4 - r10
            r9.fadeDelay = r4
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 > 0) goto L_0x0031
            float r1 = r1 - r10
            float r1 = java.lang.Math.max(r3, r1)
            r9.fadeAlpha = r1
        L_0x0031:
            r1 = 1
            goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            float r4 = r9.flingTimer
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0099
            r9.setScrollbarsVisible(r2)
            float r1 = r9.flingTimer
            float r4 = r9.flingTime
            float r1 = r1 / r4
            float r4 = r9.amountX
            float r5 = r9.velocityX
            float r5 = r5 * r1
            float r5 = r5 * r10
            float r4 = r4 - r5
            r9.amountX = r4
            float r4 = r9.amountY
            float r5 = r9.velocityY
            float r5 = r5 * r1
            float r5 = r5 * r10
            float r4 = r4 - r5
            r9.amountY = r4
            r9.clamp()
            float r1 = r9.amountX
            float r4 = r9.overscrollDistance
            float r4 = -r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0066
            r9.velocityX = r3
        L_0x0066:
            float r1 = r9.amountX
            float r4 = r9.maxX
            float r5 = r9.overscrollDistance
            float r4 = r4 + r5
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 < 0) goto L_0x0073
            r9.velocityX = r3
        L_0x0073:
            float r1 = r9.amountY
            float r4 = r9.overscrollDistance
            float r4 = -r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x007e
            r9.velocityY = r3
        L_0x007e:
            float r1 = r9.amountY
            float r4 = r9.maxY
            float r5 = r9.overscrollDistance
            float r4 = r4 + r5
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 < 0) goto L_0x008b
            r9.velocityY = r3
        L_0x008b:
            float r1 = r9.flingTimer
            float r1 = r1 - r10
            r9.flingTimer = r1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0098
            r9.velocityX = r3
            r9.velocityY = r3
        L_0x0098:
            r1 = 1
        L_0x0099:
            boolean r4 = r9.smoothScrolling
            if (r4 == 0) goto L_0x0151
            float r4 = r9.flingTimer
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 > 0) goto L_0x0151
            if (r0 != 0) goto L_0x0151
            boolean r4 = r9.touchScrollH
            r5 = 1036831949(0x3dcccccd, float:0.1)
            if (r4 == 0) goto L_0x00c6
            boolean r4 = r9.scrollX
            if (r4 == 0) goto L_0x0151
            float r4 = r9.maxX
            com.badlogic.gdx.math.Rectangle r6 = r9.hScrollBounds
            float r6 = r6.width
            com.badlogic.gdx.math.Rectangle r7 = r9.hKnobBounds
            float r7 = r7.width
            float r6 = r6 - r7
            float r4 = r4 / r6
            com.badlogic.gdx.math.Rectangle r6 = r9.widgetArea
            float r6 = r6.width
            float r6 = r6 * r5
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0151
        L_0x00c6:
            boolean r4 = r9.touchScrollV
            if (r4 == 0) goto L_0x00e4
            boolean r4 = r9.scrollY
            if (r4 == 0) goto L_0x0151
            float r4 = r9.maxY
            com.badlogic.gdx.math.Rectangle r6 = r9.vScrollBounds
            float r6 = r6.height
            com.badlogic.gdx.math.Rectangle r7 = r9.vKnobBounds
            float r7 = r7.height
            float r6 = r6 - r7
            float r4 = r4 / r6
            com.badlogic.gdx.math.Rectangle r6 = r9.widgetArea
            float r6 = r6.height
            float r6 = r6 * r5
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0151
        L_0x00e4:
            float r4 = r9.visualAmountX
            float r5 = r9.amountX
            r6 = 1088421888(0x40e00000, float:7.0)
            r7 = 1128792064(0x43480000, float:200.0)
            int r8 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x011c
            int r1 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x0108
            float r1 = r10 * r7
            float r8 = r5 - r4
            float r8 = r8 * r6
            float r8 = r8 * r10
            float r1 = java.lang.Math.max(r1, r8)
            float r1 = r1 + r4
            float r1 = java.lang.Math.min(r5, r1)
            r9.visualAmountX = r1
            goto L_0x011b
        L_0x0108:
            float r1 = r10 * r7
            float r8 = r4 - r5
            float r8 = r8 * r6
            float r8 = r8 * r10
            float r1 = java.lang.Math.max(r1, r8)
            float r4 = r4 - r1
            float r1 = java.lang.Math.max(r5, r4)
            r9.visualAmountX = r1
        L_0x011b:
            r1 = 1
        L_0x011c:
            float r4 = r9.visualAmountY
            float r5 = r9.amountY
            int r8 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x0165
            int r1 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x013c
            float r7 = r7 * r10
            float r1 = r5 - r4
            float r1 = r1 * r6
            float r1 = r1 * r10
            float r1 = java.lang.Math.max(r7, r1)
            float r1 = r1 + r4
            float r1 = java.lang.Math.min(r5, r1)
            r9.visualAmountY = r1
            goto L_0x014f
        L_0x013c:
            float r7 = r7 * r10
            float r1 = r4 - r5
            float r1 = r1 * r6
            float r1 = r1 * r10
            float r1 = java.lang.Math.max(r7, r1)
            float r4 = r4 - r1
            float r1 = java.lang.Math.max(r5, r4)
            r9.visualAmountY = r1
        L_0x014f:
            r1 = 1
            goto L_0x0165
        L_0x0151:
            float r4 = r9.visualAmountX
            float r5 = r9.amountX
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x015b
            r9.visualAmountX = r5
        L_0x015b:
            float r4 = r9.visualAmountY
            float r5 = r9.amountY
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x0165
            r9.visualAmountY = r5
        L_0x0165:
            if (r0 != 0) goto L_0x020b
            boolean r0 = r9.overscrollX
            if (r0 == 0) goto L_0x01b9
            boolean r0 = r9.scrollX
            if (r0 == 0) goto L_0x01b9
            float r0 = r9.amountX
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0192
            r9.setScrollbarsVisible(r2)
            float r0 = r9.amountX
            float r1 = r9.overscrollSpeedMin
            float r4 = r9.overscrollSpeedMax
            float r4 = r4 - r1
            float r5 = -r0
            float r4 = r4 * r5
            float r5 = r9.overscrollDistance
            float r4 = r4 / r5
            float r4 = r4 + r1
            float r4 = r4 * r10
            float r4 = r4 + r0
            r9.amountX = r4
            int r0 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b8
            r9.amountX = r3
            goto L_0x01b8
        L_0x0192:
            float r4 = r9.maxX
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b9
            r9.setScrollbarsVisible(r2)
            float r0 = r9.amountX
            float r1 = r9.overscrollSpeedMin
            float r4 = r9.overscrollSpeedMax
            float r4 = r4 - r1
            float r5 = r9.maxX
            float r6 = r5 - r0
            float r6 = -r6
            float r4 = r4 * r6
            float r6 = r9.overscrollDistance
            float r4 = r4 / r6
            float r4 = r4 + r1
            float r4 = r4 * r10
            float r0 = r0 - r4
            r9.amountX = r0
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x01b8
            r9.amountX = r5
        L_0x01b8:
            r1 = 1
        L_0x01b9:
            boolean r0 = r9.overscrollY
            if (r0 == 0) goto L_0x020b
            boolean r0 = r9.scrollY
            if (r0 == 0) goto L_0x020b
            float r0 = r9.amountY
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x01e4
            r9.setScrollbarsVisible(r2)
            float r0 = r9.amountY
            float r1 = r9.overscrollSpeedMin
            float r4 = r9.overscrollSpeedMax
            float r4 = r4 - r1
            float r5 = -r0
            float r4 = r4 * r5
            float r5 = r9.overscrollDistance
            float r4 = r4 / r5
            float r4 = r4 + r1
            float r4 = r4 * r10
            float r4 = r4 + r0
            r9.amountY = r4
            int r10 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r10 <= 0) goto L_0x020c
            r9.amountY = r3
            goto L_0x020c
        L_0x01e4:
            float r3 = r9.maxY
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x020b
            r9.setScrollbarsVisible(r2)
            float r0 = r9.amountY
            float r1 = r9.overscrollSpeedMin
            float r3 = r9.overscrollSpeedMax
            float r3 = r3 - r1
            float r4 = r9.maxY
            float r5 = r4 - r0
            float r5 = -r5
            float r3 = r3 * r5
            float r5 = r9.overscrollDistance
            float r3 = r3 / r5
            float r3 = r3 + r1
            float r3 = r3 * r10
            float r0 = r0 - r3
            r9.amountY = r0
            int r10 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r10 >= 0) goto L_0x020c
            r9.amountY = r4
            goto L_0x020c
        L_0x020b:
            r2 = r1
        L_0x020c:
            if (r2 == 0) goto L_0x021d
            com.badlogic.gdx.scenes.scene2d.Stage r10 = r9.stage
            if (r10 == 0) goto L_0x021d
            boolean r10 = r10.actionsRequestRendering
            if (r10 == 0) goto L_0x021d
            com.badlogic.gdx.Graphics r10 = co.hyperverge.hypersnapsdk.c.k.graphics
            com.badlogic.gdx.backends.android.AndroidGraphics r10 = (com.badlogic.gdx.backends.android.AndroidGraphics) r10
            r10.requestRendering()
        L_0x021d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.act(float):void");
    }

    @Deprecated
    public void addActor(Actor actor) {
        throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
    }

    @Deprecated
    public void addActorAfter(Actor actor, Actor actor2) {
        throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
    }

    @Deprecated
    public void addActorBefore(Actor actor, Actor actor2) {
        throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
    }

    public void cancelTouchFocus() {
        Stage stage = this.stage;
        if (stage != null) {
            stage.cancelTouchFocusExcept(this.flickScrollListener, this);
        }
    }

    public void clamp() {
        float f2;
        float f3;
        if (this.clamp) {
            if (this.overscrollX) {
                float f4 = this.amountX;
                float f5 = this.overscrollDistance;
                f2 = MathUtils.clamp(f4, -f5, this.maxX + f5);
            } else {
                f2 = MathUtils.clamp(this.amountX, 0.0f, this.maxX);
            }
            this.amountX = f2;
            if (this.overscrollY) {
                float f6 = this.amountY;
                float f7 = this.overscrollDistance;
                f3 = MathUtils.clamp(f6, -f7, this.maxY + f7);
            } else {
                f3 = MathUtils.clamp(this.amountY, 0.0f, this.maxY);
            }
            this.amountY = f3;
        }
    }

    public void draw(Batch batch, float f2) {
        float f3;
        float f4;
        if (this.widget != null) {
            validate();
            Matrix4 computeTransform = computeTransform();
            this.oldTransform.set(batch.getTransformMatrix());
            batch.setTransformMatrix(computeTransform);
            if (this.scrollX) {
                Rectangle rectangle = this.hKnobBounds;
                Rectangle rectangle2 = this.hScrollBounds;
                float f5 = rectangle2.x;
                float f6 = rectangle2.width - rectangle.width;
                float f7 = this.maxX;
                if (f7 == 0.0f) {
                    f4 = 0.0f;
                } else {
                    f4 = MathUtils.clamp(this.visualAmountX / f7, 0.0f, 1.0f);
                }
                rectangle.x = f5 + ((float) ((int) (f6 * f4)));
            }
            if (this.scrollY) {
                Rectangle rectangle3 = this.vKnobBounds;
                Rectangle rectangle4 = this.vScrollBounds;
                float f8 = rectangle4.y;
                float f9 = rectangle4.height - rectangle3.height;
                float f10 = this.maxY;
                if (f10 == 0.0f) {
                    f3 = 0.0f;
                } else {
                    f3 = MathUtils.clamp(this.visualAmountY / f10, 0.0f, 1.0f);
                }
                rectangle3.y = f8 + ((float) ((int) ((1.0f - f3) * f9)));
            }
            updateWidgetPosition();
            Color color = this.color;
            float f11 = color.f3306a * f2;
            if (this.style.background != null) {
                batch.setColor(color.r, color.g, color.f3307b, f11);
                this.style.background.draw(batch, 0.0f, 0.0f, this.width, this.height);
            }
            batch.flush();
            Rectangle rectangle5 = this.widgetArea;
            if (clipBegin(rectangle5.x, rectangle5.y, rectangle5.width, rectangle5.height)) {
                drawChildren(batch, f2);
                batch.flush();
                clipEnd();
            }
            batch.setColor(color.r, color.g, color.f3307b, f11);
            if (this.fadeScrollBars) {
                f11 *= Interpolation.fade.apply(this.fadeAlpha / this.fadeAlphaSeconds);
            }
            float f12 = color.r;
            float f13 = color.g;
            float f14 = color.f3307b;
            if (f11 > 0.0f) {
                batch.setColor(f12, f13, f14, f11);
                boolean z = false;
                boolean z2 = this.scrollX && this.hKnobBounds.width > 0.0f;
                if (this.scrollY && this.vKnobBounds.height > 0.0f) {
                    z = true;
                }
                if (z2 && z) {
                    Drawable drawable = this.style.corner;
                    if (drawable != null) {
                        Rectangle rectangle6 = this.hScrollBounds;
                        float f15 = rectangle6.x;
                        float f16 = rectangle6.y;
                        Rectangle rectangle7 = this.vScrollBounds;
                        drawable.draw(batch, rectangle6.width + f15, f16, rectangle7.width, rectangle7.y);
                    }
                }
                if (z2) {
                    Drawable drawable2 = this.style.hScroll;
                    if (drawable2 != null) {
                        Rectangle rectangle8 = this.hScrollBounds;
                        drawable2.draw(batch, rectangle8.x, rectangle8.y, rectangle8.width, rectangle8.height);
                    }
                    Drawable drawable3 = this.style.hScrollKnob;
                    if (drawable3 != null) {
                        Rectangle rectangle9 = this.hKnobBounds;
                        drawable3.draw(batch, rectangle9.x, rectangle9.y, rectangle9.width, rectangle9.height);
                    }
                }
                if (z) {
                    Drawable drawable4 = this.style.vScroll;
                    if (drawable4 != null) {
                        Rectangle rectangle10 = this.vScrollBounds;
                        drawable4.draw(batch, rectangle10.x, rectangle10.y, rectangle10.width, rectangle10.height);
                    }
                    Drawable drawable5 = this.style.vScrollKnob;
                    if (drawable5 != null) {
                        Rectangle rectangle11 = this.vKnobBounds;
                        drawable5.draw(batch, rectangle11.x, rectangle11.y, rectangle11.width, rectangle11.height);
                    }
                }
            }
            batch.setTransformMatrix(this.oldTransform);
        }
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        drawDebugBounds(shapeRenderer);
        Matrix4 computeTransform = computeTransform();
        this.oldTransform.set(shapeRenderer.getTransformMatrix());
        shapeRenderer.setTransformMatrix(computeTransform);
        shapeRenderer.flush();
        Rectangle rectangle = this.widgetArea;
        if (clipBegin(rectangle.x, rectangle.y, rectangle.width, rectangle.height)) {
            drawDebugChildren(shapeRenderer);
            shapeRenderer.flush();
            clipEnd();
        }
        shapeRenderer.setTransformMatrix(this.oldTransform);
    }

    public float getMinHeight() {
        return 0.0f;
    }

    public float getMinWidth() {
        return 0.0f;
    }

    public float getPrefHeight() {
        float f2;
        Actor actor = this.widget;
        float f3 = 0.0f;
        if (actor instanceof Layout) {
            f2 = ((Layout) actor).getPrefHeight();
        } else {
            f2 = actor != null ? actor.height : 0.0f;
        }
        Drawable drawable = this.style.background;
        if (drawable != null) {
            f2 = Math.max(drawable.getBottomHeight() + drawable.getTopHeight() + f2, drawable.getMinHeight());
        }
        if (!this.scrollX) {
            return f2;
        }
        Drawable drawable2 = this.style.hScrollKnob;
        if (drawable2 != null) {
            f3 = drawable2.getMinHeight();
        }
        Drawable drawable3 = this.style.hScroll;
        if (drawable3 != null) {
            f3 = Math.max(f3, drawable3.getMinHeight());
        }
        return f2 + f3;
    }

    public float getPrefWidth() {
        float f2;
        Actor actor = this.widget;
        float f3 = 0.0f;
        if (actor instanceof Layout) {
            f2 = ((Layout) actor).getPrefWidth();
        } else {
            f2 = actor != null ? actor.width : 0.0f;
        }
        Drawable drawable = this.style.background;
        if (drawable != null) {
            f2 = Math.max(drawable.getRightWidth() + drawable.getLeftWidth() + f2, drawable.getMinWidth());
        }
        if (!this.scrollY) {
            return f2;
        }
        Drawable drawable2 = this.style.vScrollKnob;
        if (drawable2 != null) {
            f3 = drawable2.getMinWidth();
        }
        Drawable drawable3 = this.style.vScroll;
        if (drawable3 != null) {
            f3 = Math.max(f3, drawable3.getMinWidth());
        }
        return f2 + f3;
    }

    public Actor hit(float f2, float f3, boolean z) {
        if (f2 < 0.0f || f2 >= this.width || f3 < 0.0f || f3 >= this.height) {
            return null;
        }
        if (z && this.touchable == Touchable.enabled && this.visible) {
            if (this.scrollX && this.touchScrollH && this.hScrollBounds.contains(f2, f3)) {
                return this;
            }
            if (this.scrollY && this.touchScrollV && this.vScrollBounds.contains(f2, f3)) {
                return this;
            }
        }
        return super.hit(f2, f3, z);
    }

    public void layout() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        ScrollPaneStyle scrollPaneStyle = this.style;
        Drawable drawable = scrollPaneStyle.background;
        Drawable drawable2 = scrollPaneStyle.hScrollKnob;
        Drawable drawable3 = scrollPaneStyle.vScrollKnob;
        float f9 = 0.0f;
        if (drawable != null) {
            f4 = drawable.getLeftWidth();
            f3 = drawable.getRightWidth();
            f2 = drawable.getTopHeight();
            f5 = drawable.getBottomHeight();
        } else {
            f5 = 0.0f;
            f4 = 0.0f;
            f3 = 0.0f;
            f2 = 0.0f;
        }
        float f10 = this.width;
        float f11 = this.height - f2;
        this.widgetArea.set(f4, f5, (f10 - f4) - f3, f11 - f5);
        if (this.widget != null) {
            float minHeight = drawable2 != null ? drawable2.getMinHeight() : 0.0f;
            Drawable drawable4 = this.style.hScroll;
            if (drawable4 != null) {
                minHeight = Math.max(minHeight, drawable4.getMinHeight());
            }
            float minWidth = drawable3 != null ? drawable3.getMinWidth() : 0.0f;
            Drawable drawable5 = this.style.vScroll;
            if (drawable5 != null) {
                minWidth = Math.max(minWidth, drawable5.getMinWidth());
            }
            Actor actor = this.widget;
            if (actor instanceof Layout) {
                Layout layout = (Layout) actor;
                f6 = layout.getPrefWidth();
                f7 = layout.getPrefHeight();
            } else {
                f6 = actor.width;
                f7 = actor.height;
            }
            boolean z = false;
            this.scrollX = f6 > this.widgetArea.width && !this.disableX;
            if (f7 > this.widgetArea.height && !this.disableY) {
                z = true;
            }
            this.scrollY = z;
            if (z) {
                Rectangle rectangle = this.widgetArea;
                rectangle.width -= minWidth;
                if (!this.vScrollOnRight) {
                    rectangle.x += minWidth;
                }
                if (!this.scrollX && f6 > this.widgetArea.width && !this.disableX) {
                    this.scrollX = true;
                }
            }
            if (this.scrollX) {
                Rectangle rectangle2 = this.widgetArea;
                rectangle2.height -= minHeight;
                if (this.hScrollOnBottom) {
                    rectangle2.y += minHeight;
                }
                if (!this.scrollY) {
                    Rectangle rectangle3 = this.widgetArea;
                    if (f7 > rectangle3.height && !this.disableY) {
                        this.scrollY = true;
                        rectangle3.width -= minWidth;
                        if (!this.vScrollOnRight) {
                            rectangle3.x += minWidth;
                        }
                    }
                }
            }
            float max = this.disableX ? this.widgetArea.width : Math.max(this.widgetArea.width, f6);
            float max2 = this.disableY ? this.widgetArea.height : Math.max(this.widgetArea.height, f7);
            Rectangle rectangle4 = this.widgetArea;
            float f12 = max - rectangle4.width;
            this.maxX = f12;
            this.maxY = max2 - rectangle4.height;
            this.amountX = MathUtils.clamp(this.amountX, 0.0f, f12);
            this.amountY = MathUtils.clamp(this.amountY, 0.0f, this.maxY);
            if (this.scrollX) {
                if (drawable2 != null) {
                    float f13 = this.widgetArea.x;
                    if (!this.hScrollOnBottom) {
                        f5 = f11 - minHeight;
                    }
                    this.hScrollBounds.set(f13, f5, this.widgetArea.width, minHeight);
                    boolean z2 = this.scrollY;
                    if (this.variableSizeKnobs) {
                        this.hKnobBounds.width = Math.max(drawable2.getMinWidth(), (float) ((int) ((this.hScrollBounds.width * this.widgetArea.width) / max)));
                    } else {
                        this.hKnobBounds.width = drawable2.getMinWidth();
                    }
                    Rectangle rectangle5 = this.hKnobBounds;
                    if (rectangle5.width > max) {
                        rectangle5.width = 0.0f;
                    }
                    this.hKnobBounds.height = drawable2.getMinHeight();
                    Rectangle rectangle6 = this.hKnobBounds;
                    Rectangle rectangle7 = this.hScrollBounds;
                    float f14 = rectangle7.x;
                    float f15 = rectangle7.width - rectangle6.width;
                    float f16 = this.maxX;
                    if (f16 == 0.0f) {
                        f8 = 0.0f;
                    } else {
                        f8 = MathUtils.clamp(this.amountX / f16, 0.0f, 1.0f);
                    }
                    rectangle6.x = f14 + ((float) ((int) (f15 * f8)));
                    this.hKnobBounds.y = this.hScrollBounds.y;
                } else {
                    this.hScrollBounds.set(0.0f, 0.0f, 0.0f, 0.0f);
                    this.hKnobBounds.set(0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
            if (this.scrollY) {
                if (drawable3 != null) {
                    float f17 = this.vScrollOnRight ? (f10 - f3) - minWidth : f4;
                    Rectangle rectangle8 = this.widgetArea;
                    this.vScrollBounds.set(f17, rectangle8.y, minWidth, rectangle8.height);
                    boolean z3 = this.scrollX;
                    this.vKnobBounds.width = drawable3.getMinWidth();
                    if (this.variableSizeKnobs) {
                        this.vKnobBounds.height = Math.max(drawable3.getMinHeight(), (float) ((int) ((this.vScrollBounds.height * this.widgetArea.height) / max2)));
                    } else {
                        this.vKnobBounds.height = drawable3.getMinHeight();
                    }
                    Rectangle rectangle9 = this.vKnobBounds;
                    if (rectangle9.height > max2) {
                        rectangle9.height = 0.0f;
                    }
                    Rectangle rectangle10 = this.vKnobBounds;
                    if (this.vScrollOnRight) {
                        f4 = (f10 - f3) - drawable3.getMinWidth();
                    }
                    rectangle10.x = f4;
                    Rectangle rectangle11 = this.vKnobBounds;
                    Rectangle rectangle12 = this.vScrollBounds;
                    float f18 = rectangle12.y;
                    float f19 = rectangle12.height - rectangle11.height;
                    float f20 = this.maxY;
                    if (f20 != 0.0f) {
                        f9 = MathUtils.clamp(this.amountY / f20, 0.0f, 1.0f);
                    }
                    rectangle11.y = f18 + ((float) ((int) ((1.0f - f9) * f19)));
                } else {
                    this.vScrollBounds.set(0.0f, 0.0f, 0.0f, 0.0f);
                    this.vKnobBounds.set(0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
            updateWidgetPosition();
            Actor actor2 = this.widget;
            if (actor2 instanceof Layout) {
                actor2.setSize(max, max2);
                ((Layout) this.widget).validate();
            }
        }
    }

    public boolean removeActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        } else if (actor != this.widget) {
            return false;
        } else {
            setActor(null);
            return true;
        }
    }

    public Actor removeActorAt(int i, boolean z) {
        Actor removeActorAt = super.removeActorAt(i, z);
        if (removeActorAt == this.widget) {
            this.widget = null;
        }
        return removeActorAt;
    }

    public void setActor(Actor actor) {
        Actor actor2 = this.widget;
        if (actor2 != this) {
            if (actor2 != null) {
                super.removeActor(actor2);
            }
            this.widget = actor;
            if (actor != null) {
                super.addActor(actor);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("widget cannot be the ScrollPane.");
    }

    public void setScrollbarsVisible(boolean z) {
        if (z) {
            this.fadeAlpha = this.fadeAlphaSeconds;
            this.fadeDelay = this.fadeDelaySeconds;
            return;
        }
        this.fadeAlpha = 0.0f;
        this.fadeDelay = 0.0f;
    }

    public final void updateWidgetPosition() {
        float f2 = this.widgetArea.x - ((float) (this.scrollX ? (int) this.visualAmountX : 0));
        float f3 = this.widgetArea.y - ((float) ((int) (this.scrollY ? this.maxY - this.visualAmountY : this.maxY)));
        this.widget.setPosition(f2, f3);
        Actor actor = this.widget;
        if (actor instanceof Cullable) {
            Rectangle rectangle = this.widgetCullingArea;
            Rectangle rectangle2 = this.widgetArea;
            rectangle.x = rectangle2.x - f2;
            rectangle.y = rectangle2.y - f3;
            rectangle.width = rectangle2.width;
            rectangle.height = rectangle2.height;
            ((Cullable) actor).setCullingArea(rectangle);
        }
    }

    public boolean removeActor(Actor actor, boolean z) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        } else if (actor != this.widget) {
            return false;
        } else {
            this.widget = null;
            return super.removeActor(actor, z);
        }
    }
}
