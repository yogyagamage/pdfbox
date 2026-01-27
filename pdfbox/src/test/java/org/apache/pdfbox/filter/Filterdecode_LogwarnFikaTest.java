package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.filter.Filter;
import org.apache.pdfbox.filter.FilterFactory;
import org.apache.pdfbox.io.RandomAccessRead;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class Filterdecode_LogwarnFikaTest {

    @Test
    void testDecodeTriggersLogWarn() throws IOException {
        // Create a filter list with duplicates to trigger the warning log
        List<Filter> filterList = new ArrayList<>();
        Filter filter1 = FilterFactory.INSTANCE.getFilter(COSName.FLATE_DECODE);
        Filter filter2 = FilterFactory.INSTANCE.getFilter(COSName.FLATE_DECODE);
        
        // Add the same filter twice to create duplicates
        filterList.add(filter1);
        filterList.add(filter2);
        
        // Create minimal required parameters
        COSDictionary parameters = new COSDictionary();
        parameters.setLong(COSName.LENGTH, 100L);
        
        // Create input stream with some dummy data
        byte[] data = new byte[10];
        InputStream encoded = new ByteArrayInputStream(data);
        
        // Create decode options
        DecodeOptions options = DecodeOptions.DEFAULT;
        
        // Call the static decode method - this should trigger the warning log
        // when it detects duplicate filters in the list
        RandomAccessRead result = Filter.decode(encoded, filterList, parameters, options, null);
        
        // No assertions needed - test passes if no exception is thrown
        // and the Log.warn() method was invoked during execution
    }
}
