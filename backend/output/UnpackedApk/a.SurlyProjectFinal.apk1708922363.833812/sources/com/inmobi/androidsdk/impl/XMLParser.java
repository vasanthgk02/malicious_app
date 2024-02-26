package com.inmobi.androidsdk.impl;

import android.util.Log;
import java.io.IOException;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class XMLParser {
    public AdUnit buildAdUnitFromResponseData(Reader reader) throws IOException, AdException {
        AdUnit ad = new AdUnit();
        boolean isAdPresent = false;
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(reader);
            String startName = null;
            String sandboxErrorCode = null;
            for (int eventType = xpp.getEventType(); eventType != 1; eventType = xpp.nextToken()) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        startName = xpp.getName();
                        if (startName != null && startName.equalsIgnoreCase("Ad")) {
                            isAdPresent = true;
                            ad.setWidth(Integer.parseInt(xpp.getAttributeValue(null, "width")));
                            ad.setHeight(Integer.parseInt(xpp.getAttributeValue(null, "height")));
                            ad.setAdActionName(AdUnit.adActionNamefromString(xpp.getAttributeValue(null, "actionName")));
                            ad.setAdType(AdUnit.adTypefromString(xpp.getAttributeValue(null, "type")));
                            sandboxErrorCode = xpp.getAttributeValue(null, "errorcode");
                        }
                    } else if (eventType == 3) {
                        startName = null;
                    } else if (eventType == 5) {
                        ad.setCDATABlock(xpp.getText());
                    } else if (eventType == 4 && startName != null && startName.equalsIgnoreCase("AdURL")) {
                        ad.setTargetUrl(xpp.getText());
                        ad.setDefaultTargetUrl(xpp.getText());
                    }
                }
            }
            if (!isAdPresent) {
                throw new AdException("No Ads present", 100);
            }
            if (sandboxErrorCode != null) {
                if (sandboxErrorCode.equals("OOF")) {
                    Log.v(Constants.LOGGING_TAG, "IP Address not found in CCID File");
                    throw new AdException("IP Address not found in CCID File", AdException.SANDBOX_OOF);
                } else if (sandboxErrorCode.equals("BADIP")) {
                    Log.v(Constants.LOGGING_TAG, "Invalid IP Address");
                    throw new AdException("Invalid IP Address", AdException.SANDBOX_BADIP);
                } else if (sandboxErrorCode.equals("UAND")) {
                    Log.v(Constants.LOGGING_TAG, "User Agent not detected through using wurfl");
                    throw new AdException("User Agent not detected through using wurfl", AdException.SANDBOX_UAND);
                } else if (sandboxErrorCode.equals("-UA")) {
                    Log.v(Constants.LOGGING_TAG, "No User Agent found");
                    throw new AdException("No User Agent found", AdException.SANDBOX_UA);
                }
            }
            return ad;
        } catch (XmlPullParserException parseException) {
            throw new AdException("Exception constructing Ad", parseException, 200);
        }
    }
}
