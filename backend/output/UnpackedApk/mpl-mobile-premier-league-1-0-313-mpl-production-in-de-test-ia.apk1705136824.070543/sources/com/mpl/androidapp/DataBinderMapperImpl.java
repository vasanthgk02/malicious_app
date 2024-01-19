package com.mpl.androidapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.databinding.ActivityEditorRouterBindingImpl;
import com.mpl.androidapp.databinding.ActivityGamesManagementBindingImpl;
import com.mpl.androidapp.databinding.ContentGameManagmentBindingImpl;
import com.mpl.androidapp.databinding.ErrorViewBindingImpl;
import com.mpl.androidapp.databinding.FragmentErrorViewBindingImpl;
import com.mpl.androidapp.databinding.FragmentGamesManagementBindingImpl;
import com.mpl.androidapp.databinding.GameStreamErrorViewBindingImpl;
import com.mpl.androidapp.databinding.HolderGamesBindingImpl;
import com.mpl.androidapp.databinding.IncludeErrorViewBindingImpl;
import com.mpl.androidapp.databinding.ItemVideoQualityBindingImpl;
import com.mpl.androidapp.databinding.LayoutErrorDialogBottomSheetBindingImpl;
import com.mpl.androidapp.databinding.MiniProfileLoadingViewBindingImpl;
import com.mpl.androidapp.databinding.MiniProfileViewBindingImpl;
import com.mpl.androidapp.databinding.ToastGameSpaceBindingImpl;
import com.mpl.androidapp.databinding.ViewExternalShareBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    public static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    public static final int LAYOUT_ACTIVITYEDITORROUTER = 1;
    public static final int LAYOUT_ACTIVITYGAMESMANAGEMENT = 2;
    public static final int LAYOUT_CONTENTGAMEMANAGMENT = 3;
    public static final int LAYOUT_ERRORVIEW = 4;
    public static final int LAYOUT_FRAGMENTERRORVIEW = 5;
    public static final int LAYOUT_FRAGMENTGAMESMANAGEMENT = 6;
    public static final int LAYOUT_GAMESTREAMERRORVIEW = 7;
    public static final int LAYOUT_HOLDERGAMES = 8;
    public static final int LAYOUT_INCLUDEERRORVIEW = 9;
    public static final int LAYOUT_ITEMVIDEOQUALITY = 10;
    public static final int LAYOUT_LAYOUTERRORDIALOGBOTTOMSHEET = 11;
    public static final int LAYOUT_MINIPROFILELOADINGVIEW = 12;
    public static final int LAYOUT_MINIPROFILEVIEW = 13;
    public static final int LAYOUT_TOASTGAMESPACE = 14;
    public static final int LAYOUT_VIEWEXTERNALSHARE = 15;

    public static class InnerBrLookup {
        public static final SparseArray<String> sKeys;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(6);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sKeys.put(1, "dialogDetails");
            sKeys.put(2, "gamesViewModel");
            sKeys.put(3, "listener");
            sKeys.put(4, "movieViewModel");
            sKeys.put(5, "quizAttempt");
        }
    }

    public static class InnerLayoutIdLookup {
        public static final HashMap<String, Integer> sKeys;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(15);
            sKeys = hashMap;
            hashMap.put("layout/activity_editor_router_0", Integer.valueOf(R.layout.activity_editor_router));
            sKeys.put("layout/activity_games_management_0", Integer.valueOf(R.layout.activity_games_management));
            sKeys.put("layout/content_game_managment_0", Integer.valueOf(R.layout.content_game_managment));
            sKeys.put("layout/error_view_0", Integer.valueOf(R.layout.error_view));
            sKeys.put("layout/fragment_error_view_0", Integer.valueOf(R.layout.fragment_error_view));
            sKeys.put("layout/fragment_games_management_0", Integer.valueOf(R.layout.fragment_games_management));
            sKeys.put("layout/game_stream_error_view_0", Integer.valueOf(R.layout.game_stream_error_view));
            sKeys.put("layout/holder_games_0", Integer.valueOf(R.layout.holder_games));
            sKeys.put("layout/include_error_view_0", Integer.valueOf(R.layout.include_error_view));
            sKeys.put("layout/item_video_quality_0", Integer.valueOf(R.layout.item_video_quality));
            sKeys.put("layout/layout_error_dialog_bottom_sheet_0", Integer.valueOf(R.layout.layout_error_dialog_bottom_sheet));
            sKeys.put("layout/mini_profile_loading_view_0", Integer.valueOf(R.layout.mini_profile_loading_view));
            sKeys.put("layout/mini_profile_view_0", Integer.valueOf(R.layout.mini_profile_view));
            sKeys.put("layout/toast_game_space_0", Integer.valueOf(R.layout.toast_game_space));
            sKeys.put("layout/view_external_share_0", Integer.valueOf(R.layout.view_external_share));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(15);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_editor_router, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.activity_games_management, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.content_game_managment, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.error_view, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_error_view, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_games_management, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.game_stream_error_view, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.holder_games, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.include_error_view, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_video_quality, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_error_dialog_bottom_sheet, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mini_profile_loading_view, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mini_profile_view, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.toast_game_space, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.view_external_share, 15);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.crimzoncode.tqcontests.DataBinderMapperImpl());
        return arrayList;
    }

    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                switch (i2) {
                    case 1:
                        if ("layout/activity_editor_router_0".equals(tag)) {
                            return new ActivityEditorRouterBindingImpl(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for activity_editor_router is invalid. Received: ", tag));
                    case 2:
                        if ("layout/activity_games_management_0".equals(tag)) {
                            return new ActivityGamesManagementBindingImpl(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for activity_games_management is invalid. Received: ", tag));
                    case 3:
                        if ("layout/content_game_managment_0".equals(tag)) {
                            return new ContentGameManagmentBindingImpl(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for content_game_managment is invalid. Received: ", tag));
                    case 4:
                        if ("layout/error_view_0".equals(tag)) {
                            return new ErrorViewBindingImpl(dataBindingComponent, new View[]{view});
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for error_view is invalid. Received: ", tag));
                    case 5:
                        if ("layout/fragment_error_view_0".equals(tag)) {
                            return new FragmentErrorViewBindingImpl(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for fragment_error_view is invalid. Received: ", tag));
                    case 6:
                        if ("layout/fragment_games_management_0".equals(tag)) {
                            return new FragmentGamesManagementBindingImpl(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for fragment_games_management is invalid. Received: ", tag));
                    case 7:
                        if ("layout/game_stream_error_view_0".equals(tag)) {
                            return new GameStreamErrorViewBindingImpl(dataBindingComponent, new View[]{view});
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for game_stream_error_view is invalid. Received: ", tag));
                    case 8:
                        if ("layout/holder_games_0".equals(tag)) {
                            return new HolderGamesBindingImpl(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for holder_games is invalid. Received: ", tag));
                    case 9:
                        if ("layout/include_error_view_0".equals(tag)) {
                            return new IncludeErrorViewBindingImpl(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for include_error_view is invalid. Received: ", tag));
                    case 10:
                        if ("layout/item_video_quality_0".equals(tag)) {
                            return new ItemVideoQualityBindingImpl(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for item_video_quality is invalid. Received: ", tag));
                    case 11:
                        if ("layout/layout_error_dialog_bottom_sheet_0".equals(tag)) {
                            return new LayoutErrorDialogBottomSheetBindingImpl(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for layout_error_dialog_bottom_sheet is invalid. Received: ", tag));
                    case 12:
                        if ("layout/mini_profile_loading_view_0".equals(tag)) {
                            return new MiniProfileLoadingViewBindingImpl(dataBindingComponent, new View[]{view});
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for mini_profile_loading_view is invalid. Received: ", tag));
                    case 13:
                        if ("layout/mini_profile_view_0".equals(tag)) {
                            return new MiniProfileViewBindingImpl(dataBindingComponent, new View[]{view});
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for mini_profile_view is invalid. Received: ", tag));
                    case 14:
                        if ("layout/toast_game_space_0".equals(tag)) {
                            return new ToastGameSpaceBindingImpl(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for toast_game_space is invalid. Received: ", tag));
                    case 15:
                        if ("layout/view_external_share_0".equals(tag)) {
                            return new ViewExternalShareBindingImpl(dataBindingComponent, new View[]{view});
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for view_external_share is invalid. Received: ", tag));
                }
            } else {
                throw new RuntimeException("view must have a tag");
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
        if (!(viewArr == null || viewArr.length == 0)) {
            int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
            if (i2 > 0) {
                Object tag = viewArr[0].getTag();
                if (tag == null) {
                    throw new RuntimeException("view must have a tag");
                } else if (i2 != 4) {
                    if (i2 != 7) {
                        if (i2 != 15) {
                            if (i2 != 12) {
                                if (i2 == 13) {
                                    if ("layout/mini_profile_view_0".equals(tag)) {
                                        return new MiniProfileViewBindingImpl(dataBindingComponent, viewArr);
                                    }
                                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for mini_profile_view is invalid. Received: ", tag));
                                }
                            } else if ("layout/mini_profile_loading_view_0".equals(tag)) {
                                return new MiniProfileLoadingViewBindingImpl(dataBindingComponent, viewArr);
                            } else {
                                throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for mini_profile_loading_view is invalid. Received: ", tag));
                            }
                        } else if ("layout/view_external_share_0".equals(tag)) {
                            return new ViewExternalShareBindingImpl(dataBindingComponent, viewArr);
                        } else {
                            throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for view_external_share is invalid. Received: ", tag));
                        }
                    } else if ("layout/game_stream_error_view_0".equals(tag)) {
                        return new GameStreamErrorViewBindingImpl(dataBindingComponent, viewArr);
                    } else {
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for game_stream_error_view is invalid. Received: ", tag));
                    }
                } else if ("layout/error_view_0".equals(tag)) {
                    return new ErrorViewBindingImpl(dataBindingComponent, viewArr);
                } else {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("The tag for error_view is invalid. Received: ", tag));
                }
            }
        }
        return null;
    }
}
