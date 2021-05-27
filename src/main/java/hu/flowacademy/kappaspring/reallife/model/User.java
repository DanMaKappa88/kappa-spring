package hu.flowacademy.kappaspring.reallife.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.nio.file.AccessMode;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String username;
    private String fullName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private Role role;

    // Mindig valamilyen kollekcio a tipusa
    // Általában List vagy Set
    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    private List<Blogpost> blogposts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(this.role);
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
//    @OneToOne(mappedBy = "publisher")
//    private Blogpost blogposts;

//    @ManyToMany(mappedBy = "owners")
//    private List<Blogpost> ownedBlogposts;

//    @OneToMany(mappedBy = "user")
//    private List<BlogpostOwners> blogpostOwners;
}
