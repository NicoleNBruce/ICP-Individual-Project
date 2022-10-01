import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;

public class RouteFinding {
    ReadFile read = new ReadFile();
    int noofflights = 0;

    HashMap<String, Airport> airportCodetoAirport = read.airportCodetoObject;
    HashMap<String, String> airportLocation = read.airportLocation;
    HashMap<String, List<Airport>> airports = read.airports;

    /**
     * This function retrieves the file name from an absolute path.
     *
     * @param path The path to the file.
     * @return The file name of the path.
     */
    public static String getPathName(String path) {
        return Paths.get(path).getFileName().toString();
    }

    /**
     * The function implements the breadth first algorithm on a problem object and
     * returns a list of actions that lead to the destination state
     *
     * @param problem The problem object that contains the initial state, goal test, and actions.
     * @return The list of actions that lead to the goal state.
     */
    public ArrayList<Routes> breadthfirstsearch(Problem problem){

        ArrayList<Node> frontier = new ArrayList<>();

        HashSet<Airport> explored = new HashSet<>();
        if (airportLocation.containsValue(problem.init_state)){
            List<Airport> airportlist = airports.get(problem.init_state);

            for (Airport airport: airportlist){
                Node node = new Node(airport);
                if(problem.goal_test(node.getState())) {
                    return node.getAct_list();
                }
                frontier.add(node);
            }
        }

        while (frontier.size()>0){
            Node node = frontier.remove(0);
            explored.add(node.getState());
            ArrayList<Routes> actions ;
            //updating the actions list
            problem.action(node.getState());
            actions = problem.actions;

            for (Routes route: actions) {
                if(airportCodetoAirport.get(route.getDestCode()) == null){
                    continue;
                }
                Node child_node = new Node(airportCodetoAirport.get(route.getDestCode()), node, route, node.pathCost+1);
                if(!explored.contains(child_node.getState()) && !frontier.contains(child_node)){
                    if(problem.goal_test(child_node.getState())) {
                        noofflights = child_node.getPathCost();
                        return child_node.getAct_list();
                    }
                    frontier.add(child_node);
                }
            }
        }
        return null;
    }

    /**
     * This function writes the output to a file
     *
     * @param routes This is the ArrayList of routes that we have created in the previous step.
     */
    public void writeFile(ArrayList<Routes> routes){
        String source = getPathName(ReadFile.inputfile);

        String[] sourcesplit = source.split("\\.");
        String name = sourcesplit[0] + "_output."+ sourcesplit[1];

        PrintWriter outputStream = null;
        String path;
        int totstops = 0;
        int numbering = 1;
        try{
            outputStream = new PrintWriter(new FileOutputStream(name));
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
            fnfe.getMessage();
        }

       for (Routes route : routes){
           totstops += Integer.parseInt(route.getStops());
           path = numbering + ". " + route.getAirlineCode() + " from "+ route.getSrcCode() + " to " + route.getDestCode() + " " + route.getStops() + " stops";
           outputStream.println(path);
           numbering+=1;
       }
       String noOfFlights = "Total number of flights: " + noofflights;
       String stops = "Total additional stops: " + totstops;
       outputStream.println(noOfFlights);
       outputStream.println(stops);

       outputStream.close();
    }
}
