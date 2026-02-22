package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationMarkup_PDAnnotationmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetPopupTriggersStaticInitializer() {
        // Create a mock COSDictionary that returns null for POPUP
        COSDictionary mockDict = Mockito.mock(COSDictionary.class);
        Mockito.when(mockDict.getCOSDictionary(COSName.POPUP)).thenReturn(null);
        
        // Create a PDAnnotationMarkup instance with the mocked dictionary
        PDAnnotationMarkup annotation = new PDAnnotationMarkup(mockDict);
        
        // Call the entry point method - this will trigger static initialization
        // of PDAnnotation class which calls LogFactory.getLog
        annotation.getPopup();
    }
}
