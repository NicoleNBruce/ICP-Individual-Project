
import java.util.*;

public class Routes {

    String srcCode;
    String airlineCode;
    String airlineID ;
    String srcID ;
    String destCode ;
    String destID ;
    String codeshare ;
    String stops ;
    String equipment ;

    public String getAirlineCode() {
        return airlineCode;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public String getSrcCode() {
        return srcCode;
    }

    public String getSrcID() {
        return srcID;
    }

    public String getDestCode() {
        return destCode;
    }

    public String getDestID() {
        return destID;
    }

    public String getStops() {
        return stops;
    }

    public Routes(String airlineCode, String airlineID,String srcCode, String srcID, String destCode, String destID, String codeshare, String stops, String equipment) {
        this.srcCode = srcCode;
        this.airlineCode = airlineCode;
        this.airlineID = airlineID;
        this.srcID = srcID;
        this.destCode = destCode;
        this.destID = destID;
        this.codeshare = codeshare;
        this.stops = stops;
        this.equipment = equipment;
    }

    public static HashMap<String, List<String>> routes= new HashMap();

    @Override
    public String toString() {
        return '[' + airlineCode + ',' +
                 airlineID + ',' +
                srcID + ',' +
                 destCode + ',' +
                destID + ',' +
                 codeshare + ',' +
              stops + ',' +
                 equipment + ',' + ']';
    }
}

