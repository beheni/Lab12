package org.example.task2;

public class TimedDocument extends Document{
    private Document document;

    public TimedDocument(Document document) {
        this.document = document;
        this.gcsPath = document.gcsPath;
    }

    @Override
    public String parse() {
        long startTime = System.currentTimeMillis();
        String text = document.parse();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return text;
    }
}
