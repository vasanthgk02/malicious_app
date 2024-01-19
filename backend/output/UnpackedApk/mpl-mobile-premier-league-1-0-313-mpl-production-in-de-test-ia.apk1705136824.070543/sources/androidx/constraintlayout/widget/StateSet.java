package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class StateSet {
    public int mCurrentConstraintNumber = -1;
    public int mCurrentStateId = -1;
    public int mDefaultState = -1;
    public SparseArray<State> mStateList = new SparseArray<>();

    public static class State {
        public int mConstraintID = -1;
        public int mId;
        public ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R$styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    "layout".equals(resourceTypeName);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public int findMatch(float f2, float f3) {
            for (int i = 0; i < this.mVariants.size(); i++) {
                if (this.mVariants.get(i).match(f2, f3)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static class Variant {
        public int mConstraintID = -1;
        public float mMaxHeight = Float.NaN;
        public float mMaxWidth = Float.NaN;
        public float mMinHeight = Float.NaN;
        public float mMinWidth = Float.NaN;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    "layout".equals(resourceTypeName);
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean match(float f2, float f3) {
            if (!Float.isNaN(this.mMinWidth) && f2 < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f3 < this.mMinHeight) {
                return false;
            }
            if (!Float.isNaN(this.mMaxWidth) && f2 > this.mMaxWidth) {
                return false;
            }
            if (Float.isNaN(this.mMaxHeight) || f3 <= this.mMaxHeight) {
                return true;
            }
            return false;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StateSet(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            r9.<init>()
            r0 = -1
            r9.mDefaultState = r0
            r9.mCurrentStateId = r0
            r9.mCurrentConstraintNumber = r0
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r9.mStateList = r1
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r11)
            int[] r2 = androidx.constraintlayout.widget.R$styleable.StateSet
            android.content.res.TypedArray r1 = r10.obtainStyledAttributes(r1, r2)
            int r2 = r1.getIndexCount()
            r3 = 0
            r4 = 0
        L_0x0026:
            if (r4 >= r2) goto L_0x003b
            int r5 = r1.getIndex(r4)
            int r6 = androidx.constraintlayout.widget.R$styleable.StateSet_defaultState
            if (r5 != r6) goto L_0x0038
            int r6 = r9.mDefaultState
            int r5 = r1.getResourceId(r5, r6)
            r9.mDefaultState = r5
        L_0x0038:
            int r4 = r4 + 1
            goto L_0x0026
        L_0x003b:
            r1.recycle()
            r1 = 0
            int r2 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
        L_0x0043:
            r4 = 1
            if (r2 == r4) goto L_0x00bf
            if (r2 == 0) goto L_0x00ae
            java.lang.String r5 = "StateSet"
            r6 = 3
            r7 = 2
            if (r2 == r7) goto L_0x005d
            if (r2 == r6) goto L_0x0051
            goto L_0x00b1
        L_0x0051:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            boolean r2 = r5.equals(r2)     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            if (r2 == 0) goto L_0x00b1
            goto L_0x00bf
        L_0x005d:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            int r8 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            switch(r8) {
                case 80204913: goto L_0x0084;
                case 1301459538: goto L_0x007a;
                case 1382829617: goto L_0x0073;
                case 1901439077: goto L_0x0069;
                default: goto L_0x0068;
            }     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
        L_0x0068:
            goto L_0x008e
        L_0x0069:
            java.lang.String r4 = "Variant"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            if (r2 == 0) goto L_0x008e
            r4 = 3
            goto L_0x008f
        L_0x0073:
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            if (r2 == 0) goto L_0x008e
            goto L_0x008f
        L_0x007a:
            java.lang.String r4 = "LayoutDescription"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            if (r2 == 0) goto L_0x008e
            r4 = 0
            goto L_0x008f
        L_0x0084:
            java.lang.String r4 = "State"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            if (r2 == 0) goto L_0x008e
            r4 = 2
            goto L_0x008f
        L_0x008e:
            r4 = -1
        L_0x008f:
            if (r4 == r7) goto L_0x00a1
            if (r4 == r6) goto L_0x0094
            goto L_0x00b1
        L_0x0094:
            androidx.constraintlayout.widget.StateSet$Variant r2 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            r2.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            if (r1 == 0) goto L_0x00b1
            java.util.ArrayList<androidx.constraintlayout.widget.StateSet$Variant> r4 = r1.mVariants     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            r4.add(r2)     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            goto L_0x00b1
        L_0x00a1:
            androidx.constraintlayout.widget.StateSet$State r1 = new androidx.constraintlayout.widget.StateSet$State     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            r1.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r2 = r9.mStateList     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            int r4 = r1.mId     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            r2.put(r4, r1)     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            goto L_0x00b1
        L_0x00ae:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
        L_0x00b1:
            int r2 = r11.next()     // Catch:{ XmlPullParserException -> 0x00bb, IOException -> 0x00b6 }
            goto L_0x0043
        L_0x00b6:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00bf
        L_0x00bb:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int stateGetConstraintID(int i, int i2, int i3) {
        int i4;
        State state;
        float f2 = (float) i2;
        float f3 = (float) i3;
        if (-1 == i) {
            if (i == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(this.mCurrentStateId);
            }
            if (state == null) {
                return -1;
            }
            if (this.mCurrentConstraintNumber != -1 && state.mVariants.get(-1).match(f2, f3)) {
                return -1;
            }
            int findMatch = state.findMatch(f2, f3);
            if (-1 == findMatch) {
                return -1;
            }
            i4 = findMatch == -1 ? state.mConstraintID : state.mVariants.get(findMatch).mConstraintID;
        } else {
            State state2 = this.mStateList.get(i);
            if (state2 == null) {
                return -1;
            }
            int findMatch2 = state2.findMatch(f2, f3);
            i4 = findMatch2 == -1 ? state2.mConstraintID : state2.mVariants.get(findMatch2).mConstraintID;
        }
        return i4;
    }
}
