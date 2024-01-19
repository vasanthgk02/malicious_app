package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.OnCloseListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002LMB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\fH\u0002J\b\u0010>\u001a\u00020;H\u0002J\u0012\u0010?\u001a\u00020;2\b\u0010@\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010A\u001a\u00020;2\b\u0010@\u001a\u0004\u0018\u00010%H\u0002J\b\u0010B\u001a\u00020;H\u0014J\u0006\u0010C\u001a\u00020;J\u001a\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020%2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\u0010\u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u00020;H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010+8BX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\u001a\u00101\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0010R\u001e\u00104\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R\u001e\u00107\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016¨\u0006N"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarView;", "Lcom/facebook/react/views/view/ReactViewGroup;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "autoCapitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "getAutoCapitalize", "()Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "setAutoCapitalize", "(Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;)V", "autoFocus", "", "getAutoFocus", "()Z", "setAutoFocus", "(Z)V", "headerIconColor", "", "getHeaderIconColor", "()Ljava/lang/Integer;", "setHeaderIconColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "hintTextColor", "getHintTextColor", "setHintTextColor", "inputType", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "getInputType", "()Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "setInputType", "(Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;)V", "mAreListenersSet", "mSearchViewFormatter", "Lcom/swmansion/rnscreens/SearchViewFormatter;", "placeholder", "", "getPlaceholder", "()Ljava/lang/String;", "setPlaceholder", "(Ljava/lang/String;)V", "screenStackFragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "getScreenStackFragment", "()Lcom/swmansion/rnscreens/ScreenStackFragment;", "shouldOverrideBackButton", "getShouldOverrideBackButton", "setShouldOverrideBackButton", "shouldShowHintSearchIcon", "getShouldShowHintSearchIcon", "setShouldShowHintSearchIcon", "textColor", "getTextColor", "setTextColor", "tintColor", "getTintColor", "setTintColor", "handleClose", "", "handleFocusChange", "hasFocus", "handleOpen", "handleTextChange", "newText", "handleTextSubmit", "onAttachedToWindow", "onUpdate", "sendEvent", "eventName", "eventContent", "Lcom/facebook/react/bridge/WritableMap;", "setSearchViewListeners", "searchView", "Landroidx/appcompat/widget/SearchView;", "setSearchViewProps", "SearchBarAutoCapitalize", "SearchBarInputTypes", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* compiled from: SearchBarView.kt */
public final class SearchBarView extends ReactViewGroup {
    public SearchBarAutoCapitalize autoCapitalize = SearchBarAutoCapitalize.NONE;
    public boolean autoFocus;
    public Integer headerIconColor;
    public Integer hintTextColor;
    public SearchBarInputTypes inputType = SearchBarInputTypes.TEXT;
    public boolean mAreListenersSet;
    public SearchViewFormatter mSearchViewFormatter;
    public String placeholder = "";
    public boolean shouldOverrideBackButton = true;
    public boolean shouldShowHintSearchIcon = true;
    public Integer textColor;
    public Integer tintColor;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "", "(Ljava/lang/String;I)V", "NONE", "WORDS", "SENTENCES", "CHARACTERS", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchBarView.kt */
    public enum SearchBarAutoCapitalize {
        NONE,
        WORDS,
        SENTENCES,
        CHARACTERS
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "", "(Ljava/lang/String;I)V", "toAndroidInputType", "", "capitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "TEXT", "PHONE", "NUMBER", "EMAIL", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchBarView.kt */
    public enum SearchBarInputTypes {
        ;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes$EMAIL;", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "toAndroidInputType", "", "capitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SearchBarView.kt */
        public static final class EMAIL extends SearchBarInputTypes {
            public EMAIL(String str, int i) {
                super(str, i, null);
            }

            public int toAndroidInputType(SearchBarAutoCapitalize searchBarAutoCapitalize) {
                Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "capitalize");
                return 32;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes$NUMBER;", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "toAndroidInputType", "", "capitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SearchBarView.kt */
        public static final class NUMBER extends SearchBarInputTypes {
            public NUMBER(String str, int i) {
                super(str, i, null);
            }

            public int toAndroidInputType(SearchBarAutoCapitalize searchBarAutoCapitalize) {
                Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "capitalize");
                return 2;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes$PHONE;", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "toAndroidInputType", "", "capitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SearchBarView.kt */
        public static final class PHONE extends SearchBarInputTypes {
            public PHONE(String str, int i) {
                super(str, i, null);
            }

            public int toAndroidInputType(SearchBarAutoCapitalize searchBarAutoCapitalize) {
                Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "capitalize");
                return 3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes$TEXT;", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarInputTypes;", "toAndroidInputType", "", "capitalize", "Lcom/swmansion/rnscreens/SearchBarView$SearchBarAutoCapitalize;", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SearchBarView.kt */
        public static final class TEXT extends SearchBarInputTypes {
            public TEXT(String str, int i) {
                super(str, i, null);
            }

