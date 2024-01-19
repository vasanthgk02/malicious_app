package com.mpl.androidapp.updater.downloadmanager.utils;

import com.mpl.androidapp.cleverTap.MplCtEventInitiate;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/utils/DownServTimePoints;", "", "()V", "PropertyTimeFour", "PropertyTimeOne", "PropertyTimeThree", "PropertyTimeTwo", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownServTimePoints.kt */
public final class DownServTimePoints {
    public static final DownServTimePoints INSTANCE = new DownServTimePoints();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/utils/DownServTimePoints$PropertyTimeFour;", "", "()V", "startPoint", "", "getStartPoint", "()J", "setStartPoint", "(J)V", "logCtEvent", "", "gameId", "", "setTime", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownServTimePoints.kt */
    public static final class PropertyTimeFour {
        public static final PropertyTimeFour INSTANCE;
        public static long startPoint;

        static {
            PropertyTimeFour propertyTimeFour = new PropertyTimeFour();
            INSTANCE = propertyTimeFour;
            startPoint = propertyTimeFour.setTime();
        }

        private final long setTime() {
            return System.currentTimeMillis();
        }

        public final long getStartPoint() {
            return startPoint;
        }

        public final void logCtEvent(int i) {
            MplCtEventInitiate.sendEventDownloadServiceTimeLog$default(MplCtEventInitiate.INSTANCE, i, setTime() - startPoint, false, false, false, true, 28, null);
        }

        public final void setStartPoint(long j) {
            startPoint = j;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/utils/DownServTimePoints$PropertyTimeOne;", "", "()V", "startPoint", "", "getStartPoint", "()J", "setStartPoint", "(J)V", "logCtEvent", "", "gameId", "", "setTime", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownServTimePoints.kt */
    public static final class PropertyTimeOne {
        public static final PropertyTimeOne INSTANCE;
        public static long startPoint;

        static {
            PropertyTimeOne propertyTimeOne = new PropertyTimeOne();
            INSTANCE = propertyTimeOne;
            startPoint = propertyTimeOne.setTime();
        }

        private final long setTime() {
            return System.currentTimeMillis();
        }

        public final long getStartPoint() {
            return startPoint;
        }

        public final void logCtEvent(int i) {
            MplCtEventInitiate.sendEventDownloadServiceTimeLog$default(MplCtEventInitiate.INSTANCE, i, setTime() - startPoint, true, false, false, false, 56, null);
        }

        public final void setStartPoint(long j) {
            startPoint = j;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/utils/DownServTimePoints$PropertyTimeThree;", "", "()V", "startPoint", "", "getStartPoint", "()J", "setStartPoint", "(J)V", "logCtEvent", "", "gameId", "", "setTime", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownServTimePoints.kt */
    public static final class PropertyTimeThree {
        public static final PropertyTimeThree INSTANCE;
        public static long startPoint;

        static {
            PropertyTimeThree propertyTimeThree = new PropertyTimeThree();
            INSTANCE = propertyTimeThree;
            startPoint = propertyTimeThree.setTime();
        }

        private final long setTime() {
            return System.currentTimeMillis();
        }

        public final long getStartPoint() {
            return startPoint;
        }

        public final void logCtEvent(int i) {
            MplCtEventInitiate.sendEventDownloadServiceTimeLog$default(MplCtEventInitiate.INSTANCE, i, setTime() - startPoint, false, false, true, false, 44, null);
        }

        public final void setStartPoint(long j) {
            startPoint = j;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/utils/DownServTimePoints$PropertyTimeTwo;", "", "()V", "startPoint", "", "getStartPoint", "()J", "setStartPoint", "(J)V", "logCtEvent", "", "gameId", "", "setTime", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownServTimePoints.kt */
    public static final class PropertyTimeTwo {
        public static final PropertyTimeTwo INSTANCE;
        public static long startPoint;

        static {
            PropertyTimeTwo propertyTimeTwo = new PropertyTimeTwo();
            INSTANCE = propertyTimeTwo;
            startPoint = propertyTimeTwo.setTime();
        }

        private final long setTime() {
            return System.currentTimeMillis();
        }

        public final long getStartPoint() {
            return startPoint;
        }

        public final void logCtEvent(int i) {
            MplCtEventInitiate.sendEventDownloadServiceTimeLog$default(MplCtEventInitiate.INSTANCE, i, setTime() - startPoint, false, true, false, false, 52, null);
        }

        public final void setStartPoint(long j) {
            startPoint = j;
        }
    }
}
