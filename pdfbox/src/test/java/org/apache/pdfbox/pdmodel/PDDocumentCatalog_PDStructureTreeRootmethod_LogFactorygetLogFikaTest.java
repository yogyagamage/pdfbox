package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PDDocumentCatalog_PDStructureTreeRootmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetStructureTreeRootTriggersStaticInitializer() throws Exception {
        // Create a real PDDocumentCatalog with mocked dependencies
        COSDictionary rootDict = Mockito.mock(COSDictionary.class);
        Mockito.when(rootDict.getCOSDictionary(org.apache.pdfbox.cos.COSName.STRUCT_TREE_ROOT))
               .thenReturn(new COSDictionary());
        
        PDDocument document = Mockito.mock(PDDocument.class);
        PDDocumentCatalog catalog = new PDDocumentCatalog(document, rootDict);
        
        // This call triggers the static initializer of PDStructureTreeRoot
        // which calls LogFactory.getLog(PDStructureTreeRoot.class)
        catalog.getStructureTreeRoot();
    }
}
