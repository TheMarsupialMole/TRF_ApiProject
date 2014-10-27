package se.limhamn.ted.apps.trf_apiproject;

/**
 * Created by radde on 14-10-27.
 */
public class IngredientsBase {
    private String name;
    private String quantity;
    private String metricUnit;

    public IngredientsBase(String name, String quantity, String metricUnit) {
        this.name = name;
        this.quantity = quantity;
        this.metricUnit = metricUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMetricUnit() {
        return metricUnit;
    }

    public void setMetricUnit(String metricUnit) {
        this.metricUnit = metricUnit;
    }
}
