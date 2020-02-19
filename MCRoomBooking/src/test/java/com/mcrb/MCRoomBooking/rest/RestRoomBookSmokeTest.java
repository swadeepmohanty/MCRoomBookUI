package com.mcrb.MCRoomBooking.rest;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class RestRoomBookSmokeTest {

    @Test
    public void whenDeployed_TheWebsiteIsReachable() throws IOException {
        URL url = new URL("http://localhost:4200/admin/rooms");
        URLConnection connection = url.openConnection();
        assertThat(connection.getContent(),notNullValue());
    }
}
