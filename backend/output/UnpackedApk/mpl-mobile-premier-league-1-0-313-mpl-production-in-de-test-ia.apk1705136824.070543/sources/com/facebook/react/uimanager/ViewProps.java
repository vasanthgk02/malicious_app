package com.facebook.react.uimanager;

import com.razorpay.AnalyticsConstants;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.Arrays;
import java.util.HashSet;

public class ViewProps {
    public static final int[] BORDER_SPACING_TYPES = {8, 4, 5, 1, 3, 0, 2};
    public static final HashSet<String> LAYOUT_ONLY_PROPS = new HashSet<>(Arrays.asList(new String[]{"alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "alignContent", "display", "position", RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT, RNGestureHandlerModule.KEY_HIT_SLOP_TOP, RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM, RNGestureHandlerModule.KEY_HIT_SLOP_LEFT, AnalyticsConstants.START, AnalyticsConstants.END, "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd"}));
    public static final int[] PADDING_MARGIN_SPACING_TYPES = {8, 7, 6, 4, 5, 1, 3, 0, 2};
}
