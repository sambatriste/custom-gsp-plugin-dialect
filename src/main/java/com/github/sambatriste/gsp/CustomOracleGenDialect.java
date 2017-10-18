package com.github.sambatriste.gsp;

import jp.co.tis.gsp.tools.dba.dialect.ExtendedOracleGenDialect;

import java.sql.Timestamp;

public class CustomOracleGenDialect extends ExtendedOracleGenDialect {

    public CustomOracleGenDialect() {
        super();
        // 親クラスの設定を上書き
        columnTypeMap.put("timestamp", TIMESTAMP);
    }

    private static OracleColumnType TIMESTAMP =
            new OracleColumnType("timestamp($s)",
                                 Timestamp.class,
                                 false,
                                 null);  // Temporalの指定をしない
}
