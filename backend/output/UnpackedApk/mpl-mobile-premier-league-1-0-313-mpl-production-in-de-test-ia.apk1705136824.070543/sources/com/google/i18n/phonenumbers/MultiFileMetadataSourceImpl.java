package com.google.i18n.phonenumbers;

import java.util.concurrent.ConcurrentHashMap;

public final class MultiFileMetadataSourceImpl {
    public final ConcurrentHashMap<String, Phonemetadata$PhoneMetadata> geographicalRegions = new ConcurrentHashMap<>();
    public final MetadataLoader metadataLoader;
    public final ConcurrentHashMap<Integer, Phonemetadata$PhoneMetadata> nonGeographicalRegions = new ConcurrentHashMap<>();
    public final String phoneNumberMetadataFilePrefix = "/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto";

    public MultiFileMetadataSourceImpl(MetadataLoader metadataLoader2) {
        this.metadataLoader = metadataLoader2;
    }
}
