public class oppg7a {
    public static String flett(String s, String t) {

        int k = Math.min( s.length(), t.length() );

        StringBuilder sp = new StringBuilder();

        for (int i = 0; i < k; i++) {

            sp.append( s.charAt( i ) ).append( t.charAt( i ) );
        }

        sp.append( s.substring( k ) ).append( t.substring( k ) );

        return sp.toString();
    }
}
