package warhammerrpg.gui.network.SelectPersonTableModel;

public class SelectPersonRow {

    private Integer id;
    private String name;
    private String proffesion;
    private String breed;

    public Object getCol(int i) {
        switch (i) {
            case 0: return getId();
            case 1: return getName();
            case 2: return getProffesion();
            case 3: return getBreed();
            default: return null;
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProffesion() {
        return proffesion;
    }

    public void setProffesion(String proffesion) {
        this.proffesion = proffesion;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
