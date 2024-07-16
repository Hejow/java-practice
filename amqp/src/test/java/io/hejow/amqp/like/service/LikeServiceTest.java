package io.hejow.amqp.like.service;

import io.hejow.amqp.like.domain.Like;
import io.hejow.amqp.like.domain.LikeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LikeServiceTest {

  @Autowired
  private LikeService likeService;
  @Autowired
  private LikeRepository likeRepository;

  private Like like;

  @BeforeEach
  void setUp() {
    like = likeRepository.save(Like.init());
  }

  @Test
  void 트랜잭션_커넥션_확인_테스트() {
    // given

    // when
    likeService.up(like.getId());

    // then
    var saved = likeRepository.findById(like.getId()).orElseThrow();
    assertThat(saved.getCount()).isEqualTo(1);
  }

  @RepeatedTest(10)
  void 좋아요_100회_성공() throws InterruptedException {
    // given
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

  @RepeatedTest(10)
  void 좋아요_100회_테스트_코드_sync() throws InterruptedException {
    // given
    var count = 100;

    var executorService = Executors.newFixedThreadPool(10);
    var latch = new CountDownLatch(count);

    // when
    for (int i = 0; i < count; i++) {
      executorService.submit(() -> {
        try {
          likeService.upSync(like.getId());
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
