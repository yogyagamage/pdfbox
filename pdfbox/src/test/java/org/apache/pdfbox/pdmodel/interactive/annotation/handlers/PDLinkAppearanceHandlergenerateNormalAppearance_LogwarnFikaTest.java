package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;

public class PDLinkAppearanceHandlergenerateNormalAppearance_LogwarnFikaTest {

    @Test
    public void testGenerateNormalAppearanceTriggersLogWarn() throws Exception {
        // Create a mock annotation that will trigger the LOG.warn call
        PDAnnotationLink mockAnnotation = Mockito.mock(PDAnnotationLink.class);
        
        // Setup rectangle that will be used for containment check
        PDRectangle rect = new PDRectangle(0, 0, 100, 100);
        Mockito.when(mockAnnotation.getRectangle()).thenReturn(rect);
        
        // Create quad points where at least one point is outside the rectangle
        // Point at index (0,1) = (150, 50) is outside rectangle (0,0,100,100)
        float[] quadPoints = new float[] {150f, 50f, 20f, 20f, 80f, 20f, 80f, 80f, 20f, 80f};
        Mockito.when(mockAnnotation.getQuadPoints()).thenReturn(quadPoints);
        
        // Setup border style to avoid NPE in getLineWidth()
        PDBorderStyleDictionary borderStyle = new PDBorderStyleDictionary();
        Mockito.when(mockAnnotation.getBorderStyle()).thenReturn(borderStyle);
        
        // Setup border array to avoid NPE in getLineWidth()
        COSArray borderArray = new COSArray();
        borderArray.add(COSFloat.get("0")); // horizontal corner radius
        borderArray.add(COSFloat.get("0")); // vertical corner radius
        borderArray.add(COSFloat.get("1")); // width
        Mockito.when(mockAnnotation.getBorder()).thenReturn(borderArray);
        
        // Create handler with mock annotation and real document
        PDDocument document = new PDDocument();
        PDLinkAppearanceHandler handler = new PDLinkAppearanceHandler(mockAnnotation, document);
        
        // This should trigger the LOG.warn call when quad point is outside rectangle
        handler.generateNormalAppearance();
        
        document.close();
    }
}
