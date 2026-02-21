package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.CALLS_REAL_METHODS;

public class PDVisibleSigBuildercreateHolderFormResources_LoginfoFikaTest {

    @Test
    public void testCreateHolderFormResources() throws Exception {
        PDVisibleSigBuilder builder = Mockito.mock(
            PDVisibleSigBuilder.class,
            Mockito.withSettings()
                .useConstructor()
                .defaultAnswer(CALLS_REAL_METHODS)
        );
        
        builder.createHolderFormResources();
    }
}
