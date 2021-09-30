/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Negocio.Atributos;
import Negocio.Codigos_FizzBuzz;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author jesusmanuelcp
 */
public class Test_escribir_PDF {
    public static void main(String[] args) throws FileNotFoundException, DocumentException, IOException {
      
        try{
        Atributos imn = new Atributos(151515, 3, 2);    
        Codigos_FizzBuzz m= new   Codigos_FizzBuzz(imn);
        
        //System.out.println(m.toString());
        Document documento = new Document();
        FileOutputStream ficheroPdf = new FileOutputStream("src/pdf/ficheroSalida.pdf");
        PdfWriter.getInstance(documento,ficheroPdf);
        documento.open();
        
        Paragraph paragraphHello = new Paragraph(imn.toString());
        Paragraph espacio = new Paragraph("\n \n \n");
        paragraphHello.add(espacio);
         paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);
         documento.add(paragraphHello);
        
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
         //Cerramos el writer.
         //writer.close();
         documento.close();
         }
         catch(RuntimeException e){
           System.err.println(e.getMessage());
            }
    }
    
}
