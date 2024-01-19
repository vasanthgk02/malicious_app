package com.bumptech.glide.manager;

import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

public final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}
