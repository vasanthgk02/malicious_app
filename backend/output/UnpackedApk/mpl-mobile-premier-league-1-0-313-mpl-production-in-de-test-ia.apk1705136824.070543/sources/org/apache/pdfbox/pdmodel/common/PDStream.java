package org.apache.pdfbox.pdmodel.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.filter.FilterFactory;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;

public class PDStream implements COSObjectable {
    public COSStream stream;

    public PDStream() {
    }

    public static PDStream createFromCOS(COSBase cOSBase) throws IOException {
        if (cOSBase instanceof COSStream) {
            return new PDStream((COSStream) cOSBase);
        }
        if (cOSBase instanceof COSArray) {
            COSArray cOSArray = (COSArray) cOSBase;
            if (cOSArray.size() > 0) {
                return new PDStream((COSStream) new COSStreamArray(cOSArray));
            }
        } else if (cOSBase != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Contents are unknown type:");
            outline73.append(cOSBase.getClass().getName());
            throw new IOException(outline73.toString());
        }
        return null;
    }

    public void addCompression() {
        if (getFilters() == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(COSName.FLATE_DECODE);
            setFilters(arrayList);
        }
    }

    public InputStream createInputStream() throws IOException {
        return this.stream.getUnfilteredStream();
    }

    public OutputStream createOutputStream() throws IOException {
        return this.stream.createUnfilteredStream();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getByteArray() throws java.io.IOException {
        /*
            r5 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
            java.io.InputStream r2 = r5.createInputStream()     // Catch:{ all -> 0x0023 }
        L_0x000d:
            int r3 = r2.read(r1)     // Catch:{ all -> 0x0021 }
            r4 = -1
            if (r3 == r4) goto L_0x0019
            r4 = 0
            r0.write(r1, r4, r3)     // Catch:{ all -> 0x0021 }
            goto L_0x000d
        L_0x0019:
            r2.close()
            byte[] r0 = r0.toByteArray()
            return r0
        L_0x0021:
            r0 = move-exception
            goto L_0x0025
        L_0x0023:
            r0 = move-exception
            r2 = 0
        L_0x0025:
            if (r2 == 0) goto L_0x002a
            r2.close()
        L_0x002a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.common.PDStream.getByteArray():byte[]");
    }

    public COSBase getCOSObject() {
        return this.stream;
    }

    public List<Object> getDecodeParms() throws IOException {
        COSBase dictionaryObject = this.stream.getDictionaryObject(COSName.DECODE_PARMS);
        if (dictionaryObject == null) {
            dictionaryObject = this.stream.getDictionaryObject(COSName.DP);
        }
        if (dictionaryObject instanceof COSDictionary) {
            return new COSArrayList(COSDictionaryMap.convertBasicTypesToMap((COSDictionary) dictionaryObject), dictionaryObject, this.stream, COSName.DECODE_PARMS);
        }
        if (!(dictionaryObject instanceof COSArray)) {
            return null;
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(COSDictionaryMap.convertBasicTypesToMap((COSDictionary) cOSArray.getObject(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public int getDecodedStreamLength() {
        return this.stream.getInt(COSName.DL);
    }

    public PDFileSpecification getFile() throws IOException {
        return PDFileSpecification.createFS(this.stream.getDictionaryObject(COSName.F));
    }

    public List<Object> getFileDecodeParams() throws IOException {
        COSBase dictionaryObject = this.stream.getDictionaryObject(COSName.F_DECODE_PARMS);
        if (dictionaryObject instanceof COSDictionary) {
            return new COSArrayList(COSDictionaryMap.convertBasicTypesToMap((COSDictionary) dictionaryObject), dictionaryObject, this.stream, COSName.F_DECODE_PARMS);
        }
        if (!(dictionaryObject instanceof COSArray)) {
            return null;
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(COSDictionaryMap.convertBasicTypesToMap((COSDictionary) cOSArray.getObject(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public List<String> getFileFilters() {
        COSBase dictionaryObject = this.stream.getDictionaryObject(COSName.F_FILTER);
        if (dictionaryObject instanceof COSName) {
            COSName cOSName = (COSName) dictionaryObject;
            return new COSArrayList(cOSName.getName(), cOSName, this.stream, COSName.F_FILTER);
        } else if (dictionaryObject instanceof COSArray) {
            return COSArrayList.convertCOSNameCOSArrayToList((COSArray) dictionaryObject);
        } else {
            return null;
        }
    }

    public List<COSName> getFilters() {
        COSBase filters = this.stream.getFilters();
        if (filters instanceof COSName) {
            COSName cOSName = (COSName) filters;
            return new COSArrayList(cOSName, cOSName, this.stream, COSName.FILTER);
        } else if (filters instanceof COSArray) {
            return ((COSArray) filters).toList();
        } else {
            return null;
        }
    }

    public String getInputStreamAsString() throws IOException {
        return new String(getByteArray(), "ISO-8859-1");
    }

    public int getLength() {
        return this.stream.getInt(COSName.LENGTH, 0);
    }

    public PDMetadata getMetadata() {
        COSBase dictionaryObject = this.stream.getDictionaryObject(COSName.METADATA);
        if (dictionaryObject != null) {
            if (dictionaryObject instanceof COSStream) {
                return new PDMetadata((COSStream) dictionaryObject);
            }
            if (!(dictionaryObject instanceof COSNull)) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a COSStream but was a ");
                outline73.append(dictionaryObject.getClass().getSimpleName());
                throw new IllegalStateException(outline73.toString());
            }
        }
        return null;
    }

    public InputStream getPartiallyFilteredStream(List<String> list) throws IOException {
        InputStream filteredStream = this.stream.getFilteredStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        List<COSName> filters = getFilters();
        boolean z = false;
        for (int i = 0; i < filters.size() && !z; i++) {
            COSName cOSName = filters.get(i);
            if (list.contains(cOSName.getName())) {
                z = true;
            } else {
                FilterFactory.INSTANCE.getFilter(cOSName).decode(filteredStream, byteArrayOutputStream, this.stream, i);
                IOUtils.closeQuietly(filteredStream);
                filteredStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.reset();
            }
        }
        return filteredStream;
    }

    public COSStream getStream() {
        return this.stream;
    }

    public void setDecodeParms(List<?> list) {
        this.stream.setItem(COSName.DECODE_PARMS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setDecodedStreamLength(int i) {
        this.stream.setInt(COSName.DL, i);
    }

    public void setFile(PDFileSpecification pDFileSpecification) {
        this.stream.setItem(COSName.F, (COSObjectable) pDFileSpecification);
    }

    public void setFileDecodeParams(List<?> list) {
        this.stream.setItem((String) "FDecodeParams", (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setFileFilters(List<String> list) {
        this.stream.setItem(COSName.F_FILTER, (COSBase) COSArrayList.convertStringListToCOSNameCOSArray(list));
    }

    public void setFilters(List<COSName> list) {
        this.stream.setItem(COSName.FILTER, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setMetadata(PDMetadata pDMetadata) {
        this.stream.setItem(COSName.METADATA, (COSObjectable) pDMetadata);
    }

    public PDStream(PDDocument pDDocument) {
        this.stream = pDDocument.getDocument().createCOSStream();
    }

    public PDStream(COSStream cOSStream) {
        this.stream = cOSStream;
    }

    public PDStream(PDDocument pDDocument, InputStream inputStream) throws IOException {
        this(pDDocument, inputStream, false);
    }

    public PDStream(PDDocument pDDocument, InputStream inputStream, boolean z) throws IOException {
        OutputStream outputStream;
        OutputStream outputStream2 = null;
        try {
            COSStream createCOSStream = pDDocument.getDocument().createCOSStream();
            this.stream = createCOSStream;
            if (z) {
                outputStream = createCOSStream.createFilteredStream();
            } else {
                outputStream = createCOSStream.createUnfilteredStream();
            }
            OutputStream outputStream3 = outputStream;
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream3.write(bArr, 0, read);
            }
            if (outputStream3 != null) {
                outputStream3.close();
            }
            inputStream.close();
        } catch (Throwable th) {
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
