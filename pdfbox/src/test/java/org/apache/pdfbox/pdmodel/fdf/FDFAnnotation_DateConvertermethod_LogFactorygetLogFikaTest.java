package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.util.DateConverter;
import org.junit.jupiter.api.Test;

public class FDFAnnotation_DateConvertermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Accessing DateConverter class will trigger static initialization
        // which includes the call to LogFactory.getLog(DateConverter.class)
        Class<?> clazz = DateConverter.class;
        
        // Force class initialization if not already done
        try {
            Class.forName(clazz.getName());
        } catch (ClassNotFoundException e) {
            // This should never happen since we're referencing the class directly
        }
    }
}
