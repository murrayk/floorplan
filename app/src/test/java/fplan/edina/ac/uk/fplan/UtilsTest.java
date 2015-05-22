package fplan.edina.ac.uk.fplan;

import junit.framework.TestCase;

/**
 * Created by murrayking on 22/05/2015.
 */
public class UtilsTest extends TestCase {

    private static final String TAG = "UtilsTest";

    private static final double DELTA = 1e-5;

    public void setUp() throws Exception {
        super.setUp();

    }

    public void testWorldFile(){

        double xPixelsPerMeter = 0.0156292234461412,
                D = 0,
                B = 0,
                yPixelsPerMeter = -0.0146227230090583,
                topX = -354987.24210430972743779,
                topY =7546999.58978366944938898;


        double X_proj = topX + (xPixelsPerMeter* 5000) ;
        double Y_proj = topY + (yPixelsPerMeter * 1) ;
        System.out.println("X_proj " + X_proj);
        System.out.println( "Y_proj " + Y_proj);

        //var pos = new OpenLayers.LonLat(X_proj,Y_proj);
        //map.setCenter(pos);

        double p = (X_proj - topX)/ xPixelsPerMeter;
        //console.log("p " + p);
        System.out.println("p " + p);
        assertEquals("move x 5000 meters ", 5000,p, DELTA);

        //move Y 2000 m

        Y_proj = topY + (yPixelsPerMeter * 2000) ;
        System.out.println( "Y_proj " + Y_proj);

        p = (Y_proj - topY)/ yPixelsPerMeter;
        assertEquals("move y 2000 meters ", 2000, p, DELTA);
        System.out.println("Y_proj " + p);

    }


    public void testLatLonToMeters(){

        Utils utils = new Utils();

        //edinburgh univerisity library
        //55.942710, -3.18915

        Utils.LatLon latLon = utils.latLonToMeters(55.942710, -3.18915);
        System.out.println("lat in meters " + latLon.getLat() + " lon in meters " + latLon.getLon());

        assertEquals("lat in meters ", 7547019.280554745, latLon.getLat(), DELTA);
        assertEquals("lon in meters ", -355014.5540633685, latLon.getLon(), DELTA);


    }
}