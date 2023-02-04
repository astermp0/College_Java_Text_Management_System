import java.util.HashMap;

public class Node {
    //HashMap Integer Represents How Many Times The
    //Character Has Been Found
    public HashMap<Character, Integer> data = new HashMap<>();
    public Node prev;
    public Node next;
    public int timesFound = 0;

    public Node() {
    }
    public Node(Character d) {
        if (d != null) {
            if (data.containsKey(d)) {
                timesFound++;
                data.replace(d, timesFound);
            } else {
                if(timesFound == 0)
                    timesFound++;
                data.put(d, timesFound);
            }

        }
    }

}
