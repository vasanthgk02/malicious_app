package com.mpl.androidapp.database.dao;

import com.mpl.androidapp.database.entity.Contact;
import java.util.List;

public interface ContactDao {
    void delete(Contact contact);

    void deleteAllContact();

    int deleteByContactId(List<String> list);

    List<Contact> getAllContacts();

    int getAllContactsCount();

    List<Contact> getAllMPLContacts();

    List<Contact> getAllNoNMPLContacts();

    Contact getContactBasedOnMplId(String str);

    List<Contact> getContactsBasedOnMplId(String[] strArr);

    List<Contact> getContactsForReactSync();

    List<Contact> getContactsForSyncServer();

    List<Contact> getContactsNameFromLocal(List<String> list);

    List<Contact> getContactsSearchBasedOnName(String str);

    List<Contact> getContactsSearchBasedOnNumber(String str, String str2);

    List<Contact> getDeletedContactsBasedOnContactIds(List<String> list);

    List<Contact> getSingleContactBasedOnId(String str);

    void insert(Contact contact);

    void update(Contact contact);

    void updateMplIds(String str, List<String> list);
}
