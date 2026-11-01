package org.apache.pdfbox.pdmodel.interactive.viewerpreferences;

import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

public class PDViewerPreferences_COSDictionarymethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Creating a COSDictionary instance will trigger static initialization
        // which includes the LogFactory.getLog(COSDictionary.class) call
        COSDictionary dictionary = new COSDictionary();
        
        // Additional operations to ensure the class is fully initialized
        // and the static field is accessed
        COSDictionary anotherDictionary = new COSDictionary();
        dictionary.setItem("test", anotherDictionary);
    }
}
