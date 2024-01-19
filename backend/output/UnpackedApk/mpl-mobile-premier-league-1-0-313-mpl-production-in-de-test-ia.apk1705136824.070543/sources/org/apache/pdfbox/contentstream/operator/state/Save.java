package org.apache.pdfbox.contentstream.operator.state;

import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import sfs2x.client.requests.mmo.SetUserPositionRequest;

public class Save extends OperatorProcessor {
    public String getName() {
        return SetUserPositionRequest.KEY_PLUS_ITEM_LIST;
    }

    public void process(Operator operator, List<COSBase> list) {
        this.context.saveGraphicsState();
    }
}
