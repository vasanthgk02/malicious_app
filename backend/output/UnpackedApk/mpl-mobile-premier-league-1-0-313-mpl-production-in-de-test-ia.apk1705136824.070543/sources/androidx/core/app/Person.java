package androidx.core.app;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import com.android.tools.r8.GeneratedOutlineSupport;

public class Person {
    public static final String ICON_KEY = "icon";
    public static final String IS_BOT_KEY = "isBot";
    public static final String IS_IMPORTANT_KEY = "isImportant";
    public static final String KEY_KEY = "key";
    public static final String NAME_KEY = "name";
    public static final String URI_KEY = "uri";
    public IconCompat mIcon;
    public boolean mIsBot;
    public boolean mIsImportant;
    public String mKey;
    public CharSequence mName;
    public String mUri;

    public static class Builder {
        public IconCompat mIcon;
        public boolean mIsBot;
        public boolean mIsImportant;
        public String mKey;
        public CharSequence mName;
        public String mUri;

        public Builder() {
        }

        public Person build() {
            return new Person(this);
        }

        public Builder setBot(boolean z) {
            this.mIsBot = z;
            return this;
        }

        public Builder setIcon(IconCompat iconCompat) {
            this.mIcon = iconCompat;
            return this;
        }

        public Builder setImportant(boolean z) {
            this.mIsImportant = z;
            return this;
        }

        public Builder setKey(String str) {
            this.mKey = str;
            return this;
        }

        public Builder setName(CharSequence charSequence) {
            this.mName = charSequence;
            return this;
        }

        public Builder setUri(String str) {
            this.mUri = str;
            return this;
        }

        public Builder(Person person) {
            this.mName = person.mName;
            this.mIcon = person.mIcon;
            this.mUri = person.mUri;
            this.mKey = person.mKey;
            this.mIsBot = person.mIsBot;
            this.mIsImportant = person.mIsImportant;
        }
    }

    public Person(Builder builder) {
        this.mName = builder.mName;
        this.mIcon = builder.mIcon;
        this.mUri = builder.mUri;
        this.mKey = builder.mKey;
        this.mIsBot = builder.mIsBot;
        this.mIsImportant = builder.mIsImportant;
    }

    public static Person fromAndroidPerson(android.app.Person person) {
        return new Builder().setName(person.getName()).setIcon(person.getIcon() != null ? IconCompat.createFromIcon(person.getIcon()) : null).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
    }

    public static Person fromBundle(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new Builder().setName(bundle.getCharSequence("name")).setIcon(bundle2 != null ? IconCompat.createFromBundle(bundle2) : null).setUri(bundle.getString("uri")).setKey(bundle.getString("key")).setBot(bundle.getBoolean(IS_BOT_KEY)).setImportant(bundle.getBoolean(IS_IMPORTANT_KEY)).build();
    }

    public static Person fromPersistableBundle(PersistableBundle persistableBundle) {
        return new Builder().setName(persistableBundle.getString("name")).setUri(persistableBundle.getString("uri")).setKey(persistableBundle.getString("key")).setBot(persistableBundle.getBoolean(IS_BOT_KEY)).setImportant(persistableBundle.getBoolean(IS_IMPORTANT_KEY)).build();
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getKey() {
        return this.mKey;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    public String resolveToLegacyUri() {
        String str = this.mUri;
        if (str != null) {
            return str;
        }
        if (this.mName == null) {
            return "";
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("name:");
        outline73.append(this.mName);
        return outline73.toString();
    }

    public android.app.Person toAndroidPerson() {
        return new android.app.Person.Builder().setName(getName()).setIcon(getIcon() != null ? getIcon().toIcon() : null).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.mName);
        IconCompat iconCompat = this.mIcon;
        Bundle bundle2 = null;
        if (iconCompat != null) {
            if (iconCompat != null) {
                bundle2 = new Bundle();
                switch (iconCompat.mType) {
                    case -1:
                        bundle2.putParcelable("obj", (Parcelable) iconCompat.mObj1);
                        break;
                    case 1:
                    case 5:
                        bundle2.putParcelable("obj", (Bitmap) iconCompat.mObj1);
                        break;
                    case 2:
                    case 4:
                    case 6:
                        bundle2.putString("obj", (String) iconCompat.mObj1);
                        break;
                    case 3:
                        bundle2.putByteArray("obj", (byte[]) iconCompat.mObj1);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid icon");
                }
                bundle2.putInt("type", iconCompat.mType);
                bundle2.putInt("int1", iconCompat.mInt1);
                bundle2.putInt("int2", iconCompat.mInt2);
                bundle2.putString("string1", iconCompat.mString1);
                ColorStateList colorStateList = iconCompat.mTintList;
                if (colorStateList != null) {
                    bundle2.putParcelable("tint_list", colorStateList);
                }
                Mode mode = iconCompat.mTintMode;
                if (mode != IconCompat.DEFAULT_TINT_MODE) {
                    bundle2.putString("tint_mode", mode.name());
                }
            } else {
                throw null;
            }
        }
        bundle.putBundle("icon", bundle2);
        bundle.putString("uri", this.mUri);
        bundle.putString("key", this.mKey);
        bundle.putBoolean(IS_BOT_KEY, this.mIsBot);
        bundle.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return bundle;
    }

    public PersistableBundle toPersistableBundle() {
        PersistableBundle persistableBundle = new PersistableBundle();
        CharSequence charSequence = this.mName;
        persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
        persistableBundle.putString("uri", this.mUri);
        persistableBundle.putString("key", this.mKey);
        persistableBundle.putBoolean(IS_BOT_KEY, this.mIsBot);
        persistableBundle.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return persistableBundle;
    }
}
