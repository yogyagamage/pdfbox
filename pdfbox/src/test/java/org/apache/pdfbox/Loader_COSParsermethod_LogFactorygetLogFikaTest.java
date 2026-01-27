package org.apache.pdfbox;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdfparser.FDFParser;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Loader_COSParsermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLoadFDFTriggersLogFactoryGetLog() throws IOException {
        // Create a minimal valid FDF input stream
        String fdfContent = "%FDF-1.0\n" +
                "1 0 obj\n" +
                "<<\n" +
                "/FDF << /F (test.fdf) >>\n" +
                ">>\n" +
                "endobj\n" +
                "trailer\n" +
                "<<\n" +
                "/Root 1 0 R\n" +
                ">>\n" +
                "%%EOF";
        InputStream inputStream = new ByteArrayInputStream(fdfContent.getBytes());
        
        // This will trigger the static initialization of COSParser,
        // which calls LogFactory.getLog(COSParser.class)
        Loader.loadFDF(inputStream);
    }
}
