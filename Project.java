import java.util.ArrayList;
import java.util.Scanner;

public class Project
{
    String title;
    int startDay, startMonth, startYear;
    int endDay, endMonth, endYear;
    String agency;
    int value;
    String goal;
    String description;
    boolean basicInfoSet;
    //Participants
    ArrayList<Professor> projects_professors;
    ArrayList<Student> projects_students;
    ArrayList<Researcher> projects_researchers;
    Professor x;
    //Status -> 1 = Implementing, 2 = In process, 3 = Concluded
    int status;

    public Project (int status, String title, Professor head)
    {
        this.status = status;
        this.title = title;
        this.basicInfoSet = false;
        this.projects_professors.add(head); //?????????
    }

    public String getTitle()
    {
        return this.title;
    }


    public start(Project project, ArrayList<Student> students, ArrayList<Professor> professors,
    ArrayList<Researcher> researchers)
    {
        Scanner input = new Scanner(System.in);

        //Set basic info
        System.out.println("Start date (dd \\n mm \\n yyyy):");
        project.startDay = input.nextInt();
        project.startMonth = input.nextInt();
        project.startYear = input.nextInt();
        System.out.println("Funding agency:");
        project.agency = input.nextLine()
        System.out.println("Funded value:");
        project.value = input.nextInt();
        System.out.println("Goals:");
        project.goal = input.nextLine();
        System.out.println("Describe this project:");
        project.description = input.nextLine();
        project.basicInfoSet = true;

        System.out.println("This project is currently not in process. Do you want to change its status to" +
                " 'in process'? (1) Yes or (2) no");
        if(input.nextInt() == 1)
        {
            project.status = 2;
        }

        boolean process = true, found = false;
        String my_email;

        while(process)
        {
            System.out.println("We're almost done... Do you want to add participants? (1) Yes or (2) no");
            if(input.nextInt() == 1)
            {
                System.out.println("Enter email");
                for (Student i : students) {
                    my_email = i.getEmail();
                    if (email.equals(my_email)) {
                        project.projects_students.add(i);
                        i.student_projects.add(project);

                        found = true;
                    }
                }
                if (!found) {
                    for (Professor i : professors) {
                        my_email = i.getEmail();
                        if (email.equals(my_email)) {
                            project.projects_professors.add(i);
                            i.professor_projects.add(project);
                            found = true;
                        }
                    }
                }
                if (!found) {
                    for (Researcher i : researchers) {
                        my_email = i.getEmail();
                        if (email.equals(my_email)) {
                            project.projects_researchers.add(i);
                            i.researcher_projects.add(project);
                            found = true;
                        }
                    }
                }
                if (found) {
                    System.out.println("Found!");
                } else {
                    System.out.println("Not found...");
                }

            }
            else process = false;
        }

    }

// i.edit() so faz umas coisas se basic info. mts condicoes D:

}
