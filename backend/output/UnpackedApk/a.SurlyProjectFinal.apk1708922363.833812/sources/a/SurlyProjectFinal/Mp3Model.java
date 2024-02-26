package a.SurlyProjectFinal;

import com.inmobi.androidsdk.impl.Constants;

public class Mp3Model {
    String album = Constants.QA_SERVER_URL;
    String filePath = Constants.QA_SERVER_URL;
    String singer = Constants.QA_SERVER_URL;
    String title = Constants.QA_SERVER_URL;

    public Mp3Model(String title2, String singer2, String filePath2, String album2) {
        this.title = title2;
        this.singer = singer2;
        this.filePath = filePath2;
        this.album = album2;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSinger() {
        return this.singer;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public void setSinger(String singer2) {
        this.singer = singer2;
    }

    public void setAlbum(String album2) {
        this.album = album2;
    }

    public void setFilePath(String filePath2) {
        this.filePath = filePath2;
    }
}
