package io.hansel.visualizer;

import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class a {
    public static int a(ExpandableListAdapter expandableListAdapter, int i) {
        try {
            return expandableListAdapter.getChildrenCount(i);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static View a(ExpandableListView expandableListView, int i, int i2) {
        int headerViewsCount = expandableListView.getHeaderViewsCount();
        ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
        int groupCount = expandableListAdapter.getGroupCount();
        int childCount = expandableListView.getChildCount();
        int footerViewsCount = expandableListView.getFooterViewsCount();
        if (i == -1) {
            return expandableListView.getChildAt(i2);
        }
        if (i == -2) {
            return expandableListView.getChildAt((childCount - footerViewsCount) + i2);
        }
        if (i >= groupCount || i2 > a(expandableListAdapter, i)) {
            return null;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= groupCount) {
                break;
            }
            if (i3 < i) {
                headerViewsCount = expandableListView.isGroupExpanded(i3) ? a(expandableListAdapter, i3) + headerViewsCount + 1 : headerViewsCount + 1;
            } else if (i3 == i) {
                if (i2 > 0) {
                    if (!expandableListView.isGroupExpanded(i3)) {
                        return null;
                    }
                    headerViewsCount += i2;
                }
            }
            i3++;
        }
        if (headerViewsCount >= expandableListView.getChildCount()) {
            return null;
        }
        return expandableListView.getChildAt(headerViewsCount - expandableListView.getFirstVisiblePosition());
    }

    public static String a(ExpandableListView expandableListView, View view) {
        int i;
        try {
            int indexOfChild = expandableListView.indexOfChild(view);
            int headerViewsCount = expandableListView.getHeaderViewsCount();
            int childCount = (expandableListView.getChildCount() - headerViewsCount) - expandableListView.getFooterViewsCount();
            int i2 = indexOfChild - headerViewsCount;
            int i3 = -1;
            if (indexOfChild < headerViewsCount) {
                return -1 + ":" + indexOfChild;
            } else if (i2 >= childCount) {
                return -2 + ":" + (i2 - childCount);
            } else {
                ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
                int groupCount = expandableListAdapter.getGroupCount();
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= groupCount) {
                        i = -1;
                        break;
                    }
                    boolean isGroupExpanded = expandableListView.isGroupExpanded(i4);
                    int a2 = a(expandableListAdapter, i4);
                    int i6 = 1;
                    if (isGroupExpanded) {
                        i6 = 1 + a2;
                    }
                    int i7 = i5 + i6;
                    if (i7 >= i2 + 1) {
                        i = i2 - i5;
                        i3 = i4;
                        break;
                    }
                    i4++;
                    i5 = i7;
                }
                return i3 + ":" + i;
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
