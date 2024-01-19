package com.badlogic.gdx.backends.android;

import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;

public class AndroidApplicationConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public int f3304a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f3305b = 8;
    public int depth = 16;
    public boolean disableAudio = false;
    public int g = 8;
    public boolean hideStatusBar = false;
    public int maxNetThreads = Integer.MAX_VALUE;
    public int maxSimultaneousSounds = 16;
    public int numSamples = 0;
    public int r = 8;
    public ResolutionStrategy resolutionStrategy = new FillResolutionStrategy();
    public int sensorDelay = 1;
    public int stencil = 0;
    public int touchSleepTime = 0;
    public boolean useAccelerometer = true;
    public boolean useCompass = true;
    @Deprecated
    public boolean useGL30 = false;
    public boolean useGyroscope = false;
    public boolean useImmersiveMode = false;
    public boolean useRotationVectorSensor = false;
    public boolean useWakelock = false;
}
