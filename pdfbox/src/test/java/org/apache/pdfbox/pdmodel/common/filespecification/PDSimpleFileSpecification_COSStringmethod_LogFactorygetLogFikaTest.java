package org.apache.pdfbox.pdmodel.common.filespecification;

import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.Test;

public class PDSimpleFileSpecification_COSStringmethod_LogFactorygetLogFikaTest {

    @Test
    public void testCOSStringStaticInitializationTriggersLogFactoryGetLog() {
        // Accessing the class triggers static initialization
        // which calls LogFactory.getLog(COSString.class)
        Class<COSString> clazz = COSString.class;
        
        // The static field LOG will be initialized when the class is loaded
        // This happens either when we reference the class or create an instance
        // We'll create an instance to ensure class initialization
        COSString cosString = new COSString("test");
    }
}
