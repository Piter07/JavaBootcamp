package com.roshka.bootcamp;

import java.util.ArrayList;


public class SmallerNumberSameDigits {
    public static long nextSmaller(long n)
    {
        long i;
        for( i = n-1 ; i >= 0 ; i--){
            if(verificar(i,n)){
                break;
            }
        }

        return i;
    }

    private static boolean verificar(long n1, long n2) {

        StringBuilder num1 = new StringBuilder(String.valueOf(n1));
        StringBuilder num2 = new StringBuilder(String.valueOf(n2));
        int cont = 0;
        if(num1.length() != num2.length())
            return false;
        for(int i = 0 ; i < num1.length() ; i++){
            for(int j = 0 ; j < num2.length() ; j++){
                if(num2.charAt(i) == num1.charAt(j)){
                    cont++;
                    num1.setCharAt(j,'*');
                    break;
                }
            }
        }
        if(cont == num1.length()){
            return true;
        }
        return false;
    }


    /*public static void main(String[] args) {
        SmallerNumberSameDigits ejemplo = new SmallerNumberSameDigits();
        System.out.println(ejemplo.nextSmaller(21));
        System.out.println(ejemplo.nextSmaller(907));
        System.out.println(ejemplo.nextSmaller(531));
        System.out.println(ejemplo.nextSmaller(1027));
        System.out.println(ejemplo.nextSmaller(441));
        System.out.println(ejemplo.nextSmaller(123456798));

    }*/
}
