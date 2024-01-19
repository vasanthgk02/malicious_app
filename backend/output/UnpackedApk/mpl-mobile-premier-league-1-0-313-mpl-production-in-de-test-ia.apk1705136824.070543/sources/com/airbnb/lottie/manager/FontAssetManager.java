package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class FontAssetManager {
    public final AssetManager assetManager;
    public String defaultFontFileExtension = ".ttf";
    public FontAssetDelegate delegate = null;
    public final Map<String, Typeface> fontFamilies = new HashMap();
    public final Map<MutablePair<String>, Typeface> fontMap = new HashMap();
    public final MutablePair<String> tempPair = new MutablePair<>();

    public FontAssetManager(Callback callback) {
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }
}
