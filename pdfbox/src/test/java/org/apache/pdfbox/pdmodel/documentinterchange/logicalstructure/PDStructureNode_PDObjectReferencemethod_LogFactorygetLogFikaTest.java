package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDObjectReference;

public class PDStructureNode_PDObjectReferencemethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target third-party method call
        PDObjectReference reference = new PDObjectReference();
        // The constructor doesn't matter - static initialization already happened
        // when class was loaded, but we create an instance to ensure class loading
    }
}
