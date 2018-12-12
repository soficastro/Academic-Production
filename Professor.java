import java.util.ArrayList;
import java.util.Scanner;

public class Professor
{
    String name;
    String email;
    ArrayList<Project> professor_projects;

    //ArrayList<Publication> student_publications;

    public Professor(String name, String email)
    {
        this.name = name;
        this.email = email;
        professor_projects = new ArrayList<Project>();
        //student_publications =  = new ArrayList<Publication>();
    }

    public String getEmail()
    {
        return this.email;
    }

    public void display()
    {
        System.out.println(this.name + "\nProfesssor");
        System.out.println(this.email);
    }
}
