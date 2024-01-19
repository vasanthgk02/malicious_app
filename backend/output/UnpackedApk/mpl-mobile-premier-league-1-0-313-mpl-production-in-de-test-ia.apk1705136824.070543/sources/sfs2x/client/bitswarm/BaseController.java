package sfs2x.client.bitswarm;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController implements IController {
    public short id = -1;
    public final Logger log = LoggerFactory.getLogger(getClass());

    public short getId() {
        return this.id;
    }

    public void handleMessage(IMessage iMessage) {
        Logger logger = this.log;
        logger.info("System controller got request: " + iMessage);
    }

    public void setId(short s) {
        if (this.id == -1) {
            this.id = s;
            return;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline57(new StringBuilder("Controller ID is already set: "), this.id, ". Can't be changed at runtime!"));
    }
}
