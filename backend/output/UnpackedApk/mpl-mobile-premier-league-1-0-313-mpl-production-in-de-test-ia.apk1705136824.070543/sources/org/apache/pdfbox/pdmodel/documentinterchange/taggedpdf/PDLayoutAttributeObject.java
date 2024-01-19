package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDAttributeObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;

public class PDLayoutAttributeObject extends PDStandardAttributeObject {
    public static final String BACKGROUND_COLOR = "BackgroundColor";
    public static final String BASELINE_SHIFT = "BaselineShift";
    public static final String BBOX = "BBox";
    public static final String BLOCK_ALIGN = "BlockAlign";
    public static final String BLOCK_ALIGN_AFTER = "After";
    public static final String BLOCK_ALIGN_BEFORE = "Before";
    public static final String BLOCK_ALIGN_JUSTIFY = "Justify";
    public static final String BLOCK_ALIGN_MIDDLE = "Middle";
    public static final String BORDER_COLOR = "BorderColor";
    public static final String BORDER_STYLE = "BorderStyle";
    public static final String BORDER_STYLE_DASHED = "Dashed";
    public static final String BORDER_STYLE_DOTTED = "Dotted";
    public static final String BORDER_STYLE_DOUBLE = "Double";
    public static final String BORDER_STYLE_GROOVE = "Groove";
    public static final String BORDER_STYLE_HIDDEN = "Hidden";
    public static final String BORDER_STYLE_INSET = "Inset";
    public static final String BORDER_STYLE_NONE = "None";
    public static final String BORDER_STYLE_OUTSET = "Outset";
    public static final String BORDER_STYLE_RIDGE = "Ridge";
    public static final String BORDER_STYLE_SOLID = "Solid";
    public static final String BORDER_THICKNESS = "BorderThickness";
    public static final String COLOR = "Color";
    public static final String COLUMN_COUNT = "ColumnCount";
    public static final String COLUMN_GAP = "ColumnGap";
    public static final String COLUMN_WIDTHS = "ColumnWidths";
    public static final String END_INDENT = "EndIndent";
    public static final String GLYPH_ORIENTATION_VERTICAL = "GlyphOrientationVertical";
    public static final String GLYPH_ORIENTATION_VERTICAL_180_DEGREES = "180";
    public static final String GLYPH_ORIENTATION_VERTICAL_270_DEGREES = "270";
    public static final String GLYPH_ORIENTATION_VERTICAL_360_DEGREES = "360";
    public static final String GLYPH_ORIENTATION_VERTICAL_90_DEGREES = "90";
    public static final String GLYPH_ORIENTATION_VERTICAL_AUTO = "Auto";
    public static final String GLYPH_ORIENTATION_VERTICAL_MINUS_180_DEGREES = "-180";
    public static final String GLYPH_ORIENTATION_VERTICAL_MINUS_90_DEGREES = "-90";
    public static final String GLYPH_ORIENTATION_VERTICAL_ZERO_DEGREES = "0";
    public static final String HEIGHT = "Height";
    public static final String HEIGHT_AUTO = "Auto";
    public static final String INLINE_ALIGN = "InlineAlign";
    public static final String INLINE_ALIGN_CENTER = "Center";
    public static final String INLINE_ALIGN_END = "End";
    public static final String INLINE_ALIGN_START = "Start";
    public static final String LINE_HEIGHT = "LineHeight";
    public static final String LINE_HEIGHT_AUTO = "Auto";
    public static final String LINE_HEIGHT_NORMAL = "Normal";
    public static final String OWNER_LAYOUT = "Layout";
    public static final String PADDING = "Padding";
    public static final String PLACEMENT = "Placement";
    public static final String PLACEMENT_BEFORE = "Before";
    public static final String PLACEMENT_BLOCK = "Block";
    public static final String PLACEMENT_END = "End";
    public static final String PLACEMENT_INLINE = "Inline";
    public static final String PLACEMENT_START = "Start";
    public static final String RUBY_ALIGN = "RubyAlign";
    public static final String RUBY_ALIGN_CENTER = "Center";
    public static final String RUBY_ALIGN_DISTRIBUTE = "Distribute";
    public static final String RUBY_ALIGN_END = "End";
    public static final String RUBY_ALIGN_JUSTIFY = "Justify";
    public static final String RUBY_ALIGN_START = "Start";
    public static final String RUBY_POSITION = "RubyPosition";
    public static final String RUBY_POSITION_AFTER = "After";
    public static final String RUBY_POSITION_BEFORE = "Before";
    public static final String RUBY_POSITION_INLINE = "Inline";
    public static final String RUBY_POSITION_WARICHU = "Warichu";
    public static final String SPACE_AFTER = "SpaceAfter";
    public static final String SPACE_BEFORE = "SpaceBefore";
    public static final String START_INDENT = "StartIndent";
    public static final String TEXT_ALIGN = "TextAlign";
    public static final String TEXT_ALIGN_CENTER = "Center";
    public static final String TEXT_ALIGN_END = "End";
    public static final String TEXT_ALIGN_JUSTIFY = "Justify";
    public static final String TEXT_ALIGN_START = "Start";
    public static final String TEXT_DECORATION_COLOR = "TextDecorationColor";
    public static final String TEXT_DECORATION_THICKNESS = "TextDecorationThickness";
    public static final String TEXT_DECORATION_TYPE = "TextDecorationType";
    public static final String TEXT_DECORATION_TYPE_LINE_THROUGH = "LineThrough";
    public static final String TEXT_DECORATION_TYPE_NONE = "None";
    public static final String TEXT_DECORATION_TYPE_OVERLINE = "Overline";
    public static final String TEXT_DECORATION_TYPE_UNDERLINE = "Underline";
    public static final String TEXT_INDENT = "TextIndent";
    public static final String T_BORDER_STYLE = "TBorderStyle";
    public static final String T_PADDING = "TPadding";
    public static final String WIDTH = "Width";
    public static final String WIDTH_AUTO = "Auto";
    public static final String WRITING_MODE = "WritingMode";
    public static final String WRITING_MODE_LRTB = "LrTb";
    public static final String WRITING_MODE_RLTB = "RlTb";
    public static final String WRITING_MODE_TBRL = "TbRl";

