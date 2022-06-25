package com.tta.app.security.utils;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.tta.app.exceptions.AuthorizationException;

@Component
public class JwtUtil {

    @Value("${jwt.token.validity}")
    public long tokenValidity;

    @Value("${jwt.signing.key}")
    public String signingKey;

    @Value("${jwt.authorities.key}")
    public String authoritiesKey;

    public String extractUsernameFromToken(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractRoleFromToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        String role = claims.get(authoritiesKey).toString();

        return role;
    }

    public String extractCustomClaimFromToken(String token, String claim) {
        Claims claims = getAllClaimsFromToken(token);

        return claims.get(claim).toString();
    }

    public String extractRoleFromSecurityContextHolder() {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if(authorities.isEmpty()) {
            throw new AuthorizationException();
        }

        String role = authorities.iterator().next().toString();
        return role;
    }

    public Date extractExpirationDateFromToken(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        Date expiration = extractExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(Authentication authentication, String username, String id) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(username)
                .claim("Id", id)
                .claim(authoritiesKey, authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidity*1000))
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        if (userDetails == null) {
            return false;
        }

        String username = extractUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public UsernamePasswordAuthenticationToken getAuthenticationToken(final String token, final UserDetails userDetails) {

        JwtParser jwtParser = Jwts.parser().setSigningKey(signingKey);

        Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

        Claims claims = claimsJws.getBody();

        List<SimpleGrantedAuthority> authorities =
                Arrays.stream(claims.get(authoritiesKey).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }
}
