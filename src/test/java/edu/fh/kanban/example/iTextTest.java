package edu.fh.kanban.example;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;
import org.junit.Test;

public class iTextTest {

    @Test
    public void createDocument() throws Exception {
        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
                Font.BOLD);
        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                Font.BOLD);


        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("kanban.pdf"));
        document.open();
        document.addTitle("Kanban Board");
        document.addSubject("Backlog export");
        document.addKeywords("kanban");
        document.addKeywords("ostfalia");
        document.addAuthor("Nikolai Alex");
        document.addCreator("Nikolai Alex");

        Paragraph preface = new Paragraph();
        preface.add(new Paragraph(" "));
        // Lets write a big header
        preface.add(new Paragraph("Kanban - Backlog", catFont));
        preface.add(new Paragraph(" "));
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph("Export generated by: " + System.getProperty("user.name") + ", " + new Date(),
                smallBold));
        document.add(preface);
        // Start a new page
        document.newPage();

        document.close();
    }
}
