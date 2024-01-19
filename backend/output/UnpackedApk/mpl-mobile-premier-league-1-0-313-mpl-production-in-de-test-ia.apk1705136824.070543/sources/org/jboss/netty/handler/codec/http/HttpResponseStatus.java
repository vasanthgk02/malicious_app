package org.jboss.netty.handler.codec.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import org.apache.commons.net.ftp.FTPReply;
import sfs2x.client.requests.BaseRequest;

public class HttpResponseStatus implements Comparable<HttpResponseStatus> {
    public static final HttpResponseStatus ACCEPTED = new HttpResponseStatus(202, "Accepted");
    public static final HttpResponseStatus BAD_GATEWAY = new HttpResponseStatus(FTPReply.COMMAND_NOT_IMPLEMENTED, "Bad Gateway");
    public static final HttpResponseStatus BAD_REQUEST = new HttpResponseStatus(400, "Bad Request");
    public static final HttpResponseStatus CONFLICT = new HttpResponseStatus(409, "Conflict");
    public static final HttpResponseStatus CONTINUE = new HttpResponseStatus(100, "Continue");
    public static final HttpResponseStatus CREATED = new HttpResponseStatus(BaseRequest.AddBuddy, "Created");
    public static final HttpResponseStatus EXPECTATION_FAILED = new HttpResponseStatus(417, "Expectation Failed");
    public static final HttpResponseStatus FAILED_DEPENDENCY = new HttpResponseStatus(424, "Failed Dependency");
    public static final HttpResponseStatus FORBIDDEN = new HttpResponseStatus(403, "Forbidden");
    public static final HttpResponseStatus FOUND = new HttpResponseStatus(BaseRequest.CreateSFSGame, "Found");
    public static final HttpResponseStatus GATEWAY_TIMEOUT = new HttpResponseStatus(FTPReply.COMMAND_NOT_IMPLEMENTED_FOR_PARAMETER, "Gateway Timeout");
    public static final HttpResponseStatus GONE = new HttpResponseStatus(410, "Gone");
    public static final HttpResponseStatus HTTP_VERSION_NOT_SUPPORTED = new HttpResponseStatus(505, "HTTP Version Not Supported");
    public static final HttpResponseStatus INSUFFICIENT_STORAGE = new HttpResponseStatus(507, "Insufficient Storage");
    public static final HttpResponseStatus INTERNAL_SERVER_ERROR = new HttpResponseStatus(500, "Internal Server Error");
    public static final HttpResponseStatus LENGTH_REQUIRED = new HttpResponseStatus(411, "Length Required");
    public static final HttpResponseStatus LOCKED = new HttpResponseStatus(423, "Locked");
    public static final HttpResponseStatus METHOD_NOT_ALLOWED = new HttpResponseStatus(405, "Method Not Allowed");
    public static final HttpResponseStatus MOVED_PERMANENTLY = new HttpResponseStatus(BaseRequest.InvitationReply, "Moved Permanently");
    public static final HttpResponseStatus MULTIPLE_CHOICES = new HttpResponseStatus(300, "Multiple Choices");
    public static final HttpResponseStatus MULTI_STATUS = new HttpResponseStatus(207, "Multi-Status");
    public static final HttpResponseStatus NON_AUTHORITATIVE_INFORMATION = new HttpResponseStatus(BaseRequest.RemoveBuddy, "Non-Authoritative Information");
    public static final HttpResponseStatus NOT_ACCEPTABLE = new HttpResponseStatus(406, "Not Acceptable");
    public static final HttpResponseStatus NOT_EXTENDED = new HttpResponseStatus(510, "Not Extended");
    public static final HttpResponseStatus NOT_FOUND = new HttpResponseStatus(404, "Not Found");
    public static final HttpResponseStatus NOT_IMPLEMENTED = new HttpResponseStatus(FTPReply.SYNTAX_ERROR_IN_ARGUMENTS, "Not Implemented");
    public static final HttpResponseStatus NOT_MODIFIED = new HttpResponseStatus(BaseRequest.JoinRoomInvite, "Not Modified");
    public static final HttpResponseStatus NO_CONTENT = new HttpResponseStatus(BaseRequest.SetBuddyVariables, "No Content");
    public static final HttpResponseStatus OK = new HttpResponseStatus(200, LiveVideoBroadcaster.OK);
    public static final HttpResponseStatus PARTIAL_CONTENT = new HttpResponseStatus(206, "Partial Content");
    public static final HttpResponseStatus PAYMENT_REQUIRED = new HttpResponseStatus(402, "Payment Required");
    public static final HttpResponseStatus PRECONDITION_FAILED = new HttpResponseStatus(412, "Precondition Failed");
    public static final HttpResponseStatus PROCESSING = new HttpResponseStatus(102, "Processing");
    public static final HttpResponseStatus PROXY_AUTHENTICATION_REQUIRED = new HttpResponseStatus(407, "Proxy Authentication Required");
    public static final HttpResponseStatus REQUESTED_RANGE_NOT_SATISFIABLE = new HttpResponseStatus(416, "Requested Range Not Satisfiable");
    public static final HttpResponseStatus REQUEST_ENTITY_TOO_LARGE = new HttpResponseStatus(413, "Request Entity Too Large");
    public static final HttpResponseStatus REQUEST_TIMEOUT = new HttpResponseStatus(408, "Request Timeout");
    public static final HttpResponseStatus REQUEST_URI_TOO_LONG = new HttpResponseStatus(414, "Request-URI Too Long");
    public static final HttpResponseStatus RESET_CONTENT = new HttpResponseStatus(BaseRequest.GoOnline, "Reset Content");
    public static final HttpResponseStatus SEE_OTHER = new HttpResponseStatus(BaseRequest.QuickJoinGame, "See Other");
    public static final HttpResponseStatus SERVICE_UNAVAILABLE = new HttpResponseStatus(FTPReply.BAD_COMMAND_SEQUENCE, "Service Unavailable");
    public static final HttpResponseStatus SWITCHING_PROTOCOLS = new HttpResponseStatus(101, "Switching Protocols");
    public static final HttpResponseStatus TEMPORARY_REDIRECT = new HttpResponseStatus(307, "Temporary Redirect");
    public static final HttpResponseStatus UNAUTHORIZED = new HttpResponseStatus(401, "Unauthorized");
    public static final HttpResponseStatus UNORDERED_COLLECTION = new HttpResponseStatus(FTPReply.CANNOT_OPEN_DATA_CONNECTION, "Unordered Collection");
    public static final HttpResponseStatus UNPROCESSABLE_ENTITY = new HttpResponseStatus(422, "Unprocessable Entity");
    public static final HttpResponseStatus UNSUPPORTED_MEDIA_TYPE = new HttpResponseStatus(415, "Unsupported Media Type");
    public static final HttpResponseStatus UPGRADE_REQUIRED = new HttpResponseStatus(FTPReply.TRANSFER_ABORTED, "Upgrade Required");
    public static final HttpResponseStatus USE_PROXY = new HttpResponseStatus(305, "Use Proxy");
    public static final HttpResponseStatus VARIANT_ALSO_NEGOTIATES = new HttpResponseStatus(506, "Variant Also Negotiates");
    public final int code;
    public final String reasonPhrase;

