package com.scottlogic.cprice.menubodyexample.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class PlaceB extends Place implements AppPlace {
	public static class Tokenizer implements PlaceTokenizer<PlaceB> {
		@Override
		public String getToken(PlaceB place) {
			return "";
		}

		@Override
		public PlaceB getPlace(String token) {
			return new PlaceB();
		}
	}

	@Override
	public String getId() {
		return "B";
	}
}
