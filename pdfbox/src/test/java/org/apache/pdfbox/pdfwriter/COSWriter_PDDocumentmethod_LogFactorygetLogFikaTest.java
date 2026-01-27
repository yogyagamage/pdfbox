package org.apache.pdfbox.pdfwriter;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class COSWriter_PDDocumentmethod_LogFactorygetLogFikaTest {

    @Test
    void testWriteTriggersStaticInitializer() throws IOException {
        // Create a COSWriter instance using the simplest constructor
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        COSWriter cosWriter = new COSWriter(outputStream);
        
        // Create a minimal COSDocument with required structure to avoid NPE
        COSDocument cosDocument = new COSDocument();
        // Ensure the document has a trailer to prevent NullPointerException
        cosDocument.setTrailer(new org.apache.pdfbox.cos.COSDictionary());
        
        // This call will trigger the static initializer of PDDocument
        // which calls LogFactory.getLog(PDDocument.class)
        cosWriter.write(cosDocument);
    }
}
