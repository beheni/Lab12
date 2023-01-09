package org.example.task2;

public class CashedDocument extends Document{
    private Document document;
    private DBConnection db;

    public CashedDocument(Document document) {
        this.gcsPath = document.getGcsPath();
        this.document = document;
        this.db = DBConnection.getInstance();
    }
    @Override
    public String parse() {
        String result = db.searchQuery(String.format("select * from document where path = '%s'", gcsPath));
//        System.out.println(gcsPath);
        if (result == null){
            String text = document.parse().replace("'", "");
            String query = String.format("insert into document (path, docText) values ('%s', '%s');", gcsPath, text);
            db.executeQuery(query);
            return text;
        }
        return result;
    }
}
