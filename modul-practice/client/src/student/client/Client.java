package student.client;

import student.model.Student;
import student.service.StudentService;
import student.service.dbimpl.StudentDbService;

public class Client {
    public static void main(String[] args) {
        StudentService service = new StudentDbService();
        service.create(new Student());
        service.read("17SS0001");
        service.update(new Student());
        service.delete("17SS0001");
    }
}
