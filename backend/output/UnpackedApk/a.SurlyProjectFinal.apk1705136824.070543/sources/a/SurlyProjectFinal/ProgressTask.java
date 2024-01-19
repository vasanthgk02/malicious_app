package a.SurlyProjectFinal;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

class ProgressTask extends AsyncTask<Void, Integer, String> {
    private boolean PROGRESS_RUNNING;
    TextView audioCurrentTime;
    int currentSecond;
    SeekBar mProgress;
    MediaPlayer mp;
    int oldSecond;
    int time;

    public ProgressTask(SeekBar mProgress2, TextView audioCurrentTime2) {
        this.oldSecond = 0;
        this.currentSecond = 0;
        this.time = 0;
        this.mProgress = null;
        this.mp = null;
        this.audioCurrentTime = null;
        this.PROGRESS_RUNNING = false;
        this.mp = MusicManager.getMusicManager().getMediaPlayer();
        this.mProgress = mProgress2;
        this.audioCurrentTime = audioCurrentTime2;
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        Log.i("fimtrus", "!!!!!!!!!!!!!!!");
        super.onCancelled();
        this.PROGRESS_RUNNING = false;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        Log.i("fimtrus", "onPre");
        this.PROGRESS_RUNNING = true;
        this.mProgress.setProgress(this.mp.getCurrentPosition());
        this.mProgress.setMax(this.mp.getDuration());
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... params) {
        while (this.PROGRESS_RUNNING) {
            try {
                this.time = this.mp.getCurrentPosition();
                publishProgress(new Integer[]{Integer.valueOf(this.time)});
            } catch (Exception e) {
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String result) {
        this.PROGRESS_RUNNING = false;
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... time2) {
        this.mProgress.setProgress(time2[0].intValue());
        this.currentSecond = time2[0].intValue() / 1000;
        if (this.currentSecond > this.oldSecond) {
            this.audioCurrentTime.setText(musicPlayerApi.getAudioDuration((long) time2[0].intValue()));
            this.oldSecond = this.currentSecond;
        }
    }

    public boolean isProgressRunning() {
        return this.PROGRESS_RUNNING;
    }

    public void setProgressRunning(boolean pROGRESS_RUNNING) {
        this.PROGRESS_RUNNING = pROGRESS_RUNNING;
    }
}