    public PDLayoutAttributeObject() {
        setOwner(OWNER_LAYOUT);
    }

    public PDRectangle getBBox() {
        COSArray cOSArray = (COSArray) getCOSDictionary().getDictionaryObject((String) BBOX);
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return null;
    }

    public PDGamma getBackgroundColor() {
        return getColor(BACKGROUND_COLOR);
    }

    public float getBaselineShift() {
        return getNumber(BASELINE_SHIFT, 0.0f);
    }

    public String getBlockAlign() {
        return getName(BLOCK_ALIGN, "Before");
    }

    public Object getBorderColors() {
        return getColorOrFourColors(BORDER_COLOR);
    }

    public Object getBorderStyle() {
        return getNameOrArrayOfName(BORDER_STYLE, "None");
    }

    public Object getBorderThickness() {
        return getNumberOrArrayOfNumber(BORDER_THICKNESS, -1.0f);
    }

    public PDGamma getColor() {
        return getColor(COLOR);
    }

    public int getColumnCount() {
        return getInteger(COLUMN_COUNT, 1);
    }

    public Object getColumnGap() {
        return getNumberOrArrayOfNumber(COLUMN_GAP, -1.0f);
    }

    public Object getColumnWidths() {
        return getNumberOrArrayOfNumber(COLUMN_WIDTHS, -1.0f);
    }

    public float getEndIndent() {
        return getNumber(END_INDENT, 0.0f);
    }

    public String getGlyphOrientationVertical() {
        return getName(GLYPH_ORIENTATION_VERTICAL, "Auto");
    }

    public Object getHeight() {
        return getNumberOrName(HEIGHT, "Auto");
    }

    public String getInlineAlign() {
        return getName(INLINE_ALIGN, "Start");
    }

    public Object getLineHeight() {
        return getNumberOrName(LINE_HEIGHT, "Normal");
    }

    public Object getPadding() {
        return getNumberOrArrayOfNumber(PADDING, 0.0f);
    }

    public String getPlacement() {
        return getName(PLACEMENT, "Inline");
    }

    public String getRubyAlign() {
        return getName(RUBY_ALIGN, RUBY_ALIGN_DISTRIBUTE);
    }

    public String getRubyPosition() {
        return getName(RUBY_POSITION, "Before");
    }

    public float getSpaceAfter() {
        return getNumber(SPACE_AFTER, 0.0f);
    }

    public float getSpaceBefore() {
        return getNumber(SPACE_BEFORE, 0.0f);
    }

    public float getStartIndent() {
        return getNumber(START_INDENT, 0.0f);
    }

    public Object getTBorderStyle() {
        return getNameOrArrayOfName(T_BORDER_STYLE, "None");
    }

    public Object getTPadding() {
        return getNumberOrArrayOfNumber(T_PADDING, 0.0f);
    }

