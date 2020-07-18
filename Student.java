package collections;

import javax.print.DocFlavor;

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
}
