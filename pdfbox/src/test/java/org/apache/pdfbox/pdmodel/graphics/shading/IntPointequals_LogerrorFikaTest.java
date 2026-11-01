package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.pdmodel.graphics.shading.IntPoint;
import org.junit.jupiter.api.Test;

class IntPointequals_LogerrorFikaTest {

    @Test
    void testEqualsInvokesLogError() {
        IntPoint point1 = new IntPoint(1, 2);
        IntPoint point2 = new IntPoint(3, 4);
        
        // Create a Point2D instance to trigger the branch with LOG.error
        java.awt.geom.Point2D point2D = new java.awt.geom.Point2D.Double(1.0, 2.0);
        
        // This should invoke LOG.error when comparing IntPoint with Point2D
        point1.equals(point2D);
    }
}
