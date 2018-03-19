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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "zool.domain.dao.oapg",sqlSessionTemplateRef = "pgSqlSessionTemplate")
public class DBPgOA {

    @Bean(name = "pgDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oapg")
    @Primary
    public DataSource pgDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pgSqlSessionFactory")
    @Primary
    public SqlSessionFactory pgSqlSessionFactory(@Qualifier("pgDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/oapg/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "pgTransactionManager")
    @Primary
    public DataSourceTransactionManager pgTransactionManager(@Qualifier("pgDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "pgSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate pgSqlSessionTemplate(@Qualifier("pgSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
