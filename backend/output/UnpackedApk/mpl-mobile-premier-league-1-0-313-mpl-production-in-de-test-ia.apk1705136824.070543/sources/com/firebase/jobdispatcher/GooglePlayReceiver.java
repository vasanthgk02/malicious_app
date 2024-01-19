package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import androidx.collection.SimpleArrayMap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.firebase.jobdispatcher.ExecutionDelegator.JobFinishedCallback;
import com.firebase.jobdispatcher.Job.Builder;
import com.firebase.jobdispatcher.JobTrigger.ContentUriTrigger;
import com.firebase.jobdispatcher.JobTrigger.ExecutionWindowTrigger;
import com.firebase.jobdispatcher.ValidationEnforcer.ValidationException;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.List;

public class GooglePlayReceiver extends Service implements JobFinishedCallback {
    public static final SimpleArrayMap<String, SimpleArrayMap<String, JobCallback>> callbacks = new SimpleArrayMap<>(1);
    public static final JobCoder prefixedCoder = new JobCoder("com.firebase.jobdispatcher.");
    public final GooglePlayCallbackExtractor callbackExtractor = new GooglePlayCallbackExtractor();
    public GooglePlayDriver driver;
    public ExecutionDelegator executionDelegator;
    public int latestStartId;
    public Messenger serviceMessenger;
    public ValidationEnforcer validationEnforcer;

    public synchronized ExecutionDelegator getExecutionDelegator() {
        if (this.executionDelegator == null) {
            this.executionDelegator = new ExecutionDelegator(this, this, new ConstraintChecker(getApplicationContext()));
        }
        return this.executionDelegator;
    }

    public final synchronized GooglePlayDriver getGooglePlayDriver() {
        if (this.driver == null) {
            this.driver = new GooglePlayDriver(getApplicationContext());
        }
        return this.driver;
    }

