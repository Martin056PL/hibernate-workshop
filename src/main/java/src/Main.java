package src;

import src.dao.ObjectDAO;
import src.model.*;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
     ObjectDAO<Backpack> backpackObjectDAO = new ObjectDAO<>();
     ObjectDAO<Student> studentObjectDAO = new ObjectDAO<>();
     ObjectDAO<Book> bookObjectDAO = new ObjectDAO<>();
     ObjectDAO<Publisher> publisherObjectDAO = new ObjectDAO<>();


     Backpack backpack = new Backpack();
     backpack.setBrand("Nike");
     backpackObjectDAO.save(backpack);

     Student student = new Student("Marek", "Wacek", GroupId.NCI_112);
     student.setBackpack(backpack);
     studentObjectDAO.save(student);


     Publisher publisher = new Publisher("ZL");
     Book book = new Book("Random title");
     book.setPublisher(publisher);
     publisherObjectDAO.save(publisher);
     publisher.setBook(Collections.singletonList(book));
     bookObjectDAO.save(book);







    }


}
