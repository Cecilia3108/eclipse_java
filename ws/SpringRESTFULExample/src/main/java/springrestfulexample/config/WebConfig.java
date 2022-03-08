package springrestfulexample.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "springrestfulexample.config" })
public class WebConfig extends WebMvcConfigurerAdapter {
 
 @Autowired
 DataSource dataSource;
 
 @Bean
 public NamedParameterJdbcTemplate geNamedParameterJdbcTemplate(){
  return new NamedParameterJdbcTemplate(dataSource);
 }
 
 @Bean
 public DataSource getDataSource() throws NamingException{
  JndiTemplate jndiTemplate = new JndiTemplate();
  DataSource dataSource = (DataSource) jndiTemplate.lookup("java:comp/env/jdbc/springmvc");
  
  return dataSource;
 }
 
}
