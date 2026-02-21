package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.util.DateConverter;
import org.junit.jupiter.api.Test;

public class FDFAnnotation_DateConvertermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Accessing the DateConverter class will trigger static initialization
        // which includes the call to LogFactory.getLog(DateConverter.class)
        Class<?> clazz = DateConverter.class;
        
        // Force class initialization if not already initialized
        try {
            Class.forName(clazz.getName(), true, clazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            // This should not happen since we're referencing an existing class
            throw new RuntimeException(e);
        }
    }
}
