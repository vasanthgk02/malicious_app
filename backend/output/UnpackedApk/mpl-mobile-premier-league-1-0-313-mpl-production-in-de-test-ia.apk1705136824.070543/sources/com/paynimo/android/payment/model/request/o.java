package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class o implements Serializable {
    public static final long serialVersionUID = 1;
    public String description = "";
    public String identifier = "";
    public String responseEndpointURL = "";
    public String responseType = "";
    public String webhookEndpointURL = "";
    public String webhookType = "";

    public String getDescription() {
        return this.description;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getResponseEndpointURL() {
        return this.responseEndpointURL;
    }

    public String getResponseType() {
        return this.responseType;
    }

    public String getWebhookEndpointURL() {
        return this.webhookEndpointURL;
    }

    public String getWebhookType() {
        return this.webhookType;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setResponseEndpointURL(String str) {
        this.responseEndpointURL = str;
    }

    public void setResponseType(String str) {
        this.responseType = str;
    }

    public void setWebhookEndpointURL(String str) {
        this.webhookEndpointURL = str;
    }

    public void setWebhookType(String str) {
        this.webhookType = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Merchant [identifier=");
        outline73.append(this.identifier);
        outline73.append(", responseType=");
        outline73.append(this.responseType);
        outline73.append(", description=");
        outline73.append(this.description);
        outline73.append(", responseEndpointURL=");
        outline73.append(this.responseEndpointURL);
        outline73.append(", webhookType=");
        outline73.append(this.webhookType);
        outline73.append(", webhookEndpointURL=");
        return GeneratedOutlineSupport.outline62(outline73, this.webhookEndpointURL, CMapParser.MARK_END_OF_ARRAY);
    }
}
