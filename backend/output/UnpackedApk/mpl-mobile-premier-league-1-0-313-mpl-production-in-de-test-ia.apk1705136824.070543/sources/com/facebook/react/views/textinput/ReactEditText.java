package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.ReactSpan;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextAttributes;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageSpan;
import com.facebook.react.views.textinput.ReactTextInputManager.ReactContentSizeWatcher;
import com.facebook.react.views.textinput.ReactTextInputManager.ReactScrollWatcher;
import com.facebook.react.views.textinput.ReactTextInputManager.ReactSelectionWatcher;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.paho.android.service.MqttServiceConstants;

public class ReactEditText extends AppCompatEditText {
    public static final KeyListener sKeyListener = QwertyKeyListener.getInstanceForFullKeyboard();
    public JavaOnlyMap mAttributedString = null;
    public boolean mAutoFocus = false;
    public Boolean mBlurOnSubmit;
    public boolean mContainsImages;
    public ContentSizeWatcher mContentSizeWatcher;
    public int mDefaultGravityHorizontal;
    public int mDefaultGravityVertical;
    public boolean mDetectScrollMovement = false;
    public boolean mDidAttachToWindow = false;
    public boolean mDisableFullscreen;
    public boolean mDisableTextDiffing = false;
    public String mFontFamily = null;
    public int mFontStyle = -1;
    public int mFontWeight = -1;
    public final InputMethodManager mInputMethodManager;
    public boolean mIsSettingTextFromJS;
    public final InternalKeyListener mKeyListener;
    public ArrayList<TextWatcher> mListeners;
    public int mNativeEventCount;
    public boolean mOnKeyPress = false;
    public ReactViewBackgroundManager mReactBackgroundManager;
    public String mReturnKeyType;
    public ScrollWatcher mScrollWatcher;
    public SelectionWatcher mSelectionWatcher;
    public int mStagedInputType;
    public StateWrapper mStateWrapper = null;
    public TextAttributes mTextAttributes;
    public TextWatcherDelegator mTextWatcherDelegator;
    public boolean mTypefaceDirty = false;

    public static class InternalKeyListener implements KeyListener {
        public int mInputType = 0;

        public void clearMetaKeyState(View view, Editable editable, int i) {
            ReactEditText.sKeyListener.clearMetaKeyState(view, editable, i);
        }

        public int getInputType() {
            return this.mInputType;
        }

