package io.hansel.core.logger;

public class HSLLogModel {
    public static HSLLogModel hslLogModel;
    public HSLLogLevel hslLogLevel;
    public StringBuilder logString;

    public static HSLLogModel getLogger() {
        HSLLogModel hSLLogModel = hslLogModel;
        if (hSLLogModel != null) {
            return hSLLogModel;
        }
        HSLLogModel hSLLogModel2 = new HSLLogModel();
        hslLogModel = hSLLogModel2;
        hSLLogModel2.logString = new StringBuilder();
        return hslLogModel;
    }

    public HSLLogModel append(Object obj) {
        if (this.hslLogLevel.isEnabled()) {
            StringBuilder sb = this.logString;
            sb.append(obj);
            this.logString = sb;
        }
        return hslLogModel;
    }

    public HSLLogModel buildLogMessage(HSLLogLevel hSLLogLevel) {
        hslLogModel.hslLogLevel = hSLLogLevel;
        this.logString.setLength(0);
        return hslLogModel;
    }

    public void print() {
        if (this.hslLogLevel.isEnabled() && this.hslLogLevel == HSLLogLevel.debug) {
            HSLLogger.d(this.logString.toString());
        }
    }
}
