package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;

class PDOutlineNodemethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDOutlineItem outlineItem = new PDOutlineItem();
            outlineItem.setTitle("Test");
            
            PDOutlineNode node = outlineItem;
            // The static field LOG will be initialized when PDOutlineNode class is loaded
            // which triggers LogFactory.getLog(PDOutlineNode.class)
            Class<?> clazz = node.getClass();
        }
    }
}
