package com.cardinalcommerce.shared.userinterfaces;

import com.cardinalcommerce.shared.models.enums.ButtonType;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import java.io.Serializable;
import java.util.HashMap;

public class UiCustomization implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, ButtonCustomization> f2234d = new HashMap<>();

    public ButtonCustomization getButtonCustomization(ButtonType buttonType) {
        Throwable th = new Throwable("Caught in ButtonCustomization.setButtonCustomization");
        if (buttonType != null) {
            try {
                return this.f2234d.get(buttonType.name());
            } catch (Exception unused) {
                return null;
            }
        } else {
            throw new InvalidInputException("InvalidInputException", th);
        }
    }
}
