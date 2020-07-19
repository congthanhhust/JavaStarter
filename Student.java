package collections;

public class Student {
    private String name;
    private int id;
    private int mathScope;

    public Student(String name, int mathScope){
        this.name = name;
        this.mathScope = mathScope;
    }

    public String getName(){
        return name;
    }

    public int getMathScope(){
        return mathScope;
    }

    public void setMathScope(int mathScope){
        this.mathScope = mathScope;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", mathScope=" + mathScope +
                '}';
    }
}
