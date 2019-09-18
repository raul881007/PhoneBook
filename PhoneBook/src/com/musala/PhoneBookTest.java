package com.musala;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private PhoneBook phoneBook= new PhoneBook();
    @Test
    void addNewPair() {
        phoneBook.addNewPair("mName","00359874123456");
        assertEquals(1,phoneBook.getPhones().size());
    }

    @Test
    void deletePairByName() {
        createPhoneBook();
        phoneBook.deletePairByName("Uncle");
        assertEquals(5,phoneBook.getPhones().size());
    }

    @Test
    void printSortedPhoneNumbers() {
        createPhoneBook();
        phoneBook.printSortedPhoneNumbers();
    }

    private void createPhoneBook() {
        phoneBook.addNewPair("Mom","00359874123416");
        phoneBook.addNewPair("Sister","0874123436");
        phoneBook.addNewPair("Uncle","+359872123446");
        phoneBook.addNewPair("Bob","+359874123456");
        phoneBook.addNewPair("Dad","+359874123426");
        phoneBook.addNewPair("Brad","+359874123356");
    }

    @Test
    void getPhoneNumberByName() {
        createPhoneBook();
        phoneBook.getPhoneNumberByName("Uncle");
    }

    @Test
    void addFromFile() {
        phoneBook.addFromFile("/Users/equipo/Desktop/PhoneBookFile.txt");
        assertEquals(6,phoneBook.getPhones().size());
    }

    @Test
    void printSortedOutgoingCalls() {
        HashMap<Map.Entry<String,String>,Integer> outgoingCalls= new HashMap<>();
        HashMap<String,String> callsData = new HashMap<>();
        callsData.put("Bob","+359874123456");
        callsData.put("Sister","+359874123436");
        callsData.put("Uncle","+359872123446");
        callsData.put("Dad","+359874123426");
        callsData.put("Mom","+359874123416");
        callsData.put("Brad","+359874123356");
        callsData.put("Steve","+359874124356");
        callsData.put("Paul","+359874125356");
        callsData.put("Anna","+359874725356");
        for(Map.Entry<String,String> currentEntry:callsData.entrySet()){
            outgoingCalls.put(currentEntry,new Random().nextInt(50));
        }
        phoneBook.printSortedOutgoingCalls(outgoingCalls);
    }
}