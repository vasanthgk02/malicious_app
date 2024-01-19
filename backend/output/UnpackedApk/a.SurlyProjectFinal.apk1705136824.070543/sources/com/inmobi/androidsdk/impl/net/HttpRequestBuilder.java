package com.inmobi.androidsdk.impl.net;

import android.util.Log;
import com.inmobi.androidsdk.IMAdRequest.EducationType;
import com.inmobi.androidsdk.IMAdRequest.EthnicityType;
import com.inmobi.androidsdk.IMAdRequest.GenderType;
import com.inmobi.androidsdk.impl.Constants;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.net.RequestResponseManager.ActionType;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map.Entry;

public final class HttpRequestBuilder {
    static String buildPostBody(UserInfo userInfoRef, ActionType usedFor) {
        StringBuffer retStrBuffer = new StringBuffer();
        try {
            if (ActionType.AdRequest == usedFor) {
                String sdkDelegateString = getSDKDelegatePostBodyString(userInfoRef);
                retStrBuffer.append("requestactivity=AdRequest");
                if (sdkDelegateString != null && !sdkDelegateString.equalsIgnoreCase(Constants.QA_SERVER_URL)) {
                    retStrBuffer.append("&" + sdkDelegateString);
                }
            } else if (ActionType.AdRequest_Interstitial == usedFor) {
                String sdkDelegateString2 = getSDKDelegatePostBodyString(userInfoRef);
                retStrBuffer.append("adtype=int");
                if (sdkDelegateString2 != null && !sdkDelegateString2.equalsIgnoreCase(Constants.QA_SERVER_URL)) {
                    retStrBuffer.append("&" + sdkDelegateString2);
                }
            } else if (ActionType.DeviceInfoUpload == usedFor) {
                retStrBuffer.append("requestactivity=DeviceInfo");
            } else {
                retStrBuffer.append("requestactivity=AdClicked");
            }
            retStrBuffer.append(getDevicePostBodyString(userInfoRef));
            retStrBuffer.append("&" + getApplicationPostBodyString(userInfoRef));
        } catch (Exception e) {
            Log.w(Constants.LOGGING_TAG, "Exception occured in an ad request" + e);
        }
        return retStrBuffer.toString();
    }

    private static String getSDKDelegatePostBodyString(UserInfo userInfoRef) {
        String str;
        StringBuilder sdkPostBody = new StringBuilder();
        if (userInfoRef.getPostalCode() != null) {
            sdkPostBody.append("u-postalCode=");
            sdkPostBody.append(getURLEncoded(userInfoRef.getPostalCode()));
        }
        if (userInfoRef.getRequestParams() != null) {
            for (Entry<String, String> entry : userInfoRef.getRequestParams().entrySet()) {
                sdkPostBody.append("&").append(getURLEncoded(entry.getKey().toString())).append("=").append(getURLEncoded(entry.getValue().toString()));
            }
        }
        if (userInfoRef.getAreaCode() != null) {
            sdkPostBody.append("&u-areaCode=");
            sdkPostBody.append(getURLEncoded(userInfoRef.getAreaCode()));
        }
        if (userInfoRef.getDateOfBirth() != null) {
            sdkPostBody.append("&u-dateOfBirth=");
            sdkPostBody.append(getURLEncoded(userInfoRef.getDateOfBirth()));
        }
        if (!(userInfoRef.getGender() == GenderType.NONE || userInfoRef.getGender() == null)) {
            sdkPostBody.append("&u-gender=");
            if (userInfoRef.getGender() == GenderType.MALE) {
                str = "M";
            } else {
                str = "F";
            }
            sdkPostBody.append(str);
        }
        if (userInfoRef.getKeywords() != null) {
            sdkPostBody.append("&p-keywords=");
            sdkPostBody.append(getURLEncoded(userInfoRef.getKeywords()));
        }
        if (userInfoRef.getSearchString() != null) {
            sdkPostBody.append("&p-type=");
            sdkPostBody.append(getURLEncoded(userInfoRef.getSearchString()));
        }
        if (userInfoRef.getIncome() > 0) {
            sdkPostBody.append("&u-income=");
            sdkPostBody.append(userInfoRef.getIncome());
        }
        if (!(userInfoRef.getEducation() == EducationType.Edu_None || userInfoRef.getEducation() == null)) {
            sdkPostBody.append("&u-education=");
            sdkPostBody.append(userInfoRef.getEducation());
        }
        if (!(userInfoRef.getEthnicity() == EthnicityType.Eth_None || userInfoRef.getEthnicity() == null)) {
            sdkPostBody.append("&u-ethnicity=");
            sdkPostBody.append(userInfoRef.getEthnicity());
        }
        if (userInfoRef.getAge() > 0) {
            sdkPostBody.append("&u-age=");
            sdkPostBody.append(userInfoRef.getAge());
        }
        if (userInfoRef.getInterests() != null) {
            sdkPostBody.append("&u-interests=");
            sdkPostBody.append(getURLEncoded(userInfoRef.getInterests()));
        }
        if (userInfoRef.getLocationWithCityStateCountry() != null) {
            sdkPostBody.append("&u-location=");
            sdkPostBody.append(getURLEncoded(userInfoRef.getLocationWithCityStateCountry()));
        }
        String retString = sdkPostBody.toString();
        try {
            if (retString.charAt(0) == '&') {
                return retString.substring(1);
            }
            return retString;
        } catch (Exception e) {
            return retString;
        }
    }

