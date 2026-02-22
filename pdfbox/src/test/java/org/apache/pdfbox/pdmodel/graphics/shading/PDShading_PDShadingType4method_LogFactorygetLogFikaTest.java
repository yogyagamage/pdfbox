package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class PDShading_PDShadingType4method_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersStaticInitializer() throws Exception {
        COSDictionary shadingDictionary = new COSDictionary();
        shadingDictionary.setInt(COSName.SHADING_TYPE, 4);
        
        PDShading.create(shadingDictionary);
    }
}
