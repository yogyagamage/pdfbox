package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationPopup_PDAnnotationmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetParentTriggersStaticInitializer() {
        COSDictionary mockDict = Mockito.mock(COSDictionary.class);
        Mockito.when(mockDict.getDictionaryObject(COSName.PARENT, COSName.P))
               .thenReturn(null);
        
        PDAnnotationPopup popup = new PDAnnotationPopup(mockDict);
        popup.getParent();
    }
}
