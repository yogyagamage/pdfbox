package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import java.awt.geom.AffineTransform;

public class PDVisibleSigBuildercreateAffineTransform_LoginfoFikaTest {

    @Test
    public void testCreateAffineTransform() {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        AffineTransform transform = new AffineTransform();
        builder.createAffineTransform(transform);
    }
}
