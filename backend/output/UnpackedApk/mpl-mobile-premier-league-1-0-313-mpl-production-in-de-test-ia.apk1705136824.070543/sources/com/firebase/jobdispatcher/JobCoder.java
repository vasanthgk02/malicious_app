package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.firebase.jobdispatcher.JobInvocation.Builder;
import com.firebase.jobdispatcher.JobTrigger.ContentUriTrigger;
import com.firebase.jobdispatcher.JobTrigger.ExecutionWindowTrigger;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JobCoder {
    public final String prefix;

    public JobCoder(String str) {
        this.prefix = str;
    }

    public Builder decode(Bundle bundle) {
        JobTrigger jobTrigger;
        RetryStrategy retryStrategy;
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            Bundle bundle3 = new Bundle(bundle2);
            boolean z = bundle3.getBoolean(this.prefix + "recurring");
            boolean z2 = bundle3.getBoolean(this.prefix + "replace_current");
            int i = bundle3.getInt(this.prefix + "persistent");
            int i2 = bundle3.getInt(this.prefix + "constraints");
            int[] iArr = Constraint.ALL_CONSTRAINTS;
            int length = iArr.length;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i3 >= length) {
                    break;
                }
                int i6 = iArr[i3];
                if ((i2 & i6) != i6) {
                    i5 = 0;
                }
                i4 += i5;
                i3++;
            }
            int[] iArr2 = new int[i4];
            int i7 = 0;
            for (int i8 : Constraint.ALL_CONSTRAINTS) {
                if ((i2 & i8) == i8) {
                    iArr2[i7] = i8;
                    i7++;
                }
            }
            int i9 = bundle3.getInt(this.prefix + "trigger_type");
            if (i9 == 1) {
                int i10 = bundle3.getInt(this.prefix + "window_start");
                int i11 = bundle3.getInt(this.prefix + "window_end");
                if (i10 < 0) {
                    throw new IllegalArgumentException("Window start can't be less than 0");
                } else if (i11 >= i10) {
                    jobTrigger = new ExecutionWindowTrigger(i10, i11);
                } else {
                    throw new IllegalArgumentException("Window end can't be less than window start");
                }
            } else if (i9 == 2) {
                jobTrigger = Trigger.NOW;
            } else if (i9 != 3) {
                Log.isLoggable("FJD.ExternalReceiver", 3);
                jobTrigger = null;
            } else {
                String string = bundle3.getString(this.prefix + "observed_uris");
                ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    JSONArray jSONArray = jSONObject.getJSONArray("uri_flags");
                    JSONArray jSONArray2 = jSONObject.getJSONArray("uris");
                    int length2 = jSONArray.length();
                    for (int i12 = 0; i12 < length2; i12++) {
                        arrayList.add(new ObservedUri(Uri.parse(jSONArray2.getString(i12)), jSONArray.getInt(i12)));
                    }
                    List unmodifiableList = Collections.unmodifiableList(arrayList);
                    if (unmodifiableList == null || unmodifiableList.isEmpty()) {
                        throw new IllegalArgumentException("Uris must not be null or empty.");
                    }
                    jobTrigger = new ContentUriTrigger(unmodifiableList);
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                }
            }
            int i13 = bundle3.getInt(this.prefix + "retry_policy");
            if (i13 == 1 || i13 == 2) {
                retryStrategy = new RetryStrategy(i13, bundle3.getInt(this.prefix + "initial_backoff_seconds"), bundle3.getInt(this.prefix + "maximum_backoff_seconds"));
            } else {
                retryStrategy = RetryStrategy.DEFAULT_EXPONENTIAL;
            }
            String string2 = bundle3.getString(this.prefix + InlineAnimation.TAG);
            String string3 = bundle3.getString(this.prefix + "service");
            if (string2 == null || string3 == null || jobTrigger == null) {
                return null;
            }
            Builder builder = new Builder();
            builder.tag = string2;
            builder.service = string3;
            builder.trigger = jobTrigger;
            builder.retryStrategy = retryStrategy;
            builder.recurring = z;
            builder.lifetime = i;
            builder.constraints = iArr2;
            builder.replaceCurrent = z2;
            if (!TextUtils.isEmpty(this.prefix)) {
                Iterator it = bundle3.keySet().iterator();
                while (it.hasNext()) {
                    if (((String) it.next()).startsWith(this.prefix)) {
                        it.remove();
                    }
                }
            }
            builder.extras.putAll(bundle3);
            return builder;
        }
        throw new IllegalArgumentException("Unexpected null Bundle provided");
    }

    public Bundle encode(JobParameters jobParameters, Bundle bundle) {
        Bundle extras = jobParameters.getExtras();
        if (extras != null) {
            bundle.putAll(extras);
        }
        bundle.putInt(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, "persistent"), jobParameters.getLifetime());
        bundle.putBoolean(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, "recurring"), jobParameters.isRecurring());
        bundle.putBoolean(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, "replace_current"), jobParameters.shouldReplaceCurrent());
        bundle.putString(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, InlineAnimation.TAG), jobParameters.getTag());
        bundle.putString(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, "service"), jobParameters.getService());
        bundle.putInt(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, "constraints"), Constraint.compact(jobParameters.getConstraints()));
        JobTrigger trigger = jobParameters.getTrigger();
        if (trigger == Trigger.NOW) {
            bundle.putInt(this.prefix + "trigger_type", 2);
        } else if (trigger instanceof ExecutionWindowTrigger) {
            ExecutionWindowTrigger executionWindowTrigger = (ExecutionWindowTrigger) trigger;
            bundle.putInt(this.prefix + "trigger_type", 1);
            bundle.putInt(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, "window_start"), executionWindowTrigger.windowStart);
            bundle.putInt(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, "window_end"), executionWindowTrigger.windowEnd);
        } else if (trigger instanceof ContentUriTrigger) {
            bundle.putInt(this.prefix + "trigger_type", 3);
            List<ObservedUri> list = ((ContentUriTrigger) trigger).uris;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (ObservedUri next : list) {
                jSONArray.put(next.flags);
                jSONArray2.put(next.uri);
            }
            try {
                jSONObject.put("uri_flags", jSONArray);
                jSONObject.put("uris", jSONArray2);
                String jSONObject2 = jSONObject.toString();
                bundle.putString(this.prefix + "observed_uris", jSONObject2);
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            throw new IllegalArgumentException("Unsupported trigger.");
        }
        RetryStrategy retryStrategy = jobParameters.getRetryStrategy();
        if (retryStrategy == null) {
            retryStrategy = RetryStrategy.DEFAULT_EXPONENTIAL;
        }
        bundle.putInt(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, "retry_policy"), retryStrategy.policy);
        bundle.putInt(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, "initial_backoff_seconds"), retryStrategy.initialBackoff);
        bundle.putInt(GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, "maximum_backoff_seconds"), retryStrategy.maximumBackoff);
        return bundle;
    }
}
