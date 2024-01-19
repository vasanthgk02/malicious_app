package com.facebook.react.views.textinput;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTextViewManagerCallback;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;
import com.razorpay.AnalyticsConstants;

@TargetApi(23)
public class ReactTextInputShadowNode extends ReactBaseTextShadowNode implements YogaMeasureFunction {
    public EditText mInternalEditText;
    public ReactTextInputLocalData mLocalData;
    public int mMostRecentEventCount;
    public String mPlaceholder;
    public int mSelectionEnd;
    public int mSelectionStart;
    public String mText;

    public ReactTextInputShadowNode(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        super(reactTextViewManagerCallback);
        this.mMostRecentEventCount = -1;
        this.mText = null;
        this.mPlaceholder = null;
        this.mSelectionStart = -1;
        this.mSelectionEnd = -1;
        this.mTextBreakStrategy = VERSION.SDK_INT < 23 ? 0 : 1;
        setMeasureFunction(this);
    }

    public boolean isVirtualAnchor() {
        return true;
    }

    public boolean isYogaLeafNode() {
        return true;
    }

    public long measure(YogaNode yogaNode, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
        EditText editText = this.mInternalEditText;
        ImageOriginUtils.assertNotNull(editText);
        EditText editText2 = editText;
        ReactTextInputLocalData reactTextInputLocalData = this.mLocalData;
        if (reactTextInputLocalData != null) {
            editText2.setText(reactTextInputLocalData.mText);
            editText2.setTextSize(0, reactTextInputLocalData.mTextSize);
            editText2.setMinLines(reactTextInputLocalData.mMinLines);
            editText2.setMaxLines(reactTextInputLocalData.mMaxLines);
            editText2.setInputType(reactTextInputLocalData.mInputType);
            editText2.setHint(reactTextInputLocalData.mPlaceholder);
            if (VERSION.SDK_INT >= 23) {
                editText2.setBreakStrategy(reactTextInputLocalData.mBreakStrategy);
            }
        } else {
            editText2.setTextSize(0, (float) this.mTextAttributes.getEffectiveFontSize());
            int i = this.mNumberOfLines;
            if (i != -1) {
                editText2.setLines(i);
            }
            if (VERSION.SDK_INT >= 23) {
                int breakStrategy = editText2.getBreakStrategy();
                int i2 = this.mTextBreakStrategy;
                if (breakStrategy != i2) {
                    editText2.setBreakStrategy(i2);
                }
            }
        }
        editText2.setHint(this.mPlaceholder);
        editText2.measure(ImageOriginUtils.getMeasureSpec(f2, yogaMeasureMode), ImageOriginUtils.getMeasureSpec(f3, yogaMeasureMode2));
        return ImageOriginUtils.make(editText2.getMeasuredWidth(), editText2.getMeasuredHeight());
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        if (this.mMostRecentEventCount != -1) {
            ReactTextUpdate reactTextUpdate = new ReactTextUpdate(spannedFromShadowNode(this, this.mText, false, null), this.mMostRecentEventCount, this.mContainsImages, getPadding(0), getPadding(1), getPadding(2), getPadding(3), this.mTextAlign, this.mTextBreakStrategy, this.mJustificationMode, this.mSelectionStart, this.mSelectionEnd);
            uIViewOperationQueue.enqueueUpdateExtraData(this.mReactTag, reactTextUpdate);
        }
    }

    public void setLocalData(Object obj) {
        ImageOriginUtils.assertCondition(obj instanceof ReactTextInputLocalData);
        this.mLocalData = (ReactTextInputLocalData) obj;
        dirty();
    }

    @ReactProp(name = "mostRecentEventCount")
    public void setMostRecentEventCount(int i) {
        this.mMostRecentEventCount = i;
    }

    public void setPadding(int i, float f2) {
        this.mPadding[i] = f2;
        this.mPaddingIsPercent[i] = false;
        updatePadding();
        markUpdated();
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(String str) {
        this.mPlaceholder = str;
        markUpdated();
    }

    @ReactProp(name = "selection")
    public void setSelection(ReadableMap readableMap) {
        this.mSelectionEnd = -1;
        this.mSelectionStart = -1;
        if (readableMap != null && readableMap.hasKey(AnalyticsConstants.START) && readableMap.hasKey(AnalyticsConstants.END)) {
            this.mSelectionStart = readableMap.getInt(AnalyticsConstants.START);
            this.mSelectionEnd = readableMap.getInt(AnalyticsConstants.END);
            markUpdated();
        }
    }

    @ReactProp(name = "text")
    public void setText(String str) {
        this.mText = str;
        if (str != null) {
            if (this.mSelectionStart > str.length()) {
                this.mSelectionStart = str.length();
            }
            if (this.mSelectionEnd > str.length()) {
                this.mSelectionEnd = str.length();
            }
        } else {
            this.mSelectionStart = -1;
            this.mSelectionEnd = -1;
        }
        markUpdated();
    }

    public void setTextBreakStrategy(String str) {
        if (VERSION.SDK_INT >= 23) {
            if (str == null || "simple".equals(str)) {
                this.mTextBreakStrategy = 0;
            } else if ("highQuality".equals(str)) {
                this.mTextBreakStrategy = 1;
            } else if ("balanced".equals(str)) {
                this.mTextBreakStrategy = 2;
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid textBreakStrategy: ", str));
            }
        }
    }

    public void setThemedContext(ThemedReactContext themedReactContext) {
        this.mThemedContext = themedReactContext;
        EditText editText = new EditText(getThemedContext());
        setDefaultPadding(4, (float) ViewCompat.getPaddingStart(editText));
        setDefaultPadding(1, (float) editText.getPaddingTop());
        setDefaultPadding(5, (float) editText.getPaddingEnd());
        setDefaultPadding(3, (float) editText.getPaddingBottom());
        this.mInternalEditText = editText;
        editText.setPadding(0, 0, 0, 0);
        this.mInternalEditText.setLayoutParams(new LayoutParams(-2, -2));
    }

    public ReactTextInputShadowNode() {
        this(null);
    }
}
