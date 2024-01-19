package sfs2x.client.entities.managers;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.User;

public class SFSGlobalUserManager extends SFSUserManager {
    public Map<User, Integer> roomRefCount = new HashMap();

    public SFSGlobalUserManager(ISmartFox iSmartFox) {
        super(iSmartFox);
    }

    public void addUser(User user) {
        if (!this.roomRefCount.containsKey(user)) {
            super.addUser(user);
            this.roomRefCount.put(user, Integer.valueOf(1));
            return;
        }
        this.roomRefCount.put(user, Integer.valueOf(this.roomRefCount.get(user).intValue() + 1));
    }

    public void removeUser(User user) {
        if (!this.roomRefCount.containsKey(user)) {
            Logger logger = this.smartFox.getLogger();
            logger.warn("Can't remove User from GlobalUserManager. RefCount missing. User: " + user);
        } else if (this.roomRefCount.get(user).intValue() < 1) {
            Logger logger2 = this.smartFox.getLogger();
            logger2.warn("GlobalUserManager RefCount is already at zero. User: " + user);
        } else {
            this.roomRefCount.put(user, Integer.valueOf(this.roomRefCount.get(user).intValue() - 1));
            if (this.roomRefCount.get(user).intValue() == 0) {
                super.removeUser(user);
                this.roomRefCount.remove(user);
            }
        }
    }
}
