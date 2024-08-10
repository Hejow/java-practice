package io.hejow.amqp.like.api;

import io.hejow.amqp.like.service.LikeFacadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LikeController {
  private final LikeFacadeService likeFacadeService;

  public LikeController(LikeFacadeService likeFacadeService) {
    this.likeFacadeService = likeFacadeService;
  }

  @GetMapping("/likes/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Map<String, Integer> getCount(@PathVariable Long id) {
    return Map.of("count", likeFacadeService.getCount(id));
  }

  @PostMapping("/likes/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Map<String, Integer> like(@PathVariable Long id) {
    return Map.of("count", likeFacadeService.up(id));
  }

  @PostMapping("/likes/{id}/rollback")
  @ResponseStatus(HttpStatus.OK)
  public Map<String, Integer> likeAndRollback(@PathVariable Long id) {
    return Map.of("count", likeFacadeService.upAndRollback(id));
  }
}
