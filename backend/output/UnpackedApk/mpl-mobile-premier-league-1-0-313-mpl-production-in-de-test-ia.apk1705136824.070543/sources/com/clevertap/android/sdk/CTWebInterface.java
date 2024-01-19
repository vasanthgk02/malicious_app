package com.clevertap.android.sdk;

import android.webkit.JavascriptInterface;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CTWebInterface {
    public final WeakReference<CleverTapAPI> weakReference;

    public CTWebInterface(CleverTapAPI cleverTapAPI) {
        this.weakReference = new WeakReference<>(cleverTapAPI);
    }

    @JavascriptInterface
    public void addMultiValueForKey(String str, String str2) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else {
            cleverTapAPI.addMultiValueForKey(str, str2);
        }
    }

    @JavascriptInterface
    public void addMultiValuesForKey(String str, String str2) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else if (str == null) {
            Logger.v("Key passed to CTWebInterface is null");
        } else if (str2 != null) {
            try {
                cleverTapAPI.addMultiValuesForKey(str, Utils.convertJSONArrayToArrayList(new JSONArray(str2)));
            } catch (JSONException e2) {
                GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to parse values from WebView "));
            }
        } else {
            Logger.v("values passed to CTWebInterface is null");
        }
    }

    @JavascriptInterface
    public void decrementValue(String str, double d2) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
            return;
        }
        cleverTapAPI.coreState.analyticsManager._constructIncrementDecrementValues(Double.valueOf(d2), str, "$decr");
    }

    @JavascriptInterface
    public void incrementValue(String str, double d2) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
            return;
        }
        cleverTapAPI.coreState.analyticsManager._constructIncrementDecrementValues(Double.valueOf(d2), str, "$incr");
    }

    @JavascriptInterface
    public void onUserLogin(String str) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else if (str != null) {
            try {
                cleverTapAPI.onUserLogin(Utils.convertJSONObjectToHashMap(new JSONObject(str)));
            } catch (JSONException e2) {
                GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to parse profile from WebView "));
            }
        } else {
            Logger.v("profile passed to CTWebInterface is null");
        }
    }

    @JavascriptInterface
    public void pushChargedEvent(String str, String str2) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (str != null) {
                try {
                    hashMap = Utils.convertJSONObjectToHashMap(new JSONObject(str));
                } catch (JSONException e2) {
                    GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to parse chargeDetails for Charged Event from WebView "));
                }
                ArrayList<HashMap<String, Object>> arrayList = null;
                if (str2 != null) {
                    try {
                        arrayList = Utils.convertJSONArrayOfJSONObjectsToArrayListOfHashMaps(new JSONArray(str2));
                    } catch (JSONException e3) {
                        GeneratedOutlineSupport.outline105(e3, GeneratedOutlineSupport.outline73("Unable to parse items for Charged Event from WebView "));
                    }
                    cleverTapAPI.pushChargedEvent(hashMap, arrayList);
                }
            } else {
                Logger.v("chargeDetails passed to CTWebInterface is null");
            }
        }
    }

    @JavascriptInterface
    public void pushEvent(String str) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else {
            cleverTapAPI.pushEvent(str);
        }
    }

    @JavascriptInterface
    public void pushProfile(String str) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else if (str != null) {
            try {
                cleverTapAPI.coreState.analyticsManager.pushProfile(Utils.convertJSONObjectToHashMap(new JSONObject(str)));
            } catch (JSONException e2) {
                GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to parse profile from WebView "));
            }
        } else {
            Logger.v("profile passed to CTWebInterface is null");
        }
    }

    @JavascriptInterface
    public void removeMultiValueForKey(String str, String str2) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else if (str == null) {
            Logger.v("Key passed to CTWebInterface is null");
        } else if (str2 == null) {
            Logger.v("Value passed to CTWebInterface is null");
        } else {
            cleverTapAPI.removeMultiValueForKey(str, str2);
        }
    }

    @JavascriptInterface
    public void removeMultiValuesForKey(String str, String str2) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else if (str == null) {
            Logger.v("Key passed to CTWebInterface is null");
        } else if (str2 != null) {
            try {
                cleverTapAPI.removeMultiValuesForKey(str, Utils.convertJSONArrayToArrayList(new JSONArray(str2)));
            } catch (JSONException e2) {
                GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to parse values from WebView "));
            }
        } else {
            Logger.v("values passed to CTWebInterface is null");
        }
    }

    @JavascriptInterface
    public void removeValueForKey(String str) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else if (str == null) {
            Logger.v("Key passed to CTWebInterface is null");
        } else {
            cleverTapAPI.removeValueForKey(str);
        }
    }

    @JavascriptInterface
    public void setMultiValueForKey(String str, String str2) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else if (str == null) {
            Logger.v("Key passed to CTWebInterface is null");
        } else if (str2 != null) {
            try {
                ArrayList<String> convertJSONArrayToArrayList = Utils.convertJSONArrayToArrayList(new JSONArray(str2));
                AnalyticsManager analyticsManager = cleverTapAPI.coreState.analyticsManager;
                Task postAsyncSafelyTask = CTExecutorFactory.executors(analyticsManager.config).postAsyncSafelyTask();
                postAsyncSafelyTask.executor.execute(new Runnable("setMultiValuesForKey", new Callable<Void>(convertJSONArrayToArrayList, str) {
                    public final /* synthetic */ String val$key;
                    public final /* synthetic */ ArrayList val$values;

                    {
                        this.val$values = r2;
                        this.val$key = r3;
                    }

                    public Object call() throws Exception {
                        AnalyticsManager.access$100(AnalyticsManager.this, this.val$values, this.val$key, "$set");
                        return null;
                    }
                }) {
                    public final /* synthetic */ Callable val$callable;
                    public final /* synthetic */ String val$logTag;

                    {
                        this.val$logTag = r2;
                        this.val$callable = r3;
                    }

                    public void run() {
                        try {
                            Logger logger = Task.this.config.getLogger();
                            logger.verbose(Task.this.taskName + " Task: " + this.val$logTag + " starting on..." + Thread.currentThread().getName());
                            TResult call = this.val$callable.call();
                            Logger logger2 = Task.this.config.getLogger();
                            logger2.verbose(Task.this.taskName + " Task: " + this.val$logTag + " executed successfully on..." + Thread.currentThread().getName());
                            Task task = Task.this;
                            if (task != null) {
                                STATE state = STATE.SUCCESS;
                                task.result = call;
                                for (SuccessExecutable<TResult> execute : task.successExecutables) {
                                    execute.execute(task.result);
                                }
                                return;
                            }
                            throw null;
                        } catch (Exception e2) {
                            Task task2 = Task.this;
                            if (task2 != null) {
                                STATE state2 = STATE.FAILED;
                                for (FailureExecutable<Exception> execute2 : task2.failureExecutables) {
                                    execute2.execute(e2);
                                }
                                Logger logger3 = Task.this.config.getLogger();
                                logger3.verbose(Task.this.taskName + " Task: " + this.val$logTag + " failed to execute on..." + Thread.currentThread().getName(), (Throwable) e2);
                                e2.printStackTrace();
                                return;
                            }
                            throw null;
                        }
                    }
                });
            } catch (JSONException e2) {
                GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to parse values from WebView "));
            }
        } else {
            Logger.v("values passed to CTWebInterface is null");
        }
    }

    @JavascriptInterface
    public void pushEvent(String str, String str2) {
        CleverTapAPI cleverTapAPI = (CleverTapAPI) this.weakReference.get();
        if (cleverTapAPI == null) {
            Logger.d("CleverTap Instance is null.");
        } else if (str2 != null) {
            try {
                cleverTapAPI.pushEvent(str, Utils.convertJSONObjectToHashMap(new JSONObject(str2)));
            } catch (JSONException e2) {
                GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to parse eventActions from WebView "));
            }
        } else {
            Logger.v("eventActions passed to CTWebInterface is null");
        }
    }
}
