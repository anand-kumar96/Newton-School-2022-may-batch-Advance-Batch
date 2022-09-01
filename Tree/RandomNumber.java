package com.company.Newton_School.AdvanceDataStructure.Tree;

import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        // approach 01--> using random class
        Random rand=new Random();
       int randomInt =rand.nextInt(10000);// we have to provide number of digit--> rand.nextInt(10)-->  take any numb from 0 to 9
                                                           //  rand.nextInt(100)-->0 to 99---> max limit is 999 i.e.  rand.nextInt(1000)
        System.out.println(randomInt); // numb between 0 to 9-->5 // doubt also work? why


       // to generate decimal
        double rand_doub=rand.nextDouble();// range 0.0 to less than 1.0
        System.out.println(rand_doub);

/*
// approach 02-->Math class  --> by default we generate decimal number
        System.out.println(Math.random());//0.0 to less than 1.0
        // generating 10 random integer
        for(int i=0;i<10;i++){
            int rand_Int=(int)(Math.random()*100);
            System.out.print(rand_Int+" ");
        }

        // approach 03-->third party ApI-->Apache common.lang API--> to generate random number and string
        // we have to download some API

        */

    }
}
