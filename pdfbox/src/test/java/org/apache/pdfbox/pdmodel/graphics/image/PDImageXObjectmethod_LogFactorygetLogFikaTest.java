package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PDImageXObjectmethod_LogFactorygetLogFikaTest {

    @Test
    public void testCreateThumbnailTriggersStaticInitializer() throws IOException {
        // Create a minimal COSStream that can be used to instantiate PDStream
        COSStream cosStream = new COSStream(null);
        
        // This call will trigger the static initializer which calls LogFactory.getLog
        PDImageXObject.createThumbnail(cosStream);
    }
}
