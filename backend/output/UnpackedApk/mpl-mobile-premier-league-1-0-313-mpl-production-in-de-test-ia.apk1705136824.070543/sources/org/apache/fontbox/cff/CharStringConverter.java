package org.apache.fontbox.cff;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CharStringConverter extends CharStringHandler {
    public int defaultWidthX = 0;
    public int nominalWidthX = 0;
    public int pathCount = 0;
    public List<Object> sequence = null;

    public CharStringConverter(int i, int i2, IndexData indexData, IndexData indexData2) {
        this.defaultWidthX = i;
        this.nominalWidthX = i2;
    }

    private void addCommand(List<Integer> list, CharStringCommand charStringCommand) {
        this.sequence.addAll(list);
        this.sequence.add(charStringCommand);
    }

    private void addCommandList(List<List<Integer>> list, CharStringCommand charStringCommand) {
        for (int i = 0; i < list.size(); i++) {
            addCommand(list.get(i), charStringCommand);
        }
    }

    private List<Integer> clearStack(List<Integer> list, boolean z) {
        if (this.sequence.size() != 0) {
            return list;
        }
        if (z) {
            addCommand(Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(list.get(0).intValue() + this.nominalWidthX)}), new CharStringCommand(13));
            return list.subList(1, list.size());
        }
        addCommand(Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(this.defaultWidthX)}), new CharStringCommand(13));
        return list;
    }

    private void closePath() {
        CharStringCommand charStringCommand = this.pathCount > 0 ? (CharStringCommand) GeneratedOutlineSupport.outline29(this.sequence, -1) : null;
        CharStringCommand charStringCommand2 = new CharStringCommand(9);
        if (charStringCommand != null && !charStringCommand2.equals(charStringCommand)) {
            addCommand(Collections.emptyList(), charStringCommand2);
        }
    }

    private void drawAlternatingCurve(List<Integer> list, boolean z) {
        Integer num;
        while (list.size() > 0) {
            int i = 5;
            boolean z2 = list.size() == 5;
            if (z) {
                Integer[] numArr = new Integer[6];
                numArr[0] = list.get(0);
                numArr[1] = Integer.valueOf(0);
                numArr[2] = list.get(1);
                numArr[3] = list.get(2);
                if (z2) {
                    num = list.get(4);
                } else {
                    num = Integer.valueOf(0);
                }
                numArr[4] = num;
                numArr[5] = list.get(3);
                addCommand(Arrays.asList(numArr), new CharStringCommand(8));
            } else {
                Integer[] numArr2 = new Integer[6];
                numArr2[0] = Integer.valueOf(0);
                numArr2[1] = list.get(0);
                numArr2[2] = list.get(1);
                numArr2[3] = list.get(2);
                numArr2[4] = list.get(3);
                numArr2[5] = z2 ? list.get(4) : Integer.valueOf(0);
                addCommand(Arrays.asList(numArr2), new CharStringCommand(8));
            }
            if (!z2) {
                i = 4;
            }
            list = list.subList(i, list.size());
            z = !z;
        }
    }

    private void drawAlternatingLine(List<Integer> list, boolean z) {
        while (list.size() > 0) {
            addCommand(list.subList(0, 1), new CharStringCommand(z ? 6 : 7));
            list = list.subList(1, list.size());
            z = !z;
        }
    }

    private void drawCurve(List<Integer> list, boolean z) {
        Integer num;
        while (list.size() > 0) {
            int i = 4;
            int i2 = 1;
            int i3 = list.size() % 4 == 1 ? 1 : 0;
            int i4 = 3;
            int i5 = 2;
            if (z) {
                Integer[] numArr = new Integer[6];
                numArr[0] = list.get(i3);
                numArr[1] = i3 != 0 ? list.get(0) : Integer.valueOf(0);
                if (i3 != 0) {
                    i2 = 2;
                }
                numArr[2] = list.get(i2);
                if (i3 != 0) {
                    i5 = 3;
                }
                numArr[3] = list.get(i5);
                if (i3 != 0) {
                    i4 = 4;
                }
                numArr[4] = list.get(i4);
                numArr[5] = Integer.valueOf(0);
                addCommand(Arrays.asList(numArr), new CharStringCommand(8));
            } else {
                Integer[] numArr2 = new Integer[6];
                if (i3 != 0) {
                    num = list.get(0);
                } else {
                    num = Integer.valueOf(0);
                }
                numArr2[0] = num;
                numArr2[1] = list.get(i3);
                if (i3 != 0) {
                    i2 = 2;
                }
                numArr2[2] = list.get(i2);
                if (i3 != 0) {
                    i5 = 3;
                }
                numArr2[3] = list.get(i5);
                numArr2[4] = Integer.valueOf(0);
                if (i3 != 0) {
                    i4 = 4;
                }
                numArr2[5] = list.get(i4);
                addCommand(Arrays.asList(numArr2), new CharStringCommand(8));
            }
            if (i3 != 0) {
                i = 5;
            }
            list = list.subList(i, list.size());
        }
    }

    private void expandStemHints(List<Integer> list, boolean z) {
    }

    private List<Integer> handleType1Command(List<Integer> list, CharStringCommand charStringCommand) {
        String str = CharStringCommand.TYPE1_VOCABULARY.get(charStringCommand.getKey());
        boolean z = false;
        boolean z2 = true;
        if ("hstem".equals(str)) {
            if (list.size() % 2 != 0) {
                z = true;
            }
            expandStemHints(clearStack(list, z), true);
        } else if ("vstem".equals(str)) {
            if (list.size() % 2 == 0) {
                z2 = false;
            }
            expandStemHints(clearStack(list, z2), false);
        } else if ("vmoveto".equals(str)) {
            if (list.size() > 1) {
                z = true;
            }
            List<Integer> clearStack = clearStack(list, z);
            markPath();
            addCommand(clearStack, charStringCommand);
        } else if ("rlineto".equals(str)) {
            addCommandList(split(list, 2), charStringCommand);
        } else if ("hlineto".equals(str)) {
            drawAlternatingLine(list, true);
        } else if ("vlineto".equals(str)) {
            drawAlternatingLine(list, false);
        } else if ("rrcurveto".equals(str)) {
            addCommandList(split(list, 6), charStringCommand);
        } else if ("endchar".equals(str)) {
            if (list.size() > 0) {
                z = true;
            }
            List<Integer> clearStack2 = clearStack(list, z);
            closePath();
            addCommand(clearStack2, charStringCommand);
        } else if ("rmoveto".equals(str)) {
            if (list.size() > 2) {
                z = true;
            }
            List<Integer> clearStack3 = clearStack(list, z);
            markPath();
            addCommand(clearStack3, charStringCommand);
        } else if ("hmoveto".equals(str)) {
            if (list.size() > 1) {
                z = true;
            }
            List<Integer> clearStack4 = clearStack(list, z);
            markPath();
            addCommand(clearStack4, charStringCommand);
        } else if ("vhcurveto".equals(str)) {
            drawAlternatingCurve(list, false);
        } else if ("hvcurveto".equals(str)) {
            drawAlternatingCurve(list, true);
        } else if ("return".equals(str)) {
            return list;
        } else {
            addCommand(list, charStringCommand);
        }
        return null;
    }

    private List<Integer> handleType2Command(List<Integer> list, CharStringCommand charStringCommand) {
        String str = CharStringCommand.TYPE2_VOCABULARY.get(charStringCommand.getKey());
        boolean equals = "hflex".equals(str);
        boolean z = true;
        boolean z2 = false;
        Integer valueOf = Integer.valueOf(0);
        if (equals) {
            addCommandList(Arrays.asList(new List[]{Arrays.asList(new Integer[]{list.get(0), valueOf, list.get(1), list.get(2), list.get(3), valueOf}), Arrays.asList(new Integer[]{list.get(4), valueOf, list.get(5), Integer.valueOf(-list.get(2).intValue()), list.get(6), valueOf})}), new CharStringCommand(8));
        } else if ("flex".equals(str)) {
            addCommandList(Arrays.asList(new List[]{list.subList(0, 6), list.subList(6, 12)}), new CharStringCommand(8));
        } else if ("hflex1".equals(str)) {
            addCommandList(Arrays.asList(new List[]{Arrays.asList(new Integer[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), valueOf}), Arrays.asList(new Integer[]{list.get(5), valueOf, list.get(6), list.get(7), list.get(8), valueOf})}), new CharStringCommand(8));
        } else if ("flex1".equals(str)) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                i += list.get(i4).intValue();
                i2 += list.get(i4 + 1).intValue();
            }
            List<Integer> subList = list.subList(0, 6);
            Integer[] numArr = new Integer[6];
            numArr[0] = list.get(6);
            numArr[1] = list.get(7);
            numArr[2] = list.get(8);
            numArr[3] = list.get(9);
            numArr[4] = Math.abs(i) > Math.abs(i2) ? list.get(10) : Integer.valueOf(-i);
            numArr[5] = Math.abs(i) > Math.abs(i2) ? Integer.valueOf(-i2) : list.get(10);
            addCommandList(Arrays.asList(new List[]{subList, Arrays.asList(numArr)}), new CharStringCommand(8));
        } else if ("hstemhm".equals(str)) {
            if (list.size() % 2 != 0) {
                z2 = true;
            }
            expandStemHints(clearStack(list, z2), true);
        } else if ("hintmask".equals(str) || "cntrmask".equals(str)) {
            if (list.size() % 2 == 0) {
                z = false;
            }
            List<Integer> clearStack = clearStack(list, z);
            if (clearStack.size() > 0) {
                expandStemHints(clearStack, false);
            }
        } else if ("vstemhm".equals(str)) {
            if (list.size() % 2 == 0) {
                z = false;
            }
            expandStemHints(clearStack(list, z), false);
        } else if ("rcurveline".equals(str)) {
            addCommandList(split(list.subList(0, list.size() - 2), 6), new CharStringCommand(8));
            addCommand(list.subList(list.size() - 2, list.size()), new CharStringCommand(5));
        } else if ("rlinecurve".equals(str)) {
            addCommandList(split(list.subList(0, list.size() - 6), 2), new CharStringCommand(5));
            addCommand(list.subList(list.size() - 6, list.size()), new CharStringCommand(8));
        } else if ("vvcurveto".equals(str)) {
            drawCurve(list, false);
        } else if ("hhcurveto".equals(str)) {
            drawCurve(list, true);
        } else {
            addCommand(list, charStringCommand);
        }
        return null;
    }

    private void markPath() {
        if (this.pathCount > 0) {
            closePath();
        }
        this.pathCount++;
    }

    public static <E> List<List<E>> split(List<E> list, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size() / i) {
            int i3 = i2 * i;
            i2++;
            arrayList.add(list.subList(i3, i2 * i));
        }
        return arrayList;
    }

    public List<Object> convert(List<Object> list) {
        this.sequence = new ArrayList();
        this.pathCount = 0;
        handleSequence(list);
        return this.sequence;
    }

    public List<Integer> handleCommand(List<Integer> list, CharStringCommand charStringCommand) {
        if (CharStringCommand.TYPE1_VOCABULARY.containsKey(charStringCommand.getKey())) {
            return handleType1Command(list, charStringCommand);
        }
        return handleType2Command(list, charStringCommand);
    }

    public CharStringConverter(int i, int i2) {
        this.defaultWidthX = i;
        this.nominalWidthX = i2;
    }
}
