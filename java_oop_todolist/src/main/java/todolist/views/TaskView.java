package todolist.views;

import java.util.Scanner;

import todolist.usecases.TaskUsecase;

public class TaskView {
    public static void ShowListtodo(String userid) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("User: " + userid);
        System.out.println("List to do");
        System.out.println("=======================");

        TaskUsecase taskUsecase = new TaskUsecase();
        taskUsecase.GetTaskList(userid);

        System.out.println("====");
        System.out.println("MENU");
        System.out.println("====");
        System.out.println("[1] - Add New Task");
        System.out.println("[2] - Delete Task");
        System.out.println("[0] - Back to Welcome Page");
        System.out.println();
        System.out.println("Input Menu (Number):");
        Integer menu = inputScanner.nextInt();

        switch (menu) {
            case 0:
                WelcomeViews.ShowWelcomeView();
                break;
            case 1:
                ShowAddTask(userid);
                break;
            case 2:
                ShowDeleteTask(userid);
                break;
        }
        inputScanner.close();
    }

    private static void ShowAddTask(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("=======================");
        System.out.print("task: ");
        String sTask = inputScanner.nextLine();

        TaskUsecase taskUsecase = new TaskUsecase();
        taskUsecase.AddTask (sTask, userid);

        ShowListtodo(userid);
        inputScanner.close();
    }

    private static void ShowDeleteTask(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("=======================");
        System.out.print("task id: ");
        Integer iTaskId = inputScanner.nextInt();

        TaskUsecase taskUsecase = new TaskUsecase();
        taskUsecase.DeleteTask(iTaskId);

        ShowListtodo(userid);
        inputScanner.close();
    }
}
