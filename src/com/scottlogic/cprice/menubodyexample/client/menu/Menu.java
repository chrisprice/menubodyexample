package com.scottlogic.cprice.menubodyexample.client.menu;

import java.util.Arrays;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.web.bindery.event.shared.EventBus;
import com.scottlogic.cprice.menubodyexample.client.places.PlaceA;
import com.scottlogic.cprice.menubodyexample.client.places.PlaceB;

public class Menu extends Composite {

	public Menu(final PlaceController pc, EventBus eb) {

		CellList<String> cellList = new CellList<String>(new TextCell());

		ListDataProvider<String> listDataProvider = new ListDataProvider<String>(Arrays.asList("A", "B"));
		listDataProvider.addDataDisplay(cellList);

		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
		cellList.setSelectionModel(selectionModel);

		// listen for celllist events
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				if (selectionModel.getSelectedObject().equals("A")) {
					pc.goTo(new PlaceA());
				} else if (selectionModel.getSelectedObject().equals("B")) {
					pc.goTo(new PlaceB());
				}
			}
		});

		// listen for place change events
		eb.addHandler(PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler() {

			@Override
			public void onPlaceChange(PlaceChangeEvent event) {
				if (event.getNewPlace() instanceof PlaceA) {
					selectionModel.setSelected("A", true);
				} else if (event.getNewPlace() instanceof PlaceB) {
					selectionModel.setSelected("B", true);
				}
			}

		});

		initWidget(cellList);
	}

}
