package ru.parsertest.staxparser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;

public class StaxStreamProcessor implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    public StaxStreamProcessor(FileReader is) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(is);
    }

    public XMLStreamReader getReader() {
        return reader;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) {
                // empty
            }
        }
    }
}
