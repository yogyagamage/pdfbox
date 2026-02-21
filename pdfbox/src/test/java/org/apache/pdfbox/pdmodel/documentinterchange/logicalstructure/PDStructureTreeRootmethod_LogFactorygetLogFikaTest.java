package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import org.junit.jupiter.api.Test;

public class PDStructureTreeRootmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target third-party method call
        PDStructureTreeRoot root = new PDStructureTreeRoot();
        // The constructor doesn't matter - static initialization already happened
        // when the class was loaded, which occurs before this test runs
    }
}
