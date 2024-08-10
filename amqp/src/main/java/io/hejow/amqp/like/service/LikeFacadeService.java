package io.hejow.amqp.like.service;

import io.hejow.amqp.like.domain.LikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LikeFacadeService {
  private final LikeService likeService;
  private final LikeRepository likeRepository;

  public LikeFacadeService(LikeService likeService, LikeRepository likeRepository) {
    this.likeService = likeService;
    this.likeRepository = likeRepository;
  }

  @Transactional(readOnly = true)
  public int getCount(Long id) {
    var like = likeRepository.findById(id).orElseThrow();
    return like.getCount();
  }

  public int upAndRollback(Long id) {
    var like = likeRepository.findById(id).orElseThrow();
    likeService.up(like);
    like.reset();

    return like.getCount();
  }

  public int up(Long id) {
    var like = likeRepository.findById(id).orElseThrow();
    likeService.up(like);
    
    return like.getCount();
  }
}
