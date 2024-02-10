package com.elevatorband.gtin.services;

import java.util.HashSet;
import java.util.Set;

public class Validator
{
    //Validator should verify that any given GTIN number follows proper format and data rules.
    //Must accept a string of numbers and letters, and output a boolean true or false
    //whether the provided number is valid or not.
    //Possible lengths: 8, 13, 14 digits.
    //https://www.gs1us.org/content/dam/gs1us/documents/tools-resources/check-digit-calculator/How-to-Calculate-a-Check-Digit.pdf

//    int[] tryGtin8 = {1,2,3,4,5,6,7,8};
//    String tryGtin13 = "1234567890123";
//    String tryGtin14 = "12345678901234";
//    //String gtin = tryGtin8;
//    try{
//       isValidNumber(tryGtin8);
//    }
//    catch{
//
//    }
    public boolean isValidNumber(int[] arr){
        Set<Integer> possibleLengths = new HashSet<>();
        possibleLengths.add(8);
        possibleLengths.add(13);
        possibleLengths.add(14);
        int currentLength = possibleLengths.size();
        possibleLengths.add(arr.length);
        if (possibleLengths.size()!=currentLength){
            return false;
        }

        boolean isOdd = true;
        int sum = 0;
        for(int i=arr.length-2 ; i>=0 ; i-- ){
            if(isOdd){
                sum = sum + arr[i]*3;
            }else{
                sum = sum + arr[i];
            }
            isOdd = !isOdd;
        }
        int result = (10-sum)%10;
        return result==arr[arr.length-1];
    }
    public int[] integerParser(String str){

        String[] strArr = str.split("");
        int index = str.length();
        int[] tryGtin = new int[index];
        for (int i = 0; i < index; i++) {
            try {
                tryGtin[i]=Integer.parseInt(strArr[i]);
            }catch (Exception e){
                System.out.println("Provide a valid gtin number!");
            }
        }
        return tryGtin;
    }


}
