package io.hejow.amqp.like.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "likes")
public class Like {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int count;

  protected Like() {
  }

  private Like(int count) {
    this.count = count;
  }

  public static Like init() {
    return new Like(0);
  }

  public void up() {
    this.count++;
  }

  public Long getId() {
    return id;
  }

  public int getCount() {
    return count;
  }

  public void reset() {
    this.count = 0;
  }
}
