package com.dianping.daogen.java.parser;

import com.dianping.daogen.java.model.lang.statics.BlockList;
import lombok.Data;

import java.util.Stack;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class StateContext {

    private BlockList blockList;

    private TokenQueue tokenQueue;

    private Stack<State> stateStack;
}
