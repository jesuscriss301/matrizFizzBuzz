/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jesus
 */
public final class    Escribir_PDF {

    Atributos imn;
    Codigos_FizzBuzz m;

    public Escribir_PDF(int i, int n, int m) throws FileNotFoundException, DocumentException, IOException,RuntimeException,NumberFormatException{
     this.imn= new Atributos(i,n,m);
     this.m= new Codigos_FizzBuzz(imn);
     this.escribir();
    }
    
    
    public void escribir() throws FileNotFoundException, DocumentException, IOException, RuntimeException, NumberFormatException{
        
            //System.out.println(m.toString());
        Document documento = new Document();
        FileOutputStream ficheroPdf = new FileOutputStream("src/pdf/respuestas.pdf");
        PdfWriter.getInstance(documento,ficheroPdf);
        documento.open();
        
        Chunk paragraphHello = new  Chunk(imn.toString());
        Paragraph espacio = new Paragraph("\n \n \n");
        paragraphHello.setBackground(BaseColor.YELLOW);
        
         documento.add(paragraphHello);
         documento.add(espacio);
        PdfPTable tabla1= new PdfPTable(3);
        tabla1.setWidthPercentage(80);
        
        Paragraph columna1 = new Paragraph("I");
        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(9);
        columna1.setAlignment(Element.ALIGN_CENTER); //aquí
        tabla1.addCell(columna1);
        
        Paragraph columna2 = new Paragraph("numeros creados");
        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(9);
        columna1.setAlignment(Element.ALIGN_CENTER); //aquí
        tabla1.addCell(columna2);
        
        Paragraph columna3 = new Paragraph("Numeros_fizzBuzz");
        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(9);
        columna1.setAlignment(Element.ALIGN_CENTER); //aquí
        tabla1.addCell(columna3);
        

        String [][]base =  m.tablaBase(imn);
            //int i = 0; i < base.length; i++
            for (String[] base1 : base) {
            for (String base11 : base1) {
                tabla1.addCell(base11);
            }
            }
        
        documento.add(tabla1);   
        documento.add(espacio);
        Font font =new Font();
        font.setSize(14);
        
        Chunk titulo= new Chunk("Matriz char de los numeros FizzBuzz",font);
        titulo.setBackground(BaseColor.YELLOW);
        Paragraph alineacion = new Paragraph(titulo);
        alineacion.setAlignment(Element.ALIGN_CENTER);
        alineacion.add(espacio);  
        documento.add(alineacion);
         //Añadimos una tabla 
        PdfPTable tabla = new PdfPTable(m.getColumnas()); 
        //Datos de porcentaje a la tabla (tamaño ancho).
        tabla.setWidthPercentage(100);

        //Recorremos cada arrayList e imprimimos los resultados. 
        for (int i = 0; i<m.getMatrizFizzBuzz().length; i++){ 
        
             for (int j = 0; j <m.getColumnas(); j++) {
                 if( j <m.getMatrizFizzBuzz()[i].length)
                  tabla.addCell(m.getMatrizFizzBuzz(i, j)+"");
                 else {
                   //creamos celda para colorear
                   PdfPCell cell = new PdfPCell(new Phrase(""));
                   cell.setBackgroundColor(BaseColor.YELLOW);//cambiamos la propiedad del color
                   tabla.addCell(cell);//añadimos la celda a tabla 
                    }
                }
        
        } 

         //Añadimos la tabla "tabla" al documento "documento".
         documento.add(tabla);   
         //identificamos el tamaño de la matriz
         int filas= imn.getN()+1;
         int columnas= m.getColumnas();
         Paragraph dimenciones = new Paragraph(filas+"x"+columnas);
         documento.add(dimenciones);
         
         //Cerramos el documento.
         documento.close();
          File objetofile = new File ("src/pdf/respuestas.pdf");
          Desktop.getDesktop().open(objetofile);
        
    }
    
  
}
