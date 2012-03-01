package com.scottlogic.cprice.menubodyexample.client.body;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.scottlogic.cprice.menubodyexample.client.places.PlaceA;
import com.scottlogic.cprice.menubodyexample.client.places.PlaceB;

public class BodyActivityMapper implements ActivityMapper {

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof PlaceA) {
			return new BodyActivityA();
		} else if (place instanceof PlaceB) {
			return new BodyActivityB();
		}
		return null;
	}

}
