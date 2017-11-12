package com.alin.recyclerview.view;

import android.view.View;

import com.alin.recyclerview.data.ListItem;

import java.util.List;

/**
 * Created by Alin on 11/12/2017.
 */

public interface ViewInterface {

    void startDetailActivity(String dateAndTime, String message, int colorResource, View viewRoot);

    void setUpAdapterAndView(List<ListItem> listOfData);

    void addNewListItemToView(ListItem newItem);

    void deleteListItemAt(int position);

    void showUndoSnackbar();

    void insertListItemAt(int temporaryListItemPosition, ListItem temporaryListItem);

}
