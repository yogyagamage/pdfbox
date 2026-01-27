package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class PDShading_PDShadingType4method_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersPDShadingType4StaticInitializer() throws Exception {
        // Create a COSDictionary with shading type 4 to trigger PDShadingType4 class loading
        COSDictionary shadingDict = new COSDictionary();
        shadingDict.setInt(COSName.SHADING_TYPE, PDShading.SHADING_TYPE4);
        
        // This will load PDShadingType4 class, triggering its static initializer
        // which calls LogFactory.getLog(PDShadingType4.class)
        PDShading.create(shadingDict);
    }
}
