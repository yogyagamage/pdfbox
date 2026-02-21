package org.apache.pdfbox.multipdf;

import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PageExtractor_Splittermethod_LogFactorygetLogFikaTest {

    @Test
    public void testSplitterConstructor() throws IOException {
        Splitter splitter = new Splitter();
        // The static field LOG triggers LogFactory.getLog(Splitter.class)
        // when the class is loaded, which happens during Splitter instantiation
    }
}
