public class Airline {
    int airlineID;
    String name;
    String alias;
    String iataCode;
    String icaoCode;
    String callsign;
    String country;
    String active;

    public Airline(int airlineID, String name, String alias, String iataCode, String icaoCode, String callsign, String country, String active) {
        this.airlineID = airlineID;
        this.name = name;
        this.alias = alias;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.callsign = callsign;
        this.country = country;
        this.active = active;
    }

    @Override
    public String toString() {
        return   name + ',' +
                 alias + ',' +
                 iataCode + ',' +
                icaoCode + ',' +
                 callsign + ',' +
                 country + ',' +
                 active + ','
                ;
    }
}
