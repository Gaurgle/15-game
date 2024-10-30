import java.util.ArrayList;
import java.util.List;

public class HelperUtil {

    private static final List<String> facit = new ArrayList<>(15);
    private static final List<String> oneFromFinished = new ArrayList<>(15);

    public static void setFacit() {
        for (int i = 1; i <= 16; i++) {
            if (i == 16) {
                facit.add("");
            } else {
                facit.add(String.valueOf(i));
            }
        }
    }

    public static void getFacit() {
        System.out.println(facit + " = facit:");
    }

    public static void setOneFromFinished() {
        for (int i = 0; i <= 16; i++) {
            if (i == 0) {
                oneFromFinished.add("");
            } else if (i <= 15) {
                oneFromFinished.add(String.valueOf(i));
            } else {
                oneFromFinished.set(Integer.parseInt(String.valueOf(14)), String.valueOf(15));
                oneFromFinished.set(Integer.parseInt(String.valueOf(15)), String.valueOf(14));
            }
        }
    }

    public static void getOneFromFinished() {
        System.out.println(oneFromFinished + " = one from finished:");
    }
}

