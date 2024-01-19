package com.facebook.react.views.image;

import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.util.Arrays;
import java.util.Map;

@ReactModule(name = "RCTImageView")
public class ReactImageManager extends SimpleViewManager<ReactImageView> {
    public static final String REACT_CLASS = "RCTImageView";
    public final Object mCallerContext;
    public final ReactCallerContextFactory mCallerContextFactory;
    public AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    public GlobalImageLoadListener mGlobalImageLoadListener;

    @Deprecated
    public ReactImageManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj) {
        this(abstractDraweeControllerBuilder, (GlobalImageLoadListener) null, obj);
    }

    @Deprecated
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public AbstractDraweeControllerBuilder getDraweeControllerBuilder() {
        if (this.mDraweeControllerBuilder == null) {
            this.mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        }
        return this.mDraweeControllerBuilder;
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return ImageOriginUtils.of(ImageLoadEvent.eventNameForType(4), ImageOriginUtils.of("registrationName", "onLoadStart"), ImageLoadEvent.eventNameForType(2), ImageOriginUtils.of("registrationName", "onLoad"), ImageLoadEvent.eventNameForType(1), ImageOriginUtils.of("registrationName", "onError"), ImageLoadEvent.eventNameForType(3), ImageOriginUtils.of("registrationName", "onLoadEnd"));
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "blurRadius")
    public void setBlurRadius(ReactImageView reactImageView, float f2) {
        reactImageView.setBlurRadius(f2);
    }

    @ReactProp(customType = "Color", name = "borderColor")
    public void setBorderColor(ReactImageView reactImageView, Integer num) {
        if (num == null) {
            reactImageView.setBorderColor(0);
        } else {
            reactImageView.setBorderColor(num.intValue());
        }
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactImageView reactImageView, int i, float f2) {
        if (!ImageOriginUtils.isUndefined(f2)) {
            f2 = ImageOriginUtils.toPixelFromDIP(f2);
        }
        if (i == 0) {
            reactImageView.setBorderRadius(f2);
            return;
        }
        int i2 = i - 1;
        if (reactImageView.mBorderCornerRadii == null) {
            float[] fArr = new float[4];
            reactImageView.mBorderCornerRadii = fArr;
            Arrays.fill(fArr, Float.NaN);
        }
        if (!ImageOriginUtils.floatsEqual(reactImageView.mBorderCornerRadii[i2], f2)) {
            reactImageView.mBorderCornerRadii[i2] = f2;
            reactImageView.mIsDirty = true;
        }
    }

    @ReactProp(name = "borderWidth")
    public void setBorderWidth(ReactImageView reactImageView, float f2) {
        reactImageView.setBorderWidth(f2);
    }

    @ReactProp(name = "defaultSrc")
    public void setDefaultSource(ReactImageView reactImageView, String str) {
        reactImageView.setDefaultSource(str);
    }

    @ReactProp(name = "fadeDuration")
    public void setFadeDuration(ReactImageView reactImageView, int i) {
        reactImageView.setFadeDuration(i);
    }

    @ReactProp(name = "headers")
    public void setHeaders(ReactImageView reactImageView, ReadableMap readableMap) {
        reactImageView.setHeaders(readableMap);
    }

    @ReactProp(name = "internal_analyticTag")
    public void setInternal_AnalyticsTag(ReactImageView reactImageView, String str) {
        ReactCallerContextFactory reactCallerContextFactory = this.mCallerContextFactory;
        if (reactCallerContextFactory != null) {
            reactImageView.mCallerContext = reactCallerContextFactory.getOrCreateCallerContext((ThemedReactContext) reactImageView.getContext(), str);
            reactImageView.mIsDirty = true;
        }
    }

    @ReactProp(name = "shouldNotifyLoadEvents")
    public void setLoadHandlersRegistered(ReactImageView reactImageView, boolean z) {
        reactImageView.setShouldNotifyLoadEvents(z);
    }

    @ReactProp(name = "loadingIndicatorSrc")
    public void setLoadingIndicatorSource(ReactImageView reactImageView, String str) {
        reactImageView.setLoadingIndicatorSource(str);
    }

    @ReactProp(customType = "Color", name = "overlayColor")
    public void setOverlayColor(ReactImageView reactImageView, Integer num) {
        if (num == null) {
            reactImageView.setOverlayColor(0);
        } else {
            reactImageView.setOverlayColor(num.intValue());
        }
    }

    @ReactProp(name = "progressiveRenderingEnabled")
    public void setProgressiveRenderingEnabled(ReactImageView reactImageView, boolean z) {
        reactImageView.setProgressiveRenderingEnabled(z);
    }

    @ReactProp(name = "resizeMethod")
    public void setResizeMethod(ReactImageView reactImageView, String str) {
        if (str == null || "auto".equals(str)) {
            reactImageView.setResizeMethod(ImageResizeMethod.AUTO);
        } else if ("resize".equals(str)) {
            reactImageView.setResizeMethod(ImageResizeMethod.RESIZE);
        } else if ("scale".equals(str)) {
            reactImageView.setResizeMethod(ImageResizeMethod.SCALE);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline52("Invalid resize method: '", str, "'"));
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(ReactImageView reactImageView, String str) {
        TileMode tileMode;
        reactImageView.setScaleType(ImageOriginUtils.toScaleType(str));
        if ("contain".equals(str) || "cover".equals(str) || "stretch".equals(str) || "center".equals(str)) {
            tileMode = TileMode.CLAMP;
        } else if (ReactVideoViewManager.PROP_REPEAT.equals(str)) {
            tileMode = TileMode.REPEAT;
        } else if (str == null) {
            tileMode = TileMode.CLAMP;
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline52("Invalid resize mode: '", str, "'"));
        }
        reactImageView.setTileMode(tileMode);
    }

    @ReactProp(name = "src")
    public void setSource(ReactImageView reactImageView, ReadableArray readableArray) {
        reactImageView.setSource(readableArray);
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(ReactImageView reactImageView, Integer num) {
        if (num == null) {
            reactImageView.clearColorFilter();
        } else {
            reactImageView.setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    @Deprecated
    public ReactImageManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContext = obj;
        this.mCallerContextFactory = null;
    }

    public ReactImageView createViewInstance(ThemedReactContext themedReactContext) {
        Object obj;
        ReactCallerContextFactory reactCallerContextFactory = this.mCallerContextFactory;
        if (reactCallerContextFactory != null) {
            obj = reactCallerContextFactory.getOrCreateCallerContext(themedReactContext, null);
        } else {
            obj = getCallerContext();
        }
        return new ReactImageView(themedReactContext, getDraweeControllerBuilder(), this.mGlobalImageLoadListener, obj);
    }

    public void onAfterUpdateTransaction(ReactImageView reactImageView) {
        super.onAfterUpdateTransaction(reactImageView);
        reactImageView.maybeUpdateView();
    }

    public ReactImageManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, ReactCallerContextFactory reactCallerContextFactory) {
        this(abstractDraweeControllerBuilder, (GlobalImageLoadListener) null, reactCallerContextFactory);
    }

    public ReactImageManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, ReactCallerContextFactory reactCallerContextFactory) {
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContextFactory = reactCallerContextFactory;
        this.mCallerContext = null;
    }

    public ReactImageManager() {
        this.mDraweeControllerBuilder = null;
        this.mCallerContext = null;
        this.mCallerContextFactory = null;
    }
}
