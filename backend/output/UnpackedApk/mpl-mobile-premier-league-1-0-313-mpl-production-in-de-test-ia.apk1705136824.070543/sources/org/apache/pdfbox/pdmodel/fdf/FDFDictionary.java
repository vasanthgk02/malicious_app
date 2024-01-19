package org.apache.pdfbox.pdmodel.fdf;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.utility.f;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FDFDictionary implements COSObjectable {
    public COSDictionary fdf;

    public FDFDictionary() {
        this.fdf = new COSDictionary();
    }

    public List<FDFAnnotation> getAnnotations() throws IOException {
        COSArray cOSArray = (COSArray) this.fdf.getDictionaryObject(COSName.ANNOTS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(FDFAnnotation.create((COSDictionary) cOSArray.getObject(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public COSDictionary getCOSDictionary() {
        return this.fdf;
    }

    public COSBase getCOSObject() {
        return this.fdf;
    }

    public COSStream getDifferences() {
        return (COSStream) this.fdf.getDictionaryObject(COSName.DIFFERENCES);
    }

    public List<PDFileSpecification> getEmbeddedFDFs() throws IOException {
        COSArray cOSArray = (COSArray) this.fdf.getDictionaryObject(COSName.EMBEDDED_FDFS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(PDFileSpecification.createFS(cOSArray.get(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public String getEncoding() {
        String nameAsString = this.fdf.getNameAsString(COSName.ENCODING);
        return nameAsString == null ? "PDFDocEncoding" : nameAsString;
    }

    public List<FDFField> getFields() {
        COSArray cOSArray = (COSArray) this.fdf.getDictionaryObject(COSName.FIELDS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(new FDFField((COSDictionary) cOSArray.getObject(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public PDFileSpecification getFile() throws IOException {
        return PDFileSpecification.createFS(this.fdf.getDictionaryObject(COSName.F));
    }

    public COSArray getID() {
        return (COSArray) this.fdf.getDictionaryObject(COSName.ID);
    }

    public FDFJavaScript getJavaScript() {
        COSDictionary cOSDictionary = (COSDictionary) this.fdf.getDictionaryObject(COSName.JAVA_SCRIPT);
        if (cOSDictionary != null) {
            return new FDFJavaScript(cOSDictionary);
        }
        return null;
    }

    public List<FDFPage> getPages() {
        COSArray cOSArray = (COSArray) this.fdf.getDictionaryObject(COSName.PAGES);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(new FDFPage((COSDictionary) cOSArray.get(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public String getStatus() {
        return this.fdf.getString(COSName.STATUS);
    }

    public String getTarget() {
        return this.fdf.getString(COSName.TARGET);
    }

    public void setAnnotations(List<FDFAnnotationText> list) {
        this.fdf.setItem(COSName.ANNOTS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setDifferences(COSStream cOSStream) {
        this.fdf.setItem(COSName.DIFFERENCES, (COSBase) cOSStream);
    }

    public void setEmbeddedFDFs(List list) {
        this.fdf.setItem(COSName.EMBEDDED_FDFS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setEncoding(String str) {
        this.fdf.setName(COSName.ENCODING, str);
    }

    public void setFields(List<FDFField> list) {
        this.fdf.setItem(COSName.FIELDS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setFile(PDFileSpecification pDFileSpecification) {
        this.fdf.setItem(COSName.F, (COSObjectable) pDFileSpecification);
    }

    public void setID(COSArray cOSArray) {
        this.fdf.setItem(COSName.ID, (COSBase) cOSArray);
    }

    public void setJavaScript(FDFJavaScript fDFJavaScript) {
        this.fdf.setItem(COSName.JAVA_SCRIPT, (COSObjectable) fDFJavaScript);
    }

    public void setPages(List list) {
        this.fdf.setItem(COSName.PAGES, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setStatus(String str) {
        this.fdf.setString(COSName.STATUS, str);
    }

    public void setTarget(String str) {
        this.fdf.setString(COSName.TARGET, str);
    }

    public void writeXML(Writer writer) throws IOException {
        PDFileSpecification file = getFile();
        if (file != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("<f href=\"");
            outline73.append(file.getFile());
            outline73.append("\" />\n");
            writer.write(outline73.toString());
        }
        COSArray id = getID();
        if (id != null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("<ids original=\"");
            outline732.append(((COSString) id.getObject(0)).toHexString());
            outline732.append("\" ");
            writer.write(outline732.toString());
            writer.write("modified=\"" + ((COSString) id.getObject(1)).toHexString() + "\" />\n");
        }
        List<FDFField> fields = getFields();
        if (fields != null && fields.size() > 0) {
            writer.write("<fields>\n");
            for (FDFField writeXML : fields) {
                writeXML.writeXML(writer);
            }
            writer.write("</fields>\n");
        }
    }

    public FDFDictionary(COSDictionary cOSDictionary) {
        this.fdf = cOSDictionary;
    }

    public FDFDictionary(Element element) throws IOException {
        this();
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals(f.f1288a)) {
                    PDSimpleFileSpecification pDSimpleFileSpecification = new PDSimpleFileSpecification();
                    pDSimpleFileSpecification.setFile(element2.getAttribute("href"));
                    setFile(pDSimpleFileSpecification);
                } else if (element2.getTagName().equals("ids")) {
                    COSArray cOSArray = new COSArray();
                    String attribute = element2.getAttribute("original");
                    String attribute2 = element2.getAttribute("modified");
                    cOSArray.add((COSBase) COSString.parseHex(attribute));
                    cOSArray.add((COSBase) COSString.parseHex(attribute2));
                    setID(cOSArray);
                } else if (element2.getTagName().equals("fields")) {
                    NodeList childNodes2 = element2.getChildNodes();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                        Node item2 = childNodes2.item(i2);
                        if ((item2 instanceof Element) && ((Element) item2).getTagName().equals(HSLCriteriaBuilder.FIELD)) {
                            arrayList.add(new FDFField((Element) childNodes2.item(i2)));
                        }
                    }
                    setFields(arrayList);
                } else if (element2.getTagName().equals("annots")) {
                    NodeList childNodes3 = element2.getChildNodes();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < childNodes3.getLength(); i3++) {
                        Node item3 = childNodes3.item(i);
                        if (item3 instanceof Element) {
                            Element element3 = (Element) item3;
                            if (element3.getNodeName().equals("text")) {
                                arrayList2.add(new FDFAnnotationText(element3));
                            } else {
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error: Unknown annotation type '");
                                outline73.append(element3.getNodeName());
                                throw new IOException(outline73.toString());
                            }
                        }
                    }
                    setAnnotations(arrayList2);
                } else {
                    continue;
                }
            }
        }
    }
}
