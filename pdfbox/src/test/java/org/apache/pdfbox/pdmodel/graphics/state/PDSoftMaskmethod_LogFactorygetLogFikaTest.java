package org.apache.pdfbox.pdmodel.graphics.state;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.state.PDSoftMask;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class PDSoftMaskmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            COSDictionary dict = new COSDictionary();
            dict.setItem(COSName.TYPE, COSName.MASK);
            dict.setItem(COSName.S, COSName.ALPHA);
            
            PDSoftMask softMask = new PDSoftMask(dict);
        }
    }
}
