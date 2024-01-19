package com.crimzoncode.tqcontests;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.crimzoncode.tqcontests.databinding.FragmentQuizQuestionBindingImpl;
import com.crimzoncode.tqcontests.databinding.ViewCustomDialogBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    public static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    public static final int LAYOUT_FRAGMENTQUIZQUESTION = 1;
    public static final int LAYOUT_VIEWCUSTOMDIALOG = 2;

    public static class InnerBrLookup {
        public static final SparseArray<String> sKeys;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(5);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sKeys.put(1, "quizAttempt");
            sKeys.put(2, "listener");
            sKeys.put(3, "dialogDetails");
        }
    }

    public static class InnerLayoutIdLookup {
        public static final HashMap<String, Integer> sKeys;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(2);
            sKeys = hashMap;
            hashMap.put("layout/fragment_quiz_question_0", Integer.valueOf(R.layout.fragment_quiz_question));
            sKeys.put("layout/view_custom_dialog_0", Integer.valueOf(R.layout.view_custom_dialog));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.fragment_quiz_question, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.view_custom_dialog, 2);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            } else if (i2 != 1) {
                if (i2 == 2) {
                    if ("layout/view_custom_dialog_0".equals(tag)) {
                        return new ViewCustomDialogBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for view_custom_dialog is invalid. Received: ", tag));
                }
            } else if ("layout/fragment_quiz_question_0".equals(tag)) {
                return new FragmentQuizQuestionBindingImpl(dataBindingComponent, view);
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for fragment_quiz_question is invalid. Received: ", tag));
            }
        }
        return null;
    }

    public int getLayoutId(String str) {
        int i = 0;
        if (str == null) {
            return 0;
        }
        Integer num = InnerLayoutIdLookup.sKeys.get(str);
        if (num != null) {
            i = num.intValue();
        }
        return i;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
