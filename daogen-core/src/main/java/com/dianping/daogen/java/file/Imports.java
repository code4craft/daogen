package com.dianping.daogen.java.file;

import com.dianping.daogen.java.model.lang.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author code4crafer@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Imports {

    private Set<String> imports = new LinkedHashSet<String>();

    public static Imports merge(Imports... manyImports) {
        Set<String> mergedImportSet = new HashSet<String>();
        for (Imports imports : manyImports) {
            mergedImportSet.addAll(imports.getImports());
        }
        return new Imports(mergedImportSet);
    }

    public Imports merge(String... manyImports) {
        Set<String> mergedImportSet = this.getImports();
        for (String imports : manyImports) {
            if (needImport(imports)) {
                mergedImportSet.add(imports);
            }
        }
        return this;
    }

    public Imports merge(List<? extends Type> types) {
        Set<String> mergedImportSet = this.getImports();
        for (Type type : types) {
            if (needImport(type.getTypeFullName())) {
                mergedImportSet.add(type.getTypeFullName());
            }
        }
        return this;
    }

    public static Imports create(List<? extends Type> types){
        Set<String> mergedImportSet = new LinkedHashSet<String>();
        for (Type type : types) {
            if (needImport(type.getTypeFullName())) {
                mergedImportSet.add(type.getTypeFullName());
            }
        }
        return new Imports(mergedImportSet);
    }

    protected static boolean needImport(String imports) {
        if (imports == null) {
            return false;
        }
        if (imports.startsWith("java.lang")) {
            return false;
        }
        return true;
    }

}
