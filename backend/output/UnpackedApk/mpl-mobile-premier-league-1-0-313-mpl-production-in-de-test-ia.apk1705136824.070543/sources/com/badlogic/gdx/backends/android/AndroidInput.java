package com.badlogic.gdx.backends.android;

import android.view.View.OnGenericMotionListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import com.badlogic.gdx.Input;

public interface AndroidInput extends Input, OnTouchListener, OnKeyListener, OnGenericMotionListener {
}
