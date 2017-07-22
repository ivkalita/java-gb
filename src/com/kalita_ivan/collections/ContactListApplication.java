package com.kalita_ivan.collections;

public class ContactListApplication {
    public static void main(String[] args) {
        ContactList contacts = new ContactList();
        contacts.add("doe", "+70000000000");
        contacts.add("silver", "+70000000001");
        contacts.add("doe", "+70000000000");
        contacts.add("doe", "+70000000005");

        System.out.println("Doe phones:");
        for (String phone: contacts.get("doe")) {
            System.out.println(phone);
        }

        System.out.println("Silver phones:");
        for (String phone: contacts.get("silver")) {
            System.out.println(phone);
        }

        System.out.println("Noname phones:");
        for (String phone: contacts.get("noname")) {
            System.out.println(phone);
        }
    }
}
