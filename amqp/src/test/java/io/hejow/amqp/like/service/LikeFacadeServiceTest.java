package io.hejow.amqp.like.service;

import io.hejow.amqp.like.domain.Like;
import io.hejow.amqp.like.domain.LikeRepository;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(HikariPoolConfig.class)
@SpringBootTest
class LikeFacadeServiceTest {

  @Autowired
  private LikeFacadeService likeFacadeService;
  @Autowired
  private LikeRepository likeRepository;

  private Like like;

  @BeforeEach
  void setup() {
    like = likeRepository.save(Like.init());
  }

  @Test
  void name() {
    var allById = likeRepository.findAllById(Collections.emptyList());

    System.out.println(allById);
    System.out.println(allById.isEmpty());
    Assertions.assertThat(allById).isEmpty();
  }

  @Test
  void 커넥션_풀_테스트() {
    // given

    // when
    likeFacadeService.upAndRollback(like.getId());

    // then
    var persisted = likeRepository.findById(like.getId()).orElseThrow();
    Assertions.assertThat(persisted.getCount()).isZero();
  }
}
