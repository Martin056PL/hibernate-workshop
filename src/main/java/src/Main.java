package src;

import src.model.Backpack;
import src.model.Student;

public class Main {

    public static void main(String[] args) {
     ObjectDAO<Backpack> backpackObjectDAO = new ObjectDAO<>();
     ObjectDAO<Student> studentObjectDAO = new ObjectDAO<>();

     Backpack backpack = new Backpack();
     backpack.setBrand("Nike");
     backpackObjectDAO.save(backpack);

     Student student = new Student("Marek", "Wacek", GroupId.NCI_112);
     student.setBackpack(backpack);
     studentObjectDAO.save(student);



    }


}
