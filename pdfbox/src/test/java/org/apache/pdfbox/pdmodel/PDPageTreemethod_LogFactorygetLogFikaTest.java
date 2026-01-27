package org.apache.pdfbox.pdmodel;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PDPageTreemethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetInheritableAttributeTriggersLogFactoryGetLog() {
        COSDictionary root = new COSDictionary();
        PDDocument document = new PDDocument();
        PDPageTree pageTree = new PDPageTree(root, document);
        
        COSDictionary node = new COSDictionary();
        COSName key = COSName.PAGE;
        
        PDPageTree.getInheritableAttribute(node, key);
    }
}
