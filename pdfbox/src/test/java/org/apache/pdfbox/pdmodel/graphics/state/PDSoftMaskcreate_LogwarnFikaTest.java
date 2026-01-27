package org.apache.pdfbox.pdmodel.graphics.state;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;

class PDSoftMaskcreate_LogwarnFikaTest {

    @Test
    void testCreateWithCOSNameThatIsNotNone() {
        // Create a COSName that is not COSName.NONE to trigger the warning path
        COSBase dictionary = COSName.getPDFName("InvalidMask");
        ResourceCache resourceCache = null;
        
        // This should invoke Log.warn() when dictionary is a COSName but not COSName.NONE
        PDSoftMask.create(dictionary, resourceCache);
    }
}
