package a.SurlyProjectFinal;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;

public class MusicManager {
    public static boolean PLAYING = true;
    public static boolean STOP = false;
    private static MusicManager musicManager = new MusicManager();
    TextView audioCurrentTime = null;
    AudioPlayerInSDCardActivity audioPlayerActivity = new AudioPlayerInSDCardActivity();
    private boolean isPlaying = false;
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                MusicManager.this.mProgressTask = new ProgressTask(MusicManager.this.mProgress, MusicManager.this.audioCurrentTime);
                MusicManager.this.mProgressTask.execute(new Void[0]);
            }
        }
    };
    private ArrayList<Mp3Model> mMp3ModelArray = null;
    private int mPlayIdx = 0;
    private MediaPlayer mPlayer = null;
    SeekBar mProgress = null;
    ProgressTask mProgressTask = null;
    private boolean pause = false;

    public void setProgressAndTimeView(TextView audioCurrentTime2, SeekBar mProgress2) {
        this.audioCurrentTime = audioCurrentTime2;
        this.mProgress = mProgress2;
        this.mProgressTask = new ProgressTask(mProgress2, audioCurrentTime2);
    }

    public ProgressTask getProgressTask() {
        return this.mProgressTask;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public static MusicManager getMusicManager() {
        if (musicManager == null) {
            musicManager = new MusicManager();
        }
        return musicManager;
    }

    public void newMediaPlayer() {
        this.mPlayer = new MediaPlayer();
    }

    public void setMediaPlayer(MediaPlayer mplayer) {
        this.mPlayer = mplayer;
    }

    public MediaPlayer getMediaPlayer() {
        return this.mPlayer;
    }

    public void newMp3ModelArray() {
        this.mMp3ModelArray = new ArrayList<>();
    }

    public void addUMp3ModelToArray(Mp3Model addMp3ModelArray) {
        this.mMp3ModelArray.add(addMp3ModelArray);
    }

    public void allRemoveMp3ModelArray() {
        this.mMp3ModelArray.removeAll(this.mMp3ModelArray);
    }

    public ArrayList<Mp3Model> getMp3ModelArray() {
        return this.mMp3ModelArray;
    }

    public void setMp3ModelArray(ArrayList<Mp3Model> setMp3ArrayList) {
        this.mMp3ModelArray = setMp3ArrayList;
    }

    public int getPlayIdx() {
        return this.mPlayIdx;
    }

    public void setPlayIdx(int idx) {
        this.mPlayIdx = idx;
    }

    public void selectPlay(int position) {
        this.mPlayer.reset();
        Log.i("fimtrus", "pos : " + position + "path : " + this.mMp3ModelArray.get(position).getFilePath());
        this.mPlayIdx = position;
        play();
    }

    public void play() {
        try {
            if (!this.pause) {
                this.mPlayer.reset();
                this.mPlayer.setDataSource(this.mMp3ModelArray.get(this.mPlayIdx).getFilePath());
                this.mPlayer.prepare();
            } else if (!this.audioPlayerActivity.getCheckWidgetStop()) {
                this.mPlayer.reset();
                this.mPlayer.setDataSource(this.mMp3ModelArray.get(this.mPlayIdx).getFilePath());
                this.mPlayer.prepare();
                this.mPlayer.start();
            } else {
                this.pause = false;
            }
            if (this.isPlaying) {
                this.mPlayer.start();
                this.mProgressTask.setProgressRunning(STOP);
                this.mHandler.sendEmptyMessageDelayed(0, 300);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void pause() {
        this.mPlayer.pause();
        this.pause = true;
        this.mProgressTask.setProgressRunning(STOP);
    }

    public void next() {
        if (this.mMp3ModelArray.size() - 1 == this.mPlayIdx) {
            this.mPlayIdx = 0;
        } else {
            this.mPlayIdx++;
        }
        play();
    }

    public void prev() {
        if (this.mPlayIdx == 0) {
            this.mPlayIdx = this.mMp3ModelArray.size() - 1;
        } else {
            this.mPlayIdx--;
        }
        play();
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlaying(boolean run) {
        this.isPlaying = run;
    }
}
