import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        System.out.println("Hello, " + hostname);
    }

    public static List<Integer> filterList(List<Object> list) {
        return list.stream()
                .filter(e -> e instanceof Integer)
                .map(e -> (Integer) e)
                .collect(Collectors.toList());
    }

    public static String[] stringToArray(String s) {
        if (s == null || s.isEmpty()) {
            return new String[0];
        }
        return s.split(" ");
    }

    public int sum(List<?> mixed) {
        return mixed.stream()
                .mapToInt(e -> {
                    if (e instanceof String) {
                        return Integer.parseInt((String) e);
                    } else if (e instanceof Integer) {
                        return (Integer) e;
                    } else if (e instanceof Double) {
                        return ((Double) e).intValue();
                    } else if (e instanceof Long) {
                        return ((Long) e).intValue();
                    } else {
                        throw new IllegalArgumentException("Element of unsupported type: " + e.getClass().getName());
                    }
                })
                .sum();
    }

    public static int[] digitize(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        return new StringBuilder().append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static int[] digitize2(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        return new StringBuilder().append(n)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static int cockroachSpeed(double x) {
        if (x < 0) {
            return 0;
        }
        return (int) Math.floor(x * 100000 / 3600);
    }

    public static String printerError(String s) {

        return s.chars().filter(c -> c > 'm').count() + "/" + s.length();
    }

}