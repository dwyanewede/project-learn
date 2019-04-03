package com.learn.demo.ibatisExt;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @ClassName: BaseDao
 * @Description: 数据库执行类
 * @Author: 尚先生
 * @CreateDate: 2019/4/3 19:41
 * @Version: 1.0
 */
public class BaseDao {

    @Autowired
    private SqlMapClient sqlMapClient;

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("extSqlExecutor")
    private SqlExecutor sqlExecutor;

    // 容器启动完成，执行设置自定义executor
    @PostConstruct
    public void initalizeExtexecutor(){
        if (null != sqlExecutor){
            if (sqlMapClient instanceof SqlMapClientImpl){
                SqlMapClientImpl client = (SqlMapClientImpl) this.sqlMapClient;
                ReflectUtils.setFieldValue(client.getDelegate(), "sqlExecutor",SqlExecutor.class,sqlExecutor);
            }
        }
    }
}
