package org.apache.pdfbox.multipdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.ByteArrayOutputStream;

public class LayerUtility_PDFCloneUtilitymethod_LogFactorygetLogFikaTest {

    @Test
    public void testPDFCloneUtilityLogInitialization() throws Exception {
        PDDocument sourceDoc = new PDDocument();
        sourceDoc.addPage(new PDPage());
        
        PDDocument destinationDoc = new PDDocument();
        destinationDoc.addPage(new PDPage());
        
        PDFCloneUtility cloner = new PDFCloneUtility(destinationDoc);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        sourceDoc.save(baos);
        sourceDoc.close();
        
        destinationDoc.close();
    }
}
