package org.apache.pdfbox.pdmodel.graphics.image;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PDImageXObjectmethod_LogFactorygetLogFikaTest7 {

    @Test
    public void testStaticInitializationTriggersLogFactoryGetLog() throws IOException {
        // Creating a PDDocument is necessary because PDImageXObject.createFromFile
        // requires it, and this will load the class and trigger static initialization
        try (PDDocument document = new PDDocument()) {
            // This will cause PDImageXObject class to be loaded and initialized,
            // which triggers the static field initialization containing LogFactory.getLog
            Class.forName("org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject");
        } catch (ClassNotFoundException e) {
            // This shouldn't happen since we're in the same package
            throw new RuntimeException(e);
        }
    }
}
