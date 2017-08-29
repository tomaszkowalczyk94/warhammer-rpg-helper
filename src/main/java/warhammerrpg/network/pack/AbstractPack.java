package warhammerrpg.network.pack;

import warhammerrpg.network.pack.Pack;

public abstract class AbstractPack implements Pack {

    private String username;
    private String token;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }
}
