package io.hejow.amqp.config;

public class MessageQueueProperties {

  private MessageQueueProperties() {
  }

  public static final String DEAD_MESSAGE_QUEUE = "dead-message-queue";
  public static final String DEAD_MESSAGE_EXCHANGE = "dead-message-exchange";

  public static final String COUPON_KEY = "coupon-key";
  public static final String COUPON_QUEUE = "coupon-queue";
  public static final String COUPON_EXCHANGE = "coupon-exchange";

  public static final String DIRECT_KEY = "direct-key";
  public static final String DIRECT_QUEUE = "direct-queue";
  public static final String DIRECT_EXCHANGE = "direct-exchange";

  public static final String FANOUT_QUEUE = "fanout-queue";
  public static final String FANOUT_QUEUE2 = "fanout-queue2";
  public static final String FANOUT_EXCHANGE = "fanout-exchange";

}
