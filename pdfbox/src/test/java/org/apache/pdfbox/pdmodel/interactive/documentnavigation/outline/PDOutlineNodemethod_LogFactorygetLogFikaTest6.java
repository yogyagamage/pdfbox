package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;

class PDOutlineNodemethod_LogFactorygetLogFikaTest6 {

    @Test
    void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDOutlineItem outlineItem = new PDOutlineItem();
            outlineItem.setTitle("Test");
            
            PDOutlineNode parent = new PDOutlineItem();
            parent.addLast(outlineItem);
            
            // Trigger static initialization which calls LogFactory.getLog
            PDOutlineItem anotherItem = new PDOutlineItem();
            anotherItem.setTitle("Another");
        }
    }
}
