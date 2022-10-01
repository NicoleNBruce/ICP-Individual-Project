import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class ReadFile {

    public static Scanner input;
    public static String inputfile;
    public String airportFile;
    public String routeFile;
    public String airlineFile;
    public static String source;
    public String destination;

    public ReadFile(){

    }
    // Creating a hashmap for the airport class.
    public static HashMap<String, List<Airport>> airports = new HashMap();
    // Creating a hashmap for the routes class.
    public static  HashMap<String, ArrayList<Routes>> routes = new HashMap();

    // This is a hashmap that stores the airline ID as the key and the airline object as the value.
    public static HashMap<Integer, List<Airline>>airlines = new HashMap();

    // This is a hashmap that stores the airport code as the key and the location as the value.
    public static HashMap<String, String> airportLocation = new HashMap();
    // This is a hashmap that stores the airport code as the key and the airport object as the value.
    public static HashMap<String, Airport> airportCodetoObject = new HashMap<>();


    public ReadFile(String inputfile, String airportFile, String routeFile, String airlineFile) {
        this.inputfile = inputfile;
        this.airportFile = airportFile;
        this.routeFile = routeFile;
        this.airlineFile = airlineFile;
    }

    /**
     * This function reads the airport file and creates three hashmaps of airport objects.
     * The first hashmap has the key being the airport location (city + country) of
     * each airport object, the second hashmap maps the airport code to the location and the third hashmap maps the
     * airport code to the airport object.
     */
    public void readairportfile() {
            try{
                input = new Scanner(new FileInputStream(airportFile));

            }
            catch(FileNotFoundException fnfe){
                fnfe.printStackTrace();
                fnfe.getMessage();

            }
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] split_line = line.split(",");
                if(split_line.length == 14){
                    String ID = split_line[2] + ", "+split_line[3];
                    String airportCode = split_line[4];

                    Airport air = new Airport(Integer.parseInt(split_line[0]), split_line[1], split_line[2], split_line[3], split_line[4], split_line[5], split_line[6], split_line[7], split_line[8], split_line[9], split_line[10], split_line[11], split_line[12], split_line[13]);

                    if(airports.containsKey(ID))
                        airports.get(ID).add(air);
                    else{
                        airports.put(ID, new ArrayList<Airport>());
                        airports.get(ID).add(air);
                    }
                    airportLocation.put(airportCode,ID);
                    airportCodetoObject.put(airportCode, air);
                }

            }

        input.close();
    }


    /**
     * This function reads the route file and stores the data in a hashmap
     */
    public void readroutefile() {
        try {
            input = new Scanner(new FileInputStream(routeFile));

        }
        catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
            fnfe.getMessage();

        }
        while (input.hasNext()){

            String line = input.nextLine();
            String [] split_line = line.split(",");
            if (split_line.length == 9){

                Routes route = new Routes(split_line[0],split_line[1], split_line[2], split_line[3], split_line[4], split_line[5], split_line[6], split_line[7], split_line[8]);
                String id = split_line[2];

                if (routes.containsKey(split_line[2])) {
                    routes.get(id).add(route);
                }
                else {
                    routes.put(split_line[2], new ArrayList());
                    routes.get(id).add(route);
                }

            }
        }
        input.close();
    }

    /**
     * This function reads the airline file and creates a hashmap of airline objects
     */
    public void readairlinefile() {
        try{
            input = new Scanner(new FileInputStream(airlineFile));
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
            fnfe.getMessage();
        }

        while (input.hasNext()){

            String line = input.nextLine();
            String [] split_line = line.split(",");
            if(split_line.length == 8) {
                Airline aline = new Airline(Integer.parseInt(split_line[0]), split_line[1], split_line[2], split_line[3], split_line[4], split_line[5], split_line[6], split_line[7]);
                airlines.put(aline.airlineID, Arrays.asList(aline));
            }
        }
        input.close();
    }

    /**
     * This function reads the input file and stores the source location and destination location in the variables source and destination
     */
    public void readInputFile(){
        try{
           input = new Scanner(new FileInputStream(inputfile));
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        source = input.nextLine();
        destination = input.nextLine();
    }

    /**
     * This function reads the input file, airport file, route file, and airline file
     */
    public void readFiles(){
        readInputFile();
        readairportfile();
        readroutefile();
        readairlinefile();
    }

}


