package src;

import src.dao.ObjectDAO;
import src.model.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ObjectDAO<Backpack> backpackDao = new ObjectDAO<>();
        ObjectDAO<Student> studentDao = new ObjectDAO<>();
        ObjectDAO<Notepad> notePadDao = new ObjectDAO<>();
        ObjectDAO<Professor> professorObjectDAO = new ObjectDAO<>();

   //      NOTEPAD CREATE
        Notepad notePadMath = new Notepad();
        notePadMath.setTitle("Math");
        notePadDao.save(notePadMath);

        Notepad notePadPhysics = new Notepad();
        notePadPhysics.setTitle("Physics");
        notePadDao.save(notePadPhysics);

        // BACKPACK CREATE
        Backpack backpackNike = new Backpack();
        backpackNike.setBrand("Nike");
        backpackNike.setNotepads(Stream.of(notePadMath, notePadPhysics).collect(Collectors.toSet()));
        backpackDao.save(backpackNike);

        Backpack backpackPuma = new Backpack();
        backpackPuma.setBrand("Puma");
        backpackDao.save(backpackPuma);

        // STUDENT CREATE
        Student studentPrzemek = new Student("Przemek", "Bykowski", GroupId.NCI_112);
        studentPrzemek.setBackpack(backpackNike);

        Student studentAnna = new Student("Anna", "Nowak", GroupId.NCI_135);
        studentAnna.setBackpack(backpackPuma);

        //PROFESSORS CREATE
        Professor professorWazny = new Professor("Wazny", "Wazniejszy");
        professorWazny.setStudentSet(Stream.of(studentPrzemek, studentAnna).collect(Collectors.toSet()));


        studentPrzemek.setProfessor(Stream.of(professorWazny).collect(Collectors.toSet()));
        studentDao.save(studentPrzemek);

        studentAnna.setProfessor(Stream.of(professorWazny).collect(Collectors.toSet()));
        studentDao.save(studentAnna);

        professorObjectDAO.save(professorWazny);
    }


}
