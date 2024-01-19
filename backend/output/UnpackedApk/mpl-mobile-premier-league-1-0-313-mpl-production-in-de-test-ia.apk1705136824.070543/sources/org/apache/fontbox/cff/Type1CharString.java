package org.apache.fontbox.cff;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.encoding.StandardEncoding;
import org.apache.fontbox.type1.Type1CharStringReader;
import org.apache.pdfbox.util.awt.AffineTransform;

public class Type1CharString {
    public int commandCount;
    public PointF current;
    public List<PointF> flexPoints;
    public Type1CharStringReader font;
    public String fontName;
    public String glyphName;
    public boolean isFlex;
    public PointF leftSideBearing;
    public Path path;
    public List<Object> type1Sequence;
    public int width;

    public Type1CharString(Type1CharStringReader type1CharStringReader, String str, String str2, List<Object> list) {
        this(type1CharStringReader, str, str2);
        this.type1Sequence = list;
    }

    private void callothersubr(int i) {
        if (i == 0) {
            this.isFlex = false;
            if (this.flexPoints.size() >= 7) {
                PointF pointF = this.flexPoints.get(0);
                PointF pointF2 = this.current;
                pointF.set(pointF2.x + pointF.x, pointF2.y + pointF.y);
                PointF pointF3 = this.flexPoints.get(1);
                pointF3.set(pointF.x + pointF3.x, pointF.y + pointF3.y);
                float f2 = pointF3.x;
                PointF pointF4 = this.current;
                pointF3.set(f2 - pointF4.x, pointF3.y - pointF4.y);
                rrcurveTo(Float.valueOf(this.flexPoints.get(1).x), Float.valueOf(this.flexPoints.get(1).y), Float.valueOf(this.flexPoints.get(2).x), Float.valueOf(this.flexPoints.get(2).y), Float.valueOf(this.flexPoints.get(3).x), Float.valueOf(this.flexPoints.get(3).y));
                rrcurveTo(Float.valueOf(this.flexPoints.get(4).x), Float.valueOf(this.flexPoints.get(4).y), Float.valueOf(this.flexPoints.get(5).x), Float.valueOf(this.flexPoints.get(5).y), Float.valueOf(this.flexPoints.get(6).x), Float.valueOf(this.flexPoints.get(6).y));
                this.flexPoints.clear();
            }
        } else if (i == 1) {
            this.isFlex = true;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Unexpected other subroutine: ", i));
        }
    }

    private void closepath() {
        if (!this.path.isEmpty()) {
            this.path.close();
        }
        Path path2 = this.path;
        PointF pointF = this.current;
        path2.moveTo(pointF.x, pointF.y);
    }

