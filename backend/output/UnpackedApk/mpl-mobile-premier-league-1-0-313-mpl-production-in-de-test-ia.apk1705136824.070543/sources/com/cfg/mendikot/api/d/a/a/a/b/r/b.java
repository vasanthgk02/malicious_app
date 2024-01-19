package com.cfg.mendikot.api.d.a.a.a.b.r;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.cfg.mendikot.api.d.a.a.a.b.o;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import java.util.Locale;
import org.apache.commons.net.ftp.FTPReply;
import sfs2x.client.requests.BaseRequest;

public class b implements o {

    /* renamed from: a  reason: collision with root package name */
    public static final b f2282a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final String[][] f2283b = {null, new String[3], new String[8], new String[8], new String[25], new String[8]};

    static {
        a(200, (String) LiveVideoBroadcaster.OK);
        a((int) BaseRequest.AddBuddy, (String) "Created");
        a(202, (String) "Accepted");
        a((int) BaseRequest.SetBuddyVariables, (String) "No Content");
        a((int) BaseRequest.InvitationReply, (String) "Moved Permanently");
        a((int) BaseRequest.CreateSFSGame, (String) "Moved Temporarily");
        a((int) BaseRequest.JoinRoomInvite, (String) "Not Modified");
        a(400, (String) "Bad Request");
        a(401, (String) "Unauthorized");
        a(403, (String) "Forbidden");
        a(404, (String) "Not Found");
        a(500, (String) "Internal Server Error");
        a((int) FTPReply.SYNTAX_ERROR_IN_ARGUMENTS, (String) "Not Implemented");
        a((int) FTPReply.COMMAND_NOT_IMPLEMENTED, (String) "Bad Gateway");
        a((int) FTPReply.BAD_COMMAND_SEQUENCE, (String) "Service Unavailable");
        a(100, (String) "Continue");
        a(307, (String) "Temporary Redirect");
        a(405, (String) "Method Not Allowed");
        a(409, (String) "Conflict");
        a(412, (String) "Precondition Failed");
        a(413, (String) "Request Too Long");
        a(414, (String) "Request-URI Too Long");
        a(415, (String) "Unsupported Media Type");
        a(300, (String) "Multiple Choices");
        a((int) BaseRequest.QuickJoinGame, (String) "See Other");
        a(305, (String) "Use Proxy");
        a(402, (String) "Payment Required");
        a(406, (String) "Not Acceptable");
        a(407, (String) "Proxy Authentication Required");
        a(408, (String) "Request Timeout");
        a(101, (String) "Switching Protocols");
        a((int) BaseRequest.RemoveBuddy, (String) "Non Authoritative Information");
        a((int) BaseRequest.GoOnline, (String) "Reset Content");
        a(206, (String) "Partial Content");
        a((int) FTPReply.COMMAND_NOT_IMPLEMENTED_FOR_PARAMETER, (String) "Gateway Timeout");
        a(505, (String) "Http Version Not Supported");
        a(410, (String) "Gone");
        a(411, (String) "Length Required");
        a(416, (String) "Requested Range Not Satisfiable");
        a(417, (String) "Expectation Failed");
        a(102, (String) "Processing");
        a(207, (String) "Multi-Status");
        a(422, (String) "Unprocessable Entity");
        a(419, (String) "Insufficient Space On Resource");
        a(420, (String) "Method Failure");
        a(423, (String) "Locked");
        a(507, (String) "Insufficient Storage");
        a(424, (String) "Failed Dependency");
    }

    public static void a(int i, String str) {
        int i2 = i / 100;
        f2283b[i2][i - (i2 * 100)] = str;
    }

    public String a(int i, Locale locale) {
        boolean z = i >= 100 && i < 600;
        String outline41 = GeneratedOutlineSupport.outline41("Unknown category for status code ", i);
        if (z) {
            int i2 = i / 100;
            int i3 = i - (i2 * 100);
            String[][] strArr = f2283b;
            if (strArr[i2].length > i3) {
                return strArr[i2][i3];
            }
            return null;
        }
        throw new IllegalArgumentException(outline41);
    }
}
