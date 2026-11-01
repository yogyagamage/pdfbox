package org.apache.pdfbox.rendering;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class PageDrawer_TilingPaintmethod_LogerrorFikaTest2 {

    @Test
    public void testStaticInitializerTriggersLogError() throws Exception {
        // Access the static field to trigger static initialization
        Field maxEdgeField = TilingPaint.class.getDeclaredField("MAXEDGE");
        maxEdgeField.setAccessible(true);
        
        // Set system property to trigger NumberFormatException
        System.setProperty("pdfbox.rendering.tilingpaint.maxedge", "not-a-number");
        
        try {
            // Trigger class loading and static initialization
            Class.forName("org.apache.pdfbox.rendering.TilingPaint");
        } catch (ClassNotFoundException e) {
            // Should not happen
        } finally {
            // Clean up system property
            System.clearProperty("pdfbox.rendering.tilingpaint.maxedge");
        }
    }
}
