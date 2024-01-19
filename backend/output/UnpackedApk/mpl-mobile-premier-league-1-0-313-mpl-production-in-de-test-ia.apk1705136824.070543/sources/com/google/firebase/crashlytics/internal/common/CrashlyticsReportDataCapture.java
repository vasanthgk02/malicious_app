package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class CrashlyticsReportDataCapture {
    public static final Map<String, Integer> ARCHITECTURES_BY_NAME;
    public static final String GENERATOR = String.format(Locale.US, CrashlyticsController.GENERATOR_FORMAT, new Object[]{"18.2.9"});
    public static final int GENERATOR_TYPE = 3;
    public static final int REPORT_ANDROID_PLATFORM = 4;
    public static final int SESSION_ANDROID_PLATFORM = 3;
    public static final String SIGNAL_DEFAULT = "0";
    public final AppData appData;
    public final Context context;
    public final IdManager idManager;
    public final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;

    static {
        HashMap hashMap = new HashMap();
        ARCHITECTURES_BY_NAME = hashMap;
        hashMap.put("armeabi", Integer.valueOf(5));
        ARCHITECTURES_BY_NAME.put("armeabi-v7a", Integer.valueOf(6));
        ARCHITECTURES_BY_NAME.put("arm64-v8a", Integer.valueOf(9));
        ARCHITECTURES_BY_NAME.put("x86", Integer.valueOf(0));
        ARCHITECTURES_BY_NAME.put("x86_64", Integer.valueOf(1));
    }

    public CrashlyticsReportDataCapture(Context context2, IdManager idManager2, AppData appData2, StackTraceTrimmingStrategy stackTraceTrimmingStrategy2) {
        this.context = context2;
        this.idManager = idManager2;
        this.appData = appData2;
        this.stackTraceTrimmingStrategy = stackTraceTrimmingStrategy2;
    }

    private Builder buildReportData() {
        return CrashlyticsReport.builder().setSdkVersion("18.2.9").setGmpAppId(this.appData.googleAppId).setInstallationUuid(this.idManager.getCrashlyticsInstallId()).setBuildVersion(this.appData.versionCode).setDisplayVersion(this.appData.versionName).setPlatform(4);
    }

    public static int getDeviceArchitecture() {
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str)) {
            return 7;
        }
        Integer num = ARCHITECTURES_BY_NAME.get(str.toLowerCase(Locale.US));
        if (num == null) {
            return 7;
        }
        return num.intValue();
    }

    private BinaryImage populateBinaryImageData() {
        return BinaryImage.builder().setBaseAddress(0).setSize(0).setName(this.appData.packageName).setUuid(this.appData.buildId).build();
    }

    private ImmutableList<BinaryImage> populateBinaryImagesList() {
        return ImmutableList.from((E[]) new BinaryImage[]{populateBinaryImageData()});
    }

    private Application populateEventApplicationData(int i, TrimmedThrowableData trimmedThrowableData, Thread thread, int i2, int i3, boolean z) {
        Boolean bool;
        RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(this.appData.packageName, this.context);
        if (appProcessInfo != null) {
            bool = Boolean.valueOf(appProcessInfo.importance != 100);
        } else {
            bool = null;
        }
        return Application.builder().setBackground(bool).setUiOrientation(i).setExecution(populateExecutionData(trimmedThrowableData, thread, i2, i3, z)).build();
    }

    private Device populateEventDeviceData(int i) {
        BatteryState batteryState = BatteryState.get(this.context);
        Float batteryLevel = batteryState.getBatteryLevel();
        Double valueOf = batteryLevel != null ? Double.valueOf(batteryLevel.doubleValue()) : null;
        int batteryVelocity = batteryState.getBatteryVelocity();
        boolean proximitySensorEnabled = CommonUtils.getProximitySensorEnabled(this.context);
        return Device.builder().setBatteryLevel(valueOf).setBatteryVelocity(batteryVelocity).setProximityOn(proximitySensorEnabled).setOrientation(i).setRamUsed(CommonUtils.getTotalRamInBytes() - CommonUtils.calculateFreeRamInBytes(this.context)).setDiskUsed(CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath())).build();
    }

    private Exception populateExceptionData(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        return populateExceptionData(trimmedThrowableData, i, i2, 0);
    }

    private Execution populateExecutionData(TrimmedThrowableData trimmedThrowableData, Thread thread, int i, int i2, boolean z) {
        return Execution.builder().setThreads(populateThreadsList(trimmedThrowableData, thread, i, z)).setException(populateExceptionData(trimmedThrowableData, i, i2)).setSignal(populateSignalData()).setBinaries(populateBinaryImagesList()).build();
    }

    private Frame populateFrameData(StackTraceElement stackTraceElement, Frame.Builder builder) {
        long j = 0;
        long max = stackTraceElement.isNativeMethod() ? Math.max((long) stackTraceElement.getLineNumber(), 0) : 0;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j = (long) stackTraceElement.getLineNumber();
        }
        return builder.setPc(max).setSymbol(str).setFile(fileName).setOffset(j).build();
    }

    private ImmutableList<Frame> populateFramesList(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement populateFrameData : stackTraceElementArr) {
            arrayList.add(populateFrameData(populateFrameData, Frame.builder().setImportance(i)));
        }
        return ImmutableList.from((List<E>) arrayList);
    }

    private Session.Application populateSessionApplicationData() {
        return Session.Application.builder().setIdentifier(this.idManager.getAppIdentifier()).setVersion(this.appData.versionCode).setDisplayVersion(this.appData.versionName).setInstallationUuid(this.idManager.getCrashlyticsInstallId()).setDevelopmentPlatform(this.appData.developmentPlatformProvider.getDevelopmentPlatform()).setDevelopmentPlatformVersion(this.appData.developmentPlatformProvider.getDevelopmentPlatformVersion()).build();
    }

    private Session populateSessionData(String str, long j) {
        return Session.builder().setStartedAt(j).setIdentifier(str).setGenerator(GENERATOR).setApp(populateSessionApplicationData()).setOs(populateSessionOperatingSystemData()).setDevice(populateSessionDeviceData()).setGeneratorType(3).build();
    }

    private Session.Device populateSessionDeviceData() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int deviceArchitecture = getDeviceArchitecture();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean isEmulator = CommonUtils.isEmulator(this.context);
        int deviceState = CommonUtils.getDeviceState(this.context);
        String str = Build.MANUFACTURER;
        return Session.Device.builder().setArch(deviceArchitecture).setModel(Build.MODEL).setCores(availableProcessors).setRam(totalRamInBytes).setDiskSpace(blockCount).setSimulator(isEmulator).setState(deviceState).setManufacturer(str).setModelClass(Build.PRODUCT).build();
    }

    private OperatingSystem populateSessionOperatingSystemData() {
        return OperatingSystem.builder().setPlatform(3).setVersion(VERSION.RELEASE).setBuildVersion(VERSION.CODENAME).setJailbroken(CommonUtils.isRooted(this.context)).build();
    }

    private Signal populateSignalData() {
        return Signal.builder().setName("0").setCode("0").setAddress(0).build();
    }

    private Thread populateThreadData(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return populateThreadData(thread, stackTraceElementArr, 0);
    }

    private ImmutableList<Thread> populateThreadsList(TrimmedThrowableData trimmedThrowableData, Thread thread, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(populateThreadData(thread, trimmedThrowableData.stacktrace, i));
        if (z) {
            for (Entry next : Thread.getAllStackTraces().entrySet()) {
                Thread thread2 = (Thread) next.getKey();
                if (!thread2.equals(thread)) {
                    arrayList.add(populateThreadData(thread2, this.stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[]) next.getValue())));
                }
            }
        }
        return ImmutableList.from((List<E>) arrayList);
    }

    public Event captureAnrEventData(ApplicationExitInfo applicationExitInfo) {
        int i = this.context.getResources().getConfiguration().orientation;
        return Event.builder().setType("anr").setTimestamp(applicationExitInfo.getTimestamp()).setApp(populateEventApplicationData(i, applicationExitInfo)).setDevice(populateEventDeviceData(i)).build();
    }

    public Event captureEventData(Throwable th, Thread thread, String str, long j, int i, int i2, boolean z) {
        int i3 = this.context.getResources().getConfiguration().orientation;
        Throwable th2 = th;
        String str2 = str;
        long j2 = j;
        return Event.builder().setType(str).setTimestamp(j).setApp(populateEventApplicationData(i3, new TrimmedThrowableData(th, this.stackTraceTrimmingStrategy), thread, i, i2, z)).setDevice(populateEventDeviceData(i3)).build();
    }

    public CrashlyticsReport captureReportData(String str, long j) {
        return buildReportData().setSession(populateSessionData(str, j)).build();
    }

    private Exception populateExceptionData(TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) {
        String str = trimmedThrowableData.className;
        String str2 = trimmedThrowableData.localizedMessage;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        int i4 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (i3 >= i2) {
            TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2;
            while (trimmedThrowableData3 != null) {
                trimmedThrowableData3 = trimmedThrowableData3.cause;
                i4++;
            }
        }
        Exception.Builder overflowCount = Exception.builder().setType(str).setReason(str2).setFrames(ImmutableList.from((List<E>) populateFramesList(stackTraceElementArr, i))).setOverflowCount(i4);
        if (trimmedThrowableData2 != null && i4 == 0) {
            overflowCount.setCausedBy(populateExceptionData(trimmedThrowableData2, i, i2, i3 + 1));
        }
        return overflowCount.build();
    }

    private Thread populateThreadData(Thread thread, StackTraceElement[] stackTraceElementArr, int i) {
        return Thread.builder().setName(thread.getName()).setImportance(i).setFrames(ImmutableList.from((List<E>) populateFramesList(stackTraceElementArr, i))).build();
    }

    private Execution populateExecutionData(ApplicationExitInfo applicationExitInfo) {
        return Execution.builder().setAppExitInfo(applicationExitInfo).setSignal(populateSignalData()).setBinaries(populateBinaryImagesList()).build();
    }

    private Application populateEventApplicationData(int i, ApplicationExitInfo applicationExitInfo) {
        return Application.builder().setBackground(Boolean.valueOf(applicationExitInfo.getImportance() != 100)).setUiOrientation(i).setExecution(populateExecutionData(applicationExitInfo)).build();
    }
}
