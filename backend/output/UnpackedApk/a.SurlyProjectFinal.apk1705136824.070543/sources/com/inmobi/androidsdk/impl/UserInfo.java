package com.inmobi.androidsdk.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdRequest.EducationType;
import com.inmobi.androidsdk.IMAdRequest.EthnicityType;
import com.inmobi.androidsdk.IMAdRequest.GenderType;
import com.inmobi.androidsdk.ai.controller.util.Utils;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public final class UserInfo {
    private String ODINId;
    private String adUnitSlot = null;
    private String appBId;
    private String appDisplayName;
    private String appVer;
    private Context applicationContext;
    private String deviceBTHW;
    private String deviceMachineHW;
    private String deviceModel;
    private String deviceName;
    private String deviceStorageSize;
    private String deviceSystemName;
    private String deviceSystemVersion;
    private long lastLocationUpdateDT = 0;
    private double lat;
    private double locAccuracy;
    private String localization;
    boolean locationDeniedByUser;
    private LocationManager locationManager;
    boolean locationMethodImplemented;
    private boolean loctionEngineSwitchedON;
    private double lon;
    private String mAndroidId;
    private IMAdRequest mIMAdRequest;
    private int mOrientation;
    private String networkType;
    private String phoneDefaultUserAgent;
    private String randomKey;
    private Random randomObject;
    private String refTagKey = null;
    private String refTagValue = null;
    private String rsakeyVersion = "1";
    private String screenDensity = null;
    private String screenSize = null;
    private String siteId;
    private String testModeAdActionType;
    private String uIdMapEncrypted;
    private boolean validGeoInfo;

    public UserInfo(Context appct) {
        this.applicationContext = appct;
        this.randomObject = new Random();
    }

    /* access modifiers changed from: 0000 */
    public Context getApplicationContext() {
        return this.applicationContext;
    }

    /* access modifiers changed from: 0000 */
    public void setApplicationContext(Context applicationContext2) {
        this.applicationContext = applicationContext2;
    }

    public String getAppBId() {
        return this.appBId;
    }

    /* access modifiers changed from: 0000 */
    public void setAppBId(String appBId2) {
        this.appBId = appBId2;
    }

    public String getAppDisplayName() {
        return this.appDisplayName;
    }

    /* access modifiers changed from: 0000 */
    public void setAppDisplayName(String appDisplayName2) {
        this.appDisplayName = appDisplayName2;
    }

    public void setIMAdRequest(IMAdRequest mIMAdRequest2) {
        this.mIMAdRequest = mIMAdRequest2;
    }

    public String getAppVer() {
        return this.appVer;
    }

    /* access modifiers changed from: 0000 */
    public void setAppVer(String appVer2) {
        this.appVer = appVer2;
    }

    public String getNetworkType() {
        return this.networkType;
    }

    /* access modifiers changed from: 0000 */
    public void setNetworkType(String networkType2) {
        this.networkType = networkType2;
    }

    private String getODINId() {
        return this.ODINId;
    }

    public String getRandomKey() {
        return this.randomKey;
    }

    public String getUIDMapEncrypted() {
        return this.uIdMapEncrypted;
    }

    public String getRsakeyVersion() {
        return this.rsakeyVersion;
    }

    /* access modifiers changed from: 0000 */
    public void setODINId(String ODINid) {
        this.ODINId = ODINid;
    }

    /* access modifiers changed from: 0000 */
    public void setRandomKey(int randomkey) {
        this.randomKey = Integer.toString(randomkey);
    }

    /* access modifiers changed from: 0000 */
    public void setUIDMapEncrypted(String uIdMapencrypted) {
        this.uIdMapEncrypted = uIdMapencrypted;
    }

    public String getLocalization() {
        return this.localization;
    }

    /* access modifiers changed from: 0000 */
    public void setLocalization(String localization2) {
        this.localization = localization2;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    /* access modifiers changed from: 0000 */
    public void setDeviceName(String deviceName2) {
        this.deviceName = deviceName2;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    /* access modifiers changed from: 0000 */
    public void setDeviceModel(String deviceModel2) {
        this.deviceModel = deviceModel2;
    }

    public String getDeviceSystemName() {
        return this.deviceSystemName;
    }

    /* access modifiers changed from: 0000 */
    public void setDeviceSystemName(String deviceSystemName2) {
        this.deviceSystemName = deviceSystemName2;
    }

    public String getDeviceSystemVersion() {
        return this.deviceSystemVersion;
    }

    /* access modifiers changed from: 0000 */
    public void setDeviceSystemVersion(String deviceSystemVersion2) {
        this.deviceSystemVersion = deviceSystemVersion2;
    }

    public Map<String, String> getRequestParams() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getRequestParams();
        }
        return null;
    }

    public String getUserAgent() {
        return "inmobi_androidsdk=3.5.0";
    }

    /* access modifiers changed from: 0000 */
    public void setUserAgent(String userAgent) {
    }

    public String getDeviceStorageSize() {
        return this.deviceStorageSize;
    }

    /* access modifiers changed from: 0000 */
    public void setDeviceStorageSize(String deviceStorageSize2) {
        this.deviceStorageSize = deviceStorageSize2;
    }

    public String getDeviceMachineHW() {
        return this.deviceMachineHW;
    }

    /* access modifiers changed from: 0000 */
    public void setDeviceMachineHW(String deviceMachineHW2) {
        this.deviceMachineHW = deviceMachineHW2;
    }

    public void setDeviceBTHW(String deviceBTHW2) {
        this.deviceBTHW = deviceBTHW2;
    }

    public String getDeviceBTHW() {
        return this.deviceBTHW;
    }

    public String getSiteId() {
        return this.siteId;
    }

    /* access modifiers changed from: 0000 */
    public void setSiteId(String siteId2) {
        this.siteId = siteId2;
    }

    public String getPostalCode() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getPostalCode();
        }
        return null;
    }

    public String getAreaCode() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getAreaCode();
        }
        return null;
    }

    public String getDateOfBirth() {
        if (this.mIMAdRequest == null) {
            return null;
        }
        if (this.mIMAdRequest.getDateOfBirth() == null) {
            return null;
        }
        Calendar cald = Calendar.getInstance();
        cald.setTimeInMillis(this.mIMAdRequest.getDateOfBirth().getTime());
        return String.valueOf(cald.get(1)) + "-" + (cald.get(2) + 1) + "-" + cald.get(5);
    }

    public GenderType getGender() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getGender();
        }
        return null;
    }

    public String getKeywords() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getKeywords();
        }
        return null;
    }

    public String getSearchString() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getSearchString();
        }
        return null;
    }

    public int getIncome() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getIncome();
        }
        return 0;
    }

    public EducationType getEducation() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getEducation();
        }
        return null;
    }

    public EthnicityType getEthnicity() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getEthnicity();
        }
        return null;
    }

    public String getLocationWithCityStateCountry() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getLocationWithCityStateCountry();
        }
        return null;
    }

    public int getAge() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getAge();
        }
        return 0;
    }

    public String getInterests() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.getInterests();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public synchronized LocationManager getLocationManager() {
        return this.locationManager;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void setLocationManager(LocationManager locationManager2) {
        this.locationManager = locationManager2;
    }

    /* access modifiers changed from: 0000 */
    public boolean isLocationInquiryAllowed() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.isLocationInquiryAllowed();
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean isLocationMethodImplemented() {
        return this.locationMethodImplemented;
    }

    /* access modifiers changed from: 0000 */
    public void setLocationMethodImplemented(boolean locationMethodImplemented2) {
        this.locationMethodImplemented = locationMethodImplemented2;
    }

    /* access modifiers changed from: 0000 */
    public boolean isLocationDeniedByUser() {
        return this.locationDeniedByUser;
    }

    /* access modifiers changed from: 0000 */
    public void setLocationDeniedByUser(boolean locationDeniedByUser2) {
        this.locationDeniedByUser = locationDeniedByUser2;
    }

    public double getLat() {
        return this.lat;
    }

    /* access modifiers changed from: 0000 */
    public void setLat(double lat2) {
        this.lat = lat2;
    }

    public double getLon() {
        return this.lon;
    }

    /* access modifiers changed from: 0000 */
    public void setLon(double lon2) {
        this.lon = lon2;
    }

    public double getLocAccuracy() {
        return this.locAccuracy;
    }

    /* access modifiers changed from: 0000 */
    public void setLocAccuracy(double locAccuracy2) {
        this.locAccuracy = locAccuracy2;
    }

    public boolean isValidGeoInfo() {
        return this.validGeoInfo;
    }

    public void setValidGeoInfo(boolean validGeoInfo2) {
        this.validGeoInfo = validGeoInfo2;
    }

    /* access modifiers changed from: 0000 */
    public long getLastLocationUpdateDT() {
        return this.lastLocationUpdateDT;
    }

    /* access modifiers changed from: 0000 */
    public void setLastLocationUpdateDT(long lastLocationUpdateDT2) {
        this.lastLocationUpdateDT = lastLocationUpdateDT2;
    }

    /* access modifiers changed from: 0000 */
    public boolean isLoctionEngineSwitchedON() {
        return this.loctionEngineSwitchedON;
    }

    /* access modifiers changed from: 0000 */
    public void setLoctionEngineSwitchedON(boolean loctionEngineSwitchedON2) {
        this.loctionEngineSwitchedON = loctionEngineSwitchedON2;
    }

    public boolean isTestMode() {
        if (this.mIMAdRequest != null) {
            return this.mIMAdRequest.isTestMode();
        }
        return false;
    }

    public String getTestModeAdActionType() {
        return this.testModeAdActionType;
    }

    /* access modifiers changed from: 0000 */
    public void setTestModeAdActionType(String testModeAdActionType2) {
        this.testModeAdActionType = testModeAdActionType2;
    }

    public String getPhoneDefaultUserAgent() {
        if (this.phoneDefaultUserAgent == null) {
            return Constants.QA_SERVER_URL;
        }
        return this.phoneDefaultUserAgent;
    }

    public synchronized void updateInfo(String siteId2, IMAdRequest imAdRequest) {
        setIMAdRequest(imAdRequest);
        fillDeviceInfo();
        setSiteId(siteId2);
        if (imAdRequest != null) {
            setValidGeoInfo(false);
            if (!isLocationInquiryAllowed()) {
                setLocationDeniedByUser(true);
            } else if (imAdRequest.getCurrentLocation() != null) {
                fillLocationInfo(imAdRequest.getCurrentLocation());
                setValidGeoInfo(true);
            } else {
                verifyLocationPermission();
                if (!isLocationDeniedByUser()) {
                    updateBestKnownLocation();
                }
            }
        }
    }

    private synchronized void updateBestKnownLocation() {
        try {
            if (getLocationManager() == null) {
                setLocationManager((LocationManager) getApplicationContext().getSystemService("location"));
            }
            if (getLocationManager() != null) {
                LocationManager locManager = getLocationManager();
                Criteria criteria = new Criteria();
                if (getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                    criteria.setAccuracy(1);
                } else if (getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    criteria.setAccuracy(2);
                }
                criteria.setCostAllowed(false);
                String provider = locManager.getBestProvider(criteria, true);
                if (!isValidGeoInfo() && provider != null) {
                    Location location = locManager.getLastKnownLocation(provider);
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "lastBestKnownLocation: " + location);
                    }
                    if (location == null) {
                        location = getLastKnownLocation();
                        if (Constants.DEBUG) {
                            Log.d(Constants.LOGGING_TAG, "lastKnownLocation: " + location);
                        }
                    }
                    fillLocationInfo(location);
                }
            }
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.w(Constants.LOGGING_TAG, "Error getting the Location Info", e);
            }
        }
    }

    private Location getLastKnownLocation() {
        if (getLocationManager() == null) {
            setLocationManager((LocationManager) getApplicationContext().getSystemService("location"));
        }
        if (getLocationManager() != null) {
            LocationManager locManager = getLocationManager();
            List<String> providers = locManager.getProviders(true);
            for (int i = providers.size() - 1; i >= 0; i--) {
                String provider = providers.get(i);
                if (locManager.isProviderEnabled(provider)) {
                    Location location = locManager.getLastKnownLocation(provider);
                    if (location != null) {
                        return location;
                    }
                }
            }
        }
        return null;
    }

    private void fillLocationInfo(Location newLocation) {
        if (newLocation != null) {
            setValidGeoInfo(true);
            setLat(newLocation.getLatitude());
            setLon(newLocation.getLongitude());
            setLocAccuracy((double) newLocation.getAccuracy());
            setLastLocationUpdateDT(newLocation.getTime());
        }
    }

    private void verifyLocationPermission() {
        int coarseLocationAccessPermission = getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
        int fineLocationAccessPermission = getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        if (coarseLocationAccessPermission == 0 || fineLocationAccessPermission == 0) {
            setLocationDeniedByUser(false);
        } else {
            setLocationDeniedByUser(true);
        }
    }

    private void fillDeviceInfo() {
        String str;
        String str2;
        if (getDeviceName() == null) {
            setDeviceName(Build.BRAND);
            setDeviceModel(Build.MODEL);
            if (TextUtils.isEmpty(Build.ID.trim())) {
                str = Build.ID;
            } else {
                str = "BASE";
            }
            setDeviceSystemName(str);
            if (TextUtils.isEmpty(VERSION.RELEASE.trim())) {
                str2 = VERSION.RELEASE;
            } else {
                str2 = "1.0";
            }
            setDeviceSystemVersion(str2);
            long inMem = MemoryStatus.getTotalInternalMemorySize();
            long extMem = MemoryStatus.getTotalExternalMemorySize();
            String deviceStorage = "InBuilt:";
            if (inMem > 0) {
                deviceStorage = String.valueOf(deviceStorage) + MemoryStatus.formatSize(inMem);
            }
            if (extMem > 0) {
                deviceStorage = String.valueOf(deviceStorage) + ",Ext:" + MemoryStatus.formatSize(extMem);
            }
            setDeviceStorageSize(deviceStorage);
            String machineOSHW = (String) System.getProperties().get("os.name");
            String machineVerHW = (String) System.getProperties().get("os.version");
            if (!(machineOSHW == null || machineVerHW == null)) {
                setDeviceMachineHW(String.valueOf(machineOSHW) + "(Android:" + machineVerHW + ")");
            }
            long sinceBTmilliseconds = SystemClock.elapsedRealtime();
            Calendar cald = Calendar.getInstance();
            cald.setTimeInMillis(System.currentTimeMillis() - sinceBTmilliseconds);
            setDeviceBTHW(cald.getTime().toString());
            Locale linfo = Locale.getDefault();
            String language = linfo.getLanguage();
            if (language != null) {
                language = language.toLowerCase();
                if (linfo.getCountry() != null) {
                    language = String.valueOf(language) + "_" + country.toLowerCase();
                }
            } else {
                String lang = (String) System.getProperties().get("user.language");
                String region = (String) System.getProperties().get("user.region");
                if (!(lang == null || region == null)) {
                    language = String.valueOf(lang) + "_" + region;
                }
                if (language == null) {
                    language = "en";
                }
            }
            setLocalization(language);
            StringBuilder uagent = new StringBuilder();
            uagent.append("InMobi_androidwebsdk=");
            uagent.append(Constants.SDK_VERSION);
            uagent.append(" (");
            uagent.append(getDeviceModel());
            uagent.append("; ");
            uagent.append(getDeviceSystemName());
            uagent.append(" ");
            uagent.append(getDeviceSystemVersion());
            uagent.append("; HW ");
            uagent.append(getDeviceMachineHW());
            uagent.append(")");
            setUserAgent(uagent.toString());
            try {
                Context context = getApplicationContext();
                PackageManager manager = context.getPackageManager();
                ApplicationInfo info = manager.getApplicationInfo(context.getPackageName(), 128);
                if (info != null) {
                    setAppBId(info.packageName);
                    setAppDisplayName(info.loadLabel(manager).toString());
                }
                PackageInfo pInfo = manager.getPackageInfo(context.getPackageName(), 128);
                String ver = null;
                if (pInfo != null) {
                    ver = pInfo.versionName;
                    if (ver == null || ver.equals(Constants.QA_SERVER_URL)) {
                        ver = new StringBuilder(String.valueOf(pInfo.versionCode)).toString();
                    }
                }
                if (ver != null && !ver.equals(Constants.QA_SERVER_URL)) {
                    setAppVer(ver);
                }
            } catch (Exception e) {
            }
        }
        setODINId(Utils.getODIN1(getAndroidId()));
        setRandomKey(this.randomObject.nextInt());
        setUIDMapEncrypted(Utils.getUIDMap(this.mIMAdRequest, getODINId(), getRandomKey(), false));
        try {
            if (this.applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                ConnectivityManager comMgr = (ConnectivityManager) getApplicationContext().getSystemService("connectivity");
                if (comMgr != null) {
                    String netTypeName = null;
                    NetworkInfo netInfo = comMgr.getActiveNetworkInfo();
                    int netType = netInfo.getType();
                    int netSubType = netInfo.getSubtype();
                    if (netType == 1) {
                        netTypeName = "wifi";
                    } else if (netType == 0) {
                        netTypeName = "carrier";
                        if (netSubType == 1) {
                            netTypeName = "gprs";
                        } else if (netSubType == 2) {
                            netTypeName = "edge";
                        } else if (netSubType == 3) {
                            netTypeName = "umts";
                        } else if (netSubType == 0) {
                            netTypeName = "carrier";
                        }
                    }
                    setNetworkType(netTypeName);
                }
            }
        } catch (Exception e2) {
            if (Constants.DEBUG) {
                Log.w(Constants.LOGGING_TAG, "Error getting the network info", e2);
            }
        }
        try {
            int currOrientation = getApplicationContext().getResources().getConfiguration().orientation;
            if (currOrientation == 2) {
                setOrientation(3);
            } else if (currOrientation == 1) {
                setOrientation(1);
            }
        } catch (Exception e3) {
            if (Constants.DEBUG) {
                Log.w(Constants.LOGGING_TAG, "Error getting the orientation info", e3);
            }
        }
    }

    private String getAndroidId() {
        if (this.mAndroidId == null) {
            try {
                this.mAndroidId = Secure.getString(getApplicationContext().getContentResolver(), "android_id");
            } catch (Exception e) {
            }
            if (this.mAndroidId == null) {
                try {
                    this.mAndroidId = System.getString(getApplicationContext().getContentResolver(), "android_id");
                } catch (Exception e2) {
                }
            }
        }
        return this.mAndroidId;
    }

    public String getRefTagKey() {
        return this.refTagKey;
    }

    public void setRefTagKey(String refTagKey2) {
        this.refTagKey = refTagKey2;
    }

    public String getRefTagValue() {
        return this.refTagValue;
    }

    public void setRefTagValue(String refTagValue2) {
        this.refTagValue = refTagValue2;
    }

    public void setPhoneDefaultUserAgent(String phoneDefaultUserAgent2) {
        this.phoneDefaultUserAgent = phoneDefaultUserAgent2;
    }

    public String getAdUnitSlot() {
        return this.adUnitSlot;
    }

    public void setAdUnitSlot(String adUnitSlot2) {
        this.adUnitSlot = adUnitSlot2;
    }

    public String getScreenSize() {
        return this.screenSize;
    }

    public void setScreenSize(String screenSize2) {
        this.screenSize = screenSize2;
    }

    public String getScreenDensity() {
        return this.screenDensity;
    }

    public void setScreenDensity(String screenDensity2) {
        this.screenDensity = screenDensity2;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int orientation) {
        this.mOrientation = orientation;
    }
}
