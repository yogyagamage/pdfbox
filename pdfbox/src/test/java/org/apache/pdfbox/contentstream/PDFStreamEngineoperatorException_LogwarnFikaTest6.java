package org.apache.pdfbox.contentstream;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.junit.jupiter.api.Test;

public class PDFStreamEngineoperatorException_LogwarnFikaTest6 {

    @Test
    public void testOperatorExceptionLogWarn() throws Exception {
        PDFStreamEngine engine = createEngine();

        Operator operator = null;
        try {
            operator = createOperator();
        } catch (Throwable ignored) {
        }

        IOException exception = createEmptyGraphicsStackException();
        if (exception == null) {
            if (operator == null) {
                throw new Exception("Unable to create Operator for fallback path");
            }
            exception = new IOException("test", new java.util.zip.DataFormatException("test"));
        }

        List<COSBase> operands = new ArrayList<>();
        engine.operatorException(operator, operands, exception);
    }

    private static PDFStreamEngine createEngine() throws Exception {
        String[] candidates = {
            "org.apache.pdfbox.contentstream.PDFStreamEngine",
            "org.apache.pdfbox.text.PDFTextStripper",
            "org.apache.pdfbox.text.PDFTextStripperByArea"
        };
        Throwable last = null;
        for (String candidate : candidates) {
            try {
                Class<?> clazz = Class.forName(candidate);
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                Object instance = constructor.newInstance();
                if (instance instanceof PDFStreamEngine) {
                    return (PDFStreamEngine) instance;
                }
                last = new Exception("Candidate is not a PDFStreamEngine: " + candidate);
            } catch (Throwable e) {
                last = e;
            }
        }
        throw new Exception("Unable to create PDFStreamEngine", last);
    }

    private static IOException createEmptyGraphicsStackException() {
        String[] candidates = {
            "org.apache.pdfbox.contentstream.operator.state.EmptyGraphicsStackException",
            "org.apache.pdfbox.pdmodel.graphics.EmptyGraphicsStackException",
            "org.apache.pdfbox.pdmodel.graphics.state.EmptyGraphicsStackException",
            "org.apache.pdfbox.contentstream.EmptyGraphicsStackException",
            "org.apache.pdfbox.contentstream.operator.EmptyGraphicsStackException"
        };
        for (String candidate : candidates) {
            try {
                Class<?> clazz = Class.forName(candidate);
                if (!IOException.class.isAssignableFrom(clazz)) {
                    continue;
                }
                try {
                    Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
                    constructor.setAccessible(true);
                    return (IOException) constructor.newInstance("test");
                } catch (Throwable stringFailure) {
                    try {
                        Constructor<?> constructor = clazz.getDeclaredConstructor();
                        constructor.setAccessible(true);
                        return (IOException) constructor.newInstance();
                    } catch (Throwable ignored) {
                    }
                }
            } catch (Throwable ignored) {
            }
        }
        return null;
    }

    private static Operator createOperator() throws Exception {
        Class<?> clazz = Operator.class;
        try {
            java.lang.reflect.Method method = clazz.getMethod("newInstance", String.class);
            return (Operator) method.invoke(null, "BT");
        } catch (Throwable ignored) {
        }
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            return (Operator) constructor.newInstance("BT");
        } catch (Throwable ignored) {
        }
        try {
            java.lang.reflect.Method method = clazz.getMethod("newInstance", String.class, List.class);
            return (Operator) method.invoke(null, "BT", new ArrayList<COSBase>());
        } catch (Throwable ignored) {
        }
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, List.class);
        constructor.setAccessible(true);
        return (Operator) constructor.newInstance("BT", new ArrayList<COSBase>());
    }
}