    /* access modifiers changed from: private */
    public List<Integer> handleCommand(List<Integer> list, CharStringCommand charStringCommand) {
        this.commandCount++;
        String str = CharStringCommand.TYPE1_VOCABULARY.get(charStringCommand.getKey());
        boolean equals = "rmoveto".equals(str);
        Integer valueOf = Integer.valueOf(0);
        if (equals) {
            if (this.isFlex) {
                this.flexPoints.add(new PointF((float) list.get(0).intValue(), (float) list.get(1).intValue()));
            } else {
                rmoveTo(list.get(0), list.get(1));
            }
        } else if ("vmoveto".equals(str)) {
            if (this.isFlex) {
                this.flexPoints.add(new PointF(0.0f, (float) list.get(0).intValue()));
            } else {
                rmoveTo(valueOf, list.get(0));
            }
        } else if ("hmoveto".equals(str)) {
            if (this.isFlex) {
                this.flexPoints.add(new PointF((float) list.get(0).intValue(), 0.0f));
            } else {
                rmoveTo(list.get(0), valueOf);
            }
        } else if ("rlineto".equals(str)) {
            rlineTo(list.get(0), list.get(1));
        } else if ("hlineto".equals(str)) {
            rlineTo(list.get(0), valueOf);
        } else if ("vlineto".equals(str)) {
            rlineTo(valueOf, list.get(0));
        } else if ("rrcurveto".equals(str)) {
            rrcurveTo(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
        } else if ("closepath".equals(str)) {
            closepath();
        } else if ("sbw".equals(str)) {
            this.leftSideBearing = new PointF((float) list.get(0).intValue(), (float) list.get(1).intValue());
            this.width = list.get(2).intValue();
            this.current.set(this.leftSideBearing);
        } else if ("hsbw".equals(str)) {
            this.leftSideBearing = new PointF((float) list.get(0).intValue(), 0.0f);
            this.width = list.get(1).intValue();
            this.current.set(this.leftSideBearing);
        } else if ("vhcurveto".equals(str)) {
            rrcurveTo(valueOf, list.get(0), list.get(1), list.get(2), list.get(3), valueOf);
        } else if ("hvcurveto".equals(str)) {
            rrcurveTo(list.get(0), valueOf, list.get(1), list.get(2), valueOf, list.get(3));
        } else if ("seac".equals(str)) {
            seac(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
        } else if ("setcurrentpoint".equals(str)) {
            setcurrentpoint(list.get(0).intValue(), list.get(1).intValue());
        } else if ("callothersubr".equals(str)) {
            callothersubr(list.get(0).intValue());
        } else if ("div".equals(str)) {
            int intValue = ((Integer) GeneratedOutlineSupport.outline30(list, 2)).intValue() / ((Integer) GeneratedOutlineSupport.outline30(list, 1)).intValue();
            ArrayList arrayList = new ArrayList(list);
            arrayList.remove(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            arrayList.add(Integer.valueOf(intValue));
            return arrayList;
        } else if (!"hstem".equals(str) && !"vstem".equals(str) && !"hstem3".equals(str) && !"vstem3".equals(str) && !"dotsection".equals(str) && !"endchar".equals(str)) {
            if (str == null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown charstring command: ");
                outline73.append(charStringCommand.getKey());
                outline73.toString();
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Unhandled command: ", str));
            }
        }
        return null;
    }

    private void render() {
        this.path = new Path();
        this.leftSideBearing = new PointF(0.0f, 0.0f);
        this.width = 0;
        new CharStringHandler() {
            public List<Integer> handleCommand(List<Integer> list, CharStringCommand charStringCommand) {
                return Type1CharString.this.handleCommand(list, charStringCommand);
            }
        }.handleSequence(this.type1Sequence);
    }

    private void rlineTo(Number number, Number number2) {
        float floatValue = number.floatValue() + this.current.x;
        float floatValue2 = number2.floatValue() + this.current.y;
        if (this.path.isEmpty()) {
            this.path.moveTo(floatValue, floatValue2);
        } else {
            this.path.lineTo(floatValue, floatValue2);
        }
        this.current.set(floatValue, floatValue2);
    }

    private void rmoveTo(Number number, Number number2) {
        float floatValue = number.floatValue() + this.current.x;
        float floatValue2 = number2.floatValue() + this.current.y;
        this.path.moveTo(floatValue, floatValue2);
        this.current.set(floatValue, floatValue2);
    }

    private void rrcurveTo(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        float floatValue = number.floatValue() + this.current.x;
        float floatValue2 = number2.floatValue() + this.current.y;
        float floatValue3 = number3.floatValue() + floatValue;
        float floatValue4 = number4.floatValue() + floatValue2;
        float floatValue5 = number5.floatValue() + floatValue3;
        float floatValue6 = number6.floatValue() + floatValue4;
        if (this.path.isEmpty()) {
            this.path.moveTo(floatValue5, floatValue6);
        } else {
            this.path.cubicTo(floatValue, floatValue2, floatValue3, floatValue4, floatValue5, floatValue6);
        }
        this.current.set(floatValue5, floatValue6);
    }

    private void seac(Number number, Number number2, Number number3, Number number4, Number number5) {
        String name = StandardEncoding.INSTANCE.getName(number4.intValue());
        if (name != null) {
            try {
                this.font.getType1CharString(name);
            } catch (IOException unused) {
            }
        }
        String name2 = StandardEncoding.INSTANCE.getName(number5.intValue());
        if (name2 != null) {
            try {
                this.font.getType1CharString(name2);
                AffineTransform.getTranslateInstance((double) (this.leftSideBearing.x + number2.floatValue()), (double) (this.leftSideBearing.y + number3.floatValue()));
            } catch (IOException unused2) {
            }
        }
    }

    private void setcurrentpoint(int i, int i2) {
        this.current.set((float) i, (float) i2);
    }

    public RectF getBounds() {
        if (this.path == null) {
            render();
        }
        this.path.computeBounds(null, true);
        return null;
    }

    public String getName() {
        return this.glyphName;
    }

    public Path getPath() {
        if (this.path == null) {
            render();
        }
        return this.path;
    }

    public List<Object> getType1Sequence() {
        return this.type1Sequence;
    }

    public int getWidth() {
        if (this.path == null) {
            render();
        }
        return this.width;
    }

    public String toString() {
        return this.type1Sequence.toString().replace("|", "\n").replace(",", CMap.SPACE);
    }

    public Type1CharString(Type1CharStringReader type1CharStringReader, String str, String str2) {
        this.path = null;
        this.width = 0;
        this.leftSideBearing = null;
        this.current = null;
        this.isFlex = false;
        this.flexPoints = new ArrayList();
        this.font = type1CharStringReader;
        this.fontName = str;
        this.glyphName = str2;
        this.current = new PointF(0.0f, 0.0f);
    }
}
