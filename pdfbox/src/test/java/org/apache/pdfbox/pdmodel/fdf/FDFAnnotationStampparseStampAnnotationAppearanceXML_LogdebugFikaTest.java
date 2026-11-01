package org.apache.pdfbox.pdmodel.fdf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FDFAnnotationStampparseStampAnnotationAppearanceXML_LogdebugFikaTest {

    @Test
    void parseStampAnnotationAppearanceXMLInvokesLogDebug() throws Exception {
        Class<?> stampClass = FDFAnnotationStamp.class;
        Object stampInstance = null;

        try {
            Constructor<?> noArg = stampClass.getDeclaredConstructor();
            noArg.setAccessible(true);
            stampInstance = noArg.newInstance();
        } catch (Throwable ignored) {
        }

        if (stampInstance == null) {
            try {
                Class<?> fdfDictClass = Class.forName("org.apache.pdfbox.pdmodel.fdf.FDFDictionary");
                Object fdfDict = fdfDictClass.getDeclaredConstructor().newInstance();
                Constructor<?> ctor = stampClass.getDeclaredConstructor(fdfDictClass);
                ctor.setAccessible(true);
                stampInstance = ctor.newInstance(fdfDict);
            } catch (Throwable ignored) {
            }
        }

        if (stampInstance == null) {
            try {
                Class<?> cosDictClass = Class.forName("org.apache.pdfbox.cos.COSDictionary");
                Object cosDict = cosDictClass.getDeclaredConstructor().newInstance();
                Constructor<?> ctor = stampClass.getDeclaredConstructor(cosDictClass);
                ctor.setAccessible(true);
                stampInstance = ctor.newInstance(cosDict);
            } catch (Throwable ignored) {
            }
        }

        if (stampInstance == null) {
            try {
                Constructor<?> ctor = stampClass.getDeclaredConstructor(String.class, String.class);
                ctor.setAccessible(true);
                stampInstance = ctor.newInstance("AP", "value");
            } catch (Throwable ignored) {
            }
        }

        if (stampInstance == null) {
            try {
                Class<?> fdfAnnotationClass = Class.forName("org.apache.pdfbox.pdmodel.fdf.FDFAnnotation");
                Class<?> fdfDictClass = Class.forName("org.apache.pdfbox.pdmodel.fdf.FDFDictionary");
                Object fdfDict = fdfDictClass.getDeclaredConstructor().newInstance();

                try {
                    Method getCOSDictionary = fdfDictClass.getMethod("getCOSDictionary");
                    Object cosDict = getCOSDictionary.invoke(fdfDict);
                    Class<?> cosNameClass = Class.forName("org.apache.pdfbox.cos.COSName");
                    Object subtype = cosNameClass.getField("SUBTYPE").get(null);
                    Object stampName = null;
                    try {
                        stampName = cosNameClass.getField("STAMP").get(null);
                    } catch (Throwable ignored) {
                        stampName = cosNameClass.getMethod("get", String.class).invoke(null, "Stamp");
                    }
                    cosDict.getClass().getMethod("setName", cosNameClass, cosNameClass)
                            .invoke(cosDict, subtype, stampName);
                } catch (Throwable ignored) {
                }

                Method create = fdfAnnotationClass.getMethod("createFDFAnnotation", fdfDictClass);
                Object annotation = create.invoke(null, fdfDict);
                if (stampClass.isInstance(annotation)) {
                    stampInstance = annotation;
                }
            } catch (Throwable ignored) {
            }
        }

        if (stampInstance == null) {
            for (Constructor<?> ctor : stampClass.getDeclaredConstructors()) {
                Class<?>[] params = ctor.getParameterTypes();
                Object[] args = new Object[params.length];
                boolean canCreateArgs = true;

                for (int i = 0; i < params.length; i++) {
                    Class<?> param = params[i];
                    try {
                        if (param == String.class) {
                            args[i] = "AP";
                        } else if (param == int.class) {
                            args[i] = 0;
                        } else if (param == long.class) {
                            args[i] = 0L;
                        } else if (param == boolean.class) {
                            args[i] = false;
                        } else if (param == double.class) {
                            args[i] = 0.0;
                        } else if (param == float.class) {
                            args[i] = 0.0f;
                        } else if (param == byte.class) {
                            args[i] = (byte) 0;
                        } else if (param == short.class) {
                            args[i] = (short) 0;
                        } else if (param == char.class) {
                            args[i] = (char) 0;
                        } else {
                            args[i] = param.getDeclaredConstructor().newInstance();
                        }
                    } catch (Throwable ignored) {
                        canCreateArgs = false;
                        break;
                    }
                }

                if (canCreateArgs) {
                    try {
                        ctor.setAccessible(true);
                        stampInstance = ctor.newInstance(args);
                        break;
                    } catch (Throwable ignored) {
                    }
                }
            }
        }

        if (stampInstance == null) {
            try {
                Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
                Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                Object unsafe = theUnsafe.get(null);
                Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
                stampInstance = allocateInstance.invoke(unsafe, stampClass);
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        }

        Class.forName(stampClass.getName(), true, stampClass.getClassLoader());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element appearanceXML = doc.createElement("AP");
        appearanceXML.setAttribute("KEY", "AP");

        Method method = stampClass.getDeclaredMethod("parseStampAnnotationAppearanceXML", Element.class);
        method.setAccessible(true);
        method.invoke(stampInstance, appearanceXML);
    }
}
