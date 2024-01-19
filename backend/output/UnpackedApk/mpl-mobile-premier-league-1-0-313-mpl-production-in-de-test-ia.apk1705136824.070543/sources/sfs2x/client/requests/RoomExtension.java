package sfs2x.client.requests;

public class RoomExtension {
    public String className;
    public String id;
    public String propertiesFile = "";

    public RoomExtension(String str, String str2) {
        this.id = str;
        this.className = str2;
    }

    public String getClassName() {
        return this.className;
    }

    public String getId() {
        return this.id;
    }

    public String getPropertiesFile() {
        return this.propertiesFile;
    }

    public void setPropertiesFile(String str) {
        this.propertiesFile = str;
    }
}
