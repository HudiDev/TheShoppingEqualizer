package hudiilfeld.theshoppingequalizer.sources;

/**
 * Created by ibm on 31/07/2017.
 */

public class SubCategoryNameAndInfo {
    private String title;
    private int id;
    private String[] url;

    public SubCategoryNameAndInfo(String title, int id, String... url) {
        this.title = title;
        this.id = id;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }
    public int getId(){
        return id;
    }
    public String[] getUrl() {
        return url;
    }
}
