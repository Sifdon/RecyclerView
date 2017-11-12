package com.alin.recyclerview;

import com.alin.recyclerview.data.DataSourceInterface;
import com.alin.recyclerview.data.ListItem;
import com.alin.recyclerview.logic.Controller;
import com.alin.recyclerview.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

/**
 * Test Driven Development Bonus: Before writing the methods themselves (a.k.a. writing the
 * "Implementation"), I've written some Unit Tests. In a nutshell, these Tests help me to figure out
 * what methods and logic I'll need for the class which I'm testing. This process is slow at first,
 * but once you become fast at writing Tests, you'll start to see how they actually help you write
 * Better Code, often at a Faster Pace.
 * <p>
 * I have some Videos on this topic on my youtube channel. Check them out for more info.
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerTestUnitTest {

    //We technically could've just used the FakeDataSource here, but you don't always want to use
    //Mocks over Fakes and vice versa. Depends on your use case.
    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    Controller controller;

    /**
     * Often times we'll want data to run our tests against. I like to define such Data as a series
     * of Static variables in the Test file itself for convenience.
     */
    private static final ListItem testItem = new ListItem(
            "6:30AM 06/01/2017",
            "Look at Open Source Projects",
            R.color.RED
    );

    @Before
    public void  setUpTest(){
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);
    }


    @Test
    public void onGetListDataSuccessful() throws Exception {
        //Since we require a List<ListItem> to be returned by the dataSource, we can define it here:
        List<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        //This is where we tell our "Mocks" what to do when our Controller talks to them. Since they
        //aren't real objects, we must tell them exactly what to do if we want responses from them.
        Mockito.when(dataSource.getListOfData()).thenReturn(listOfData);

        //This is the method we are testing
        //Call the method we are testing
        controller.getListFromDataSource();

        //Check how the Tested Class responds to the data it receives
        //or test it's behaviour
        Mockito.verify(view).setUpAdapterAndView(listOfData);
    }

    @Test
    public void onListItemClicked() {
        controller.onListItemClick(testItem);

        Mockito.verify(view).startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResources());
    }
}