            public int toAndroidInputType(SearchBarAutoCapitalize searchBarAutoCapitalize) {
                Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "capitalize");
                int ordinal = searchBarAutoCapitalize.ordinal();
                if (ordinal == 0) {
                    return 1;
                }
                if (ordinal == 1) {
                    return 8192;
                }
                if (ordinal == 2) {
                    return 16384;
                }
                if (ordinal == 3) {
                    return 4096;
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        public abstract int toAndroidInputType(SearchBarAutoCapitalize searchBarAutoCapitalize);
    }

    public SearchBarView(ReactContext reactContext) {
        super(reactContext);
    }

    public static final void access$handleTextChange(SearchBarView searchBarView, String str) {
        if (searchBarView != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("text", str);
            searchBarView.sendEvent("onChangeText", createMap);
            return;
        }
        throw null;
    }

    public static final void access$handleTextSubmit(SearchBarView searchBarView, String str) {
        if (searchBarView != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("text", str);
            searchBarView.sendEvent("onSearchButtonPress", createMap);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public final ScreenStackFragment getScreenStackFragment() {
        ViewParent parent = getParent();
        if (!(parent instanceof ScreenStackHeaderSubview)) {
            return null;
        }
        ScreenStackHeaderConfig config = ((ScreenStackHeaderSubview) parent).getConfig();
        if (config == null) {
            return null;
        }
        return config.getScreenFragment();
    }

    private final void setSearchViewListeners(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchBarView$setSearchViewListeners$1(this));
        searchView.setOnQueryTextFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                SearchBarView.m110setSearchViewListeners$lambda0(SearchBarView.this, view, z);
            }
        });
        searchView.setOnCloseListener(new OnCloseListener() {
            public final boolean onClose() {
                return SearchBarView.m111setSearchViewListeners$lambda1(SearchBarView.this);
            }
        });
        searchView.setOnSearchClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SearchBarView.m112setSearchViewListeners$lambda2(SearchBarView.this, view);
            }
        });
    }

    /* renamed from: setSearchViewListeners$lambda-0  reason: not valid java name */
    public static final void m110setSearchViewListeners$lambda0(SearchBarView searchBarView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(searchBarView, "this$0");
        searchBarView.sendEvent(z ? "onFocus" : "onBlur", null);
    }

    /* renamed from: setSearchViewListeners$lambda-1  reason: not valid java name */
    public static final boolean m111setSearchViewListeners$lambda1(SearchBarView searchBarView) {
        Intrinsics.checkNotNullParameter(searchBarView, "this$0");
        searchBarView.sendEvent("onClose", null);
        return false;
    }

    /* renamed from: setSearchViewListeners$lambda-2  reason: not valid java name */
    public static final void m112setSearchViewListeners$lambda2(SearchBarView searchBarView, View view) {
        Intrinsics.checkNotNullParameter(searchBarView, "this$0");
        searchBarView.sendEvent("onOpen", null);
    }

    public final SearchBarAutoCapitalize getAutoCapitalize() {
        return this.autoCapitalize;
    }

    public final boolean getAutoFocus() {
        return this.autoFocus;
    }

    public final Integer getHeaderIconColor() {
        return this.headerIconColor;
    }

    public final Integer getHintTextColor() {
        return this.hintTextColor;
    }

