package androidx.databinding;

public interface Observable {

    public static abstract class OnPropertyChangedCallback {
    }

    void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);

    void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);
}
