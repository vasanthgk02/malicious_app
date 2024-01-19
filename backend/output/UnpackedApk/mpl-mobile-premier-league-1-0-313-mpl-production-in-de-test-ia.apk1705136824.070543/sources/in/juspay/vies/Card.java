package in.juspay.vies;

import androidx.annotation.Keep;
import in.juspay.hypersdk.core.JuspayLogger;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class Card {
    public String alias;
    public String bin;
    public String maskedCard;

    public String getAlias() {
        return this.alias;
    }

    public String getBin() {
        return this.bin;
    }

    public String getMaskedCard() {
        return this.maskedCard;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setBin(String str) {
        this.bin = str;
    }

    public void setMaskedCard(String str) {
        this.maskedCard = str;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bin", getBin());
            jSONObject.put("alias", getAlias());
            jSONObject.put("masked_card", getMaskedCard());
        } catch (JSONException e2) {
            JuspayLogger.e("CARD", "Error while converting to JSON", e2);
        }
        return jSONObject;
    }

    public String toString() {
        return toJSON().toString();
    }
}
