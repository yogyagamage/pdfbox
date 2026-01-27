package org.apache.pdfbox.cos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class COSArray_COSObjectmethod_LogFactorygetLogFikaTest {

    @Test
    public void testSetTriggersCOSObjectStaticInitializer() {
        // Create COSArray instance using default constructor
        COSArray cosArray = new COSArray();
        
        // Create a COSDictionary that is indirect and has a key
        // to trigger the COSObject creation path in set() method
        COSDictionary dict = new COSDictionary();
        dict.setDirect(false);
        
        // Create a mock key for the dictionary
        COSObjectKey key = new COSObjectKey(1L, 0);
        
        // Use reflection to set the key since there's no public setter
        try {
            java.lang.reflect.Field keyField = COSBase.class.getDeclaredField("key");
            keyField.setAccessible(true);
            keyField.set(dict, key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        // Ensure the array has at least one element to set
        cosArray.add(COSNull.NULL);
        
        // Call the entry point method - this should trigger COSObject.<clinit>()
        // which calls LogFactory.getLog(COSObject.class)
        cosArray.set(0, dict);
    }
}
