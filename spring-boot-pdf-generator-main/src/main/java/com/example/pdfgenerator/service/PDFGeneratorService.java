package com.example.pdfgenerator.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PDFGeneratorService {
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("This is a title.", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Add the title
        document.add(paragraph);

        // Create a table
        PdfPTable table = new PdfPTable(3); // Number of columns
        table.setHorizontalAlignment(5);

        // Add cells to the table
        table.addCell("Column 1");
        table.addCell("Column 2");
        table.addCell("Column 3");

        // Add more rows if needed
        for (int i = 0; i < 10; i++) {
            table.addCell("Data 1");
            table.addCell("Data 2");
            table.addCell("Data 3");
        }

        // Add the table to the document
        document.add(table);
        document.close();
    }
}
