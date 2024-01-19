package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.firebase.jobdispatcher.IJobCallback.Stub;
import com.firebase.jobdispatcher.JobInvocation.Builder;

public class ExecutionDelegator {
    public static final SimpleArrayMap<String, JobServiceConnection> serviceConnections = new SimpleArrayMap<>();
    public final ConstraintChecker constraintChecker;
    public final Context context;
    public final IJobCallback execCallback = new Stub() {
        public void jobFinished(Bundle bundle, int i) {
            JobServiceConnection jobServiceConnection;
            Builder decode = GooglePlayReceiver.prefixedCoder.decode(bundle);
            if (decode == null) {
                Log.wtf("FJD.ExternalReceiver", "jobFinished: unknown invocation provided");
                return;
            }
            ExecutionDelegator executionDelegator = ExecutionDelegator.this;
            JobInvocation build = decode.build();
            if (executionDelegator != null) {
                synchronized (ExecutionDelegator.serviceConnections) {
                    jobServiceConnection = (JobServiceConnection) ExecutionDelegator.serviceConnections.get(build.service);
                }
                if (jobServiceConnection != null) {
                    synchronized (jobServiceConnection) {
                        jobServiceConnection.jobStatuses.remove(build);
                        if (jobServiceConnection.jobStatuses.isEmpty()) {
                            jobServiceConnection.unbind();
                        }
                    }
                    if (jobServiceConnection.wasUnbound()) {
                        synchronized (ExecutionDelegator.serviceConnections) {
                            ExecutionDelegator.serviceConnections.remove(build.service);
                        }
                    }
                }
                ((GooglePlayReceiver) executionDelegator.jobFinishedCallback).onJobFinished(build, i);
                return;
            }
            throw null;
        }
    };
    public final JobFinishedCallback jobFinishedCallback;

    public interface JobFinishedCallback {
    }

    public ExecutionDelegator(Context context2, JobFinishedCallback jobFinishedCallback2, ConstraintChecker constraintChecker2) {
        this.context = context2;
        this.jobFinishedCallback = jobFinishedCallback2;
        this.constraintChecker = constraintChecker2;
    }

