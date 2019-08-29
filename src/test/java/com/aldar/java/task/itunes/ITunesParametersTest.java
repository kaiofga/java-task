package com.aldar.java.task.itunes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ITunesParametersTest {

    @Test
    public void shouldBuilderParams() {
        ITunesParameters parameters = ITunesParameters.builderParams("Any String", 3);

        assertEquals("music", parameters.getMedia());
        assertEquals("album", parameters.getEntity());
        assertEquals(3, parameters.getLimit().intValue());
        assertEquals("Any+String", parameters.getTerm());
    }
}