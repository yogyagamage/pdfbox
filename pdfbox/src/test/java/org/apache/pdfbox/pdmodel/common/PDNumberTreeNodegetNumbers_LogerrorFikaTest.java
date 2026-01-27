package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class PDNumberTreeNodegetNumbers_LogerrorFikaTest {

    @Test
    void testGetNumbersTriggersLogError() throws IOException {
        // Create a COSDictionary with a NUMS array that will trigger the error path
        COSDictionary dict = new COSDictionary();
        COSArray numbersArray = new COSArray();
        
        // Add a non-COSInteger at index 0 to trigger the LOG.error call
        numbersArray.add(COSNull.NULL); // This is not a COSInteger
        numbersArray.add(COSNull.NULL); // Add a second element to avoid early exit
        
        dict.setItem(COSName.NUMS, numbersArray);
        
        // Create PDNumberTreeNode using the constructor that takes a dictionary
        // We need a valueClass - use a simple COSObjectable class
        PDNumberTreeNode node = new PDNumberTreeNode(dict, COSInteger.class);
        
        // Call the entry point method - this should trigger LOG.error
        node.getNumbers();
    }
}
