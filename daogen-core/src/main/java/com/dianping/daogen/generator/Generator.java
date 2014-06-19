package com.dianping.daogen.generator;

/**
 * @author code4crafer@gmail.com
 */
public interface Generator<T> {

    public T generate(GeneratorContext generatorContext);
}
