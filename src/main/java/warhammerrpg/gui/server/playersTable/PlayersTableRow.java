package warhammerrpg.gui.server.playersTable;

public class PlayersTableRow {

    private String name;
    private String token;
    private String removeButton;


    public Object getCol(int i) {
        switch (i) {
            case 0: return getName();
            case 1: return getToken();
            case 2: return getRemoveButton();
            default: return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRemoveButton() {
        return "usun";
    }
}
