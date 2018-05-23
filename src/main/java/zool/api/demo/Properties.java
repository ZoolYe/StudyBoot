package zool.api.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.oapg")
public class Properties {

    private String jdbcUrl;
    private String driverClassName;

}
