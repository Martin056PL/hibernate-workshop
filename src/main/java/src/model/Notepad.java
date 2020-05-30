package src.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "notepads")
public class Notepad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notepadId;
    private String title;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Backpack> backpack;

    public Notepad() {
    }

    public Notepad(String title){
        this.title = title;
    }

    public Long getNotepadId() {
        return notepadId;
    }

    public void setNotepadId(Long notepadId) {
        this.notepadId = notepadId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Backpack> getBackpack() {
        return backpack;
    }

    public void setBackpack(List<Backpack> backpack) {
        this.backpack = backpack;
    }
}
