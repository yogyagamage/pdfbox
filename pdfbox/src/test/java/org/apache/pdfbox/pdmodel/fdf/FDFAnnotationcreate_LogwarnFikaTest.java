package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FDFAnnotationcreate_LogwarnFikaTest {

    @Test
    void testCreateWithUnknownSubtype() {
        COSDictionary fdfDic = new COSDictionary();
        fdfDic.setItem(COSName.SUBTYPE, COSName.getPDFName("UnknownAnnotationType"));
        
        FDFAnnotation.create(fdfDic);
    }
}
