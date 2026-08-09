package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PageMode;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PDFMergerUtility_PDDocumentCataloggetPageMode_LogdebugFikaTest {

    @Test
    public void testAppendDocumentTriggersLogDebug() throws IOException {
        // Create a PDFMergerUtility instance using the provided constructor
        PDFMergerUtility mergerUtility = new PDFMergerUtility();
        
        // Create a minimal source PDF with a catalog that has an invalid PageMode
        byte[] minimalPdf = createMinimalPdfWithInvalidPageMode();
        
        try (PDDocument sourceDoc = Loader.loadPDF(new RandomAccessReadBuffer(minimalPdf));
             PDDocument destDoc = new PDDocument()) {
            
            // Call the entry point method
            mergerUtility.appendDocument(destDoc, sourceDoc);
        }
    }

    private byte[] createMinimalPdfWithInvalidPageMode() {
        // Create a minimal PDF that will cause getPageMode() to throw IllegalArgumentException
        // when it tries to parse an invalid PageMode string, triggering LOG.debug()
        String pdfContent = "%PDF-1.4\n" +
                "1 0 obj\n" +
                "<<\n" +
                "  /Type /Catalog\n" +
                "  /Pages 2 0 R\n" +
                "  /PageMode /InvalidMode  % This will cause IllegalArgumentException in getPageMode()\n" +
                ">>\n" +
                "endobj\n" +
                "2 0 obj\n" +
                "<<\n" +
                "  /Type /Pages\n" +
                "  /Kids []\n" +
                "  /Count 0\n" +
                ">>\n" +
                "endobj\n" +
                "xref\n" +
                "0 3\n" +
                "0000000000 65535 f \n" +
                "0000000010 00000 n \n" +
                "0000000060 00000 n \n" +
                "trailer\n" +
                "<<\n" +
                "  /Size 3\n" +
                "  /Root 1 0 R\n" +
                ">>\n" +
                "startxref\n" +
                "120\n" +
                "%%EOF";
        
        return pdfContent.getBytes();
    }
}
