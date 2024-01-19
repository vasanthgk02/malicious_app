package org.apache.pdfbox.pdmodel.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Vector;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.ICOSVisitor;

public class COSStreamArray extends COSStream {
    public COSStream firstStream;
    public COSArray streams;

    public COSStreamArray(COSArray cOSArray) {
        super(new COSDictionary());
        this.streams = cOSArray;
        if (cOSArray.size() > 0) {
            this.firstStream = (COSStream) cOSArray.getObject(0);
        }
    }

    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return this.streams.accept(iCOSVisitor);
    }

    public void appendStream(COSStream cOSStream) {
        this.streams.add((COSBase) cOSStream);
    }

    public OutputStream createFilteredStream() throws IOException {
        return this.firstStream.createFilteredStream();
    }

    public OutputStream createUnfilteredStream() throws IOException {
        return this.firstStream.createUnfilteredStream();
    }

    public COSBase get(int i) {
        return this.streams.get(i);
    }

    public COSDictionary getDictionary() {
        return this.firstStream;
    }

    public COSBase getDictionaryObject(COSName cOSName) {
        return this.firstStream.getDictionaryObject(cOSName);
    }

    public InputStream getFilteredStream() throws IOException {
        throw new IOException("Error: Not allowed to get filtered stream from array of streams.");
    }

    public COSBase getFilters() {
        return this.firstStream.getFilters();
    }

    public COSBase getItem(COSName cOSName) {
        return this.firstStream.getItem(cOSName);
    }

    public int getStreamCount() {
        return this.streams.size();
    }

    public InputStream getUnfilteredStream() throws IOException {
        Vector vector = new Vector();
        byte[] bytes = "\n".getBytes("ISO-8859-1");
        for (int i = 0; i < this.streams.size(); i++) {
            vector.add(((COSStream) this.streams.getObject(i)).getUnfilteredStream());
            vector.add(new ByteArrayInputStream(bytes));
        }
        return new SequenceInputStream(vector.elements());
    }

    public void insertCOSStream(PDStream pDStream) {
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSObjectable) pDStream);
        cOSArray.addAll(this.streams);
        this.streams.clear();
        this.streams = cOSArray;
    }

    public void setFilters(COSBase cOSBase) throws IOException {
        this.firstStream.setFilters(cOSBase);
    }

    public String toString() {
        return "COSStream{}";
    }

    public OutputStream createFilteredStream(COSBase cOSBase) throws IOException {
        return this.firstStream.createFilteredStream(cOSBase);
    }
}
