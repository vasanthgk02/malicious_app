package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

public final class InputContentInfoCompat {
    public final InputContentInfoCompatImpl mImpl;

    public static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {
        public final InputContentInfo mObject;

        public InputContentInfoCompatApi25Impl(Object obj) {
            this.mObject = (InputContentInfo) obj;
        }

        public Uri getContentUri() {
            return this.mObject.getContentUri();
        }

        public ClipDescription getDescription() {
            return this.mObject.getDescription();
        }

        public Object getInputContentInfo() {
            return this.mObject;
        }

        public Uri getLinkUri() {
            return this.mObject.getLinkUri();
        }

        public void requestPermission() {
            this.mObject.requestPermission();
        }

        public InputContentInfoCompatApi25Impl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.mObject = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {
        public final Uri mContentUri;
        public final ClipDescription mDescription;
        public final Uri mLinkUri;

        public InputContentInfoCompatBaseImpl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.mContentUri = uri;
            this.mDescription = clipDescription;
            this.mLinkUri = uri2;
        }

        public Uri getContentUri() {
            return this.mContentUri;
        }

        public ClipDescription getDescription() {
            return this.mDescription;
        }

        public Object getInputContentInfo() {
            return null;
        }

        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        public void requestPermission() {
        }
    }

    public interface InputContentInfoCompatImpl {
        Uri getContentUri();

        ClipDescription getDescription();

        Object getInputContentInfo();

        Uri getLinkUri();

        void requestPermission();
    }

    public InputContentInfoCompat(InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.mImpl = inputContentInfoCompatImpl;
    }
}
