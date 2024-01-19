package com.badlogic.gdx.backends.android;

import com.badlogic.gdx.backends.android.DefaultAndroidInput.TouchEvent;

public class AndroidMouseHandler {
    public int deltaX = 0;
    public int deltaY = 0;

    public final void postTouchEvent(DefaultAndroidInput defaultAndroidInput, int i, int i2, int i3, int i4, int i5, long j) {
        TouchEvent touchEvent = (TouchEvent) defaultAndroidInput.usedTouchEvents.obtain();
        touchEvent.timeStamp = j;
        touchEvent.x = i2;
        touchEvent.y = i3;
        touchEvent.type = i;
        touchEvent.scrollAmountX = i4;
        touchEvent.scrollAmountY = i5;
        defaultAndroidInput.touchEvents.add(touchEvent);
    }
}
