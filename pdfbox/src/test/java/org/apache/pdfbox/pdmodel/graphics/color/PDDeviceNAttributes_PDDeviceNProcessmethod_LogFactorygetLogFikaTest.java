package org.apache.pdfbox.pdmodel.graphics.color;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

public class PDDeviceNAttributes_PDDeviceNProcessmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetProcessTriggersStaticInitializer() {
        COSDictionary dict = new COSDictionary();
        dict.setItem(COSName.PROCESS, new COSDictionary());
        
        PDDeviceNAttributes attributes = new PDDeviceNAttributes(dict);
        attributes.getProcess();
    }
}
