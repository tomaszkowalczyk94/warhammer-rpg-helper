package warhammerrpg.core.database.entity;

public class Feature {
    private String featureName;
    private Integer initialVal;
    private Integer devScheme;
    private Integer curVal;

    public Feature(String featureName, Integer initialVal, Integer devScheme, Integer curVal) {
        this.featureName = featureName;
        this.initialVal = initialVal;
        this.devScheme = devScheme;
        this.curVal = curVal;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public Integer getInitialVal() {
        return initialVal;
    }

    public void setInitialVal(Integer initialVal) {
        this.initialVal = initialVal;
    }

    public Integer getDevScheme() {
        return devScheme;
    }

    public void setDevScheme(Integer devScheme) {
        this.devScheme = devScheme;
    }

    public Integer getCurVal() {
        return curVal;
    }

    public void setCurVal(Integer curVal) {
        this.curVal = curVal;
    }




}
