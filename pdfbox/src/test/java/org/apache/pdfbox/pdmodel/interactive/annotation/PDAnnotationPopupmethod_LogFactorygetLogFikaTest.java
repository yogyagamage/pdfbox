package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PDAnnotationPopupmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetParentTriggersLogFactoryGetLog() {
        COSDictionary cosDictionary = new COSDictionary();
        PDAnnotationPopup popup = new PDAnnotationPopup(cosDictionary);
        popup.getParent();
    }
}
