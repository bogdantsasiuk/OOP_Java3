import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private static final long serialVersionUID = 1L;
    private String faculty; // Наприклад: "ФІТ", "Кібернетика", "Економіка"
    private Map<String, Integer> gradebook; // Залікова книжка: Назва курсу -> Оцінка

    public Student(String id, String name, String phone, String faculty) {
        super(id, name, phone);
        this.faculty = faculty;
        this.gradebook = new HashMap<>();
    }

    public void setGrade(String courseName, int grade) {
        gradebook.put(courseName, grade);
    }

    @Override
    public String getRole() { return "Студент"; }

    @Override
    public String toString() {
        return "Студент: " + name + " (Факультет: " + faculty + ") | Заліковка: " + gradebook;
    }
}