package ru.deevddenis.likeserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.deevddenis.likeserver.model.Like;
import ru.deevddenis.likeserver.repository.LikeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    public final LikeRepository likeRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void incrementLikeAndView(@NonNull String name) {
        Optional<Like> likeOptional = likeRepository.findLikeByName(name);

        Like like;
        if (likeOptional.isEmpty()) {
            like = Like.builder()
                    .name(name)
                    .likeCount(1L)
                    .viewCount(1L)
                    .build();
        } else {
            like = likeOptional.get();
            like.increment();
        }

        likeRepository.save(like);
    }
}
