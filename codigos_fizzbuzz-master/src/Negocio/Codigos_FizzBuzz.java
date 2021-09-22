/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 * Plantilla inicial códigos de FizzBuzz
 * @author madarme
 */
public class Codigos_FizzBuzz {
    
    
    private char [][]matrizFizzBuzz;

    public Codigos_FizzBuzz() {
    }
    
    
    /**
     * Constructor para códigos
     * @param i límite inicial 
     * @param n límite final
     * @param m particiones
     */
    public Codigos_FizzBuzz(int i, int n, int m) {
        
    }
    
    public int[] patirNumeros(int i, int m){
    
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
    
    public String getFizzbuzz(int i){ 
	String msg = "";
        if (i<=0)
	   throw new RuntimeException("Invalid data");
        if (!(i % 3 == 0 || i % 5 == 0))
            return ""+i;
        else{
               if (i % 3 == 0)
                 msg = "FIZZ";
               if (i % 5 == 0) 
                 msg += "BUZZ";
        }
	return msg;
        }


    public char[][] getMatrizFizzBuzz() {
        return matrizFizzBuzz;
    }
    
    
    
    
}
