package com.example.test2.Repository;

import com.example.test2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value="SELECT * FROM USER u WHERE u.user_Id=:userId", nativeQuery = true)
    User selectUserInfo(@Param("userId")String userId);


}
