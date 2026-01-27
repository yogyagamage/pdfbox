package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PDAcroForm_PDSignatureFieldconstructAppearances_LogwarnFikaTest {

    @Test
    void testRefreshAppearancesTriggersLogWarn() throws IOException {
        // Create a mock PDDocument required for PDAcroForm constructor
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        
        // Create PDAcroForm instance using the first constructor
        PDAcroForm acroForm = new PDAcroForm(mockDocument);
        
        // Create a mock PDSignatureField that will trigger the log warning
        PDSignatureField signatureField = Mockito.mock(PDSignatureField.class);
        
        // Create a mock PDAnnotationWidget with a valid rectangle
        PDAnnotationWidget mockWidget = Mockito.mock(PDAnnotationWidget.class);
        PDRectangle mockRectangle = Mockito.mock(PDRectangle.class);
        
        // Configure the mock widget to have a valid rectangle and not be hidden/noView
        Mockito.when(mockWidget.getRectangle()).thenReturn(mockRectangle);
        Mockito.when(mockRectangle.getHeight()).thenReturn(10.0f);
        Mockito.when(mockRectangle.getWidth()).thenReturn(10.0f);
        Mockito.when(mockWidget.isNoView()).thenReturn(false);
        Mockito.when(mockWidget.isHidden()).thenReturn(false);
        
        // Create a list with the mock widget
        List<PDAnnotationWidget> widgetList = new ArrayList<>();
        widgetList.add(mockWidget);
        
        // Configure the signature field to return the widget list
        Mockito.when(signatureField.getWidgets()).thenReturn(widgetList);
        
        // Make the signature field a PDTerminalField (PDSignatureField extends PDTerminalField)
        // and configure constructAppearances to call the real method on the mock
        Mockito.doCallRealMethod().when(signatureField).constructAppearances();
        
        // Create the fields list with our mock signature field
        List<PDField> fields = new ArrayList<>();
        fields.add(signatureField);
        
        // Call the entry point method - this should trigger the log warning
        acroForm.refreshAppearances(fields);
    }
}
