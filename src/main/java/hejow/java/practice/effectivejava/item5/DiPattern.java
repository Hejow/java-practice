package hejow.java.practice.effectivejava.item5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Dictionary {}

public class DiPattern {
    // 정적 클래스
//    public class SpellChecker {
//        private static final Dictionary dictionary = new Dictionary();
//
//        private SpellChecker() { }
//
//        public static boolean isValid(String word) { return false; };
//        public static List<String> suggestions(String typo) { return new ArrayList<>(); }
//    }

    // 싱글톤 객체
//    public class SpellChecker {
//        private final Dictionary dictionary = new Dictionary();
//
//        private SpellChecker() { }
//        public static SpellChecker INSTANCE = new SpellChecker(...);
//
//        public boolean isValid(String word) { return false; };
//        public List<String> suggestions(String typo) { return new ArrayList<>(); }
//    }

    public class SpellChecker {
        private final Dictionary dictionary;

        public SpellChecker(Dictionary dictionary) {
            this.dictionary = Objects.requireNonNull(dictionary);
        }

        public boolean isValid(String word) { return false; };
        public List<String> suggestions(String typo) { return new ArrayList<>(); }
    }
}
