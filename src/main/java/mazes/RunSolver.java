package mazes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

abstract public class RunSolver extends SolutionMain
{

  public RunSolver() {
    super();
  }

  public RunSolver(String resourcePath) {
    super(resourcePath);
  }

  @Override
  protected String solve(List<String> data) throws InterruptedException
  {
    List<List<Character>> converted = new ArrayList<>();
    for(String line : data)
    {
      converted.add(line.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
    }
    Maze maze = new Maze(converted);
    return solve(maze);
  }

  abstract String solve(Maze maze) throws InterruptedException;
}
