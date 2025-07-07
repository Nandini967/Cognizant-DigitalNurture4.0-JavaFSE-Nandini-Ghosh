package com.example;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Mock ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Inject into service
        MyService service = new MyService(mockApi);

        // Step 3: Call the method
        service.fetchData();

        // Step 4: Verify the method was called
        verify(mockApi).getData();
    }
}
