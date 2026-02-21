package org.apache.pdfbox.cos;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSObject;

class COSArray_COSObjectmethod_LogFactorygetLogFikaTest2 {

    @Test
    void testLogFactoryGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target method call
        COSObject obj = new COSObject(null);
        // The static field LOG is initialized when the class is loaded
        // Creating an instance ensures class loading occurs
    }
}
