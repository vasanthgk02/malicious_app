package com.mpl.androidapp.updater.repo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CheckUpdateResponse {
    @SerializedName("payload")
    @Expose
    public Payload payload;
    @SerializedName("status")
    @Expose
    public Status status;

    public class Payload {
        @SerializedName("canSkipPopup")
        @Expose
        public Boolean canSkipPopup;
        @SerializedName("eligibilityCriteria")
        @Expose
        public String eligibilityCriteria;
        @SerializedName("showPopup")
        @Expose
        public Boolean showPopup;
        @SerializedName("update")
        @Expose
        public Update update;
        @SerializedName("updateAvailable")
        @Expose
        public Boolean updateAvailable;

        public class Update {
            @SerializedName("binary")
            @Expose
            public Binary binary;
            @SerializedName("id")
            @Expose
            public String id;
            @SerializedName("lcStage")
            @Expose
            public String lcStage;
            @SerializedName("releaseNotes")
            @Expose
            public ReleaseNotes releaseNotes;
            @SerializedName("subversion")
            @Expose
            public Integer subversion;
            @SerializedName("type")
            @Expose
            public Object type;
            @SerializedName("typeMeta")
            @Expose
            public Object typeMeta;
            @SerializedName("version")
            @Expose
            public Integer version;

            public class Binary {
                @SerializedName("id")
                @Expose
                public String id;
                @SerializedName("sha")
                @Expose
                public String sha;
                @SerializedName("type")
                @Expose
                public Object type;
                @SerializedName("url")
                @Expose
                public String url;

                public Binary() {
                }

                public String getId() {
                    return this.id;
                }

                public String getSha() {
                    return this.sha;
                }

                public Object getType() {
                    return this.type;
                }

                public String getUrl() {
                    return this.url;
                }

                public void setId(String str) {
                    this.id = str;
                }

                public void setSha(String str) {
                    this.sha = str;
                }

                public void setType(Object obj) {
                    this.type = obj;
                }

                public void setUrl(String str) {
                    this.url = str;
                }
            }

            public class ReleaseNotes {
                @SerializedName("releasePoints")
                @Expose
                public List<ReleasePoint> releasePoints = null;

                public ReleaseNotes() {
                }

                public List<ReleasePoint> getReleasePoints() {
                    return this.releasePoints;
                }

                public void setReleasePoints(List<ReleasePoint> list) {
                    this.releasePoints = list;
                }
            }

            public class ReleasePoint {
                @SerializedName("iconUrl")
                @Expose
                public String iconUrl;
                @SerializedName("updateDesc")
                @Expose
                public String updateDesc;

                public ReleasePoint() {
                }

                public String getIconUrl() {
                    return this.iconUrl;
                }

                public String getUpdateDesc() {
                    return this.updateDesc;
                }

                public void setIconUrl(String str) {
                    this.iconUrl = str;
                }

                public void setUpdateDesc(String str) {
                    this.updateDesc = str;
                }
            }

            public Update() {
            }

            public Binary getBinary() {
                return this.binary;
            }

            public String getId() {
                return this.id;
            }

            public String getLcStage() {
                return this.lcStage;
            }

            public ReleaseNotes getReleaseNotes() {
                return this.releaseNotes;
            }

            public Integer getSubversion() {
                return this.subversion;
            }

            public Object getType() {
                return this.type;
            }

            public Object getTypeMeta() {
                return this.typeMeta;
            }

            public Integer getVersion() {
                return this.version;
            }

            public void setBinary(Binary binary2) {
                this.binary = binary2;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setLcStage(String str) {
                this.lcStage = str;
            }

            public void setReleaseNotes(ReleaseNotes releaseNotes2) {
                this.releaseNotes = releaseNotes2;
            }

            public void setSubversion(Integer num) {
                this.subversion = num;
            }

            public void setType(Object obj) {
                this.type = obj;
            }

            public void setTypeMeta(Object obj) {
                this.typeMeta = obj;
            }

            public void setVersion(Integer num) {
                this.version = num;
            }
        }

        public Payload() {
        }

        public Boolean getCanSkipPopup() {
            return this.canSkipPopup;
        }

        public String getEligibilityCriteria() {
            return this.eligibilityCriteria;
        }

        public Boolean getShowPopup() {
            return this.showPopup;
        }

        public Update getUpdate() {
            return this.update;
        }

        public Boolean getUpdateAvailable() {
            return this.updateAvailable;
        }

        public void setCanSkipPopup(Boolean bool) {
            this.canSkipPopup = bool;
        }

        public void setEligibilityCriteria(String str) {
            this.eligibilityCriteria = str;
        }

        public void setShowPopup(Boolean bool) {
            this.showPopup = bool;
        }

        public void setUpdate(Update update2) {
            this.update = update2;
        }

        public void setUpdateAvailable(Boolean bool) {
            this.updateAvailable = bool;
        }
    }

    public class Status {
        @SerializedName("code")
        @Expose
        public Integer code;
        @SerializedName("message")
        @Expose
        public String message;
        @SerializedName("reason")
        @Expose
        public String reason;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("type")
        @Expose
        public String type;

        public Status() {
        }

        public Integer getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public String getReason() {
            return this.reason;
        }

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public void setCode(Integer num) {
            this.code = num;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setReason(String str) {
            this.reason = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public Payload getPayload() {
        return this.payload;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public void setStatus(Status status2) {
        this.status = status2;
    }
}
