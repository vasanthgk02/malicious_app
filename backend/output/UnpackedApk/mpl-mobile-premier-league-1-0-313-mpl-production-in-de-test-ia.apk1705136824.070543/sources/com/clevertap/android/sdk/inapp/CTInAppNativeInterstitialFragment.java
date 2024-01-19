package com.clevertap.android.sdk.inapp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat.WearableExtender;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.clevertap.android.sdk.R$drawable;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.gif.GifImageView;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.Builder;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;

public class CTInAppNativeInterstitialFragment extends CTInAppBaseFullNativeFragment {
    public static long mediaPosition;
    public boolean exoPlayerFullscreen = false;
    public Dialog fullScreenDialog;
    public ImageView fullScreenIcon;
    public GifImageView gifImageView;
    public LayoutParams imageViewLayoutParams;
    public SimpleExoPlayer player;
    public PlayerView playerView;
    public LayoutParams playerViewLayoutParams;
    public RelativeLayout relativeLayout;
    public FrameLayout videoFrameLayout;
    public LayoutParams videoFramelayoutParams;

    public void cleanup() {
        GifImageView gifImageView2 = this.gifImageView;
        if (gifImageView2 != null) {
            gifImageView2.clear();
        }
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
            this.player.release();
            this.player = null;
        }
    }

    public final void closeFullscreenDialog() {
        ((ViewGroup) this.playerView.getParent()).removeView(this.playerView);
        this.playerView.setLayoutParams(this.playerViewLayoutParams);
        ((FrameLayout) this.videoFrameLayout.findViewById(R$id.video_frame)).addView(this.playerView);
        this.fullScreenIcon.setLayoutParams(this.imageViewLayoutParams);
        ((FrameLayout) this.videoFrameLayout.findViewById(R$id.video_frame)).addView(this.fullScreenIcon);
        this.videoFrameLayout.setLayoutParams(this.videoFramelayoutParams);
        ((RelativeLayout) this.relativeLayout.findViewById(R$id.interstitial_relative_layout)).addView(this.videoFrameLayout);
        this.exoPlayerFullscreen = false;
        this.fullScreenDialog.dismiss();
        this.fullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this.context, R$drawable.ct_ic_fullscreen_expand));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        ArrayList arrayList = new ArrayList();
        if (!this.inAppNotification.isTablet || !isTablet()) {
            view = layoutInflater.inflate(R$layout.inapp_interstitial, viewGroup, false);
        } else {
            view = layoutInflater.inflate(R$layout.tab_inapp_interstitial, viewGroup, false);
        }
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.inapp_interstitial_frame_layout);
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        RelativeLayout relativeLayout2 = (RelativeLayout) frameLayout.findViewById(R$id.interstitial_relative_layout);
        this.relativeLayout = relativeLayout2;
        relativeLayout2.setBackgroundColor(Color.parseColor(this.inAppNotification.backgroundColor));
        int i = this.currentOrientation;
        if (i == 1) {
            this.relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R$id.interstitial_relative_layout);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
                    CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment = CTInAppNativeInterstitialFragment.this;
                    if (cTInAppNativeInterstitialFragment.inAppNotification.isTablet && cTInAppNativeInterstitialFragment.isTablet()) {
                        CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment2 = CTInAppNativeInterstitialFragment.this;
                        cTInAppNativeInterstitialFragment2.redrawInterstitialTabletInApp(cTInAppNativeInterstitialFragment2.relativeLayout, layoutParams, frameLayout, closeImageView);
                    } else if (CTInAppNativeInterstitialFragment.this.isTablet()) {
                        CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment3 = CTInAppNativeInterstitialFragment.this;
                        cTInAppNativeInterstitialFragment3.redrawInterstitialMobileInAppOnTablet(cTInAppNativeInterstitialFragment3.relativeLayout, layoutParams, frameLayout, closeImageView);
                    } else {
                        CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment4 = CTInAppNativeInterstitialFragment.this;
                        CloseImageView closeImageView = closeImageView;
                        if (cTInAppNativeInterstitialFragment4 != null) {
                            layoutParams.height = (int) (((float) relativeLayout.getMeasuredWidth()) * 1.78f);
                            relativeLayout.setLayoutParams(layoutParams);
                            cTInAppNativeInterstitialFragment4.addCloseImageView(relativeLayout, closeImageView);
                        } else {
                            throw null;
                        }
                    }
                    CTInAppNativeInterstitialFragment.this.relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        } else if (i == 2) {
            this.relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) CTInAppNativeInterstitialFragment.this.relativeLayout.getLayoutParams();
                    CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment = CTInAppNativeInterstitialFragment.this;
                    if (cTInAppNativeInterstitialFragment.inAppNotification.isTablet && cTInAppNativeInterstitialFragment.isTablet()) {
                        CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment2 = CTInAppNativeInterstitialFragment.this;
                        cTInAppNativeInterstitialFragment2.redrawLandscapeInterstitialTabletInApp(cTInAppNativeInterstitialFragment2.relativeLayout, layoutParams, frameLayout, closeImageView);
                    } else if (CTInAppNativeInterstitialFragment.this.isTablet()) {
                        CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment3 = CTInAppNativeInterstitialFragment.this;
                        cTInAppNativeInterstitialFragment3.redrawLandscapeInterstitialMobileInAppOnTablet(cTInAppNativeInterstitialFragment3.relativeLayout, layoutParams, frameLayout, closeImageView);
                    } else {
                        CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment4 = CTInAppNativeInterstitialFragment.this;
                        cTInAppNativeInterstitialFragment4.redrawLandscapeInterstitialInApp(cTInAppNativeInterstitialFragment4.relativeLayout, layoutParams, closeImageView);
                    }
                    CTInAppNativeInterstitialFragment.this.relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
        if (!this.inAppNotification.mediaList.isEmpty()) {
            if (this.inAppNotification.mediaList.get(0).isImage()) {
                CTInAppNotification cTInAppNotification = this.inAppNotification;
                if (cTInAppNotification.getImage(cTInAppNotification.mediaList.get(0)) != null) {
                    ImageView imageView = (ImageView) this.relativeLayout.findViewById(R$id.backgroundImage);
                    imageView.setVisibility(0);
                    CTInAppNotification cTInAppNotification2 = this.inAppNotification;
                    imageView.setImageBitmap(cTInAppNotification2.getImage(cTInAppNotification2.mediaList.get(0)));
                }
            } else if (this.inAppNotification.mediaList.get(0).isGIF()) {
                CTInAppNotification cTInAppNotification3 = this.inAppNotification;
                if (cTInAppNotification3.getGifByteArray(cTInAppNotification3.mediaList.get(0)) != null) {
                    GifImageView gifImageView2 = (GifImageView) this.relativeLayout.findViewById(R$id.gifImage);
                    this.gifImageView = gifImageView2;
                    gifImageView2.setVisibility(0);
                    GifImageView gifImageView3 = this.gifImageView;
                    CTInAppNotification cTInAppNotification4 = this.inAppNotification;
                    gifImageView3.setBytes(cTInAppNotification4.getGifByteArray(cTInAppNotification4.mediaList.get(0)));
                    GifImageView gifImageView4 = this.gifImageView;
                    gifImageView4.animating = true;
                    gifImageView4.startAnimationThread();
                }
            } else if (this.inAppNotification.mediaList.get(0).isVideo()) {
                this.fullScreenDialog = new Dialog(this.context, 16973834) {
                    public void onBackPressed() {
                        CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment = CTInAppNativeInterstitialFragment.this;
                        if (cTInAppNativeInterstitialFragment.exoPlayerFullscreen) {
                            cTInAppNativeInterstitialFragment.closeFullscreenDialog();
                        }
                        super.onBackPressed();
                    }
                };
                prepareMedia();
                playMedia();
            } else if (this.inAppNotification.mediaList.get(0).isAudio()) {
                prepareMedia();
                playMedia();
                this.fullScreenIcon.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) this.relativeLayout.findViewById(R$id.interstitial_linear_layout);
        Button button = (Button) linearLayout.findViewById(R$id.interstitial_button1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout.findViewById(R$id.interstitial_button2);
        arrayList.add(button2);
        TextView textView = (TextView) this.relativeLayout.findViewById(R$id.interstitial_title);
        textView.setText(this.inAppNotification.title);
        textView.setTextColor(Color.parseColor(this.inAppNotification.titleColor));
        TextView textView2 = (TextView) this.relativeLayout.findViewById(R$id.interstitial_message);
        textView2.setText(this.inAppNotification.message);
        textView2.setTextColor(Color.parseColor(this.inAppNotification.messageColor));
        ArrayList<CTInAppNotificationButton> arrayList2 = this.inAppNotification.buttons;
        if (arrayList2.size() == 1) {
            int i2 = this.currentOrientation;
            if (i2 == 2) {
                button.setVisibility(8);
            } else if (i2 == 1) {
                button.setVisibility(4);
            }
            setupInAppButton(button2, arrayList2.get(0), 0);
        } else if (!arrayList2.isEmpty()) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (i3 < 2) {
                    setupInAppButton((Button) arrayList.get(i3), arrayList2.get(i3), i3);
                }
            }
        }
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        closeImageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CTInAppNativeInterstitialFragment.this.didDismiss(null);
                GifImageView gifImageView = CTInAppNativeInterstitialFragment.this.gifImageView;
                if (gifImageView != null) {
                    gifImageView.clear();
                }
                CTInAppNativeInterstitialFragment.this.getActivity().finish();
            }
        });
        if (!this.inAppNotification.hideCloseButton) {
            closeImageView.setVisibility(8);
        } else {
            closeImageView.setVisibility(0);
        }
        return view;
    }

    public void onPause() {
        super.onPause();
        GifImageView gifImageView2 = this.gifImageView;
        if (gifImageView2 != null) {
            gifImageView2.clear();
        }
        if (this.exoPlayerFullscreen) {
            closeFullscreenDialog();
        }
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            mediaPosition = simpleExoPlayer.getCurrentPosition();
            this.player.stop();
            this.player.release();
            this.player = null;
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.inAppNotification.mediaList.isEmpty() && this.player == null) {
            if (this.inAppNotification.mediaList.get(0).isVideo() || this.inAppNotification.mediaList.get(0).isAudio()) {
                prepareMedia();
                playMedia();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        GifImageView gifImageView2 = this.gifImageView;
        if (gifImageView2 != null) {
            CTInAppNotification cTInAppNotification = this.inAppNotification;
            gifImageView2.setBytes(cTInAppNotification.getGifByteArray(cTInAppNotification.mediaList.get(0)));
            GifImageView gifImageView3 = this.gifImageView;
            gifImageView3.animating = true;
            gifImageView3.startAnimationThread();
        }
    }

    public void onStop() {
        super.onStop();
        GifImageView gifImageView2 = this.gifImageView;
        if (gifImageView2 != null) {
            gifImageView2.clear();
        }
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
            this.player.release();
        }
    }

    public final void openFullscreenDialog() {
        this.imageViewLayoutParams = this.fullScreenIcon.getLayoutParams();
        this.playerViewLayoutParams = this.playerView.getLayoutParams();
        this.videoFramelayoutParams = this.videoFrameLayout.getLayoutParams();
        ((ViewGroup) this.playerView.getParent()).removeView(this.playerView);
        ((ViewGroup) this.fullScreenIcon.getParent()).removeView(this.fullScreenIcon);
        ((ViewGroup) this.videoFrameLayout.getParent()).removeView(this.videoFrameLayout);
        this.fullScreenDialog.addContentView(this.playerView, new LayoutParams(-1, -1));
        this.exoPlayerFullscreen = true;
        this.fullScreenDialog.show();
    }

    public final void playMedia() {
        this.playerView.requestFocus();
        this.playerView.setVisibility(0);
        this.playerView.setPlayer(this.player);
        this.player.setPlayWhenReady(true);
    }

    public final void prepareMedia() {
        FrameLayout frameLayout = (FrameLayout) this.relativeLayout.findViewById(R$id.video_frame);
        this.videoFrameLayout = frameLayout;
        frameLayout.setVisibility(0);
        this.playerView = new PlayerView(this.context);
        ImageView imageView = new ImageView(this.context);
        this.fullScreenIcon = imageView;
        imageView.setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R$drawable.ct_ic_fullscreen_expand, null));
        this.fullScreenIcon.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment = CTInAppNativeInterstitialFragment.this;
                if (!cTInAppNativeInterstitialFragment.exoPlayerFullscreen) {
                    cTInAppNativeInterstitialFragment.openFullscreenDialog();
                } else {
                    cTInAppNativeInterstitialFragment.closeFullscreenDialog();
                }
            }
        });
        if (!this.inAppNotification.isTablet || !isTablet()) {
            this.playerView.setLayoutParams(new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 240.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 134.0f, getResources().getDisplayMetrics())));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()));
            layoutParams.gravity = WearableExtender.DEFAULT_CONTENT_ICON_GRAVITY;
            layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()), 0);
            this.fullScreenIcon.setLayoutParams(layoutParams);
        } else {
            this.playerView.setLayoutParams(new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 408.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 229.0f, getResources().getDisplayMetrics())));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics()));
            layoutParams2.gravity = WearableExtender.DEFAULT_CONTENT_ICON_GRAVITY;
            layoutParams2.setMargins(0, (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()), 0);
            this.fullScreenIcon.setLayoutParams(layoutParams2);
        }
        this.playerView.setShowBuffering(1);
        this.playerView.setUseArtwork(true);
        this.playerView.setControllerAutoShow(false);
        this.videoFrameLayout.addView(this.playerView);
        this.videoFrameLayout.addView(this.fullScreenIcon);
        this.playerView.setDefaultArtwork(this.context.getResources().getDrawable(R$drawable.ct_audio, null));
        TransferListener build = new Builder(this.context).build();
        this.player = new SimpleExoPlayer.Builder(this.context).setTrackSelector(new DefaultTrackSelector(this.context, new Factory())).build();
        Context context = this.context;
        this.player.prepare(new HlsMediaSource.Factory(new DefaultDataSourceFactory(context, Util.getUserAgent(context, context.getApplicationContext().getPackageName()), build)).createMediaSource(Uri.parse(this.inAppNotification.mediaList.get(0).mediaUrl)));
        this.player.setRepeatMode(1);
        this.player.seekTo(mediaPosition);
    }
}
