package com.freshchat.consumer.sdk.beans;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class FCLocale {
    public String country;
    public String direction;
    public String displayCode;
    public String displayName;
    public String extension;
    public String language;
    public long localeId;
    public String region;
    public String script;
    public String variant;

    public static FCLocale fromString(String str) {
        try {
            return (FCLocale) new Gson().fromJson(str, FCLocale.class);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    public String getCountry() {
        return this.country;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getDisplayCode() {
        return this.displayCode;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getExtension() {
        return this.extension;
    }

    public String getLanguage() {
        return this.language;
    }

    public long getLocaleId() {
        return this.localeId;
    }

    public String getRegion() {
        return this.region;
    }

    public String getScript() {
        return this.script;
    }

    public String getVariant() {
        return this.variant;
    }

    public FCLocale setCountry(String str) {
        this.country = str;
        return this;
    }

    public FCLocale setDirection(String str) {
        this.direction = str;
        return this;
    }

    public FCLocale setDisplayCode(String str) {
        this.displayCode = str;
        return this;
    }

    public FCLocale setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public FCLocale setExtension(String str) {
        this.extension = str;
        return this;
    }

    public FCLocale setLanguage(String str) {
        this.language = str;
        return this;
    }

    public FCLocale setLocaleId(long j) {
        this.localeId = j;
        return this;
    }

    public FCLocale setRegion(String str) {
        this.region = str;
        return this;
    }

    public FCLocale setScript(String str) {
        this.script = str;
        return this;
    }

    public FCLocale setVariant(String str) {
        this.variant = str;
        return this;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("FCLocale{", "localeId='");
        outline77.append(this.localeId);
        outline77.append(ExtendedMessageFormat.QUOTE);
        outline77.append(", language='");
        GeneratedOutlineSupport.outline99(outline77, this.language, ExtendedMessageFormat.QUOTE, ", script='");
        GeneratedOutlineSupport.outline99(outline77, this.script, ExtendedMessageFormat.QUOTE, ", region='");
        GeneratedOutlineSupport.outline99(outline77, this.region, ExtendedMessageFormat.QUOTE, ", country='");
        GeneratedOutlineSupport.outline99(outline77, this.country, ExtendedMessageFormat.QUOTE, ", variant='");
        GeneratedOutlineSupport.outline99(outline77, this.variant, ExtendedMessageFormat.QUOTE, ", extension='");
        GeneratedOutlineSupport.outline99(outline77, this.extension, ExtendedMessageFormat.QUOTE, ", displayCode='");
        GeneratedOutlineSupport.outline99(outline77, this.displayCode, ExtendedMessageFormat.QUOTE, ", displayName='");
        GeneratedOutlineSupport.outline99(outline77, this.displayName, ExtendedMessageFormat.QUOTE, ", direction='");
        return GeneratedOutlineSupport.outline60(outline77, this.direction, ExtendedMessageFormat.QUOTE, '}');
    }
}
