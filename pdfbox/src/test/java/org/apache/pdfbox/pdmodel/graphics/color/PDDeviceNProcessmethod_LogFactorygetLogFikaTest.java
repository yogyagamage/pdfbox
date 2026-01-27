package org.apache.pdfbox.pdmodel.graphics.color;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class PDDeviceNProcessmethod_LogFactorygetLogFikaTest {

    @Test
    void testToStringTriggersStaticInitializer() {
        COSDictionary attributes = new COSDictionary();
        PDDeviceNProcess process = new PDDeviceNProcess(attributes);
        process.toString();
    }
}
