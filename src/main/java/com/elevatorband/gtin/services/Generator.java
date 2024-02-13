package com.elevatorband.gtin.services;
import java.util.Arrays;
import java.util.Random;

public class Generator {
    public String generate (int length) throws Exception {
        if(length == 8 || length == 13 || length == 14){
            Random rand = new Random();
            int[] gtin = new int[length];
            for (int i = 0; i < length-1; i++) {
                gtin[i] = rand.nextInt(9);
            }

            boolean isOdd = true;
            int sum = 0;
            for(int i=gtin.length-2 ; i>=0 ; i-- ){
                if(isOdd){
                    sum = sum + gtin[i]*3;
                }else{
                    sum = sum + gtin[i];
                }
                isOdd = !isOdd;
            }

            gtin[length-1] = 10 + ((10-sum)%10);

            String stringGtin = "";
            for (int i : gtin) {
                stringGtin = stringGtin + i;
            }


            return stringGtin;
        }
        throw new Exception("please use either 8, 13 or 14!");
    }
}
