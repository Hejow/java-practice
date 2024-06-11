package hejow.java.practice.etc.throwable;

public class BBQ {
    private int money = 10000;

    public FriedChicken 황금올리브_주문() {
        try {
            MarinatedChicken marinatedChicken = 닭을_염지한다();
            return marinatedChicken.튀긴다();
        } catch (NoChickenException e) {
            throw new FryFailException("튀길 염지된 닭이 없습니다.", e);
        }
    }

    private MarinatedChicken 닭을_염지한다() {
        try {
            Chicken chicken = 치킨을_사온다();
            return chicken.염지한다();
        } catch (NoMoneyException e) {
            throw new NoChickenException("염지할 닭이 없습니다.", e);
        }
    }

    private Chicken 치킨을_사온다() {
        if (this.money <= 15_000) {
            throw new NoMoneyException("닭을 살 돈이 없습니다.");
        }

        return new Chicken();
    }

    public static class FryFailException extends RuntimeException {
        public FryFailException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class NoChickenException extends RuntimeException {
        public NoChickenException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class NoMoneyException extends RuntimeException {
        public NoMoneyException(String message) {
            super(message);
        }
    }
}