        public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyDown(view, editable, i, keyEvent);
        }

        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyOther(view, editable, keyEvent);
        }

        public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyUp(view, editable, i, keyEvent);
        }
    }

    public class TextWatcherDelegator implements TextWatcher {
        public TextWatcherDelegator(AnonymousClass1 r2) {
        }

        public void afterTextChanged(Editable editable) {
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.mIsSettingTextFromJS) {
                ArrayList<TextWatcher> arrayList = reactEditText.mListeners;
                if (arrayList != null) {
                    Iterator<TextWatcher> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().afterTextChanged(editable);
                    }
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.mIsSettingTextFromJS) {
                ArrayList<TextWatcher> arrayList = reactEditText.mListeners;
                if (arrayList != null) {
                    Iterator<TextWatcher> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().beforeTextChanged(charSequence, i, i2, i3);
                    }
                }
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.mIsSettingTextFromJS) {
                ArrayList<TextWatcher> arrayList = reactEditText.mListeners;
                if (arrayList != null) {
                    Iterator<TextWatcher> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().onTextChanged(charSequence, i, i2, i3);
                    }
                }
            }
            ReactEditText.this.onContentSizeChange();
        }
    }

    public ReactEditText(Context context) {
        super(context, null);
        setFocusableInTouchMode(false);
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        Object systemService = context.getSystemService("input_method");
        ImageOriginUtils.assertNotNull(systemService);
        this.mInputMethodManager = (InputMethodManager) systemService;
        this.mDefaultGravityHorizontal = getGravity() & 8388615;
        this.mDefaultGravityVertical = getGravity() & 112;
        this.mNativeEventCount = 0;
        this.mIsSettingTextFromJS = false;
        this.mBlurOnSubmit = null;
        this.mDisableFullscreen = false;
        this.mListeners = null;
        this.mTextWatcherDelegator = null;
        this.mStagedInputType = getInputType();
        this.mKeyListener = new InternalKeyListener();
        this.mScrollWatcher = null;
        this.mTextAttributes = new TextAttributes();
        applyTextAttributes();
        int i = VERSION.SDK_INT;
        if (i >= 26 && i <= 27) {
            setLayerType(1, null);
        }
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() {
            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                if (i == 16) {
                    return ReactEditText.this.requestFocusInternal();
                }
                return super.performAccessibilityAction(view, i, bundle);
            }
        });
    }

    private TextWatcherDelegator getTextWatcherDelegator() {
        if (this.mTextWatcherDelegator == null) {
            this.mTextWatcherDelegator = new TextWatcherDelegator(null);
        }
        return this.mTextWatcherDelegator;
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        this.mListeners.add(textWatcher);
    }

    public void applyTextAttributes() {
        setTextSize(0, (float) this.mTextAttributes.getEffectiveFontSize());
        float effectiveLetterSpacing = this.mTextAttributes.getEffectiveLetterSpacing();
        if (!Float.isNaN(effectiveLetterSpacing)) {
            setLetterSpacing(effectiveLetterSpacing);
        }
    }

    public void clearFocus() {
        setFocusableInTouchMode(false);
        super.clearFocus();
        this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public boolean getBlurOnSubmit() {
        Boolean bool = this.mBlurOnSubmit;
        if (bool == null) {
            return !isMultiline();
        }
        return bool.booleanValue();
    }

    public boolean getDisableFullscreenUI() {
        return this.mDisableFullscreen;
    }

    public String getReturnKeyType() {
        return this.mReturnKeyType;
    }

    public int getStagedInputType() {
        return this.mStagedInputType;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                if (((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDrawable == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public boolean isLayoutRequested() {
        return false;
    }

    public boolean isMultiline() {
        return (getInputType() & 131072) != 0;
    }

    public void maybeSetSelection(int i, int i2, int i3) {
        if (!(!(i >= this.mNativeEventCount) || i2 == -1 || i3 == -1)) {
            setSelection(i2, i3);
        }
    }

    public void maybeSetText(ReactTextUpdate reactTextUpdate) {
        boolean z;
        if (!((getInputType() & 144) != 0) || !TextUtils.equals(getText(), reactTextUpdate.mText)) {
            if (reactTextUpdate.mJsEventCounter >= this.mNativeEventCount) {
                ReadableMap readableMap = reactTextUpdate.mAttributedString;
                if (readableMap != null) {
                    this.mAttributedString = JavaOnlyMap.deepClone(readableMap);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(reactTextUpdate.mText);
                Object[] spans = getText().getSpans(0, length(), Object.class);
                for (int i = 0; i < spans.length; i++) {
                    if (spans[i] instanceof ReactSpan) {
                        getText().removeSpan(spans[i]);
                    }
                    if ((getText().getSpanFlags(spans[i]) & 33) == 33) {
                        Object obj = spans[i];
                        int spanStart = getText().getSpanStart(spans[i]);
                        int spanEnd = getText().getSpanEnd(spans[i]);
                        int spanFlags = getText().getSpanFlags(spans[i]);
                        getText().removeSpan(spans[i]);
                        Editable text = getText();
                        if (spanStart <= spannableStringBuilder.length() && spanEnd <= spannableStringBuilder.length()) {
                            int i2 = spanStart;
                            while (true) {
                                if (i2 >= spanEnd) {
                                    z = true;
                                    break;
                                } else if (text.charAt(i2) != spannableStringBuilder.charAt(i2)) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                        }
                    }
                }
                this.mContainsImages = reactTextUpdate.mContainsImages;
                this.mDisableTextDiffing = true;
                if (reactTextUpdate.mText.length() == 0) {
                    setText(null);
                } else {
                    getText().replace(0, length(), spannableStringBuilder);
                }
                this.mDisableTextDiffing = false;
                if (VERSION.SDK_INT >= 23) {
                    int breakStrategy = getBreakStrategy();
                    int i3 = reactTextUpdate.mTextBreakStrategy;
                    if (breakStrategy != i3) {
                        setBreakStrategy(i3);
                    }
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onAttach();
            }
        }
        if (this.mAutoFocus && !this.mDidAttachToWindow) {
            requestFocusInternal();
        }
        this.mDidAttachToWindow = true;
    }

    public final void onContentSizeChange() {
        ContentSizeWatcher contentSizeWatcher = this.mContentSizeWatcher;
        if (contentSizeWatcher != null) {
            ReactContentSizeWatcher reactContentSizeWatcher = (ReactContentSizeWatcher) contentSizeWatcher;
            int width = reactContentSizeWatcher.mEditText.getWidth();
            int height = reactContentSizeWatcher.mEditText.getHeight();
            if (reactContentSizeWatcher.mEditText.getLayout() != null) {
                width = reactContentSizeWatcher.mEditText.getCompoundPaddingRight() + reactContentSizeWatcher.mEditText.getLayout().getWidth() + reactContentSizeWatcher.mEditText.getCompoundPaddingLeft();
                height = reactContentSizeWatcher.mEditText.getCompoundPaddingBottom() + reactContentSizeWatcher.mEditText.getLayout().getHeight() + reactContentSizeWatcher.mEditText.getCompoundPaddingTop();
            }
            if (!(width == reactContentSizeWatcher.mPreviousContentWidth && height == reactContentSizeWatcher.mPreviousContentHeight)) {
                reactContentSizeWatcher.mPreviousContentHeight = height;
                reactContentSizeWatcher.mPreviousContentWidth = width;
                reactContentSizeWatcher.mEventDispatcher.dispatchEvent(new ReactContentSizeChangedEvent(reactContentSizeWatcher.mEditText.getId(), ImageOriginUtils.toDIPFromPixel((float) width), ImageOriginUtils.toDIPFromPixel((float) height)));
            }
        }
        if (this.mStateWrapper == null) {
            ReactContext reactContext = ImageOriginUtils.getReactContext(this);
            ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).setViewLocalData(getId(), new ReactTextInputLocalData(this));
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        ReactContext reactContext = ImageOriginUtils.getReactContext(this);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && this.mOnKeyPress) {
            onCreateInputConnection = new ReactEditTextInputConnectionWrapper(onCreateInputConnection, reactContext, this);
        }
        if (isMultiline() && getBlurOnSubmit()) {
            editorInfo.imeOptions &= -1073741825;
        }
        return onCreateInputConnection;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onDetach();
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onAttach();
            }
        }
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            SelectionWatcher selectionWatcher = this.mSelectionWatcher;
            if (selectionWatcher != null) {
                ((ReactSelectionWatcher) selectionWatcher).onSelectionChanged(getSelectionStart(), getSelectionEnd());
            }
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 66 || isMultiline()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return true;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onContentSizeChange();
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ScrollWatcher scrollWatcher = this.mScrollWatcher;
        if (scrollWatcher != null) {
            ReactScrollWatcher reactScrollWatcher = (ReactScrollWatcher) scrollWatcher;
            if (reactScrollWatcher.mPreviousHoriz != i || reactScrollWatcher.mPreviousVert != i2) {
                reactScrollWatcher.mEventDispatcher.dispatchEvent(ScrollEvent.obtain(reactScrollWatcher.mReactEditText.getId(), ScrollEventType.SCROLL, i, i2, 0.0f, 0.0f, 0, 0, reactScrollWatcher.mReactEditText.getWidth(), reactScrollWatcher.mReactEditText.getHeight()));
                reactScrollWatcher.mPreviousHoriz = i;
                reactScrollWatcher.mPreviousVert = i2;
            }
        }
    }

    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.mSelectionWatcher != null && hasFocus()) {
            ((ReactSelectionWatcher) this.mSelectionWatcher).onSelectionChanged(i, i2);
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onDetach();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDetectScrollMovement = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && this.mDetectScrollMovement) {
            if (!canScrollVertically(-1) && !canScrollVertically(1) && !canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.mDetectScrollMovement = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        ArrayList<TextWatcher> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.remove(textWatcher);
            if (this.mListeners.isEmpty()) {
                this.mListeners = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    public boolean requestFocus(int i, Rect rect) {
        return isFocused();
    }

    public final boolean requestFocusInternal() {
        setFocusableInTouchMode(true);
        boolean requestFocus = super.requestFocus(130, null);
        if (getShowSoftInputOnFocus()) {
            this.mInputMethodManager.showSoftInput(this, 0);
        }
        return requestFocus;
    }

    public void setAllowFontScaling(boolean z) {
        TextAttributes textAttributes = this.mTextAttributes;
        if (textAttributes.mAllowFontScaling != z) {
            textAttributes.mAllowFontScaling = z;
            applyTextAttributes();
        }
    }

    public void setAutoFocus(boolean z) {
        this.mAutoFocus = z;
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBlurOnSubmit(Boolean bool) {
        this.mBlurOnSubmit = bool;
    }

    public void setBorderRadius(float f2) {
        this.mReactBackgroundManager.setBorderRadius(f2);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setContentSizeWatcher(ContentSizeWatcher contentSizeWatcher) {
        this.mContentSizeWatcher = contentSizeWatcher;
    }

    public void setDisableFullscreenUI(boolean z) {
        this.mDisableFullscreen = z;
        updateImeOptions();
    }

    public void setFontFamily(String str) {
        this.mFontFamily = str;
        this.mTypefaceDirty = true;
    }

    public void setFontSize(float f2) {
        this.mTextAttributes.mFontSize = f2;
        applyTextAttributes();
    }

    public void setFontStyle(String str) {
        int parseFontStyle = ImageOriginUtils.parseFontStyle(str);
        if (parseFontStyle != this.mFontStyle) {
            this.mFontStyle = parseFontStyle;
            this.mTypefaceDirty = true;
        }
    }

    public void setFontWeight(String str) {
        int parseFontWeight = ImageOriginUtils.parseFontWeight(str);
        if (parseFontWeight != this.mFontWeight) {
            this.mFontWeight = parseFontWeight;
            this.mTypefaceDirty = true;
        }
    }

    public void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & -8 & -8388616));
    }

    public void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & -113));
    }

    public void setInputType(int i) {
        Typeface typeface = super.getTypeface();
        if (i == 32 && VERSION.SDK_INT == 29 && Build.MANUFACTURER.startsWith("Xiaomi")) {
            i = 1;
        }
        super.setInputType(i);
        this.mStagedInputType = i;
        super.setTypeface(typeface);
        if (isMultiline()) {
            setSingleLine(false);
        }
        InternalKeyListener internalKeyListener = this.mKeyListener;
        internalKeyListener.mInputType = i;
        setKeyListener(internalKeyListener);
    }

    public void setLetterSpacingPt(float f2) {
        this.mTextAttributes.mLetterSpacing = f2;
        applyTextAttributes();
    }

    public void setMaxFontSizeMultiplier(float f2) {
        TextAttributes textAttributes = this.mTextAttributes;
        if (f2 != textAttributes.mMaxFontSizeMultiplier) {
            textAttributes.setMaxFontSizeMultiplier(f2);
            applyTextAttributes();
        }
    }

    public void setOnKeyPress(boolean z) {
        this.mOnKeyPress = z;
    }

    public void setReturnKeyType(String str) {
        this.mReturnKeyType = str;
        updateImeOptions();
    }

    public void setScrollWatcher(ScrollWatcher scrollWatcher) {
        this.mScrollWatcher = scrollWatcher;
    }

    public void setSelection(int i, int i2) {
        super.setSelection(i, i2);
    }

    public void setSelectionWatcher(SelectionWatcher selectionWatcher) {
        this.mSelectionWatcher = selectionWatcher;
    }

    public void setStagedInputType(int i) {
        this.mStagedInputType = i;
    }

    public final void updateImeOptions() {
        String str = this.mReturnKeyType;
        int i = 4;
        if (str != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1273775369:
                    if (str.equals("previous")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -906336856:
                    if (str.equals("search")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3304:
                    if (str.equals("go")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals(MqttServiceConstants.SEND_ACTION)) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    i = 2;
                    break;
                case 1:
                    i = 5;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 7;
                    break;
                case 4:
                    i = 3;
                    break;
                case 5:
                    break;
            }
        }
        i = 6;
        if (this.mDisableFullscreen) {
            setImeOptions(33554432 | i);
        } else {
            setImeOptions(i);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                if (((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDrawable == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }
}
