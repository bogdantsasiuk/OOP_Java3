import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UniversityStorage implements Serializable {
    private static final long serialVersionUID = 1L;
    public List<Student> students = new ArrayList<>();
    public List<Teacher> teachers = new ArrayList<>();
    public List<Course> courses = new ArrayList<>();
}