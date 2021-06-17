package vshchur.com.spaceScanner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import vshchur.com.spaceScanner.config.filter.AuthorizationFilter;
import vshchur.com.spaceScanner.util.JwtUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtUtil jwtUtil;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .addFilterBefore(new AuthorizationFilter(jwtUtil), BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/airports")
                .antMatchers("/auth/login")
                .antMatchers("/flights/get")
                .antMatchers("/planets")
                .antMatchers("/tourists/reserve")
                .antMatchers("/user/register")
                .antMatchers("/flights/{flightId}/seat-codes")
                .antMatchers("/flights/{flightId}")
                .antMatchers("/shuttle");
    }
}
