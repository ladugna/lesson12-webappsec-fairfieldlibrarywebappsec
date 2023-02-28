package edu.miu.cs.cs425.fairfieldlibraryapp.config;

import edu.miu.cs.cs425.fairfieldlibraryapp.service.impl.FairfieldLibraryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class FairfieldLibraryWebSecurityConfig {

    private FairfieldLibraryUserDetailsService userDetailsService;

    public FairfieldLibraryWebSecurityConfig(FairfieldLibraryUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/resources/static/**").permitAll()
                .requestMatchers("/images/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/secured/**").hasRole("ADMIN")
                .requestMatchers("/secured/sysadmin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login");
                // TODO on Monday
        return httpSecurity.build();
    }
}
