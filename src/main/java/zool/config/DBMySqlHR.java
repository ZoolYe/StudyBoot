package zool.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "zool.domain.dao.hrmysql",sqlSessionTemplateRef = "hrSqlSessionTemplate")
public class DBMySqlHR {

    @Bean(name = "hrDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hrmysql")
    public DataSource hrDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "hrSqlSessionFactory")
    public SqlSessionFactory hrSqlSessionFactory(@Qualifier("hrDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/hrmysql/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "hrTransactionManager")
    public DataSourceTransactionManager hrTransactionManager(@Qualifier("hrDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "hrSqlSessionTemplate")
    public SqlSessionTemplate hrSqlSessionTemplate(@Qualifier("hrSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
