package org.apache.commons.net.ftp;

public enum FTPCmd {
    ABOR,
    ACCT,
    ALLO,
    APPE,
    CDUP,
    CWD,
    DELE,
    EPRT,
    EPSV,
    FEAT,
    HELP,
    LIST,
    MDTM,
    MFMT,
    MKD,
    MLSD,
    MLST,
    MODE,
    NLST,
    NOOP,
    PASS,
    PASV,
    PORT,
    PWD,
    QUIT,
    REIN,
    REST,
    RETR,
    RMD,
    RNFR,
    RNTO,
    SITE,
    SMNT,
    STAT,
    STOR,
    STOU,
    STRU,
    SYST,
    TYPE,
    USER;
    
    public static final FTPCmd ABORT = null;
    public static final FTPCmd ACCOUNT = null;
    public static final FTPCmd ALLOCATE = null;
    public static final FTPCmd APPEND = null;
    public static final FTPCmd CHANGE_TO_PARENT_DIRECTORY = null;
    public static final FTPCmd CHANGE_WORKING_DIRECTORY = null;
    public static final FTPCmd DATA_PORT = null;
    public static final FTPCmd DELETE = null;
    public static final FTPCmd FEATURES = null;
    public static final FTPCmd FILE_STRUCTURE = null;
    public static final FTPCmd GET_MOD_TIME = null;
    public static final FTPCmd LOGOUT = null;
    public static final FTPCmd MAKE_DIRECTORY = null;
    public static final FTPCmd MOD_TIME = null;
    public static final FTPCmd NAME_LIST = null;
    public static final FTPCmd PASSIVE = null;
    public static final FTPCmd PASSWORD = null;
    public static final FTPCmd PRINT_WORKING_DIRECTORY = null;
    public static final FTPCmd REINITIALIZE = null;
    public static final FTPCmd REMOVE_DIRECTORY = null;
    public static final FTPCmd RENAME_FROM = null;
    public static final FTPCmd RENAME_TO = null;
    public static final FTPCmd REPRESENTATION_TYPE = null;
    public static final FTPCmd RESTART = null;
    public static final FTPCmd RETRIEVE = null;
    public static final FTPCmd SET_MOD_TIME = null;
    public static final FTPCmd SITE_PARAMETERS = null;
    public static final FTPCmd STATUS = null;
    public static final FTPCmd STORE = null;
    public static final FTPCmd STORE_UNIQUE = null;
    public static final FTPCmd STRUCTURE_MOUNT = null;
    public static final FTPCmd SYSTEM = null;
    public static final FTPCmd TRANSFER_MODE = null;
    public static final FTPCmd USERNAME = null;

    static {
        FTPCmd fTPCmd;
        FTPCmd fTPCmd2;
        FTPCmd fTPCmd3;
        FTPCmd fTPCmd4;
        FTPCmd fTPCmd5;
        FTPCmd fTPCmd6;
        FTPCmd fTPCmd7;
        FTPCmd fTPCmd8;
        FTPCmd fTPCmd9;
        FTPCmd fTPCmd10;
        FTPCmd fTPCmd11;
        FTPCmd fTPCmd12;
        FTPCmd fTPCmd13;
        FTPCmd fTPCmd14;
        FTPCmd fTPCmd15;
        FTPCmd fTPCmd16;
        FTPCmd fTPCmd17;
        FTPCmd fTPCmd18;
        FTPCmd fTPCmd19;
        FTPCmd fTPCmd20;
        FTPCmd fTPCmd21;
        FTPCmd fTPCmd22;
        FTPCmd fTPCmd23;
        FTPCmd fTPCmd24;
        FTPCmd fTPCmd25;
        FTPCmd fTPCmd26;
        FTPCmd fTPCmd27;
        FTPCmd fTPCmd28;
        FTPCmd fTPCmd29;
        FTPCmd fTPCmd30;
        FTPCmd fTPCmd31;
        FTPCmd fTPCmd32;
        FTPCmd fTPCmd33;
        ABORT = fTPCmd;
        ACCOUNT = fTPCmd2;
        ALLOCATE = fTPCmd3;
        APPEND = fTPCmd4;
        CHANGE_TO_PARENT_DIRECTORY = fTPCmd5;
        CHANGE_WORKING_DIRECTORY = fTPCmd6;
        DATA_PORT = fTPCmd16;
        DELETE = fTPCmd7;
        FEATURES = fTPCmd8;
        FILE_STRUCTURE = fTPCmd30;
        GET_MOD_TIME = fTPCmd9;
        LOGOUT = fTPCmd18;
        MAKE_DIRECTORY = fTPCmd11;
        MOD_TIME = fTPCmd9;
        NAME_LIST = fTPCmd13;
        PASSIVE = fTPCmd15;
        PASSWORD = fTPCmd14;
        PRINT_WORKING_DIRECTORY = fTPCmd17;
        REINITIALIZE = fTPCmd19;
        REMOVE_DIRECTORY = fTPCmd22;
        RENAME_FROM = fTPCmd23;
        RENAME_TO = fTPCmd24;
        REPRESENTATION_TYPE = fTPCmd32;
        RESTART = fTPCmd20;
        RETRIEVE = fTPCmd21;
        SET_MOD_TIME = fTPCmd10;
        SITE_PARAMETERS = fTPCmd25;
        STATUS = fTPCmd27;
        STORE = fTPCmd28;
        STORE_UNIQUE = fTPCmd29;
        STRUCTURE_MOUNT = fTPCmd26;
        SYSTEM = fTPCmd31;
        TRANSFER_MODE = fTPCmd12;
        USERNAME = fTPCmd33;
    }

    public final String getCommand() {
        return name();
    }
}
