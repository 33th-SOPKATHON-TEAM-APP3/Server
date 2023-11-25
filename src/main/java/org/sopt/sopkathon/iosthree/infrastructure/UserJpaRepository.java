package org.sopt.sopkathon.iosthree.infrastructure;

import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.sopt.sopkathon.iosthree.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
	Optional<User> findByIosId(String iosId);

    default User findByIdOrThrow(Long userId){
        return findById(userId)
                .orElseThrow(()-> new EntityNotFoundException("해당하는 유저가 없습니다."));
    }
}
