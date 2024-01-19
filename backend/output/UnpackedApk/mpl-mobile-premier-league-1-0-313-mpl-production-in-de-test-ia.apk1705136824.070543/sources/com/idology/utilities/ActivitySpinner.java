package com.idology.utilities;

import android.app.Activity;
import android.app.ProgressDialog;

public class ActivitySpinner {
    public Activity mActivity = null;
    public ProgressDialog progressDialog;

    public ActivitySpinner(Activity activity) {
        this.mActivity = activity;
    }

    public void cancel() {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && progressDialog2.isShowing()) {
            this.progressDialog.dismiss();
        }
    }

    public void start() {
        if (this.progressDialog == null) {
            ProgressDialog progressDialog2 = new ProgressDialog(this.mActivity);
            this.progressDialog = progressDialog2;
            progressDialog2.setMessage("Getting Results ... Please Wait");
            this.progressDialog.setProgressStyle(0);
            this.progressDialog.setCanceledOnTouchOutside(false);
        }
        this.progressDialog.show();
    }
}
