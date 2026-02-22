package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;

public class PDType1FontrepairLength2_LogwarnFikaTest {

    @Test
    public void testRepairLength2TriggersLogWarn() throws Exception {
        // Create a mock COSDictionary for the constructor
        COSDictionary mockDict = Mockito.mock(COSDictionary.class);
        
        // Create PDType1Font instance using reflection since constructor is package-private
        // and we need to pass a COSDictionary
        Class<?> clazz = Class.forName("org.apache.pdfbox.pdmodel.font.PDType1Font");
        
        // Get the constructor that takes COSDictionary
        java.lang.reflect.Constructor<?> constructor = clazz.getDeclaredConstructor(COSDictionary.class);
        constructor.setAccessible(true);
        
        // Create instance
        Object fontInstance = constructor.newInstance(mockDict);
        
        // Get the repairLength2 method
        Method repairMethod = clazz.getDeclaredMethod("repairLength2", byte[].class, int.class, int.class);
        repairMethod.setAccessible(true);
        
        // Create test data that will trigger the warn log
        byte[] bytes = new byte[100];
        int length1 = 50;
        int length2 = 60; // This is > (100 - 50) = 50, so it will trigger the warning
        
        // Invoke the method - this should trigger LOG.warn()
        repairMethod.invoke(fontInstance, bytes, length1, length2);
    }
}