    public HttpResponseStatus(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("code: ", i, " (expected: 0+)"));
        } else if (str != null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt == 10 || charAt == 13) {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("reasonPhrase contains one of the following prohibited characters: \\r\\n: ", str));
                }
            }
            this.code = i;
            this.reasonPhrase = str;
        } else {
            throw new NullPointerException("reasonPhrase");
        }
    }

    public static HttpResponseStatus valueOf(int i) {
        if (i == 307) {
            return TEMPORARY_REDIRECT;
        }
        if (i == 510) {
            return NOT_EXTENDED;
        }
        switch (i) {
            case 100:
                return CONTINUE;
            case 101:
                return SWITCHING_PROTOCOLS;
            case 102:
                return PROCESSING;
            default:
                switch (i) {
                    case 200:
                        return OK;
                    case BaseRequest.AddBuddy /*201*/:
                        return CREATED;
                    case 202:
                        return ACCEPTED;
                    case BaseRequest.RemoveBuddy /*203*/:
                        return NON_AUTHORITATIVE_INFORMATION;
                    case BaseRequest.SetBuddyVariables /*204*/:
                        return NO_CONTENT;
                    case BaseRequest.GoOnline /*205*/:
                        return RESET_CONTENT;
                    case 206:
                        return PARTIAL_CONTENT;
                    case 207:
                        return MULTI_STATUS;
                    default:
                        switch (i) {
                            case 300:
                                return MULTIPLE_CHOICES;
                            case BaseRequest.InvitationReply /*301*/:
                                return MOVED_PERMANENTLY;
                            case BaseRequest.CreateSFSGame /*302*/:
                                return FOUND;
                            case BaseRequest.QuickJoinGame /*303*/:
                                return SEE_OTHER;
                            case BaseRequest.JoinRoomInvite /*304*/:
                                return NOT_MODIFIED;
                            case 305:
                                return USE_PROXY;
                            default:
                                switch (i) {
                                    case 400:
                                        return BAD_REQUEST;
                                    case 401:
                                        return UNAUTHORIZED;
                                    case 402:
                                        return PAYMENT_REQUIRED;
                                    case 403:
                                        return FORBIDDEN;
                                    case 404:
                                        return NOT_FOUND;
                                    case 405:
                                        return METHOD_NOT_ALLOWED;
                                    case 406:
                                        return NOT_ACCEPTABLE;
                                    case 407:
                                        return PROXY_AUTHENTICATION_REQUIRED;
                                    case 408:
                                        return REQUEST_TIMEOUT;
                                    case 409:
                                        return CONFLICT;
                                    case 410:
                                        return GONE;
                                    case 411:
                                        return LENGTH_REQUIRED;
                                    case 412:
                                        return PRECONDITION_FAILED;
                                    case 413:
                                        return REQUEST_ENTITY_TOO_LARGE;
                                    case 414:
                                        return REQUEST_URI_TOO_LONG;
                                    case 415:
                                        return UNSUPPORTED_MEDIA_TYPE;
                                    case 416:
                                        return REQUESTED_RANGE_NOT_SATISFIABLE;
                                    case 417:
                                        return EXPECTATION_FAILED;
                                    default:
                                        switch (i) {
                                            case 422:
                                                return UNPROCESSABLE_ENTITY;
                                            case 423:
                                                return LOCKED;
                                            case 424:
                                                return FAILED_DEPENDENCY;
                                            case FTPReply.CANNOT_OPEN_DATA_CONNECTION /*425*/:
                                                return UNORDERED_COLLECTION;
                                            case FTPReply.TRANSFER_ABORTED /*426*/:
                                                return UPGRADE_REQUIRED;
                                            default:
                                                switch (i) {
                                                    case 500:
                                                        return INTERNAL_SERVER_ERROR;
                                                    case FTPReply.SYNTAX_ERROR_IN_ARGUMENTS /*501*/:
                                                        return NOT_IMPLEMENTED;
                                                    case FTPReply.COMMAND_NOT_IMPLEMENTED /*502*/:
                                                        return BAD_GATEWAY;
                                                    case FTPReply.BAD_COMMAND_SEQUENCE /*503*/:
                                                        return SERVICE_UNAVAILABLE;
                                                    case FTPReply.COMMAND_NOT_IMPLEMENTED_FOR_PARAMETER /*504*/:
                                                        return GATEWAY_TIMEOUT;
                                                    case 505:
                                                        return HTTP_VERSION_NOT_SUPPORTED;
                                                    case 506:
                                                        return VARIANT_ALSO_NEGOTIATES;
                                                    case 507:
                                                        return INSUFFICIENT_STORAGE;
                                                    default:
                                                        String str = "Unknown Status";
                                                        if (i >= 100) {
                                                            if (i < 200) {
                                                                str = "Informational";
                                                            } else if (i < 300) {
                                                                str = "Successful";
                                                            } else if (i < 400) {
                                                                str = "Redirection";
                                                            } else if (i < 500) {
                                                                str = "Client Error";
                                                            } else if (i < 600) {
                                                                str = "Server Error";
                                                            }
                                                        }
                                                        return new HttpResponseStatus(i, str + " (" + i + ')');
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof HttpResponseStatus)) {
            return false;
        }
        if (getCode() == ((HttpResponseStatus) obj).getCode()) {
            z = true;
        }
        return z;
    }

    public int getCode() {
        return this.code;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public int hashCode() {
        return getCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.reasonPhrase.length() + 5);
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.reasonPhrase);
        return sb.toString();
    }

    public int compareTo(HttpResponseStatus httpResponseStatus) {
        return getCode() - httpResponseStatus.getCode();
    }
}
