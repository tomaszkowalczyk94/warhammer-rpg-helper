package warhammerrpg.network.server;

import com.esotericsoftware.kryonet.Connection;

public class ServerUserContainer {

    protected String username;
    protected String token;
    protected Connection connection;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
