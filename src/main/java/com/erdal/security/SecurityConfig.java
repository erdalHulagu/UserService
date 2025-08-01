package com.erdal.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// Method-level security açmak için
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // Bu sınıf bir configuration (ayar) sınıfıdır
@EnableMethodSecurity // @PreAuthorize, @Secured gibi method-level güvenliği aktif eder
public class SecurityConfig {

    @Bean // Spring context'e SecurityFilterChain bean'i ekler
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF korumasını kapat (stateless API + JWT ile çalışırken genelde gerekmez)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() // /api/auth/** altındaki endpoint'ler herkese açık (login, register gibi)
                .anyRequest().authenticated() // Diğer bütün istekler için kimlik doğrulaması gerekli (token vs.)
            );
        return http.build(); // HttpSecurity yapılandırmasını tamamla ve build et
    }

    @Bean // Şifreleri hash'lemek için BCrypt kullanırız
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Güçlü ve standart bir şifreleyici
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}