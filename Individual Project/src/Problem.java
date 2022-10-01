import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Problem{
    String init_state;
    String goal_state;
    ReadFile read = new ReadFile();
    HashMap<String, List<Airport>> airports = read.airports;

    HashMap<String, ArrayList<Routes>> map = read.routes;
    HashMap<String, Airport> airportCodetoAirport = read.airportCodetoObject;
    ArrayList<Routes> actions = new ArrayList<>();
    ArrayList<Airport> successors = new ArrayList<>();


    public Problem(String state){
        this.init_state = state;
    }

    public Problem(String init_state, String goal_state, HashMap<String, ArrayList<Routes>> map) {
        this.init_state = init_state;
        this.goal_state = goal_state;
        this.map = map;
    }

    /**
     * > If the airport state is in the same location as the goal state, then the goal test is true
     *
     * @param state The current state of the problem
     * @return The goal test is returning true if the state is the goal state.
     */
    public boolean goal_test(Airport state) {
        boolean check =false;
        List<Airport> dests = airports.get(this.goal_state);
        for(Airport airport: dests) {
            check = airport.equals(state);
        }
        return check;
    }

    /**
     * The function takes in an airport and returns a list of all the airports that are reachable from the given airport
     *
     * @param state The current state of the search problem.
     */
    public void action(Airport state){
        String id = state.getIata_code();

        if(map.containsKey(id))
            actions = map.get(id);
        successors.add(airportCodetoAirport.get(id));

    }

}

