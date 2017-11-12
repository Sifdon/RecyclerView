package com.alin.recyclerview.data;

import java.util.List;

/**
 * Created by Alin on 11/12/2017.
 */

public interface DataSourceInterface {

    List<ListItem> getListOfData();


    ListItem createNewListItem();

    void deleteListItem(ListItem listItem);

    void inserListItem(ListItem temporaryListItem);

}