    public String getTextAlign() {
        return getName(TEXT_ALIGN, "Start");
    }

    public PDGamma getTextDecorationColor() {
        return getColor(TEXT_DECORATION_COLOR);
    }

    public float getTextDecorationThickness() {
        return getNumber(TEXT_DECORATION_THICKNESS);
    }

    public String getTextDecorationType() {
        return getName(TEXT_DECORATION_TYPE, "None");
    }

    public float getTextIndent() {
        return getNumber(TEXT_INDENT, 0.0f);
    }

    public Object getWidth() {
        return getNumberOrName(WIDTH, "Auto");
    }

    public String getWritingMode() {
        return getName(WRITING_MODE, WRITING_MODE_LRTB);
    }

    public void setAllBorderColors(PDGamma pDGamma) {
        setColor(BORDER_COLOR, pDGamma);
    }

    public void setAllBorderStyles(String str) {
        setName(BORDER_STYLE, str);
    }

    public void setAllBorderThicknesses(float f2) {
        setNumber((String) BORDER_THICKNESS, f2);
    }

    public void setAllColumnWidths(float f2) {
        setNumber((String) COLUMN_WIDTHS, f2);
    }

    public void setAllPaddings(float f2) {
        setNumber((String) PADDING, f2);
    }

    public void setAllTBorderStyles(String str) {
        setName(T_BORDER_STYLE, str);
    }

    public void setAllTPaddings(float f2) {
        setNumber((String) T_PADDING, f2);
    }

    public void setBBox(PDRectangle pDRectangle) {
        COSBase cOSBase;
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject((String) BBOX);
        getCOSDictionary().setItem((String) BBOX, (COSObjectable) pDRectangle);
        if (pDRectangle == null) {
            cOSBase = null;
        } else {
            cOSBase = pDRectangle.getCOSObject();
        }
        potentiallyNotifyChanged(dictionaryObject, cOSBase);
    }

    public void setBackgroundColor(PDGamma pDGamma) {
        setColor(BACKGROUND_COLOR, pDGamma);
    }

    public void setBaselineShift(float f2) {
        setNumber((String) BASELINE_SHIFT, f2);
    }

    public void setBlockAlign(String str) {
        setName(BLOCK_ALIGN, str);
    }

    public void setBorderColors(PDFourColours pDFourColours) {
        setFourColors(BORDER_COLOR, pDFourColours);
    }

    public void setBorderStyles(String[] strArr) {
        setArrayOfName(BORDER_STYLE, strArr);
    }

    public void setBorderThicknesses(float[] fArr) {
        setArrayOfNumber(BORDER_THICKNESS, fArr);
    }

    public void setColor(PDGamma pDGamma) {
        setColor(COLOR, pDGamma);
    }

    public void setColumnCount(int i) {
        setInteger(COLUMN_COUNT, i);
    }

    public void setColumnGap(float f2) {
        setNumber((String) COLUMN_GAP, f2);
    }

    public void setColumnGaps(float[] fArr) {
        setArrayOfNumber(COLUMN_GAP, fArr);
    }

    public void setColumnWidths(float[] fArr) {
        setArrayOfNumber(COLUMN_WIDTHS, fArr);
    }

    public void setEndIndent(float f2) {
        setNumber((String) END_INDENT, f2);
    }

    public void setGlyphOrientationVertical(String str) {
        setName(GLYPH_ORIENTATION_VERTICAL, str);
    }

    public void setHeight(float f2) {
        setNumber((String) HEIGHT, f2);
    }

    public void setHeightAuto() {
        setName(HEIGHT, "Auto");
    }

    public void setInlineAlign(String str) {
        setName(INLINE_ALIGN, str);
    }

    public void setLineHeight(float f2) {
        setNumber((String) LINE_HEIGHT, f2);
    }

    public void setLineHeightAuto() {
        setName(LINE_HEIGHT, "Auto");
    }

    public void setLineHeightNormal() {
        setName(LINE_HEIGHT, "Normal");
    }

    public void setPaddings(float[] fArr) {
        setArrayOfNumber(PADDING, fArr);
    }

    public void setPlacement(String str) {
        setName(PLACEMENT, str);
    }

    public void setRubyAlign(String str) {
        setName(RUBY_ALIGN, str);
    }

    public void setRubyPosition(String str) {
        setName(RUBY_POSITION, str);
    }

    public void setSpaceAfter(float f2) {
        setNumber((String) SPACE_AFTER, f2);
    }

    public void setSpaceBefore(float f2) {
        setNumber((String) SPACE_BEFORE, f2);
    }

