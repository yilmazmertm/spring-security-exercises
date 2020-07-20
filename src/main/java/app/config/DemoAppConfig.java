package app.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "app")
@PropertySource("classpath:persistance-mysql.properties")
public class DemoAppConfig {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private Environment env;


    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource securityDataSource(){
        // create a connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
        // set the jdbc driver
        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.Driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        // log the connection
        logger.info(">>jdbc url : " + env.getProperty("jdbc.url") + " --- ");
        logger.info(">>jdbc user : " + env.getProperty("jdbc.user") + " --- ");
        // set the database
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        // set the connection pool
        return securityDataSource;
    }
    private int getIntProperty(String propName){
        String propVal = env.getProperty(propName);

        int intPropVal = Integer.parseInt(propVal);
        return intPropVal;
    }
}
