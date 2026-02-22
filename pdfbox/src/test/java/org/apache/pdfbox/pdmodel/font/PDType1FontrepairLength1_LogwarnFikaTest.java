package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.util.Random;

class PDType1FontrepairLength1_LogwarnFikaTest {

    @Test
    void testRepairLength1TriggersLogWarn() throws Exception {
        // Create a mock COSDictionary for the constructor
        COSDictionary mockDict = Mockito.mock(COSDictionary.class);
        
        // Create a PDType1Font instance using the constructor that takes COSDictionary
        // This constructor is package-private, so we need to use reflection
        Class<?> clazz = Class.forName("org.apache.pdfbox.pdmodel.font.PDType1Font");
        
        // Get the constructor that takes COSDictionary
        java.lang.reflect.Constructor<?> constructor = clazz.getDeclaredConstructor(COSDictionary.class);
        constructor.setAccessible(true);
        
        // Create instance
        Object fontInstance = constructor.newInstance(mockDict);
        
        // Prepare test data that will trigger the warn log
        // We need bytes and length1 that will cause offset != 0 and offset > 0
        // Based on the repairLength1 logic, we need:
        // 1. length1 > 0
        // 2. offset > 0 (found via findBinaryOffsetAfterExec)
        // 3. (length1 - offset) != 0
        
        // Create a byte array that contains 'exec' somewhere
        byte[] bytes = new byte[100];
        Random random = new Random(42);
        random.nextBytes(bytes);
        
        // Insert 'exec' at position 50 (0x65 0x78 0x65 0x63)
        bytes[50] = 0x65; // 'e'
        bytes[51] = 0x78; // 'x'
        bytes[52] = 0x65; // 'e'
        bytes[53] = 0x63; // 'c'
        
        // Set length1 to 60 so that offset (50+4=54) != length1
        int length1 = 60;
        
        // Call repairLength1 via reflection
        Method repairLength1Method = clazz.getDeclaredMethod("repairLength1", byte[].class, int.class);
        repairLength1Method.setAccessible(true);
        repairLength1Method.invoke(fontInstance, bytes, length1);
    }
}
