package com.pabwe.config;

import com.pabwe.web.LoggingAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
//    private DataSource dataSource;

    private final String USERS_QUERY = "select username, password, active from user where username=?";
    private final String ROLES_QUERY = "select u.username, r.role from user u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.username=?";

    private final String GURUS_QUERY = "select username, password, active from guru where username=?";
    private final String GURUROLES_QUERY = "select g.username, r.role from guru g inner join guru_role gr on (g.id = gr.guru_id) inner join role r on (gr.role_id=r.role_id) where g.username=?";

//    @Autowired
//    void injectDependency(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/dist/**", "/js/**").permitAll()
//                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/jurusan/**").hasRole("AKADEMIK")
                .antMatchers("/kelas/**").hasRole("AKADEMIK")
                .antMatchers("/subject/**").hasRole("AKADEMIK")
                .antMatchers("/semester/**").hasRole("AKADEMIK")
                .antMatchers("/request/siswa/**").hasRole("AKADEMIK")
                .antMatchers("/dataAkademikGuru/**").hasRole("AKADEMIK")
                .antMatchers("/dataAkademikSiswa/**").hasRole("AKADEMIK")
                .antMatchers("/daftarSiswa/**").hasRole("GURU")
                .antMatchers("/materi/x/eng/create/**").hasRole("GURU")
                .antMatchers("/materi/x/eng/edit/**").hasRole("GURU")
                .antMatchers("/materi/x/eng/delete/**").hasRole("GURU")
                .antMatchers("/pengumuman/create/**").hasAnyRole("GURU", "AKADEMIK")
                .antMatchers("/pengumuman/edit/**").hasAnyRole("GURU", "AKADEMIK")
                .antMatchers("/pengumuman/delete/**").hasAnyRole("GURU", "AKADEMIK")
                .antMatchers("/datadiri/**").hasAnyRole("GURU", "USER")
                .antMatchers("/x/eng**").hasAnyRole("GURU", "USER")
                .antMatchers("/x/neng**").hasAnyRole("GURU", "USER")

                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll().and().logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").permitAll()
                .and().exceptionHandling().accessDeniedHandler((AccessDeniedHandler) accessDeniedHandler);

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .usersByUsernameQuery(USERS_QUERY)
//                .authoritiesByUsernameQuery(ROLES_QUERY)
//                .dataSource(dataSource);
//    }

//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//        db.setDataSource(dataSource);
//        return db;
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("akademik").password("{noop}akademik123").roles("AKADEMIK")
                .and().withUser("user").password("{noop}user123").roles("USER")
                .and().withUser("guru").password("{noop}guru123").roles("GURU")
        ;;
    }
}
