package com.musala;

import java.io.*;
import java.util.TreeMap;

/**
 * A class to do operations in a Phonebook.
 *
 * <h3>PhoneBook</h3>
 *
 * The use of this class will help to work with a Phonebook.
 *
 */

class PhoneBook {

    /** TreeMap of phones in the Phonebook. */
    private TreeMap<String,String> phones;
    


    /**
     * Construct a new <code>PhoneBook</code> method will init the
     * phones TreeMap to after add new correct phones.
     */
    PhoneBook() {
        this.phones = new TreeMap<>();
    }

    TreeMap<String, String> getPhones() {
        return phones;
    }

    /**
     * Insert all corrects elements given in {@code fileName},
     * the method will arrive to the end of {@code fileName} and insert the corrects combinations of phone numbers.
     *
     * @param fileName complete path to the current file
     */
    void addFromFile(String fileName) {

        try{
            File mFile= new File(fileName);
            BufferedReader bReader = new BufferedReader(new FileReader(mFile));
            String line;
            while((line = bReader.readLine()) !=null){
                String name=line.split(",")[0];
                String phone=line.split(",")[1];
                addNewPair(name, phone.substring(1));
            }
        }catch (FileNotFoundException ex){
            System.out.println("Error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert the {@code name} and the {@code phone} to the list if the {@code phone} have an accepted combination,
     * TreeMap will insert data in {@code name} alphabetical order
     *
     * @param name the name of the pair this will be the key of the TreeMap
     * @param phone the phone number to add
     */

    void addNewPair(String name, String phone){
        String countryCode;
        int operatorCode;
        int digit;

        if((phone.startsWith("+") && phone.length()==13) || (phone.substring(0,2).equals("00") && phone.length()==14)){
            try{
                if(phone.startsWith("+")){
                    Integer.parseInt(phone.substring(7));
                    countryCode=phone.substring(1,4);
                    operatorCode=Integer.parseInt(phone.substring(4,6));
                    digit=Integer.parseInt(phone.substring(6,7));
                }else{
                    Integer.parseInt(phone.substring(8));
                    countryCode=phone.substring(2,5);
                    operatorCode=Integer.parseInt(phone.substring(5,7));
                    digit=Integer.parseInt(phone.substring(7,8));
                }

                if(countryCode.equals("359") && (operatorCode >= 87 && operatorCode <= 89) && (digit >=2)){
                    String resultPhone;
                    if(phone.startsWith("+")){
                        resultPhone=phone;
                    }else{
                        resultPhone="+"+phone.substring(2);
                    }


                    phones.put(name,resultPhone);
                }
            }catch (NumberFormatException e){
                e.printStackTrace();
            }

        }else if(phone.startsWith("0") && phone.length()==10){
            try{
                Integer.parseInt(phone.substring(4));
                operatorCode=Integer.parseInt(phone.substring(1,3));
                digit=Integer.parseInt(phone.substring(3,4));

                if((operatorCode >= 87 && operatorCode <= 89) && (digit >=2)){
                    phones.put(name,"+359"+phone.substring(1));
                }
            }catch (NumberFormatException e){
                e.printStackTrace();
            }

        }
    }

 /**
     * Delete an element from phones TreeMap, when the element is found the for sentence will break.
     *
     * @param name the random name provide in the TreeMap
     */

 void deletePairByName(String name){
        phones.remove(name);
    }

    /**
     * Returns the phone number correspond to the {@code name} given , null if {@code name} is not present in phones TreeMap.
     *
     * @param name the random name provide in the TreeMap
     *
     */

    String getPhoneNumberByName(String name){
        System.out.print(phones.get(name));
        return phones.get(name);
    }

    /**
     * Print all pairs of phone number sorted by phone number in text format.
     *
     */


    void printSortedPhoneNumbers(){
        System.out.print(phones);
    }


}
