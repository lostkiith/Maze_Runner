package maze;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] maze = null;

    public static void main(String[] args) {

        String newMenu = "=== Menu ===\n" +
                      "1. Generate a new maze\n" +
                      "2. Load a maze\n" +
                      "0. Exit";

        String loadedMenu = "=== Menu ===\n" +
                "1. Generate a new maze\n" +
                "2. Load a maze\n" +
                "3. Save the maze\n" +
                "4. Display the Maze\n" +
                "5. Find the escape\n" +
                "0. Exit";

        Scanner sc = new Scanner(System.in);
        System.out.println(newMenu);
        while(true){
            try {
                int choose = sc.nextInt();
                if (choose != 1 && choose != 2 && choose != 3
                        && choose != 4 && choose != 5 && choose != 0){
                    System.out.println("Incorrect option. Please try again");
                } else if (choose == 1){
                    System.out.println("Enter the size of a new maze");
                    int size = sc.nextInt();
                    maze = Maze.init_maze(size,size);
                    Maze.print_maze(maze);
                    System.out.println(loadedMenu);

                } else if (choose == 2){
                    System.out.println("Please enter the file name.");
                    String fileName = sc.next();
                    FileInputStream fileInput = new FileInputStream(fileName);
                    ObjectInputStream objectInput = new ObjectInputStream(fileInput);
                    maze = (int[][]) objectInput.readObject();
                    objectInput.close();
                    fileInput.close();

                    System.out.println(loadedMenu);

                } else if (choose == 3){
                    System.out.println("Please enter the file name.");
                    String fileName = sc.next();
                    FileOutputStream fileOutput = new FileOutputStream(fileName);
                    ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
                    objectOutput.writeObject(maze);
                    objectOutput.close();
                    fileOutput.close();

                    System.out.println(loadedMenu);

                } else if (choose == 4){
                    Maze.print_maze(maze);
                } else if (choose == 5){
                    Maze.mazeSearch(maze);

                }
                else {
                    System.exit(0);
                }
            } catch (InputMismatchException e){
                System.out.println("Incorrect option. Please try again");
            } catch (IOException e) {
                System.out.println("The file ... does not exist");
            } catch (ClassNotFoundException e) {
                System.out.println("Cannot load the maze. It has an invalid format");
            }
        }
    }

}
