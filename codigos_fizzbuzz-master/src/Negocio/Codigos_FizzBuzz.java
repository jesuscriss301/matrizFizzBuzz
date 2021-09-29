/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 * Plantilla inicial códigos de FizzBuzz
 * @author jesusManuelcp
 */
public class Codigos_FizzBuzz {
    
    
    private char [][]matrizFizzBuzz;

    /**
     * Constructor para códigoss
     * @param i límite inicial 
     * @param n límite final
     * @param m particiones
     */
    public Codigos_FizzBuzz(int i, int n, int m) {
        if (m <= 0 || n < 0 || i < 0)
	   throw new RuntimeException("Datos invalidos, ingrese valores mayores a cero");

        this.matrizFizzBuzz= new char[n+1][];
        int []numeros;
        int j , aux = i;
        for (j = 0; aux <= (i+n); j++) {
            numeros = this.patirNumeros(aux, m);
            this.matrizFizzBuzz[j]= this.getFizzbuzz(numeros);
            aux++;     
        }
    }
    
    private int[] patirNumeros(int i, int m){
    
        int a = String.valueOf(i).length();
        int []numeros;
        if(a%m!=0){
            numeros= new int[(a/m)+1];
            double b= i%(Math.pow(10,a%m));
            numeros[a/m] =(int) b;
            i/=Math.pow(10,a%m);
        }
        else {
            numeros= new int[a/m];
        }
         for (int j = (a/m)-1; j >= 0; j--) {
                int potencia= (int) Math.pow(10,m);
                numeros[j] = i%potencia;
                i/=potencia;
                
            }
    return numeros;
    }
    
    private char[] getFizzbuzz(int []i){ 
        String msg = "";
        if (i == null)
	   throw new RuntimeException("Invalid data");
        for (int j = 0; j < i.length; j++) {
        
            if (!(i[j] % 3 == 0 || i[j] % 5 == 0 )|| i[j] == 0)
                msg += ""+i[j];
            else{
               if (i[j] % 3 == 0)
                 msg += "FIZZ";
               if (i[j] % 5 == 0) 
                 msg += "BUZZ";
            }
        }
	return msg.toCharArray();
        }


    public char[][] getMatrizFizzBuzz() {
        return matrizFizzBuzz;
    }

    public char getMatrizFizzBuzz(int i,int j) {
        return matrizFizzBuzz[i][j];
    }
    public int getColumnas() {
        int columnas=0;
        for (char[] matrizFizzBuzz1 : this.matrizFizzBuzz) {
            if (matrizFizzBuzz1.length > columnas) {
                columnas = matrizFizzBuzz1.length;       
            }
        }
        return columnas;
    }
    

    
    @Override
    public String toString() {
        String msg="";
        for (int i = 0; i < this.matrizFizzBuzz.length; i++) {
            msg += "\n"+i;
            for (int j = 0; j < this.matrizFizzBuzz[i].length; j++) {
                msg += ""+ this.matrizFizzBuzz[i][j]+ "\t";
            }
        }
        
        return msg;
    }
    
    
    
    
}
