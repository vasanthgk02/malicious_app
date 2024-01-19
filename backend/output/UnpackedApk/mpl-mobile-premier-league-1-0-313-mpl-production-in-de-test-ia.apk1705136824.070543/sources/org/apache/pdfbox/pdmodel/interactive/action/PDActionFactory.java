package org.apache.pdfbox.pdmodel.interactive.action;

import org.apache.pdfbox.cos.COSDictionary;

public final class PDActionFactory {
    public static PDAction createAction(COSDictionary cOSDictionary) {
        if (cOSDictionary != null) {
            String nameAsString = cOSDictionary.getNameAsString((String) "S");
            if (PDActionJavaScript.SUB_TYPE.equals(nameAsString)) {
                return new PDActionJavaScript(cOSDictionary);
            }
            if (PDActionGoTo.SUB_TYPE.equals(nameAsString)) {
                return new PDActionGoTo(cOSDictionary);
            }
            if (PDActionLaunch.SUB_TYPE.equals(nameAsString)) {
                return new PDActionLaunch(cOSDictionary);
            }
            if (PDActionRemoteGoTo.SUB_TYPE.equals(nameAsString)) {
                return new PDActionRemoteGoTo(cOSDictionary);
            }
            if (PDActionURI.SUB_TYPE.equals(nameAsString)) {
                return new PDActionURI(cOSDictionary);
            }
            if (PDActionNamed.SUB_TYPE.equals(nameAsString)) {
                return new PDActionNamed(cOSDictionary);
            }
        }
        return null;
    }
}
