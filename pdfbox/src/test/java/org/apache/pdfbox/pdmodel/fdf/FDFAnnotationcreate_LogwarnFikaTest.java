package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FDFAnnotationcreate_LogwarnFikaTest {

    @Test
    void testCreateInvokesLogWarn() {
        // Create a COSDictionary with an unknown subtype to trigger the warning log
        COSDictionary fdfDic = new COSDictionary();
        fdfDic.setName(COSName.SUBTYPE, "UnknownAnnotationType");
        
        // This will execute the method and reach the Log.warn() call
        FDFAnnotation.create(fdfDic);
    }
}
