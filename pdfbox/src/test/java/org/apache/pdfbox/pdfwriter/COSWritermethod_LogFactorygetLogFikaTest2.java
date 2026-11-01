package org.apache.pdfbox.pdfwriter;

import org.junit.jupiter.api.Test;

class COSWritermethod_LogFactorygetLogFikaTest2 {

    @Test
    void testStaticInitializationTriggersLogFactoryGetLog() {
        // Accessing any static field will trigger static initialization
        // which includes the static field: LOG = LogFactory.getLog(COSWriter.class)
        byte[] dictOpen = COSWriter.DICT_OPEN;
    }
}
