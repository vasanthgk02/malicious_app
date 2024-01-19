package org.apache.pdfbox.pdmodel.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;

public class PDMemoryStream extends PDStream {
    public final byte[] data;

    public PDMemoryStream(byte[] bArr) {
        this.data = bArr;
    }

    public void addCompression() {
    }

    public InputStream createInputStream() throws IOException {
        return new ByteArrayInputStream(this.data);
    }

    public OutputStream createOutputStream() throws IOException {
        throw new UnsupportedOperationException("not supported for memory stream");
    }

    public byte[] getByteArray() throws IOException {
        return this.data;
    }

    public COSBase getCOSObject() {
        throw new UnsupportedOperationException("not supported for memory stream");
    }

    public List getDecodeParams() throws IOException {
        return null;
    }

    public PDFileSpecification getFile() {
        return null;
    }

    public List getFileDecodeParams() throws IOException {
        return null;
    }

    public List getFileFilters() {
        return null;
    }

    public List getFilters() {
        return null;
    }

    public int getLength() {
        return this.data.length;
    }

    public PDMetadata getMetadata() {
        return null;
    }

    public InputStream getPartiallyFilteredStream(List list) throws IOException {
        return createInputStream();
    }

    public COSStream getStream() {
        throw new UnsupportedOperationException("not supported for memory stream");
    }

    public void setDecodeParams(List list) {
    }

    public void setFile(PDFileSpecification pDFileSpecification) {
    }

    public void setFileDecodeParams(List list) {
    }

    public void setFileFilters(List list) {
    }

    public void setFilters(List list) {
        throw new UnsupportedOperationException("not supported for memory stream");
    }

    public void setMetadata(PDMetadata pDMetadata) {
    }
}
