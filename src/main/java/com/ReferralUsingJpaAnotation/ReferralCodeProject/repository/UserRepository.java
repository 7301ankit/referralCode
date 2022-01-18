package com.ReferralUsingJpaAnotation.ReferralCodeProject.repository;

import com.ReferralUsingJpaAnotation.ReferralCodeProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByReferralCode(String referralCode);
}
