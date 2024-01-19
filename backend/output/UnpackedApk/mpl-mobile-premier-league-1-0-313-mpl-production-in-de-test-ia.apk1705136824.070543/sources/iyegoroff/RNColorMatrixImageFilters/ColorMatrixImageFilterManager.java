package iyegoroff.RNColorMatrixImageFilters;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewManager;

@ReactModule(name = "CMIFColorMatrixImageFilter")
public class ColorMatrixImageFilterManager extends ReactViewManager {
    public static final String PROP_MATRIX = "matrix";
    public static final String REACT_CLASS = "CMIFColorMatrixImageFilter";

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "matrix")
    public void setMatrix(ColorMatrixImageFilter colorMatrixImageFilter, ReadableArray readableArray) {
        colorMatrixImageFilter.setMatrix(readableArray);
    }

    public ColorMatrixImageFilter createViewInstance(ThemedReactContext themedReactContext) {
        return new ColorMatrixImageFilter(themedReactContext);
    }
}
