package com.wade12.customvolleyrequest;

import com.wade12.customvolleyrequest.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {
	TextView textView;
		        
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView);
		                
		RequestQueue requestQueue = Volley.newRequestQueue(this);
		ByteArrayRequest byteArrayRequest = new ByteArrayRequest(Request.Method.GET, "https://gdata.youtube.com/feeds/api/videos?q=surfing&v=2&alt=jsonc&max-results=1", byteListener, error);
		
		requestQueue.add(byteArrayRequest);
	} // end method onCreate

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	} // end method onCreateOptionsMenu
		    
	
	ByteArrayResponseListener byteListener = new ByteArrayResponseListener(){

		@Override
		public void onByteArrayResponse(byte[] response) {
			String text = response.toString();
		    textView.setText(text);
		} // end method onByteArrayResponse
	}; // end ByteArrayResponseListener
	
		        
	ErrorListener error = new ErrorListener(){
		                
		@Override
		public void onErrorResponse(VolleyError error) {
		// TODO Auto-generated method stub
		} // end method onErrorResponse
	}; // end ErrorListener
		        
		  
	public interface ByteArrayResponseListener{
		                
		public void onByteArrayResponse(byte[] response);
	} // end interface ByteArrayResponseListener

} // end Class MainActivity
