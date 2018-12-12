import java.util.ArrayList;
import java.util.Scanner;

public class Researcher
{
    String name;
    String email;
    ArrayList<Project> researcher_projects;
    //ArrayList<Publication> student_publications;

    public Researcher(String name, String email)
    {
        this.name = name;
        this.email = email;
        researcher_projects = new ArrayList<Project>();
        //student_publications =  = new ArrayList<Publication>();
    }

    public String getEmail() {
        return this.email;
    }

    public void display()
    {
        System.out.println(this.name + "\nResearcher");
        System.out.println(this.email);
    }




}
