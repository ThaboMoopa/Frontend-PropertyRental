//package com.rentalproperty.Security;
//
//import com.rentalproperty.Services.Impl.ResidentServiceImpl;
//import com.rentalproperty.domain.Resident;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.stereotype.Component;
//
//
//@Configuration
//
////The WebSecurityConfig class is annotated with
//// @EnableWebSecurity to enable Spring Security’s web security support and provide the Spring MVC integration
//@EnableWebSecurity
//
////extends WebSecurityConfigurerAdapter and overrides a
//// couple of its methods to set some specifics of the web security configuration.
//
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//    //@Autowired
//    //private ResidentServiceImpl residentService;
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
////        httpSecurity
////            .authorizeRequests().antMatchers("/address/addAdress").permitAll().anyRequest().authenticated();
//
//
//        //Our recommendation is to use CSRF protection for any request that could be processed by a browser by normal users.
//        // If you are only creating a service that is used by non-browser clients,
//        // you will likely want to disable CSRF protection
//        httpSecurity.
//                authorizeRequests().antMatchers("/resident/addResident")
//                .hasRole("USER").and().csrf().disable().headers().frameOptions(); //.httpStrictTransportSecurity();
//
////         httpSecurity
////                .authorizeRequests().antMatchers("/address/deleteAddress").denyAll();
////
////        httpSecurity.httpBasic().and().authorizeRequests().antMatchers("/address/**")
////                .hasRole("USER").and().csrf().disable().headers().frameOptions().disable();
//    }
//
//
//
//    @Autowired
//    //the configureGlobal(AuthenticationManagerBuilder) method, it sets up an in-memory user store with a single user.
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//               // and().withUser("admin").password("admin").roles("ADMIN");
//    }
//
//
//
//}
