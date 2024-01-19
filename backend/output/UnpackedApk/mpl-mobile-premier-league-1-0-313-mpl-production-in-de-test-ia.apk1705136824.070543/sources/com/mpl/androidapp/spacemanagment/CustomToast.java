package com.mpl.androidapp.spacemanagment;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.MLogger;

public class CustomToast {
    public static final String TAG = "CustomToast";

    public void showToast(Activity activity, String str) {
        try {
            View inflate = activity.getLayoutInflater().inflate(R.layout.toast_game_space, (ViewGroup) activity.findViewById(R.id.cv_toast));
            TextView textView = (TextView) inflate.findViewById(R.id.tv_message);
            textView.setText(str);
            textView.setTypeface(Typeface.createFromAsset(MPLApplication.getInstance().getAssets(), "fonts/Roboto-Regular.ttf"));
            Toast toast = new Toast(activity);
            toast.setGravity(87, 0, 90);
            toast.setDuration(1);
            toast.setView(inflate);
            toast.show();
        } catch (Exception e2) {
            MLogger.d(TAG, e2.getMessage());
        }
    }
}
