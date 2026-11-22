import java.io.*;
import java.util.List;

public class UniversityService {
    private UniversityStorage storage;
    private final String FILE_NAME = "university_data.ser";
    private NotificationCenter notificationCenter;

    public UniversityService(NotificationCenter notificationCenter) {
        this.notificationCenter = notificationCenter;
        loadData();
    }

    public void addStudent(Student student) {
        storage.students.add(student);
        saveData();
    }

    public void addTeacher(Teacher teacher) {
        storage.teachers.add(teacher);
        saveData();
    }

    public void addCourse(Course course) {
        storage.courses.add(course);
        saveData();
    }

     //інтеграція зі сповіщеннями
    public void enrollStudentInCourse(Student student, Course course) {
        course.enrollStudent(student);
        saveData();

        // Відправляємо сповіщення студенту про зарахування
        Notification notif = new SmsNotification(
                student.getPhone(),
                "УНІВЕРСИТЕТ",
                "Вас успішно зараховано на курс: " + course.getTitle()
        );
        notificationCenter.addNotification(notif);
    }

    public void gradeStudent(Student student, String courseTitle, int grade) {
        student.setGrade(courseTitle, grade);
        saveData();

        // Відправляємо сповіщення студенту про нову оцінку
        Notification notif = new PushNotification(
                student.getPhone(),
                "Електронний Журнал",
                "Нова оцінка!",
                "Ви отримали " + grade + " балів з курсу " + courseTitle
        );
        notificationCenter.addNotification(notif);
    }

    //Каталог з розбиттям на сторінки
    public void displayCoursesWithPagination(int pageNumber, int pageSize) {
        List<Course> courses = storage.courses;
        int totalCourses = courses.size();
        int startIndex = (pageNumber - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalCourses);

        System.out.println("=== Каталог курсів (Сторінка " + pageNumber + ") ===");
        if (startIndex >= totalCourses) {
            System.out.println("Ця сторінка порожня.");
            return;
        }

        for (int i = startIndex; i < endIndex; i++) {
            System.out.println((i + 1) + ". " + courses.get(i).toString());
        }
    }

    public List<Student> getStudents() { return storage.students; }
    public List<Course> getCourses() { return storage.courses; }

    //Збереження та Завантаження
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(storage);
        } catch (IOException e) {
            System.out.println("Помилка збереження даних: " + e.getMessage());
        }
    }

    private void loadData() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                storage = (UniversityStorage) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Помилка завантаження даних: " + e.getMessage());
                storage = new UniversityStorage();
            }
        } else {
            storage = new UniversityStorage();
        }
    }
}