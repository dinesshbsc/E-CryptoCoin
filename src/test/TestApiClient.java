package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.tunyk.currencyconverter.BankUaCom;
import com.tunyk.currencyconverter.api.Currency;
import com.tunyk.currencyconverter.api.CurrencyConverter;
import com.tunyk.currencyconverter.api.CurrencyConverterException;

import dto.CurrencyResponse;
import dto.Ticker;
import main.RestApiClient;
import util.JaxbJsonParser;

public class TestApiClient {

	public static void main(String[] args) {

		String listOfCoins[] = "BTC,BCH,BCN,XRP".split(",");
		try {
			CurrencyConverter currencyConverter = new BankUaCom(Currency.USD, Currency.EUR);
			System.out.println(currencyConverter.convertCurrency(1f, Currency.USD, Currency.EUR));

		} catch (CurrencyConverterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


/*		for (String coin : listOfCoins) {
			String url = String.format("https://api.cryptonator.com/api/ticker/%s-USD", coin);
			Map<String, String> params = new HashMap<String, String>();
			String responseBodyString = RestApiClient.processRestRequest(url, params, false);
			try {
				CurrencyResponse currencyResponse = JaxbJsonParser.unmarshalJson(responseBodyString,
						CurrencyResponse.class, false);
				Ticker coinTicker = currencyResponse.getTicker();
				System.out.println(String.format("%s - %s", coinTicker.getBase(), coinTicker.getPrice()));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
*/	}

}
