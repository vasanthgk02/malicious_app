package org.apache.pdfbox.contentstream.operator.state;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingIntent;
import sfs2x.client.requests.game.InviteUsersRequest;

public class SetRenderingIntent extends OperatorProcessor {
    public String getName() {
        return InviteUsersRequest.KEY_REPLY_ID;
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.getGraphicsState().setRenderingIntent(RenderingIntent.fromString(((COSName) list.get(0)).getName()));
    }
}
