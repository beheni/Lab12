package org.example;

public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument("gs://oop-course/Geico-2021.png");
//        document = TimedDocument(document);
//        document = CashedDocument(document);
        System.out.println(document.parse());


    }
}
