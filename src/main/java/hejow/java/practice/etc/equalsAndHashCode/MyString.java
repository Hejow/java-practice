package hejow.java.practice.etc.equalsAndHashCode;

public class MyString {
    private final String value;

    public MyString(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyString input) {
            return value.equalsIgnoreCase(input.value);
        }
        if (obj instanceof String str) {
            return value.equalsIgnoreCase(str);
        }
        return false;
    }
}
