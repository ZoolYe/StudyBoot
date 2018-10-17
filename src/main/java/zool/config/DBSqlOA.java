package zool.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "zool.domain.dao.oasqlserver",sqlSessionTemplateRef = "sqlSessionTemplate")
public class DBSqlOA {

    @Bean(name = "oaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oasqlserver")
    public DataSource oaDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oaSqlSessionFactory")
    public SqlSessionFactory oaSqlSessionFactory(@Qualifier("oaDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/oasqlserver/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "oaTransactionManager")
    public DataSourceTransactionManager oaTransactionManager(@Qualifier("oaDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("oaSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
