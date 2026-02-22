package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOutlineItem_PDOutlineNodemethod_LogFactorygetLogFikaTest {

    @Test
    void testGetPreviousSiblingTriggersLogFactoryGetLog() {
        // Create a mock COSDictionary for the PDOutlineItem constructor
        COSDictionary mockDict = Mockito.mock(COSDictionary.class);
        
        // Create a real PDOutlineItem instance
        PDOutlineItem outlineItem = new PDOutlineItem(mockDict);
        
        // Trigger the static initialization of PDOutlineNode by calling getPreviousSibling
        outlineItem.getPreviousSibling();
    }
}
