import org.billy.service.StudentService;

public class App {
    public static void main(String[] args) throws Exception {
        StudentService studentService = new StudentService();
        studentService.queryAll();
        studentService.add();
        studentService.delete();
        studentService.update();
        studentService.query();
    }
}
