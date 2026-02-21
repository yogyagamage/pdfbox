package org.apache.pdfbox.pdmodel.graphics.state;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.graphics.state.PDSoftMask;
import org.junit.jupiter.api.Test;

class PDSoftMaskcreate_LogwarnFikaTest {

    @Test
    void testCreateWithCOSNameThatIsNotNone() {
        // Create a COSName that is not COSName.NONE to trigger the warning log
        COSName nonNoneName = COSName.getPDFName("InvalidMask");
        
        // This should invoke LOG.warn("Invalid SMask " + dictionary)
        PDSoftMask.create(nonNoneName, null);
    }
}
