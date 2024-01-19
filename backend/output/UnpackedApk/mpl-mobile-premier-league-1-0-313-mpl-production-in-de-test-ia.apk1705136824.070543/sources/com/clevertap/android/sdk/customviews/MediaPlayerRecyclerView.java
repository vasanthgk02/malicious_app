package com.clevertap.android.sdk.customviews;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.clevertap.android.sdk.R$drawable;
import com.clevertap.android.sdk.inbox.CTInboxActivity;
import com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder;
import com.google.android.exoplayer2.Player.Listener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.SimpleExoPlayer.Builder;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import java.util.ArrayList;

public class MediaPlayerRecyclerView extends RecyclerView {
    public Context appContext;
    public SimpleExoPlayer player;
    public CTInboxBaseMessageViewHolder playingHolder;
    public PlayerView videoSurfaceView;

    public MediaPlayerRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
    }

    public final void initialize(Context context) {
        this.appContext = context.getApplicationContext();
        PlayerView playerView = new PlayerView(this.appContext);
        this.videoSurfaceView = playerView;
        playerView.setBackgroundColor(0);
        if (CTInboxActivity.orientation == 2) {
            this.videoSurfaceView.setResizeMode(3);
        } else {
            this.videoSurfaceView.setResizeMode(0);
        }
        this.videoSurfaceView.setUseArtwork(true);
        this.videoSurfaceView.setDefaultArtwork(ResourcesCompat.getDrawable(context.getResources(), R$drawable.ct_audio, null));
        SimpleExoPlayer build = new Builder(context).setTrackSelector(new DefaultTrackSelector(this.appContext, new Factory())).build();
        this.player = build;
        build.setVolume(0.0f);
        this.videoSurfaceView.setUseController(true);
        this.videoSurfaceView.setControllerAutoShow(false);
        this.videoSurfaceView.setPlayer(this.player);
        addOnScrollListener(new OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    MediaPlayerRecyclerView.this.playVideo();
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
        AnonymousClass2 r6 = new OnChildAttachStateChangeListener() {
            public void onChildViewAttachedToWindow(View view) {
            }

            public void onChildViewDetachedFromWindow(View view) {
                CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = MediaPlayerRecyclerView.this.playingHolder;
                if (cTInboxBaseMessageViewHolder != null && cTInboxBaseMessageViewHolder.itemView.equals(view)) {
                    MediaPlayerRecyclerView.this.stop();
                }
            }
        };
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(r6);
        this.player.addListener(new Listener() {
        });
    }

    public void onPausePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    public void playVideo() {
        if (this.videoSurfaceView != null) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = ((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition();
            CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = null;
            int i = 0;
            for (int i2 = findFirstVisibleItemPosition; i2 <= findLastVisibleItemPosition; i2++) {
                View childAt = getChildAt(i2 - findFirstVisibleItemPosition);
                if (childAt != null) {
                    CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder2 = (CTInboxBaseMessageViewHolder) childAt.getTag();
                    if (cTInboxBaseMessageViewHolder2 != null && cTInboxBaseMessageViewHolder2.requiresMediaPlayer) {
                        Rect rect = new Rect();
                        int height = cTInboxBaseMessageViewHolder2.itemView.getGlobalVisibleRect(rect) ? rect.height() : 0;
                        if (height > i) {
                            cTInboxBaseMessageViewHolder = cTInboxBaseMessageViewHolder2;
                            i = height;
                        }
                    }
                }
            }
            if (cTInboxBaseMessageViewHolder == null) {
                stop();
                removeVideoView();
                return;
            }
            CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder3 = this.playingHolder;
            if (cTInboxBaseMessageViewHolder3 == null || !cTInboxBaseMessageViewHolder3.itemView.equals(cTInboxBaseMessageViewHolder.itemView)) {
                removeVideoView();
                if (cTInboxBaseMessageViewHolder.addMediaPlayer(this.videoSurfaceView)) {
                    this.playingHolder = cTInboxBaseMessageViewHolder;
                }
                return;
            }
            Rect rect2 = new Rect();
            int height2 = this.playingHolder.itemView.getGlobalVisibleRect(rect2) ? rect2.height() : 0;
            if (this.player != null) {
                if (!(height2 >= 400)) {
                    this.player.setPlayWhenReady(false);
                } else if (this.playingHolder.firstContentItem.mediaIsVideo()) {
                    this.player.setPlayWhenReady(true);
                }
            }
        }
    }

    public void release() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
            this.player.release();
            this.player = null;
        }
        this.playingHolder = null;
        this.videoSurfaceView = null;
    }

    public final void removeVideoView() {
        PlayerView playerView = this.videoSurfaceView;
        if (playerView != null) {
            ViewGroup viewGroup = (ViewGroup) playerView.getParent();
            if (viewGroup != null) {
                int indexOfChild = viewGroup.indexOfChild(this.videoSurfaceView);
                if (indexOfChild >= 0) {
                    viewGroup.removeViewAt(indexOfChild);
                    SimpleExoPlayer simpleExoPlayer = this.player;
                    if (simpleExoPlayer != null) {
                        simpleExoPlayer.stop();
                    }
                    CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = this.playingHolder;
                    if (cTInboxBaseMessageViewHolder != null) {
                        FrameLayout frameLayout = cTInboxBaseMessageViewHolder.progressBarFrameLayout;
                        if (frameLayout != null) {
                            frameLayout.setVisibility(8);
                        }
                        ImageView imageView = cTInboxBaseMessageViewHolder.muteIcon;
                        if (imageView != null) {
                            imageView.setVisibility(8);
                        }
                        FrameLayout frameLayout2 = cTInboxBaseMessageViewHolder.frameLayout;
                        if (frameLayout2 != null) {
                            frameLayout2.removeAllViews();
                        }
                        this.playingHolder = null;
                    }
                }
            }
        }
    }

    public void stop() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
        }
        this.playingHolder = null;
    }

    public MediaPlayerRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context);
    }

    public MediaPlayerRecyclerView(Context context) {
        super(context, null);
        initialize(context);
    }
}
