package com.twitter.sdk.android.tweetui.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.twitter.sdk.android.tweetui.R$drawable;
import com.twitter.sdk.android.tweetui.R$id;
import com.twitter.sdk.android.tweetui.R$layout;
import com.twitter.sdk.android.tweetui.R$string;
import com.twitter.sdk.android.tweetui.TweetUtils;
import org.apache.commons.net.ftp.FTPReply;

public class VideoControlView extends FrameLayout {
    public TextView currentTime;
    public TextView duration;
    @SuppressLint({"HandlerLeak"})
    public final Handler handler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1001) {
                VideoControlView videoControlView = VideoControlView.this;
                MediaPlayerControl mediaPlayerControl = videoControlView.player;
                if (mediaPlayerControl != null) {
                    int duration = mediaPlayerControl.getDuration();
                    int currentPosition = videoControlView.player.getCurrentPosition();
                    int bufferPercentage = videoControlView.player.getBufferPercentage();
                    videoControlView.setDuration(duration);
                    videoControlView.setCurrentTime(currentPosition);
                    videoControlView.setProgress(currentPosition, duration, bufferPercentage);
                    VideoControlView videoControlView2 = VideoControlView.this;
                    boolean z = false;
                    if (((VideoView) videoControlView2.player).isPlaying()) {
                        videoControlView2.stateControl.setImageResource(R$drawable.tw__video_pause_btn);
                        videoControlView2.stateControl.setContentDescription(videoControlView2.getContext().getString(R$string.tw__pause));
                    } else if (videoControlView2.player.getCurrentPosition() > Math.max(videoControlView2.player.getDuration() - 500, 0)) {
                        videoControlView2.stateControl.setImageResource(R$drawable.tw__video_replay_btn);
                        videoControlView2.stateControl.setContentDescription(videoControlView2.getContext().getString(R$string.tw__replay));
                    } else {
                        videoControlView2.stateControl.setImageResource(R$drawable.tw__video_play_btn);
                        videoControlView2.stateControl.setContentDescription(videoControlView2.getContext().getString(R$string.tw__play));
                    }
                    if (VideoControlView.this.getVisibility() == 0) {
                        z = true;
                    }
                    if (z && ((VideoView) VideoControlView.this.player).isPlaying()) {
                        sendMessageDelayed(obtainMessage(1001), 500);
                    }
                }
            }
        }
    };
    public MediaPlayerControl player;
    public SeekBar seekBar;
    public ImageButton stateControl;

    public interface MediaPlayerControl {
        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();
    }

    public VideoControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void hide() {
        this.handler.removeMessages(1001);
        if (getVisibility() == 0) {
            clearAnimation();
            animate().alpha(0.0f).setDuration((long) FTPReply.FILE_STATUS_OK).setListener(new AnimationUtils$1(this));
        }
    }

    public /* synthetic */ void lambda$createStateControlClickListener$0$VideoControlView(View view) {
        if (((VideoView) this.player).isPlaying()) {
            ((VideoView) this.player).pause();
        } else {
            ((VideoView) this.player).start();
        }
        show();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R$layout.tw__video_control, this);
        this.stateControl = (ImageButton) findViewById(R$id.tw__state_control);
        this.currentTime = (TextView) findViewById(R$id.tw__current_time);
        this.duration = (TextView) findViewById(R$id.tw__duration);
        SeekBar seekBar2 = (SeekBar) findViewById(R$id.tw__progress);
        this.seekBar = seekBar2;
        seekBar2.setMax(1000);
        this.seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    int duration = (int) (((long) (VideoControlView.this.player.getDuration() * i)) / 1000);
                    ((VideoView) VideoControlView.this.player).seekTo(duration);
                    VideoControlView.this.setCurrentTime(duration);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControlView.this.handler.removeMessages(1001);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControlView.this.handler.sendEmptyMessage(1001);
            }
        });
        this.stateControl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VideoControlView.this.lambda$createStateControlClickListener$0$VideoControlView(view);
            }
        });
        setDuration(0);
        setCurrentTime(0);
        setProgress(0, 0, 0);
    }

    public void setCurrentTime(int i) {
        this.currentTime.setText(TweetUtils.getPlaybackTime((long) i));
    }

    public void setDuration(int i) {
        this.duration.setText(TweetUtils.getPlaybackTime((long) i));
    }

    public void setMediaPlayer(MediaPlayerControl mediaPlayerControl) {
        this.player = mediaPlayerControl;
    }

    public void setProgress(int i, int i2, int i3) {
        this.seekBar.setProgress((int) (i2 > 0 ? (((long) i) * 1000) / ((long) i2) : 0));
        this.seekBar.setSecondaryProgress(i3 * 10);
    }

    public void show() {
        this.handler.sendEmptyMessage(1001);
        if (getVisibility() != 0) {
            setAlpha(0.0f);
            setVisibility(0);
        }
        clearAnimation();
        animate().alpha(1.0f).setDuration((long) FTPReply.FILE_STATUS_OK).setListener(null);
    }

    public VideoControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
