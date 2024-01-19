package sfs2x.client.util;

import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import sfs2x.client.SmartFox;

public class ConfigData {
    public String bboxHost;
    public int bboxPollingRate = OS2WindowsMetricsTable.WEIGHT_CLASS_BOLD;
    public boolean debug = false;
    public String host = "127.0.0.1";
    public int httpPort = SmartFox.DEFAULT_HTTP_PORT;
    public int httpsPort = 8443;
    public int port = 9933;
    public String udpHost = "127.0.0.1";
    public int udpPort = 9933;
    public boolean useBBox = true;
    public String zone;

    public String getBboxHost() {
        return this.bboxHost;
    }

    public int getBboxPollingRate() {
        return this.bboxPollingRate;
    }

    public String getHost() {
        return this.host;
    }

    public int getHttpPort() {
        return this.httpPort;
    }

    public int getHttpsPort() {
        return this.httpsPort;
    }

    public int getPort() {
        return this.port;
    }

    public String getUdpHost() {
        return this.udpHost;
    }

    public int getUdpPort() {
        return this.udpPort;
    }

    public String getZone() {
        return this.zone;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isUseBBox() {
        return this.useBBox;
    }

    public void setBboxHost(String str) {
        this.bboxHost = str;
    }

    public void setBboxPollingRate(int i) {
        this.bboxPollingRate = i;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setHttpPort(int i) {
        this.httpPort = i;
    }

    public void setHttpsPort(int i) {
        this.httpsPort = i;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setUdpHost(String str) {
        this.udpHost = str;
    }

    public void setUdpPort(int i) {
        this.udpPort = i;
    }

    public void setUseBBox(boolean z) {
        this.useBBox = z;
    }

    public void setZone(String str) {
        this.zone = str;
    }
}
