package com.google.firebase.components;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.List;

public class DependencyCycleException extends DependencyException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DependencyCycleException(List<Component<?>> list) {
        // StringBuilder outline73 = GeneratedOutlineSupport.outline73("Dependency cycle detected: ");
        // outline73.append(Arrays.toString(list.toArray()));
        super(outline73.toString());
    }
}
