package org.sopt.sopkathon.iosthree.infrastructure;

import org.sopt.sopkathon.iosthree.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
