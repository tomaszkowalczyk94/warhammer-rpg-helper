package warhammerrpg.core.person;

public class Equipment {
    private String item;
    private String equipLoad;
    private String equipDescription;

    public Equipment(String item, String equipLoad, String equipDescription) {
        this.item = item;
        this.equipLoad = equipLoad;
        this.equipDescription = equipDescription;
    }

    public Equipment(String item, String equipLoad) {
        this.item = item;
        this.equipLoad = equipLoad;
        equipDescription = "";
    }



    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getEquipLoad() {
        return equipLoad;
    }

    public void setEquipLoad(String equipLoad) {
        this.equipLoad = equipLoad;
    }

    public String getEquipDescription() {
        return equipDescription;
    }

    public void setEquipDescription(String equipDescription) {
        this.equipDescription = equipDescription;
    }
}
