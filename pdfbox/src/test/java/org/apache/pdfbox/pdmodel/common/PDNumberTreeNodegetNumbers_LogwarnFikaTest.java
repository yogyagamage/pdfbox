package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class PDNumberTreeNodegetNumbers_LogwarnFikaTest {

    @Test
    void testGetNumbersTriggersLogWarn() throws IOException {
        // Create a COSDictionary with an odd-sized NUMS array
        COSDictionary dict = new COSDictionary();
        COSArray numbersArray = new COSArray();
        
        // Add three elements to create odd size (3 % 2 != 0)
        numbersArray.add(COSInteger.get(1));
        numbersArray.add(COSNull.NULL);
        numbersArray.add(COSInteger.get(2)); // This third element makes size odd
        
        dict.setItem(COSName.NUMS, numbersArray);
        
        // Use the constructor that accepts a COSDictionary
        PDNumberTreeNode node = new PDNumberTreeNode(dict, PDPage.class);
        
        // Call the entry point method - this should trigger LOG.warn(...)
        node.getNumbers();
    }
}
