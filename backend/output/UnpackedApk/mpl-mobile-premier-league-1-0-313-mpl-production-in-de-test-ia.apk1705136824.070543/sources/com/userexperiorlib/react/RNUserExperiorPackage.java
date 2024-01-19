package com.userexperiorlib.react;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.userexperior.UserExperior;
import com.userexperior.utilities.SecureViewBucket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RNUserExperiorPackage implements ReactPackage {

    public class RNUserExperiorModule extends ReactContextBaseJavaModule {
        public RNUserExperiorModule(ReactApplicationContext reactApplicationContext) {
            super(reactApplicationContext);
        }

        @ReactMethod
        public void addInSecureViewBucket(final int i) {
            ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock(this) {
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    try {
                        SecureViewBucket.addInSecureViewBucket(nativeViewHierarchyManager.resolveView(i));
                    } catch (Exception unused) {
                    }
                }
            });
        }

        @ReactMethod
        public void consent() {
            try {
                UserExperior.consent();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void endTimer(String str) {
            try {
                UserExperior.endTimer(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public String getName() {
            return UserExperior.TAG;
        }

        @ReactMethod
        public void getOptOutStatus(Promise promise) {
            try {
                promise.resolve(Boolean.valueOf(UserExperior.getOptOutStatus()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void isRecording(Promise promise) {
            try {
                promise.resolve(Boolean.valueOf(UserExperior.isRecording()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void logEvent(String str) {
            try {
                UserExperior.logEvent(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void logMessage(String str) {
            try {
                UserExperior.logMessage(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void optIn() {
            try {
                UserExperior.optIn();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void optOut() {
            try {
                UserExperior.optOut();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void pauseRecording() {
            try {
                UserExperior.pauseRecording();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void removeFromSecureViewBucket(final int i) {
            ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock(this) {
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    try {
                        SecureViewBucket.removeFromSecureViewBucket(nativeViewHierarchyManager.resolveView(i));
                    } catch (Exception unused) {
                    }
                }
            });
        }

        @ReactMethod
        public void resumeRecording() {
            try {
                UserExperior.resumeRecording();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void setCustomTag(String str, String str2) {
            try {
                UserExperior.setCustomTag(str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void setDeviceLocation(double d2, double d3) {
            try {
                UserExperior.setDeviceLocation(d2, d3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void setUserIdentifier(String str) {
            try {
                UserExperior.setUserIdentifier(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void setUserProperties(ReadableMap readableMap) {
            if (readableMap != null) {
                HashMap hashMap = new HashMap();
                ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    ReadableType type = readableMap.getType(nextKey);
                    if (type == ReadableType.Boolean) {
                        hashMap.put(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
                    } else if (type == ReadableType.Number) {
                        hashMap.put(nextKey, Double.valueOf(readableMap.getDouble(nextKey)));
                    } else {
                        hashMap.put(nextKey, readableMap.getString(nextKey));
                    }
                }
                try {
                    UserExperior.setUserProperties(hashMap);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @ReactMethod
        public void startRecording(String str, String str2, String str3) {
            try {
                UserExperior.startRecording(getReactApplicationContext(), str, str2, str3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void startScreen(String str) {
            try {
                UserExperior.startScreen(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void startTimer(String str) {
            try {
                UserExperior.startTimer(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void stopRecording() {
            try {
                UserExperior.stopRecording();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @ReactMethod
        public void endTimer(String str, ReadableMap readableMap) {
            if (readableMap != null) {
                HashMap hashMap = new HashMap();
                ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    hashMap.put(nextKey, readableMap.getString(nextKey));
                }
                try {
                    UserExperior.endTimer(str, hashMap);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    UserExperior.endTimer(str);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }

        @ReactMethod
        public void logEvent(String str, ReadableMap readableMap) {
            if (readableMap != null) {
                HashMap hashMap = new HashMap();
                ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    ReadableType type = readableMap.getType(nextKey);
                    if (type == ReadableType.Boolean) {
                        hashMap.put(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
                    } else if (type == ReadableType.Number) {
                        hashMap.put(nextKey, Double.valueOf(readableMap.getDouble(nextKey)));
                    } else {
                        hashMap.put(nextKey, readableMap.getString(nextKey));
                    }
                }
                try {
                    UserExperior.logEvent(str, hashMap);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    UserExperior.logEvent(str);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }

        @ReactMethod
        public void logMessage(String str, ReadableMap readableMap) {
            if (readableMap != null) {
                HashMap hashMap = new HashMap();
                ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    ReadableType type = readableMap.getType(nextKey);
                    if (type == ReadableType.Boolean) {
                        hashMap.put(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
                    } else if (type == ReadableType.Number) {
                        hashMap.put(nextKey, Double.valueOf(readableMap.getDouble(nextKey)));
                    } else {
                        hashMap.put(nextKey, readableMap.getString(nextKey));
                    }
                }
                try {
                    UserExperior.logMessage(str, hashMap);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    UserExperior.logMessage(str);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }

        @ReactMethod
        public void startTimer(String str, ReadableMap readableMap) {
            if (readableMap != null) {
                HashMap hashMap = new HashMap();
                ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    hashMap.put(nextKey, readableMap.getString(nextKey));
                }
                try {
                    UserExperior.startTimer(str, hashMap);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    UserExperior.startTimer(str);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RNUserExperiorModule(reactApplicationContext));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
