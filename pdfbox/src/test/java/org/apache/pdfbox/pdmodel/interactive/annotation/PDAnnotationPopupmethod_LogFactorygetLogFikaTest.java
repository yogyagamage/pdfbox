package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPopup;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;

import java.io.IOException;

class PDAnnotationPopupmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetParentTriggersLogFactoryGetLog() throws IOException {
        // Create a minimal COSDictionary that will allow PDAnnotation.createAnnotation to work
        COSDictionary dict = new COSDictionary();
        dict.setItem(COSName.TYPE, COSName.ANNOT);
        dict.setItem(COSName.SUBTYPE, COSName.getPDFName("Popup"));
        
        // Create a parent dictionary that will be returned by getDictionaryObject
        COSDictionary parentDict = new COSDictionary();
        parentDict.setItem(COSName.TYPE, COSName.ANNOT);
        parentDict.setItem(COSName.SUBTYPE, COSName.getPDFName("Highlight"));
        
        // Set the parent in the popup dictionary
        dict.setItem(COSName.PARENT, parentDict);
        
        // Create the PDAnnotationPopup instance
        PDAnnotationPopup popup = new PDAnnotationPopup(dict);
        
        // This call will trigger the static initializer which calls LogFactory.getLog
        // and then execute the getParent() method
        popup.getParent();
    }
}
