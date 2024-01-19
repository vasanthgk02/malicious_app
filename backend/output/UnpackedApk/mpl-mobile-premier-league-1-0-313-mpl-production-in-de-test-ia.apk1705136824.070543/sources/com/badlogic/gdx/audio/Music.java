package com.badlogic.gdx.audio;

import com.badlogic.gdx.utils.Disposable;

public interface Music extends Disposable {

    public interface OnCompletionListener {
        void onCompletion(Music music);
    }
}
