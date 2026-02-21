package org.apache.pdfbox.printing;

import org.junit.jupiter.api.Test;
import java.awt.print.PrinterJob;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.ByteArrayOutputStream;

class PDFPageable_PDFPrintablemethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            document.addPage(new PDPage());
            
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            PDFPrintable printable = new PDFPrintable(document);
            
            // Trigger static initialization which calls LogFactory.getLog
            Class<?> clazz = PDFPrintable.class;
        }
    }
}
