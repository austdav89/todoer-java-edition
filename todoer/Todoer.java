/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoer;

import java.util.ArrayList;
import java.time.OffsetDateTime;
import java.util.Scanner; 

/**
 *
 * @author austind
 */
class Todoer {
    
    static void welcomeMsg(){
        System.out.print("\nWelcome to ToDoer v0.1!\n");
        System.out.print("Created by: Austin Davis\n");
        System.out.print("Type \"help\" for a list of commands.\n\n");
    }
    
    /* This function is summoned by using the help command.The bulk of the instructions and tutorials should go here. */
    static void helpMsg(){
        System.out.print("\nToDoer is a checklist program to help prioritize the day.\n\n"); 
        System.out.print("Available commands:\n\nadd\t<Todo Name>\ndel\t<todo Num> (Use show cmd)\ndone\t<todo Num> (Use show cmd)\nshow\nquit\n\n"); 
    }
    
    static void startTodoer(){
        Scanner input = new Scanner(System.in);
        ArrayList<Todo> todos = new ArrayList<Todo>(); 
        String prompt = "TODO>"; ////Universal prompt prefix
        String[] userInput;
        int todoNum;
        
        while (true){
            userInput = new String[2];
            System.out.print(prompt);
            userInput = (input.nextLine()).split(" ", 2);
            
            switch (userInput[0]){
                case "quit":
                    System.exit(0); break;
                case "help":
                    helpMsg(); break;
                case "add":
                    if (userInput.length == 2){
                        todos.add(new Todo(userInput[1]));
                    } else {
                        System.out.println("-add error: todo name not supplied");
                    }
                    break;
                case "show":
                    if (!(todos.isEmpty())){
                        System.out.println("Todo#\tDone\tName");
                        System.out.println("--------------------------------");
                    }
                    for (int i = 0; i < todos.size(); i++){
                        System.out.println((i + 1) + "\t" + todos.get(i).done + "\t" + todos.get(i).name);
                    }
                    break;
                case "del":
                    try {
                        todoNum = Integer.parseInt(userInput[1]);
                        if (todoNum == 1 && todos.size() == 1){
                            todos.clear();
                        }
                        else if (todoNum > 0 && todoNum <= todos.size()){
                            todos.remove(todoNum - 1);
                        }
                        else if (todos.isEmpty()){
                            System.out.println("No todos to delete");
                        }
                        else {
                            System.out.println("-del error: number out of scope");
                        }  
                    }
                    catch (NumberFormatException e)
                        {
                           System.out.println("-del error: not a number");
                        }
                    break;
                case "done":
                    try {
                        todoNum = Integer.parseInt(userInput[1]);
                        if (todoNum > 0 && todoNum <= todos.size()){
                            todos.get(todoNum - 1).done = true;
                        }
                        else if (todos.isEmpty()){
                            System.out.println("No todos to complete");
                        }
                        else {
                            System.out.println("-done error: number out of scope");
                        }  
                    }
                    catch (NumberFormatException e)
                        {
                           System.out.println("-done error: not a number");
                        }
                    break;
                default:
                    if (!(userInput[0].isBlank())) //if user input is NOT blank throw error
                        System.out.println("-TODO: " + userInput[0] + ": command not found");
            }
            
        }
    }
}
