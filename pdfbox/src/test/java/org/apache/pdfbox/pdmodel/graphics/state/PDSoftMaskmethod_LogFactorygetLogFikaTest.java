package org.apache.pdfbox.pdmodel.graphics.state;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class PDSoftMaskmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersLogFactoryGetLog() {
        // Create a minimal COSDictionary that will be accepted by the create method
        COSDictionary dict = new COSDictionary();
        dict.setItem(COSName.TYPE, COSName.MASK);
        dict.setItem(COSName.S, COSName.ALPHA);
        
        // This will trigger the static initializer which calls LogFactory.getLog
        PDSoftMask.create(dict);
    }
}
