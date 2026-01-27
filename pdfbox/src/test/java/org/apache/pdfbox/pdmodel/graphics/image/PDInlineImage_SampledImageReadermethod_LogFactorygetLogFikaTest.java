package org.apache.pdfbox.pdmodel.graphics.image;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PDInlineImage_SampledImageReadermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetImageTriggersLogFactoryGetLog() throws IOException {
        // Create minimal required objects
        COSDictionary parameters = new COSDictionary();
        parameters.setInt(COSName.W, 100);
        parameters.setInt(COSName.H, 100);
        parameters.setInt(COSName.BPC, 8);
        parameters.setItem(COSName.CS, PDDeviceGray.INSTANCE.getCOSObject());
        
        // Create empty filters list to avoid filter processing
        COSArray filtersArray = new COSArray();
        parameters.setItem(COSName.F, filtersArray);
        
        byte[] data = new byte[100];
        PDResources resources = new PDResources();
        
        // Create PDInlineImage instance
        PDInlineImage inlineImage = new PDInlineImage(parameters, data, resources);
        
        // Call entry point method - this should trigger static initialization
        // of SampledImageReader which calls LogFactory.getLog()
        inlineImage.getImage(new Rectangle(0, 0, 100, 100), 1);
    }
}
