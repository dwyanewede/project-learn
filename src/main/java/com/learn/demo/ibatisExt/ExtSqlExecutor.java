package com.learn.demo.ibatisExt;

import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
import com.ibatis.sqlmap.engine.scope.StatementScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName: ExtSqlExecutor
 * @Description: 自定义处理器
 * @Author: 尚先生
 * @CreateDate: 2019/4/3 19:28
 * @Version: 1.0
 */
@Component("extSqlExecutor")
public class ExtSqlExecutor extends SqlExecutor {

    private static final Logger logger = LoggerFactory.getLogger(ExtSqlExecutor.class);

    private static final String SQL_END_DELIMITER = ";";

    /**
     * 不跳过结果
     */
    public static final int NO_SKIPPED_RESULTS = 0;
    /**
     * 查询所有结果
     */
    public static final int NO_MAXIMUM_RESULTS = -999999;

    public void executeQuery(StatementScope statementScope, Connection conn, String sql, Object[] parameters, int skipResults, int maxResults, RowHandlerCallback callback) throws SQLException {
        if (skipResults != NO_SKIPPED_RESULTS || maxResults != NO_MAXIMUM_RESULTS){
            sql = getLimitSql(sql,skipResults,maxResults);
        }
        logger.info("自定义执行器，查询SQL：", new Object[]{sql});

    }

    /**
     * 拼接SQL
     * @param sql
     * @param offset
     * @param limit
     * @return
     */
    public String getLimitSql(String sql, int offset, int limit) {
        sql = trim(sql);
        StringBuffer sb = new StringBuffer(sql.length() + 20);
        sb.append(sql);
        if (offset > 0) {
            sb.append(" limit ").append(offset).append(',').append(limit)
                    .append(SQL_END_DELIMITER);
        } else {
            sb.append(" limit ").append(limit).append(SQL_END_DELIMITER);
        }
        return sb.toString();
    }

    /**
     * 根据结束符号截取SQL
     * @param sql
     * @return
     */
    private String trim(String sql) {
        sql = sql.trim();
        if (sql.endsWith(SQL_END_DELIMITER)) {
            sql = sql.substring(0, sql.length() - 1
                    - SQL_END_DELIMITER.length());
        }
        return sql;
    }
}
