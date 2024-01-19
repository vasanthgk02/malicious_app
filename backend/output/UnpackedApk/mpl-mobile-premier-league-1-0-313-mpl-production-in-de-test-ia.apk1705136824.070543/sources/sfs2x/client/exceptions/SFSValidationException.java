package sfs2x.client.exceptions;

import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SFSValidationException extends SFSException {
    public final List<String> errors;

    public SFSValidationException(String str, List<String> list) {
        super(str);
        this.errors = new ArrayList(list);
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(this.errors);
    }
}
