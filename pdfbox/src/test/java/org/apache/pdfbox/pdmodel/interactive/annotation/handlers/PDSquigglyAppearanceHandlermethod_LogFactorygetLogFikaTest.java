package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquiggly;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PDSquigglyAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        
        PDAnnotationSquiggly annotation = new PDAnnotationSquiggly();
        annotation.setRectangle(new PDRectangle(100, 100, 200, 50));
        
        PDSquigglyAppearanceHandler handler = new PDSquigglyAppearanceHandler(annotation, document);
        
        document.close();
    }
}
