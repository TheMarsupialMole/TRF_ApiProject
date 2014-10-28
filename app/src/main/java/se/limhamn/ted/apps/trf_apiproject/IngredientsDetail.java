package se.limhamn.ted.apps.trf_apiproject;

/**
 * Created by Ted on 2014-10-28.
 */
public class IngredientsDetail {
    private String name;
    private String id = "";


    public IngredientsDetail(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
