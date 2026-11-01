package org.apache.pdfbox.pdfwriter.compress;

import org.junit.jupiter.api.Test;

public class COSWriterCompressionPool_COSWriterObjectStreammethod_LogFactorygetLogFikaTest {

    @Test
    public void testCOSWriterObjectStreamStaticInitialization() {
        try {
            Class.forName("org.apache.pdfbox.pdfwriter.compress.COSWriterObjectStream", true, getClass().getClassLoader());
        } catch (Throwable ignored) {
        }
    }
}
