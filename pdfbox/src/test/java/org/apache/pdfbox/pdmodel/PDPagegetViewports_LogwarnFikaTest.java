package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class PDPagegetViewports_LogwarnFikaTest {

    @Test
    public void testGetViewportsTriggersLogWarn() throws Exception {
        // Create a mock COSArray that will return a non-dictionary COSBase
        COSArray mockArray = Mockito.mock(COSArray.class);
        Mockito.when(mockArray.size()).thenReturn(1);
        
        // Create a COSBase that is NOT a COSDictionary to trigger the warn log
        COSBase nonDictionaryBase = Mockito.mock(COSBase.class);
        Mockito.when(mockArray.getObject(0)).thenReturn(nonDictionaryBase);
        
        // Create a mock page dictionary that returns our array for COSName.VP
        COSDictionary mockPageDict = Mockito.mock(COSDictionary.class);
        Mockito.when(mockPageDict.getCOSArray(COSName.VP)).thenReturn(mockArray);
        
        // Create PDPage with the mock dictionary
        PDPage page = new PDPage(mockPageDict);
        
        // This should trigger LOG.warn when processing the non-dictionary element
        List<?> viewports = page.getViewports();
    }
}
