package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.filter.LZWFilter;

class Filter_LZWFiltermethod_LogFactorygetLogFikaTest {

    @Test
    void test() {
        // Access the static field to trigger static initialization
        // which includes the LogFactory.getLog(LZWFilter.class) call
        LZWFilter filter = new LZWFilter();
        // The constructor doesn't need to do anything specific,
        // but creating an instance ensures the class is loaded
        // and static initializers run
    }
}
