package org.apache.pdfbox.printing;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.print.PageFormat;

class PDFPageable_PDFPrintablemethod_LogFactorygetLogFikaTest2 {

    @Test
    void testGetPageFormatTriggersLogFactoryGetLog() throws Exception {
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        PDPage mockPage = Mockito.mock(PDPage.class);
        PDRectangle mockMediaBox = Mockito.mock(PDRectangle.class);
        PDRectangle mockCropBox = Mockito.mock(PDRectangle.class);

        Mockito.when(mockDocument.getPage(0)).thenReturn(mockPage);
        Mockito.when(mockPage.getMediaBox()).thenReturn(mockMediaBox);
        Mockito.when(mockPage.getCropBox()).thenReturn(mockCropBox);
        Mockito.when(mockMediaBox.getWidth()).thenReturn(100.0f);
        Mockito.when(mockMediaBox.getHeight()).thenReturn(200.0f);
        Mockito.when(mockCropBox.getLowerLeftX()).thenReturn(0.0f);
        Mockito.when(mockCropBox.getLowerLeftY()).thenReturn(0.0f);
        Mockito.when(mockCropBox.getWidth()).thenReturn(100.0f);
        Mockito.when(mockCropBox.getHeight()).thenReturn(200.0f);

        PDFPageable pageable = new PDFPageable(mockDocument);
        pageable.getPageFormat(0);
    }
}