    public final SearchBarInputTypes getInputType() {
        return this.inputType;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final boolean getShouldOverrideBackButton() {
        return this.shouldOverrideBackButton;
    }

    public final boolean getShouldShowHintSearchIcon() {
        return this.shouldShowHintSearchIcon;
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    public final Integer getTintColor() {
        return this.tintColor;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment != null) {
            screenStackFragment.onSearchViewCreate = new SearchBarView$onAttachedToWindow$1(this);
        }
    }

    public final void sendEvent(String str, WritableMap writableMap) {
        Context context = getContext();
        if (context != null) {
            RCTEventEmitter rCTEventEmitter = (RCTEventEmitter) ((ReactContext) context).getJSModule(RCTEventEmitter.class);
            if (rCTEventEmitter != null) {
                rCTEventEmitter.receiveEvent(getId(), str, writableMap);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
    }

    public final void setAutoCapitalize(SearchBarAutoCapitalize searchBarAutoCapitalize) {
        Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "<set-?>");
        this.autoCapitalize = searchBarAutoCapitalize;
    }

    public final void setAutoFocus(boolean z) {
        this.autoFocus = z;
    }

    public final void setHeaderIconColor(Integer num) {
        this.headerIconColor = num;
    }

    public final void setHintTextColor(Integer num) {
        this.hintTextColor = num;
    }

    public final void setInputType(SearchBarInputTypes searchBarInputTypes) {
        Intrinsics.checkNotNullParameter(searchBarInputTypes, "<set-?>");
        this.inputType = searchBarInputTypes;
    }

    public final void setPlaceholder(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.placeholder = str;
    }

    public final void setSearchViewProps() {
        CustomSearchView customSearchView;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        Integer num = null;
        if (screenStackFragment == null) {
            customSearchView = null;
        } else {
            customSearchView = screenStackFragment.searchView;
        }
        if (customSearchView != null) {
            if (!this.mAreListenersSet) {
                setSearchViewListeners(customSearchView);
                this.mAreListenersSet = true;
            }
            customSearchView.setInputType(this.inputType.toAndroidInputType(this.autoCapitalize));
            SearchViewFormatter searchViewFormatter = this.mSearchViewFormatter;
            if (searchViewFormatter != null) {
                Integer num2 = this.textColor;
                Integer num3 = searchViewFormatter.mDefaultTextColor;
                if (num2 != null) {
                    if (num3 == null) {
                        EditText searchEditText = searchViewFormatter.getSearchEditText();
                        if (searchEditText != null) {
                            ColorStateList textColors = searchEditText.getTextColors();
                            if (textColors != null) {
                                num = Integer.valueOf(textColors.getDefaultColor());
                            }
                        }
                        searchViewFormatter.mDefaultTextColor = num;
                    }
                    EditText searchEditText2 = searchViewFormatter.getSearchEditText();
                    if (searchEditText2 != null) {
                        searchEditText2.setTextColor(num2.intValue());
                    }
                } else if (num3 != null) {
                    EditText searchEditText3 = searchViewFormatter.getSearchEditText();
                    if (searchEditText3 != null) {
                        searchEditText3.setTextColor(num3.intValue());
                    }
                }
            }
            SearchViewFormatter searchViewFormatter2 = this.mSearchViewFormatter;
            if (searchViewFormatter2 != null) {
                Integer num4 = this.tintColor;
                Drawable drawable = searchViewFormatter2.mDefaultTintBackground;
                if (num4 != null) {
                    if (drawable == null) {
                        searchViewFormatter2.mDefaultTintBackground = searchViewFormatter2.getSearchTextPlate().getBackground();
                    }
                    searchViewFormatter2.getSearchTextPlate().setBackgroundColor(num4.intValue());
                } else if (drawable != null) {
                    searchViewFormatter2.getSearchTextPlate().setBackground(drawable);
                }
            }
            SearchViewFormatter searchViewFormatter3 = this.mSearchViewFormatter;
            if (searchViewFormatter3 != null) {
                Integer num5 = this.headerIconColor;
                if (num5 != null) {
                    int intValue = num5.intValue();
                    ((ImageView) searchViewFormatter3.searchView.findViewById(R$id.search_button)).setColorFilter(intValue);
                    ((ImageView) searchViewFormatter3.searchView.findViewById(R$id.search_close_btn)).setColorFilter(intValue);
                }
            }
            SearchViewFormatter searchViewFormatter4 = this.mSearchViewFormatter;
            if (searchViewFormatter4 != null) {
                Integer num6 = this.hintTextColor;
                if (num6 != null) {
                    int intValue2 = num6.intValue();
                    EditText searchEditText4 = searchViewFormatter4.getSearchEditText();
                    if (searchEditText4 != null) {
                        searchEditText4.setHintTextColor(intValue2);
                    }
                }
            }
            SearchViewFormatter searchViewFormatter5 = this.mSearchViewFormatter;
            if (searchViewFormatter5 != null) {
                String str = this.placeholder;
                boolean z = this.shouldShowHintSearchIcon;
                Intrinsics.checkNotNullParameter(str, "placeholder");
                if (z) {
                    searchViewFormatter5.searchView.setQueryHint(str);
                } else {
                    EditText searchEditText5 = searchViewFormatter5.getSearchEditText();
                    if (searchEditText5 != null) {
                        searchEditText5.setHint(str);
                    }
                }
            }
            customSearchView.setOverrideBackAction(this.shouldOverrideBackButton);
        }
    }

    public final void setShouldOverrideBackButton(boolean z) {
        this.shouldOverrideBackButton = z;
    }

    public final void setShouldShowHintSearchIcon(boolean z) {
        this.shouldShowHintSearchIcon = z;
    }

    public final void setTextColor(Integer num) {
        this.textColor = num;
    }

    public final void setTintColor(Integer num) {
        this.tintColor = num;
    }
}
