package com.ReferralUsingJpaAnotation.ReferralCodeProject.repository;

import com.ReferralUsingJpaAnotation.ReferralCodeProject.entity.RefferedFriends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RefferedFriendsRepo extends JpaRepository<RefferedFriends,Long> {
    List<RefferedFriends> findByRefferedByUserId(Long refferedByUserId);
}
