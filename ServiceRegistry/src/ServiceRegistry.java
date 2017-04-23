import java.util.Iterator;
import java.util.List;
import java.util.Map;

import kr.ac.kaist.mms_client.*;

/* -------------------------------------------------------- */
/** 
File name : ServiceRegistry.java
Author : Jaehee Ha (jaehee.ha@kaist.ac.kr)
Creation Date : 2017-02-01
Version : 0.3.01
*/
/* -------------------------------------------------------- */

public class ServiceRegistry{
	
	public static void main(String args[]) throws Exception{
		String myMRN = "urn:mrn:smart-navi:device:msr1";
		//myMRN = args[0];
		int port = 8905;
		//port = Integer.parseInt(args[1]);

		MMSConfiguration.MMS_URL="127.0.0.1:8088";
		
		MMSClientHandler ch = new MMSClientHandler(myMRN);
		ch.setPort(port);
		//Request Callback from the request message
		ch.setRequestCallback(new MMSClientHandler.RequestCallback() {
			
			//it is called when client receives a message
			@Override
			public String respondToClient(Map<String,List<String>>  headerField, String message) {
				Iterator<String> iter = headerField.keySet().iterator();
				while (iter.hasNext()){
					String key = iter.next();
					System.out.println(key+":"+headerField.get(key).toString());
				}
				System.out.println(message);
				return "OK";
			}

			@Override
			public int setResponseCode() {
				// TODO Auto-generated method stub
				return 200;
			}
		});
	}
}
