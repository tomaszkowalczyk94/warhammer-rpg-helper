package warhammerrpg.core.person;

public class Skills {
    private String skillName;
    private Boolean purchased; // czy wykupione
    private Boolean plusTen; ///+10
    private Boolean plusTwenty;
    private String relatedSkills; ///skile pokrewne

    public Skills(){};

    public Skills(String skillName) {
        this.skillName = skillName;
        this.purchased = Boolean.TRUE;
        this.plusTen = Boolean.FALSE;
        this.plusTwenty = Boolean.FALSE;
        this.relatedSkills = "";
    }

    ///drugi konstruktor dokladniejszy
    public Skills(String skillName, Boolean purchased, Boolean plusTen, Boolean plusTwenty, String relatedSkills) {
        this.skillName = skillName;
        this.purchased = purchased;
        this.plusTen = plusTen;
        this.plusTwenty = plusTwenty;
        this.relatedSkills = relatedSkills;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }

    public Boolean getPlusTen() {
        return plusTen;
    }

    public void setPlusTen(Boolean plusTen) {
        this.plusTen = plusTen;
    }

    public Boolean getPlusTwenty() {
        return plusTwenty;
    }

    public void setPlusTwenty(Boolean plusTwenty) {
        this.plusTwenty = plusTwenty;
    }

    public String getRelatedSkills() {
        return relatedSkills;
    }

    public void setRelatedSkills(String relatedSkills) {
        this.relatedSkills = relatedSkills;
    }



}
