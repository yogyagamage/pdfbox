package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FDFAnnotation_FDFAnnotationInkmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersFDFAnnotationInkStaticInitializer() {
        COSDictionary fdfDic = new COSDictionary();
        fdfDic.setItem(COSName.SUBTYPE, COSName.getPDFName("Ink"));
        
        FDFAnnotation.create(fdfDic);
    }
}
