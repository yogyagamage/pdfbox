package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPolygon;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class PDPolygonAppearanceHandlergenerateNormalAppearance_LogerrorFikaTest {

    @Test
    void testGenerateNormalAppearanceTriggersLogError() throws Exception {
        // Create a real PDDocument
        PDDocument document = new PDDocument();
        
        // Create a real PDAnnotationPolygon with minimal configuration
        PDAnnotationPolygon annotation = new PDAnnotationPolygon();
        
        // Set rectangle to non-null
        PDRectangle rect = new PDRectangle(100, 100, 200, 200);
        annotation.setRectangle(rect);
        
        // Set path array (COSArray) to avoid null return from getPathArray
        COSArray vertices = new COSArray();
        vertices.add(new COSFloat(110));
        vertices.add(new COSFloat(110));
        vertices.add(new COSFloat(190));
        vertices.add(new COSFloat(110));
        vertices.add(new COSFloat(150));
        vertices.add(new COSFloat(190));
        
        COSArray pathArray = new COSArray();
        pathArray.add(vertices);
        
        // Use reflection to set the private field
        COSDictionary dict = annotation.getCOSObject();
        dict.setItem("Vertices", vertices);
        
        // Create handler using constructor that takes annotation and document
        PDPolygonAppearanceHandler handler = new PDPolygonAppearanceHandler(annotation, document);
        
        // Mock the getNormalAppearanceAsContentStream to throw IOException
        // This will trigger the catch block and call LOG.error(e)
        PDPolygonAppearanceHandler spyHandler = Mockito.spy(handler);
        Mockito.when(spyHandler.getNormalAppearanceAsContentStream())
               .thenThrow(new IOException("Test exception to trigger LOG.error"));
        
        // Call the entry point method
        spyHandler.generateNormalAppearance();
        
        // Clean up
        document.close();
    }
}
