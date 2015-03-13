/**
 * 
 */
package info.pello.asynctask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Extends AsyncTask to get the contents from an URL
 * It provides a way to pass some values through generics:
 * AsyncTask<class1,class2,class3> where:
 * -Class1: type of information for the task (e.g. the URL to get), passed
 *          through execute method
 * -Class2: type of information to indicate progress, must be the same
 *          class in onProgressUpdate method
 * -Class3: type of information for the postTask
 * @author Pello Xabier Altadill Izura
 * @greetz any
 */
public class MyTask 
	extends AsyncTask<String,String,String> {
     
    // We well keep a reference to our caller activity
    // so we can attach/detach in case of activity is destroyed in a rotation
    private MainActivity mainActivity;
 
    /**
     * Default constructor
     * @param mainActivity
     */
    public MyTask (MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

	@Override
	protected String doInBackground(String... params) {
		String result = getPage();
		Log.d("Pello", result);
		return null;
	}

	private String getPage() {
		String url = "http://www.pello.info";
		 
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
	 
		StringBuffer result = new StringBuffer();
		// add request header
		//request.addHeader("User-Agent", USER_AGENT);
		try {
		HttpResponse response = client.execute(request);
	 
		System.out.println("Response Code : " 
	                + response.getStatusLine().getStatusCode());
	 
		BufferedReader rd;

			rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));

	 
		String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}		
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}
     
   
 
}
