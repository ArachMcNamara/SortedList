import java.util.ArrayList;

public class SortedList {

    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String value) {
        int position = binarySearch(value);
        list.add(position, value);
    }

    public int binarySearch(String target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int compare = list.get(mid).compareTo(target);

            if (compare == 0) {
                return mid;
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public String search(String target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int compare = list.get(mid).compareTo(target);

            if (compare == 0) {
                return "Found \"" + target + "\" at index " + mid;
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "\"" + target + "\" not found. Would be inserted at index " + low;
    }

    public String displayList() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(i).append(": ")
                    .append(list.get(i))
                    .append("\n");
        }

        return sb.toString();
    }
}