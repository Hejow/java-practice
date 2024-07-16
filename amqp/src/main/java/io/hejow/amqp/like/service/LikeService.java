package io.hejow.amqp.like.service;

import io.hejow.amqp.like.domain.LikeRepository;
import io.hejow.amqp.lock.Lockable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {
  private final LikeRepository likeRepository;

  public LikeService(LikeRepository likeRepository) {
    this.likeRepository = likeRepository;
  }

  @Lockable(key = Lockable.Key.LIKE)
  public void up(Long id) {
    var like = likeRepository.findById(id).orElseThrow();
    like.up();
  }

  @Transactional
  public synchronized void upSync(Long id) {
    var like = likeRepository.findById(id).orElseThrow();
    like.up();
  }
}
