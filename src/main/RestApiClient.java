package main;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

/**
 * RestApiClient class to execute rest apiactions
 */
public class RestApiClient {
  static final Logger logger = LoggerFactory.getLogger(RestApiClient.class);

  /**
   * Method to restrict creating new object for this class.
   */
  private RestApiClient() {

  }

  /**
   * Method to execute rest api post method actions
   * 
   * @param url
   *          to get access
   * @param params
   *          no of parameter to attach i post method
   * @return response as string
   */
  public static String processRestRequest(String url, Map<String, String> params,
      boolean logResponse) {
    String response = null;
    try {
      PostMethod postMethod = new PostMethod(url);
      Set<String> keys = params.keySet();
      for (String key : keys) {
        postMethod.addParameter(key, params.get(key));
      }
      HttpClient hc = new HttpClient();

      // proxy settings controlled by properties.
/*      if (ServerProperties.getRestApiClientProxyEnabled()) {
        String proxyHost = ServerProperties.getRestApiClientProxyHost();
        int proxyPort = ServerProperties.getRestApiClientProxyPort();
        if (!Util.isEmpty(proxyHost)) {
          hc.getHostConfiguration().setProxy(proxyHost, proxyPort);
        }
      }
*/
      hc.executeMethod(postMethod);
      response = getStringFromInputStream(postMethod.getResponseBodyAsStream());
      if (logResponse) {
        logger.info("JSON Response : " + response);
      }
    } catch (IOException e) {
      logger.error("An exception while executing rest api requrest: " + e.getMessage(), e);
    }
    return response;
  }

  /**
   * Method to convert input stream to string
   * 
   * @param is
   *          input stream object
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
