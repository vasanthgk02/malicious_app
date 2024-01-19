package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

public class TooltipPopup {
    public final View mContentView;
    public final Context mContext;
    public final LayoutParams mLayoutParams = new LayoutParams();
    public final TextView mMessageView;
    public final int[] mTmpAnchorPos = new int[2];
    public final int[] mTmpAppPos = new int[2];
    public final Rect mTmpDisplayFrame = new Rect();

    public TooltipPopup(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.abc_tooltip, null);
        this.mContentView = inflate;
        this.mMessageView = (TextView) inflate.findViewById(R$id.message);
        this.mLayoutParams.setTitle(TooltipPopup.class.getSimpleName());
        this.mLayoutParams.packageName = this.mContext.getPackageName();
        LayoutParams layoutParams = this.mLayoutParams;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public void hide() {
        if (this.mContentView.getParent() != null) {
            ((WindowManager) this.mContext.getSystemService("window")).removeView(this.mContentView);
        }
    }
}