    private static String getDevicePostBodyString(UserInfo userInfoRef) {
        StringBuilder devicePostBodyString = new StringBuilder();
        if (userInfoRef.getScreenDensity() != null) {
            devicePostBodyString.append("&d-device-screen-density=").append(getURLEncoded(userInfoRef.getScreenDensity()));
        }
        if (userInfoRef.getScreenSize() != null) {
            devicePostBodyString.append("&d-device-screen-size=").append(getURLEncoded(userInfoRef.getScreenSize()));
        }
        return devicePostBodyString.toString();
    }

    private static String getApplicationPostBodyString(UserInfo userInfoRef) {
        StringBuilder appPostBodyString = new StringBuilder();
        if (userInfoRef.getSiteId() != null) {
            appPostBodyString.append("mk-siteid=");
            appPostBodyString.append(getURLEncoded(userInfoRef.getSiteId()));
        }
        if (userInfoRef.getUIDMapEncrypted() != null) {
            appPostBodyString.append("&u-id-map=");
            appPostBodyString.append(getURLEncoded(userInfoRef.getUIDMapEncrypted()));
            appPostBodyString.append("&u-id-key=");
            appPostBodyString.append(userInfoRef.getRandomKey());
            appPostBodyString.append("&u-key-ver=");
            appPostBodyString.append(userInfoRef.getRsakeyVersion());
        }
        appPostBodyString.append("&mk-version=");
        appPostBodyString.append(getURLEncoded("pr-SAND-DTFTA-20120224"));
        appPostBodyString.append("&format=xhtml");
        appPostBodyString.append("&mk-ads=1");
        appPostBodyString.append("&h-user-agent=");
        appPostBodyString.append(getURLEncoded(userInfoRef.getPhoneDefaultUserAgent()));
        appPostBodyString.append("&u-InMobi_androidwebsdkVersion=");
        appPostBodyString.append(getURLEncoded(Constants.SDK_VERSION));
        appPostBodyString.append("&u-appBId=");
        appPostBodyString.append(getURLEncoded(userInfoRef.getAppBId()));
        appPostBodyString.append("&u-appDNM=");
        appPostBodyString.append(getURLEncoded(userInfoRef.getAppDisplayName()));
        appPostBodyString.append("&u-appVer=");
        appPostBodyString.append(getURLEncoded(userInfoRef.getAppVer()));
        appPostBodyString.append("&d-localization=");
        appPostBodyString.append(getURLEncoded(userInfoRef.getLocalization()));
        if (userInfoRef.getNetworkType() != null) {
            appPostBodyString.append("&d-netType=");
            appPostBodyString.append(getURLEncoded(userInfoRef.getNetworkType()));
        }
        if (userInfoRef.getOrientation() != 0) {
            appPostBodyString.append("&d-orientation=");
            appPostBodyString.append(userInfoRef.getOrientation());
        }
        appPostBodyString.append("&mk-ad-slot=");
        appPostBodyString.append(getURLEncoded(userInfoRef.getAdUnitSlot()));
        if (userInfoRef.isValidGeoInfo()) {
            appPostBodyString.append("&u-latlong-accu=");
            appPostBodyString.append(getURLEncoded(currentLocationStr(userInfoRef)));
        }
        if (!(userInfoRef.getRefTagKey() == null || userInfoRef.getRefTagValue() == null)) {
            appPostBodyString.append("&").append(getURLEncoded(userInfoRef.getRefTagKey())).append("=").append(getURLEncoded(userInfoRef.getRefTagValue()));
        }
        return appPostBodyString.toString();
    }

    public static String currentLocationStr(UserInfo clientInfo) {
        StringBuilder data = new StringBuilder();
        if (data == null || !clientInfo.isValidGeoInfo()) {
            return Constants.QA_SERVER_URL;
        }
        data.append(clientInfo.getLat());
        data.append(",");
        data.append(clientInfo.getLon());
        data.append(",");
        data.append((int) clientInfo.getLocAccuracy());
        return data.toString();
    }

    public static String getURLEncoded(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (Exception e) {
            return Constants.QA_SERVER_URL;
        }
    }

    public static String getURLDecoded(String value, String encoding) {
        String decoded = Constants.QA_SERVER_URL;
        try {
            return URLDecoder.decode(value, encoding);
        } catch (Exception e) {
            return decoded;
        }
    }
}
