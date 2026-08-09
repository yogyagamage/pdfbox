package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class COSArrayList_COSStringmethod_LogFactorygetLogFikaTest {

    @Test
    public void testConverterToCOSArrayTriggersCOSStringStaticInitializer() {
        // Create a list containing a String to trigger COSString instantiation
        List<String> stringList = new ArrayList<>();
        stringList.add("test");
        
        // Call the static entry point method
        COSArrayList.converterToCOSArray(stringList);
    }
}
