package ru.deevddenis.likeserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import ru.deevddenis.likeserver.model.Like;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Like> findLikeByName(String name);

}
