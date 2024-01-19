package org.apache.pdfbox.text;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.util.Matrix;

public final class TextPosition {
    public static final Map<Integer, String> DIACRITICS = createDiacritics();
    public final int[] charCodes;
    public final float endX;
    public final float endY;
    public final PDFont font;
    public final float fontSize;
    public final int fontSizePt;
    public final float maxHeight;
    public final float pageHeight;
    public final float pageWidth;
    public final int rotation;
    public final Matrix textMatrix;
    public String unicode;
    public final float widthOfSpace;
    public float[] widths;
    public final float x;
    public final float y;

    public TextPosition(int i, float f2, float f3, Matrix matrix, float f4, float f5, float f6, float f7, float f8, String str, int[] iArr, PDFont pDFont, float f9, int i2) {
        this.textMatrix = matrix;
        this.endX = f4;
        this.endY = f5;
        this.rotation = i;
        this.maxHeight = f6;
        this.pageHeight = f3;
        this.pageWidth = f2;
        this.widths = new float[]{f7};
        this.widthOfSpace = f8;
        this.unicode = str;
        this.charCodes = iArr;
        this.font = pDFont;
        this.fontSize = f9;
        this.fontSizePt = i2;
        float f10 = (float) i;
        this.x = getXRot(f10);
        if (i == 0 || i == 180) {
            this.y = this.pageHeight - getYLowerLeftRot(f10);
        } else {
            this.y = this.pageWidth - getYLowerLeftRot(f10);
        }
    }

    private String combineDiacritic(String str) {
        int codePointAt = str.codePointAt(0);
        if (DIACRITICS.containsKey(Integer.valueOf(codePointAt))) {
            return DIACRITICS.get(Integer.valueOf(codePointAt));
        }
        return Normalizer.normalize(str, Form.NFKC).trim();
    }

