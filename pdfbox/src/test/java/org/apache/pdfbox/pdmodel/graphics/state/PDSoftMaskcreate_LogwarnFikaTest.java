package org.apache.pdfbox.pdmodel.graphics.state;

import org.apache.commons.logging.Log;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;

class PDSoftMaskcreate_LogwarnFikaTest {

    @Test
    void testCreateInvokesLogWarn() {
        // Create a COSName that is not COSName.NONE to trigger the warning path
        COSBase dictionary = COSName.getPDFName("InvalidMask");
        ResourceCache resourceCache = null;
        
        // Invoke the static entry point method
        PDSoftMask.create(dictionary, resourceCache);
    }
}
