package ar.com.jmvg.challenges.minesweeper.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

/**
 *
 * Filter class to validate tokens in requests 
 * @author Maxi Vega
 *
 */
@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

    	PreAuthTokenHeaderFilter filter = new PreAuthTokenHeaderFilter(HttpHeaders.AUTHORIZATION);
        
        filter.setAuthenticationManager(new AuthenticationManager() {
			
        	@Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String principal = (String) authentication.getPrincipal();
                
                if (null == principal){
                    throw new BadCredentialsException("token not found or not the expected value.");
                }
                
    	        final String[] pieces = principal.split(" ");
    	        String b64payload = pieces[1];
    	        //not a final implementation just to have something in place
    	        if(null != b64payload)
    	        	authentication.setAuthenticated(true);
                return authentication;
            }   
        });
    	
    	httpSecurity.antMatcher("/api/**")
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .addFilter(filter)
            .addFilterBefore(new ExceptionTranslationFilter(new Http403ForbiddenEntryPoint()), filter.getClass())
            .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/_ah/*","/api/login*");
    }
}