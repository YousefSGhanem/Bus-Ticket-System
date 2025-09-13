/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.frauas.Bustravelio.frontend;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author haith
 */
public class ExportPDF {
    public void pdfExport(String username, String datum,String nachricht, String info1, String info2, String info3, String info4, String info5, String info6, String info7){
        
        try{
        Document document = new Document();
        PdfWriter.getInstance( document, new FileOutputStream("C:\\Users\\Janny\\Downloads\\"+username+datum+".pdf"));
        document.open();
        document.add(new Paragraph(nachricht));
        document.add(new Paragraph(info1));
        document.add(new Paragraph(info2));
        document.add(new Paragraph(info3));
        document.add(new Paragraph(info4));
        document.add(new Paragraph(info5));
        document.add(new Paragraph(info6));
        document.add(new Paragraph(info7));
        document.close();
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("pdf is created");
    }
}
