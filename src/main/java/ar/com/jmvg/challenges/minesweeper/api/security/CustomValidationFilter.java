package ar.com.jmvg.challenges.minesweeper.api.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 * This class is responsible to check the token received in the AUTHORIZATION header
 * not classy but effective.
 * 
 * */
public class CustomValidationFilter extends GenericFilterBean {


	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final Enumeration<String> headerNames = httpRequest.getHeaderNames();
        final String encodedToken = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (null == headerNames || null == encodedToken) {
        	SecurityContextHolder.getContext().setAuthentication(null);
        }else {
	        final String[] pieces = encodedToken.split(" ");
	        String b64payload = pieces[1];
	        
	        if(this.validate(b64payload)) {
	        	List<GrantedAuthority> authorities = new ArrayList<>();
	        	Authentication authenticated = new UsernamePasswordAuthenticationToken(encodedToken, encodedToken, authorities);
	        	authenticated.setAuthenticated(true);
	        	SecurityContextHolder.getContext().setAuthentication(authenticated);
	        	chain.doFilter(httpRequest, response);
	        } else {
	        	SecurityContextHolder.getContext().setAuthentication(null);
	        }
        }
	}

	private boolean validate(String b64payload) {
		// TODO Auto-generated method stub
		return false;
	}
}
