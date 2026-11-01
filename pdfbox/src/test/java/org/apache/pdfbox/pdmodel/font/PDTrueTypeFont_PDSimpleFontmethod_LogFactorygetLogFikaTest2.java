package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import java.io.ByteArrayOutputStream;

public class PDTrueTypeFont_PDSimpleFontmethod_LogFactorygetLogFikaTest2 {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Create a PDType1Font which extends PDSimpleFont
                // This will trigger static initialization of PDSimpleFont
                // which calls LogFactory.getLog(PDSimpleFont.class)
                contentStream.setFont(new PDType1Font(FontName.HELVETICA), 12);
            }
            
            // Write to output stream to ensure font is actually used
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
        }
    }
}
