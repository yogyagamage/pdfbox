package org.apache.pdfbox.pdmodel.graphics.color;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSName;
import org.apache.commons.logging.LogFactory;

class PDCalGray_PDColormethod_LogFactorygetLogFikaTest {

    @Test
    void testEntryPointToThirdPartyMethod() {
        PDCalGray instance = new PDCalGray();
        // The static initializer of PDColor should be triggered
        // which calls LogFactory.getLog(PDColor.class)
    }
}
