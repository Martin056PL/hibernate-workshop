package src;

import src.dao.ObjectDAO;
import src.model.*;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ObjectDAO<Backpack> backpackObjectDAO = new ObjectDAO<>();
        ObjectDAO<Student> studentObjectDAO = new ObjectDAO<>();
        ObjectDAO<Notepad> notepadObjectDAO = new ObjectDAO<>();

        Backpack backpack = new Backpack();
        backpack.setBrand("Nike");
        backpackObjectDAO.save(backpack);

        Student student = new Student("Marek", "Wacek", GroupId.NCI_112);
        student.setBackpack(backpack);
        studentObjectDAO.save(student);

        Notepad notepad = new Notepad("notepad");
        notepad.setBackpack(Collections.singletonList(backpack));
        notepadObjectDAO.save(notepad);


    }


}
