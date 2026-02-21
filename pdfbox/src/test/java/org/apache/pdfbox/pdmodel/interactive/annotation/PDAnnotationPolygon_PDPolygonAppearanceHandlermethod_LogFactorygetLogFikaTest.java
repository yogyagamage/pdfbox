package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPolygon;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDPolygonAppearanceHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PDAnnotationPolygon_PDPolygonAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationPolygon annotation = new PDAnnotationPolygon();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 200));
            float[] vertices = {100, 100, 200, 100, 200, 200, 100, 200};
            annotation.setVertices(vertices);
            
            PDPolygonAppearanceHandler handler = new PDPolygonAppearanceHandler(annotation, document);
            
            // This will trigger the static initialization of PDPolygonAppearanceHandler
            // which calls LogFactory.getLog(PDPolygonAppearanceHandler.class)
            handler.generateAppearanceStreams();
        }
    }
}
