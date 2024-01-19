package org.apache.pdfbox.pdmodel.fdf;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public final class XMLUtil {
    public static String getNodeValue(Element element) {
        StringBuilder sb = new StringBuilder();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item instanceof Text) {
                sb.append(item.getNodeValue());
            }
        }
        return sb.toString();
    }

    public static Document parse(InputStream inputStream) throws IOException {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        } catch (FactoryConfigurationError e2) {
            throw new IOException(e2.getMessage(), e2);
        } catch (ParserConfigurationException e3) {
            throw new IOException(e3.getMessage(), e3);
        } catch (SAXException e4) {
            throw new IOException(e4.getMessage(), e4);
        }
    }
}
