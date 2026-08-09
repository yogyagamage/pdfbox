package org.apache.pdfbox.multipdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import java.io.File;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PDFMergerUtility_PDDocumentCatalogmethod_LogFactorygetLogFikaTest {

    @Test
    public void testMergeDocumentsTriggersLogFactoryGetLog() throws IOException {
        // Create an instance of PDFMergerUtility using the provided constructor
        PDFMergerUtility mergerUtility = new PDFMergerUtility();
        
        // Ensure documentMergeMode is PDFBOX_LEGACY_MODE to follow the desired path
        // This is already the default according to fieldDeclarations
        
        // Add a source to the list of documents to merge
        // Create a minimal valid PDF content
        String minimalPDF = "%PDF-1.4\n1 0 obj\n<< /Type /Catalog /Pages 2 0 R >>\nendobj\n2 0 obj\n<< /Type /Pages /Kids [] /Count 0 >>\nendobj\nxref\n0 3\n0000000000 65535 f \n0000000010 00000 n \n0000000053 00000 n \ntrailer\n<< /Size 3 /Root 1 0 R >>\nstartxref\n100\n%%EOF";
        byte[] pdfBytes = minimalPDF.getBytes();
        RandomAccessRead source = new RandomAccessReadBuffer(new ByteArrayInputStream(pdfBytes));
        mergerUtility.addSource(source);
        
        // Set a destination file name to avoid NPE during save
        mergerUtility.setDestinationFileName("test_output.pdf");
        
        // Call the entry point method with null parameters (will use default stream cache)
        // This should trigger the static initialization of PDDocumentCatalog which calls LogFactory.getLog
        mergerUtility.mergeDocuments((RandomAccessStreamCache.StreamCacheCreateFunction) null, 
                                     (CompressParameters) null);
    }
}