    public void setStartIndent(float f2) {
        setNumber((String) START_INDENT, f2);
    }

    public void setTBorderStyles(String[] strArr) {
        setArrayOfName(T_BORDER_STYLE, strArr);
    }

    public void setTPaddings(float[] fArr) {
        setArrayOfNumber(T_PADDING, fArr);
    }

    public void setTextAlign(String str) {
        setName(TEXT_ALIGN, str);
    }

    public void setTextDecorationColor(PDGamma pDGamma) {
        setColor(TEXT_DECORATION_COLOR, pDGamma);
    }

    public void setTextDecorationThickness(float f2) {
        setNumber((String) TEXT_DECORATION_THICKNESS, f2);
    }

    public void setTextDecorationType(String str) {
        setName(TEXT_DECORATION_TYPE, str);
    }

    public void setTextIndent(float f2) {
        setNumber((String) TEXT_INDENT, f2);
    }

    public void setWidth(float f2) {
        setNumber((String) WIDTH, f2);
    }

    public void setWidthAuto() {
        setName(WIDTH, "Auto");
    }

    public void setWritingMode(String str) {
        setName(WRITING_MODE, str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (isSpecified(PLACEMENT)) {
            sb.append(", Placement=");
            sb.append(getPlacement());
        }
        if (isSpecified(WRITING_MODE)) {
            sb.append(", WritingMode=");
            sb.append(getWritingMode());
        }
        if (isSpecified(BACKGROUND_COLOR)) {
            sb.append(", BackgroundColor=");
            sb.append(getBackgroundColor());
        }
        if (isSpecified(BORDER_COLOR)) {
            sb.append(", BorderColor=");
            sb.append(getBorderColors());
        }
        if (isSpecified(BORDER_STYLE)) {
            Object borderStyle = getBorderStyle();
            sb.append(", BorderStyle=");
            if (borderStyle instanceof String[]) {
                sb.append(PDAttributeObject.arrayToString((Object[]) (String[]) borderStyle));
            } else {
                sb.append(borderStyle);
            }
        }
        if (isSpecified(BORDER_THICKNESS)) {
            Object borderThickness = getBorderThickness();
            sb.append(", BorderThickness=");
            if (borderThickness instanceof float[]) {
                sb.append(PDAttributeObject.arrayToString((float[]) borderThickness));
            } else {
                sb.append(String.valueOf(borderThickness));
            }
        }
        if (isSpecified(PADDING)) {
            Object padding = getPadding();
            sb.append(", Padding=");
            if (padding instanceof float[]) {
                sb.append(PDAttributeObject.arrayToString((float[]) padding));
            } else {
                sb.append(String.valueOf(padding));
            }
        }
        if (isSpecified(COLOR)) {
            sb.append(", Color=");
            sb.append(getColor());
        }
        if (isSpecified(SPACE_BEFORE)) {
            sb.append(", SpaceBefore=");
            sb.append(String.valueOf(getSpaceBefore()));
        }
        if (isSpecified(SPACE_AFTER)) {
            sb.append(", SpaceAfter=");
            sb.append(String.valueOf(getSpaceAfter()));
        }
        if (isSpecified(START_INDENT)) {
            sb.append(", StartIndent=");
            sb.append(String.valueOf(getStartIndent()));
        }
        if (isSpecified(END_INDENT)) {
            sb.append(", EndIndent=");
            sb.append(String.valueOf(getEndIndent()));
        }
        if (isSpecified(TEXT_INDENT)) {
            sb.append(", TextIndent=");
            sb.append(String.valueOf(getTextIndent()));
        }
        if (isSpecified(TEXT_ALIGN)) {
            sb.append(", TextAlign=");
            sb.append(getTextAlign());
        }
        if (isSpecified(BBOX)) {
            sb.append(", BBox=");
            sb.append(getBBox());
        }
        if (isSpecified(WIDTH)) {
            Object width = getWidth();
            sb.append(", Width=");
            if (width instanceof Float) {
                sb.append(String.valueOf(width));
            } else {
                sb.append(width);
            }
        }
        if (isSpecified(HEIGHT)) {
            Object height = getHeight();
            sb.append(", Height=");
            if (height instanceof Float) {
                sb.append(String.valueOf(height));
            } else {
                sb.append(height);
            }
        }
        if (isSpecified(BLOCK_ALIGN)) {
            sb.append(", BlockAlign=");
            sb.append(getBlockAlign());
        }
        if (isSpecified(INLINE_ALIGN)) {
            sb.append(", InlineAlign=");
            sb.append(getInlineAlign());
        }
        if (isSpecified(T_BORDER_STYLE)) {
            Object tBorderStyle = getTBorderStyle();
            sb.append(", TBorderStyle=");
            if (tBorderStyle instanceof String[]) {
                sb.append(PDAttributeObject.arrayToString((Object[]) (String[]) tBorderStyle));
            } else {
                sb.append(tBorderStyle);
            }
        }
        if (isSpecified(T_PADDING)) {
            Object tPadding = getTPadding();
            sb.append(", TPadding=");
            if (tPadding instanceof float[]) {
                sb.append(PDAttributeObject.arrayToString((float[]) tPadding));
            } else {
                sb.append(String.valueOf(tPadding));
            }
        }
        if (isSpecified(BASELINE_SHIFT)) {
            sb.append(", BaselineShift=");
            sb.append(String.valueOf(getBaselineShift()));
        }
        if (isSpecified(LINE_HEIGHT)) {
            Object lineHeight = getLineHeight();
            sb.append(", LineHeight=");
            if (lineHeight instanceof Float) {
                sb.append(String.valueOf(lineHeight));
            } else {
                sb.append(lineHeight);
            }
        }
        if (isSpecified(TEXT_DECORATION_COLOR)) {
            sb.append(", TextDecorationColor=");
            sb.append(getTextDecorationColor());
        }
        if (isSpecified(TEXT_DECORATION_THICKNESS)) {
            sb.append(", TextDecorationThickness=");
            sb.append(String.valueOf(getTextDecorationThickness()));
        }
        if (isSpecified(TEXT_DECORATION_TYPE)) {
            sb.append(", TextDecorationType=");
            sb.append(getTextDecorationType());
        }
        if (isSpecified(RUBY_ALIGN)) {
            sb.append(", RubyAlign=");
            sb.append(getRubyAlign());
        }
        if (isSpecified(RUBY_POSITION)) {
            sb.append(", RubyPosition=");
            sb.append(getRubyPosition());
        }
        if (isSpecified(GLYPH_ORIENTATION_VERTICAL)) {
            sb.append(", GlyphOrientationVertical=");
            sb.append(getGlyphOrientationVertical());
        }
        if (isSpecified(COLUMN_COUNT)) {
            sb.append(", ColumnCount=");
            sb.append(String.valueOf(getColumnCount()));
        }
        if (isSpecified(COLUMN_GAP)) {
            Object columnGap = getColumnGap();
            sb.append(", ColumnGap=");
            if (columnGap instanceof float[]) {
                sb.append(PDAttributeObject.arrayToString((float[]) columnGap));
            } else {
                sb.append(String.valueOf(columnGap));
            }
        }
        if (isSpecified(COLUMN_WIDTHS)) {
            Object columnWidths = getColumnWidths();
            sb.append(", ColumnWidths=");
            if (columnWidths instanceof float[]) {
                sb.append(PDAttributeObject.arrayToString((float[]) columnWidths));
            } else {
                sb.append(String.valueOf(columnWidths));
            }
        }
        return sb.toString();
    }

    public void setAllBorderThicknesses(int i) {
        setNumber((String) BORDER_THICKNESS, i);
    }

    public void setAllColumnWidths(int i) {
        setNumber((String) COLUMN_WIDTHS, i);
    }

    public void setAllPaddings(int i) {
        setNumber((String) PADDING, i);
    }

    public void setAllTPaddings(int i) {
        setNumber((String) T_PADDING, i);
    }

    public void setBaselineShift(int i) {
        setNumber((String) BASELINE_SHIFT, i);
    }

    public void setColumnGap(int i) {
        setNumber((String) COLUMN_GAP, i);
    }

    public void setEndIndent(int i) {
        setNumber((String) END_INDENT, i);
    }

    public void setHeight(int i) {
        setNumber((String) HEIGHT, i);
    }

    public void setLineHeight(int i) {
        setNumber((String) LINE_HEIGHT, i);
    }

    public void setSpaceAfter(int i) {
        setNumber((String) SPACE_AFTER, i);
    }

    public void setSpaceBefore(int i) {
        setNumber((String) SPACE_BEFORE, i);
    }

    public void setStartIndent(int i) {
        setNumber((String) START_INDENT, i);
    }

    public void setTextDecorationThickness(int i) {
        setNumber((String) TEXT_DECORATION_THICKNESS, i);
    }

    public void setTextIndent(int i) {
        setNumber((String) TEXT_INDENT, i);
    }

    public void setWidth(int i) {
        setNumber((String) WIDTH, i);
    }

    public PDLayoutAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
