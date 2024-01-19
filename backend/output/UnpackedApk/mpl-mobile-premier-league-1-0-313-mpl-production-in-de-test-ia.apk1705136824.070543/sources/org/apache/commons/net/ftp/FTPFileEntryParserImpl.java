package org.apache.commons.net.ftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public abstract class FTPFileEntryParserImpl implements FTPFileEntryParser {
    public List<String> preParse(List<String> list) {
        return list;
    }

    public String readNextEntry(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
    }
}
