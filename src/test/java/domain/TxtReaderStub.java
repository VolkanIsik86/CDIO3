package domain;

import services.TxtReader;
import services.TxtReaderTest;

public class TxtReaderStub extends TxtReader {
    public TxtReaderStub(String path, String fileName) {
        super(path, fileName);
    }
}
