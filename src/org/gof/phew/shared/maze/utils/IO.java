package org.gof.phew.shared.maze.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;

/**
 * Resource loading/storing helpers.
 * 
 * @author gof
 */
public class IO
{
	
	private static final String TAG = "IO";
	
	private static IO io;
	
	private IO(AssetManager assets) {
		this.assets = assets;
		
	}
	
	public static void init(Activity activity) {
		
		io = new IO(activity.getAssets());
		
	}
	
	
	
	/**
	 * Android resources
	 */
	private AssetManager assets;
	
	/**
	 * JSON marshaller
	 */
	private Gson gson = new Gson();
	
	/**
	 * TODO: list resource and map to type, subtype and id
	 */
	private Map <String, File> resources = new HashMap <String, File> ();
	
	/**
	 * Loads object of specified type.
	 * @param resourceId - resource id associated with this object (TODO: currently file path)
	 * @param clazz - object type
	 * @return null, if 
	 */
	public static <E> E loadObject(String resourceId, Class <E> clazz)
	{
		if(io == null) 
			throw new IllegalStateException("IO not initialized.");
		
		InputStreamReader reader = null;
		try {
			
			InputStream resourceStream = io.assets.open(resourceId);
			if(resourceStream == null)
				throw new NullPointerException("Failed to open resource.");
			
			reader = new InputStreamReader(resourceStream);
			
			synchronized(io.gson) { // just to be sure
				return io.gson.fromJson(reader, clazz);
			}
			
		}
		catch(Exception e) { // FileNotFoundException, JsonIOException, JsonSyntaxException, NullPointerException
			Log.w(TAG, "Failed to load resource id [" + resourceId + "].");
			Log.d(TAG, "Resource type [" + clazz + "]:", e);
			return null;
			
		}
		finally {
			try
			{
				if(reader != null) reader.close(); 
			} catch ( IOException e )
			{
				Log.w(TAG, "Failed to load resource id [" + resourceId + "].");
				Log.d(TAG, "Resource type [" + clazz + "]:", e);
				throw new RuntimeException("Oh my god!!!", e);
			}
		}

	}
	
	
	private static String readExternalFile(String filename)
	{
		//Find the directory for the SD Card using the API
		//*Don't* hardcode "/sdcard"
		File sdcard = Environment.getExternalStorageDirectory();

		//Get the text file
		File file = new File(sdcard,"file.txt");

		//Read text from file
		StringBuilder text = new StringBuilder();

		try {
		    BufferedReader br = new BufferedReader(new FileReader(file));
		    String line;

		    while ((line = br.readLine()) != null) {
		        text.append(line);
		        text.append('\n');
		    }
		}
		catch (IOException e) {
		    //You'll need to add proper error handling here
		}

		return text.toString();
	}
}
