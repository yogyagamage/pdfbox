package org.apache.pdfbox.pdfwriter;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessRead;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class COSWritermethod_LogFactorygetLogFikaTest {

    @Test
    void testWriteReferenceTriggersStaticInitializer() throws Exception {
        // Create a minimal COSWriter instance using the simplest constructor
        OutputStream outputStream = new ByteArrayOutputStream();
        COSWriter cosWriter = new COSWriter(outputStream);
        
        // Create a COSBase object that will be accepted by writeReference
        // We need a COSObject because writeReference calls getObjectKey which expects
        // an object that exists in the objectKeys map
        COSDictionary dict = new COSDictionary();
        COSObject cosObject = new COSObject(dict);
        COSObjectKey key = new COSObjectKey(1, 0);
        
        // Use reflection to access private fields and methods to set up the state
        Field objectKeysField = COSWriter.class.getDeclaredField("objectKeys");
        objectKeysField.setAccessible(true);
        java.util.Map<COSBase, COSObjectKey> objectKeys = 
            (java.util.Map<COSBase, COSObjectKey>) objectKeysField.get(cosWriter);
        objectKeys.put(dict, key);
        
        Field keyObjectField = COSWriter.class.getDeclaredField("keyObject");
        keyObjectField.setAccessible(true);
        java.util.Map<COSObjectKey, COSBase> keyObject = 
            (java.util.Map<COSObjectKey, COSBase>) keyObjectField.get(cosWriter);
        keyObject.put(key, dict);
        
        // Also need to set the standardOutput field to avoid NPE
        Field standardOutputField = COSWriter.class.getDeclaredField("standardOutput");
        standardOutputField.setAccessible(true);
        
        // Create a COSStandardOutputStream instance
        Class<?> cosStandardOutputStreamClass = Class.forName("org.apache.pdfbox.pdfwriter.COSStandardOutputStream");
        Object cosStandardOutputStream = cosStandardOutputStreamClass
            .getConstructor(OutputStream.class)
            .newInstance(outputStream);
        standardOutputField.set(cosWriter, cosStandardOutputStream);
        
        // Now call writeReference - this should trigger static initialization
        // which calls LogFactory.getLog(COSWriter.class)
        Method writeReferenceMethod = COSWriter.class.getMethod("writeReference", COSBase.class);
        writeReferenceMethod.invoke(cosWriter, cosObject);
    }
}
