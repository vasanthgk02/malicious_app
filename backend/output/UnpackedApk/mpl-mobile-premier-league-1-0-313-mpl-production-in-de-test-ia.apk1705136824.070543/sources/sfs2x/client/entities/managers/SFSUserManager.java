package sfs2x.client.entities.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.User;

public class SFSUserManager implements IUserManager {
    public Lock globalLock = new ReentrantLock();
    public ISmartFox smartFox;
    public Map<Integer, User> usersById = new HashMap();
    public Map<String, User> usersByName = new HashMap();

    public SFSUserManager(ISmartFox iSmartFox) {
        this.smartFox = iSmartFox;
    }

    public void addUser(User user) {
        this.globalLock.lock();
        try {
            if (!(!this.usersById.containsKey(Integer.valueOf(user.getId())) || this.smartFox == null || this.smartFox.getLogger() == null)) {
                Logger logger = this.smartFox.getLogger();
                logger.warn("Unexpected: duplicate user in UserManager: " + user);
            }
            addUserInternal(user);
        } finally {
            this.globalLock.unlock();
        }
    }

    public void addUserInternal(User user) {
        this.globalLock.lock();
        try {
            this.usersByName.put(user.getName(), user);
            this.usersById.put(Integer.valueOf(user.getId()), user);
        } finally {
            this.globalLock.unlock();
        }
    }

    public boolean containsUser(User user) {
        this.globalLock.lock();
        try {
            return this.usersByName.containsValue(user);
        } finally {
            this.globalLock.unlock();
        }
    }

    public boolean containsUserId(int i) {
        this.globalLock.lock();
        try {
            return this.usersById.containsKey(Integer.valueOf(i));
        } finally {
            this.globalLock.unlock();
        }
    }

    public boolean containsUserName(String str) {
        this.globalLock.lock();
        try {
            return this.usersByName.containsKey(str);
        } finally {
            this.globalLock.unlock();
        }
    }

    public ISmartFox getSmartFox() {
        return this.smartFox;
    }

    /* JADX INFO: finally extract failed */
    public User getUserById(int i) {
        this.globalLock.lock();
        try {
            if (!this.usersById.containsKey(Integer.valueOf(i))) {
                this.globalLock.unlock();
                return null;
            }
            User user = this.usersById.get(Integer.valueOf(i));
            this.globalLock.unlock();
            return user;
        } catch (Throwable th) {
            this.globalLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public User getUserByName(String str) {
        this.globalLock.lock();
        try {
            if (!this.usersByName.containsKey(str)) {
                this.globalLock.unlock();
                return null;
            }
            User user = this.usersByName.get(str);
            this.globalLock.unlock();
            return user;
        } catch (Throwable th) {
            this.globalLock.unlock();
            throw th;
        }
    }

    public int getUserCount() {
        this.globalLock.lock();
        try {
            return this.usersById.size();
        } finally {
            this.globalLock.unlock();
        }
    }

    public List<User> getUserList() {
        this.globalLock.lock();
        try {
            return new ArrayList(this.usersById.values());
        } finally {
            this.globalLock.unlock();
        }
    }

    public void removeUser(User user) {
        this.globalLock.lock();
        try {
            this.usersByName.remove(user.getName());
            this.usersById.remove(Integer.valueOf(user.getId()));
        } finally {
            this.globalLock.unlock();
        }
    }

    public void removeUserById(int i) {
        this.globalLock.lock();
        try {
            if (this.usersById.containsKey(Integer.valueOf(i))) {
                removeUser(this.usersById.get(Integer.valueOf(i)));
            }
        } finally {
            this.globalLock.unlock();
        }
    }

    public void replaceAll(List<User> list) {
        this.globalLock.lock();
        try {
            this.usersById.clear();
            this.usersByName.clear();
            for (User addUser : list) {
                addUser(addUser);
            }
        } finally {
            this.globalLock.unlock();
        }
    }
}
