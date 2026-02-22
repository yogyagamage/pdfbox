package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FDFAnnotation_FDFAnnotationPolylinemethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersLogFactoryGetLog() {
        // Create a COSDictionary with the Polyline subtype
        COSDictionary fdfDic = new COSDictionary();
        fdfDic.setItem(COSName.SUBTYPE, COSName.getPDFName("Polyline"));
        
        // This will trigger FDFAnnotationPolyline class initialization,
        // which calls LogFactory.getLog(FDFAnnotationPolyline.class)
        FDFAnnotation.create(fdfDic);
    }
}
