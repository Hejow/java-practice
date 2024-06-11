package hejow.java.practice.effectivejava.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CaseInsensitiveString {
    private final String str;

    public CaseInsensitiveString(String str) {
        this.str = Objects.requireNonNull(str);
    }

    //대칭성 위배
//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof CaseInsensitiveString){
//            return str.equalsIgnoreCase(((CaseInsensitiveString)o).str);
//        }
//        if (o instanceof String) {
//            return str.equalsIgnoreCase((String) o);
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) obj).str.equalsIgnoreCase(str);
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("hejow");
        String s = "hejow";

        cis.equals(s); // true
        s.equals(cis); // false

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        list.contains(s); // true or false
    }
}
