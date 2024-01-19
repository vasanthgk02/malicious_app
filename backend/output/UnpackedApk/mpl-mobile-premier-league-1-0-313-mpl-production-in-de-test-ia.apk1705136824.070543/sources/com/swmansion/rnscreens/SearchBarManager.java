package com.swmansion.rnscreens;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u001a\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0007J\u001f\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0007J\u001f\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u001f\u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001aJ\u001f\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001a¨\u0006%"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/SearchBarView;", "()V", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "onAfterUpdateTransaction", "", "view", "setAutoCapitalize", "autoCapitalize", "setAutoFocus", "autoFocus", "", "(Lcom/swmansion/rnscreens/SearchBarView;Ljava/lang/Boolean;)V", "setDisableBackButtonOverride", "disableBackButtonOverride", "setHeaderIconColor", "color", "", "(Lcom/swmansion/rnscreens/SearchBarView;Ljava/lang/Integer;)V", "setHintTextColor", "setInputType", "inputType", "setPlaceholder", "placeholder", "setShouldShowHintSearchIcon", "shouldShowHintSearchIcon", "setTextColor", "setTintColor", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ReactModule(name = "RNSSearchBar")
/* compiled from: SearchBarManager.kt */
public final class SearchBarManager extends ViewGroupManager<SearchBarView> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSSearchBar";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchBarManager.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put("onChangeText", ImageOriginUtils.of("registrationName", "onChangeText"));
        builder.put("onSearchButtonPress", ImageOriginUtils.of("registrationName", "onSearchButtonPress"));
        builder.put("onFocus", ImageOriginUtils.of("registrationName", "onFocus"));
        builder.put("onBlur", ImageOriginUtils.of("registrationName", "onBlur"));
        builder.put("onClose", ImageOriginUtils.of("registrationName", "onClose"));
        builder.put("onOpen", ImageOriginUtils.of("registrationName", "onOpen"));
        return builder.build();
    }

    public String getName() {
        return REACT_CLASS;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r3.equals("none") != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Forbidden auto capitalize value passed");
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "autoCapitalize")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setAutoCapitalize(com.swmansion.rnscreens.SearchBarView r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L_0x0041
            int r0 = r3.hashCode()
            switch(r0) {
                case 3387192: goto L_0x0030;
                case 113318569: goto L_0x0025;
                case 490141296: goto L_0x001a;
                case 1245424234: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0039
        L_0x000f:
            java.lang.String r0 = "characters"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.CHARACTERS
            goto L_0x0043
        L_0x001a:
            java.lang.String r0 = "sentences"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.SENTENCES
            goto L_0x0043
        L_0x0025:
            java.lang.String r0 = "words"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.WORDS
            goto L_0x0043
        L_0x0030:
            java.lang.String r0 = "none"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r3 = "Forbidden auto capitalize value passed"
            r2.<init>(r3)
            throw r2
        L_0x0041:
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.NONE
        L_0x0043:
            r2.setAutoCapitalize(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.SearchBarManager.setAutoCapitalize(com.swmansion.rnscreens.SearchBarView, java.lang.String):void");
    }

    @ReactProp(name = "autoFocus")
    public final void setAutoFocus(SearchBarView searchBarView, Boolean bool) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setAutoFocus(bool == null ? false : bool.booleanValue());
    }

    @ReactProp(name = "disableBackButtonOverride")
    public final void setDisableBackButtonOverride(SearchBarView searchBarView, Boolean bool) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setShouldOverrideBackButton(!Intrinsics.areEqual(bool, Boolean.TRUE));
    }

    @ReactProp(customType = "Color", name = "headerIconColor")
    public final void setHeaderIconColor(SearchBarView searchBarView, Integer num) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setHeaderIconColor(num);
    }

    @ReactProp(customType = "Color", name = "hintTextColor")
    public final void setHintTextColor(SearchBarView searchBarView, Integer num) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setHintTextColor(num);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r3.equals("text") != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Forbidden input type value");
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "inputType")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setInputType(com.swmansion.rnscreens.SearchBarView r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L_0x0041
            int r0 = r3.hashCode()
            switch(r0) {
                case -1034364087: goto L_0x002e;
                case 3556653: goto L_0x0025;
                case 96619420: goto L_0x001a;
                case 106642798: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0039
        L_0x000f:
            java.lang.String r0 = "phone"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.PHONE
            goto L_0x0043
        L_0x001a:
            java.lang.String r0 = "email"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.EMAIL
            goto L_0x0043
        L_0x0025:
            java.lang.String r0 = "text"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            goto L_0x0041
        L_0x002e:
            java.lang.String r0 = "number"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.NUMBER
            goto L_0x0043
        L_0x0039:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r3 = "Forbidden input type value"
            r2.<init>(r3)
            throw r2
        L_0x0041:
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.TEXT
        L_0x0043:
            r2.setInputType(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.SearchBarManager.setInputType(com.swmansion.rnscreens.SearchBarView, java.lang.String):void");
    }

    @ReactProp(name = "placeholder")
    public final void setPlaceholder(SearchBarView searchBarView, String str) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        if (str != null) {
            searchBarView.setPlaceholder(str);
        }
    }

    @ReactProp(name = "shouldShowHintSearchIcon")
    public final void setShouldShowHintSearchIcon(SearchBarView searchBarView, Boolean bool) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setShouldShowHintSearchIcon(bool == null ? true : bool.booleanValue());
    }

    @ReactProp(customType = "Color", name = "textColor")
    public final void setTextColor(SearchBarView searchBarView, Integer num) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setTextColor(num);
    }

    @ReactProp(customType = "Color", name = "barTintColor")
    public final void setTintColor(SearchBarView searchBarView, Integer num) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setTintColor(num);
    }

    public SearchBarView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new SearchBarView(themedReactContext);
    }

    public void onAfterUpdateTransaction(SearchBarView searchBarView) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        super.onAfterUpdateTransaction(searchBarView);
        searchBarView.setSearchViewProps();
    }
}
