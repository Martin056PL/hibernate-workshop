package src.model;

import org.hibernate.annotations.GenericGenerator;
import src.sequencegenerator.StringPrefixedSequenceIdGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE/*, generator = "ID_Generator"*/)
//    @GenericGenerator(name = "ID_Generator", strategy = "src.sequencegenerator.StringPrefixedSequenceIdGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Student_"),
//                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d")
//            })
    private Long id;
    private String name;
    private String surname;

    @Column(name = "group_id")
    @Enumerated(EnumType.STRING)
    private GroupId groupId;

    @OneToOne
    private Backpack backpack;

    @ManyToMany(mappedBy = "studentSet")
    private Set<Professor> professor;



    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Student(String name, String surname, GroupId groupId) {
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupId groupId) {
        this.groupId = groupId;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }


    public Set<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(Set<Professor> professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
