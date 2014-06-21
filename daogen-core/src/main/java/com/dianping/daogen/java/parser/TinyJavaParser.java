package com.dianping.daogen.java.parser;

import com.dianping.daogen.java.model.lang.statics.BlockList;
import com.dianping.daogen.java.model.lang.statics.JavaFile;
import lombok.Setter;

import java.util.Stack;

/**
 * 极其简单的Java解析器，只解析到方法级别<br/>
 *
 * @author code4crafer@gmail.com
 */
public class TinyJavaParser {

    @Setter
    private TokenQueue sourceCode;

    @Setter
    private JavaFile javaFile;

    @Setter
    private State state = State.INIT;

    public BlockList parse() {
        BlockList blockList = new BlockList();
        StateContext stateContext = new StateContext();
        stateContext.setBlockList(blockList);
        stateContext.setTokenQueue(sourceCode);
        stateContext.setStateStack(new Stack<State>());
        while (state != State.FINITE && !sourceCode.isEmpty()) {
            state = state.transduce(stateContext);
            if (state == State.FAIL) {
                System.out.println(blockList);
                throw new IllegalArgumentException("Syntax error in " + sourceCode.getStringMarkToPos() + " >>" + sourceCode.remainder());
            }
        }
        if (state == State.FINITE && !sourceCode.isEmpty()) {
            blockList.addUnknownBlock(sourceCode.remainder());
        } else if (state != State.FINITE && sourceCode.isEmpty()) {
            throw new IllegalArgumentException("Syntax error! Incomplete source code!");
        }
        return blockList;
    }

}
