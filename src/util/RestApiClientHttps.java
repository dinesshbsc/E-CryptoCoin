package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RestApiClient class to execute rest apiactions
 */
public class RestApiClientHttps {
	static final Logger logger = LoggerFactory.getLogger(RestApiClientHttps.class);

	/**
	 * Method to restrict creating new object for this class.
	 */
	private RestApiClientHttps() {

	}

	public static String processRestRequest(String https_url) {
		String response = null;
		try {
			URL url = new URL(https_url);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			response = getStringFromInputStream(con.getInputStream());
		} catch (IOException e) {
			logger.error("An exception while executing rest api requrest: " + e.getMessage(), e);
			System.out.println("An exception while executing rest api requrest: " + e.getMessage());
		}
		return response;
	}

	/**
	 * Method to convert input stream to string
	 * 
	 * @param is
	 *            input stream object
	 * @return
	 */
	private static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		return sb.toString();
	}

}
