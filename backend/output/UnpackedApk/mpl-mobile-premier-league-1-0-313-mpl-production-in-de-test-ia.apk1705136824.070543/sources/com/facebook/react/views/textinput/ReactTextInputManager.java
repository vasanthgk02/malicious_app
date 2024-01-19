package com.facebook.react.views.textinput;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTextViewManagerCallback;
import com.facebook.react.views.text.TextAttributeProps;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.TextTransform;
import com.mpl.payment.routing.RoutingConstants;
import com.rudderstack.android.sdk.core.RudderTraits;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import sfs2x.client.entities.invitation.InvitationReply;

@ReactModule(name = "AndroidTextInput")
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode> {
    public static final int AUTOCAPITALIZE_FLAGS = 28672;
    public static final int BLUR_TEXT_INPUT = 2;
    public static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
    public static final int FOCUS_TEXT_INPUT = 1;
    public static final int IME_ACTION_ID = 1648;
    public static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
    public static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    public static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
    public static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
    public static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
    public static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
    public static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    public static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    public static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
    public static final int PASSWORD_VISIBILITY_FLAG = 16;
    public static final String REACT_CLASS = "AndroidTextInput";
    public static final int SET_MOST_RECENT_EVENT_COUNT = 3;
    public static final int SET_TEXT_AND_SELECTION = 4;
    public static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    public static final String TAG = "ReactTextInputManager";
    public static final int UNSET = -1;
    public ReactTextViewManagerCallback mReactTextViewManagerCallback;

    public class ReactContentSizeWatcher implements ContentSizeWatcher {
        public ReactEditText mEditText;
        public EventDispatcher mEventDispatcher;
        public int mPreviousContentHeight = 0;
        public int mPreviousContentWidth = 0;

        public ReactContentSizeWatcher(ReactTextInputManager reactTextInputManager, ReactEditText reactEditText) {
            this.mEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ImageOriginUtils.getReactContext(reactEditText).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }
    }

    public class ReactScrollWatcher implements ScrollWatcher {
        public EventDispatcher mEventDispatcher;
        public int mPreviousHoriz;
        public int mPreviousVert;
        public ReactEditText mReactEditText;

        public ReactScrollWatcher(ReactTextInputManager reactTextInputManager, ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            this.mEventDispatcher = ReactTextInputManager.getEventDispatcher(ImageOriginUtils.getReactContext(reactEditText), reactEditText);
        }
    }

    public class ReactSelectionWatcher implements SelectionWatcher {
        public EventDispatcher mEventDispatcher;
        public int mPreviousSelectionEnd;
        public int mPreviousSelectionStart;
        public ReactEditText mReactEditText;

        public ReactSelectionWatcher(ReactTextInputManager reactTextInputManager, ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            this.mEventDispatcher = ReactTextInputManager.getEventDispatcher(ImageOriginUtils.getReactContext(reactEditText), reactEditText);
        }

        public void onSelectionChanged(int i, int i2) {
            int min = Math.min(i, i2);
            int max = Math.max(i, i2);
            if (this.mPreviousSelectionStart != min || this.mPreviousSelectionEnd != max) {
                this.mEventDispatcher.dispatchEvent(new ReactTextInputSelectionEvent(this.mReactEditText.getId(), min, max));
                this.mPreviousSelectionStart = min;
                this.mPreviousSelectionEnd = max;
            }
        }
    }

    public class ReactTextInputTextWatcher implements TextWatcher {
        public ReactEditText mEditText;
        public EventDispatcher mEventDispatcher;
        public String mPreviousText = null;

        public ReactTextInputTextWatcher(ReactTextInputManager reactTextInputManager, ReactContext reactContext, ReactEditText reactEditText) {
            this.mEventDispatcher = ReactTextInputManager.getEventDispatcher(reactContext, reactEditText);
            this.mEditText = reactEditText;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mPreviousText = charSequence.toString();
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str;
            int i4;
            String str2;
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            if (!this.mEditText.mDisableTextDiffing) {
                if (i7 != 0 || i6 != 0) {
                    ImageOriginUtils.assertNotNull(this.mPreviousText);
                    int i8 = i5 + i7;
                    String substring = charSequence.toString().substring(i5, i8);
                    int i9 = i5 + i6;
                    String substring2 = this.mPreviousText.substring(i5, i9);
                    if (i7 != i6 || !substring.equals(substring2)) {
                        JavaOnlyMap javaOnlyMap = this.mEditText.mAttributedString;
                        if (javaOnlyMap != null && javaOnlyMap.hasKey("fragments")) {
                            String charSequence2 = charSequence.subSequence(i5, i8).toString();
                            String string = javaOnlyMap.getString(NetworkingModule.REQUEST_BODY_KEY_STRING);
                            StringBuilder sb = new StringBuilder();
                            sb.append(string.substring(0, i5));
                            sb.append(charSequence2);
                            if (string.length() > i9) {
                                str = string.substring(i9);
                            } else {
                                str = "";
                            }
                            sb.append(str);
                            javaOnlyMap.putString(NetworkingModule.REQUEST_BODY_KEY_STRING, sb.toString());
                            JavaOnlyArray javaOnlyArray = (JavaOnlyArray) javaOnlyMap.getArray("fragments");
                            int i10 = 0;
                            boolean z = false;
                            int i11 = 0;
                            while (i10 < javaOnlyArray.size() && !z) {
                                JavaOnlyMap javaOnlyMap2 = (JavaOnlyMap) javaOnlyArray.getMap(i10);
                                String string2 = javaOnlyMap2.getString(NetworkingModule.REQUEST_BODY_KEY_STRING);
                                JavaOnlyArray javaOnlyArray2 = javaOnlyArray;
                                int length = string2.length() + i11;
                                if (length < i5) {
                                    i4 = length;
                                    str2 = substring2;
                                } else {
                                    int i12 = i5 - i11;
                                    int length2 = string2.length() - i12;
                                    i4 = length;
                                    StringBuilder sb2 = new StringBuilder();
                                    str2 = substring2;
                                    sb2.append(string2.substring(0, i12));
                                    sb2.append(charSequence2);
                                    sb2.append(string2.substring(Math.min(i6, length2) + i12));
                                    javaOnlyMap2.putString(NetworkingModule.REQUEST_BODY_KEY_STRING, sb2.toString());
                                    if (length2 < i6) {
                                        i5 += length2;
                                        i6 -= length2;
                                        charSequence2 = "";
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                }
                                i10++;
                                CharSequence charSequence3 = charSequence;
                                i11 = i4;
                                substring2 = str2;
                                javaOnlyArray = javaOnlyArray2;
                            }
                        }
                        String str3 = substring2;
                        int i13 = i5;
                        if (!(this.mEditText.mStateWrapper == null || javaOnlyMap == null)) {
                            WritableNativeMap writableNativeMap = new WritableNativeMap();
                            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                            WritableNativeArray writableNativeArray = new WritableNativeArray();
                            for (int i14 = 0; i14 < javaOnlyMap.getArray("fragments").size(); i14++) {
                                ReadableMap map = javaOnlyMap.getArray("fragments").getMap(i14);
                                WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                                writableNativeMap3.putDouble("reactTag", (double) map.getInt("reactTag"));
                                writableNativeMap3.putString(NetworkingModule.REQUEST_BODY_KEY_STRING, map.getString(NetworkingModule.REQUEST_BODY_KEY_STRING));
                                writableNativeArray.pushMap(writableNativeMap3);
                            }
                            writableNativeMap2.putString(NetworkingModule.REQUEST_BODY_KEY_STRING, javaOnlyMap.getString(NetworkingModule.REQUEST_BODY_KEY_STRING));
                            writableNativeMap2.putArray("fragments", writableNativeArray);
                            ReactEditText reactEditText = this.mEditText;
                            int i15 = reactEditText.mNativeEventCount + 1;
                            reactEditText.mNativeEventCount = i15;
                            writableNativeMap.putInt("mostRecentEventCount", i15);
                            writableNativeMap.putMap("textChanged", writableNativeMap2);
                            this.mEditText.mStateWrapper.updateState(writableNativeMap);
                        }
                        EventDispatcher eventDispatcher = this.mEventDispatcher;
                        int id = this.mEditText.getId();
                        String charSequence4 = charSequence.toString();
                        ReactEditText reactEditText2 = this.mEditText;
                        int i16 = reactEditText2.mNativeEventCount + 1;
                        reactEditText2.mNativeEventCount = i16;
                        eventDispatcher.dispatchEvent(new ReactTextChangedEvent(id, charSequence4, i16));
                        EventDispatcher eventDispatcher2 = this.mEventDispatcher;
                        ReactTextInputEvent reactTextInputEvent = new ReactTextInputEvent(this.mEditText.getId(), substring, str3, i13, i13 + i6);
                        eventDispatcher2.dispatchEvent(reactTextInputEvent);
                    }
                }
            }
        }
    }

    public static void checkPasswordType(ReactEditText reactEditText) {
        if ((reactEditText.getStagedInputType() & INPUT_TYPE_KEYBOARD_NUMBERED) != 0 && (reactEditText.getStagedInputType() & 128) != 0) {
            updateStagedInputTypeFlag(reactEditText, 128, 16);
        }
    }

    public static EventDispatcher getEventDispatcher(ReactContext reactContext, ReactEditText reactEditText) {
        return ImageOriginUtils.getEventDispatcherForReactTag(reactContext, reactEditText.getId());
    }

    private ReactTextUpdate getReactTextUpdate(String str, int i, int i2, int i3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str2 = str;
        spannableStringBuilder.append(TextTransform.apply(str, TextTransform.UNSET));
        ReactTextUpdate reactTextUpdate = new ReactTextUpdate(spannableStringBuilder, i, false, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, i2, i3);
        return reactTextUpdate;
    }

    private void setAutofillHints(ReactEditText reactEditText, String... strArr) {
        if (VERSION.SDK_INT >= 26) {
            reactEditText.setAutofillHints(strArr);
        }
    }

    public static void updateStagedInputTypeFlag(ReactEditText reactEditText, int i, int i2) {
        reactEditText.setStagedInputType(((~i) & reactEditText.getStagedInputType()) | i2);
    }

    public EditText createInternalEditText(ThemedReactContext themedReactContext) {
        return new EditText(themedReactContext);
    }

    public Map<String, Integer> getCommandsMap() {
        return ImageOriginUtils.of("focusTextInput", Integer.valueOf(1), "blurTextInput", Integer.valueOf(2));
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put("topSubmitEditing", ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture")));
        builder.put("topEndEditing", ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", "onEndEditing", "captured", "onEndEditingCapture")));
        builder.put("topTextInput", ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", "onTextInput", "captured", "onTextInputCapture")));
        builder.put("topFocus", ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", "onFocus", "captured", "onFocusCapture")));
        builder.put("topBlur", ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", "onBlur", "captured", "onBlurCapture")));
        builder.put("topKeyPress", ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", "onKeyPress", "captured", "onKeyPressCapture")));
        return builder.build();
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), ImageOriginUtils.of("registrationName", "onScroll"));
        return builder.build();
    }

    public Map getExportedViewConstants() {
        return ImageOriginUtils.of("AutoCapitalizationType", ImageOriginUtils.of("none", Integer.valueOf(0), "characters", Integer.valueOf(4096), "words", Integer.valueOf(8192), "sentences", Integer.valueOf(16384)));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ReactTextInputShadowNode.class;
    }

    @ReactProp(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(ReactEditText reactEditText, boolean z) {
        reactEditText.setAllowFontScaling(z);
    }

    @ReactProp(name = "autoCapitalize")
    public void setAutoCapitalize(ReactEditText reactEditText, Dynamic dynamic) {
        int i = 16384;
        if (dynamic.getType() == ReadableType.Number) {
            i = dynamic.asInt();
        } else if (dynamic.getType() == ReadableType.String) {
            String asString = dynamic.asString();
            if (asString.equals("none")) {
                i = 0;
            } else if (asString.equals("characters")) {
                i = 4096;
            } else if (asString.equals("words")) {
                i = 8192;
            } else {
                boolean equals = asString.equals("sentences");
            }
        }
        updateStagedInputTypeFlag(reactEditText, AUTOCAPITALIZE_FLAGS, i);
    }

    @ReactProp(name = "autoCorrect")
    public void setAutoCorrect(ReactEditText reactEditText, Boolean bool) {
        updateStagedInputTypeFlag(reactEditText, 557056, bool != null ? bool.booleanValue() ? 32768 : 524288 : 0);
    }

    @ReactProp(defaultBoolean = false, name = "autoFocus")
    public void setAutoFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setAutoFocus(z);
    }

    @ReactProp(name = "blurOnSubmit")
    public void setBlurOnSubmit(ReactEditText reactEditText, Boolean bool) {
        reactEditText.setBlurOnSubmit(bool);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactEditText reactEditText, int i, Integer num) {
        float f2 = Float.NaN;
        float intValue = num == null ? Float.NaN : (float) (num.intValue() & 16777215);
        if (num != null) {
            f2 = (float) (num.intValue() >>> 24);
        }
        reactEditText.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderColor(SPACING_TYPES[i], intValue, f2);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactEditText reactEditText, int i, float f2) {
        if (!ImageOriginUtils.isUndefined(f2)) {
            f2 = ImageOriginUtils.toPixelFromDIP(f2);
        }
        if (i == 0) {
            reactEditText.setBorderRadius(f2);
            return;
        }
        reactEditText.mReactBackgroundManager.getOrCreateReactViewBackground().setRadius(f2, i - 1);
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactEditText reactEditText, String str) {
        reactEditText.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactEditText reactEditText, int i, float f2) {
        if (!ImageOriginUtils.isUndefined(f2)) {
            f2 = ImageOriginUtils.toPixelFromDIP(f2);
        }
        reactEditText.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderWidth(SPACING_TYPES[i], f2);
    }

    @ReactProp(defaultBoolean = false, name = "caretHidden")
    public void setCaretHidden(ReactEditText reactEditText, boolean z) {
        reactEditText.setCursorVisible(!z);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            ColorStateList defaultTextAttribute = ImageOriginUtils.getDefaultTextAttribute(reactEditText.getContext(), 16842904);
            if (defaultTextAttribute != null) {
                reactEditText.setTextColor(defaultTextAttribute);
                return;
            }
            Context context = reactEditText.getContext();
            String str = TAG;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Could not get default text color from View Context: ");
            outline73.append(context != null ? context.getClass().getCanonicalName() : "null");
            ReactSoftException.logSoftException(str, new IllegalStateException(outline73.toString()));
            return;
        }
        reactEditText.setTextColor(num.intValue());
    }

    @ReactProp(defaultBoolean = false, name = "contextMenuHidden")
    public void setContextMenuHidden(ReactEditText reactEditText, final boolean z) {
        reactEditText.setOnLongClickListener(new OnLongClickListener(this) {
            public boolean onLongClick(View view) {
                return z;
            }
        });
    }

    @ReactProp(customType = "Color", name = "cursorColor")
    public void setCursorColor(ReactEditText reactEditText, Integer num) {
        if (num != null) {
            int i = VERSION.SDK_INT;
            if (i >= 29) {
                Drawable textCursorDrawable = reactEditText.getTextCursorDrawable();
                if (textCursorDrawable != null) {
                    textCursorDrawable.setColorFilter(new BlendModeColorFilter(num.intValue(), BlendMode.SRC_IN));
                    reactEditText.setTextCursorDrawable(textCursorDrawable);
                }
            } else if (i != 28) {
                try {
                    Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                    declaredField.setAccessible(true);
                    int i2 = declaredField.getInt(reactEditText);
                    if (i2 != 0) {
                        Drawable drawable = ContextCompat.getDrawable(reactEditText.getContext(), i2);
                        drawable.setColorFilter(num.intValue(), Mode.SRC_IN);
                        Drawable[] drawableArr = {drawable, drawable};
                        Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                        declaredField2.setAccessible(true);
                        Object obj = declaredField2.get(reactEditText);
                        Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
                        declaredField3.setAccessible(true);
                        declaredField3.set(obj, drawableArr);
                    }
                } catch (IllegalAccessException | NoSuchFieldException unused) {
                }
            }
        }
    }

    @ReactProp(defaultBoolean = false, name = "disableFullscreenUI")
    public void setDisableFullscreenUI(ReactEditText reactEditText, boolean z) {
        reactEditText.setDisableFullscreenUI(z);
    }

    @ReactProp(defaultBoolean = true, name = "editable")
    public void setEditable(ReactEditText reactEditText, boolean z) {
        reactEditText.setEnabled(z);
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(ReactEditText reactEditText, String str) {
        reactEditText.setFontFamily(str);
    }

    @ReactProp(defaultFloat = 14.0f, name = "fontSize")
    public void setFontSize(ReactEditText reactEditText, float f2) {
        reactEditText.setFontSize(f2);
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(ReactEditText reactEditText, String str) {
        reactEditText.setFontStyle(str);
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(ReactEditText reactEditText, String str) {
        reactEditText.setFontWeight(str);
    }

    @ReactProp(name = "importantForAutofill")
    public void setImportantForAutofill(ReactEditText reactEditText, String str) {
        int i;
        if ("no".equals(str)) {
            i = 2;
        } else if ("noExcludeDescendants".equals(str)) {
            i = 8;
        } else if ("yes".equals(str)) {
            i = 1;
        } else {
            i = "yesExcludeDescendants".equals(str) ? 4 : 0;
        }
        setImportantForAutofill(reactEditText, i);
    }

    @ReactProp(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(ReactEditText reactEditText, boolean z) {
        reactEditText.setIncludeFontPadding(z);
    }

    @ReactProp(name = "inlineImageLeft")
    public void setInlineImageLeft(ReactEditText reactEditText, String str) {
        reactEditText.setCompoundDrawablesWithIntrinsicBounds(ResourceDrawableIdHelper.getInstance().getResourceDrawableId(reactEditText.getContext(), str), 0, 0, 0);
    }

    @ReactProp(name = "inlineImagePadding")
    public void setInlineImagePadding(ReactEditText reactEditText, int i) {
        reactEditText.setCompoundDrawablePadding(i);
    }

    @ReactProp(name = "keyboardType")
    public void setKeyboardType(ReactEditText reactEditText, String str) {
        int i;
        if (KEYBOARD_TYPE_NUMERIC.equalsIgnoreCase(str)) {
            i = INPUT_TYPE_KEYBOARD_NUMBERED;
        } else if (KEYBOARD_TYPE_NUMBER_PAD.equalsIgnoreCase(str)) {
            i = 2;
        } else if (KEYBOARD_TYPE_DECIMAL_PAD.equalsIgnoreCase(str)) {
            i = 8194;
        } else if (KEYBOARD_TYPE_EMAIL_ADDRESS.equalsIgnoreCase(str)) {
            i = 33;
        } else if (KEYBOARD_TYPE_PHONE_PAD.equalsIgnoreCase(str)) {
            i = 3;
        } else {
            i = KEYBOARD_TYPE_VISIBLE_PASSWORD.equalsIgnoreCase(str) ? 144 : 1;
        }
        updateStagedInputTypeFlag(reactEditText, 15, i);
        checkPasswordType(reactEditText);
    }

    @ReactProp(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(ReactEditText reactEditText, float f2) {
        reactEditText.setLetterSpacingPt(f2);
    }

    @ReactProp(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(ReactEditText reactEditText, float f2) {
        reactEditText.setMaxFontSizeMultiplier(f2);
    }

    @ReactProp(name = "maxLength")
    public void setMaxLength(ReactEditText reactEditText, Integer num) {
        InputFilter[] filters = reactEditText.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        if (num == null) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < filters.length; i++) {
                    if (!(filters[i] instanceof LengthFilter)) {
                        linkedList.add(filters[i]);
                    }
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
        } else if (filters.length > 0) {
            boolean z = false;
            for (int i2 = 0; i2 < filters.length; i2++) {
                if (filters[i2] instanceof LengthFilter) {
                    filters[i2] = new LengthFilter(num.intValue());
                    z = true;
                }
            }
            if (!z) {
                InputFilter[] inputFilterArr2 = new InputFilter[(filters.length + 1)];
                System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
                filters[filters.length] = new LengthFilter(num.intValue());
                filters = inputFilterArr2;
            }
            inputFilterArr = filters;
        } else {
            inputFilterArr = new InputFilter[]{new LengthFilter(num.intValue())};
        }
        reactEditText.setFilters(inputFilterArr);
    }

    @ReactProp(defaultBoolean = false, name = "multiline")
    public void setMultiline(ReactEditText reactEditText, boolean z) {
        int i = 0;
        int i2 = z ? 0 : 131072;
        if (z) {
            i = 131072;
        }
        updateStagedInputTypeFlag(reactEditText, i2, i);
    }

    @ReactProp(defaultInt = 1, name = "numberOfLines")
    public void setNumLines(ReactEditText reactEditText, int i) {
        reactEditText.setLines(i);
    }

    @ReactProp(defaultBoolean = false, name = "onContentSizeChange")
    public void setOnContentSizeChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setContentSizeWatcher(new ReactContentSizeWatcher(this, reactEditText));
        } else {
            reactEditText.setContentSizeWatcher(null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onKeyPress")
    public void setOnKeyPress(ReactEditText reactEditText, boolean z) {
        reactEditText.setOnKeyPress(z);
    }

    @ReactProp(defaultBoolean = false, name = "onScroll")
    public void setOnScroll(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setScrollWatcher(new ReactScrollWatcher(this, reactEditText));
        } else {
            reactEditText.setScrollWatcher(null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onSelectionChange")
    public void setOnSelectionChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setSelectionWatcher(new ReactSelectionWatcher(this, reactEditText));
        } else {
            reactEditText.setSelectionWatcher(null);
        }
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(ReactEditText reactEditText, String str) {
        reactEditText.setHint(str);
    }

    @ReactProp(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setHintTextColor(ImageOriginUtils.getDefaultTextAttribute(reactEditText.getContext(), 16842906));
        } else {
            reactEditText.setHintTextColor(num.intValue());
        }
    }

    @ReactProp(name = "returnKeyLabel")
    public void setReturnKeyLabel(ReactEditText reactEditText, String str) {
        reactEditText.setImeActionLabel(str, IME_ACTION_ID);
    }

    @ReactProp(name = "returnKeyType")
    public void setReturnKeyType(ReactEditText reactEditText, String str) {
        reactEditText.setReturnKeyType(str);
    }

    @ReactProp(defaultBoolean = false, name = "secureTextEntry")
    public void setSecureTextEntry(ReactEditText reactEditText, boolean z) {
        int i = 0;
        int i2 = z ? 0 : 144;
        if (z) {
            i = 128;
        }
        updateStagedInputTypeFlag(reactEditText, i2, i);
        checkPasswordType(reactEditText);
    }

    @ReactProp(defaultBoolean = false, name = "selectTextOnFocus")
    public void setSelectTextOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setSelectAllOnFocus(z);
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setHighlightColor(ImageOriginUtils.getDefaultTextAttribute(reactEditText.getContext(), 16842905).getDefaultColor());
        } else {
            reactEditText.setHighlightColor(num.intValue());
        }
        setCursorColor(reactEditText, num);
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(ReactEditText reactEditText, String str) {
        if ("justify".equals(str)) {
            if (VERSION.SDK_INT >= 26) {
                reactEditText.setJustificationMode(1);
            }
            reactEditText.setGravityHorizontal(3);
            return;
        }
        if (VERSION.SDK_INT >= 26) {
            reactEditText.setJustificationMode(0);
        }
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityHorizontal(0);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_LEFT.equals(str)) {
            reactEditText.setGravityHorizontal(3);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT.equals(str)) {
            reactEditText.setGravityHorizontal(5);
        } else if ("center".equals(str)) {
            reactEditText.setGravityHorizontal(1);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid textAlign: ", str));
        }
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactEditText reactEditText, String str) {
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityVertical(0);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_TOP.equals(str)) {
            reactEditText.setGravityVertical(48);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM.equals(str)) {
            reactEditText.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactEditText.setGravityVertical(16);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid textAlignVertical: ", str));
        }
    }

    @ReactProp(name = "autoCompleteType")
    public void setTextContentType(ReactEditText reactEditText, String str) {
        if (str == null) {
            setImportantForAutofill(reactEditText, 2);
        } else if (RudderTraits.USERNAME_KEY.equals(str)) {
            setAutofillHints(reactEditText, RudderTraits.USERNAME_KEY);
        } else if ("password".equals(str)) {
            setAutofillHints(reactEditText, "password");
        } else if ("email".equals(str)) {
            setAutofillHints(reactEditText, "emailAddress");
        } else if ("name".equals(str)) {
            setAutofillHints(reactEditText, "name");
        } else if ("tel".equals(str)) {
            setAutofillHints(reactEditText, "phone");
        } else if ("street-address".equals(str)) {
            setAutofillHints(reactEditText, "postalAddress");
        } else if ("postal-code".equals(str)) {
            setAutofillHints(reactEditText, RoutingConstants.MI_REACT_POSTAL_CODE);
        } else if ("cc-number".equals(str)) {
            setAutofillHints(reactEditText, "creditCardNumber");
        } else if ("cc-csc".equals(str)) {
            setAutofillHints(reactEditText, "creditCardSecurityCode");
        } else if ("cc-exp".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationDate");
        } else if ("cc-exp-month".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationMonth");
        } else if ("cc-exp-year".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationYear");
        } else if (PDPrintFieldAttributeObject.CHECKED_STATE_OFF.equals(str)) {
            setImportantForAutofill(reactEditText, 2);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid autoCompleteType: ", str));
        }
    }

    @ReactProp(customType = "Color", name = "underlineColorAndroid")
    public void setUnderlineColor(ReactEditText reactEditText, Integer num) {
        Drawable background = reactEditText.getBackground();
        if (background.getConstantState() != null) {
            try {
                background = background.mutate();
            } catch (NullPointerException e2) {
                FLog.e(TAG, (String) "NullPointerException when setting underlineColorAndroid for TextInput", (Throwable) e2);
            }
        }
        if (num == null) {
            background.clearColorFilter();
        } else {
            background.setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    @ReactProp(defaultBoolean = true, name = "showSoftInputOnFocus")
    public void showKeyboardOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setShowSoftInputOnFocus(z);
    }

    public void addEventEmitters(final ThemedReactContext themedReactContext, final ReactEditText reactEditText) {
        reactEditText.addTextChangedListener(new ReactTextInputTextWatcher(this, themedReactContext, reactEditText));
        reactEditText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            public void onFocusChange(View view, boolean z) {
                EventDispatcher access$000 = ReactTextInputManager.getEventDispatcher(themedReactContext, reactEditText);
                if (z) {
                    access$000.dispatchEvent(new ReactTextInputFocusEvent(reactEditText.getId()));
                    return;
                }
                access$000.dispatchEvent(new ReactTextInputBlurEvent(reactEditText.getId()));
                access$000.dispatchEvent(new ReactTextInputEndEditingEvent(reactEditText.getId(), reactEditText.getText().toString()));
            }
        });
        reactEditText.setOnEditorActionListener(new OnEditorActionListener(this) {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean z = true;
                if ((i & InvitationReply.EXPIRED) == 0 && i != 0) {
                    return true;
                }
                boolean blurOnSubmit = reactEditText.getBlurOnSubmit();
                boolean isMultiline = reactEditText.isMultiline();
                ReactTextInputManager.getEventDispatcher(themedReactContext, reactEditText).dispatchEvent(new ReactTextInputSubmitEditingEvent(reactEditText.getId(), reactEditText.getText().toString()));
                if (blurOnSubmit) {
                    reactEditText.clearFocus();
                }
                if (!blurOnSubmit && isMultiline && i != 5 && i != 7) {
                    z = false;
                }
                return z;
            }
        });
    }

    public ReactBaseTextShadowNode createShadowNodeInstance() {
        return new ReactTextInputShadowNode(null);
    }

    public ReactEditText createViewInstance(ThemedReactContext themedReactContext) {
        ReactEditText reactEditText = new ReactEditText(themedReactContext);
        reactEditText.setInputType(reactEditText.getInputType() & -131073);
        reactEditText.setReturnKeyType("done");
        return reactEditText;
    }

    public void onAfterUpdateTransaction(ReactEditText reactEditText) {
        super.onAfterUpdateTransaction(reactEditText);
        if (reactEditText.mTypefaceDirty) {
            reactEditText.mTypefaceDirty = false;
            reactEditText.setTypeface(ImageOriginUtils.applyStyles(reactEditText.getTypeface(), reactEditText.mFontStyle, reactEditText.mFontWeight, reactEditText.mFontFamily, reactEditText.getContext().getAssets()));
        }
        if (reactEditText.getInputType() != reactEditText.mStagedInputType) {
            int selectionStart = reactEditText.getSelectionStart();
            int selectionEnd = reactEditText.getSelectionEnd();
            reactEditText.setInputType(reactEditText.mStagedInputType);
            reactEditText.setSelection(selectionStart, selectionEnd);
        }
    }

    public void setPadding(ReactEditText reactEditText, int i, int i2, int i3, int i4) {
        reactEditText.setPadding(i, i2, i3, i4);
    }

    public void updateExtraData(ReactEditText reactEditText, Object obj) {
        if (obj instanceof ReactTextUpdate) {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
            int i = (int) reactTextUpdate.mPaddingLeft;
            int i2 = (int) reactTextUpdate.mPaddingTop;
            int i3 = (int) reactTextUpdate.mPaddingRight;
            int i4 = (int) reactTextUpdate.mPaddingBottom;
            if (!(i == -1 && i2 == -1 && i3 == -1 && i4 == -1)) {
                if (i == -1) {
                    i = reactEditText.getPaddingLeft();
                }
                if (i2 == -1) {
                    i2 = reactEditText.getPaddingTop();
                }
                if (i3 == -1) {
                    i3 = reactEditText.getPaddingRight();
                }
                if (i4 == -1) {
                    i4 = reactEditText.getPaddingBottom();
                }
                reactEditText.setPadding(i, i2, i3, i4);
            }
            if (reactTextUpdate.mContainsImages) {
                TextInlineImageSpan.possiblyUpdateInlineImageSpans(reactTextUpdate.mText, reactEditText);
            }
            reactEditText.maybeSetText(reactTextUpdate);
            reactEditText.maybeSetSelection(reactTextUpdate.mJsEventCounter, reactTextUpdate.mSelectionStart, reactTextUpdate.mSelectionEnd);
        }
    }

    public Object updateState(ReactEditText reactEditText, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        ReadableNativeMap state = stateWrapper.getState();
        if (!state.getBoolean("hasThemeData")) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ReactContext reactContext = ImageOriginUtils.getReactContext(reactEditText);
            if (reactContext instanceof ThemedReactContext) {
                EditText createInternalEditText = createInternalEditText((ThemedReactContext) reactContext);
                writableNativeMap.putNull("textChanged");
                writableNativeMap.putDouble("themePaddingStart", (double) ImageOriginUtils.toDIPFromPixel((float) ViewCompat.getPaddingStart(createInternalEditText)));
                writableNativeMap.putDouble("themePaddingEnd", (double) ImageOriginUtils.toDIPFromPixel((float) createInternalEditText.getPaddingEnd()));
                writableNativeMap.putDouble("themePaddingTop", (double) ImageOriginUtils.toDIPFromPixel((float) createInternalEditText.getPaddingTop()));
                writableNativeMap.putDouble("themePaddingBottom", (double) ImageOriginUtils.toDIPFromPixel((float) createInternalEditText.getPaddingBottom()));
                stateWrapper.updateState(writableNativeMap);
            } else {
                String str = TAG;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("ReactContext is not a ThemedReactContent: ");
                outline73.append(reactContext != null ? reactContext.getClass().getName() : "null");
                ReactSoftException.logSoftException(str, new IllegalStateException(outline73.toString()));
            }
        }
        ReadableNativeMap map = state.getMap((String) "attributedString");
        ReadableNativeMap map2 = state.getMap((String) "paragraphAttributes");
        Spannable orCreateSpannableForText = TextLayoutManager.getOrCreateSpannableForText(reactEditText.getContext(), map, this.mReactTextViewManagerCallback);
        int textBreakStrategy = TextAttributeProps.getTextBreakStrategy(map2.getString("textBreakStrategy"));
        reactEditText.mStateWrapper = stateWrapper;
        ReactTextUpdate reactTextUpdate = new ReactTextUpdate(orCreateSpannableForText, state.getInt("mostRecentEventCount"), false, TextAttributeProps.getTextAlignment(reactStylesDiffMap), textBreakStrategy, TextAttributeProps.getJustificationMode(reactStylesDiffMap));
        reactTextUpdate.mAttributedString = map;
        return reactTextUpdate;
    }

    public void receiveCommand(ReactEditText reactEditText, int i, ReadableArray readableArray) {
        if (i == 1) {
            receiveCommand(reactEditText, (String) "focus", readableArray);
        } else if (i == 2) {
            receiveCommand(reactEditText, (String) "blur", readableArray);
        } else if (i == 4) {
            receiveCommand(reactEditText, (String) "setTextAndSelection", readableArray);
        }
    }

    public ReactBaseTextShadowNode createShadowNodeInstance(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return new ReactTextInputShadowNode(reactTextViewManagerCallback);
    }

    private void setImportantForAutofill(ReactEditText reactEditText, int i) {
        if (VERSION.SDK_INT >= 26) {
            reactEditText.setImportantForAutofill(i);
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.views.textinput.ReactEditText r8, java.lang.String r9, com.facebook.react.bridge.ReadableArray r10) {
        /*
            r7 = this;
            int r0 = r9.hashCode()
            r1 = 1
            r2 = -1
            r3 = 2
            r4 = 3
            r5 = 0
            r6 = 4
            switch(r0) {
                case -1699362314: goto L_0x0036;
                case 3027047: goto L_0x002c;
                case 97604824: goto L_0x0022;
                case 1427010500: goto L_0x0018;
                case 1690703013: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0040
        L_0x000e:
            java.lang.String r0 = "focusTextInput"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0040
            r9 = 1
            goto L_0x0041
        L_0x0018:
            java.lang.String r0 = "setTextAndSelection"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0040
            r9 = 4
            goto L_0x0041
        L_0x0022:
            java.lang.String r0 = "focus"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0041
        L_0x002c:
            java.lang.String r0 = "blur"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0040
            r9 = 2
            goto L_0x0041
        L_0x0036:
            java.lang.String r0 = "blurTextInput"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0040
            r9 = 3
            goto L_0x0041
        L_0x0040:
            r9 = -1
        L_0x0041:
            if (r9 == 0) goto L_0x0075
            if (r9 == r1) goto L_0x0075
            if (r9 == r3) goto L_0x0071
            if (r9 == r4) goto L_0x0071
            if (r9 == r6) goto L_0x004c
            goto L_0x0078
        L_0x004c:
            int r9 = r10.getInt(r5)
            if (r9 != r2) goto L_0x0053
            return
        L_0x0053:
            java.lang.String r0 = r10.getString(r1)
            int r3 = r10.getInt(r3)
            int r10 = r10.getInt(r4)
            if (r10 != r2) goto L_0x0062
            r10 = r3
        L_0x0062:
            com.facebook.react.views.text.ReactTextUpdate r0 = r7.getReactTextUpdate(r0, r9, r3, r10)
            r8.mIsSettingTextFromJS = r1
            r8.maybeSetText(r0)
            r8.mIsSettingTextFromJS = r5
            r8.maybeSetSelection(r9, r3, r10)
            goto L_0x0078
        L_0x0071:
            r8.clearFocus()
            goto L_0x0078
        L_0x0075:
            r8.requestFocusInternal()
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.receiveCommand(com.facebook.react.views.textinput.ReactEditText, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
