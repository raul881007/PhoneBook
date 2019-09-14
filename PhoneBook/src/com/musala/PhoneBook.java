package com.musala;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * A class to do operations in a Phonebook.
 *
 * <h3>PhoneBook</h3>
 *
 * The use of this class will help to work with a Phonebook.
 *
 */

public  class PhoneBook {

    /** TreeMap of phones in the Phonebook. */
    TreeMap<String,String> phones;
    


    /**
     * Construct a new <code>PhoneBook</code> method will init the
     * phones TreeMap to after add new correct phones.
     */
    public PhoneBook() {
        this.phones = new TreeMap<>();
    }

    /**
     * Insert all corrects elements given in {@code fileName},
     * the method will arrive to the end of {@code fileName} and insert the corrects combinations of phone numbers.
     *
     * @param fileName complete path to the current file
     */
    public void addFromFile(String fileName) {

        try{
            File mFile= new File(fileName);
            Scanner scanner = new Scanner(mFile);
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String name=line.split(",")[0];
                String phone=line.split(",")[1];
                addNewPair(name, phone);
            }
        }catch (FileNotFoundException ex){

        }
    }

    /**
     * Insert the {@code name} and the {@code phone} to the list if the {@code phone} have the accepted combination,
     * TreeMap will insert data in name alphabetical order
     *
     * @param name the name of the pair this will be the key of the TreeMap
     * @param phone the phone number to add
     */

    public void addNewPair(String name,String phone){
        String countryCode="";
        int operatorCode=0;
        int digit=0;
        int number=0;

        if((phone.startsWith("+") && phone.length()==13) || (phone.substring(0,2).equals("00") && phone.length()==14)){
            try{
                if(phone.startsWith("+")){
                    number=Integer.parseInt(phone.substring(7));
                    countryCode=phone.substring(1,4);
                    operatorCode=Integer.parseInt(phone.substring(4,6));
                    digit=Integer.parseInt(phone.substring(6,7));
                }else{
                    number=Integer.parseInt(phone.substring(8));
                    countryCode=phone.substring(2,5);
                    operatorCode=Integer.parseInt(phone.substring(5,7));
                    digit=Integer.parseInt(phone.substring(7,8));
                }

                if(countryCode.equals("359") && (operatorCode >= 87 && operatorCode <= 89) && (digit >=2)){
                    String resultPhone="";
                    if(phone.startsWith("+")){
                        resultPhone=phone;
                    }else{
                        resultPhone="+"+phone.substring(2);
                    }


                    phones.put(name,resultPhone);
                }
            }catch (NumberFormatException e){

            }

        }else if(phone.startsWith("0") && phone.length()==10){
            try{
                number=Integer.parseInt(phone.substring(4));
                operatorCode=Integer.parseInt(phone.substring(1,3));
                digit=Integer.parseInt(phone.substring(3,4));

                if((operatorCode >= 87 && operatorCode <= 89) && (digit >=2)){
                    phones.put(name,"+359"+phone.substring(1));
                }
            }catch (NumberFormatException e){

            }

        }
    }




}
