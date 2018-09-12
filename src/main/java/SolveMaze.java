import edu.illinois.cs.cs125.lib.mazemaker.Maze;

/**
 * Solve a randomly-generated maze.
 *
 * @see <a href="https://github.com/cs125-illinois/mazemaker">Mazemaker on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/mazemaker/">Mazemaker Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/2/#maze">Lab 2 Writeup</a>
 */
@SuppressWarnings("checkstyle:emptyblock")
public class SolveMaze {

    /**
     * Implement your maze solving algorithm in the main method below.
     *
     * @param unused unused input arguments
     */

    public static void main(final String[] unused) {
        /*
         * Create a new 10 x 10 maze. Feel free to change these values.
         */
        Maze maze = new Maze(10, 10);

        /*
         * Pick (0, 0), the bottom left corner, as the starting point.
         * Put the end in the top right corner.
         */
        maze.startAtZero();
        maze.endAtTopRight();

        /*
         * You should be able to solve a 10 x 10 maze in (far fewer than) 1000 steps.
         * Feel free to adjust this number if you experiment with other mazes.
         */
        for (int step = 0; step < 1000; step++) {
            // Implement your maze solving algorithm hereWhile (isFinished() == false):
            //start with left
            maze.turnLeft();
                //if you hit a wall
                if(!maze.canMove() ) {
                    //move along wall if possible
                    maze.turnRight();

                    //if can't move
                    if (!maze.canMove()) {
                        maze.turnRight();
                    }
                }
            //move
            maze.move();
            if (maze.isFinished()){
                break;
            }
/**
            if (maze.isFinished() == false) {
                maze.turnRight();
                if (maze.canMove() == true) {
                    maze.move();
                } else {
                    if (maze.canMove() == false) {
                        maze.turnRight();
                        maze.turnLeft();
                        maze.turnLeft();
                        maze.move();
                    }
                }
            }
 **/
        }

        if (maze.isFinished()) {
            System.out.println("You solved the maze!");
        } else {
            System.out.println("Try again!");
        }

    }
}
