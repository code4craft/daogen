package com.dianping.daogen.generator;

import com.dianping.daogen.GeneratorContext;

/**
 * @author code4crafer@gmail.com
 */
public interface Generator<T> {

    public T generate(GeneratorContext generatorContext);
}
