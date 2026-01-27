package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.doThrow;

public class PDAnnotationPopupgetParent_LogdebugFikaTest {

    @Test
    public void testGetParentTriggersLogDebug() throws Exception {
        // Create a COSDictionary that will cause PDAnnotation.createAnnotation to throw IOException
        COSDictionary dict = new COSDictionary();
        dict.setItem(COSName.PARENT, COSName.P); // This will make getDictionaryObject return COSName.P
        
        // Create PDAnnotationPopup with the dictionary
        PDAnnotationPopup popup = new PDAnnotationPopup(dict);
        
        // Call getParent - when PDAnnotation.createAnnotation is called with COSName.P,
        // it will throw IOException, triggering LOG.debug
        popup.getParent();
    }
}
