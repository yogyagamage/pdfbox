package org.apache.pdfbox.pdmodel.graphics.shading;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.awt.geom.Point2D;

class IntPointequals_LogerrorFikaTest {

    @Test
    void testEqualsTriggersLogError() {
        // Create an IntPoint instance
        IntPoint intPoint = new IntPoint(5, 10);
        
        // Create a Point2D instance that will pass the instanceof check
        // but fail the getClass() check in equals() method
        Point2D point2D = new Point2D.Double(5.0, 10.0);
        
        // This call should trigger the LOG.error() in the equals() method
        // when obj instanceof Point2D is true but getClass() != obj.getClass()
        intPoint.equals(point2D);
    }
}
