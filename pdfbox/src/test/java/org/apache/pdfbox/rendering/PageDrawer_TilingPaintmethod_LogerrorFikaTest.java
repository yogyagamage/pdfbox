package org.apache.pdfbox.rendering;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class PageDrawer_TilingPaintmethod_LogerrorFikaTest {

    @Test
    public void testTilingPaintStaticInitializer() throws Exception {
        // Access the static field to trigger static initializer
        Field maxEdgeField = TilingPaint.class.getDeclaredField("MAXEDGE");
        maxEdgeField.setAccessible(true);
        
        // Try to set system property to cause NumberFormatException
        String originalValue = System.getProperty("pdfbox.rendering.tilingpaint.maxedge");
        try {
            System.setProperty("pdfbox.rendering.tilingpaint.maxedge", "not-a-number");
            
            // Trigger class loading and static initialization
            Class.forName("org.apache.pdfbox.rendering.TilingPaint");
        } finally {
            // Restore original system property
            if (originalValue != null) {
                System.setProperty("pdfbox.rendering.tilingpaint.maxedge", originalValue);
            } else {
                System.clearProperty("pdfbox.rendering.tilingpaint.maxedge");
            }
        }
    }
}
