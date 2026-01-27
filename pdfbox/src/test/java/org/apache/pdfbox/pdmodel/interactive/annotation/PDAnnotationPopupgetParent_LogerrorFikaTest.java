package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class PDAnnotationPopupgetParent_LogerrorFikaTest {

    @Test
    public void testGetParentTriggersLogError() {
        // Create a COSDictionary that will cause PDAnnotation.createAnnotation to return
        // a non-PDAnnotationMarkup instance, triggering the log.error call
        COSDictionary dict = new COSDictionary();
        dict.setItem(COSName.PARENT, new COSDictionary());
        dict.setName(COSName.SUBTYPE, "Widget"); // Different from PDAnnotationMarkup subtypes
        
        PDAnnotationPopup popup = new PDAnnotationPopup(dict);
        popup.getParent();
    }
}
