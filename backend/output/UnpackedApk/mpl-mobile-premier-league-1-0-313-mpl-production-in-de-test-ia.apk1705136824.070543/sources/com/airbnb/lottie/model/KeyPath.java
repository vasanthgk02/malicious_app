package com.airbnb.lottie.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");
    public final List<String> keys;
    public KeyPathElement resolvedElement;

    public KeyPath(String... strArr) {
        this.keys = Arrays.asList(strArr);
    }

    public KeyPath addKey(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.keys.add(str);
        return keyPath;
    }

    public final boolean endsWithGlobstar() {
        return ((String) GeneratedOutlineSupport.outline29(this.keys, -1)).equals("**");
    }

    public boolean fullyResolvesTo(String str, int i) {
        boolean z = false;
        if (i >= this.keys.size()) {
            return false;
        }
        boolean z2 = i == this.keys.size() - 1;
        String str2 = this.keys.get(i);
        if (!str2.equals("**")) {
            boolean z3 = str2.equals(str) || str2.equals("*");
            if ((z2 || (i == this.keys.size() - 2 && endsWithGlobstar())) && z3) {
                z = true;
            }
            return z;
        }
        if (!z2 && this.keys.get(i + 1).equals(str)) {
            if (i == this.keys.size() - 2 || (i == this.keys.size() - 3 && endsWithGlobstar())) {
                z = true;
            }
            return z;
        } else if (z2) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.keys.size() - 1) {
                return false;
            }
            return this.keys.get(i2).equals(str);
        }
    }

    public int incrementDepthBy(String str, int i) {
        if ("__container".equals(str)) {
            return 0;
        }
        if (!this.keys.get(i).equals("**")) {
            return 1;
        }
        if (i != this.keys.size() - 1 && this.keys.get(i + 1).equals(str)) {
            return 2;
        }
        return 0;
    }

    public boolean matches(String str, int i) {
        if ("__container".equals(str)) {
            return true;
        }
        if (i >= this.keys.size()) {
            return false;
        }
        if (this.keys.get(i).equals(str) || this.keys.get(i).equals("**") || this.keys.get(i).equals("*")) {
            return true;
        }
        return false;
    }

    public boolean propagateToChildren(String str, int i) {
        boolean z = true;
        if ("__container".equals(str)) {
            return true;
        }
        if (i >= this.keys.size() - 1 && !this.keys.get(i).equals("**")) {
            z = false;
        }
        return z;
    }

    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.resolvedElement = keyPathElement;
        return keyPath;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("KeyPath{keys=");
        outline73.append(this.keys);
        outline73.append(",resolved=");
        return GeneratedOutlineSupport.outline65(outline73, this.resolvedElement != null, '}');
    }

    public KeyPath(KeyPath keyPath) {
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }
}
