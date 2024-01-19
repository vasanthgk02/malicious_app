package com.google.firebase.abt;

import android.text.TextUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import com.google.firebase.inject.Provider;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FirebaseABTesting {
    public final Provider<AnalyticsConnector> analyticsConnector;
    public Integer maxUserProperties = null;
    public final String originService;

    public FirebaseABTesting(Provider provider, String str) {
        this.analyticsConnector = provider;
        this.originService = str;
    }

    public final List<ConditionalUserProperty> getAllExperimentsInAnalytics() {
        return ((AnalyticsConnector) this.analyticsConnector.get()).getConditionalUserProperties(this.originService, "");
    }

    public final void removeExperiments(Collection<ConditionalUserProperty> collection) {
        for (ConditionalUserProperty conditionalUserProperty : collection) {
            ((AnalyticsConnector) this.analyticsConnector.get()).clearConditionalUserProperty(conditionalUserProperty.name, null, null);
        }
    }

    public void replaceAllExperiments(List<Map<String, String>> list) throws AbtException {
        String str;
        if (this.analyticsConnector.get() != null) {
            ArrayList arrayList = new ArrayList();
            for (Map<String, String> fromMap : list) {
                arrayList.add(AbtExperimentInfo.fromMap(fromMap));
            }
            if (!arrayList.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    hashSet.add(((AbtExperimentInfo) it.next()).experimentId);
                }
                List<ConditionalUserProperty> allExperimentsInAnalytics = getAllExperimentsInAnalytics();
                HashSet hashSet2 = new HashSet();
                for (ConditionalUserProperty conditionalUserProperty : allExperimentsInAnalytics) {
                    hashSet2.add(conditionalUserProperty.name);
                }
                ArrayList arrayList2 = new ArrayList();
                for (ConditionalUserProperty next : allExperimentsInAnalytics) {
                    if (!hashSet.contains(next.name)) {
                        arrayList2.add(next);
                    }
                }
                removeExperiments(arrayList2);
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    AbtExperimentInfo abtExperimentInfo = (AbtExperimentInfo) it2.next();
                    if (!hashSet2.contains(abtExperimentInfo.experimentId)) {
                        arrayList3.add(abtExperimentInfo);
                    }
                }
                ArrayDeque arrayDeque = new ArrayDeque(getAllExperimentsInAnalytics());
                if (this.maxUserProperties == null) {
                    this.maxUserProperties = Integer.valueOf(((AnalyticsConnector) this.analyticsConnector.get()).getMaxUserProperties(this.originService));
                }
                int intValue = this.maxUserProperties.intValue();
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    AbtExperimentInfo abtExperimentInfo2 = (AbtExperimentInfo) it3.next();
                    while (true) {
                        str = null;
                        if (arrayDeque.size() < intValue) {
                            break;
                        }
                        ((AnalyticsConnector) this.analyticsConnector.get()).clearConditionalUserProperty(((ConditionalUserProperty) arrayDeque.pollFirst()).name, null, null);
                    }
                    String str2 = this.originService;
                    if (abtExperimentInfo2 != null) {
                        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty();
                        conditionalUserProperty2.origin = str2;
                        conditionalUserProperty2.creationTimestamp = abtExperimentInfo2.experimentStartTime.getTime();
                        conditionalUserProperty2.name = abtExperimentInfo2.experimentId;
                        conditionalUserProperty2.value = abtExperimentInfo2.variantId;
                        if (!TextUtils.isEmpty(abtExperimentInfo2.triggerEventName)) {
                            str = abtExperimentInfo2.triggerEventName;
                        }
                        conditionalUserProperty2.triggerEventName = str;
                        conditionalUserProperty2.triggerTimeout = abtExperimentInfo2.triggerTimeoutInMillis;
                        conditionalUserProperty2.timeToLive = abtExperimentInfo2.timeToLiveInMillis;
                        ((AnalyticsConnector) this.analyticsConnector.get()).setConditionalUserProperty(conditionalUserProperty2);
                        arrayDeque.offer(conditionalUserProperty2);
                    } else {
                        throw null;
                    }
                }
            } else if (this.analyticsConnector.get() != null) {
                removeExperiments(getAllExperimentsInAnalytics());
            } else {
                throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
            }
        } else {
            throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }
}
