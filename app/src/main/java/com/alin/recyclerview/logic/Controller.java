package com.alin.recyclerview.logic;

import android.view.View;

import com.alin.recyclerview.data.DataSourceInterface;
import com.alin.recyclerview.data.ListItem;
import com.alin.recyclerview.view.ViewInterface;

/**
 * Created by Alin on 11/12/2017.
 */

public class Controller {

    private ListItem temporaryListItem;
    private int temporaryListItemPosition;

    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSourceInterface) {
        this.view = view;
        this.dataSource = dataSourceInterface;

        getListFromDataSource();

    }

    public void getListFromDataSource() {
        view.setUpAdapterAndView(
                dataSource.getListOfData()
        );
    }

    public void onListItemClick(ListItem selectedItem, View viewRoot) {
        view.startDetailActivity(
                selectedItem.getDateAndTime(),
                selectedItem.getMessage(),
                selectedItem.getColorResources(),
                viewRoot
        );
    }

    public void createNewListItem() {
        ListItem newItem = dataSource.createNewListItem();
        view.addNewListItemToView(newItem);
    }

    public void onListItemSwiped(int position, ListItem listItem) {
        //ensure that the view and data layers have consistent state
        dataSource.deleteListItem(listItem);
        view.deleteListItemAt(position);

        temporaryListItemPosition = position;
        temporaryListItem = listItem;

        view.showUndoSnackbar();

    }

    public void onUndoConfirmed() {
        if(temporaryListItem != null){
            //ensure View/Data consitency
            dataSource.inserListItem(temporaryListItem);
            view.insertListItemAt(temporaryListItemPosition, temporaryListItem);

            temporaryListItem = null;
            temporaryListItemPosition = 0;
        }else{

        }
    }

    public void onSnackbarTimeout() {
        temporaryListItem = null;
        temporaryListItemPosition = 0;
    }
}
