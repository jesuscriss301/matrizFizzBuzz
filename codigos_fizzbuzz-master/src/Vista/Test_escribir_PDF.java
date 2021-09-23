/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Negocio.Codigos_FizzBuzz;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
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
        
        /*
        Document documento = new Document();
        FileOutputStream ficheroPdf = new FileOutputStream("src/pdf/ficheroSalida.pdf");
        PdfWriter.getInstance(documento,ficheroPdf);
        documento.open();
        Paragraph paragraphHello = new Paragraph();
         paragraphHello.add("Hello iText paragraph!");
         paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);
         documento.add(paragraphHello);
         documento.close();*/
        
        Codigos_FizzBuzz m= new   Codigos_FizzBuzz(42949672, 3 , 2);
        
        System.out.println(m.toString());
        
    }
    
}
