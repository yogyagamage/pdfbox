package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FDFAnnotation_FDFAnnotationFreeTextmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersLogFactoryGetLog() {
        // Create a COSDictionary with the FreeText subtype
        COSDictionary fdfDic = new COSDictionary();
        fdfDic.setName(COSName.SUBTYPE, "FreeText");
        
        // This will trigger FDFAnnotationFreeText class initialization
        // which calls LogFactory.getLog(FDFAnnotationFreeText.class)
        FDFAnnotation.create(fdfDic);
    }
}
