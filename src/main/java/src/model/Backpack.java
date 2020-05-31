package src.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "backpacks")
public class Backpack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String brand;

    @OneToMany
    @JoinColumn(name = "backpack_id")
    private Set<Notepad> notepads;

    public Backpack() {
    }

    public Backpack(String brand){
        this.brand = brand;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Set<Notepad> getNotepads() {
        return notepads;
    }

    public void setNotepads(Set<Notepad> notepads) {
        this.notepads = notepads;
    }
}
