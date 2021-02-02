package com.yunhwan.security.repository;

import java.util.Optional;
import com.yunhwan.security.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);
}