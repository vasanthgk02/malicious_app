package sfs2x.client.entities.managers;

import java.util.List;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.User;

public interface IUserManager {
    void addUser(User user);

    boolean containsUser(User user);

    boolean containsUserId(int i);

    boolean containsUserName(String str);

    ISmartFox getSmartFox();

    User getUserById(int i);

    User getUserByName(String str);

    int getUserCount();

    List<User> getUserList();

    void removeUser(User user);

    void removeUserById(int i);

    void replaceAll(List<User> list);
}
