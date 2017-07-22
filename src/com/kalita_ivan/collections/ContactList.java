package com.kalita_ivan.collections;

import java.util.HashMap;
import java.util.HashSet;

class ContactList {
    private HashMap<String, HashSet<String>> storage;

    ContactList() {
        storage = new HashMap<>();
    }

    void add(String secondName, String phone) {
        HashSet<String> phones = storage.getOrDefault(secondName, null);
        if (phones == null) {
            phones = new HashSet<>();
            storage.put(secondName, phones);
        }
        phones.add(phone);
    }

    HashSet<String> get(String secondName) {
        return storage.getOrDefault(secondName, new HashSet<>());
    }
}
