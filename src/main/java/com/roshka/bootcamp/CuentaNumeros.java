package com.roshka.bootcamp;

import java.util.*;
public class CuentaNumeros {
    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        ArrayList<Long> retorno = new ArrayList<>();
        int max = 0,min = 0 ,cantidad,num,numMin=0,numMax=0;

        for(int i = 0; i < numDigits ; i++){
            max = (int) (max + 9*(Math.pow(10,i)));
            min = (int) (min + 1*(Math.pow(10,i)));
        }
        cantidad=0;
        for(num = min ; num <= max ; num++ ){
            if(verificar(num,sumDigits,numDigits)){
                if(cantidad == 0){
                    numMin = num;
                    numMax = num;
                }else if(numMin > num){
                    numMin = num;
                }else if(numMax < num){
                    numMax = num;
                }
                cantidad++;
            }
        }
        if(cantidad == 0)
            return new ArrayList<>();

        retorno.add((long) cantidad);
        retorno.add((long) numMin);
        retorno.add((long) numMax);
        return retorno;
    }
    private static boolean verificar(int num,int sumDigits,int numDigits) {
        int digito,suma=0;
        int[] numero = new int[numDigits];
        int i = numDigits - 1;
        while(num > 0)
        {
            digito = num % 10;
            suma = suma + digito;
            num = num / 10;
            numero[i] = digito;
            i--;
        }
        for(i = 0 ; i < numDigits -1 ; i++){
            if(numero[i]>numero[i+1])
                return false;
        }

        if(i == numDigits - 1 && suma == sumDigits) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Long> lista = (ArrayList<Long>) findAll(35,6);
        for(int i = 0;i < lista.size() ; i++ ){
            System.out.println(lista.get(i));
        }
    }
}

