package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPopup;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PDAnnotationPopupgetParent_LogerrorFikaTest {

    @Test
    public void testGetParentTriggersLogError() throws IOException {
        try (PDDocument document = new PDDocument()) {
            COSDictionary popupDict = new COSDictionary();
            popupDict.setItem(COSName.SUBTYPE, COSName.getPDFName("Popup"));
            
            COSDictionary parentDict = new COSDictionary();
            parentDict.setItem(COSName.SUBTYPE, COSName.getPDFName("Link"));
            
            popupDict.setItem(COSName.PARENT, parentDict);
            
            PDAnnotationPopup popup = new PDAnnotationPopup(popupDict);
            popup.getParent();
        }
    }
}
