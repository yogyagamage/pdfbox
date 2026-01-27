package org.apache.pdfbox.pdmodel.graphics.shading;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class IntPointmethod_LogFactorygetLogFikaTest {

    @Test
    void testEqualsTriggersStaticInitializer() {
        IntPoint point1 = new IntPoint(10, 20);
        IntPoint point2 = new IntPoint(10, 20);
        
        // This will trigger the static initializer which calls LogFactory.getLog
        point1.equals(point2);
    }
}
