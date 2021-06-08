package maze;

import java.util.*;

public class Maze {

    //print maze
    public static void print_maze(int[][] twoDimArray) {
        for (int[] ints : twoDimArray) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    System.out.print("\u2588\u2588");
                }else if (anInt == 4) {
                    System.out.print("//");

                }else {
                    System.out.print("  ");
                }

            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }

    //Create maze
    public static int[][] init_maze(final int width, final int height) {

        int[][] maze = new int[height][width];
        // fills the maze with 3 to represent not-visited
        for (int i = 0; i < height; i++) {
            int[] line = new int[width];
            for (int k = 0; k < width; k++) {
                line[k] = 3;
            }
            maze[i] = line;
        }
        generate_maze_shape(width, height, maze);
        return maze;
    }

    // generates the maze's shape using prim's algorithm.
    private static void generate_maze_shape(final int width, final int height, int[][] maze) {
        Random rand = new Random();

        int starting_width = rand.nextInt(width - 1);
        int starting_height = rand.nextInt(height - 1);

        // checks if cell is on the sides of the maze
        if (starting_height == 0)
            starting_height += 1;
        if (starting_height == height - 1)
            starting_height -= 1;
        if (starting_width == 0)
            starting_width += 1;
        if (starting_width == width - 1)
            starting_width -= 1;

        //sets starting point to a passage
        maze[starting_height][starting_width] = 0;

        // set the locations around passage as walls and store
        ArrayList<List<Integer>> walls = new ArrayList<>();
        walls.add(Arrays.asList(starting_height - 1, starting_width));
        walls.add(Arrays.asList(starting_height, starting_width - 1));
        walls.add(Arrays.asList(starting_height, starting_width + 1));
        walls.add(Arrays.asList(starting_height + 1, starting_width));

        // set blocks around starting point to walls.
        maze[starting_height - 1][starting_width] = 1;
        maze[starting_height][starting_width - 1] = 1;
        maze[starting_height][starting_width + 1] = 1;
        maze[starting_height + 1][starting_width] = 1;


        while (!walls.isEmpty()) {
            int random_cell = rand.nextInt(walls.size());
            var rand_wall = walls.remove(random_cell);

            // Check if it is a left wall
            if (rand_wall.get(1) != 0) {
                // -1 is one to the right of the cell
                if (maze[rand_wall.get(0)][rand_wall.get(1) - 1] == 3
                        // +1 is one to the left of the cell
                        && maze[rand_wall.get(0)][rand_wall.get(1) + 1] == 0) {
                    // Find the number of surrounding cells
                    int s_cells = surroundingCells(rand_wall, maze);

                    if (s_cells < 2) {
                        // Denote the new path
                        maze[rand_wall.get(0)][rand_wall.get(1)] = 0;

                        //Mark the new walls
                        //Upper cell
                        if (rand_wall.get(0) != 0) {
                            if (maze[rand_wall.get(0) - 1][rand_wall.get(1)] != 0)
                                maze[rand_wall.get(0) - 1][rand_wall.get(1)] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0) - 1, rand_wall.get(1))))
                                walls.add(Arrays.asList(rand_wall.get(0) - 1, rand_wall.get(1)));
                        }

                        // Bottom cell
                        if (rand_wall.get(0) != height - 1) {
                            if (maze[rand_wall.get(0) + 1][rand_wall.get(1)] != 0)
                                maze[rand_wall.get(0) + 1][rand_wall.get(1)] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0) + 1, rand_wall.get(1))))
                                walls.add(Arrays.asList(rand_wall.get(0) + 1, rand_wall.get(1)));
                        }

                        // Leftmost cell
                        if (rand_wall.get(1) != 0) {
                            if (maze[rand_wall.get(0)][rand_wall.get(1) - 1] != 0)
                                maze[rand_wall.get(0)][rand_wall.get(1) - 1] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0), rand_wall.get(1) - 1)))
                                walls.add(Arrays.asList(rand_wall.get(0), rand_wall.get(1) - 1));
                        }
                    }
                    // Delete wall
                    walls.removeIf(wall -> wall.get(0).equals(rand_wall.get(0)) && wall.get(1).equals(rand_wall.get(1)));
                }
            }
            // Check if it is an upper wall
            if (rand_wall.get(0) != 0) {
                if (maze[rand_wall.get(0) - 1][rand_wall.get(1)] == 3
                        && maze[rand_wall.get(0) + 1][rand_wall.get(1)] == 0) {
                    // Find the number of surrounding cells
                    var s_cells = surroundingCells(rand_wall, maze);

                    if (s_cells < 2) {
                        // Denote the new path
                        maze[rand_wall.get(0)][rand_wall.get(1)] = 0;

                        //Mark the new walls
                        //Upper cell
                        if (rand_wall.get(0) != 0) {
                            if (maze[rand_wall.get(0) - 1][rand_wall.get(1)] != 0)
                                maze[rand_wall.get(0) - 1][rand_wall.get(1)] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0) - 1, rand_wall.get(1))))
                                walls.add(Arrays.asList(rand_wall.get(0) - 1, rand_wall.get(1)));
                        }

                        // Leftmost cell
                        if (rand_wall.get(1) != 0) {
                            if (maze[rand_wall.get(0)][rand_wall.get(1) - 1] != 0)
                                maze[rand_wall.get(0)][rand_wall.get(1) - 1] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0), rand_wall.get(1) - 1)))
                                walls.add(Arrays.asList(rand_wall.get(0), rand_wall.get(1) - 1));
                        }

                        // Rightmost cell
                        if (rand_wall.get(1) != width - 1) {
                            if (maze[rand_wall.get(0)][rand_wall.get(1) + 1] != 0)
                                maze[rand_wall.get(0)][rand_wall.get(1) + 1] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0), rand_wall.get(1) + 1)))
                                walls.add(Arrays.asList(rand_wall.get(0), rand_wall.get(1) + 1));
                        }
                    }
                    // Delete wall
                    walls.removeIf(wall -> wall.get(0).equals(rand_wall.get(0)) && wall.get(1).equals(rand_wall.get(1)));
                }
            }
            // Check the bottom wall
            if (rand_wall.get(0) != height - 1) {
                if (maze[rand_wall.get(0) + 1][rand_wall.get(1)] == 3
                        && maze[rand_wall.get(0) - 1][rand_wall.get(1)] == 0) {
                    // Find the number of surrounding cells
                    var s_cells = surroundingCells(rand_wall, maze);

                    if (s_cells < 2) {
                        // Denote the new path
                        maze[rand_wall.get(0)][rand_wall.get(1)] = 0;

                        //Mark the new walls
                        //Upper cell
                        if (rand_wall.get(0) != height - 1) {
                            if (maze[rand_wall.get(0) + 1][rand_wall.get(1)] != 0)
                                maze[rand_wall.get(0) + 1][rand_wall.get(1)] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0) + 1, rand_wall.get(1))))
                                walls.add(Arrays.asList(rand_wall.get(0) + 1, rand_wall.get(1)));
                        }

                        // Leftmost cell
                        if (rand_wall.get(1) != 0) {
                            if (maze[rand_wall.get(0)][rand_wall.get(1) - 1] != 0)
                                maze[rand_wall.get(0)][rand_wall.get(1) - 1] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0), rand_wall.get(1) - 1)))
                                walls.add(Arrays.asList(rand_wall.get(0), rand_wall.get(1) - 1));
                        }

                        // Rightmost cell
                        if (rand_wall.get(1) != width - 1) {
                            if (maze[rand_wall.get(0)][rand_wall.get(1) + 1] != 0)
                                maze[rand_wall.get(0)][rand_wall.get(1) + 1] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0), rand_wall.get(1) + 1)))
                                walls.add(Arrays.asList(rand_wall.get(0), rand_wall.get(1) + 1));
                        }
                    }
                    // Delete wall
                    walls.removeIf(wall -> wall.get(0).equals(rand_wall.get(0)) && wall.get(1).equals(rand_wall.get(1)));
                }
            }
            // Check the right wall
            if (rand_wall.get(1) != width - 1) {
                if (maze[rand_wall.get(0)][rand_wall.get(1) + 1] == 3
                        && maze[rand_wall.get(0)][rand_wall.get(1) - 1] == 0) {
                    // Find the number of surrounding cells
                    var s_cells = surroundingCells(rand_wall, maze);

                    if (s_cells < 2) {
                        // Denote the new path
                        maze[rand_wall.get(0)][rand_wall.get(1)] = 0;

                        //Mark the new walls
                        //Upper cell
                        if (rand_wall.get(1) != width - 1) {
                            if (maze[rand_wall.get(0)][rand_wall.get(1) + 1] != 0)
                                maze[rand_wall.get(0)][rand_wall.get(1) + 1] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0), rand_wall.get(1) + 1)))
                                walls.add(Arrays.asList(rand_wall.get(0), rand_wall.get(1) + 1));
                        }

                        // Leftmost cell
                        if (rand_wall.get(0) != height - 1) {
                            if (maze[rand_wall.get(0) + 1][rand_wall.get(1)] != 0)
                                maze[rand_wall.get(0) + 1][rand_wall.get(1)] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0) + 1, rand_wall.get(1))))
                                walls.add(Arrays.asList(rand_wall.get(0) + 1, rand_wall.get(1)));
                        }

                        // Rightmost cell
                        if (rand_wall.get(0) != 0) {
                            if (maze[rand_wall.get(0) - 1][rand_wall.get(1)] != 0)
                                maze[rand_wall.get(0) - 1][rand_wall.get(1)] = 1;
                            //if ([rand_wall[0] - 1, rand_wall[1]]not in walls):
                            if (!walls.contains(Arrays.asList(rand_wall.get(0) - 1, rand_wall.get(1))))
                                walls.add(Arrays.asList(rand_wall.get(0) - 1, rand_wall.get(1)));
                        }
                    }
                    // Delete wall
                    walls.removeIf(wall -> wall.get(0).equals(rand_wall.get(0)) && wall.get(1).equals(rand_wall.get(1)));
                }
            }
            // Delete the wall from the list anyway
            walls.removeIf(wall -> wall.get(0).equals(rand_wall.get(0)) && wall.get(1).equals(rand_wall.get(1)));
        }
        // Mark the remaining unvisited cells as walls
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == 3)
                    maze[i][j] = 1;
            }
        }

        // Set entrance
        for (int i = 0; i < width; i++) {
            if (maze[1][i] == 0) {
                maze[0][i] = 0;
                break;
            }
        }
        //set end
        for (int i = 0; i < width - 1; i++) {
            if (maze[height - 2][i] == 0) {
                maze[height - 1][i] = 0;
                break;
            }
        }
    }

    // Find number of surrounding cells
    private static int surroundingCells(List<Integer> rand_wall, int[][] maze) {
        int s_cells = 0;
        if (maze[rand_wall.get(0) - 1][rand_wall.get(1)] == 0)
            s_cells += 1;
        if (maze[rand_wall.get(0) + 1][rand_wall.get(1)] == 0)
            s_cells += 1;
        if (maze[rand_wall.get(0)][rand_wall.get(1) - 1] == 0)
            s_cells += 1;
        if (maze[rand_wall.get(0)][rand_wall.get(1) + 1] == 0)
            s_cells += 1;

        return s_cells;
    }

    // search the maze for an exit route
    public static void mazeSearch(int[][] maze) {
        int [][] mazeRoute = maze.clone();
        mazeRoute[0][1] = 4;
        ArrayList<List<Integer>> routeOut = new ArrayList<>();
        routeOut.add(Arrays.asList(0,1));
        backTrack(mazeRoute, routeOut);
    }

    // the algorithm to find ther exit using backtrack
    public static void backTrack(int[][] mazeRoute, ArrayList<List<Integer>> routeOut) {
        var current_cell = routeOut.get(routeOut.size() - 1);

        if (current_cell.get(0) == mazeRoute.length - 1 && current_cell.get(1) == 1) {
            Maze.print_maze(mazeRoute);
            System.exit(0);
        }

        if (mazeRoute[current_cell.get(0) + 1][current_cell.get(1)] == 0) {
            mazeRoute[current_cell.get(0) + 1][current_cell.get(1)] = 4;
            routeOut.add(Arrays.asList(current_cell.get(0) + 1, current_cell.get(1)));
            backTrack(mazeRoute, routeOut);
        }

        if (mazeRoute[current_cell.get(0)][current_cell.get(1) + 1] == 0) {
            mazeRoute[current_cell.get(0)][current_cell.get(1) + 1] = 4;
            routeOut.add(Arrays.asList(current_cell.get(0), current_cell.get(1) + 1));
            backTrack(mazeRoute, routeOut);
        }

        if (mazeRoute[current_cell.get(0) - 1][current_cell.get(1)] == 0) {
            mazeRoute[current_cell.get(0) - 1][current_cell.get(1)] = 4;
            routeOut.add(Arrays.asList(current_cell.get(0) - 1, current_cell.get(1)));
            backTrack(mazeRoute, routeOut);
        }

        if (mazeRoute[current_cell.get(0)][current_cell.get(1) - 1] == 0) {
            mazeRoute[current_cell.get(0)][current_cell.get(1) - 1] = 4;
            routeOut.add(Arrays.asList(current_cell.get(0), current_cell.get(1) - 1));
            backTrack(mazeRoute, routeOut);
        }

        current_cell = routeOut.get(routeOut.size() - 1);
        if (!(current_cell.get(0) == mazeRoute.length - 1 && current_cell.get(1) == 1)) {
            var cell_to_remove = routeOut.get(routeOut.size() - 1);
            routeOut.remove(cell_to_remove);
            mazeRoute[cell_to_remove.get(0)][cell_to_remove.get(1)] = 0;
        }
    }
}



