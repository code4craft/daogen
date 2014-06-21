package com.dianping.daogen.java.parser;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafer@gmail.com
 */
public class TokenQueueTest {

    @Test
    public void testMarkAndSubstring() throws Exception {
        String test = "123456789";
        TokenQueue tokenQueue = new TokenQueue(test);
        //123456789
        //^
        tokenQueue.consume();
        //123456789
        // ^
        tokenQueue.mark();

        for (int i = 0; i < 3; i++) {
            tokenQueue.consume();
        }
        //123456789
        // ^  ^
        assertThat(tokenQueue.getStringMarkToPos()).isEqualTo("234");

    }
}
