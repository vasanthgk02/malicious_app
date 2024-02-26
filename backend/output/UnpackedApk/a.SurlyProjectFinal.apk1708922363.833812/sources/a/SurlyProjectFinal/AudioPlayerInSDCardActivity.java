package a.SurlyProjectFinal;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Audio.Media;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.cauly.android.ad.AdView;
import com.inmobi.androidsdk.impl.Constants;

public class AudioPlayerInSDCardActivity extends Activity implements Callback {
    private static final int HELLO_ID = 1;
    public static final String TAG = "MP3Log";
    Mp3ListAdapter Adapter = null;
    /* access modifiers changed from: private */
    public boolean PROGRESS_RUNNING = false;
    String Tag = "AudioPlayerInSDCardActivity";
    ImageView _imageView;
    public AdView adView;
    private TextView audioCurrentTime;
    /* access modifiers changed from: private */
    public TextView audioDurationTime;
    private boolean checkWidgetStop = false;
    private Handler exitHandler;
    /* access modifiers changed from: private */
    public boolean flag = false;
    public ImageView forwardButton;
    public LinearLayout highlayout;
    ListView list;
    PhoneStateListener mCallListener = new PhoneStateListener() {
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state) {
                case 0:
                    if ((AudioPlayerInSDCardActivity.this.previousStatus == 1 || AudioPlayerInSDCardActivity.this.previousStatus == 2) && AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer() != null) {
                        AudioPlayerInSDCardActivity.this.mPauseBtn.setBackgroundResource(R.drawable.player_pause_button_selector);
                        AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().start();
                        AudioPlayerInSDCardActivity.this.wasPlaying = true;
                    }
                    AudioPlayerInSDCardActivity.this.previousStatus = 0;
                    return;
                case 1:
                    if (AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer() != null && AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().isPlaying()) {
                        AudioPlayerInSDCardActivity.this.mPauseBtn.setBackgroundResource(R.drawable.player_play_button_selector);
                        AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().pause();
                        AudioPlayerInSDCardActivity.this.wasPlaying = false;
                    }
                    AudioPlayerInSDCardActivity.this.previousStatus = 1;
                    return;
                case 2:
                    if (AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer() != null && AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().isPlaying()) {
                        AudioPlayerInSDCardActivity.this.mPauseBtn.setBackgroundResource(R.drawable.player_play_button_selector);
                        AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().pause();
                        AudioPlayerInSDCardActivity.this.wasPlaying = false;
                    }
                    AudioPlayerInSDCardActivity.this.previousStatus = 2;
                    return;
                default:
                    if (AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer() != null) {
                        AudioPlayerInSDCardActivity.this.mPauseBtn.setBackgroundResource(R.drawable.player_pause_button_selector);
                        AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().start();
                        AudioPlayerInSDCardActivity.this.wasPlaying = true;
                        return;
                    }
                    return;
            }
        }
    };
    OnClickListener mClickForward = new OnClickListener() {
        public void onClick(View v) {
            AudioPlayerInSDCardActivity.this.musicManager.next();
            AudioPlayerInSDCardActivity.this.ScreenReset();
            AudioPlayerInSDCardActivity.this.randomBackground();
        }
    };
    OnClickListener mClickPlay = new OnClickListener() {
        public void onClick(View v) {
            if (!AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().isPlaying()) {
                AudioPlayerInSDCardActivity.this.mPlayBtn.setVisibility(4);
                AudioPlayerInSDCardActivity.this.mPlayBtn.setImageResource(R.drawable.player_play_button_selector);
                AudioPlayerInSDCardActivity.this.musicManager.setPlaying(MusicManager.PLAYING);
                AudioPlayerInSDCardActivity.this.musicManager.play();
                AudioPlayerInSDCardActivity.this.audioDurationTime.setText(musicPlayerApi.getAudioDuration((long) AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().getDuration()).toString());
                AudioPlayerInSDCardActivity.this.mPauseBtn.setVisibility(0);
                return;
            }
            AudioPlayerInSDCardActivity.this.mPauseBtn.setVisibility(4);
            AudioPlayerInSDCardActivity.this.mPauseBtn.setImageResource(R.drawable.player_pause_button_selector);
            AudioPlayerInSDCardActivity.this.musicManager.setPlaying(MusicManager.STOP);
            AudioPlayerInSDCardActivity.this.musicManager.pause();
            AudioPlayerInSDCardActivity.this.mPlayBtn.setVisibility(0);
        }
    };
    OnClickListener mClickRewind = new OnClickListener() {
        public void onClick(View v) {
            AudioPlayerInSDCardActivity.this.musicManager.prev();
            AudioPlayerInSDCardActivity.this.ScreenReset();
            AudioPlayerInSDCardActivity.this.randomBackground();
        }
    };
    OnCompletionListener mCompletion = new OnCompletionListener() {
        public void onCompletion(MediaPlayer mp) {
            Log.i("asdf", "completion");
            AudioPlayerInSDCardActivity.this.musicManager.next();
            AudioPlayerInSDCardActivity.this.ScreenReset();
            AudioPlayerInSDCardActivity.this.randomBackground();
        }
    };
    TextView mFileName;
    BroadcastReceiver mHeadsetReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("android.intent.action.HEADSET_PLUG")) {
                Log.v(AudioPlayerInSDCardActivity.this.Tag, "AudioPlayerInSDCardActivity intent.getIntExtra(state) : " + intent.getIntExtra("state", 0));
                Log.v(AudioPlayerInSDCardActivity.this.Tag, "AudioPlayerInSDCardActivity intent.getStringExtra(name) : " + intent.getStringExtra("name"));
                Log.v(AudioPlayerInSDCardActivity.this.Tag, "AudioPlayerInSDCardActivity intent.getIntExtra(microphone) : " + intent.getIntExtra("microphone", 0));
                if (intent.getIntExtra("state", 0) == 1) {
                    Toast.makeText(AudioPlayerInSDCardActivity.this, "earphone state : On", 1).show();
                } else {
                    Toast.makeText(AudioPlayerInSDCardActivity.this, "earphone state : Off", 1).show();
                }
            }
        }
    };
    private int[] mImageIds = {R.drawable.suli2, R.drawable.suli3, R.drawable.suli4, R.drawable.suli5, R.drawable.suli6, R.drawable.suli7, R.drawable.suli8, R.drawable.suli9, R.drawable.suli10, R.drawable.suli11, R.drawable.suli12, R.drawable.suli13, R.drawable.suli15, R.drawable.suli16, R.drawable.suli17, R.drawable.suli18, R.drawable.suli19, R.drawable.suli20, R.drawable.suli21, R.drawable.suli22};
    NotificationManager mNotificationManager;
    OnErrorListener mOnError = new OnErrorListener() {
        public boolean onError(MediaPlayer mp, int what, int extra) {
            Toast.makeText(AudioPlayerInSDCardActivity.this, "OnError occured. what = " + what + " ,extra = " + extra, 1).show();
            return false;
        }
    };
    OnPreparedListener mOnPrepared = new OnPreparedListener() {
        public void onPrepared(MediaPlayer mp) {
            AudioPlayerInSDCardActivity.this.PROGRESS_RUNNING = false;
            AudioPlayerInSDCardActivity.this.ScreenReset();
        }
    };
    OnSeekBarChangeListener mOnSeek = new OnSeekBarChangeListener() {
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            AudioPlayerInSDCardActivity.this.wasPlaying = AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().isPlaying();
            if (AudioPlayerInSDCardActivity.this.wasPlaying) {
                AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().pause();
            }
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().seekTo(progress);
                AudioPlayerInSDCardActivity.this.mProgress.setProgress(progress);
            }
        }
    };
    OnSeekCompleteListener mOnSeekComplete = new OnSeekCompleteListener() {
        public void onSeekComplete(MediaPlayer mp) {
            if (AudioPlayerInSDCardActivity.this.wasPlaying) {
                AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().start();
            }
        }
    };
    ImageView mPauseBtn;
    ImageView mPlayBtn;
    SeekBar mProgress;
    ProgressTask mProgressTask = null;
    TelephonyManager mTelManager;
    /* access modifiers changed from: private */
    public MusicManager musicManager = null;
    /* access modifiers changed from: private */
    public boolean musicState = false;
    Notification notification;
    int previousStatus = 0;
    AsyncTask<Void, Void, Void> readMediaFileTask = new AsyncTask<Void, Void, Void>() {
        Dialog dialog = null;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = musicPlayerApi.makeDialogForLoading(AudioPlayerInSDCardActivity.this);
            this.dialog.show();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            AudioPlayerInSDCardActivity.this.Adapter = new Mp3ListAdapter(AudioPlayerInSDCardActivity.this, AudioPlayerInSDCardActivity.this.musicManager.getMp3ModelArray());
            AudioPlayerInSDCardActivity.this.list.setAdapter(AudioPlayerInSDCardActivity.this.Adapter);
            AudioPlayerInSDCardActivity.this.musicManager.setPlayIdx(0);
            this.dialog.dismiss();
            if (AudioPlayerInSDCardActivity.this.musicState) {
                if (AudioPlayerInSDCardActivity.this.musicManager.getMediaPlayer().isPlaying()) {
                    AudioPlayerInSDCardActivity.this.mPlayBtn.setVisibility(4);
                    AudioPlayerInSDCardActivity.this.mPauseBtn.setVisibility(0);
                } else {
                    AudioPlayerInSDCardActivity.this.mPlayBtn.setVisibility(0);
                    AudioPlayerInSDCardActivity.this.mPauseBtn.setVisibility(4);
                }
                AudioPlayerInSDCardActivity.this.MusicState();
            }
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            AudioPlayerInSDCardActivity.this.musicManager.newMp3ModelArray();
            Cursor albumCursor = AudioPlayerInSDCardActivity.this.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"artist", "title", "_id", "_data"}, null, null, null);
            albumCursor.moveToFirst();
            int titleColumn = 0;
            int singerColumn = 0;
            int pathColumn = 0;
            try {
                titleColumn = albumCursor.getColumnIndex("title");
                singerColumn = albumCursor.getColumnIndex("artist");
                int albumId = albumCursor.getColumnIndex("_id");
                pathColumn = albumCursor.getColumnIndex("_data");
            } catch (Exception e) {
            }
            while (albumCursor.moveToNext()) {
                try {
                    Mp3Model mp3Model = new Mp3Model(albumCursor.getString(titleColumn), albumCursor.getString(singerColumn), albumCursor.getString(pathColumn), Constants.QA_SERVER_URL);
                    try {
                        AudioPlayerInSDCardActivity.this.musicManager.addUMp3ModelToArray(mp3Model);
                        Mp3Model mp3Model2 = mp3Model;
                    } catch (Exception e2) {
                        Mp3Model mp3Model3 = mp3Model;
                    }
                } catch (Exception e3) {
                }
            }
            return null;
        }
    };
    public ImageView rewindButton;
    boolean wasPlaying;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio);
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        if (this.musicManager == null) {
            this.musicManager = MusicManager.getMusicManager();
        }
        if (this.musicManager.getMediaPlayer() == null) {
            this.musicManager.newMediaPlayer();
        } else {
            this.musicState = true;
        }
        init();
        if (this.musicManager.getMp3ModelArray() == null) {
            this.readMediaFileTask.execute(new Void[0]);
        } else {
            this.Adapter = new Mp3ListAdapter(this, this.musicManager.getMp3ModelArray());
            this.list.setAdapter(this.Adapter);
            if (this.musicState) {
                if (this.musicManager.getMediaPlayer().isPlaying()) {
                    this.mPlayBtn.setVisibility(4);
                    this.mPauseBtn.setVisibility(0);
                    this.musicManager.getProgressTask().setProgressRunning(MusicManager.STOP);
                    this.musicManager.getHandler().sendEmptyMessageDelayed(0, 300);
                } else {
                    this.mPlayBtn.setVisibility(0);
                    this.mPauseBtn.setVisibility(4);
                }
                MusicState();
            }
        }
        callInit();
    }

    /* access modifiers changed from: private */
    public void MusicState() {
        this.audioCurrentTime.setText(musicPlayerApi.getAudioDuration((long) this.musicManager.getMediaPlayer().getCurrentPosition()));
        this.audioDurationTime.setText(musicPlayerApi.getAudioDuration((long) this.musicManager.getMediaPlayer().getDuration()));
        if (this.musicManager.getMp3ModelArray().size() > 0) {
            this.mFileName.setText(this.musicManager.getMp3ModelArray().get(this.musicManager.getPlayIdx()).getTitle());
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        unregisterReceiver(this.mHeadsetReceiver);
        noticeTitle();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        registerReceiver(this.mHeadsetReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        super.onResume();
    }

    private void noticeTitle() {
        this.notification = new Notification(R.drawable.audacity, "MusicPlayerInSDCard", System.currentTimeMillis());
        this.notification.setLatestEventInfo(getApplicationContext(), this.musicManager.getMp3ModelArray().get(this.musicManager.getPlayIdx()).getTitle(), this.musicManager.getMp3ModelArray().get(this.musicManager.getPlayIdx()).getSinger(), PendingIntent.getActivity(this, 0, new Intent(this, AudioPlayerInSDCardActivity.class), 0));
        this.mNotificationManager.notify(1, this.notification);
    }

    private void init() {
        this.mFileName = (TextView) findViewById(R.id.text);
        this.mPlayBtn = (ImageView) findViewById(R.id.audioPlayButton);
        this.mPauseBtn = (ImageView) findViewById(R.id.audioPlayPauseButton);
        this.audioCurrentTime = (TextView) findViewById(R.id.audioCurrentFrameTime);
        this.audioDurationTime = (TextView) findViewById(R.id.audioTotalDuration);
        findViewById(R.id.audioRewindButton).setOnClickListener(this.mClickRewind);
        findViewById(R.id.audioForwardButton).setOnClickListener(this.mClickForward);
        this.musicManager.getMediaPlayer().setOnCompletionListener(this.mCompletion);
        this.musicManager.getMediaPlayer().setOnSeekCompleteListener(this.mOnSeekComplete);
        this.musicManager.getMediaPlayer().setOnPreparedListener(this.mOnPrepared);
        this.mProgress = (SeekBar) findViewById(R.id.SeekBar);
        this.mProgress.setOnSeekBarChangeListener(this.mOnSeek);
        this.list = (ListView) findViewById(R.id.list);
        this.mPauseBtn.setOnClickListener(this.mClickPlay);
        this.mPlayBtn.setOnClickListener(this.mClickPlay);
        this.musicManager.setProgressAndTimeView(this.audioCurrentTime, this.mProgress);
        this.list.getBackground().setAlpha(153);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    public boolean getCheckWidgetStop() {
        return this.checkWidgetStop;
    }

    public void onDestroy() {
        super.onDestroy();
        this.musicManager.pause();
        if (this.musicManager.getMediaPlayer() != null) {
            this.musicManager.getMediaPlayer().release();
            this.musicManager.allRemoveMp3ModelArray();
            this.musicManager.setMp3ModelArray(null);
            this.musicManager.setMediaPlayer(null);
        }
    }

    public void callInit() {
        this.mTelManager = (TelephonyManager) getSystemService("phone");
        this.mTelManager.listen(this.mCallListener, 32);
    }

    /* access modifiers changed from: private */
    public void ScreenReset() {
        this.audioCurrentTime.setText("00:00");
        this.audioDurationTime.setText(musicPlayerApi.getAudioDuration((long) this.musicManager.getMediaPlayer().getDuration()));
        this.mFileName.setText(this.musicManager.getMp3ModelArray().get(this.musicManager.getPlayIdx()).getTitle());
    }

    /* access modifiers changed from: private */
    public void randomBackground() {
        findViewById(R.id.list).setBackgroundResource(this.mImageIds[((int) (Math.random() * 19.0d)) + 0]);
        this.list.getBackground().setAlpha(153);
    }

    public void onBackPressed() {
        this.exitHandler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 0) {
                    AudioPlayerInSDCardActivity.this.flag = false;
                }
            }
        };
        if (!this.flag) {
            Toast.makeText(this, "If you click one more back key, Application will be finished", 0).show();
            this.flag = true;
            this.mNotificationManager.cancel(1);
            this.exitHandler.sendEmptyMessageDelayed(0, 2000);
            this.checkWidgetStop = true;
            return;
        }
        this.mNotificationManager.cancel(getPackageName(), 1);
        super.onBackPressed();
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceCreated(SurfaceHolder holder) {
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
    }
}
