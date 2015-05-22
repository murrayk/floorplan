package fplan.edina.ac.uk.fplan;

/**
 * Created by murrayking on 22/05/2015.
 */
public class Utils {

    double originShift = 2 * Math.PI * 6378137 / 2.0;



    /**
        Converts given lat/lon in WGS84 Datum to XY in Spherical Mercator EPSG:900913
     */
    public  LatLon latLonToMeters (double lat,double lon){
        double mx = lon * this.originShift / 180.0;
        double my = Math.log( Math.tan((90 + lat) * Math.PI / 360.0 )) / (Math.PI / 180.0);

        my = my * this.originShift / 180.0;
        return new LatLon( my, mx);

    }



    class LatLon {
        private double lat;
        private double lon;


        LatLon(double lat,double lon){
            this.lat = lat;
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public double getLon() {
            return lon;
        }
    }
}
