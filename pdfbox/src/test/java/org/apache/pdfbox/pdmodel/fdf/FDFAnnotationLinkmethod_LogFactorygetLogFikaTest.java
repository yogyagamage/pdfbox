package org.apache.pdfbox.pdmodel.fdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class FDFAnnotationLinkmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            COSDictionary dict = new COSDictionary();
            dict.setItem(COSName.SUBTYPE, COSName.getPDFName(FDFAnnotationLink.SUBTYPE));
            
            FDFAnnotationLink annotation = new FDFAnnotationLink(dict);
            
            // Trigger class initialization which will invoke LogFactory.getLog
            Class<?> clazz = annotation.getClass();
        }
    }
}
