package com.addressbookapp.storage;

import com.addressbookapp.model.Contact;
import com.addressbookapp.util.AddressBookJSONIO;

import java.util.List;

public class JSONStorage implements ContactStorage {

    @Override
    public void save(String filePath, List<Contact> contacts) {
        AddressBookJSONIO.writeContactsToJSON(filePath, contacts);
    }

    @Override
    public List<Contact> load(String filePath) {
        return AddressBookJSONIO.readContactsFromJSON(filePath);
    }
}