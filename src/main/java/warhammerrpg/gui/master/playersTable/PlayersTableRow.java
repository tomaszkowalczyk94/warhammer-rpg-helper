package warhammerrpg.gui.master.playersTable;

public class PlayersTableRow {

    private String name;
    private String token;

    public Object getCol(int i) {
        switch (i) {
            case 0: return getName();
            case 1: return getToken();
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

}
