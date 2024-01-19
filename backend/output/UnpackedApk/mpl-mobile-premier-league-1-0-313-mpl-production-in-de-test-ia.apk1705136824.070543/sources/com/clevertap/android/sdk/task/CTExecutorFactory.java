package com.clevertap.android.sdk.task;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CTExecutorFactory {
    public static final Map<String, CTExecutors> executorMap = Collections.synchronizedMap(new HashMap());

    public static CTExecutors executors(CleverTapInstanceConfig cleverTapInstanceConfig) {
        if (cleverTapInstanceConfig != null) {
            CTExecutors cTExecutors = executorMap.get(cleverTapInstanceConfig.accountId);
            if (cTExecutors == null) {
                synchronized (CTExecutorFactory.class) {
                    try {
                        cTExecutors = executorMap.get(cleverTapInstanceConfig.accountId);
                        if (cTExecutors == null) {
                            cTExecutors = new CTExecutors(cleverTapInstanceConfig);
                            executorMap.put(cleverTapInstanceConfig.accountId, cTExecutors);
                        }
                    }
                }
            }
            return cTExecutors;
        }
        throw new IllegalArgumentException("Can't create task for null config");
    }
}
