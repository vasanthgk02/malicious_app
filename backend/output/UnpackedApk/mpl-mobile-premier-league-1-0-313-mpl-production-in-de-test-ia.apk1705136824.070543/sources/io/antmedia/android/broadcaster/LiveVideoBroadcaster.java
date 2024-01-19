package io.antmedia.android.broadcaster;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Intent;
import android.media.AudioRecord;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.HandlerThread;
import android.os.IBinder;
import android.view.SurfaceView;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.antmedia.android.broadcaster.encoder.AudioHandler;
import io.antmedia.android.broadcaster.encoder.VideoHandler;
import io.antmedia.android.broadcaster.network.IMediaMuxer;
import io.antmedia.android.broadcaster.network.RTMPStreamer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class LiveVideoBroadcaster extends Service implements ILiveVideoBroadcaster {
    public static final String DESCRIPTION = "description";
    public static final String ERROR = "error";
    public static final String INFO = "INFO";
    public static final String METADATA = "metadata";
    public static final String OK = "OK";
    public static final int PERMISSIONS_REQUEST = 8954;
    public static final String STATUS = "status";
    public static final String STREAMING_STARTED = "StreamingStarted";
    public static final String STREAMING_STOPPED = "StreamingStopped";
    public static final String TAG = LiveVideoBroadcaster.class.getSimpleName();
    public static final String TIMESTAMP = "Timestamp";
    public static final String URL = "RtmpUrl";
    public static final String VIDEO_LENGTH_MS = "VideoLengthMS";
    public static LiveVideoBroadcaster _instance;
    public AudioHandler audioHandler;
    public HandlerThread audioHandlerThread;
    public boolean connectedOnce = false;
    public Timer connectionCheckerTimer;
    public ConnectivityManager connectivityManager;
    public Activity context;
    public boolean isRecording = false;
    public AlertDialog mAlertDialog;
    public final IBinder mBinder = new LocalBinder();
    public HandlerThread mRtmpHandlerThread;
    public IMediaMuxer mRtmpStreamer;
    public int mSentFrameCount = 0;
    public String methodName = null;
    public String objectName = null;
    public VideoHandler videoHandler;

    public interface EncoderListener {
        void inputNotValid();
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public ILiveVideoBroadcaster getService() {
            return LiveVideoBroadcaster.this;
        }
    }

    public interface StreamingStatusListener {
        void streamingStartStatus(boolean z, String str);

        void streamingStopped(JSONObject jSONObject);
    }

    public static LiveVideoBroadcaster getInstance() {
        return _instance;
    }

    public static void startService(Activity activity) {
        activity.startService(new Intent(activity, LiveVideoBroadcaster.class));
    }

    public SurfaceView getSurfaceView(Activity activity) {
        try {
            int i = 0;
            Object invoke = activity.getClass().getMethod("getMainUnityPlayer", new Class[0]).invoke(activity, new Object[0]);
            String str = null;
            if (invoke == null) {
                return null;
            }
            Field[] declaredFields = invoke.getClass().getDeclaredFields();
            int length = declaredFields.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                Field field = declaredFields[i];
                field.getName();
                field.getType().getSimpleName();
                if ("SurfaceView".equals(field.getType().getSimpleName())) {
                    str = field.getName();
                    break;
                }
                i++;
            }
            Field declaredField = invoke.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return (SurfaceView) declaredField.get(invoke);
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e2) {
            e2.printStackTrace();
            return getSurfaceViewDirectlyFromUnityPlayer(activity);
        }
    }

    public SurfaceView getSurfaceViewDirectlyFromUnityPlayer(Activity activity) {
        String str;
        Field[] declaredFields = activity.getClass().getDeclaredFields();
        int i = 0;
        for (int i2 = 0; i2 < declaredFields.length; i2++) {
            declaredFields[i2].getName();
            declaredFields[i2].getType().getSimpleName();
        }
        try {
            Field declaredField = activity.getClass().getDeclaredField("mUnityPlayer");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Field[] declaredFields2 = obj.getClass().getDeclaredFields();
            while (true) {
                if (i >= declaredFields2.length) {
                    str = null;
                    break;
                }
                declaredFields2[i].getName();
                declaredFields2[i].getType().getSimpleName();
                if ("SurfaceView".equals(declaredFields2[i].getType().getSimpleName())) {
                    str = declaredFields2[i].getName();
                    break;
                }
                i++;
            }
            Field declaredField2 = obj.getClass().getDeclaredField(str);
            declaredField2.setAccessible(true);
            return (SurfaceView) declaredField2.get(obj);
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean hasConnection() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void init(Activity activity) {
        try {
            if (this.audioHandlerThread != null) {
                this.audioHandlerThread.quitSafely();
                this.audioHandlerThread = null;
            }
            HandlerThread handlerThread = new HandlerThread("AudioHandlerThread", -16);
            this.audioHandlerThread = handlerThread;
            handlerThread.start();
            this.audioHandler = new AudioHandler(this.audioHandlerThread.getLooper());
            this.context = activity;
            if (this.mRtmpHandlerThread != null) {
                this.mRtmpHandlerThread.quitSafely();
                this.mRtmpHandlerThread = null;
            }
            HandlerThread handlerThread2 = new HandlerThread("RtmpStreamerThread");
            this.mRtmpHandlerThread = handlerThread2;
            handlerThread2.start();
            this.mRtmpStreamer = new RTMPStreamer(this.mRtmpHandlerThread.getLooper(), new StreamingStatusListener() {
                public void streamingStartStatus(boolean z, String str) {
                    if (z) {
                        LiveVideoBroadcaster liveVideoBroadcaster = LiveVideoBroadcaster.this;
                        liveVideoBroadcaster.sendStatusMessage(LiveVideoBroadcaster.OK, "RTMP is connected for " + str);
                        LiveVideoBroadcaster.this.connectedOnce = true;
                        LiveVideoBroadcaster.TAG;
                        LiveVideoBroadcaster.this.mRtmpStreamer.getFrameCountInQueue();
                        return;
                    }
                    LiveVideoBroadcaster liveVideoBroadcaster2 = LiveVideoBroadcaster.this;
                    liveVideoBroadcaster2.sendStatusMessage("error", "Cannot connect to the RTMP URL: " + str);
                    LiveVideoBroadcaster.TAG;
                    LiveVideoBroadcaster.this.mRtmpStreamer.getFrameCountInQueue();
                }

                public void streamingStopped(JSONObject jSONObject) {
                    LiveVideoBroadcaster.this.sendStatusMessage(LiveVideoBroadcaster.INFO, LiveVideoBroadcaster.STREAMING_STOPPED, jSONObject);
                }
            });
            this.connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean isConnected() {
        IMediaMuxer iMediaMuxer = this.mRtmpStreamer;
        if (iMediaMuxer != null) {
            return iMediaMuxer.isConnected();
        }
        return false;
    }

    public boolean isRecording() {
        return this.isRecording;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void onDestroy() {
        HandlerThread handlerThread = this.audioHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.audioHandlerThread = null;
        }
        HandlerThread handlerThread2 = this.mRtmpHandlerThread;
        if (handlerThread2 != null) {
            handlerThread2.quitSafely();
            this.mRtmpHandlerThread = null;
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        _instance = this;
        return super.onStartCommand(intent, i, i2);
    }

    public void pause() {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.mAlertDialog.dismiss();
        }
        stopBroadcasting();
    }

    public void recordAudio(float[] fArr, int i) {
        AudioHandler audioHandler2 = this.audioHandler;
        if (audioHandler2 != null) {
            audioHandler2.recordAudio(fArr, i);
        }
    }

    public void registerStatusListener(String str, String str2) {
        this.objectName = str;
        this.methodName = str2;
    }

    public void sendStatusMessage(String str, String str2) {
        sendStatusMessage(str, str2, null);
    }

    public boolean startBroadcasting(String str, int i, int i2, int i3, Activity activity) {
        return startBroadcasting(str, i, i2, i3, activity, 0, 0);
    }

    public void stopBroadcasting() {
        if (this.isRecording) {
            Timer timer = this.connectionCheckerTimer;
            if (timer != null) {
                timer.cancel();
                this.connectionCheckerTimer = null;
            }
            AudioHandler audioHandler2 = this.audioHandler;
            if (audioHandler2 != null) {
                audioHandler2.sendEmptyMessage(2);
            }
            this.videoHandler.stopEncoder();
            this.isRecording = false;
            this.connectedOnce = false;
            this.mSentFrameCount = 0;
        }
    }

    public void sendStatusMessage(String str, String str2, JSONObject jSONObject) {
        Class<String> cls = String.class;
        if (this.objectName != null && this.methodName != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", str);
                jSONObject2.put("description", str2);
                if (jSONObject != null) {
                    jSONObject2.put(METADATA, jSONObject);
                }
                Class.forName("com.unity3d.player.UnityPlayer").getDeclaredMethod("UnitySendMessage", new Class[]{cls, cls, cls}).invoke(null, new Object[]{this.objectName, this.methodName, jSONObject2.toString()});
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
    }

    public boolean startBroadcasting(String str, int i, int i2, int i3, Activity activity, int i4, int i5) {
        Activity activity2 = activity;
        int i6 = i4;
        int i7 = i5;
        init(activity2);
        this.isRecording = false;
        boolean hasConnection = hasConnection();
        Timer timer = new Timer();
        this.connectionCheckerTimer = timer;
        final String str2 = str;
        timer.schedule(new TimerTask() {
            public void run() {
                if (!LiveVideoBroadcaster.this.hasConnection()) {
                    LiveVideoBroadcaster.TAG;
                    LiveVideoBroadcaster.this.mRtmpStreamer.getFrameCountInQueue();
                    LiveVideoBroadcaster.this.sendStatusMessage("error", "There is not network connection");
                } else if (!LiveVideoBroadcaster.this.isConnected()) {
                    if (LiveVideoBroadcaster.this.connectedOnce) {
                        LiveVideoBroadcaster liveVideoBroadcaster = LiveVideoBroadcaster.this;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("RTMP is disconnected for ");
                        outline73.append(str2);
                        liveVideoBroadcaster.sendStatusMessage("error", outline73.toString());
                    }
                    LiveVideoBroadcaster.this.mRtmpStreamer.open(str2);
                } else {
                    LiveVideoBroadcaster.TAG;
                    LiveVideoBroadcaster.this.mRtmpStreamer.getFrameCountInQueue();
                    int sendFrameCount = LiveVideoBroadcaster.this.mRtmpStreamer.getSendFrameCount();
                    if (sendFrameCount > LiveVideoBroadcaster.this.mSentFrameCount) {
                        LiveVideoBroadcaster liveVideoBroadcaster2 = LiveVideoBroadcaster.this;
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("RTMP is connected and sending stream to ");
                        outline732.append(str2);
                        liveVideoBroadcaster2.sendStatusMessage(LiveVideoBroadcaster.OK, outline732.toString());
                    } else {
                        LiveVideoBroadcaster liveVideoBroadcaster3 = LiveVideoBroadcaster.this;
                        StringBuilder outline733 = GeneratedOutlineSupport.outline73("Cannot sending frames. It may be because encoder is not working properly or there is a problem in audio and video capturing/synch to the rtmpUrl: ");
                        outline733.append(str2);
                        outline733.append(" audio frame count in queue ");
                        outline733.append(LiveVideoBroadcaster.this.mRtmpStreamer.getAudioFrameCountInQueue());
                        outline733.append(" video frame count in queue: ");
                        outline733.append(LiveVideoBroadcaster.this.mRtmpStreamer.getVideoFrameCountInQueue());
                        liveVideoBroadcaster3.sendStatusMessage("error", outline733.toString());
                    }
                    LiveVideoBroadcaster.this.mSentFrameCount = sendFrameCount;
                }
            }
        }, 0, 1000);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.videoHandler = new VideoHandler(new EncoderListener() {
                public void inputNotValid() {
                    LiveVideoBroadcaster.this.stopBroadcasting();
                }
            });
            SurfaceView surfaceView = getSurfaceView(activity2);
            if (surfaceView == null) {
                return false;
            }
            int width = (surfaceView.getWidth() * i3) / surfaceView.getHeight();
            if (width % 2 == 1) {
                width++;
            }
            this.videoHandler.prepareEncoder(width, i3, i, i2, this.mRtmpStreamer);
            this.videoHandler.setRecordStartTime(currentTimeMillis);
            this.videoHandler.setInputSurfaceView(surfaceView);
            if (i6 == 0 || i7 == 0) {
                this.mRtmpStreamer.setAudioEnable(false);
            } else {
                int minBufferSize = AudioRecord.getMinBufferSize(i6, i7, 2);
                this.audioHandler.setRecordStartTime(currentTimeMillis);
                this.audioHandler.startAudioEncoder(this.mRtmpStreamer, i6, minBufferSize, i7);
            }
            this.videoHandler.setName("Video Handler Thread");
            this.videoHandler.start();
            this.isRecording = true;
            sendStatusMessage(INFO, STREAMING_STARTED);
            return this.isRecording;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
