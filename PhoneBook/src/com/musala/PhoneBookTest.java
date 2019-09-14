package com.musala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    PhoneBook phoneBook= new PhoneBook();
    @Test
    void addNewPair() {
        phoneBook.addNewPair("mName","00359874123456");
        assertEquals(1,phoneBook.phones.size());
    }

    @Test
    void deletePairByName() {
        createPhoneBook();
        phoneBook.deletePairByName("aName");
        assertEquals(4,phoneBook.phones.size());
    }

    @Test
    void printSortedPhoneNumbers() {
        createPhoneBook();
        phoneBook.printSortedPhoneNumbers();
    }

    private void createPhoneBook() {
        phoneBook.addNewPair("mName","00359874123456");
        phoneBook.addNewPair("aName","+359874123456");
        phoneBook.addNewPair("bName","0874123456");
        phoneBook.addNewPair("xName","+359872123456");
        phoneBook.addNewPair("lName","+359874123456");
    }

    @Test
    void getPhoneNumberByName() {
        createPhoneBook();
        phoneBook.getPhoneNumberByName("bName");
    }
}