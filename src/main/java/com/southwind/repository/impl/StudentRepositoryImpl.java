package com.southwind.repository.impl;

import com.southwind.entity.Student;
import org.springframework.stereotype.Repository;
import com.southwind.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//@Repository//交给ioc，注解不能给接口加，接口不能实例化，只能给实现类加。加了之后会自动扫，就有了repository实例了
@Repository
public class StudentRepositoryImpl implements StudentRepository {


    private static Map<Long,Student> studentMap;

    static {
        studentMap=new HashMap<>();
        studentMap.put(1L,new Student(1L,"张三",22));
        studentMap.put(2L,new Student(2L,"lisi",23));
        studentMap.put(3L,new Student(3L,"王五",24));

    }


    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {

        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);

    }
}
