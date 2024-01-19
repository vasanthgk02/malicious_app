package com.twitter.sdk.android.tweetui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.resources.TextAppearanceConfig;
import com.twitter.sdk.android.tweetui.PlayerActivity.PlayerItem;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.Callback;
import com.twitter.sdk.android.tweetui.internal.VideoControlView;
import com.twitter.sdk.android.tweetui.internal.VideoView;

public class PlayerController {
    public final TextView callToActionView;
    public final Callback callback;
    public boolean isPlaying = true;
    public final View rootView;
    public int seekPosition;
    public final VideoControlView videoControlView;
    public final ProgressBar videoProgressView;
    public final VideoView videoView;

    public PlayerController(View view, Callback callback2) {
        this.rootView = view;
        this.videoView = (VideoView) view.findViewById(R$id.video_view);
        this.videoControlView = (VideoControlView) view.findViewById(R$id.video_control_view);
        this.videoProgressView = (ProgressBar) view.findViewById(R$id.video_progress_view);
        this.callToActionView = (TextView) view.findViewById(R$id.call_to_action_view);
        this.callback = callback2;
    }

    public /* synthetic */ void lambda$prepare$0$PlayerController(MediaPlayer mediaPlayer) {
        this.videoProgressView.setVisibility(8);
    }

    public /* synthetic */ boolean lambda$prepare$1$PlayerController(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 702) {
            this.videoProgressView.setVisibility(8);
            return true;
        } else if (i != 701) {
            return false;
        } else {
            this.videoProgressView.setVisibility(0);
            return true;
        }
    }

    public /* synthetic */ void lambda$setUpCallToActionListener$3$PlayerController(String str, View view) {
        TextAppearanceConfig.safeStartActivity(this.callToActionView.getContext(), new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public /* synthetic */ void lambda$setUpLoopControl$2$PlayerController(View view) {
        if (this.videoView.isPlaying()) {
            this.videoView.pause();
        } else {
            this.videoView.start();
        }
    }

    public /* synthetic */ void lambda$setUpRootViewOnClickListener$4$PlayerController(View view) {
        if (this.callToActionView.getVisibility() == 0) {
            this.callToActionView.setVisibility(8);
        } else {
            this.callToActionView.setVisibility(0);
        }
    }

    public void setUpCallToAction(PlayerItem playerItem) {
        if (playerItem.callToActionText != null && playerItem.callToActionUrl != null) {
            this.callToActionView.setVisibility(0);
            this.callToActionView.setText(playerItem.callToActionText);
            this.callToActionView.setOnClickListener(new OnClickListener(playerItem.callToActionUrl) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PlayerController.this.lambda$setUpCallToActionListener$3$PlayerController(this.f$1, view);
                }
            });
            this.rootView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    PlayerController.this.lambda$setUpRootViewOnClickListener$4$PlayerController(view);
                }
            });
        }
    }
}
