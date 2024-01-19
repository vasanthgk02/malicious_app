package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.mpl.androidapp.R;

public final class SplashScreenBinding implements ViewBinding {
    public final Button btnDownload;
    public final LottieAnimationView dynamicSplashImageLottie;
    public final ConstraintLayout errorView;
    public final ConstraintLayout errorViewContentView;
    public final View gestureView;
    public final ImageView imgAction;
    public final ProgressBar progress;
    public final Button releaseNoteBtnDownload;
    public final ConstraintLayout releaseNoteContainer;
    public final ConstraintLayout releaseNoteLayoutMain;
    public final FrameLayout rootView;
    public final ProgressBar splashProgress;
    public final TextView storageTxt;
    public final TextView txtMessage;
    public final TextView txtProgress;
    public final TextView txtStatus;
    public final RecyclerView updateItemList;
    public final View view;

    public SplashScreenBinding(FrameLayout frameLayout, Button button, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view2, ImageView imageView, ProgressBar progressBar, Button button2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ProgressBar progressBar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, RecyclerView recyclerView, View view3) {
        this.rootView = frameLayout;
        this.btnDownload = button;
        this.dynamicSplashImageLottie = lottieAnimationView;
        this.errorView = constraintLayout;
        this.errorViewContentView = constraintLayout2;
        this.gestureView = view2;
        this.imgAction = imageView;
        this.progress = progressBar;
        this.releaseNoteBtnDownload = button2;
        this.releaseNoteContainer = constraintLayout3;
        this.releaseNoteLayoutMain = constraintLayout4;
        this.splashProgress = progressBar2;
        this.storageTxt = textView;
        this.txtMessage = textView2;
        this.txtProgress = textView3;
        this.txtStatus = textView4;
        this.updateItemList = recyclerView;
        this.view = view3;
    }

    public static SplashScreenBinding bind(View view2) {
        View view3 = view2;
        int i = R.id.btn_download;
        Button button = (Button) view3.findViewById(R.id.btn_download);
        if (button != null) {
            i = R.id.dynamic_splash_image_lottie;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view3.findViewById(R.id.dynamic_splash_image_lottie);
            if (lottieAnimationView != null) {
                i = R.id.error_view;
                ConstraintLayout constraintLayout = (ConstraintLayout) view3.findViewById(R.id.error_view);
                if (constraintLayout != null) {
                    i = R.id.error_view_content_view;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view3.findViewById(R.id.error_view_content_view);
                    if (constraintLayout2 != null) {
                        i = R.id.gesture_view;
                        View findViewById = view3.findViewById(R.id.gesture_view);
                        if (findViewById != null) {
                            i = R.id.img_action;
                            ImageView imageView = (ImageView) view3.findViewById(R.id.img_action);
                            if (imageView != null) {
                                i = R.id.progress;
                                ProgressBar progressBar = (ProgressBar) view3.findViewById(R.id.progress);
                                if (progressBar != null) {
                                    i = R.id.release_note_btn_download;
                                    Button button2 = (Button) view3.findViewById(R.id.release_note_btn_download);
                                    if (button2 != null) {
                                        i = R.id.releaseNoteContainer;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view3.findViewById(R.id.releaseNoteContainer);
                                        if (constraintLayout3 != null) {
                                            i = R.id.release_note_layout_main;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view3.findViewById(R.id.release_note_layout_main);
                                            if (constraintLayout4 != null) {
                                                i = R.id.splash_progress;
                                                ProgressBar progressBar2 = (ProgressBar) view3.findViewById(R.id.splash_progress);
                                                if (progressBar2 != null) {
                                                    i = R.id.storageTxt;
                                                    TextView textView = (TextView) view3.findViewById(R.id.storageTxt);
                                                    if (textView != null) {
                                                        i = R.id.txt_message;
                                                        TextView textView2 = (TextView) view3.findViewById(R.id.txt_message);
                                                        if (textView2 != null) {
                                                            i = R.id.txt_progress;
                                                            TextView textView3 = (TextView) view3.findViewById(R.id.txt_progress);
                                                            if (textView3 != null) {
                                                                i = R.id.txtStatus;
                                                                TextView textView4 = (TextView) view3.findViewById(R.id.txtStatus);
                                                                if (textView4 != null) {
                                                                    i = R.id.update_item_list;
                                                                    RecyclerView recyclerView = (RecyclerView) view3.findViewById(R.id.update_item_list);
                                                                    if (recyclerView != null) {
                                                                        i = R.id.view;
                                                                        View findViewById2 = view3.findViewById(R.id.view);
                                                                        if (findViewById2 != null) {
                                                                            SplashScreenBinding splashScreenBinding = new SplashScreenBinding((FrameLayout) view3, button, lottieAnimationView, constraintLayout, constraintLayout2, findViewById, imageView, progressBar, button2, constraintLayout3, constraintLayout4, progressBar2, textView, textView2, textView3, textView4, recyclerView, findViewById2);
                                                                            return splashScreenBinding;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }

    public static SplashScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SplashScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.splash_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
