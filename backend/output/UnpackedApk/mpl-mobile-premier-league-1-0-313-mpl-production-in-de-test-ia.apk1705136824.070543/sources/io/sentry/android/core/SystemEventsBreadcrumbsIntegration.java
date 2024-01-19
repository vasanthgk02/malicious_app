package io.sentry.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import io.sentry.Breadcrumb;
import io.sentry.IHub;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.Objects;
import io.sentry.util.StringUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class SystemEventsBreadcrumbsIntegration implements Integration, Closeable {
    public final List<String> actions;
    public final Context context;
    public SentryAndroidOptions options;
    public SystemEventsBroadcastReceiver receiver;

    public static final class SystemEventsBroadcastReceiver extends BroadcastReceiver {
        public final IHub hub;
        public final ILogger logger;

        public SystemEventsBroadcastReceiver(IHub iHub, ILogger iLogger) {
            this.hub = iHub;
            this.logger = iLogger;
        }

        public void onReceive(Context context, Intent intent) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType("system");
            breadcrumb.setCategory("device.event");
            String action = intent.getAction();
            String stringAfterDot = StringUtils.getStringAfterDot(action);
            if (stringAfterDot != null) {
                breadcrumb.setData("action", stringAfterDot);
            }
            Bundle extras = intent.getExtras();
            HashMap hashMap = new HashMap();
            if (extras != null && !extras.isEmpty()) {
                for (String str : extras.keySet()) {
                    try {
                        Object obj = extras.get(str);
                        if (obj != null) {
                            hashMap.put(str, obj.toString());
                        }
                    } catch (Exception e2) {
                        this.logger.log(SentryLevel.ERROR, e2, "%s key of the %s action threw an error.", str, action);
                    }
                }
                breadcrumb.setData("extras", hashMap);
            }
            breadcrumb.setLevel(SentryLevel.INFO);
            this.hub.addBreadcrumb(breadcrumb);
        }
    }

    public SystemEventsBreadcrumbsIntegration(Context context2) {
        this(context2, getDefaultActions());
    }

    public static List<String> getDefaultActions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.appwidget.action.APPWIDGET_DELETED");
        arrayList.add("android.appwidget.action.APPWIDGET_DISABLED");
        arrayList.add("android.appwidget.action.APPWIDGET_ENABLED");
        arrayList.add("android.appwidget.action.APPWIDGET_HOST_RESTORED");
        arrayList.add("android.appwidget.action.APPWIDGET_RESTORED");
        arrayList.add("android.appwidget.action.APPWIDGET_UPDATE");
        arrayList.add("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS");
        arrayList.add("android.intent.action.ACTION_POWER_CONNECTED");
        arrayList.add("android.intent.action.ACTION_POWER_DISCONNECTED");
        arrayList.add("android.intent.action.ACTION_SHUTDOWN");
        arrayList.add("android.intent.action.AIRPLANE_MODE");
        arrayList.add("android.intent.action.BATTERY_LOW");
        arrayList.add("android.intent.action.BATTERY_OKAY");
        arrayList.add("android.intent.action.BOOT_COMPLETED");
        arrayList.add("android.intent.action.CAMERA_BUTTON");
        arrayList.add("android.intent.action.CONFIGURATION_CHANGED");
        arrayList.add("android.intent.action.CONTENT_CHANGED");
        arrayList.add("android.intent.action.DATE_CHANGED");
        arrayList.add("android.intent.action.DEVICE_STORAGE_LOW");
        arrayList.add("android.intent.action.DEVICE_STORAGE_OK");
        arrayList.add("android.intent.action.DOCK_EVENT");
        arrayList.add("android.intent.action.DREAMING_STARTED");
        arrayList.add("android.intent.action.DREAMING_STOPPED");
        arrayList.add("android.intent.action.INPUT_METHOD_CHANGED");
        arrayList.add("android.intent.action.LOCALE_CHANGED");
        arrayList.add("android.intent.action.REBOOT");
        arrayList.add("android.intent.action.SCREEN_OFF");
        arrayList.add("android.intent.action.SCREEN_ON");
        arrayList.add("android.intent.action.TIMEZONE_CHANGED");
        arrayList.add("android.intent.action.TIME_SET");
        arrayList.add("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        arrayList.add("android.os.action.POWER_SAVE_MODE_CHANGED");
        arrayList.add("android.intent.action.APP_ERROR");
        arrayList.add("android.intent.action.BUG_REPORT");
        arrayList.add("android.intent.action.MEDIA_BAD_REMOVAL");
        arrayList.add("android.intent.action.MEDIA_MOUNTED");
        arrayList.add("android.intent.action.MEDIA_UNMOUNTABLE");
        arrayList.add("android.intent.action.MEDIA_UNMOUNTED");
        return arrayList;
    }

    public void close() throws IOException {
        SystemEventsBroadcastReceiver systemEventsBroadcastReceiver = this.receiver;
        if (systemEventsBroadcastReceiver != null) {
            this.context.unregisterReceiver(systemEventsBroadcastReceiver);
            this.receiver = null;
            SentryAndroidOptions sentryAndroidOptions = this.options;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "SystemEventsBreadcrumbsIntegration remove.", new Object[0]);
            }
        }
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "SystemEventsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.options.isEnableSystemEventBreadcrumbs()));
        if (this.options.isEnableSystemEventBreadcrumbs()) {
            this.receiver = new SystemEventsBroadcastReceiver(iHub, this.options.getLogger());
            IntentFilter intentFilter = new IntentFilter();
            for (String addAction : this.actions) {
                intentFilter.addAction(addAction);
            }
            this.context.registerReceiver(this.receiver, intentFilter);
            sentryOptions.getLogger().log(SentryLevel.DEBUG, (String) "SystemEventsBreadcrumbsIntegration installed.", new Object[0]);
        }
    }

    public SystemEventsBreadcrumbsIntegration(Context context2, List<String> list) {
        this.context = (Context) Objects.requireNonNull(context2, "Context is required");
        this.actions = (List) Objects.requireNonNull(list, "Actions list is required");
    }
}
