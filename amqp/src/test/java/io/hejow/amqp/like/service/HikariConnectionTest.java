package io.hejow.amqp.like.service;

import io.hejow.amqp.like.domain.Like;
import io.hejow.amqp.like.domain.LikeRepository;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@Import(HikariPoolConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HikariConnectionTest {
  @Autowired
  private LikeService likeService;
  @Autowired
  private LikeRepository likeRepository;

  @RepeatedTest(10)
  void 좋아요_100회_성공_히카리풀_공식_적용() throws InterruptedException {
    // given
    var like = likeRepository.save(Like.init());
    var count = 100;

    var executorService = Executors.newFixedThreadPool(10);
    var latch = new CountDownLatch(count);

    // when
    for (int i = 0; i < count; i++) {
      executorService.submit(() -> {
        try {
          likeService.up(like.getId());
        } finally {
          latch.countDown();
        }
      });
    }

    latch.await();

    // then
    var saved = likeRepository.findById(like.getId()).orElseThrow();
    assertThat(saved.getCount()).isEqualTo(count);
  }
}
