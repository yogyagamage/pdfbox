package org.apache.pdfbox.pdmodel.fdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class FDFAnnotation_FDFAnnotationStampmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            COSDictionary dict = new COSDictionary();
            dict.setItem(COSName.SUBTYPE, COSName.getPDFName("Stamp"));
            
            FDFAnnotationStamp annotation = new FDFAnnotationStamp(dict);
            
            // Trigger static initialization which calls LogFactory.getLog
            Class<?> clazz = FDFAnnotationStamp.class;
        }
    }
}
