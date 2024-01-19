package com.facebook.react.shell;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.CameraRollManager;
import com.facebook.react.modules.camera.ImageEditingManager;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.sound.SoundManagerModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.storage.AsyncStorageModule;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.art.ARTRenderableViewManager;
import com.facebook.react.views.art.ARTSurfaceViewManager;
import com.facebook.react.views.checkbox.ReactCheckBoxManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.picker.ReactDialogPickerManager;
import com.facebook.react.views.picker.ReactDropdownPickerManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.viewpager.ReactViewPagerManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainReactPackage extends TurboReactPackage {
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ARTRenderableViewManager.createARTGroupViewManager());
        arrayList.add(ARTRenderableViewManager.createARTShapeViewManager());
        arrayList.add(ARTRenderableViewManager.createARTTextViewManager());
        arrayList.add(new ReactCheckBoxManager());
        arrayList.add(new ReactDialogPickerManager());
        arrayList.add(new ReactDrawerLayoutManager());
        arrayList.add(new ReactDropdownPickerManager());
        arrayList.add(new ReactHorizontalScrollViewManager());
        arrayList.add(new ReactHorizontalScrollContainerViewManager());
        arrayList.add(new ReactProgressBarViewManager());
        arrayList.add(new ReactScrollViewManager());
        arrayList.add(new ReactSliderManager());
        arrayList.add(new ReactSwitchManager());
        arrayList.add(new SwipeRefreshLayoutManager());
        arrayList.add(new ARTSurfaceViewManager());
        arrayList.add(new FrescoBasedReactTextInlineImageViewManager());
        arrayList.add(new ReactImageManager());
        arrayList.add(new ReactModalHostManager());
        arrayList.add(new ReactRawTextManager());
        arrayList.add(new ReactTextInputManager());
        arrayList.add(new ReactTextViewManager());
        arrayList.add(new ReactViewManager());
        arrayList.add(new ReactViewPagerManager());
        arrayList.add(new ReactVirtualTextViewManager());
        return arrayList;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.NativeModule getModule(java.lang.String r3, com.facebook.react.bridge.ReactApplicationContext r4) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 1
            switch(r0) {
                case -2115067288: goto L_0x0125;
                case -2033388651: goto L_0x011b;
                case -1962922905: goto L_0x0110;
                case -1850625090: goto L_0x0105;
                case -1654566518: goto L_0x00fa;
                case -1505215509: goto L_0x00f0;
                case -1399423980: goto L_0x00e5;
                case -1344126773: goto L_0x00db;
                case -1062061717: goto L_0x00d0;
                case -657277650: goto L_0x00c5;
                case -570370161: goto L_0x00b9;
                case -504784764: goto L_0x00ae;
                case -457866500: goto L_0x00a3;
                case -382654004: goto L_0x0097;
                case -254310125: goto L_0x008b;
                case 163245714: goto L_0x007f;
                case 174691539: goto L_0x0073;
                case 283572496: goto L_0x0067;
                case 403570038: goto L_0x005c;
                case 563961875: goto L_0x0050;
                case 1221389072: goto L_0x0045;
                case 1515242260: goto L_0x0039;
                case 1547941001: goto L_0x002e;
                case 1555425035: goto L_0x0022;
                case 1721274886: goto L_0x0016;
                case 1922110066: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0130
        L_0x000a:
            java.lang.String r0 = "Vibration"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 24
            goto L_0x0131
        L_0x0016:
            java.lang.String r0 = "NativeAnimatedModule"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 16
            goto L_0x0131
        L_0x0022:
            java.lang.String r0 = "ShareModule"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 19
            goto L_0x0131
        L_0x002e:
            java.lang.String r0 = "BlobModule"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 3
            goto L_0x0131
        L_0x0039:
            java.lang.String r0 = "Networking"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 17
            goto L_0x0131
        L_0x0045:
            java.lang.String r0 = "AppState"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 2
            goto L_0x0131
        L_0x0050:
            java.lang.String r0 = "IntentAndroid"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 15
            goto L_0x0131
        L_0x005c:
            java.lang.String r0 = "Clipboard"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 7
            goto L_0x0131
        L_0x0067:
            java.lang.String r0 = "ImageEditingManager"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 12
            goto L_0x0131
        L_0x0073:
            java.lang.String r0 = "DatePickerAndroid"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 8
            goto L_0x0131
        L_0x007f:
            java.lang.String r0 = "FrescoModule"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 10
            goto L_0x0131
        L_0x008b:
            java.lang.String r0 = "WebSocketModule"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 25
            goto L_0x0131
        L_0x0097:
            java.lang.String r0 = "StatusBarManager"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 20
            goto L_0x0131
        L_0x00a3:
            java.lang.String r0 = "AccessibilityInfo"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 0
            goto L_0x0131
        L_0x00ae:
            java.lang.String r0 = "Appearance"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 1
            goto L_0x0131
        L_0x00b9:
            java.lang.String r0 = "I18nManager"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 11
            goto L_0x0131
        L_0x00c5:
            java.lang.String r0 = "ImageLoader"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 13
            goto L_0x0131
        L_0x00d0:
            java.lang.String r0 = "PermissionsAndroid"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 18
            goto L_0x0131
        L_0x00db:
            java.lang.String r0 = "FileReaderModule"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 4
            goto L_0x0131
        L_0x00e5:
            java.lang.String r0 = "TimePickerAndroid"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 22
            goto L_0x0131
        L_0x00f0:
            java.lang.String r0 = "CameraRollManager"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 6
            goto L_0x0131
        L_0x00fa:
            java.lang.String r0 = "DialogManagerAndroid"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 9
            goto L_0x0131
        L_0x0105:
            java.lang.String r0 = "SoundManager"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 21
            goto L_0x0131
        L_0x0110:
            java.lang.String r0 = "ImageStoreManager"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 14
            goto L_0x0131
        L_0x011b:
            java.lang.String r0 = "AsyncSQLiteDBStorage"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 5
            goto L_0x0131
        L_0x0125:
            java.lang.String r0 = "ToastAndroid"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0130
            r3 = 23
            goto L_0x0131
        L_0x0130:
            r3 = -1
        L_0x0131:
            r0 = 0
            switch(r3) {
                case 0: goto L_0x01cc;
                case 1: goto L_0x01c6;
                case 2: goto L_0x01c0;
                case 3: goto L_0x01ba;
                case 4: goto L_0x01b4;
                case 5: goto L_0x01ae;
                case 6: goto L_0x01a8;
                case 7: goto L_0x01a2;
                case 8: goto L_0x019c;
                case 9: goto L_0x0196;
                case 10: goto L_0x0190;
                case 11: goto L_0x018a;
                case 12: goto L_0x0184;
                case 13: goto L_0x017e;
                case 14: goto L_0x0178;
                case 15: goto L_0x0172;
                case 16: goto L_0x016c;
                case 17: goto L_0x0166;
                case 18: goto L_0x0160;
                case 19: goto L_0x015a;
                case 20: goto L_0x0154;
                case 21: goto L_0x014e;
                case 22: goto L_0x0148;
                case 23: goto L_0x0142;
                case 24: goto L_0x013c;
                case 25: goto L_0x0136;
                default: goto L_0x0135;
            }
        L_0x0135:
            return r0
        L_0x0136:
            com.facebook.react.modules.websocket.WebSocketModule r3 = new com.facebook.react.modules.websocket.WebSocketModule
            r3.<init>(r4)
            return r3
        L_0x013c:
            com.facebook.react.modules.vibration.VibrationModule r3 = new com.facebook.react.modules.vibration.VibrationModule
            r3.<init>(r4)
            return r3
        L_0x0142:
            com.facebook.react.modules.toast.ToastModule r3 = new com.facebook.react.modules.toast.ToastModule
            r3.<init>(r4)
            return r3
        L_0x0148:
            com.facebook.react.modules.timepicker.TimePickerDialogModule r3 = new com.facebook.react.modules.timepicker.TimePickerDialogModule
            r3.<init>(r4)
            return r3
        L_0x014e:
            com.facebook.react.modules.sound.SoundManagerModule r3 = new com.facebook.react.modules.sound.SoundManagerModule
            r3.<init>(r4)
            return r3
        L_0x0154:
            com.facebook.react.modules.statusbar.StatusBarModule r3 = new com.facebook.react.modules.statusbar.StatusBarModule
            r3.<init>(r4)
            return r3
        L_0x015a:
            com.facebook.react.modules.share.ShareModule r3 = new com.facebook.react.modules.share.ShareModule
            r3.<init>(r4)
            return r3
        L_0x0160:
            com.facebook.react.modules.permissions.PermissionsModule r3 = new com.facebook.react.modules.permissions.PermissionsModule
            r3.<init>(r4)
            return r3
        L_0x0166:
            com.facebook.react.modules.network.NetworkingModule r3 = new com.facebook.react.modules.network.NetworkingModule
            r3.<init>(r4)
            return r3
        L_0x016c:
            com.facebook.react.animated.NativeAnimatedModule r3 = new com.facebook.react.animated.NativeAnimatedModule
            r3.<init>(r4)
            return r3
        L_0x0172:
            com.facebook.react.modules.intent.IntentModule r3 = new com.facebook.react.modules.intent.IntentModule
            r3.<init>(r4)
            return r3
        L_0x0178:
            com.facebook.react.modules.camera.ImageStoreManager r3 = new com.facebook.react.modules.camera.ImageStoreManager
            r3.<init>(r4)
            return r3
        L_0x017e:
            com.facebook.react.modules.image.ImageLoaderModule r3 = new com.facebook.react.modules.image.ImageLoaderModule
            r3.<init>(r4)
            return r3
        L_0x0184:
            com.facebook.react.modules.camera.ImageEditingManager r3 = new com.facebook.react.modules.camera.ImageEditingManager
            r3.<init>(r4)
            return r3
        L_0x018a:
            com.facebook.react.modules.i18nmanager.I18nManagerModule r3 = new com.facebook.react.modules.i18nmanager.I18nManagerModule
            r3.<init>(r4)
            return r3
        L_0x0190:
            com.facebook.react.modules.fresco.FrescoModule r3 = new com.facebook.react.modules.fresco.FrescoModule
            r3.<init>(r4, r1, r0)
            return r3
        L_0x0196:
            com.facebook.react.modules.dialog.DialogModule r3 = new com.facebook.react.modules.dialog.DialogModule
            r3.<init>(r4)
            return r3
        L_0x019c:
            com.facebook.react.modules.datepicker.DatePickerDialogModule r3 = new com.facebook.react.modules.datepicker.DatePickerDialogModule
            r3.<init>(r4)
            return r3
        L_0x01a2:
            com.facebook.react.modules.clipboard.ClipboardModule r3 = new com.facebook.react.modules.clipboard.ClipboardModule
            r3.<init>(r4)
            return r3
        L_0x01a8:
            com.facebook.react.modules.camera.CameraRollManager r3 = new com.facebook.react.modules.camera.CameraRollManager
            r3.<init>(r4)
            return r3
        L_0x01ae:
            com.facebook.react.modules.storage.AsyncStorageModule r3 = new com.facebook.react.modules.storage.AsyncStorageModule
            r3.<init>(r4)
            return r3
        L_0x01b4:
            com.facebook.react.modules.blob.FileReaderModule r3 = new com.facebook.react.modules.blob.FileReaderModule
            r3.<init>(r4)
            return r3
        L_0x01ba:
            com.facebook.react.modules.blob.BlobModule r3 = new com.facebook.react.modules.blob.BlobModule
            r3.<init>(r4)
            return r3
        L_0x01c0:
            com.facebook.react.modules.appstate.AppStateModule r3 = new com.facebook.react.modules.appstate.AppStateModule
            r3.<init>(r4)
            return r3
        L_0x01c6:
            com.facebook.react.modules.appearance.AppearanceModule r3 = new com.facebook.react.modules.appearance.AppearanceModule
            r3.<init>(r4)
            return r3
        L_0x01cc:
            com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule r3 = new com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule
            r3.<init>(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.shell.MainReactPackage.getModule(java.lang.String, com.facebook.react.bridge.ReactApplicationContext):com.facebook.react.bridge.NativeModule");
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.facebook.react.shell.MainReactPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            Class[] clsArr = {AccessibilityInfoModule.class, AppearanceModule.class, AppStateModule.class, BlobModule.class, FileReaderModule.class, AsyncStorageModule.class, CameraRollManager.class, ClipboardModule.class, DatePickerDialogModule.class, DialogModule.class, FrescoModule.class, I18nManagerModule.class, ImageEditingManager.class, ImageLoaderModule.class, ImageStoreManager.class, IntentModule.class, NativeAnimatedModule.class, NetworkingModule.class, PermissionsModule.class, ShareModule.class, StatusBarModule.class, SoundManagerModule.class, TimePickerDialogModule.class, ToastModule.class, VibrationModule.class, WebSocketModule.class};
            final HashMap hashMap = new HashMap();
            for (int i = 0; i < 26; i++) {
                Class cls = clsArr[i];
                ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                String name = reactModule.name();
                ReactModuleInfo reactModuleInfo = new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), TurboModule.class.isAssignableFrom(cls));
                hashMap.put(name, reactModuleInfo);
            }
            return new ReactModuleInfoProvider(this) {
                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    return hashMap;
                }
            };
        } catch (InstantiationException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e3);
        }
    }
}
