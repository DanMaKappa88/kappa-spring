package hu.flowacademy.kappaspring.reallife.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String fullName;

    // Mindig valamilyen kollekcio a tipusa
    // Általában List vagy Set
    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    private List<Blogpost> blogposts;
//    @OneToOne(mappedBy = "publisher")
//    private Blogpost blogposts;

//    @ManyToMany(mappedBy = "owners")
//    private List<Blogpost> ownedBlogposts;

//    @OneToMany(mappedBy = "user")
//    private List<BlogpostOwners> blogpostOwners;
}
