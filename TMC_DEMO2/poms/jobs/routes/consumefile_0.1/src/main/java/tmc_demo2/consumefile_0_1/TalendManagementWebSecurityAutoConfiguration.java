

package tmc_demo2.consumefile_0_1;

        import java.util.Properties;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
        import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration;
        import org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration;
        import org.springframework.boot.actuate.autoconfigure.jolokia.JolokiaEndpoint;
        import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
        import org.springframework.boot.actuate.health.HealthEndpoint;
        import org.springframework.boot.actuate.info.InfoEndpoint;
        import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusScrapeEndpoint;
        import org.springframework.boot.autoconfigure.AutoConfigureAfter;
        import org.springframework.boot.autoconfigure.AutoConfigureBefore;
        import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
        import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
        import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
        import org.springframework.boot.autoconfigure.security.SecurityProperties;
        import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
        import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
        import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
        import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Import;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@ConditionalOnClass(WebSecurityConfigurerAdapter.class)
@ConditionalOnMissingBean(WebSecurityConfigurerAdapter.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@AutoConfigureBefore(SecurityAutoConfiguration.class)
@AutoConfigureAfter({ HealthEndpointAutoConfiguration.class,
		InfoEndpointAutoConfiguration.class, WebEndpointAutoConfiguration.class,
		OAuth2ClientAutoConfiguration.class,
		OAuth2ResourceServerAutoConfiguration.class })
@Import(TalendManagementWebSecurityPrometheusConfigurerAdapter.class)
@EnableWebSecurity
public class TalendManagementWebSecurityAutoConfiguration {

}

class TalendManagementWebSecurityPrometheusConfigurerAdapter extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TalendManagementWebSecurityPrometheusConfigurerAdapter.class);

    @Value("${spring.security.user.name:#{null}}")
    private String springSecurityUserNameValue;

    @Value("${spring.security.user.password:#{null}}")
    private String springSecurityUserPasswordValue;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       String sringSecurityUserName = "spring.security.user.name";
       String sringSecurityUserPassword = "spring.security.user.password";

        if(springSecurityUserNameValue != null && !springSecurityUserNameValue.isEmpty()
                && springSecurityUserPasswordValue != null && !springSecurityUserPasswordValue.isEmpty() ) {
            logger.warn("spring security username and password are available");
            super.configure(auth);
        }else {
            logger.warn("spring security username and password are NOT available, generating");
            SecurityProperties.User user = new User();
            springSecurityUserNameValue =  springSecurityUserNameValue != null ? springSecurityUserNameValue : user.getName();
            springSecurityUserPasswordValue = springSecurityUserPasswordValue != null ? springSecurityUserPasswordValue : user.getPassword();

            logger.warn(String.format(
                    "%n%nUsing generated security credentials %nusername: %s %npassword: %s%n%nThis generated password is for development use only. "
                            + "%nYour security configuration must be updated before running your application in "
                            + "production.%n",
                            springSecurityUserNameValue,
                            springSecurityUserPasswordValue));

            auth
            .inMemoryAuthentication()
            .withUser(user.getName()).password("{noop}"+user.getPassword()).roles("USER");
        }
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .httpBasic()
        .and()
        .authorizeHttpRequests()
        .requestMatchers(EndpointRequest.to(HealthEndpoint.class, InfoEndpoint.class,PrometheusScrapeEndpoint.class,JolokiaEndpoint.class))
        .authenticated()
        .and()
        .formLogin()
    		
                .and()
				.authorizeHttpRequests()
				.antMatchers("/**")
			.permitAll();
    }
}