    public IBinder onBind(Intent intent) {
        Messenger messenger;
        if (intent == null || !"com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) {
            return null;
        }
        synchronized (this) {
            if (this.serviceMessenger == null) {
                this.serviceMessenger = new Messenger(new GooglePlayMessageHandler(Looper.getMainLooper(), this));
            }
            messenger = this.serviceMessenger;
        }
        return messenger.getBinder();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (callbacks.isEmpty() == false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        stopSelf(r4.latestStartId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        r5 = callbacks;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0039, code lost:
        if (callbacks.isEmpty() == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        stopSelf(r4.latestStartId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0040, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0056, code lost:
        if (r5.recurring == false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005c, code lost:
        if ((r5.trigger instanceof com.firebase.jobdispatcher.JobTrigger.ContentUriTrigger) == false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005e, code lost:
        if (r6 == 1) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0061, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0062, code lost:
        if (r1 == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0064, code lost:
        reschedule(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0068, code lost:
        android.util.Log.isLoggable("FJD.GooglePlayReceiver", 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r2.jobFinished(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        r5 = callbacks;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        monitor-enter(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onJobFinished(com.firebase.jobdispatcher.JobInvocation r5, int r6) {
        /*
            r4 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r0 = callbacks     // Catch:{ all -> 0x008e }
            monitor-enter(r0)     // Catch:{ all -> 0x008e }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r1 = callbacks     // Catch:{ all -> 0x008b }
            java.lang.String r2 = r5.service     // Catch:{ all -> 0x008b }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x008b }
            androidx.collection.SimpleArrayMap r1 = (androidx.collection.SimpleArrayMap) r1     // Catch:{ all -> 0x008b }
            if (r1 != 0) goto L_0x0025
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r5 = callbacks
            monitor-enter(r5)
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r6 = callbacks     // Catch:{ all -> 0x0022 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0022 }
            if (r6 == 0) goto L_0x0020
            int r6 = r4.latestStartId     // Catch:{ all -> 0x0022 }
            r4.stopSelf(r6)     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r5)     // Catch:{ all -> 0x0022 }
            return
        L_0x0022:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0022 }
            throw r6
        L_0x0025:
            java.lang.String r2 = r5.tag     // Catch:{ all -> 0x008b }
            java.lang.Object r2 = r1.remove(r2)     // Catch:{ all -> 0x008b }
            com.firebase.jobdispatcher.JobCallback r2 = (com.firebase.jobdispatcher.JobCallback) r2     // Catch:{ all -> 0x008b }
            if (r2 != 0) goto L_0x0045
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r5 = callbacks
            monitor-enter(r5)
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r6 = callbacks     // Catch:{ all -> 0x0042 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r6 == 0) goto L_0x0040
            int r6 = r4.latestStartId     // Catch:{ all -> 0x0042 }
            r4.stopSelf(r6)     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r5)     // Catch:{ all -> 0x0042 }
            return
        L_0x0042:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0042 }
            throw r6
        L_0x0045:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0052
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r1 = callbacks     // Catch:{ all -> 0x008b }
            java.lang.String r3 = r5.service     // Catch:{ all -> 0x008b }
            r1.remove(r3)     // Catch:{ all -> 0x008b }
        L_0x0052:
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            boolean r0 = r5.recurring     // Catch:{ all -> 0x008e }
            r1 = 1
            if (r0 == 0) goto L_0x0061
            com.firebase.jobdispatcher.JobTrigger r0 = r5.trigger     // Catch:{ all -> 0x008e }
            boolean r0 = r0 instanceof com.firebase.jobdispatcher.JobTrigger.ContentUriTrigger     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0061
            if (r6 == r1) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            if (r1 == 0) goto L_0x0068
            r4.reschedule(r5)     // Catch:{ all -> 0x008e }
            goto L_0x0076
        L_0x0068:
            java.lang.String r5 = "FJD.GooglePlayReceiver"
            r0 = 2
            android.util.Log.isLoggable(r5, r0)     // Catch:{ all -> 0x008e }
            r2.jobFinished(r6)     // Catch:{ all -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r5 = move-exception
            r5.getMessage()     // Catch:{ all -> 0x008e }
        L_0x0076:
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r5 = callbacks
            monitor-enter(r5)
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r6 = callbacks     // Catch:{ all -> 0x0088 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0088 }
            if (r6 == 0) goto L_0x0086
            int r6 = r4.latestStartId     // Catch:{ all -> 0x0088 }
            r4.stopSelf(r6)     // Catch:{ all -> 0x0088 }
        L_0x0086:
            monitor-exit(r5)     // Catch:{ all -> 0x0088 }
            return
        L_0x0088:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0088 }
            throw r6
        L_0x008b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r5     // Catch:{ all -> 0x008e }
        L_0x008e:
            r5 = move-exception
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r6 = callbacks
            monitor-enter(r6)
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r0 = callbacks     // Catch:{ all -> 0x00a1 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x009f
            int r0 = r4.latestStartId     // Catch:{ all -> 0x00a1 }
            r4.stopSelf(r0)     // Catch:{ all -> 0x00a1 }
        L_0x009f:
            monitor-exit(r6)     // Catch:{ all -> 0x00a1 }
            throw r5
        L_0x00a1:
            r5 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00a1 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayReceiver.onJobFinished(com.firebase.jobdispatcher.JobInvocation, int):void");
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            super.onStartCommand(intent, i, i2);
            if (intent == null) {
                synchronized (callbacks) {
                    this.latestStartId = i2;
                    if (callbacks.isEmpty()) {
                        stopSelf(this.latestStartId);
                    }
                }
                return 2;
            }
            String action = intent.getAction();
            if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                getExecutionDelegator().executeJob(prepareJob(intent));
                synchronized (callbacks) {
                    this.latestStartId = i2;
                    if (callbacks.isEmpty()) {
                        stopSelf(this.latestStartId);
                    }
                }
                return 2;
            } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action)) {
                synchronized (callbacks) {
                    this.latestStartId = i2;
                    if (callbacks.isEmpty()) {
                        stopSelf(this.latestStartId);
                    }
                }
                return 2;
            } else {
                synchronized (callbacks) {
                    this.latestStartId = i2;
                    if (callbacks.isEmpty()) {
                        stopSelf(this.latestStartId);
                    }
                }
                return 2;
            }
        } catch (Throwable th) {
            synchronized (callbacks) {
                this.latestStartId = i2;
                if (callbacks.isEmpty()) {
                    stopSelf(this.latestStartId);
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.firebase.jobdispatcher.JobInvocation prepareJob(android.content.Intent r9) {
        /*
            r8 = this;
            android.os.Bundle r9 = r9.getExtras()
            r0 = 0
            if (r9 != 0) goto L_0x0008
            return r0
        L_0x0008:
            com.firebase.jobdispatcher.GooglePlayCallbackExtractor r1 = r8.callbackExtractor
            if (r1 == 0) goto L_0x00d4
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            android.os.Parcel r2 = android.os.Parcel.obtain()
            r3 = 0
            r9.writeToParcel(r2, r3)
            r2.setDataPosition(r3)
            int r9 = r2.readInt()     // Catch:{ all -> 0x00cf }
            if (r9 > 0) goto L_0x0024
            goto L_0x00b6
        L_0x0024:
            int r9 = r2.readInt()     // Catch:{ all -> 0x00cf }
            r4 = 1279544898(0x4c444e42, float:5.146036E7)
            if (r9 == r4) goto L_0x002f
            goto L_0x00b6
        L_0x002f:
            int r9 = r2.readInt()     // Catch:{ all -> 0x00cf }
            r4 = r0
        L_0x0034:
            if (r3 >= r9) goto L_0x00b4
            java.lang.String r5 = com.firebase.jobdispatcher.GooglePlayCallbackExtractor.readKey(r2)     // Catch:{ all -> 0x00cf }
            if (r5 != 0) goto L_0x003e
            goto L_0x00b1
        L_0x003e:
            if (r4 != 0) goto L_0x006a
            java.lang.String r6 = "callback"
            boolean r6 = r6.equals(r5)     // Catch:{ all -> 0x00cf }
            if (r6 != 0) goto L_0x0049
            goto L_0x006a
        L_0x0049:
            int r4 = r2.readInt()     // Catch:{ all -> 0x00cf }
            r5 = 4
            if (r4 == r5) goto L_0x0052
            goto L_0x00b6
        L_0x0052:
            java.lang.String r4 = r2.readString()     // Catch:{ all -> 0x00cf }
            java.lang.String r5 = "com.google.android.gms.gcm.PendingCallback"
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x00cf }
            if (r4 != 0) goto L_0x005f
            goto L_0x00b6
        L_0x005f:
            android.os.IBinder r4 = r2.readStrongBinder()     // Catch:{ all -> 0x00cf }
            com.firebase.jobdispatcher.GooglePlayJobCallback r5 = new com.firebase.jobdispatcher.GooglePlayJobCallback     // Catch:{ all -> 0x00cf }
            r5.<init>(r4)     // Catch:{ all -> 0x00cf }
            r4 = r5
            goto L_0x00b1
        L_0x006a:
            java.lang.Object r6 = r2.readValue(r0)     // Catch:{ all -> 0x00cf }
            boolean r7 = r6 instanceof java.lang.String     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x0078
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00cf }
            r1.putString(r5, r6)     // Catch:{ all -> 0x00cf }
            goto L_0x00b1
        L_0x0078:
            boolean r7 = r6 instanceof java.lang.Boolean     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x0086
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x00cf }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x00cf }
            r1.putBoolean(r5, r6)     // Catch:{ all -> 0x00cf }
            goto L_0x00b1
        L_0x0086:
            boolean r7 = r6 instanceof java.lang.Integer     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x0094
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x00cf }
            int r6 = r6.intValue()     // Catch:{ all -> 0x00cf }
            r1.putInt(r5, r6)     // Catch:{ all -> 0x00cf }
            goto L_0x00b1
        L_0x0094:
            boolean r7 = r6 instanceof java.util.ArrayList     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x009e
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x00cf }
            r1.putParcelableArrayList(r5, r6)     // Catch:{ all -> 0x00cf }
            goto L_0x00b1
        L_0x009e:
            boolean r7 = r6 instanceof android.os.Bundle     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x00a8
            android.os.Bundle r6 = (android.os.Bundle) r6     // Catch:{ all -> 0x00cf }
            r1.putBundle(r5, r6)     // Catch:{ all -> 0x00cf }
            goto L_0x00b1
        L_0x00a8:
            boolean r7 = r6 instanceof android.os.Parcelable     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x00b1
            android.os.Parcelable r6 = (android.os.Parcelable) r6     // Catch:{ all -> 0x00cf }
            r1.putParcelable(r5, r6)     // Catch:{ all -> 0x00cf }
        L_0x00b1:
            int r3 = r3 + 1
            goto L_0x0034
        L_0x00b4:
            if (r4 != 0) goto L_0x00b8
        L_0x00b6:
            r9 = r0
            goto L_0x00bc
        L_0x00b8:
            android.util.Pair r9 = android.util.Pair.create(r4, r1)     // Catch:{ all -> 0x00cf }
        L_0x00bc:
            r2.recycle()
            if (r9 != 0) goto L_0x00c2
            return r0
        L_0x00c2:
            java.lang.Object r0 = r9.first
            com.firebase.jobdispatcher.JobCallback r0 = (com.firebase.jobdispatcher.JobCallback) r0
            java.lang.Object r9 = r9.second
            android.os.Bundle r9 = (android.os.Bundle) r9
            com.firebase.jobdispatcher.JobInvocation r9 = r8.prepareJob(r0, r9)
            return r9
        L_0x00cf:
            r9 = move-exception
            r2.recycle()
            throw r9
        L_0x00d4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayReceiver.prepareJob(android.content.Intent):com.firebase.jobdispatcher.JobInvocation");
    }

    public final void reschedule(JobInvocation jobInvocation) {
        ValidationEnforcer validationEnforcer2;
        synchronized (this) {
            if (this.validationEnforcer == null) {
                this.validationEnforcer = new ValidationEnforcer(getGooglePlayDriver().validator);
            }
            validationEnforcer2 = this.validationEnforcer;
        }
        Builder builder = new Builder(validationEnforcer2, jobInvocation);
        int i = 1;
        builder.replaceCurrent = true;
        List<String> validate = builder.validator.validator.validate(builder);
        if (validate == null) {
            Job job = new Job(builder, null);
            GooglePlayDriver googlePlayDriver = getGooglePlayDriver();
            if (googlePlayDriver != null) {
                synchronized (callbacks) {
                    SimpleArrayMap simpleArrayMap = (SimpleArrayMap) callbacks.get(job.service);
                    if (simpleArrayMap != null) {
                        if (((JobCallback) simpleArrayMap.get(job.tag)) != null) {
                            JobInvocation.Builder builder2 = new JobInvocation.Builder();
                            builder2.tag = job.tag;
                            builder2.service = job.service;
                            builder2.trigger = job.trigger;
                            ExecutionDelegator.stopJob(builder2.build(), false);
                        }
                    }
                }
                Context context = googlePlayDriver.context;
                Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
                intent.setPackage("com.google.android.gms");
                intent.putExtra("scheduler_action", "SCHEDULE_TASK");
                intent.putExtra("app", googlePlayDriver.token);
                intent.putExtra(DefaultSettingsSpiCall.SOURCE_PARAM, 8);
                intent.putExtra("source_version", 1);
                GooglePlayJobWriter googlePlayJobWriter = googlePlayDriver.writer;
                Bundle extras = intent.getExtras();
                if (googlePlayJobWriter != null) {
                    extras.putString(InlineAnimation.TAG, job.tag);
                    extras.putBoolean("update_current", job.replaceCurrent);
                    extras.putBoolean("persisted", job.lifetime == 2);
                    extras.putString("service", GooglePlayReceiver.class.getName());
                    JobTrigger jobTrigger = job.trigger;
                    if (jobTrigger == Trigger.NOW) {
                        extras.putInt("trigger_type", 2);
                        extras.putLong("window_start", 0);
                        extras.putLong("window_end", 1);
                    } else if (jobTrigger instanceof ExecutionWindowTrigger) {
                        ExecutionWindowTrigger executionWindowTrigger = (ExecutionWindowTrigger) jobTrigger;
                        extras.putInt("trigger_type", 1);
                        if (job.recurring) {
                            extras.putLong("period", (long) executionWindowTrigger.windowEnd);
                            extras.putLong("period_flex", (long) (executionWindowTrigger.windowEnd - executionWindowTrigger.windowStart));
                        } else {
                            extras.putLong("window_start", (long) executionWindowTrigger.windowStart);
                            extras.putLong("window_end", (long) executionWindowTrigger.windowEnd);
                        }
                    } else if (jobTrigger instanceof ContentUriTrigger) {
                        ContentUriTrigger contentUriTrigger = (ContentUriTrigger) jobTrigger;
                        extras.putInt("trigger_type", 3);
                        int size = contentUriTrigger.uris.size();
                        int[] iArr = new int[size];
                        Uri[] uriArr = new Uri[size];
                        for (int i2 = 0; i2 < size; i2++) {
                            ObservedUri observedUri = contentUriTrigger.uris.get(i2);
                            iArr[i2] = observedUri.flags;
                            uriArr[i2] = observedUri.uri;
                        }
                        extras.putIntArray("content_uri_flags_array", iArr);
                        extras.putParcelableArray("content_uri_array", uriArr);
                    } else {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown trigger: ");
                        outline73.append(jobTrigger.getClass());
                        throw new IllegalArgumentException(outline73.toString());
                    }
                    int compact = Constraint.compact(job.constraints);
                    extras.putBoolean("requiresCharging", (compact & 4) == 4);
                    extras.putBoolean("requiresIdle", (compact & 8) == 8);
                    int i3 = (compact & 2) == 2 ? 0 : 2;
                    if ((compact & 1) == 1) {
                        i3 = 1;
                    }
                    extras.putInt("requiredNetwork", i3);
                    RetryStrategy retryStrategy = job.retryStrategy;
                    Bundle bundle = new Bundle();
                    if (retryStrategy.policy != 2) {
                        i = 0;
                    }
                    bundle.putInt("retry_policy", i);
                    bundle.putInt("initial_backoff_seconds", retryStrategy.initialBackoff);
                    bundle.putInt("maximum_backoff_seconds", retryStrategy.maximumBackoff);
                    extras.putBundle("retryStrategy", bundle);
                    Bundle bundle2 = job.extras;
                    if (bundle2 == null) {
                        bundle2 = new Bundle();
                    }
                    googlePlayJobWriter.jobCoder.encode(job, bundle2);
                    extras.putBundle("extras", bundle2);
                    intent.putExtras(extras);
                    context.sendBroadcast(intent);
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw new ValidationException("JobParameters is invalid", validate);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.firebase.jobdispatcher.JobInvocation prepareJob(com.firebase.jobdispatcher.JobCallback r5, android.os.Bundle r6) {
        /*
            r4 = this;
            com.firebase.jobdispatcher.JobCoder r0 = prefixedCoder
            r1 = 0
            if (r6 != 0) goto L_0x0006
            goto L_0x000e
        L_0x0006:
            java.lang.String r2 = "extras"
            android.os.Bundle r2 = r6.getBundle(r2)
            if (r2 != 0) goto L_0x0010
        L_0x000e:
            r6 = r1
            goto L_0x0027
        L_0x0010:
            com.firebase.jobdispatcher.JobInvocation$Builder r0 = r0.decode(r2)
            java.lang.String r2 = "triggered_uris"
            java.util.ArrayList r6 = r6.getParcelableArrayList(r2)
            if (r6 == 0) goto L_0x0023
            com.firebase.jobdispatcher.TriggerReason r2 = new com.firebase.jobdispatcher.TriggerReason
            r2.<init>(r6)
            r0.triggerReason = r2
        L_0x0023:
            com.firebase.jobdispatcher.JobInvocation r6 = r0.build()
        L_0x0027:
            if (r6 != 0) goto L_0x0033
            r6 = 2
            r5.jobFinished(r6)     // Catch:{ all -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r5 = move-exception
            r5.getMessage()
        L_0x0032:
            return r1
        L_0x0033:
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r0 = callbacks
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r1 = callbacks     // Catch:{ all -> 0x0056 }
            java.lang.String r2 = r6.service     // Catch:{ all -> 0x0056 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0056 }
            androidx.collection.SimpleArrayMap r1 = (androidx.collection.SimpleArrayMap) r1     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x004f
            androidx.collection.SimpleArrayMap r1 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x0056 }
            r2 = 1
            r1.<init>(r2)     // Catch:{ all -> 0x0056 }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r2 = callbacks     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = r6.service     // Catch:{ all -> 0x0056 }
            r2.put(r3, r1)     // Catch:{ all -> 0x0056 }
        L_0x004f:
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x0056 }
            r1.put(r2, r5)     // Catch:{ all -> 0x0056 }
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return r6
        L_0x0056:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayReceiver.prepareJob(com.firebase.jobdispatcher.JobCallback, android.os.Bundle):com.firebase.jobdispatcher.JobInvocation");
    }
}
