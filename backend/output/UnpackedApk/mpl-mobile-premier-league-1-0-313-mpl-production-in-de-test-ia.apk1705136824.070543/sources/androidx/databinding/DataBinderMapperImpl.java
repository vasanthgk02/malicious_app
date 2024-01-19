package androidx.databinding;

import android.view.View;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class DataBinderMapperImpl extends DataBinderMapper {
    public Set<Class<? extends DataBinderMapper>> mExistingMappers = new HashSet();
    public List<String> mFeatureBindingMappers = new CopyOnWriteArrayList();
    public List<DataBinderMapper> mMappers = new CopyOnWriteArrayList();

    public DataBinderMapperImpl() {
        addMapper(new com.mpl.androidapp.DataBinderMapperImpl());
    }

    /* access modifiers changed from: private */
    /* renamed from: convertBrIdToString$androidx$databinding$MergedDataBinderMapper */
    public String convertBrIdToString(int i) {
        for (DataBinderMapper convertBrIdToString : this.mMappers) {
            String convertBrIdToString2 = convertBrIdToString.convertBrIdToString(i);
            if (convertBrIdToString2 != null) {
                return convertBrIdToString2;
            }
        }
        if (loadFeatures()) {
            return convertBrIdToString(i);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: getDataBinder$androidx$databinding$MergedDataBinderMapper */
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        for (DataBinderMapper dataBinder : this.mMappers) {
            ViewDataBinding dataBinder2 = dataBinder.getDataBinder(dataBindingComponent, view, i);
            if (dataBinder2 != null) {
                return dataBinder2;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, view, i);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: getLayoutId$androidx$databinding$MergedDataBinderMapper */
    public int getLayoutId(String str) {
        for (DataBinderMapper layoutId : this.mMappers) {
            int layoutId2 = layoutId.getLayoutId(str);
            if (layoutId2 != 0) {
                return layoutId2;
            }
        }
        if (loadFeatures()) {
            return getLayoutId(str);
        }
        return 0;
    }

    public void addMapper(DataBinderMapper dataBinderMapper) {
        if (this.mExistingMappers.add(dataBinderMapper.getClass())) {
            this.mMappers.add(dataBinderMapper);
            for (DataBinderMapper addMapper : dataBinderMapper.collectDependencies()) {
                addMapper(addMapper);
            }
        }
    }

    public final boolean loadFeatures() {
        boolean z = false;
        for (String next : this.mFeatureBindingMappers) {
            try {
                Class<?> cls = Class.forName(next);
                if (DataBinderMapper.class.isAssignableFrom(cls)) {
                    addMapper((DataBinderMapper) cls.newInstance());
                    this.mFeatureBindingMappers.remove(next);
                    z = true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: getDataBinder$androidx$databinding$MergedDataBinderMapper */
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        for (DataBinderMapper dataBinder : this.mMappers) {
            ViewDataBinding dataBinder2 = dataBinder.getDataBinder(dataBindingComponent, viewArr, i);
            if (dataBinder2 != null) {
                return dataBinder2;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, viewArr, i);
        }
        return null;
    }
}
