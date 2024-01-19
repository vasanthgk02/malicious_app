package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import java.util.Iterator;
import java.util.List;

public final class ReactPackageHelper$1 implements Iterable<ModuleHolder> {
    public final /* synthetic */ List val$nativeModules;

    public ReactPackageHelper$1(List list) {
        this.val$nativeModules = list;
    }

    public Iterator<ModuleHolder> iterator() {
        return new Iterator<ModuleHolder>() {
            public int position = 0;

            public boolean hasNext() {
                return this.position < ReactPackageHelper$1.this.val$nativeModules.size();
            }

            public Object next() {
                List list = ReactPackageHelper$1.this.val$nativeModules;
                int i = this.position;
                this.position = i + 1;
                return new ModuleHolder((NativeModule) list.get(i));
            }

            public void remove() {
                throw new UnsupportedOperationException("Cannot remove methods ");
            }
        };
    }
}
