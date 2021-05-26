package hu.flowacademy.kappaspring.reallife.repository;

import hu.flowacademy.kappaspring.reallife.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

//    @Query("select u from User as u inner join u.blogposts as b where b.title")
//    List<User> findUsersByBlogpostTitle(String title);

    @Query("update User u set u.fullName=?2 where u.id=?1")
    @Modifying // Kötelező, nélküle nem tudunk update műveletet végrehajtani
    void updateFullName(String id, String fullName);

}
