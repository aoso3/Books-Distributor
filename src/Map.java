
import java.util.ArrayList;

import java.util.List;

//Processing library
import processing.core.PApplet;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
import main_classes.Store;
//Parsing library


public class Map extends PApplet {

	// You can ignore this.  It's to keep eclipse from generating a warning.
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFLINE, change the value of this variable to true
	public static boolean offline = false;
	

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "data/blankLight-1-3.mbtiles";
	
	// The map
	private UnfoldingMap map;
	

	public void setup() {
		size(400, 500, OPENGL);

		if (offline) {
		    map = new UnfoldingMap(this, 0, 0, 400, 500, new MBTilesMapProvider(mbTilesString));
		}
		else {
			map = new UnfoldingMap(this, 0, 0, 400, 500, new Google.GoogleMapProvider());
			
		}
		map.zoomAndPanTo(3,new Location(33.513806,36.276459));
	   // map.zoomToLevel(4);
	    MapUtils.createDefaultEventDispatcher(this, map);	
			
	    // The List you will populate with new SimplePointMarkers
	    List<Marker> markers = new ArrayList<Marker>();


		for(Store store :Intro.bd.getStoresByLocation()){
			String string = store.adress;
			String[] parts = string.split(",");
			String part1 = parts[0]; 
			String part2 = parts[1];
			//double check fo location
			String[] parts2 = part2.split(",");
			String part2_2 =parts2[0];

			
			SimplePointMarker marker = new SimplePointMarker(new Location(Double.parseDouble(part1),Double.parseDouble(part2_2)));
			marker.setRadius(13);
			marker.setColor(color(0,76,153));
			
			
			markers.add(marker);
			map.addMarker(marker);

		}

	}
	
	
	public void draw() {
	    background(10);
	    
	    map.draw();
	    //addKey();
	}


	// helper method to draw key in GUI
//	private void addKey() 
//	{	
//		// Remember you can use Processing's graphics methods here
//
//		fill(0, 102, 153);
//		rect(15, 110, 150, 450, 7);
//
//
//		fill(255, 255,255);
//		textSize(10);
//		text("Earth Quakes Key", 50, 150);
//
//
//		fill(0, 0, 200);
//		ellipse(30, 200, 25, 25);
//		text("- 4.0", 100, 200);
//
//		fill(255,255,51);
//		ellipse(30,250,25,25);
//		text("4.0 -> 4.9", 100, 250);
//
//		fill(200,0,0);
//		ellipse(30,300,25,25);
//		text("+ 5.0", 100, 300);
//
//
//
//	}
}
