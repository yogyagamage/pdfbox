package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FDFAnnotation_FDFAnnotationStampmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersLogFactoryGetLog() {
        COSDictionary fdfDic = new COSDictionary();
        fdfDic.setItem(COSName.SUBTYPE, COSName.getPDFName("Stamp"));
        
        FDFAnnotation.create(fdfDic);
    }
}
