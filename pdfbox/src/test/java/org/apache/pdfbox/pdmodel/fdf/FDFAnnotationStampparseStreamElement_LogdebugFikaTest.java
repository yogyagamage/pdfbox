package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

class FDFAnnotationStampparseStreamElement_LogdebugFikaTest {

    @Test
    void testParseStreamElement() throws Exception {
        String xmlContent = "<stream KEY=\"TestKey\">" +
                "<INT KEY=\"TestIntKey\" VAL=\"42\"/>" +
                "<FIXED KEY=\"TestFloatKey\" VAL=\"3.14\"/>" +
                "<NAME KEY=\"TestNameKey\" VAL=\"TestName\"/>" +
                "<BOOL KEY=\"TestBoolKey\" VAL=\"true\"/>" +
                "<ARRAY KEY=\"TestArrayKey\">" +
                "<INT KEY=\"ArrayItem\" VAL=\"1\"/>" +
                "</ARRAY>" +
                "<DICT KEY=\"TestDictKey\">" +
                "<INT KEY=\"DictItem\" VAL=\"2\"/>" +
                "</DICT>" +
                "<STREAM KEY=\"TestStreamKey\">" +
                "<INT KEY=\"StreamItem\" VAL=\"3\"/>" +
                "</STREAM>" +
                "<DATA ENCODING=\"HEX\">414243</DATA>" +
                "<DATA ENCODING=\"ASCII\">TestData</DATA>" +
                "<UNKNOWN KEY=\"UnknownKey\" VAL=\"UnknownVal\"/>" +
                "</stream>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlContent)));
        Element streamEl = document.getDocumentElement();

        FDFAnnotationStamp instance = new FDFAnnotationStamp();
        java.lang.reflect.Method method = FDFAnnotationStamp.class.getDeclaredMethod(
                "parseStreamElement", Element.class);
        method.setAccessible(true);
        method.invoke(instance, streamEl);
    }
}
