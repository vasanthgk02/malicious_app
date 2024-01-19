package com.facebook.react.uimanager;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNative;
import com.facebook.yoga.YogaNodeJNIBase;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;

public class LayoutShadowNode extends ReactShadowNodeImpl {
    public final MutableYogaValue mTempYogaValue = new MutableYogaValue(null);

    public static class MutableYogaValue {
        public YogaUnit unit;
        public float value;

        public MutableYogaValue(AnonymousClass1 r1) {
        }

        public void setFromDynamic(Dynamic dynamic) {
            if (dynamic.isNull()) {
                this.unit = YogaUnit.UNDEFINED;
                this.value = Float.NaN;
            } else if (dynamic.getType() == ReadableType.String) {
                String asString = dynamic.asString();
                if (asString.equals("auto")) {
                    this.unit = YogaUnit.AUTO;
                    this.value = Float.NaN;
                } else if (asString.endsWith("%")) {
                    this.unit = YogaUnit.PERCENT;
                    this.value = Float.parseFloat(asString.substring(0, asString.length() - 1));
                } else {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Unknown value: ", asString));
                }
            } else {
                this.unit = YogaUnit.POINT;
                this.value = ImageOriginUtils.toPixelFromDIP(dynamic.asDouble());
            }
        }
    }

    public final int maybeTransformLeftRightToStartEnd(int i) {
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(getThemedContext())) {
            return i;
        }
        if (i == 0) {
            return 4;
        }
        if (i != 2) {
            return i;
        }
        return 5;
    }

    @ReactProp(name = "alignContent")
    public void setAlignContent(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignContent(YogaAlign.FLEX_START);
                return;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    setAlignContent(YogaAlign.AUTO);
                    return;
                case 1:
                    setAlignContent(YogaAlign.FLEX_START);
                    return;
                case 2:
                    setAlignContent(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignContent(YogaAlign.FLEX_END);
                    return;
                case 4:
                    setAlignContent(YogaAlign.STRETCH);
                    return;
                case 5:
                    setAlignContent(YogaAlign.BASELINE);
                    return;
                case 6:
                    setAlignContent(YogaAlign.SPACE_BETWEEN);
                    return;
                case 7:
                    setAlignContent(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("invalid value for alignContent: ", str));
            }
        }
    }

    @ReactProp(name = "alignItems")
    public void setAlignItems(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignItems(YogaAlign.STRETCH);
                return;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    setAlignItems(YogaAlign.AUTO);
                    return;
                case 1:
                    setAlignItems(YogaAlign.FLEX_START);
                    return;
                case 2:
                    setAlignItems(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignItems(YogaAlign.FLEX_END);
                    return;
                case 4:
                    setAlignItems(YogaAlign.STRETCH);
                    return;
                case 5:
                    setAlignItems(YogaAlign.BASELINE);
                    return;
                case 6:
                    setAlignItems(YogaAlign.SPACE_BETWEEN);
                    return;
                case 7:
                    setAlignItems(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("invalid value for alignItems: ", str));
            }
        }
    }

    @ReactProp(name = "alignSelf")
    public void setAlignSelf(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignSelf(YogaAlign.AUTO);
                return;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    setAlignSelf(YogaAlign.AUTO);
                    return;
                case 1:
                    setAlignSelf(YogaAlign.FLEX_START);
                    return;
                case 2:
                    setAlignSelf(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignSelf(YogaAlign.FLEX_END);
                    return;
                case 4:
                    setAlignSelf(YogaAlign.STRETCH);
                    return;
                case 5:
                    setAlignSelf(YogaAlign.BASELINE);
                    return;
                case 6:
                    setAlignSelf(YogaAlign.SPACE_BETWEEN);
                    return;
                case 7:
                    setAlignSelf(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("invalid value for alignSelf: ", str));
            }
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "aspectRatio")
    public void setAspectRatio(float f2) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f2);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
    public void setBorderWidths(int i, float f2) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.BORDER_SPACING_TYPES[i]);
            YogaNative.jni_YGNodeStyleSetBorderJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(maybeTransformLeftRightToStartEnd).intValue(), ImageOriginUtils.toPixelFromDIP(f2));
        }
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(boolean z) {
    }

    @ReactProp(name = "display")
    public void setDisplay(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setDisplay(YogaDisplay.FLEX);
                return;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3145721) {
                if (hashCode == 3387192 && str.equals("none")) {
                    c2 = 1;
                }
            } else if (str.equals("flex")) {
                c2 = 0;
            }
            if (c2 == 0) {
                setDisplay(YogaDisplay.FLEX);
            } else if (c2 == 1) {
                setDisplay(YogaDisplay.NONE);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("invalid value for display: ", str));
            }
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flex")
    public void setFlex(float f2) {
        if (!isVirtual()) {
            YogaNative.jni_YGNodeStyleSetFlexJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f2);
        }
    }

    @ReactProp(name = "flexBasis")
    public void setFlexBasis(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetFlexBasisJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 3) {
                YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "flexDirection")
    public void setFlexDirection(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setFlexDirection(YogaFlexDirection.COLUMN);
                return;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1448970769:
                    if (str.equals("row-reverse")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1354837162:
                    if (str.equals("column")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 113114:
                    if (str.equals("row")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1272730475:
                    if (str.equals("column-reverse")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                setFlexDirection(YogaFlexDirection.COLUMN);
            } else if (c2 == 1) {
                setFlexDirection(YogaFlexDirection.COLUMN_REVERSE);
            } else if (c2 == 2) {
                setFlexDirection(YogaFlexDirection.ROW);
            } else if (c2 == 3) {
                setFlexDirection(YogaFlexDirection.ROW_REVERSE);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("invalid value for flexDirection: ", str));
            }
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flexGrow")
    public void setFlexGrow(float f2) {
        if (!isVirtual()) {
            YogaNative.jni_YGNodeStyleSetFlexGrowJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f2);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flexShrink")
    public void setFlexShrink(float f2) {
        if (!isVirtual()) {
            YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f2);
        }
    }

    @ReactProp(name = "flexWrap")
    public void setFlexWrap(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setFlexWrap(YogaWrap.NO_WRAP);
                return;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1039592053) {
                if (hashCode != -749527969) {
                    if (hashCode == 3657802 && str.equals("wrap")) {
                        c2 = 1;
                    }
                } else if (str.equals("wrap-reverse")) {
                    c2 = 2;
                }
            } else if (str.equals("nowrap")) {
                c2 = 0;
            }
            if (c2 == 0) {
                setFlexWrap(YogaWrap.NO_WRAP);
            } else if (c2 == 1) {
                setFlexWrap(YogaWrap.WRAP);
            } else if (c2 == 2) {
                setFlexWrap(YogaWrap.WRAP_REVERSE);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("invalid value for flexWrap: ", str));
            }
        }
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                setStyleHeight(this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetHeightPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 3) {
                YogaNative.jni_YGNodeStyleSetHeightAutoJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "justifyContent")
    public void setJustifyContent(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setJustifyContent(YogaJustify.FLEX_START);
                return;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2055030478:
                    if (str.equals("space-evenly")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                setJustifyContent(YogaJustify.FLEX_START);
            } else if (c2 == 1) {
                setJustifyContent(YogaJustify.CENTER);
            } else if (c2 == 2) {
                setJustifyContent(YogaJustify.FLEX_END);
            } else if (c2 == 3) {
                setJustifyContent(YogaJustify.SPACE_BETWEEN);
            } else if (c2 == 4) {
                setJustifyContent(YogaJustify.SPACE_AROUND);
            } else if (c2 == 5) {
                setJustifyContent(YogaJustify.SPACE_EVENLY);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("invalid value for justifyContent: ", str));
            }
        }
    }

    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                setMargin(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetMarginPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(maybeTransformLeftRightToStartEnd).intValue(), this.mTempYogaValue.value);
            } else if (ordinal == 3) {
                YogaNative.jni_YGNodeStyleSetMarginAutoJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(maybeTransformLeftRightToStartEnd).intValue());
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "maxHeight")
    public void setMaxHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetMaxHeightJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "maxWidth")
    public void setMaxWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetMaxWidthJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "minHeight")
    public void setMinHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetMinHeightJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "minWidth")
    public void setMinWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetMinWidthJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "overflow")
    public void setOverflow(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setOverflow(YogaOverflow.VISIBLE);
                return;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1217487446) {
                if (hashCode != -907680051) {
                    if (hashCode == 466743410 && str.equals("visible")) {
                        c2 = 0;
                    }
                } else if (str.equals("scroll")) {
                    c2 = 2;
                }
            } else if (str.equals("hidden")) {
                c2 = 1;
            }
            if (c2 == 0) {
                setOverflow(YogaOverflow.VISIBLE);
            } else if (c2 == 1) {
                setOverflow(YogaOverflow.HIDDEN);
            } else if (c2 == 2) {
                setOverflow(YogaOverflow.SCROLL);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("invalid value for overflow: ", str));
            }
        }
    }

    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                setPadding(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                float f2 = this.mTempYogaValue.value;
                this.mPadding[maybeTransformLeftRightToStartEnd] = f2;
                this.mPaddingIsPercent[maybeTransformLeftRightToStartEnd] = !ImageOriginUtils.isUndefined(f2);
                updatePadding();
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "position")
    public void setPosition(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setPositionType(YogaPositionType.RELATIVE);
                return;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -554435892) {
                if (hashCode == 1728122231 && str.equals("absolute")) {
                    c2 = 1;
                }
            } else if (str.equals("relative")) {
                c2 = 0;
            }
            if (c2 == 0) {
                setPositionType(YogaPositionType.RELATIVE);
            } else if (c2 == 1) {
                setPositionType(YogaPositionType.ABSOLUTE);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("invalid value for position: ", str));
            }
        }
    }

    @ReactPropGroup(names = {"start", "end", "left", "right", "top", "bottom"})
    public void setPositionValues(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(new int[]{4, 5, 0, 2, 1, 3}[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetPositionJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(maybeTransformLeftRightToStartEnd).intValue(), this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetPositionPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(maybeTransformLeftRightToStartEnd).intValue(), this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z) {
        this.mShouldNotifyOnLayout = z;
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                setStyleWidth(this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetWidthPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 3) {
                YogaNative.jni_YGNodeStyleSetWidthAutoJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
            }
            dynamic.recycle();
        }
    }
}
