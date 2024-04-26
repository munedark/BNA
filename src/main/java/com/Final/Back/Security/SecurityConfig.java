package com.Final.Back.Security;

import com.Final.Back.Services.ServImpl.Authentifcation.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtRequestFilter   jwtRequestFilter;
    @Autowired
    private MyUserDetailsService myUserDetailsService;




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/operations/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMINISTRATEUR")
                .antMatchers("/gestionnaire/**").hasRole("GESTIONNAIRE")
                .antMatchers("/validateur/**").hasRole("VALIDATEUR")
                .antMatchers("/agent").hasAnyRole("ADMINISTARATEUR","GESTIONNAIRE","VALIDATEUR")
                .antMatchers("/client/**").hasRole("CLIENT")
                .antMatchers("/ws/**").permitAll() // Allow access to the WebSocket endpoint
                .anyRequest().authenticated().and()
                .exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        // Allow WebSocket handshake without authentication
        httpSecurity.headers().frameOptions().disable();}

}
