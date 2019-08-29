package com.aldar.java.task.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooksParametersTest {

    @Test
    public void shouldBuilderParams() {
        BooksParameters parameters = BooksParameters.builderParams("Any String", 3);

        assertEquals("Any String", parameters.getQ());
        assertEquals("books", parameters.getPrintType());
        assertEquals(3, parameters.getMaxResults().intValue());
    }
}