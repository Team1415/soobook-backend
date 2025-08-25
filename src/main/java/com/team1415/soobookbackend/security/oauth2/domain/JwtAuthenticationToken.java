package com.team1415.soobookbackend.security.oauth2.domain;

import com.team1415.soobookbackend.security.oauth2.domain.jwt_account.JwtAccount;
import java.util.Collection;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

@Getter
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final JwtAccount principal;

    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal represented
     *                    by this authentication object.
     * @param principal   jwtAccount
     */
    public JwtAuthenticationToken(
        Collection<? extends GrantedAuthority> authorities, JwtAccount principal) {
        super(authorities);
        this.principal = principal;
        this.setAuthenticated(true);
    }


    @Override
    public Object getCredentials() {
        return "";
    }
}
