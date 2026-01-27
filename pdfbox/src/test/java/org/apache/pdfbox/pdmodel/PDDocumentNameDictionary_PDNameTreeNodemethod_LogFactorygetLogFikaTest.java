package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentNameDictionary;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentNameDictionary_PDNameTreeNodemethod_LogFactorygetLogFikaTest {

    @Test
    void testGetJavaScriptTriggersStaticInitializer() {
        // Create mocks for required constructor dependencies
        PDDocumentCatalog catalogMock = Mockito.mock(PDDocumentCatalog.class);
        COSDictionary namesDictMock = Mockito.mock(COSDictionary.class);
        COSDictionary catalogDictMock = Mockito.mock(COSDictionary.class);
        
        // Setup mock behavior to ensure getJavaScript() doesn't return null
        Mockito.when(catalogMock.getCOSObject()).thenReturn(catalogDictMock);
        Mockito.when(catalogDictMock.getCOSDictionary(COSName.NAMES)).thenReturn(namesDictMock);
        Mockito.when(namesDictMock.getCOSDictionary(COSName.JAVA_SCRIPT)).thenReturn(new COSDictionary());
        
        // Instantiate the class under test using the first constructor
        PDDocumentNameDictionary dictionary = new PDDocumentNameDictionary(catalogMock);
        
        // Call the entry point method - this will trigger the static initializer
        // in PDNameTreeNode when PDJavascriptNameTreeNode is instantiated
        dictionary.getJavaScript();
    }
}
