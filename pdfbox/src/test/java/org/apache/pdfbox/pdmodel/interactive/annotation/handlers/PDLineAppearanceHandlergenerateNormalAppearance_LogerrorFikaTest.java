package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLine;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDLineAppearanceHandlergenerateNormalAppearance_LogerrorFikaTest {

    @Test
    public void testGenerateNormalAppearanceTriggersLogError() throws IOException {
        // Create a real PDDocument
        PDDocument document = new PDDocument();
        
        // Create a real PDAnnotationLine with all required properties
        PDAnnotationLine annotation = new PDAnnotationLine();
        
        // Set rectangle (required to pass early null check)
        PDRectangle rect = new PDRectangle(100, 100, 200, 200);
        annotation.setRectangle(rect);
        
        // Set line coordinates (required to pass early null check)
        float[] lineArray = {10.0f, 10.0f, 90.0f, 90.0f};
        annotation.setLine(lineArray);
        
        // Set color (required to pass early null check)
        PDColor color = new PDColor(new float[]{0.5f, 0.5f, 0.5f}, PDDeviceRGB.INSTANCE);
        annotation.setColor(color);
        
        // Set border style to avoid NPE in AnnotationBorder.getAnnotationBorder
        PDBorderStyleDictionary borderStyle = new PDBorderStyleDictionary();
        borderStyle.setWidth(1.0f);
        annotation.setBorderStyle(borderStyle);
        
        // Set border array to avoid NPE in AnnotationBorder.getAnnotationBorder
        COSArray borderArray = new COSArray();
        borderArray.add(COSName.getPDFName("0"));
        borderArray.add(COSName.getPDFName("0"));
        borderArray.add(COSName.getPDFName("1"));
        annotation.getCOSObject().setItem(COSName.BORDER, borderArray);
        
        // Enable caption and set contents that will cause IllegalArgumentException
        // when font.getStringWidth() is called
        annotation.setCaption(true);
        
        // Set contents to a string that will cause IllegalArgumentException
        // when PDFont.getStringWidth() is called
        annotation.setContents("\u0000"); // Null character that causes IllegalArgumentException
        
        // Set required properties for caption handling
        annotation.setCaptionPositioning("Inline");
        annotation.setStartPointEndingStyle("None");
        annotation.setEndPointEndingStyle("None");
        
        // Create handler using constructor that takes both annotation and document
        PDLineAppearanceHandler handler = new PDLineAppearanceHandler(annotation, document);
        
        // Call the entry point method - this should trigger the LOG.error call
        // when the IllegalArgumentException is caught
        handler.generateNormalAppearance();
        
        // Close the document
        document.close();
    }
}
