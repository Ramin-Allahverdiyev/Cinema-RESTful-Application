package com.CinemaApp.config;

import com.CinemaApp.filter.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(CsrfConfigurer::disable);
        httpSecurity.authorizeHttpRequests(request->
                request.
                        requestMatchers(antMatcher("/api-docs/**"))
                        .permitAll()
                        .requestMatchers(antMatcher("/swagger-ui/**"))
                        .permitAll()
                        .requestMatchers(antMatcher(HttpMethod.POST,"/api/v1/cinema-app/auth/**"))
                        .permitAll()
                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/api/v1/cinema-app/auth/**"))
                        .hasAuthority("ADMIN")
                        .requestMatchers(antMatcher(HttpMethod.GET,"/api/v1/cinema-app/auth/**"))
                        .hasAuthority("ADMIN")
                        .requestMatchers(antMatcher("/h2-console/**"))
                        .permitAll()
                        .requestMatchers(antMatcher(HttpMethod.POST,"/api/v1/cinema-app/category/**"),antMatcher(HttpMethod.POST,"/api/v1/cinema-app/hall/**")
                                ,antMatcher(HttpMethod.POST,"/api/v1/cinema-app/movie/**"),antMatcher(HttpMethod.POST,"/api/v1/cinema-app/role/**")
                                ,antMatcher(HttpMethod.POST,"/api/v1/cinema-app/seat/**"),antMatcher(HttpMethod.POST,"/api/v1/cinema-app/stype/**")
                                ,antMatcher(HttpMethod.POST,"/api/v1/cinema-app/session/**"),antMatcher(HttpMethod.POST,"/api/v1/cinema-app/ticket/**"))
                        .hasAuthority("ADMIN")
                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/api/v1/cinema-app/category/**"),antMatcher(HttpMethod.DELETE,"/api/v1/cinema-app/hall/**")
                                ,antMatcher(HttpMethod.DELETE,"/api/v1/cinema-app/movie/**"),antMatcher(HttpMethod.DELETE,"/api/v1/cinema-app/role/**")
                                ,antMatcher(HttpMethod.DELETE,"/api/v1/cinema-app/seat/**"),antMatcher(HttpMethod.DELETE,"/api/v1/cinema-app/stype/**")
                                ,antMatcher(HttpMethod.DELETE,"/api/v1/cinema-app/session/**"),antMatcher(HttpMethod.DELETE,"/api/v1/cinema-app/ticket/**"))
                        .hasAuthority("ADMIN")
                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/v1/cinema-app/category/**"),antMatcher(HttpMethod.PUT,"/api/v1/cinema-app/hall/**")
                                ,antMatcher(HttpMethod.PUT,"/api/v1/cinema-app/movie/**"),antMatcher(HttpMethod.PUT,"/api/v1/cinema-app/role/**")
                                ,antMatcher(HttpMethod.PUT,"/api/v1/cinema-app/seat/**"),antMatcher(HttpMethod.PUT,"/api/v1/cinema-app/stype/**")
                                ,antMatcher(HttpMethod.PUT,"/api/v1/cinema-app/session/**"),antMatcher(HttpMethod.PUT,"/api/v1/cinema-app/ticket/**"))
                        .hasAuthority("ADMIN")
                        .requestMatchers(antMatcher(HttpMethod.GET,"/api/v1/cinema-app/category/**"),antMatcher(HttpMethod.GET,"/api/v1/cinema-app/hall/**")
                                ,antMatcher(HttpMethod.GET,"/api/v1/cinema-app/movie/**"),antMatcher(HttpMethod.GET,"/api/v1/cinema-app/role/**")
                                ,antMatcher(HttpMethod.GET,"/api/v1/cinema-app/seat/**"),antMatcher(HttpMethod.GET,"/api/v1/cinema-app/stype/**")
                                ,antMatcher(HttpMethod.GET,"/api/v1/cinema-app/session/**"),antMatcher(HttpMethod.GET,"/api/v1/cinema-app/ticket/**"))
                        .hasAnyAuthority("ADMIN","USER")
                        .anyRequest()
                        .authenticated())
                        .authenticationProvider(authenticationProvider)
                                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.headers((headers) -> headers.disable());
        return httpSecurity.build();
    }


}
