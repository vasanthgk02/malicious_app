package com.clevertap.android.sdk.gif;

import java.util.ArrayList;
import java.util.List;

public class GifHeader {
    public int bgColor;
    public int bgIndex;
    public GifFrame currentFrame;
    public int frameCount = 0;
    public List<GifFrame> frames = new ArrayList();
    public int[] gct = null;
    public boolean gctFlag;
    public int gctSize;
    public int height;
    public int loopCount = 0;
    public int pixelAspect;
    public int status = 0;
    public int width;
}
