import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ReadFile fileread = new ReadFile("accra-winnipeg.txt","airports.csv", "routes.csv","airlines.csv");
        fileread.readFiles();
        Problem prob = new Problem(fileread.source, fileread.destination, fileread.routes);
        RouteFinding find = new RouteFinding();
        ArrayList<Routes> action_list = find.breadthfirstsearch(prob);
        find.writeFile(action_list);

    }
}
