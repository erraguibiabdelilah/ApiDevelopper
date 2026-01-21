package com.example.backend.security.config;

import com.example.backend.security.filter.JwtAuthenticationFilter;
import com.example.backend.security.filter.JwtAuthorisationFilter;
import com.example.backend.security.services.facad.UserService;
import com.example.backend.security.services.utils.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

    /**
     * Filtre JWT pour la validation des tokens sur chaque requête
     */
    @Bean
    public JwtAuthorisationFilter jwtAuthorisationFilter(UserService userDetailsService,
                                                         JwtUtils jwtUtils) {
        return new JwtAuthorisationFilter(userDetailsService, jwtUtils);
    }

    /**
     * Configuration de la chaîne de filtres de sécurité
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           AuthenticationManager authenticationManager,
                                           JwtAuthorisationFilter jwtAuthorisationFilter) throws Exception {
        // Filtre d’authentification JWT pour endpoints protégés seulement
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager);
        // IMPORTANT : NE PAS mettre /api_backend/auth/login ou /sign-in ici
        // On laisse ce filtre pour les endpoints futurs qui nécessitent un token
        jwtAuthenticationFilter.setFilterProcessesUrl("/api_backend/protected");


        http
                // Configuration du contexte de sécurité
                .securityContext(securityContext ->
                        securityContext.requireExplicitSave(false)
                )

                // Désactivation de CSRF (API REST stateless)
                .csrf(csrf -> csrf.disable())

                // Configuration de la gestion de session (stateless pour API REST)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Configuration des autorisations HTTP
                .authorizeHttpRequests(auth -> auth
                        // Endpoints publics
                        .requestMatchers( "/api_backend/auth/sign-in/").permitAll()
                        .requestMatchers("/api_backend/auth/login/").permitAll()     // création user

                        // authentification user
                        .requestMatchers("/api/admin/**").permitAll()
                        .requestMatchers("/actuator/health", "/actuator/info").permitAll()
                        .requestMatchers("/api/open/**").permitAll()
                        .requestMatchers("/api/admin/login").permitAll()


                        // Documentation Swagger
                        .requestMatchers(
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/webjars/**"
                        ).permitAll()

                        // Endpoints admin (décommentez selon vos besoins)
                        // .requestMatchers("/api/admin/**").hasAuthority("ADMIN")

                        // Tous les autres endpoints nécessitent une authentification
                        .anyRequest().authenticated()
                )

                // IMPORTANT: Ajout des deux filtres JWT
                // 1. Filtre d'authentification (pour le login)
                .addFilter(jwtAuthenticationFilter)
                // 2. Filtre d'autorisation (pour valider le token sur chaque requête)
                .addFilterBefore(jwtAuthorisationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}