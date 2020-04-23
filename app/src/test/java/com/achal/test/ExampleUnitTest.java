package com.achal.test;

import com.achal.test.model.Canada;
import com.achal.test.network.response.CanadaResponse;
import com.achal.test.network.retrofit.RetrofitRequest;
import com.achal.test.repository.CanadaArticleRepository;
import com.achal.test.view_model.CanadaArticleViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

import static junit.framework.TestCase.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private CanadaArticleViewModel viewModel;
    List<Canada> searchResults = new ArrayList<>();


    @Mock
    private CanadaArticleRepository repository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);// required for the "@Mock" annotations

        // Make presenter a mock while using mock repository and viewContract created above
        //  viewModel = Mockito.spy();
    }

   //This test is to check whether we get success response
    @SuppressWarnings("unchecked")
    @Test
    public void handleResponse_Success() {
        Response response = Mockito.mock(Response.class);
        CanadaResponse searchResponse = Mockito.mock(CanadaResponse.class);
        Mockito.doReturn(true).when(response).isSuccessful();
        Mockito.doReturn(searchResponse).when(response).body();

    }

//This is to check  that we are not getting failed response
    @Test
    public void handleResponse_Failure() {
        Response response = Mockito.mock(Response.class);
        Mockito.doReturn(false).when(response).isSuccessful();

    }

   //This test is to see that correct base url ois used
//    @Test
//    public void test_badseurl() {
//
//        assertEquals("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/",RetrofitRequest);
//
//    }


}