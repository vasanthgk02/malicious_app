package com.mpl.androidapp.miniprofile.ct;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents;", "", "()V", "GameBroadcasting", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClevertapEvents.kt */
public abstract class ClevertapEvents {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting;", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents;", "()V", "FeatureSegments", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClevertapEvents.kt */
    public static abstract class GameBroadcasting extends ClevertapEvents {

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments;", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting;", "()V", "SegmentationChapterNameClicked", "SegmentationChapterSelectionFromChapterList", "SegmentationCourseSeekChapterChange", "SegmentationViewAllClicked", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments$SegmentationCourseSeekChapterChange;", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments$SegmentationChapterNameClicked;", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments$SegmentationViewAllClicked;", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments$SegmentationChapterSelectionFromChapterList;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ClevertapEvents.kt */
        public static abstract class FeatureSegments extends GameBroadcasting {

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments$SegmentationChapterNameClicked;", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments;", "context", "Landroid/content/Context;", "chapterName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getChapterName", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ClevertapEvents.kt */
            public static final class SegmentationChapterNameClicked extends FeatureSegments {
                public final String chapterName;
                public final Context context;

                /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
                public SegmentationChapterNameClicked(Context context2, String str) {
                    // Intrinsics.checkNotNullParameter(context2, "context");
                    // Intrinsics.checkNotNullParameter(str, "chapterName");
                    super(null);
                    this.context = context2;
                    this.chapterName = str;
                }

                public final String getChapterName() {
                    return this.chapterName;
                }

                public final Context getContext() {
                    return this.context;
                }
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments$SegmentationChapterSelectionFromChapterList;", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments;", "context", "Landroid/content/Context;", "chapterName", "", "timeStamp", "listType", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChapterName", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getListType", "getTimeStamp", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ClevertapEvents.kt */
            public static final class SegmentationChapterSelectionFromChapterList extends FeatureSegments {
                public final String chapterName;
                public final Context context;
                public final String listType;
                public final String timeStamp;

                /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
                public SegmentationChapterSelectionFromChapterList(Context context2, String str, String str2, String str3) {
                    // Intrinsics.checkNotNullParameter(context2, "context");
                    // Intrinsics.checkNotNullParameter(str, "chapterName");
                    // Intrinsics.checkNotNullParameter(str2, "timeStamp");
                    // Intrinsics.checkNotNullParameter(str3, "listType");
                    super(null);
                    this.context = context2;
                    this.chapterName = str;
                    this.timeStamp = str2;
                    this.listType = str3;
                }

                public final String getChapterName() {
                    return this.chapterName;
                }

                public final Context getContext() {
                    return this.context;
                }

                public final String getListType() {
                    return this.listType;
                }

                public final String getTimeStamp() {
                    return this.timeStamp;
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments$SegmentationCourseSeekChapterChange;", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ClevertapEvents.kt */
            public static final class SegmentationCourseSeekChapterChange extends FeatureSegments {
                public final Context context;

                /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
                public SegmentationCourseSeekChapterChange(Context context2) {
                    // Intrinsics.checkNotNullParameter(context2, "context");
                    super(null);
                    this.context = context2;
                }

                public final Context getContext() {
                    return this.context;
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments$SegmentationViewAllClicked;", "Lcom/mpl/androidapp/miniprofile/ct/ClevertapEvents$GameBroadcasting$FeatureSegments;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ClevertapEvents.kt */
            public static final class SegmentationViewAllClicked extends FeatureSegments {
                public final Context context;

                /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
                public SegmentationViewAllClicked(Context context2) {
                    // Intrinsics.checkNotNullParameter(context2, "context");
                    super(null);
                    this.context = context2;
                }

                public final Context getContext() {
                    return this.context;
                }
            }

            public FeatureSegments() {
                super(null);
            }

            public /* synthetic */ FeatureSegments(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public GameBroadcasting() {
            super(null);
        }

        public /* synthetic */ GameBroadcasting(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ClevertapEvents() {
    }

    public /* synthetic */ ClevertapEvents(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
