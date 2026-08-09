package org.apache.pdfbox.pdmodel.graphics.shading;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class IntPointmethod_LogFactorygetLogFikaTest {

    @Test
    void testEqualsTriggersLogFactoryGetLog() {
        // Create first IntPoint instance
        IntPoint point1 = new IntPoint(10, 20);
        
        // Create second IntPoint instance with different coordinates
        IntPoint point2 = new IntPoint(30, 40);
        
        // Call equals method - this will trigger static initialization
        // which calls LogFactory.getLog(IntPoint.class)
        point1.equals(point2);
    }
}
