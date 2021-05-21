package hu.flowacademy.kappaspring.reallife.repository;

import hu.flowacademy.kappaspring.reallife.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

//    @Query("select u from User as u inner join u.blogposts as b where b.title")
//    List<User> findUsersByBlogpostTitle(String title);

}
