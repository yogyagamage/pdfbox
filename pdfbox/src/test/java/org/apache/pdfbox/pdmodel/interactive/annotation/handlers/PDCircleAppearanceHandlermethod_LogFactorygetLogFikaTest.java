package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDCircleAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testGenerateNormalAppearanceTriggersStaticInitializer() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationCircle annotation = new PDAnnotationCircle();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 150));
            
            PDCircleAppearanceHandler handler = new PDCircleAppearanceHandler(
                annotation,
                document
            );
            
            handler.generateNormalAppearance();
        }
    }
}
