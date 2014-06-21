package com.dianping.daogen.java.model.lang.statics;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
@ToString
public class BlockList {

    @Getter
    private List<Block> blocks = new ArrayList<Block>();

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public void addUnknownBlock(String block) {
        blocks.add(new Block("Unknown", block));
    }

    public void addBlankBlock(String block) {
        blocks.add(new Block("Blank", block));
    }

}
