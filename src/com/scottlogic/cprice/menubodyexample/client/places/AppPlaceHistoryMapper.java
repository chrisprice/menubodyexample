package com.scottlogic.cprice.menubodyexample.client.places;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ PlaceA.Tokenizer.class, PlaceB.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
