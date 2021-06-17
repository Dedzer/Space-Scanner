package vshchur.com.spaceScanner.config.filter;

import org.springframework.web.filter.GenericFilterBean;
import vshchur.com.spaceScanner.util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AuthorizationFilter extends GenericFilterBean {

    private final JwtUtil jwtUtil;

    public AuthorizationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Long userId = jwtUtil.retrieveUserId(getToken(request));
        if (userId == null) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        chain.doFilter(request, response);
    }

    private Optional<String> getToken(ServletRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        return Optional.ofNullable(httpRequest.getHeader("Authorization"));
    }
}
