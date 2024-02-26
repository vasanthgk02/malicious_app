package a.SurlyProjectFinal;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;

public class musicPlayerApi {
    public static Dialog makeDialogForLoading(Context context) {
        Dialog dialog = new Dialog(context, R.style.Theme_CustomDialog);
        dialog.setContentView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_activity, null));
        return dialog;
    }

    public static String getAudioDuration(long audioDuration2) {
        int seconds = ((int) audioDuration2) / 1000;
        int minutes = seconds / 60;
        int leftOutSeconds = seconds - (minutes * 60);
        return (minutes >= 10 ? Integer.valueOf(minutes) : "0" + minutes) + ":" + (leftOutSeconds >= 10 ? Integer.valueOf(leftOutSeconds) : "0" + leftOutSeconds);
    }
}
