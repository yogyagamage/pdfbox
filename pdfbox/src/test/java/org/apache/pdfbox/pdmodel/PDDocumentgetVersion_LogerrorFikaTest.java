package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class PDDocumentgetVersion_LogerrorFikaTest {

    @Test
    public void testGetVersionTriggersLogError() throws Exception {
        // Create a mock COSDocument that will cause the NumberFormatException
        COSDocument mockCosDoc = Mockito.mock(COSDocument.class);
        
        // Mock getVersion() to return >= 1.4 to enter the catalog version check
        Mockito.when(mockCosDoc.getVersion()).thenReturn(1.4f);
        
        // Mock getDocumentState() to avoid NPE in constructor
        org.apache.pdfbox.cos.COSDocumentState mockState = 
            Mockito.mock(org.apache.pdfbox.cos.COSDocumentState.class);
        Mockito.when(mockCosDoc.getDocumentState()).thenReturn(mockState);
        
        // Mock getTrailer() to avoid NPE
        COSDictionary mockTrailer = Mockito.mock(COSDictionary.class);
        Mockito.when(mockCosDoc.getTrailer()).thenReturn(mockTrailer);
        
        // Mock getHighestXRefObjectNumber() to avoid NPE
        Mockito.when(mockCosDoc.getHighestXRefObjectNumber()).thenReturn(0L);
        
        // Create PDDocument with the mocked COSDocument
        PDDocument pdDocument = new PDDocument(mockCosDoc);
        
        // Create a mock PDDocumentCatalog that will return a non-null but non-parsable version string
        PDDocumentCatalog mockCatalog = Mockito.mock(PDDocumentCatalog.class);
        
        // Return a string that cannot be parsed as float to trigger NumberFormatException
        Mockito.when(mockCatalog.getVersion()).thenReturn("not-a-float");
        
        // Use reflection to set the documentCatalog field
        java.lang.reflect.Field catalogField = PDDocument.class.getDeclaredField("documentCatalog");
        catalogField.setAccessible(true);
        catalogField.set(pdDocument, mockCatalog);
        
        // Call the entry point method - this should trigger LOG.error() when parsing fails
        pdDocument.getVersion();
    }
}
