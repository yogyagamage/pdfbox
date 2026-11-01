package org.apache.pdfbox.cos;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class COSArray_COSObjectmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws IOException {
        // Create a real COSObject instance to trigger static initialization
        COSObject obj = new COSObject(null);
        
        // Access the static LOG field to ensure it's initialized
        // This will trigger the static initializer containing LogFactory.getLog()
        Class<?> clazz = COSObject.class;
    }
}
