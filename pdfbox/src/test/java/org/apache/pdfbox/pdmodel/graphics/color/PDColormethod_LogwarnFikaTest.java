package org.apache.pdfbox.pdmodel.graphics.color;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDColormethod_LogwarnFikaTest {

    @Test
    void testWarnInvoked() {
        COSArray array = new COSArray();
        array.add(COSName.getPDFName("SomePattern"));
        array.add(COSName.getPDFName("NotANameButActuallyIs"));

        PDColorSpace colorSpace = Mockito.mock(PDColorSpace.class);

        PDColor pdColor = new PDColor(array, colorSpace);
    }
}
