package model;
public class Artgs {
    private int id_article;
    private String headline;
    private String news_url;
    private String source;

    public Artgs(int id_article, String headline, String news_url, String source){
        this.id_article = id_article;
        this.headline = headline;
        this.news_url = news_url;
        this.source = source;
    }

    public String toString() {
        return "\nid_article: " + this.id_article +
                "\nheadline: " + this.headline +
                "\nnews_url: " + this.news_url +
                "\nsource: " + this.source;
    }

//    GETTERS
    public int getId_article() {
        return this.id_article;
    }

    public String getHeadline() {
        return this.headline;
    }

    public String getNews_url() {
        return this.news_url;
    }

    public String getSource() {
        return this.source;
    }
}
