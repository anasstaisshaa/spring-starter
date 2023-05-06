package edu.AnastasiiaTkachuk.spring.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
@ConfigurationProperties(prefix = "db")
public class DatabaseProperties {
    private String username;
    private String password;
    private String driver;
    private String url;
    private String host;
    private PoolProperties pool;
    private List<PoolProperties> pools;
    private Map<String, Object> properties;

    @NoArgsConstructor
    @Data
    public static class PoolProperties{
        private Integer size;
        private Integer timeout;
    }

}
