package com.dianping.daogen.antlr;

import com.dianping.daogen.java.parser.TinyJavaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author code4crafer@gmail.com
 */
public class JavaParserTest {

    private InputStream resourceAsStream;

    @Before
    public void setUp() throws Exception {
        resourceAsStream = TinyJavaParser.class.getClassLoader().getResourceAsStream("Block.java.test");
    }

    @Test
    public void testParser() throws Exception {

        JavaLexer lexer = new JavaLexer(new ANTLRInputStream(resourceAsStream));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParserRuleContext tree = parser.compilationUnit();// parse

        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        ParseTreeListener extractor = new ParseTreeListener() {
            @Override
            public void visitTerminal(@NotNull TerminalNode node) {
                System.out.println(node);
            }

            @Override
            public void visitErrorNode(@NotNull ErrorNode node) {
                System.out.println(node);
            }

            @Override
            public void enterEveryRule(@NotNull ParserRuleContext ctx) {

            }

            @Override
            public void exitEveryRule(@NotNull ParserRuleContext ctx) {

            }
        };
        walker.walk(extractor, tree); // initiate walk of tree with listener
    }
}
