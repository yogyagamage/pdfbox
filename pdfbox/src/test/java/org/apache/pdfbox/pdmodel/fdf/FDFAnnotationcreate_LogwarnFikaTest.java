package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

public class FDFAnnotationcreate_LogwarnFikaTest {

    @Test
    public void testCreateInvokesLogWarn() {
        // Create a COSDictionary with an unknown subtype to trigger the warning log
        COSDictionary fdfDic = new COSDictionary();
        fdfDic.setItem(COSName.SUBTYPE, COSName.getPDFName("UnknownAnnotationType"));
        
        // This should invoke LOG.warn(...) internally
        FDFAnnotation.create(fdfDic);
    }
}
