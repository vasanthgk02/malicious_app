package com.cardinalcommerce.emvco.events;

import com.cardinalcommerce.shared.models.ErrorMessage;

public class ProtocolErrorEvent extends ThreeDSEvent {
    public ProtocolErrorEvent(String str, ErrorMessage errorMessage) {
    }
}
