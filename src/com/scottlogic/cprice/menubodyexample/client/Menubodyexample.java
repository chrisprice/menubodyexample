package com.scottlogic.cprice.menubodyexample.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.scottlogic.cprice.menubodyexample.client.body.BodyActivityMapper;
import com.scottlogic.cprice.menubodyexample.client.menu.Menu;
import com.scottlogic.cprice.menubodyexample.client.places.AppPlaceHistoryMapper;
import com.scottlogic.cprice.menubodyexample.client.places.PlaceA;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Menubodyexample implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		EventBus eventBus = new SimpleEventBus();
		PlaceController placeController = new PlaceController(eventBus);

		FlowPanel appPanel = new FlowPanel();
		appPanel.add(new Menu(placeController, eventBus));
		SimplePanel bodyPanel = new SimplePanel();
		appPanel.add(bodyPanel);

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new BodyActivityMapper();
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(bodyPanel);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, new PlaceA());

		RootPanel.get().add(appPanel);
		// Goes to the place represented on URL else default place
		historyHandler.handleCurrentHistory();
	}
}
