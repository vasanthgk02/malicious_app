package com.facebook.reactnative.androidsdk;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.SendButton;

public class FBSendButtonManager extends SimpleViewManager<SendButton> {
    public static final String REACT_CLASS = "RCTFBSendButton";

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "shareContent")
    public void setShareContent(SendButton sendButton, ReadableMap readableMap) {
        ShareContent buildShareContent = ImageOriginUtils.buildShareContent(readableMap);
        if (buildShareContent != null) {
            sendButton.setShareContent(buildShareContent);
        }
    }

    public SendButton createViewInstance(ThemedReactContext themedReactContext) {
        return new SendButton(themedReactContext);
    }
}
