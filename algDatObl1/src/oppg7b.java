public class oppg7b {
    public static String flett(String... s) {

        int storstelength = 0;

        for (int i = 0; i < s.length; i++) { //finner største string length i s Arrayet

            if (s[i].length() > storstelength) {

                storstelength = s[i].length();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= storstelength; i++) {

            for (int j = 0; j <= s.length - 1; j++) {

                if (i <= s[j].length()) {

                    sb.append( s[j].charAt( i - 1 ) );
                }
            }
        }
        return sb.toString();

    }
}
