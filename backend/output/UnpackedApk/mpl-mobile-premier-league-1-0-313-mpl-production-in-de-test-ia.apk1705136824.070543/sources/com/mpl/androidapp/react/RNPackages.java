package com.mpl.androidapp.react;

import com.facebook.react.LazyReactPackage;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.mpl.androidapp.imagepicker.ImagePickerModule;
import com.mpl.androidapp.login.LoginReactModule;
import com.mpl.androidapp.react.modules.ActivityLifeCycleModule;
import com.mpl.androidapp.react.modules.AddsModule;
import com.mpl.androidapp.react.modules.AnalyticsHelper;
import com.mpl.androidapp.react.modules.AppsflyerModule;
import com.mpl.androidapp.react.modules.AudioModule;
import com.mpl.androidapp.react.modules.ChatBotModule;
import com.mpl.androidapp.react.modules.ContactModule;
import com.mpl.androidapp.react.modules.DeviceInfoModule;
import com.mpl.androidapp.react.modules.FileDownloadHelperModule;
import com.mpl.androidapp.react.modules.FileHelperModule;
import com.mpl.androidapp.react.modules.FreshChatModule;
import com.mpl.androidapp.react.modules.GameBroadcastModule;
import com.mpl.androidapp.react.modules.GameLaunchHelper;
import com.mpl.androidapp.react.modules.GameLaunchModule;
import com.mpl.androidapp.react.modules.HanselModule;
import com.mpl.androidapp.react.modules.HaptikModule;
import com.mpl.androidapp.react.modules.IntentHelper;
import com.mpl.androidapp.react.modules.MqttModule;
import com.mpl.androidapp.react.modules.NetworkModule;
import com.mpl.androidapp.react.modules.NotificationDBModule;
import com.mpl.androidapp.react.modules.NotificationHelperModule;
import com.mpl.androidapp.react.modules.PaymentModule;
import com.mpl.androidapp.react.modules.PermissionsModule;
import com.mpl.androidapp.react.modules.RNImmersiveModule;
import com.mpl.androidapp.react.modules.ReactDebugHelperModule;
import com.mpl.androidapp.react.modules.ReadOtpModule;
import com.mpl.androidapp.react.modules.SendBirdModule;
import com.mpl.androidapp.react.modules.SharedPrefModule;
import com.mpl.androidapp.react.modules.SocialLoginModule;
import com.mpl.androidapp.react.modules.SocialShareModule;
import com.mpl.androidapp.react.modules.SpecialPermissionsModule;
import com.mpl.androidapp.react.modules.SponsorHelperModule;
import com.mpl.androidapp.react.modules.TrueCallerModule;
import java.util.Arrays;
import java.util.List;
import javax.inject.Provider;

public class RNPackages extends LazyReactPackage {
    public static /* synthetic */ NativeModule lambda$getNativeModules$0(ReactApplicationContext reactApplicationContext) {
        return new IntentHelper(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$1(ReactApplicationContext reactApplicationContext) {
        return new NetworkModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$10(ReactApplicationContext reactApplicationContext) {
        return new FileHelperModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$11(ReactApplicationContext reactApplicationContext) {
        return new SponsorHelperModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$12(ReactApplicationContext reactApplicationContext) {
        return new FileDownloadHelperModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$13(ReactApplicationContext reactApplicationContext) {
        return new HanselModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$14(ReactApplicationContext reactApplicationContext) {
        return new NotificationHelperModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$15(ReactApplicationContext reactApplicationContext) {
        return new ReactDebugHelperModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$16(ReactApplicationContext reactApplicationContext) {
        return new AudioModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$17(ReactApplicationContext reactApplicationContext) {
        return new AppsflyerModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$18(ReactApplicationContext reactApplicationContext) {
        return new AddsModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$19(ReactApplicationContext reactApplicationContext) {
        return new ChatBotModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$2(ReactApplicationContext reactApplicationContext) {
        return new SharedPrefModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$20(ReactApplicationContext reactApplicationContext) {
        return new ActivityLifeCycleModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$21(ReactApplicationContext reactApplicationContext) {
        return new ContactModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$22(ReactApplicationContext reactApplicationContext) {
        return new GameLaunchHelper(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$23(ReactApplicationContext reactApplicationContext) {
        return new SendBirdModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$24(ReactApplicationContext reactApplicationContext) {
        return new RNImmersiveModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$25(ReactApplicationContext reactApplicationContext) {
        return new FreshChatModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$26(ReactApplicationContext reactApplicationContext) {
        return new ImagePickerModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$27(ReactApplicationContext reactApplicationContext) {
        return new MqttModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$28(ReactApplicationContext reactApplicationContext) {
        return new GameBroadcastModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$29(ReactApplicationContext reactApplicationContext) {
        return new NotificationDBModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$3(ReactApplicationContext reactApplicationContext) {
        return new TrueCallerModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$30(ReactApplicationContext reactApplicationContext) {
        return new LoginReactModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$31(ReactApplicationContext reactApplicationContext) {
        return new SocialLoginModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$32(ReactApplicationContext reactApplicationContext) {
        return new HaptikModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$33(ReactApplicationContext reactApplicationContext) {
        return new SpecialPermissionsModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$34(ReactApplicationContext reactApplicationContext) {
        return new GameLaunchModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$4(ReactApplicationContext reactApplicationContext) {
        return new SocialShareModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$5(ReactApplicationContext reactApplicationContext) {
        return new PaymentModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$6(ReactApplicationContext reactApplicationContext) {
        return new DeviceInfoModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$7(ReactApplicationContext reactApplicationContext) {
        return new PermissionsModule(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$8(ReactApplicationContext reactApplicationContext) {
        return new AnalyticsHelper(reactApplicationContext);
    }

    public static /* synthetic */ NativeModule lambda$getNativeModules$9(ReactApplicationContext reactApplicationContext) {
        return new ReadOtpModule(reactApplicationContext);
    }

    public List<ModuleSpec> getNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ModuleSpec[]{ModuleSpec.nativeModuleSpec(IntentHelper.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$0(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(NetworkModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$1(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(SharedPrefModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$2(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(TrueCallerModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$3(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(SocialShareModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$4(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(PaymentModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$5(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(DeviceInfoModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$6(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(PermissionsModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$7(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(AnalyticsHelper.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$8(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(ReadOtpModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$9(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(FileHelperModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$10(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(SponsorHelperModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$11(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(FileDownloadHelperModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$12(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(HanselModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$13(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(NotificationHelperModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$14(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(ReactDebugHelperModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$15(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(AudioModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$16(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(AppsflyerModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$17(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(AddsModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$18(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(ChatBotModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$19(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(ActivityLifeCycleModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$20(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(ContactModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$21(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(GameLaunchHelper.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$22(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(SendBirdModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$23(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(RNImmersiveModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$24(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(FreshChatModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$25(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(ImagePickerModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$26(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(MqttModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$27(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(GameBroadcastModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$28(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(NotificationDBModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$29(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(LoginReactModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$30(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(SocialLoginModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$31(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(HaptikModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$32(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(SpecialPermissionsModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$33(ReactApplicationContext.this);
            }
        }), ModuleSpec.nativeModuleSpec(GameLaunchModule.class, (Provider<? extends NativeModule>) new Provider() {
            public final Object get() {
                return RNPackages.lambda$getNativeModules$34(ReactApplicationContext.this);
            }
        })});
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return LazyReactPackage.getReactModuleInfoProviderViaReflection(this);
    }
}
