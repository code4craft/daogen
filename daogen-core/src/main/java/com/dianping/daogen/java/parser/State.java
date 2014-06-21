package com.dianping.daogen.java.parser;

import com.dianping.daogen.java.model.lang.statics.Block;
import com.dianping.daogen.java.model.lang.statics.Import;
import com.dianping.daogen.java.model.lang.statics.Package;

/**
 * @author code4crafer@gmail.com
 */
public enum State {
    INIT {
        @Override
        public State transduce(StateContext stateContext) {
            consumeWhitSpace(stateContext);
            if (stateContext.getTokenQueue().matches("//") || stateContext.getTokenQueue().matches("/*")) {
                stateContext.getStateStack().push(this);
                return IN_COMMENT;
            }
            if (stateContext.getTokenQueue().matchChomp("package")) {
                stateContext.getTokenQueue().consumeWhitespace();
                String packageName = stateContext.getTokenQueue().consumeTo(";");
                stateContext.getTokenQueue().consume(";");
                stateContext.getBlockList().addBlock(new Block(new Package(packageName), stateContext.getTokenQueue().getStringMarkToPos()));
                return IN_IMPORT;
            } else {
                return FAIL;
            }
        }
    },
    IN_IMPORT {
        @Override
        public State transduce(StateContext stateContext) {
            consumeWhitSpace(stateContext);
            if (stateContext.getTokenQueue().matches("//") || stateContext.getTokenQueue().matches("/*")) {
                stateContext.getStateStack().push(this);
                return IN_COMMENT;
            }
            if (stateContext.getTokenQueue().matchChomp("import")) {
                stateContext.getTokenQueue().consumeWhitespace();
                String packageName = stateContext.getTokenQueue().consumeTo(";");
                stateContext.getTokenQueue().consume(";");
                stateContext.getBlockList().addBlock(new Block(new Import(packageName), stateContext.getTokenQueue().getStringMarkToPos()));
                return IN_IMPORT;
            } else {

            }
            return super.transduce(stateContext);
        }
    },
    IN_COMMENT {

    },
    FINITE,
    FAIL;

    protected void consumeWhitSpace(StateContext stateContext) {
        stateContext.getTokenQueue().mark();
        stateContext.getTokenQueue().consumeWhitespace();
        stateContext.getBlockList().addBlankBlock(stateContext.getTokenQueue().getStringMarkToPos());
    }

    public State transduce(StateContext stateContext) {
        return FAIL;
    }
}
