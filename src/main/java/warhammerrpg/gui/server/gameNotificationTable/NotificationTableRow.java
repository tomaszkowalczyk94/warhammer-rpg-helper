package warhammerrpg.gui.server.gameNotificationTable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotificationTableRow {



    protected String username;
    protected Date date;
    protected String message;

    public Object getCol(int i) {
        switch (i) {
            case 0: return getUsername();
            case 1:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                return simpleDateFormat.format(getDate());
            case 2: return getMessage();
            default: return null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
