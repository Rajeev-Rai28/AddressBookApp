package com.addressbookapp.storage;

import com.addressbookapp.model.Contact;
import com.addressbookapp.util.AddressBookFileIO;

import java.util.List;

public class FileStorage implements ContactStorage {

    @Override
    public void save(String filePath, List<Contact> contacts) {
        AddressBookFileIO.writeContactsToFile(filePath, contacts);
    }

    @Override
    public List<Contact> load(String filePath) {
        return AddressBookFileIO.readContactsFromFile(filePath);
    }
}