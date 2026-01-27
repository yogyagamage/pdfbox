package org.apache.pdfbox.pdfparser;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PDFParser_COSParserparseXref_LogwarnFikaTest {

    @Test
    public void testParseTriggersLogWarn() throws IOException {
        // Create a minimal PDF that will trigger the warning in parseXref
        // The PDF needs to have a /XRefStm entry in the trailer with an incorrect offset
        // that gets corrected, which triggers LOG.warn()
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
                "<< /Size 3 /Root 1 0 R /XRefStm 1000 >>\n" + // Incorrect offset that will be corrected
                "startxref\n" +
                "70\n" +
                "%%EOF\n";
        
        byte[] pdfBytes = pdfContent.getBytes();
        RandomAccessRead source = new RandomAccessReadBuffer(pdfBytes);
        
        PDFParser parser = new PDFParser(source);
        parser.parse(true);
    }
}
