package se.limhamn.ted.apps.trf_apiproject;

/**
 * Created by Ted on 2014-10-24.
 */
public class RecipeBase {

    private String title = "";
    private String category = "";
    private String id = "";

    public RecipeBase(String title, String category, String id){
        this.title = title;
        this.category = category;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
