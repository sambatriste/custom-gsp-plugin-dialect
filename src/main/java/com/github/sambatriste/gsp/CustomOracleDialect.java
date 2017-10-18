package com.github.sambatriste.gsp;

import jp.co.tis.gsp.tools.dba.dialect.OracleDialect;
import org.seasar.extension.jdbc.gen.dialect.GenDialectRegistry;

public class CustomOracleDialect extends OracleDialect {


    public CustomOracleDialect() {
        super();

        // 親クラスの設定を変更する。
        GenDialectRegistry.deregister(
                org.seasar.extension.jdbc.dialect.OracleDialect.class
        );
        GenDialectRegistry.register(
                org.seasar.extension.jdbc.dialect.OracleDialect.class,
                new CustomOracleGenDialect()
        );
    }
}
