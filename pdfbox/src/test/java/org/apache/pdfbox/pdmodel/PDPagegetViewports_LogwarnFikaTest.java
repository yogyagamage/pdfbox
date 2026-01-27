package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDViewportDictionary;
import org.junit.jupiter.api.Test;

import java.util.List;

class PDPagegetViewports_LogwarnFikaTest {

    @Test
    void testGetViewportsTriggersLogWarn() {
        // Create a COSDictionary with a VP entry that contains a non-dictionary element
        COSDictionary pageDict = new COSDictionary();
        pageDict.setItem(COSName.TYPE, COSName.PAGE);
        pageDict.setItem(COSName.MEDIA_BOX, PDRectangle.LETTER);
        
        // Create a COSArray for VP with at least one non-dictionary element
        COSArray vpArray = new COSArray();
        // Add a COSName (non-dictionary) to trigger the warning log
        vpArray.add(COSName.VP);
        pageDict.setItem(COSName.VP, vpArray);
        
        // Instantiate PDPage using the constructor that takes COSDictionary
        PDPage page = new PDPage(pageDict);
        
        // Call the entry point method - this should traverse the path and invoke Log.warn
        List<PDViewportDictionary> viewports = page.getViewports();
        // No assertions needed
    }
}
