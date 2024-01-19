package kotlin.reflect.jvm.internal.impl.utils;

import java.util.HashSet;
import java.util.Set;

public class DFS$VisitedWithSet<N> implements DFS$Visited<N> {
    public final Set<N> visited = new HashSet();
}
