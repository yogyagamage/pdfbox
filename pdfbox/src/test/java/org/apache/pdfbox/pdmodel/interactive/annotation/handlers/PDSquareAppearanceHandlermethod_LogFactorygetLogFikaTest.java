package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquare;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDSquareAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    public void testGenerateNormalAppearanceTriggersStaticInitializer() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationSquare annotation = new PDAnnotationSquare();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 100));
            
            PDSquareAppearanceHandler handler = new PDSquareAppearanceHandler(
                annotation,
                document
            );
            
            handler.generateNormalAppearance();
        }
    }
}
