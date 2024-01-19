package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Phonemetadata$PhoneMetadataCollection implements Externalizable {
    public static final long serialVersionUID = 1;
    public List<Phonemetadata$PhoneMetadata> metadata_ = new ArrayList();

    public void readExternal(ObjectInput objectInput) throws IOException {
        int readInt = objectInput.readInt();
        for (int i = 0; i < readInt; i++) {
            Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata = new Phonemetadata$PhoneMetadata();
            phonemetadata$PhoneMetadata.readExternal(objectInput);
            this.metadata_.add(phonemetadata$PhoneMetadata);
        }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        int size = this.metadata_.size();
        objectOutput.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.metadata_.get(i).writeExternal(objectOutput);
        }
    }
}
