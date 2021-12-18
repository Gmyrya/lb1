public class Grammatic {
    public static void main(String[] args) {
        String[] lev = new String[]{"S", "S", "K", "KS", "K"};
        String[] prav = new String[]{"ab", "aKSb", "bSb", "b", "e"};
        int kz = 0, ks = 0, l = 0, pl = 0;

        for (int i = 0; i < lev.length; i++) {
            if (lev[i].length() <= prav[i].length()) {
                kz += 1;
            }
            int levCharUnicodeIndex = lev[i].charAt(0);
            if (lev[i].length() == 1 && levCharUnicodeIndex < 97 && levCharUnicodeIndex > 64) {
                ks += 1;
            }
            int s = 0, b;
            for (b = 0; b < prav[i].length(); b++) {
                int unicodeIndex = prav[i].charAt(b);
                if (unicodeIndex > 64 && unicodeIndex < 97 || unicodeIndex == 101) {
                    s += 1;
                }
            }
            b -= 1;
            if (s == 1) {
                l += 1;
            }
            String k = prav[i];
            int lastCharUnicodeIndex = k.charAt(k.length() - 1);
            if (lastCharUnicodeIndex < 97 && lastCharUnicodeIndex > 64 || prav[i].charAt(b) == 101) {
                pl += 1;
            }
        }

        if (kz == lev.length && ks == lev.length && l == lev.length && pl == lev.length) {
            System.out.println("праволинейная грамматика");
        }
        if (kz == lev.length && ks == lev.length && l == lev.length && pl < lev.length) {
            System.out.println("линейная грамматика");
        }
        if (kz == lev.length && ks == lev.length && l < lev.length && pl < lev.length) {
            System.out.println("контекстно-свободная грамматика");
        }
        if (kz == lev.length && ks < lev.length && l < lev.length && pl < lev.length) {
            System.out.println("контектно-зависимая грамматика");
        }
        if (kz < lev.length && ks < lev.length && l < lev.length && pl < lev.length) {
            System.out.println("грамматика общего вида");
        }
    }
}
