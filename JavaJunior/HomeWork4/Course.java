import javax.persistence.*;

@Entity
@Table(name = "SchoolDB.Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private String duration;


    public Course(){

    }

    public Course(int id, String title, String duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", duration = '" + duration + '\'' +
                '}';
    }
}
