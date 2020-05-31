package src.model.mymodels;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import src.sequencegenerator.PublisherCodePrefixedSequenceIdGenerator;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @GenericGenerator(name = "book_seq",
            strategy = "src.sequencegenerator.PublisherCodePrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = PublisherCodePrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PublisherCodePrefixedSequenceIdGenerator.CODE_NUMBER_SEPARATOR_PARAMETER, value = "_"),
                    @Parameter(name = PublisherCodePrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id;
    private String title;

    @ManyToOne
    private Publisher publisher;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
