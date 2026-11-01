package org.apache.pdfbox.pdmodel.fdf;

import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FDFAnnotationStampparseStampAnnotationAppearanceXML_LogwarnFikaTest {
    @Test
    public void parseStampAnnotationAppearanceXMLReachesLogWarn() throws Exception {
        FDFAnnotationStamp stamp = new FDFAnnotationStamp();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element appearanceXML = document.createElement("Appearance");
        appearanceXML.setAttribute("KEY", "NOT_AP");

        Method method = FDFAnnotationStamp.class.getDeclaredMethod(
                "parseStampAnnotationAppearanceXML", Element.class);
        method.setAccessible(true);
        method.invoke(stamp, appearanceXML);
    }
}
