package test;

import java.io.IOException;

import dto.koinex.KoinexResponse;
import dto.koinex.Prices;
import dto.koinex.XRP;
import util.JaxbJsonParser;
import util.RestApiClientHttps;

public class TestApiClient {

	public static void main(String[] args) throws IOException {
		getKoinexResponseString();
	}

	public static void getKoinexResponseString() {
		String digiCurrencyUrl = "https://koinex.in/api/ticker";
		System.out.println(digiCurrencyUrl);
		String responseBodyString = RestApiClientHttps.processRestRequest(digiCurrencyUrl);
		System.out.println(responseBodyString);
		mars(responseBodyString);
	}

	public static void mars(String responseString) {
		KoinexResponse koinexResponse = null;
		try {
			koinexResponse = JaxbJsonParser.unmarshalJson(responseString, KoinexResponse.class, false);

			Prices price = koinexResponse.getPrices();
			System.out.println(String.format("***PRICES***\nXRP: %s\nETH: %s\nLTC: %s\nBTC: %s\nBCH: %s\n",
					price.getXRP(), price.getETH(), price.getLTC(), price.getBTC(), price.getBCH()));

			XRP xrp = koinexResponse.getStats().getXRP();
			printState(xrp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void printState(XRP xrp) {
		System.out.println(String.format(
				"***STATES [%S]***\nlast_traded_price: %s\nlowest_ask: %s\nhighest_bid: %s\nmin_24hrs: %s\nmax_24hrs: %s\nvol_24hrs: %s\n",
				xrp.getClass().getName(), xrp.getLastTradedPrice(), xrp.getLowestAsk(), xrp.getHighestBid(),
				xrp.getMin24hrs(), xrp.getMax24hrs(), xrp.getVol24hrs()));
	}

}
