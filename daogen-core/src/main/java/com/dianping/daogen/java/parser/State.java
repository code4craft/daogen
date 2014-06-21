package com.dianping.daogen.java.parser;

import com.dianping.daogen.java.file.BlockList;

/**
 * @author code4crafer@gmail.com
 */
public enum State {
    INIT {
        @Override
        public State transduce(BlockList blockList, TokenQueue tokenQueue) {
            tokenQueue.consumeWhitespace();
            return null;
        }
    };

    public abstract State transduce(BlockList blockList, TokenQueue tokenQueue);
}
