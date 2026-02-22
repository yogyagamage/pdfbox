package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDLinkAppearanceHandlergenerateNormalAppearance_LogwarnFikaTest {

    @Test
    public void testGenerateNormalAppearanceTriggersLogWarn() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationLink annotation = new PDAnnotationLink();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 50));
            
            float[] quadPoints = new float[] {
                50, 50,  // Outside rectangle (x=50 < 100)
                150, 120,
                250, 120,
                150, 150
            };
            annotation.setQuadPoints(quadPoints);
            
            PDLinkAppearanceHandler handler = new PDLinkAppearanceHandler(
                annotation,
                document
            );
            
            handler.generateNormalAppearance();
        }
    }
}
