package hu.flowacademy.kappaspring.reallife.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN, ROLE_USER;
//    USER_UPDATE // Ez már nem lenne role, hanem authority, mivel nem ROLE-lal kezdődik a neve

    @Override
    public String getAuthority() {
        return this.name();
    }
}
