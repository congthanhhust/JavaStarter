package collections;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Team {
    private ArrayList<Student> listStudents = new ArrayList<>();

    public void initTeam(){
        listStudents.add(new Student("Thao", 6));
        listStudents.add(new Student("Thanh", 3));
        listStudents.add(new Student("Hai", 2));
    }

    public void increaseScope(){
        listStudents.stream().filter(student -> student.getName().toLowerCase().contains("Thao"))
                .forEach(student -> student.setMathScope(student.getMathScope() + 3));
    }
}
