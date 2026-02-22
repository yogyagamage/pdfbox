package org.apache.pdfbox.pdmodel.graphics.shading;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.graphics.shading.IntPoint;

class IntPointmethod_LogFactorygetLogFikaTest {

    @Test
    void testEqualsTriggersLogFactoryGetLog() {
        // Create two IntPoint instances
        IntPoint point1 = new IntPoint(1, 2);
        IntPoint point2 = new IntPoint(3, 4);
        
        // First call to equals with same object
        point1.equals(point1);
        
        // Second call to equals with null
        point1.equals(null);
        
        // Third call to equals with different class
        point1.equals(new Object());
        
        // Fourth call to equals with Point2D instance to trigger LOG.error
        // Create a Point2D instance (using java.awt.geom.Point2D.Double)
        java.awt.geom.Point2D point2D = new java.awt.geom.Point2D.Double(1.0, 2.0);
        point1.equals(point2D);
        
        // Fifth call to equals with another IntPoint instance
        point1.equals(point2);
    }
}
