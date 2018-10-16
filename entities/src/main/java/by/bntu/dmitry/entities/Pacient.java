package by.bntu.dmitry.entities;

import java.util.Objects;

/**
 *
 * @author dmitry
 */
public class Pacient extends AbstractEntity{
    
    private User pacient;
    private User doctor;
    private int directionHistology;

    public Pacient() {
    }

    public Pacient(User pacient, User doctor, int directionHistology) {
        this.pacient = pacient;
        this.doctor = doctor;
        this.directionHistology = directionHistology;
    }

    public User getPacient() {
        return pacient;
    }

    public void setPacient(User pacient) {
        this.pacient = pacient;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public int getDirectionHistology() {
        return directionHistology;
    }

    public void setDirectionHistology(int directionHistology) {
        this.directionHistology = directionHistology;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.pacient);
        hash = 67 * hash + Objects.hashCode(this.doctor);
        hash = 67 * hash + this.directionHistology;
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
        final Pacient other = (Pacient) obj;
        if (this.directionHistology != other.directionHistology) {
            return false;
        }
        if (!Objects.equals(this.pacient, other.pacient)) {
            return false;
        }
        if (!Objects.equals(this.doctor, other.doctor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pacient{" + "pacient=" + pacient + ", doctor=" + doctor + ", directionHistology=" + directionHistology + '}';
    }
    
    
    
}
