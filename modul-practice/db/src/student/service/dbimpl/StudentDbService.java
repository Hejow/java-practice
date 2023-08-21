package student.service.dbimpl;

import student.model.Student;
import student.service.StudentService;

public class StudentDbService implements StudentService {
    @Override
    public String create(Student student) {
        return student.getRegistrationId();
    }

    @Override
    public Student read(String registrationId) {
        return new Student();
    }

    @Override
    public String delete(String registrationId) {
        return registrationId;
    }

    @Override
    public Student update(Student student) {
        return student;
    }
}
