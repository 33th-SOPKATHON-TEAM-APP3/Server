package org.sopt.sopkathon.iosthree.infrastructure;

import java.util.Optional;

import org.sopt.sopkathon.iosthree.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
	Optional<User> findByIosId(String iosId);
}
