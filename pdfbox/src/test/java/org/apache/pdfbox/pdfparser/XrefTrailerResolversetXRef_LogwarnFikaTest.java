package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.Test;

public class XrefTrailerResolversetXRef_LogwarnFikaTest {

    @Test
    public void testSetXRefInvokesLogWarn() {
        XrefTrailerResolver resolver = new XrefTrailerResolver();
        COSObjectKey objKey = new COSObjectKey(1L, 0);
        resolver.setXRef(objKey, 100L);
    }
}
