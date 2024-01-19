package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import java.io.InputStream;
import okio.Okio;

public class ContactsPhotoRequestHandler extends RequestHandler {
    public static final int ID_CONTACT = 3;
    public static final int ID_DISPLAY_PHOTO = 4;
    public static final int ID_LOOKUP = 1;
    public static final int ID_THUMBNAIL = 2;
    public static final UriMatcher matcher;
    public final Context context;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        matcher = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        matcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        matcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        matcher.addURI("com.android.contacts", "contacts/#", 3);
        matcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    public ContactsPhotoRequestHandler(Context context2) {
        this.context = context2;
    }

    private InputStream getInputStream(Request request) throws IOException {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri uri = request.uri;
        int match = matcher.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                        throw new IllegalStateException(GeneratedOutlineSupport.outline46("Invalid uri: ", uri));
                    }
                }
            }
            return contentResolver.openInputStream(uri);
        }
        uri = Contacts.lookupContact(contentResolver, uri);
        if (uri == null) {
            return null;
        }
        return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    public boolean canHandleRequest(Request request) {
        Uri uri = request.uri;
        return "content".equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && matcher.match(request.uri) != -1;
    }

    public Result load(Request request, int i) throws IOException {
        InputStream inputStream = getInputStream(request);
        if (inputStream == null) {
            return null;
        }
        return new Result(Okio.source(inputStream), LoadedFrom.DISK);
    }
}
