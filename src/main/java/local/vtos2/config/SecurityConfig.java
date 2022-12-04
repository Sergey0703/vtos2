package local.vtos2.config;

import local.vtos2.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // private final AuthProviderImpl authProvider;

//    @Autowired
//    public SecurityConfig(AuthProviderImpl authProvider) {
//        this.authProvider = authProvider;
//    }

    private final PersonDetailsService personDetailsService;
    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService){
        this.personDetailsService=personDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        String[] staticResources  =  {
                "/css/**",
                "/images/**"
               };

                    http.csrf().disable()
                        .authorizeRequests()
                        .antMatchers(staticResources).permitAll()
                        .antMatchers("/auth/login","/auth/registration","/error").permitAll()
                        .anyRequest().authenticated()
                        .and()
                        .formLogin().loginPage("/auth/login")
                        .loginProcessingUrl("/process_login")
                        .defaultSuccessUrl("/",true)
                        .failureUrl("/auth/login?error");
    }


    //tweak authentication
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(personDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
