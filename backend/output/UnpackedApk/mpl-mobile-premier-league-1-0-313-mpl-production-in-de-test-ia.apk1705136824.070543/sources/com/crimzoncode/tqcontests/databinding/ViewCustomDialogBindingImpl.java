package com.crimzoncode.tqcontests.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.crimzoncode.tqcontests.BR;
import com.crimzoncode.tqcontests.R;
import com.crimzoncode.tqcontests.util.dialog.DialogDetails;
import com.crimzoncode.tqcontests.util.dialog.OnCustomDialogInteractionListener;

public class ViewCustomDialogBindingImpl extends ViewCustomDialogBinding {
    public static final IncludedLayouts sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.custom_view_container, 7);
    }

    public ViewCustomDialogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r37 = this;
            r1 = r37
            monitor-enter(r37)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x01e1 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x01e1 }
            monitor-exit(r37)     // Catch:{ all -> 0x01e1 }
            com.crimzoncode.tqcontests.util.dialog.OnCustomDialogInteractionListener r0 = r1.mListener
            com.crimzoncode.tqcontests.util.dialog.DialogDetails r6 = r1.mDialogDetails
            r7 = 7
            long r9 = r2 & r7
            r11 = 1048576(0x100000, double:5.180654E-318)
            r13 = 16384(0x4000, double:8.095E-320)
            r16 = 0
            int r17 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0031
            if (r0 == 0) goto L_0x0021
            r0 = 1
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r17 == 0) goto L_0x0032
            if (r0 == 0) goto L_0x0029
            long r2 = r2 | r13
            long r2 = r2 | r11
            goto L_0x0032
        L_0x0029:
            r9 = 8192(0x2000, double:4.0474E-320)
            long r2 = r2 | r9
            r9 = 524288(0x80000, double:2.590327E-318)
            long r2 = r2 | r9
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            r9 = 6
            long r17 = r2 & r9
            r19 = 64
            r21 = 8
            r22 = 0
            int r23 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x00e1
            if (r6 == 0) goto L_0x005b
            java.lang.String r22 = r6.getDescriptionBig()
            java.lang.String r17 = r6.getButtonText()
            java.lang.String r18 = r6.getTitle()
            android.graphics.drawable.Drawable r24 = r6.getIconDrawable()
            java.lang.String r25 = r6.getSecondaryButtonText()
            java.lang.String r26 = r6.getDescriptionSmall()
            goto L_0x0065
        L_0x005b:
            r17 = r22
            r18 = r17
            r24 = r18
            r25 = r24
            r26 = r25
        L_0x0065:
            if (r22 != 0) goto L_0x006a
            r27 = 1
            goto L_0x006c
        L_0x006a:
            r27 = 0
        L_0x006c:
            if (r18 != 0) goto L_0x0071
            r28 = 1
            goto L_0x0073
        L_0x0071:
            r28 = 0
        L_0x0073:
            if (r24 != 0) goto L_0x0078
            r24 = 1
            goto L_0x007a
        L_0x0078:
            r24 = 0
        L_0x007a:
            if (r26 != 0) goto L_0x007f
            r29 = 1
            goto L_0x0081
        L_0x007f:
            r29 = 0
        L_0x0081:
            if (r23 == 0) goto L_0x008e
            if (r27 == 0) goto L_0x0089
            r30 = 65536(0x10000, double:3.2379E-319)
            goto L_0x008c
        L_0x0089:
            r30 = 32768(0x8000, double:1.61895E-319)
        L_0x008c:
            long r2 = r2 | r30
        L_0x008e:
            long r30 = r2 & r9
            int r23 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x009d
            if (r28 == 0) goto L_0x0099
            r30 = 16
            goto L_0x009b
        L_0x0099:
            r30 = 8
        L_0x009b:
            long r2 = r2 | r30
        L_0x009d:
            long r30 = r2 & r9
            int r23 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x00ac
            if (r24 == 0) goto L_0x00a8
            long r2 = r2 | r19
            goto L_0x00ac
        L_0x00a8:
            r30 = 32
            long r2 = r2 | r30
        L_0x00ac:
            long r30 = r2 & r9
            int r23 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x00bd
            if (r29 == 0) goto L_0x00b8
            r30 = 262144(0x40000, double:1.295163E-318)
            goto L_0x00bb
        L_0x00b8:
            r30 = 131072(0x20000, double:6.4758E-319)
        L_0x00bb:
            long r2 = r2 | r30
        L_0x00bd:
            if (r27 == 0) goto L_0x00c2
            r23 = 8
            goto L_0x00c4
        L_0x00c2:
            r23 = 0
        L_0x00c4:
            if (r28 == 0) goto L_0x00c9
            r27 = 8
            goto L_0x00cb
        L_0x00c9:
            r27 = 0
        L_0x00cb:
            if (r29 == 0) goto L_0x00d0
            r28 = 8
            goto L_0x00d2
        L_0x00d0:
            r28 = 0
        L_0x00d2:
            r32 = r18
            r15 = r22
            r34 = r23
            r33 = r26
            r35 = r27
            r36 = r28
            r22 = r17
            goto L_0x00f1
        L_0x00e1:
            r15 = r22
            r25 = r15
            r32 = r25
            r33 = r32
            r24 = 0
            r34 = 0
            r35 = 0
            r36 = 0
        L_0x00f1:
            r26 = 1065024(0x104040, double:5.26192E-318)
            long r26 = r2 & r26
            int r18 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0139
            long r13 = r13 & r2
            int r18 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0109
            if (r6 == 0) goto L_0x0105
            java.lang.String r22 = r6.getButtonText()
        L_0x0105:
            if (r22 == 0) goto L_0x0109
            r13 = 1
            goto L_0x010a
        L_0x0109:
            r13 = 0
        L_0x010a:
            long r18 = r2 & r19
            int r14 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x011c
            if (r6 == 0) goto L_0x0117
            int r14 = r6.getIconRes()
            goto L_0x0118
        L_0x0117:
            r14 = 0
        L_0x0118:
            if (r14 != 0) goto L_0x011c
            r14 = 1
            goto L_0x011d
        L_0x011c:
            r14 = 0
        L_0x011d:
            long r11 = r11 & r2
            int r18 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0134
            if (r6 == 0) goto L_0x0128
            java.lang.String r25 = r6.getSecondaryButtonText()
        L_0x0128:
            if (r25 == 0) goto L_0x012d
            r17 = 1
            goto L_0x012f
        L_0x012d:
            r17 = 0
        L_0x012f:
            r6 = r22
            r11 = r25
            goto L_0x0141
        L_0x0134:
            r6 = r22
            r11 = r25
            goto L_0x013f
        L_0x0139:
            r6 = r22
            r11 = r25
            r13 = 0
            r14 = 0
        L_0x013f:
            r17 = 0
        L_0x0141:
            long r18 = r2 & r9
            int r12 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x015b
            if (r24 == 0) goto L_0x014a
            goto L_0x014b
        L_0x014a:
            r14 = 0
        L_0x014b:
            if (r12 == 0) goto L_0x0156
            if (r14 == 0) goto L_0x0152
            r18 = 256(0x100, double:1.265E-321)
            goto L_0x0154
        L_0x0152:
            r18 = 128(0x80, double:6.3E-322)
        L_0x0154:
            long r2 = r2 | r18
        L_0x0156:
            if (r14 == 0) goto L_0x015b
            r12 = 8
            goto L_0x015c
        L_0x015b:
            r12 = 0
        L_0x015c:
            long r18 = r2 & r7
            int r14 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0193
            if (r0 == 0) goto L_0x0165
            goto L_0x0166
        L_0x0165:
            r13 = 0
        L_0x0166:
            if (r0 == 0) goto L_0x0169
            goto L_0x016b
        L_0x0169:
            r17 = 0
        L_0x016b:
            if (r14 == 0) goto L_0x0176
            if (r13 == 0) goto L_0x0172
            r18 = 1024(0x400, double:5.06E-321)
            goto L_0x0174
        L_0x0172:
            r18 = 512(0x200, double:2.53E-321)
        L_0x0174:
            long r2 = r2 | r18
        L_0x0176:
            long r18 = r2 & r7
            int r0 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0185
            if (r17 == 0) goto L_0x0181
            r18 = 4096(0x1000, double:2.0237E-320)
            goto L_0x0183
        L_0x0181:
            r18 = 2048(0x800, double:1.012E-320)
        L_0x0183:
            long r2 = r2 | r18
        L_0x0185:
            if (r13 == 0) goto L_0x0189
            r0 = 0
            goto L_0x018b
        L_0x0189:
            r0 = 8
        L_0x018b:
            if (r17 == 0) goto L_0x018e
            goto L_0x0190
        L_0x018e:
            r16 = 8
        L_0x0190:
            r13 = r16
            goto L_0x0195
        L_0x0193:
            r0 = 0
            r13 = 0
        L_0x0195:
            long r9 = r9 & r2
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x01d1
            android.widget.Button r9 = r1.actionButton
            androidx.core.widget.CompoundButtonCompat.setText(r9, r6)
            android.widget.TextView r6 = r1.descriptionBig
            androidx.core.widget.CompoundButtonCompat.setText(r6, r15)
            android.widget.TextView r6 = r1.descriptionBig
            r9 = r34
            r6.setVisibility(r9)
            android.widget.TextView r6 = r1.descriptionSmall
            r9 = r33
            androidx.core.widget.CompoundButtonCompat.setText(r6, r9)
            android.widget.TextView r6 = r1.descriptionSmall
            r9 = r36
            r6.setVisibility(r9)
            android.widget.TextView r6 = r1.dialogTitle
            r9 = r32
            androidx.core.widget.CompoundButtonCompat.setText(r6, r9)
            android.widget.TextView r6 = r1.dialogTitle
            r9 = r35
            r6.setVisibility(r9)
            android.widget.ImageView r6 = r1.popupLogo
            r6.setVisibility(r12)
            android.widget.Button r6 = r1.secondaryActionButton
            androidx.core.widget.CompoundButtonCompat.setText(r6, r11)
        L_0x01d1:
            long r2 = r2 & r7
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x01e0
            android.widget.Button r2 = r1.actionButton
            r2.setVisibility(r0)
            android.widget.Button r0 = r1.secondaryActionButton
            r0.setVisibility(r13)
        L_0x01e0:
            return
        L_0x01e1:
            r0 = move-exception
            monitor-exit(r37)     // Catch:{ all -> 0x01e1 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crimzoncode.tqcontests.databinding.ViewCustomDialogBindingImpl.executeBindings():void");
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        requestRebind();
    }

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public void setDialogDetails(DialogDetails dialogDetails) {
        this.mDialogDetails = dialogDetails;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.dialogDetails);
        super.requestRebind();
    }

    public void setListener(OnCustomDialogInteractionListener onCustomDialogInteractionListener) {
        this.mListener = onCustomDialogInteractionListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (BR.listener == i) {
            setListener((OnCustomDialogInteractionListener) obj);
        } else if (BR.dialogDetails != i) {
            return false;
        } else {
            setDialogDetails((DialogDetails) obj);
        }
        return true;
    }

    public ViewCustomDialogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[5], (FrameLayout) objArr[7], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[1], (ImageView) objArr[3], (Button) objArr[6]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.descriptionBig.setTag(null);
        this.descriptionSmall.setTag(null);
        this.dialogTitle.setTag(null);
        RelativeLayout relativeLayout = objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.popupLogo.setTag(null);
        this.secondaryActionButton.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
