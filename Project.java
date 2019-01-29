import java.util.ArrayList;
import java.util.InputMismatchException;
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
    ArrayList<Publication> projects_publications;
    //Participants
    ArrayList<Professor> projects_professors;
    ArrayList<Student> projects_students;
    ArrayList<Researcher> projects_researchers;
    //Status -> 1 = Under construction, 2 = In process, 3 = Concluded
    int status;

    public Project (int status, String title)
    {
        this.status = status;
        this.title = title;
        this.basicInfoSet = false;
        this.projects_professors = new ArrayList<Professor>();
        this.projects_students = new ArrayList<Student>();
        this.projects_researchers = new ArrayList<Researcher>();
    }

    public String getTitle()
    {
        return this.title;
    }


    public void start(Project project, ArrayList<Student> students, ArrayList<Professor> professors,
                 ArrayList<Researcher> researchers)
    {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input4 = new Scanner(System.in);
        Scanner input5 = new Scanner(System.in);

        //Set basic info
        System.out.println("Start date (dd \\n mm \\n yyyy):");
        project.startDay = input.nextInt();
        project.startMonth = input.nextInt();
        project.startYear = input.nextInt();
        System.out.println("Funding agency:");
        project.agency = input2.nextLine();
        System.out.println("Funded value:");
        project.value = input3.nextInt();
        System.out.println("Goals:");
        project.goal = input4.nextLine();
        System.out.println("Describe this project:");
        project.description = input5.nextLine();
        project.basicInfoSet = true;

        System.out.println("This project is currently not in process. Do you want to change its status to" +
                " 'in process'? (1) Yes or (2) no");
        if(input.nextInt() == 1)
        {
            project.status = 2;
        }

        boolean process = true, found = false;
        String my_email, email;

        while(process)
        {
            System.out.println("We're almost done... Do you want to add participants? (1) Yes or (2) no");
            if(input.nextInt() == 1)
            {
                System.out.println("Enter email");
                email = input2.nextLine();
                for (Student i : students) {
                    my_email = i.getEmail();
                    if (email.equals(my_email)) {
                        project.projects_students.add(i);
                        i.collaborator_projects.add(project);

                        found = true;
                    }
                }
                if (!found) {
                    for (Professor i : professors) {
                        my_email = i.getEmail();
                        if (email.equals(my_email)) {
                            project.projects_professors.add(i);
                            i.collaborator_projects.add(project);
                            found = true;
                        }
                    }
                }
                if (!found) {
                    for (Researcher i : researchers) {
                        my_email = i.getEmail();
                        if (email.equals(my_email)) {
                            project.projects_researchers.add(i);
                            i.collaborator_projects.add(project);
                            found = true;
                        }
                    }
                }
                if (found)
                {
                    System.out.println("Added to project!");

                }
                else
                {
                    System.out.println("Not found...");
                }
            }
            else process = false;
        }

    }

    public void edit(Project project, ArrayList<Student> students, ArrayList<Professor> professors,
                      ArrayList<Researcher> researchers, ArrayList<Publication> publications)
    {
        boolean process = true, found = false;
        String my_email, email;
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input4 = new Scanner(System.in);
        int option;

        while(process)
        {
            System.out.println("Editing " + project.title);
            System.out.println("Press 1 to EDIT BASIC INFORMATIONS");
            System.out.println("Press 2 to CHANGE STATUS");
            System.out.println("Press 3 to ADD ONE COLLABORATOR");
            System.out.println("Press 4 to ADD ONE PUBLICATION\nRemember, the publications need to be added to the Laboratory " +
                    "beforehand");
            System.out.println("Press 5 to PLAY JOANNA NEWSOM AND LEAVE");

            option = input.nextInt();

            switch(option)
            {
                case 1:
                    //Set basic info
                    System.out.println("Start date (dd \\n mm \\n yyyy):");
                    project.startDay = input2.nextInt();
                    project.startMonth = input2.nextInt();
                    project.startYear = input2.nextInt();
                    System.out.println("Funding agency:");
                    project.agency = input3.nextLine();
                    System.out.println("Funded value:");
                    project.value = input2.nextInt();
                    System.out.println("Goals:");
                    project.goal = input3.nextLine();
                    System.out.println("Describe this project:");
                    project.description = input4.nextLine();
                    project.basicInfoSet = true;

                case 2:
                    if(project.status == 1)
                    {
                        System.out.println("The project is currently under construction");
                        if(project.basicInfoSet = true)
                        {
                            System.out.println("Press 1 to set it to 'in process'");
                            if(input.nextInt() == 1)
                            {
                                project.status = 2;
                            }
                        }
                        else
                        {
                            System.out.println("You can only change its status after setting basic info");
                        }
                    }
                    else if(project.status == 2)
                    {
                        System.out.println("The project is currently in process");
                        if(project.projects_publications != null)
                        {
                            System.out.println("Press 1 to set it to 'concluded'");
                            if(input.nextInt() == 1)
                            {
                                project.status = 3;
                                System.out.println("End date (dd \\n mm \\n yyyy):");
                                project.endDay = input.nextInt();
                                project.endMonth = input.nextInt();
                                project.endYear = input.nextInt();
                            }

                        }
                        else
                        {
                            System.out.println("You can only edit this once you publish something");
                        }
                    }
                    else if(project.status == 3)
                    {
                        System.out.println("The project is concluded. You can't change that");
                    }
                    break;
                case 3:
                    Scanner input6 = new Scanner(System.in);
                    System.out.println("Enter email");
                    email = input6.nextLine();
                    for (Student i : students) {
                        my_email = i.getEmail();
                        if (email.equals(my_email)) {
                            project.projects_students.add(i);
                            i.collaborator_projects.add(project);

                            found = true;
                        }
                    }
                    if (!found) {
                        for (Professor i : professors) {
                            my_email = i.getEmail();
                            if (email.equals(my_email)) {
                                project.projects_professors.add(i);
                                i.collaborator_projects.add(project);
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        for (Researcher i : researchers) {
                            my_email = i.getEmail();
                            if (email.equals(my_email)) {
                                project.projects_researchers.add(i);
                                i.collaborator_projects.add(project);
                                found = true;
                            }
                        }
                    }
                    if (found)
                    {
                        System.out.println("Found!");

                    }
                    else
                    {
                        System.out.println("Not found...");
                    }
                    break;
                case 4:
                    addPublication(publications, project);
                case 5:
                    System.out.println("Hey hey hey the end is near");
                    process = false;

            }
        }
    }

    public void addPublication(ArrayList<Publication> publications, Project project)
    {
        System.out.println("Enter the exact name of the publication");
        Scanner input = new Scanner(System.in);
        String pub_name = input.nextLine();
        boolean found = false;
        for(Publication i : publications)
        {
            if(i.title.equals(pub_name))
            {
                project.projects_publications.add(i);
                found = true;
            }
        }
        if(!found)
        {
            System.out.println("Something went wrong");
        }

    }

    public void add1Publication(Publication publication, Project project)
    {
        project.projects_publications.add(publication);
    }

    public void display() //mudar nome
    {
        System.out.println("WAIT FOR IT...");
    }
}
