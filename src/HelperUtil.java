import java.util.ArrayList;
import java.util.List;

public class HelperUtil {

    private static final List<String> facit = new ArrayList<>(15);

    public static void setFacit() {
        for (int i = 1; i <= 16; i++) {
            if (i == 16) {
                facit.add("");
            } else {
                facit.add(String.valueOf(i));
            }
        }
    }

    public static List<String> getFacit() {
        return facit;
    }
}