    public static Map<Integer, String> createDiacritics() {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(96), "̀");
        hashMap.put(Integer.valueOf(715), "̀");
        hashMap.put(Integer.valueOf(39), "́");
        hashMap.put(Integer.valueOf(697), "́");
        hashMap.put(Integer.valueOf(714), "́");
        hashMap.put(Integer.valueOf(94), "̂");
        hashMap.put(Integer.valueOf(710), "̂");
        hashMap.put(Integer.valueOf(126), "̃");
        hashMap.put(Integer.valueOf(713), "̄");
        hashMap.put(Integer.valueOf(176), "̊");
        hashMap.put(Integer.valueOf(698), "̋");
        hashMap.put(Integer.valueOf(711), "̌");
        hashMap.put(Integer.valueOf(712), "̍");
        hashMap.put(Integer.valueOf(34), "̎");
        hashMap.put(Integer.valueOf(699), "̒");
        hashMap.put(Integer.valueOf(OS2WindowsMetricsTable.WEIGHT_CLASS_BOLD), "̓");
        hashMap.put(Integer.valueOf(1158), "̓");
        hashMap.put(Integer.valueOf(1370), "̓");
        hashMap.put(Integer.valueOf(701), "̔");
        hashMap.put(Integer.valueOf(1157), "̔");
        hashMap.put(Integer.valueOf(1369), "̔");
        hashMap.put(Integer.valueOf(724), "̝");
        hashMap.put(Integer.valueOf(725), "̞");
        hashMap.put(Integer.valueOf(726), "̟");
        hashMap.put(Integer.valueOf(727), "̠");
        hashMap.put(Integer.valueOf(690), "̡");
        hashMap.put(Integer.valueOf(716), "̩");
        hashMap.put(Integer.valueOf(695), "̫");
        hashMap.put(Integer.valueOf(717), "̱");
        hashMap.put(Integer.valueOf(95), "̲");
        hashMap.put(Integer.valueOf(8270), "͙");
        return hashMap;
    }

    private float getWidthRot(float f2) {
        if (f2 == 90.0f || f2 == 270.0f) {
            return Math.abs(this.endY - this.textMatrix.getTranslateY());
        }
        return Math.abs(this.endX - this.textMatrix.getTranslateX());
    }

    private float getXRot(float f2) {
        if (f2 == 0.0f) {
            return this.textMatrix.getTranslateX();
        }
        if (f2 == 90.0f) {
            return this.textMatrix.getTranslateY();
        }
        if (f2 == 180.0f) {
            return this.pageWidth - this.textMatrix.getTranslateX();
        }
        if (f2 == 270.0f) {
            return this.pageHeight - this.textMatrix.getTranslateX();
        }
        return 0.0f;
    }

    private float getYLowerLeftRot(float f2) {
        if (f2 == 0.0f) {
            return this.textMatrix.getTranslateY();
        }
        if (f2 == 90.0f) {
            return this.pageWidth - this.textMatrix.getTranslateX();
        }
        if (f2 == 180.0f) {
            return this.pageHeight - this.textMatrix.getTranslateY();
        }
        if (f2 == 270.0f) {
            return this.textMatrix.getTranslateX();
        }
        return 0.0f;
    }

    private void insertDiacritic(int i, TextPosition textPosition) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.unicode.substring(0, i));
        float[] fArr = this.widths;
        float[] fArr2 = new float[(fArr.length + 1)];
        System.arraycopy(fArr, 0, fArr2, 0, i);
        sb.append(this.unicode.charAt(i));
        fArr2[i] = this.widths[i];
        sb.append(combineDiacritic(textPosition.getUnicode()));
        int i2 = i + 1;
        fArr2[i2] = 0.0f;
        String str = this.unicode;
        sb.append(str.substring(i2, str.length()));
        float[] fArr3 = this.widths;
        System.arraycopy(fArr3, i2, fArr2, i + 2, (fArr3.length - i) - 1);
        this.unicode = sb.toString();
        this.widths = fArr2;
    }

    public boolean contains(TextPosition textPosition) {
        double xDirAdj = (double) getXDirAdj();
        double widthDirAdj = (double) (getWidthDirAdj() + getXDirAdj());
        double xDirAdj2 = (double) textPosition.getXDirAdj();
        double widthDirAdj2 = (double) (textPosition.getWidthDirAdj() + textPosition.getXDirAdj());
        boolean z = false;
        if (widthDirAdj2 > xDirAdj && xDirAdj2 < widthDirAdj) {
            if (textPosition.getHeightDir() + textPosition.getYDirAdj() >= getYDirAdj()) {
                if (textPosition.getYDirAdj() <= getHeightDir() + getYDirAdj()) {
                    if (xDirAdj2 > xDirAdj && widthDirAdj2 > widthDirAdj) {
                        if ((widthDirAdj - xDirAdj2) / ((double) getWidthDirAdj()) > 0.15d) {
                            z = true;
                        }
                        return z;
                    } else if (xDirAdj2 >= xDirAdj || widthDirAdj2 >= widthDirAdj) {
                        return true;
                    } else {
                        if ((widthDirAdj2 - xDirAdj) / ((double) getWidthDirAdj()) > 0.15d) {
                            z = true;
                        }
                        return z;
                    }
                }
            }
        }
        return false;
    }

    public int[] getCharacterCodes() {
        return this.charCodes;
    }

    public float getDir() {
        float scaleY = this.textMatrix.getScaleY();
        float shearY = this.textMatrix.getShearY();
        float scaleX = this.textMatrix.getScaleX();
        float shearX = this.textMatrix.getShearX();
        if (scaleY > 0.0f && Math.abs(shearY) < shearX && Math.abs(scaleX) < scaleY && shearX > 0.0f) {
            return 0.0f;
        }
        if (scaleY < 0.0f && Math.abs(shearY) < Math.abs(shearX) && Math.abs(scaleX) < Math.abs(scaleY) && shearX < 0.0f) {
            return 180.0f;
        }
        if (Math.abs(scaleY) < Math.abs(scaleX) && shearY > 0.0f && scaleX < 0.0f && Math.abs(shearX) < shearY) {
            return 90.0f;
        }
        if (Math.abs(scaleY) >= scaleX || shearY >= 0.0f || scaleX <= 0.0f || Math.abs(shearX) >= Math.abs(shearY)) {
            return 0.0f;
        }
        return 270.0f;
    }

    public PDFont getFont() {
        return this.font;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public float getFontSizeInPt() {
        return (float) this.fontSizePt;
    }

    public float getHeight() {
        return this.maxHeight;
    }

    public float getHeightDir() {
        return this.maxHeight;
    }

    public float[] getIndividualWidths() {
        return this.widths;
    }

    public Matrix getTextMatrix() {
        return this.textMatrix;
    }

    public String getUnicode() {
        return this.unicode;
    }

    public float getWidth() {
        return getWidthRot((float) this.rotation);
    }

    public float getWidthDirAdj() {
        return getWidthRot(getDir());
    }

    public float getWidthOfSpace() {
        return this.widthOfSpace;
    }

    public float getX() {
        return this.x;
    }

    public float getXDirAdj() {
        return getXRot(getDir());
    }

    public float getXScale() {
        return this.textMatrix.getScalingFactorX();
    }

    public float getY() {
        return this.y;
    }

    public float getYDirAdj() {
        float f2;
        float yLowerLeftRot;
        float dir = getDir();
        if (dir == 0.0f || dir == 180.0f) {
            f2 = this.pageHeight;
            yLowerLeftRot = getYLowerLeftRot(dir);
        } else {
            f2 = this.pageWidth;
            yLowerLeftRot = getYLowerLeftRot(dir);
        }
        return f2 - yLowerLeftRot;
    }

    public float getYScale() {
        return this.textMatrix.getScalingFactorY();
    }

    public boolean isDiacritic() {
        String unicode2 = getUnicode();
        boolean z = true;
        if (unicode2.length() != 1) {
            return false;
        }
        int type = Character.getType(unicode2.charAt(0));
        if (!(type == 6 || type == 27 || type == 4)) {
            z = false;
        }
        return z;
    }

    public void mergeDiacritic(TextPosition textPosition) {
        if (textPosition.getUnicode().length() <= 1) {
            float xDirAdj = textPosition.getXDirAdj();
            float f2 = textPosition.widths[0] + xDirAdj;
            float xDirAdj2 = getXDirAdj();
            int length = this.unicode.length();
            float f3 = xDirAdj2;
            boolean z = false;
            for (int i = 0; i < length && !z; i++) {
                float[] fArr = this.widths;
                float f4 = fArr[i] + f3;
                int i2 = (xDirAdj > f3 ? 1 : (xDirAdj == f3 ? 0 : -1));
                if (i2 >= 0 || f2 > f4) {
                    if (i2 >= 0 || f2 <= f4) {
                        int i3 = (xDirAdj > f3 ? 1 : (xDirAdj == f3 ? 0 : -1));
                        if (i3 < 0 || f2 > f4) {
                            if (i3 >= 0 && f2 > f4 && i == length - 1) {
                                insertDiacritic(i, textPosition);
                            }
                            f3 += this.widths[i];
                        } else {
                            insertDiacritic(i, textPosition);
                        }
                    } else {
                        insertDiacritic(i, textPosition);
                    }
                } else if (i == 0) {
                    insertDiacritic(i, textPosition);
                } else {
                    int i4 = i - 1;
                    if ((f2 - f3) / fArr[i] >= (f3 - xDirAdj) / fArr[i4]) {
                        insertDiacritic(i, textPosition);
                    } else {
                        insertDiacritic(i4, textPosition);
                    }
                }
                z = true;
                f3 += this.widths[i];
            }
        }
    }

    public String toString() {
        return getUnicode();
    }
}
