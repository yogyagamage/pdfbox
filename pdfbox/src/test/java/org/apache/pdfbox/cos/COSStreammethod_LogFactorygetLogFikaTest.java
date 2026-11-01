package org.apache.pdfbox.cos;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSStream;

public class COSStreammethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Creating a COSStream instance will trigger static initialization
        // which includes the LogFactory.getLog(COSStream.class) call
        COSStream stream = new COSStream();
    }
}
