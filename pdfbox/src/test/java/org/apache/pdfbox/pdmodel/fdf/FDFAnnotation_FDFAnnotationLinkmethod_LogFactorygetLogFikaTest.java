package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FDFAnnotation_FDFAnnotationLinkmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersLogFactoryGetLog() {
        COSDictionary fdfDic = new COSDictionary();
        fdfDic.setItem(COSName.SUBTYPE, COSName.getPDFName("Link"));
        
        FDFAnnotation.create(fdfDic);
    }
}
