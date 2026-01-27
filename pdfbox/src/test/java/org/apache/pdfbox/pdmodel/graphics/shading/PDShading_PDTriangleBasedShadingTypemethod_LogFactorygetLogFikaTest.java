package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType;

class PDShading_PDTriangleBasedShadingTypemethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersStaticInitializer() throws Exception {
        COSDictionary shadingDictionary = new COSDictionary();
        shadingDictionary.setInt(COSName.SHADING_TYPE, PDShading.SHADING_TYPE4);
        
        PDShading.create(shadingDictionary);
    }
}
