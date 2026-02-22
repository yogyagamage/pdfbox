package org.apache.pdfbox.pdfwriter;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class COSWritermethod_LogFactorygetLogFikaTest {

    @Test
    public void testWriteReferenceTriggersStaticInitializer() throws IOException {
        // Trigger static initialization which calls LogFactory.getLog
        // by creating an instance and calling the entry point method
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        COSWriter writer = new COSWriter(outputStream);
        
        // Create a COSObject to pass to writeReference
        COSDictionary dict = new COSDictionary();
        COSObject obj = new COSObject(dict);
        
        // This will trigger the static initializer when the class is first loaded
        // The static initializer contains: private static final Log LOG = LogFactory.getLog(COSWriter.class);
        writer.writeReference(obj);
    }
}
