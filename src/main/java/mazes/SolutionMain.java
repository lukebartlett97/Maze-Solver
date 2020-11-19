package mazes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class SolutionMain
{
  private String resourcePath;

  private boolean verbose = false;

  public SolutionMain() {
    super();
  }

  public SolutionMain(String resourcePath) {
    super();
    this.resourcePath = resourcePath;
  }

  public void printSolution(boolean verbose) throws IOException, InterruptedException
  {
    this.verbose = verbose;
    getNotes().forEach(System.out::println);
    List<String> data = getData();
    System.out.println("Data:");
    System.out.println(data);
    System.out.println("Solution:");
    System.out.println(solve(data));
  }

  protected abstract String solve(List<String> data) throws IOException, InterruptedException;

  protected List<String> getData() throws IOException
  {
    URL resource = this.getClass().getResource(resourcePath + "data.txt");
    return readFile(resource);
  }

  protected List<String> getNotes() throws IOException
  {
    URL resource = this.getClass().getResource(resourcePath + "notes.txt");
    return readFile(resource);
  }

  private List<String> readFile (URL file) throws IOException
  {
    BufferedReader in = new BufferedReader(
            new InputStreamReader(file.openStream()));

    String inputLine;
    List<String> lines = new ArrayList<String>();
    while ((inputLine = in.readLine()) != null)
      lines.add(inputLine);
    in.close();
    return lines;
  }

  public void setResourcePath(String resourcePath)
  {
    this.resourcePath = resourcePath;
  }

  protected void printInfo(String line)
  {
    if(verbose)
    {
      System.out.println(line);
    }
  }
}
