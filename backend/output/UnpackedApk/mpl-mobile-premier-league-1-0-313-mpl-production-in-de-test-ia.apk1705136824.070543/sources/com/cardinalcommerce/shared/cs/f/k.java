package com.cardinalcommerce.shared.cs.f;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.cardinalcommerce.shared.cs.utils.h;
import org.json.JSONObject;

public class k {
    public char[] A;
    public char[] B;
    public char[] C;
    public char[] D;
    public int E;
    public int F;
    public char[] G;
    public int H;
    public int I;
    public int J;
    public char[] K;
    public char[] L;
    public int M;
    public char[] N;
    public char[] O;
    public char[] P;
    public int Q;
    public int R;
    public char[] S;
    public int T;
    public char[] U;
    public int V;
    public int W;
    public char[] X;
    public int Y;
    public char[] Z;

    /* renamed from: a  reason: collision with root package name */
    public int f2152a;
    public char[] aa;
    public int ab;
    public char[] ac;
    public int ad;
    public int ae;
    public int af;
    public int ag;

    /* renamed from: b  reason: collision with root package name */
    public int f2153b;

    /* renamed from: c  reason: collision with root package name */
    public int f2154c;

    /* renamed from: d  reason: collision with root package name */
    public int f2155d;

    /* renamed from: e  reason: collision with root package name */
    public char[] f2156e;

    /* renamed from: f  reason: collision with root package name */
    public int f2157f;
    public char[] g;
    public char[] h;
    public char[] i;
    public char[] j;
    public char[] k;
    public char[] l;
    public char[] m;
    public char[] n;
    public char[] o;
    public char[] p;
    public int q;
    public int r;
    public int s;
    public char[] t;
    public char[] u;
    public char[] v;
    public int w;
    public char[] x;
    public char[] y;
    public char[] z;

