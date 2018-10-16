package by.bntu.dmitry.entities;

import by.bntu.dmitry.enums.Role;
import java.util.Objects;

/**
 *
 * @author dmitry
 */
public class User extends AbstractEntity {

    private String login;
    private String password;
    private Role role;
    private boolean isActive;
    private boolean isAuthorizate;

    public User() {
    }

    public User(String login, String password, Role role, boolean isActive, boolean isAuthorizate) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
        this.isAuthorizate = isAuthorizate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRole(int i) {
        switch (i) {
            case 0:
                this.role = Role.USER;
                break;
            case 1:
                this.role = Role.DOCTOR;
                break;
            case 2:
                this.role = Role.ADMIN;
                break;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setActive(int i) {
        this.isActive = i != 0;
    }

    public boolean isAuthorizate() {
        return isAuthorizate;
    }

    public void setAuthorizate(boolean isAuthorizate) {
        this.isAuthorizate = isAuthorizate;
    }

    public void setAuthorizate(int i) {
        this.isAuthorizate = i != 0;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.getLogin());
        hash = 29 * hash + Objects.hashCode(this.getPassword());
        hash = 29 * hash + Objects.hashCode(this.getRole());
        hash = 29 * hash + (this.isActive() ? 1 : 0);
        hash = 29 * hash + (this.isAuthorizate() ? 1 : 0);
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
        final User other = (User) obj;
        if (this.isActive() != other.isActive()) {
            return false;
        }
        if (this.isAuthorizate() != other.isAuthorizate()) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.role, other.role);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + getId()
                + ", login=" + getLogin()
                + ", password=" + getPassword()
                + ", role=" + getRole()
                + ", isActive=" + isActive()
                + ", isAuthorizate=" + isAuthorizate() + '}';
    }

    public int getActive() {
        if (isActive) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getAuthorizate() {
        if (isAuthorizate) {
            return 1;
        } else {
            return 0;
        }
    }

}
