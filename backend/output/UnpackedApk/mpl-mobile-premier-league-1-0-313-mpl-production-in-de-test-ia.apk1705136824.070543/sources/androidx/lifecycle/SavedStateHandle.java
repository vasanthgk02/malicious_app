package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class SavedStateHandle {
    public static final Class[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    public final Map<String, Object<?>> mLiveDatas;
    public final Map<String, Object> mRegular;
    public final SavedStateProvider mSavedStateProvider;
    public final Map<String, SavedStateProvider> mSavedStateProviders;

    public SavedStateHandle(Map<String, Object> map) {
        this.mSavedStateProviders = new HashMap();
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new SavedStateProvider() {
            public Bundle saveState() {
                for (Entry entry : new HashMap(SavedStateHandle.this.mSavedStateProviders).entrySet()) {
                    Bundle saveState = ((SavedStateProvider) entry.getValue()).saveState();
                    SavedStateHandle savedStateHandle = SavedStateHandle.this;
                    String str = (String) entry.getKey();
                    if (savedStateHandle != null) {
                        if (saveState != null) {
                            Class[] clsArr = SavedStateHandle.ACCEPTABLE_CLASSES;
                            int length = clsArr.length;
                            int i = 0;
                            while (i < length) {
                                if (!clsArr[i].isInstance(saveState)) {
                                    i++;
                                }
                            }
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Can't put value with type ");
                            outline73.append(saveState.getClass());
                            outline73.append(" into saved state");
                            throw new IllegalArgumentException(outline73.toString());
                        }
                        MutableLiveData mutableLiveData = (MutableLiveData) savedStateHandle.mLiveDatas.get(str);
                        if (mutableLiveData != null) {
                            mutableLiveData.setValue(saveState);
                        } else {
                            savedStateHandle.mRegular.put(str, saveState);
                        }
                    } else {
                        throw null;
                    }
                }
                Set<String> keySet = SavedStateHandle.this.mRegular.keySet();
                ArrayList arrayList = new ArrayList(keySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String next : keySet) {
                    arrayList.add(next);
                    arrayList2.add(SavedStateHandle.this.mRegular.get(next));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(UserMetadata.KEYDATA_FILENAME, arrayList);
                bundle.putParcelableArrayList("values", arrayList2);
                return bundle;
            }
        };
        this.mRegular = new HashMap(map);
    }

    public static SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new SavedStateHandle();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new SavedStateHandle(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UserMetadata.KEYDATA_FILENAME);
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            hashMap.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
        }
        return new SavedStateHandle(hashMap);
    }

    public SavedStateHandle() {
        this.mSavedStateProviders = new HashMap();
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new SavedStateProvider() {
            public Bundle saveState() {
                for (Entry entry : new HashMap(SavedStateHandle.this.mSavedStateProviders).entrySet()) {
                    Bundle saveState = ((SavedStateProvider) entry.getValue()).saveState();
                    SavedStateHandle savedStateHandle = SavedStateHandle.this;
                    String str = (String) entry.getKey();
                    if (savedStateHandle != null) {
                        if (saveState != null) {
                            Class[] clsArr = SavedStateHandle.ACCEPTABLE_CLASSES;
                            int length = clsArr.length;
                            int i = 0;
                            while (i < length) {
                                if (!clsArr[i].isInstance(saveState)) {
                                    i++;
                                }
                            }
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Can't put value with type ");
                            outline73.append(saveState.getClass());
                            outline73.append(" into saved state");
                            throw new IllegalArgumentException(outline73.toString());
                        }
                        MutableLiveData mutableLiveData = (MutableLiveData) savedStateHandle.mLiveDatas.get(str);
                        if (mutableLiveData != null) {
                            mutableLiveData.setValue(saveState);
                        } else {
                            savedStateHandle.mRegular.put(str, saveState);
                        }
                    } else {
                        throw null;
                    }
                }
                Set<String> keySet = SavedStateHandle.this.mRegular.keySet();
                ArrayList arrayList = new ArrayList(keySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String next : keySet) {
                    arrayList.add(next);
                    arrayList2.add(SavedStateHandle.this.mRegular.get(next));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(UserMetadata.KEYDATA_FILENAME, arrayList);
                bundle.putParcelableArrayList("values", arrayList2);
                return bundle;
            }
        };
        this.mRegular = new HashMap();
    }
}
