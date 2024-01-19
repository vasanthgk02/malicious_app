package com.badlogic.gdx.backends.android;

import android.media.AudioManager;
import android.media.SoundPool;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.IntArray;

public final class AndroidSound implements Sound {
    public final int soundId;
    public final SoundPool soundPool;
    public final IntArray streamIds = new IntArray(8);

    public AndroidSound(SoundPool soundPool2, AudioManager audioManager, int i) {
        this.soundPool = soundPool2;
        this.soundId = i;
    }

    public void dispose() {
        this.soundPool.unload(this.soundId);
    }

    public long loop(float f2) {
        IntArray intArray = this.streamIds;
        if (intArray.size == 8) {
            intArray.pop();
        }
        int play = this.soundPool.play(this.soundId, f2, f2, 1, -1, 1.0f);
        if (play == 0) {
            return -1;
        }
        this.streamIds.insert(0, play);
        return (long) play;
    }

    public long play() {
        return play(1.0f);
    }

    public void stop() {
        int i = this.streamIds.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.soundPool.stop(this.streamIds.get(i2));
        }
    }

    public long play(float f2) {
        IntArray intArray = this.streamIds;
        if (intArray.size == 8) {
            intArray.pop();
        }
        int play = this.soundPool.play(this.soundId, f2, f2, 1, 0, 1.0f);
        if (play == 0) {
            return -1;
        }
        this.streamIds.insert(0, play);
        return (long) play;
    }
}
