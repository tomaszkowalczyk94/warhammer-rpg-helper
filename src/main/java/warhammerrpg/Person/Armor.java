package warhammerrpg.Person;

public class Armor {
    enum ArmorType {Szata, ZbrojaLekka, ZbrojaCieżka;}

    private ArmorType armorType;
    private Integer armorPoints;
    private Integer load;
    private String localization;

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public Integer getArmorPoints() {
        return armorPoints;
    }

    public void setArmorPoints(Integer armorPoints) {
        this.armorPoints = armorPoints;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

}
