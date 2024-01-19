package com.paynimo.android.payment.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ShowDialog extends Activity {

    public static class a implements OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f1438a;

        public a(Dialog dialog) {
            this.f1438a = dialog;
        }

        public void onClick(View view) {
            this.f1438a.dismiss();
        }
    }

    public static void showAlertDialog(Context context, String str, String str2, Boolean bool) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(context.getResources().getIdentifier("paynimo_dialog_one_button", "layout", context.getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(context.getResources().getIdentifier("paynimo_dialog_one_tv", "id", context.getPackageName()))).setText(str2);
        ((Button) dialog.findViewById(context.getResources().getIdentifier("paynimo_dialog_one_btn", "id", context.getPackageName()))).setOnClickListener(new a(dialog));
        dialog.show();
    }
}
