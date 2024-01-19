package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JobServiceConnection implements ServiceConnection {
    public IRemoteJobService binder;
    public final IJobCallback callback;
    public final Context context;
    public final Map<JobInvocation, Boolean> jobStatuses = new HashMap();
    public boolean wasUnbound = false;

    public JobServiceConnection(IJobCallback iJobCallback, Context context2) {
        this.callback = iJobCallback;
        this.context = context2;
    }

    public static Bundle encodeJob(JobParameters jobParameters) {
        JobCoder jobCoder = GooglePlayReceiver.prefixedCoder;
        Bundle bundle = new Bundle();
        jobCoder.encode(jobParameters, bundle);
        return bundle;
    }

    public synchronized boolean isConnected() {
        return this.binder != null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r5 = r4.wasUnbound()     // Catch:{ all -> 0x0082 }
            if (r5 == 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            com.firebase.jobdispatcher.IRemoteJobService r5 = com.firebase.jobdispatcher.IRemoteJobService.Stub.asInterface(r6)     // Catch:{ all -> 0x0082 }
            r4.binder = r5     // Catch:{ all -> 0x0082 }
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x0082 }
            r5.<init>()     // Catch:{ all -> 0x0082 }
            java.util.Map<com.firebase.jobdispatcher.JobInvocation, java.lang.Boolean> r6 = r4.jobStatuses     // Catch:{ all -> 0x0082 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ all -> 0x0082 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0082 }
        L_0x001e:
            boolean r0 = r6.hasNext()     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x0068
            java.lang.Object r0 = r6.next()     // Catch:{ all -> 0x0082 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0082 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0082 }
            java.lang.Object r2 = r0.getValue()     // Catch:{ all -> 0x0082 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x001e
            com.firebase.jobdispatcher.IRemoteJobService r1 = r4.binder     // Catch:{ RemoteException -> 0x004f }
            java.lang.Object r2 = r0.getKey()     // Catch:{ RemoteException -> 0x004f }
            com.firebase.jobdispatcher.JobParameters r2 = (com.firebase.jobdispatcher.JobParameters) r2     // Catch:{ RemoteException -> 0x004f }
            android.os.Bundle r2 = encodeJob(r2)     // Catch:{ RemoteException -> 0x004f }
            com.firebase.jobdispatcher.IJobCallback r3 = r4.callback     // Catch:{ RemoteException -> 0x004f }
            r1.start(r2, r3)     // Catch:{ RemoteException -> 0x004f }
            java.lang.Object r1 = r0.getKey()     // Catch:{ RemoteException -> 0x004f }
            r5.add(r1)     // Catch:{ RemoteException -> 0x004f }
            goto L_0x001e
        L_0x004f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r5.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r6 = "Failed to start job "
            r5.append(r6)     // Catch:{ all -> 0x0082 }
            java.lang.Object r6 = r0.getKey()     // Catch:{ all -> 0x0082 }
            r5.append(r6)     // Catch:{ all -> 0x0082 }
            r5.toString()     // Catch:{ all -> 0x0082 }
            r4.unbind()     // Catch:{ all -> 0x0082 }
            monitor-exit(r4)
            return
        L_0x0068:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0082 }
        L_0x006c:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x0080
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0082 }
            com.firebase.jobdispatcher.JobInvocation r6 = (com.firebase.jobdispatcher.JobInvocation) r6     // Catch:{ all -> 0x0082 }
            java.util.Map<com.firebase.jobdispatcher.JobInvocation, java.lang.Boolean> r0 = r4.jobStatuses     // Catch:{ all -> 0x0082 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0082 }
            r0.put(r6, r1)     // Catch:{ all -> 0x0082 }
            goto L_0x006c
        L_0x0080:
            monitor-exit(r4)
            return
        L_0x0082:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.JobServiceConnection.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public synchronized void onServiceDisconnected(ComponentName componentName) {
        unbind();
    }

    public final void requestRetryForJob(JobInvocation jobInvocation) {
        try {
            this.callback.jobFinished(encodeJob(jobInvocation), 1);
        } catch (RemoteException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error sending result for job ");
            outline73.append(jobInvocation.tag);
            outline73.append(": ");
            outline73.append(e2);
            outline73.toString();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|(1:9)|10|11|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0040 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:12:0x0040=Splitter:B:12:0x0040, B:16:0x0055=Splitter:B:16:0x0055} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean startJob(com.firebase.jobdispatcher.JobInvocation r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.wasUnbound()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x000a
            r5.requestRetryForJob(r6)     // Catch:{ all -> 0x0060 }
        L_0x000a:
            boolean r0 = r5.isConnected()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0055
            java.util.Map<com.firebase.jobdispatcher.JobInvocation, java.lang.Boolean> r1 = r5.jobStatuses     // Catch:{ all -> 0x0060 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0060 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0060 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0060 }
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x0060 }
            r2 = 0
            if (r1 == 0) goto L_0x0034
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = "Received an execution request for already running job "
            r1.append(r3)     // Catch:{ all -> 0x0060 }
            r1.append(r6)     // Catch:{ all -> 0x0060 }
            r1.toString()     // Catch:{ all -> 0x0060 }
            r5.stopJob(r2, r6)     // Catch:{ all -> 0x0060 }
        L_0x0034:
            com.firebase.jobdispatcher.IRemoteJobService r1 = r5.binder     // Catch:{ RemoteException -> 0x0040 }
            android.os.Bundle r3 = encodeJob(r6)     // Catch:{ RemoteException -> 0x0040 }
            com.firebase.jobdispatcher.IJobCallback r4 = r5.callback     // Catch:{ RemoteException -> 0x0040 }
            r1.start(r3, r4)     // Catch:{ RemoteException -> 0x0040 }
            goto L_0x0055
        L_0x0040:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r0.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = "Failed to start the job "
            r0.append(r1)     // Catch:{ all -> 0x0060 }
            r0.append(r6)     // Catch:{ all -> 0x0060 }
            r0.toString()     // Catch:{ all -> 0x0060 }
            r5.unbind()     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return r2
        L_0x0055:
            java.util.Map<com.firebase.jobdispatcher.JobInvocation, java.lang.Boolean> r1 = r5.jobStatuses     // Catch:{ all -> 0x0060 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0060 }
            r1.put(r6, r2)     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return r0
        L_0x0060:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.JobServiceConnection.startJob(com.firebase.jobdispatcher.JobInvocation):boolean");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void stopJob(boolean r2, com.firebase.jobdispatcher.JobInvocation r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.firebase.jobdispatcher.IRemoteJobService r0 = r1.binder     // Catch:{ RemoteException -> 0x000d }
            android.os.Bundle r3 = encodeJob(r3)     // Catch:{ RemoteException -> 0x000d }
            r0.stop(r3, r2)     // Catch:{ RemoteException -> 0x000d }
            goto L_0x0010
        L_0x000b:
            r2 = move-exception
            goto L_0x0012
        L_0x000d:
            r1.unbind()     // Catch:{ all -> 0x000b }
        L_0x0010:
            monitor-exit(r1)
            return
        L_0x0012:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.JobServiceConnection.stopJob(boolean, com.firebase.jobdispatcher.JobInvocation):void");
    }

    public synchronized void unbind() {
        if (!wasUnbound()) {
            this.binder = null;
            this.wasUnbound = true;
            try {
                this.context.unbindService(this);
            } catch (IllegalArgumentException e2) {
                e2.getMessage();
            }
            ArrayList arrayList = new ArrayList(this.jobStatuses.size());
            Iterator<JobInvocation> it = this.jobStatuses.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
                it.remove();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                requestRetryForJob((JobInvocation) it2.next());
            }
        }
    }

    public synchronized boolean wasUnbound() {
        try {
        }
        return this.wasUnbound;
    }
}
