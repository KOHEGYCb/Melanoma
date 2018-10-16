package by.bntu.dmitry.entities;

import by.bntu.dmitry.enums.Sex;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author dmitry
 */
public class UserForm extends AbstractEntity{
    
    private User user;
    private String name;
    private String surname;
    private String patronymic;
    private Date birthday;
    private Sex sex;
    private int relativeMelanoma;
    private int anamnesisMelanoma;
    private int dyspasticNevusSyndrome;
    private int dyspasticNevusSyndromeRelatives;
    private int immunosuppressiveTherapy;
    private int presenceUlceration;
    private String hospital;

    public UserForm() {
    }

    public UserForm(User user, String name, String surname, String patronymic, Date birthday, Sex sex, int relativeMelanoma, int anamnesisMelanoma, int dyspasticNevusSyndrome, int dyspasticNevusSyndromeRelatives, int immunosuppressiveTherapy, int presenceUlceration, String hospital) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.sex = sex;
        this.relativeMelanoma = relativeMelanoma;
        this.anamnesisMelanoma = anamnesisMelanoma;
        this.dyspasticNevusSyndrome = dyspasticNevusSyndrome;
        this.dyspasticNevusSyndromeRelatives = dyspasticNevusSyndromeRelatives;
        this.immunosuppressiveTherapy = immunosuppressiveTherapy;
        this.presenceUlceration = presenceUlceration;
        this.hospital = hospital;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    public void setSex(int sex) {
        if (sex == 1){
            this.sex = Sex.MALE;
        }else{
        this.sex = Sex.SHEMALE;
        }
    }

    public int getRelativeMelanoma() {
        return relativeMelanoma;
    }

    public void setRelativeMelanoma(int relativeMelanoma) {
        this.relativeMelanoma = relativeMelanoma;
    }

    public int getAnamnesisMelanoma() {
        return anamnesisMelanoma;
    }

    public void setAnamnesisMelanoma(int anamnesisMelanoma) {
        this.anamnesisMelanoma = anamnesisMelanoma;
    }

    public int getDyspasticNevusSyndrome() {
        return dyspasticNevusSyndrome;
    }

    public void setDyspasticNevusSyndrome(int dyspasticNevusSyndrome) {
        this.dyspasticNevusSyndrome = dyspasticNevusSyndrome;
    }

    public int getDyspasticNevusSyndromeRelatives() {
        return dyspasticNevusSyndromeRelatives;
    }

    public void setDyspasticNevusSyndromeRelatives(int dyspasticNevusSyndromeRelatives) {
        this.dyspasticNevusSyndromeRelatives = dyspasticNevusSyndromeRelatives;
    }

    public int getImmunosuppressiveTherapy() {
        return immunosuppressiveTherapy;
    }

    public void setImmunosuppressiveTherapy(int immunosuppressiveTherapy) {
        this.immunosuppressiveTherapy = immunosuppressiveTherapy;
    }

    public int getPresenceUlceration() {
        return presenceUlceration;
    }

    public void setPresenceUlceration(int presenceUlceration) {
        this.presenceUlceration = presenceUlceration;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.user);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.surname);
        hash = 97 * hash + Objects.hashCode(this.patronymic);
        hash = 97 * hash + Objects.hashCode(this.birthday);
        hash = 97 * hash + Objects.hashCode(this.sex);
        hash = 97 * hash + this.relativeMelanoma;
        hash = 97 * hash + this.anamnesisMelanoma;
        hash = 97 * hash + this.dyspasticNevusSyndrome;
        hash = 97 * hash + this.dyspasticNevusSyndromeRelatives;
        hash = 97 * hash + this.immunosuppressiveTherapy;
        hash = 97 * hash + this.presenceUlceration;
        hash = 97 * hash + Objects.hashCode(this.hospital);
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
        final UserForm other = (UserForm) obj;
        if (this.relativeMelanoma != other.relativeMelanoma) {
            return false;
        }
        if (this.anamnesisMelanoma != other.anamnesisMelanoma) {
            return false;
        }
        if (this.dyspasticNevusSyndrome != other.dyspasticNevusSyndrome) {
            return false;
        }
        if (this.dyspasticNevusSyndromeRelatives != other.dyspasticNevusSyndromeRelatives) {
            return false;
        }
        if (this.immunosuppressiveTherapy != other.immunosuppressiveTherapy) {
            return false;
        }
        if (this.presenceUlceration != other.presenceUlceration) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.patronymic, other.patronymic)) {
            return false;
        }
        if (!Objects.equals(this.hospital, other.hospital)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        if (this.sex != other.sex) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserForm{" + "user=" + user + ", name=" + name + ", surname=" + surname + ", patronymic=" + patronymic + ", birthday=" + birthday + ", sex=" + sex + ", relativeMelanoma=" + relativeMelanoma + ", anamnesisMelanoma=" + anamnesisMelanoma + ", dyspasticNevusSyndrome=" + dyspasticNevusSyndrome + ", dyspasticNevusSyndromeRelatives=" + dyspasticNevusSyndromeRelatives + ", immunosuppressiveTherapy=" + immunosuppressiveTherapy + ", presenceUlceration=" + presenceUlceration + ", hospital=" + hospital + '}';
    }
    
    
}
