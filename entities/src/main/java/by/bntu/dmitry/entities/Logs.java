package by.bntu.dmitry.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author dmitry
 */
public class Logs extends AbstractEntity{

    private Date date;
    private User user;
    private String action;

    public Logs() {
    }

    public Logs(Date date, User user, String action) {
        this.date = date;
        this.user = user;
        this.action = action;
    }

    @Override
    public String toString() {
        return "Logs{" + "date=" + date + ", user=" + user + ", action=" + action + '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + Objects.hashCode(this.user);
        hash = 53 * hash + Objects.hashCode(this.action);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Logs other = (Logs) obj;
        if (!Objects.equals(this.action, other.action)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }
    
    
    
}
