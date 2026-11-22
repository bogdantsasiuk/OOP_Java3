import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private Teacher teacher;
    private List<Student> enrolledStudents;

    public Course(String title, Teacher teacher) {
        this.title = title;
        this.teacher = teacher;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getTitle() { return title; }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    @Override
    public String toString() {
        return "Курс: " + title + " | Викладач: " + (teacher != null ? teacher.getName() : "Немає") +
                " | Студентів: " + enrolledStudents.size();
    }
}