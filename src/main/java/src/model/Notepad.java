package src.model;

import javax.persistence.*;

@Entity
@Table(name = "notepads")
public class Notepad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notepad_id")
    private Long id;
    private String title;

    public Notepad() {
    }

    public Notepad(String title){
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long notepadId) {
        this.id = notepadId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
