package org.apache.pdfbox.pdfparser;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdfparser.XrefTrailerResolver;

public class XrefTrailerResolvermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target third-party method call
        XrefTrailerResolver resolver = new XrefTrailerResolver();
        // The static field LOG is initialized when class is loaded
        // This happens either when we create an instance or access the class
        // The getLog method is called during static initialization
    }
}
