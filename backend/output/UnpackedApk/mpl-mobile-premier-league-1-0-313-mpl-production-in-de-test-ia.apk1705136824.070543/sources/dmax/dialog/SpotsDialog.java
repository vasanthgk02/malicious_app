package dmax.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.TextView;
import org.apache.commons.net.ftp.FTPReply;

public class SpotsDialog extends AlertDialog {
    public AnimatorPlayer animator;
    public CharSequence message;
    public int size;
    public AnimatedView[] spots;

    public SpotsDialog(Context context, String str, int i, boolean z, OnCancelListener onCancelListener, AnonymousClass1 r6) {
        super(context, i);
        this.message = str;
        setCancelable(z);
        if (onCancelListener != null) {
            setOnCancelListener(onCancelListener);
        }
    }

    public final void initMessage() {
        CharSequence charSequence = this.message;
        if (charSequence != null && charSequence.length() > 0) {
            ((TextView) findViewById(R$id.dmax_spots_title)).setText(this.message);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.dmax_spots_dialog);
        setCanceledOnTouchOutside(false);
        initMessage();
        ProgressLayout progressLayout = (ProgressLayout) findViewById(R$id.dmax_spots_progress);
        int spotsCount = progressLayout.getSpotsCount();
        this.size = spotsCount;
        this.spots = new AnimatedView[spotsCount];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.spot_size);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R$dimen.progress_width);
        for (int i = 0; i < this.spots.length; i++) {
            AnimatedView animatedView = new AnimatedView(getContext());
            animatedView.setBackgroundResource(R$drawable.dmax_spots_spot);
            animatedView.target = dimensionPixelSize2;
            animatedView.setX(((float) dimensionPixelSize2) * -1.0f);
            animatedView.setVisibility(4);
            progressLayout.addView(animatedView, dimensionPixelSize, dimensionPixelSize);
            this.spots[i] = animatedView;
        }
    }

    public void onStart() {
        super.onStart();
        int i = 0;
        for (AnimatedView visibility : this.spots) {
            visibility.setVisibility(0);
        }
        Animator[] animatorArr = new Animator[this.size];
        while (true) {
            AnimatedView[] animatedViewArr = this.spots;
            if (i >= animatedViewArr.length) {
                break;
            }
            final AnimatedView animatedView = animatedViewArr[i];
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(animatedView, "xFactor", new float[]{0.0f, 1.0f});
            ofFloat.setDuration(1500);
            ofFloat.setInterpolator(new HesitateInterpolator());
            ofFloat.setStartDelay((long) (i * FTPReply.FILE_STATUS_OK));
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    animatedView.setVisibility(4);
                }

                public void onAnimationStart(Animator animator) {
                    animatedView.setVisibility(0);
                }
            });
            animatorArr[i] = ofFloat;
            i++;
        }
        AnimatorPlayer animatorPlayer = new AnimatorPlayer(animatorArr);
        this.animator = animatorPlayer;
        if (animatorPlayer != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(animatorPlayer.animators);
            animatorSet.addListener(animatorPlayer);
            animatorSet.start();
            return;
        }
        throw null;
    }

    public void onStop() {
        super.onStop();
        this.animator.interrupted = true;
    }

    public void setMessage(CharSequence charSequence) {
        this.message = charSequence;
        if (isShowing()) {
            initMessage();
        }
    }
}
