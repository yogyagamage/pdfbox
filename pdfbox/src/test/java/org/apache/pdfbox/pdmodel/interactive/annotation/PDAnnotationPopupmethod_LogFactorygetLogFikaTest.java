package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPopup;

public class PDAnnotationPopupmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetLogInvocation() {
        // Creating an instance will trigger static initialization
        // which includes the LogFactory.getLog call
        PDAnnotationPopup annotation = new PDAnnotationPopup();
    }
}
