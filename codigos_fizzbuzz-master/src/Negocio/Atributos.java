/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author jesus
 */
public class Atributos {
    int i;
    int n;
    int m; 

    public Atributos(int i, int n, int m) {
        this.i = i;
        this.n = n;
        this.m = m;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "si i=\t"+i+",\t m=\t"+m+" y n=\t"+n;
    }
    
    
}