    public static void stopJob(JobInvocation jobInvocation, boolean z) {
        JobServiceConnection jobServiceConnection;
        synchronized (serviceConnections) {
            jobServiceConnection = (JobServiceConnection) serviceConnections.get(jobInvocation.service);
        }
        if (jobServiceConnection != null) {
            synchronized (jobServiceConnection) {
                if (!jobServiceConnection.wasUnbound()) {
                    if (Boolean.TRUE.equals(jobServiceConnection.jobStatuses.remove(jobInvocation)) && jobServiceConnection.isConnected()) {
                        jobServiceConnection.stopJob(z, jobInvocation);
                    }
                    if (!z && jobServiceConnection.jobStatuses.isEmpty()) {
                        jobServiceConnection.unbind();
                    }
                }
            }
            if (jobServiceConnection.wasUnbound()) {
                synchronized (serviceConnections) {
                    serviceConnections.remove(jobInvocation.service);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
        if ((!r0.isActiveNetworkMetered()) == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00be, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeJob(com.firebase.jobdispatcher.JobInvocation r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            com.firebase.jobdispatcher.ConstraintChecker r0 = r5.constraintChecker
            if (r0 == 0) goto L_0x00c2
            int[] r1 = r6.constraints
            int r1 = com.firebase.jobdispatcher.Constraint.compact(r1)
            r2 = r1 & 2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0015
            r2 = 1
            goto L_0x0016
        L_0x0015:
            r2 = 0
        L_0x0016:
            if (r2 != 0) goto L_0x0024
            r2 = r1 & 1
            if (r2 == 0) goto L_0x001e
            r2 = 1
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            if (r2 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r2 = 0
            goto L_0x0025
        L_0x0024:
            r2 = 1
        L_0x0025:
            if (r2 != 0) goto L_0x0028
            goto L_0x0050
        L_0x0028:
            android.content.Context r0 = r0.context
            java.lang.String r2 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r2 = r0.getActiveNetworkInfo()
            if (r2 != 0) goto L_0x003a
            r2 = 0
            goto L_0x003e
        L_0x003a:
            boolean r2 = r2.isConnected()
        L_0x003e:
            if (r2 != 0) goto L_0x0041
            goto L_0x0051
        L_0x0041:
            r1 = r1 & r4
            if (r1 == 0) goto L_0x0046
            r1 = 1
            goto L_0x0047
        L_0x0046:
            r1 = 0
        L_0x0047:
            if (r1 == 0) goto L_0x0050
            boolean r0 = r0.isActiveNetworkMetered()
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x0051
        L_0x0050:
            r3 = 1
        L_0x0051:
            r0 = 3
            if (r3 != 0) goto L_0x0074
            java.lang.String r1 = "FJD.ExternalReceiver"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L_0x006c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Not executing job because constraints still unmet. Job: "
            r0.append(r1)
            r0.append(r6)
            r0.toString()
        L_0x006c:
            com.firebase.jobdispatcher.ExecutionDelegator$JobFinishedCallback r0 = r5.jobFinishedCallback
            com.firebase.jobdispatcher.GooglePlayReceiver r0 = (com.firebase.jobdispatcher.GooglePlayReceiver) r0
            r0.onJobFinished(r6, r4)
            return
        L_0x0074:
            java.lang.String r1 = "FJD.ExternalReceiver"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L_0x008c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Proceeding to execute job because constraints met. Job: "
            r0.append(r1)
            r0.append(r6)
            r0.toString()
        L_0x008c:
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobServiceConnection> r0 = serviceConnections
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobServiceConnection> r1 = serviceConnections     // Catch:{ all -> 0x00bf }
            java.lang.String r2 = r6.service     // Catch:{ all -> 0x00bf }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00bf }
            com.firebase.jobdispatcher.JobServiceConnection r1 = (com.firebase.jobdispatcher.JobServiceConnection) r1     // Catch:{ all -> 0x00bf }
            if (r1 == 0) goto L_0x00a0
            r1.startJob(r6)     // Catch:{ all -> 0x00bf }
            monitor-exit(r0)     // Catch:{ all -> 0x00bf }
            return
        L_0x00a0:
            com.firebase.jobdispatcher.JobServiceConnection r1 = new com.firebase.jobdispatcher.JobServiceConnection     // Catch:{ all -> 0x00bf }
            com.firebase.jobdispatcher.IJobCallback r2 = r5.execCallback     // Catch:{ all -> 0x00bf }
            android.content.Context r3 = r5.context     // Catch:{ all -> 0x00bf }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x00bf }
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobServiceConnection> r2 = serviceConnections     // Catch:{ all -> 0x00bf }
            java.lang.String r3 = r6.service     // Catch:{ all -> 0x00bf }
            r2.put(r3, r1)     // Catch:{ all -> 0x00bf }
            r1.startJob(r6)     // Catch:{ all -> 0x00bf }
            boolean r6 = r5.tryBindingToJobService(r6, r1)     // Catch:{ all -> 0x00bf }
            if (r6 == 0) goto L_0x00ba
            goto L_0x00bd
        L_0x00ba:
            r1.unbind()     // Catch:{ all -> 0x00bf }
        L_0x00bd:
            monitor-exit(r0)     // Catch:{ all -> 0x00bf }
            return
        L_0x00bf:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bf }
            throw r6
        L_0x00c2:
            r6 = 0
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.ExecutionDelegator.executeJob(com.firebase.jobdispatcher.JobInvocation):void");
    }

    public final boolean tryBindingToJobService(JobInvocation jobInvocation, JobServiceConnection jobServiceConnection) {
        try {
            return this.context.bindService(new Intent(JobService.ACTION_EXECUTE).setClassName(this.context, jobInvocation.service), jobServiceConnection, 1);
        } catch (SecurityException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to bind to ");
            outline73.append(jobInvocation.service);
            outline73.append(": ");
            outline73.append(e2);
            outline73.toString();
            return false;
        }
    }
}
