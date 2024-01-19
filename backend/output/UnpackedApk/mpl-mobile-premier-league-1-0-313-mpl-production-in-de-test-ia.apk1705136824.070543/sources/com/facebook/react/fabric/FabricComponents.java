package com.facebook.react.fabric;

import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.view.ReactViewManager;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationText;

public class FabricComponents {
    public static final Map<String, String> sComponentNames;

    static {
        HashMap hashMap = new HashMap();
        sComponentNames = hashMap;
        hashMap.put("View", ReactViewManager.REACT_CLASS);
        sComponentNames.put("Image", ReactImageManager.REACT_CLASS);
        sComponentNames.put("ScrollView", ReactScrollViewManager.REACT_CLASS);
        sComponentNames.put("Slider", ReactSliderManager.REACT_CLASS);
        sComponentNames.put("ModalHostView", ReactModalHostManager.REACT_CLASS);
        sComponentNames.put(PDAnnotationText.NAME_PARAGRAPH, ReactTextViewManager.REACT_CLASS);
        sComponentNames.put("Text", "RCText");
        sComponentNames.put("RawText", ReactRawTextManager.REACT_CLASS);
        sComponentNames.put("ActivityIndicatorView", ReactProgressBarViewManager.REACT_CLASS);
        sComponentNames.put("ShimmeringView", "RKShimmeringView");
        sComponentNames.put("TemplateView", "RCTTemplateView");
        sComponentNames.put("AxialGradientView", "RCTAxialGradientView");
        sComponentNames.put("Video", ReactVideoViewManager.REACT_CLASS);
        sComponentNames.put("StickerInputView", "RCTStickerInputView");
        sComponentNames.put("Map", "RCTMap");
        sComponentNames.put("WebView", "RCTWebView");
    }
}
