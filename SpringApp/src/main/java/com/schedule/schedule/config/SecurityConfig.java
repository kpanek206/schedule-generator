
package com.schedule.schedule.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Configuration
@CrossOrigin
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user1")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin1")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers(HttpMethod.GET,"/tasks").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.GET,"/tasks/{taskId}").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.POST,"/tasks").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/tasks/{taskId}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/tasks/{taskId}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "//schedule/solve").hasAnyRole("USER","ADMIN")
                .anyRequest().hasRole("ADMIN")
                .and()
                .csrf().disable();
    }
}

