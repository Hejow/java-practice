package io.hejow.amqp.like.service;

import io.hejow.amqp.like.domain.Like;
import io.hejow.amqp.like.domain.LikeRepository;
import io.hejow.amqp.lock.Lockable;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
  private final LikeRepository likeRepository;

  public LikeService(LikeRepository likeRepository) {
    this.likeRepository = likeRepository;
  }

  @PostConstruct
  void setup() {
    likeRepository.save(Like.init());
  }

  @Lockable(key = Lockable.Key.LIKE)
  public void up(Long id) {
    var like = likeRepository.findById(id).orElseThrow();
    like.up();
  }

  @Lockable(key = Lockable.Key.LIKE)
  public void up(Like like) {
    like.up();
  }

  public synchronized void upSync(Long id) {
    var like = likeRepository.findById(id).orElseThrow();
    like.up();
  }
}
