import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Admin administrator = new Admin;

        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Professor> professors = new ArrayList<Professor>();
        ArrayList<Researcher> researchers = new ArrayList<Researcher>();

        ArrayList<Project> projects = new ArrayList<Project>();

        boolean process;
        process = true;
        Scanner input = new Scanner(System.in);

        while (process) {
            System.out.println("Welcome! How do you like to continue?");
            System.out.println("Press 1 to ADD A COLLABORATOR");
            System.out.println("Press 2 to LOGIN AS ADMIN");
            System.out.println("Press 3 to CONSULT COLLABORATOR OR PROJECT");
            System.out.println("Press 4 to SHOW REPORT");

            int option = input.nextInt();

            switch (option) {
                case 1:
                    //Scanner input2 = new Scanner(System.in);
                    String name, email;
                    System.out.println("Adding new collaborator...");
                    System.out.println("Are you a (1) student, (2) professor, (3) researcher?");
                    int option2 = input.nextInt();

                    if (option2 == 1 || option2 == 2 || option2 == 3)
                    {
                        System.out.println("Type in your name:");
                        name = input.nextLine();
                        System.out.println("Type in your email:");
                        email = input.nextLine();
                        switch (option2) {
                            case 1:
                                int type;
                                System.out.println("Are you (1) an undergrad, (2) a graduate, (3) mastering?");
                                type = input.nextInt();
                                Student newCollab = new Student(name, email, type);
                                students.add(newCollab);
                                break;

                            case 2:
                                Professor newCollab2 = new Professor(name, email);
                                professors.add(newCollab2);
                                break;

                            case 3:
                                Researcher newCollab3 = new Researcher(name, email);
                                researchers.add(newCollab3);
                                break;
                        }
                    } else {
                        System.out.println("Umm, that's not an option...");
                    }

                    break;
                case 2:
                    int tries = 3;
                    boolean isAdmin = false;
                    String adminEmail, adminPassword;

                    while(tries != 0)
                    {
                        System.out.println("Enter email");
                        adminEmail = input.nextLine();
                        if(adminEmail.equals(administrator.getEmail))
                        {
                            System.out.println("Enter password");
                            adminPassword = input.nextLine();
                            if(adminPassword.equals(administrator.getPassword))
                            {
                                isAdmin = true;
                            }
                            else
                            {
                                tries--;
                                System.out.println("Wrong password! You've got " + tries + "more chances");
                            }
                        }
                        else
                        {
                            System.out.println("Wrong email! Try again");
                        }
                    }
                    if(isAdmin)
                    {
                        login(students, professors, researchers, projects);
                    }
                    break;
                case 3:
                    consult(students, professors, researchers);
                    break;
                case 4:
                    System.out.println("Not available right now");
                    break;
                default:
                    System.out.println("Please choose a valid option, yes?");
            }

            System.out.println("Would you like to exit or continue?");
            System.out.println("Press 0 to exit the application or 1 to continue");
            if (input.nextInt() == 0) {
                process = false;
            }

        }
    }

/* public static void newCollaborator()
    {

    }*/

    public static void consult(ArrayList<Student> students, ArrayList<Professor> professors,
                               ArrayList<Researcher> researchers)
    {
        System.out.println("Consult for a (1) collaborator, (2) project");
        Scanner input = new Scanner(System.in);
        int option;
        boolean found = false;
        option = input.nextInt();
        String email;
        int id;

        if (option == 1) {
            System.out.println("Enter email");
            email = input.nextLine();
            String my_email;

            for (Student i : students) {
                my_email = i.getEmail();
                if (email.equals(my_email)) {
                    i.display();
                    found = true;
                }
            }
            if (!found) {
                for (Professor i : professors) {
                    my_email = i.getEmail();
                    if (email.equals(my_email)) {
                        i.display();
                        found = true;
                    }
                }
            }
            if (!found) {
                for (Researcher i : researchers) {
                    my_email = i.getEmail();
                    if (email.equals(my_email)) {
                        i.display();
                        found = true;
                    }
                }
            }
            if (found) {
                System.out.println("Found!");
            } else {
                System.out.println("Not found...");
            }
        } else if (option == 2) {
            System.out.println("Enter project's name");
            name = input.nextLine();
            System.out.println("Not available right now");
        }
    }

    public void login(ArrayList<Student> students, ArrayList<Professor> professors,
                      ArrayList<Researcher> researchers, ArrayList<Project> projects)
    {
        Scanner input = new Scanner(System.in);
        int option;
        boolean process;
        process = true;

        while(process)
        {
            System.out.println("What would you like to do?");
            System.out.println("Press 1 to ADD A PROJECT");
            System.out.println("Press 2 to EDIT A PROJECT");
            System.out.println("Press 3 to ADD A PUBLICATION");
            System.out.println("Press 4 to ASSOCIATE MENTORING TO PROFESSOR");
            System.out.println("Press 5 to LOG OUT");

            option = input.nextInt();

            switch(option)
            {
                case 1:
                    int continuing;
                    String name, email, my_email;
                    Professor project_head;
                    boolean found;

                    System.out.println("Enter the professor's email");
                    email = input.nextLine();
                    for (Professor i : professors) {
                        my_email = i.getEmail();
                        if (email.equals(my_email)) {
                            i.display();
                            found = true;
                            project_head = i;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Sorry, start over");
                    }

                    System.out.println("Enter project's name");
                    name = input.nextLine();

                    Project newProject = new Project(1, name, project_head);
                    projects.add(newProject);
                    project_head.professor_projects.add(newProject); //adiciona o projeto na lista de projetos desse professor head

                    System.out.println("Add all info? (1) Yes or (2) no. You can edit it later");
                    continuing = input.nextInt();
                    if(continuing == 1)
                    {
                        //newProject.start(newProject, students, professors, researchers);
                    }
                    break;

                case 2:
                    String name2, my_name;
                    boolean found2 = false;
                    System.out.println("Enter project's name");
                    name2 = input.nextLine();
                    for (Project i : projects) {
                        my_name = i.getTitle();
                        if (name2.equals(my_name)) {
                            i.display();
                            found2 = true;
                            //i.edit()
                        }
                    }
                    if(!found2)
                    {
                        System.out.println("This project doesn't seem to exist...");
                    }

                case 3:

                    //criar uma publicacao e ou associar uma publicacao a um projeto e ou a um colaborador

                case 4:

                case 5:
                    process = false;

            }

        }

    }

}