    @SuppressLint({"HardwareIds"})
    public k(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        this.f2152a = System.getInt(context.getContentResolver(), "accelerometer_rotation", -1);
        this.f2153b = System.getInt(context.getContentResolver(), "bluetooth_discoverability", 0);
        this.f2154c = System.getInt(context.getContentResolver(), "bluetooth_discoverability_timeout", 0);
        this.f2155d = System.getInt(context.getContentResolver(), "date_format", 0);
        if (VERSION.SDK_INT >= 23) {
            this.y = h.a(System.getString(context.getContentResolver(), "dtmf_tone_type"));
        }
        this.f2156e = h.a(System.getString(context.getContentResolver(), "dtmf_tone"));
        this.f2157f = System.getInt(context.getContentResolver(), "end_button_behavior", 0);
        this.g = h.a(System.getString(context.getContentResolver(), "font_scale"));
        this.h = h.a(System.getString(context.getContentResolver(), "haptic_feedback_enabled"));
        this.i = h.a(System.getString(context.getContentResolver(), "mode_ringer_streams_affected"));
        this.j = h.a(System.getString(context.getContentResolver(), "notification_sound"));
        this.k = h.a(System.getString(context.getContentResolver(), "mute_streams_affected"));
        this.l = h.a(System.getString(context.getContentResolver(), "ringtone"));
        this.m = h.a(System.getString(context.getContentResolver(), "screen_brightness"));
        this.n = h.a(System.getString(context.getContentResolver(), "screen_brightness_mode"));
        this.o = h.a(System.getString(context.getContentResolver(), "screen_off_timeout"));
        this.p = h.a(System.getString(context.getContentResolver(), "sound_effects_enabled"));
        this.q = System.getInt(context.getContentResolver(), "auto_caps", 0);
        this.r = System.getInt(context.getContentResolver(), "auto_punctuate", -1);
        this.s = System.getInt(context.getContentResolver(), "auto_replace", 0);
        this.t = h.a(System.getString(context.getContentResolver(), "show_password"));
        this.u = h.a(System.getString(context.getContentResolver(), "time_12_24"));
        this.v = h.a(System.getString(context.getContentResolver(), "user_rotation"));
        this.w = System.getInt(context.getContentResolver(), "vibrate_on", 0);
        if (VERSION.SDK_INT >= 23) {
            this.x = h.a(System.getString(context.getContentResolver(), "vibrate_when_ringing"));
        }
        this.K = h.a(Global.getString(contentResolver, "adb_enabled"));
        this.L = h.a(Global.getString(contentResolver, "airplane_mode_radios"));
        this.M = Global.getInt(contentResolver, "always_finish_activities", 0);
        this.Y = Global.getInt(contentResolver, "animator_duration_scale", 1);
        this.N = h.a(Global.getString(contentResolver, "auto_time"));
        this.O = h.a(Global.getString(contentResolver, "auto_time_zone"));
        this.P = h.a(Global.getString(contentResolver, "development_settings_enabled"));
        this.Q = Global.getInt(contentResolver, "http_proxy", 0);
        this.R = Global.getInt(contentResolver, "network_preference", 0);
        this.S = h.a(Global.getString(contentResolver, "stay_on_while_plugged_in"));
        this.T = Global.getInt(contentResolver, "transition_animation_scale", 0);
        this.U = h.a(Global.getString(contentResolver, "usb_mass_storage_enabled"));
        this.V = Global.getInt(contentResolver, "use_google_mail", 0);
        this.W = Global.getInt(contentResolver, "wait_for_debugger", 0);
        this.X = h.a(Global.getString(contentResolver, "wifi_networks_available_notification_on"));
        this.z = h.a(Secure.getString(contentResolver, "accessibility_enabled"));
        this.A = h.a(Secure.getString(contentResolver, "speak_password"));
        this.B = h.a(Secure.getString(contentResolver, "allowed_geolocation_origins"));
        this.C = h.a(Secure.getString(contentResolver, "android_id"));
        this.D = h.a(Secure.getString(contentResolver, "default_input_method"));
        this.F = Secure.getInt(contentResolver, "enabled_input_methods", 0);
        this.E = Secure.getInt(contentResolver, "input_method_selector_visibility", 0);
        this.G = h.a(Secure.getString(contentResolver, "install_non_market_apps"));
        this.ag = Secure.getInt(contentResolver, "location_mode", 0);
        this.af = Secure.getInt(contentResolver, "accessibility_display_inversion_enabled", 0);
        this.ae = Secure.getInt(contentResolver, "enabled_accessibility_services", 0);
        this.ad = Secure.getInt(contentResolver, "skip_first_use_hints", 0);
        this.ac = null;
        this.ab = Secure.getInt(contentResolver, "tts_default_pitch", 0);
        this.H = Secure.getInt(contentResolver, "tts_default_rate", 0);
        this.I = Secure.getInt(contentResolver, "tts_default_synth", 0);
        this.J = Secure.getInt(contentResolver, "tts_enabled_plugins", 0);
        this.Z = h.a(Global.getString(contentResolver, "data_roaming"));
        this.aa = h.a(Secure.getString(contentResolver, "device_provisioned"));
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("AccelerometerRotation", Integer.valueOf(this.f2152a));
        jSONObject.putOpt("BluetoothDiscoverability", Integer.valueOf(this.f2153b));
        jSONObject.putOpt("BluetoothDiscoverabilityTimeout", Integer.valueOf(this.f2154c));
        jSONObject.putOpt("DateFormat", String.valueOf(this.f2155d));
        jSONObject.putOpt("DtmfToneWhenDialing", h.b(this.f2156e));
        jSONObject.putOpt("EndButtonBehavior", String.valueOf(this.f2157f));
        jSONObject.putOpt("FontScale", h.b(this.g));
        jSONObject.putOpt("HapticFeedbackEnabled", h.b(this.h));
        jSONObject.putOpt("ModeRingerStreamsAffected", h.b(this.i));
        jSONObject.putOpt("NotificationSound", h.b(this.j));
        jSONObject.putOpt("MuteStreamsAffected", h.b(this.k));
        jSONObject.putOpt("Ringtone", h.b(this.l));
        jSONObject.putOpt("ScreenBrightness", h.b(this.m));
        jSONObject.putOpt("ScreenBrightnessMode", h.b(this.n));
        jSONObject.putOpt("ScreenOffTimeout", h.b(this.o));
        jSONObject.putOpt("SoundEffectsEnabled", h.b(this.p));
        jSONObject.putOpt("TextAutoCaps", String.valueOf(this.q));
        jSONObject.putOpt("TextAutoPunctuate", Integer.valueOf(this.r));
        jSONObject.putOpt("TextAutoReplace", String.valueOf(this.s));
        jSONObject.putOpt("TextShowPassword", h.b(this.t));
        jSONObject.putOpt("Time1224", h.b(this.u));
        jSONObject.putOpt("UserRotation", h.b(this.v));
        jSONObject.putOpt("VibrateOn", String.valueOf(this.w));
        jSONObject.putOpt("VibrateWhenRinging", h.b(this.x));
        jSONObject.putOpt("DtmfToneTypeWhenDialing", h.b(this.y));
        jSONObject.putOpt("AccessibilityEnabled", h.b(this.z));
        jSONObject.putOpt("AccessibilitySpeakPassword", h.b(this.A));
        jSONObject.putOpt("AllowedGeolocationOrigins", h.b(this.B));
        jSONObject.putOpt("AndroidId", h.b(this.C));
        jSONObject.putOpt("DefaultInputMethod", h.b(this.D));
        jSONObject.putOpt("InputMethodSelectorVisibility", String.valueOf(this.E));
        jSONObject.putOpt("EnabledInputMethods", String.valueOf(this.F));
        jSONObject.putOpt("InstallNonMarketApps", h.b(this.G));
        jSONObject.putOpt("TtsDefaultRate", String.valueOf(this.H));
        jSONObject.putOpt("TtsDefaultSynth", String.valueOf(this.I));
        jSONObject.putOpt("TtsEnabledPlugins", String.valueOf(this.J));
        jSONObject.putOpt("AdbEnabled", h.b(this.K));
        jSONObject.putOpt("AirplaneModeRadios", h.b(this.L));
        jSONObject.putOpt("AlwaysFinishActivities", String.valueOf(this.M));
        jSONObject.putOpt("AutoTime", h.b(this.N));
        jSONObject.putOpt("AutoTimeZone", h.b(this.O));
        jSONObject.putOpt("DevelopmentSettingsEnabled", h.b(this.P));
        jSONObject.putOpt("HttpProxy", String.valueOf(this.Q));
        jSONObject.putOpt("NetworkPreference", String.valueOf(this.R));
        jSONObject.putOpt("StayOnWhilePluggedIn", h.b(this.S));
        jSONObject.putOpt("TransitionAnimationScale", Integer.valueOf(this.T));
        jSONObject.putOpt("UsbMassStorageEnabled", h.b(this.U));
        jSONObject.putOpt("UseGoogleMail", String.valueOf(this.V));
        jSONObject.putOpt("WaitForDebugger", String.valueOf(this.W));
        jSONObject.putOpt("WifiNetworksAvailableNotificationOn", h.b(this.X));
        jSONObject.putOpt("AnimatorDurationScale", String.valueOf(this.Y));
        jSONObject.putOpt("DataRoaming", h.b(this.Z));
        jSONObject.putOpt("DeviceProvisioned", h.b(this.aa));
        jSONObject.putOpt("TtsDefaultPitch", String.valueOf(this.ab));
        jSONObject.putOpt("SysPropSettingVersion", h.b(this.ac));
        jSONObject.putOpt("SkipFirstUseHints", String.valueOf(this.ad));
        jSONObject.putOpt("EnabledAccessibilityServices", String.valueOf(this.ae));
        jSONObject.putOpt("AccessibilityDisplayInversionEnabled", String.valueOf(this.af));
        jSONObject.putOpt("LocationMode", String.valueOf(this.ag));
        return jSONObject;
    }
}
