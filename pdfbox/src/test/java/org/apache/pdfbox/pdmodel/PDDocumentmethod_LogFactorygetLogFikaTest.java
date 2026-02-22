package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PDDocumentmethod_LogFactorygetLogFikaTest {

    @Test
    public void testImportPageTriggersStaticInitializer() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.importPage(page);
    }
}
