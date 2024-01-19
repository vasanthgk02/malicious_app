package com.badlogic.gdx.audio;

import com.badlogic.gdx.utils.Disposable;

public interface Sound extends Disposable {
    long loop(float f2);

    long play();

    long play(float f2);

    void stop();
}
