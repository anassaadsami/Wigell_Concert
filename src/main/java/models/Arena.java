package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "arena")
public class Arena {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "arena_id")
    private int arenaId;
    @Basic
    @Column(name = "arena_name")
    private String arenaName;
    @Basic
    @Column(name = "address_id")
    private int addressId;
    @Basic
    @Column(name = "indoors")
    private boolean indoors;

    public int getArenaId() {
        return arenaId;
    }

    public void setArenaId(int arenaId) {
        this.arenaId = arenaId;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public boolean getIndoors() {
        return indoors;
    }

    public void setIndoors(boolean indoors) {
        this.indoors = indoors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arena arena = (Arena) o;
        return arenaId == arena.arenaId && addressId == arena.addressId && indoors == arena.indoors && Objects.equals(arenaName, arena.arenaName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arenaId, arenaName, addressId, indoors);
    }

    @Override
    public String toString() {
        return "Arena{" +
                "arenaId=" + arenaId +
                ", arenaName='" + arenaName + '\'' +
                ", addressId=" + addressId +
                ", indoors=" + indoors +
                '}';
    }
}
