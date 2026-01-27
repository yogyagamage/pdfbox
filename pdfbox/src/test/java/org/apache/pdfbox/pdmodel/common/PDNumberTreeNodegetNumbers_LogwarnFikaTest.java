package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class PDNumberTreeNodegetNumbers_LogwarnFikaTest {

    @Test
    void testGetNumbersTriggersLogWarn() throws IOException {
        // Create a COSArray with odd size to trigger the warning log
        COSArray numbersArray = new COSArray();
        numbersArray.add(COSInteger.get(1));
        numbersArray.add(COSNull.NULL);
        numbersArray.add(COSInteger.get(3)); // Odd size: 3 elements

        COSDictionary dict = new COSDictionary();
        dict.setItem(COSName.NUMS, numbersArray);

        // Use the constructor that accepts a dictionary
        PDNumberTreeNode node = new PDNumberTreeNode(dict, COSObjectable.class);

        // This should invoke LOG.warn(...) due to odd array size
        node.getNumbers();
    }
}
