package com.scottlogic.cprice.menubodyexample.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class PlaceA extends Place implements AppPlace {
	public static class Tokenizer implements PlaceTokenizer<PlaceA> {
		@Override
		public String getToken(PlaceA place) {
			return "";
		}

		@Override
		public PlaceA getPlace(String token) {
			return new PlaceA();
		}
	}

	@Override
	public String getId() {
		return "A";
	}
}
