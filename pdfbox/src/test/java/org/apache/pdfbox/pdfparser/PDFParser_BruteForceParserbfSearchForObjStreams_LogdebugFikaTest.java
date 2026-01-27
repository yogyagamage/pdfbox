package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PDFParser_BruteForceParserbfSearchForObjStreams_LogdebugFikaTest {

    @Test
    public void testParseToLogDebug() throws IOException {
        // Create a minimal PDF content that will trigger the bfSearchForObjStreams path
        // The PDF needs to have a valid header and trigger the brute force parser
        String pdfContent = "%PDF-1.4\n" +
                "1 0 obj\n" +
                "<< /Type /Catalog /Pages 2 0 R >>\n" +
                "endobj\n" +
                "2 0 obj\n" +
                "<< /Type /Pages /Kids [] /Count 0 >>\n" +
                "endobj\n" +
                "xref\n" +
                "0 3\n" +
                "0000000000 65535 f \n" +
                "0000000010 00000 n \n" +
                "0000000050 00000 n \n" +
                "trailer\n" +
                "<< /Size 3 /Root 1 0 R >>\n" +
                "startxref\n" +
                "100\n" +
                "%%EOF";
        
        byte[] pdfBytes = pdfContent.getBytes();
        RandomAccessRead source = new RandomAccessReadBuffer(pdfBytes);
        
        // Use the simplest constructor
        PDFParser parser = new PDFParser(source);
        
        // Call the entry point method
        parser.parse(true);
    }
}
