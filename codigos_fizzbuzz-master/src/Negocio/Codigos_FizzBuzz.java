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

    public Codigos_FizzBuzz() {
    }
    
    
    /**
     * Constructor para códigos
     * @param i límite inicial 
     * @param n límite final
     * @param m particiones
     */
    public Codigos_FizzBuzz(int i, int n, int m) {
        matrizFizzBuzz= new char[n+1][];
        int []numeros;
        int j , aux = i;
        for (j = 0; aux <= (i+n); j++) {
            numeros = this.patirNumeros(aux, m);
            this.matrizFizzBuzz[j]= this.getFizzbuzz(numeros);
            
            aux++;
        }
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
    
    public char[] getFizzbuzz(int []i){ 
        String msg = "";
        if (i.equals(null))
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
