package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class PDShading_PDMeshBasedShadingTypemethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersStaticInitializer() throws Exception {
        COSDictionary dict = new COSDictionary();
        dict.setInt(COSName.SHADING_TYPE, 6);
        
        PDShading.create(dict);
    }
}
