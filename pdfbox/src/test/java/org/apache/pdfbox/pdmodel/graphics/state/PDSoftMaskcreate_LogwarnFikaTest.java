package org.apache.pdfbox.pdmodel.graphics.state;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;

class PDSoftMaskcreate_LogwarnFikaTest {

    @Test
    void testCreateWithCOSNameTriggersWarn() {
        COSBase dictionary = COSName.getPDFName("InvalidName");
        ResourceCache resourceCache = null;
        
        PDSoftMask.create(dictionary, resourceCache);
    }
}
