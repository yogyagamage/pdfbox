package org.apache.pdfbox.pdmodel.common.filespecification;

import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.Test;

public class PDSimpleFileSpecification_COSStringmethod_LogFactorygetLogFikaTest {

    @Test
    public void testCOSStringStaticInitializationTriggersLogFactoryGetLog() {
        // Accessing COSString will trigger static initialization
        // which includes the static field LOG initialization
        // that calls LogFactory.getLog(COSString.class)
        Class<COSString> clazz = COSString.class;
        
        // Force class loading and static initialization
        // by creating an instance
        COSString cosString = new COSString("test");
    }
}
