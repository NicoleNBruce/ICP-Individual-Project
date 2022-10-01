public class Airport {
    private int ID;
    private String name;
    private String city;
    private String country;
    private String iata_code;
    private String icao_code;
    private String latitude;
    private String longitude;
    private String altitude;
    private String timezone;
    private String dst;
    private String tz;
    private String type;
    private String data_src;
    private String location;




    public Airport(int ID, String name, String city, String country, String iata_code, String icao_code, String latitude, String longitude, String altitude, String timezone, String dst, String tz, String type, String data_src) {
        this.ID = ID;
        this.name = name;
        this.city = city;
        this.country = country;
        this.iata_code = iata_code;
        this.icao_code = icao_code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timezone = timezone;
        this.dst = dst;
        this.tz = tz;
        this.type = type;
        this.data_src = data_src;
    }


    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getIata_code() {
        return iata_code;
    }

    public String getIcao_code() {
        return icao_code;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getLocation(){
         location = city + country;
         return location;
    }

    @Override
    public String toString() {
        return name + ',' +
                iata_code + ',' +
                icao_code + ',' +
                latitude + ',' +
                 longitude + ',' +
                 altitude + ',' +
                timezone + ',' +
                dst + ',' +
               tz + ',' +
                type + ',' +
                data_src + ','
                ;
    }
}

