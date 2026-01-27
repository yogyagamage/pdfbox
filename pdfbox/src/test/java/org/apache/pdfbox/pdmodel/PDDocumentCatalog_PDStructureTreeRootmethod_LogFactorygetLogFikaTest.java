package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentCatalog_PDStructureTreeRootmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetStructureTreeRootTriggersStaticInitializer() {
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        COSDictionary mockRootDict = Mockito.mock(COSDictionary.class);
        COSDictionary mockTrailer = Mockito.mock(COSDictionary.class);
        org.apache.pdfbox.cos.COSDocument mockCosDocument = Mockito.mock(org.apache.pdfbox.cos.COSDocument.class);
        
        Mockito.when(mockDocument.getDocument()).thenReturn(mockCosDocument);
        Mockito.when(mockCosDocument.getTrailer()).thenReturn(mockTrailer);
        Mockito.when(mockRootDict.getCOSDictionary(COSName.STRUCT_TREE_ROOT)).thenReturn(null);
        
        PDDocumentCatalog catalog = new PDDocumentCatalog(mockDocument, mockRootDict);
        
        catalog.getStructureTreeRoot();
        
        // Trigger static initialization of PDStructureTreeRoot class
        try {
            Class.forName("org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot");
        } catch (ClassNotFoundException e) {
            // Ignore - should not happen
        }
    }
}
