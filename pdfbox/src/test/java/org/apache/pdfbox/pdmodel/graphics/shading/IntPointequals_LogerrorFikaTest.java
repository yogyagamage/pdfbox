package org.apache.pdfbox.pdmodel.graphics.shading;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.Log;
import java.awt.geom.Point2D;

public class IntPointequals_LogerrorFikaTest {

    @Test
    public void testEqualsTriggersLogError() {
        IntPoint intPoint = new IntPoint(1, 2);
        Point2D point2D = new Point2D.Double(3.0, 4.0);
        
        intPoint.equals(point2D);
    }
}
