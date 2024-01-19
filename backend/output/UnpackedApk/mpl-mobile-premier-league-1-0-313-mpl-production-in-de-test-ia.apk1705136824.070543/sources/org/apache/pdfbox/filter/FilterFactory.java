package org.apache.pdfbox.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSName;

public final class FilterFactory {
    public static final FilterFactory INSTANCE = new FilterFactory();
    public final Map<COSName, Filter> filters = new HashMap();

    public FilterFactory() {
        FlateFilter flateFilter = new FlateFilter();
        DCTFilter dCTFilter = new DCTFilter();
        CCITTFaxFilter cCITTFaxFilter = new CCITTFaxFilter();
        LZWFilter lZWFilter = new LZWFilter();
        ASCIIHexFilter aSCIIHexFilter = new ASCIIHexFilter();
        ASCII85Filter aSCII85Filter = new ASCII85Filter();
        RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
        CryptFilter cryptFilter = new CryptFilter();
        this.filters.put(COSName.FLATE_DECODE, flateFilter);
        this.filters.put(COSName.FLATE_DECODE_ABBREVIATION, flateFilter);
        this.filters.put(COSName.DCT_DECODE, dCTFilter);
        this.filters.put(COSName.DCT_DECODE_ABBREVIATION, dCTFilter);
        this.filters.put(COSName.CCITTFAX_DECODE, cCITTFaxFilter);
        this.filters.put(COSName.CCITTFAX_DECODE_ABBREVIATION, cCITTFaxFilter);
        this.filters.put(COSName.LZW_DECODE, lZWFilter);
        this.filters.put(COSName.LZW_DECODE_ABBREVIATION, lZWFilter);
        this.filters.put(COSName.ASCII_HEX_DECODE, aSCIIHexFilter);
        this.filters.put(COSName.ASCII_HEX_DECODE_ABBREVIATION, aSCIIHexFilter);
        this.filters.put(COSName.ASCII85_DECODE, aSCII85Filter);
        this.filters.put(COSName.ASCII85_DECODE_ABBREVIATION, aSCII85Filter);
        this.filters.put(COSName.RUN_LENGTH_DECODE, runLengthDecodeFilter);
        this.filters.put(COSName.RUN_LENGTH_DECODE_ABBREVIATION, runLengthDecodeFilter);
        this.filters.put(COSName.CRYPT, cryptFilter);
    }

    public Collection<Filter> getAllFilters() {
        return this.filters.values();
    }

    public Filter getFilter(String str) throws IOException {
        return getFilter(COSName.getPDFName(str));
    }

    public Filter getFilter(COSName cOSName) throws IOException {
        Filter filter = this.filters.get(cOSName);
        if (filter != null) {
            return filter;
        }
        throw new IOException("Invalid filter: " + cOSName);
    }
}
