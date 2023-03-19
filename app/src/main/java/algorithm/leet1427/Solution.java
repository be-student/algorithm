package algorithm.leet1427;

public class Solution {

}

class BrowserHistory {

    private final String[] history = new String[10000];
    private int current;
    private int last;

    public BrowserHistory(String homepage) {
        history[current] = homepage;
    }

    public void visit(String url) {
        current++;
        history[current] = url;
        last = current;
    }

    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history[current];
    }

    public String forward(int steps) {
        current = Math.min(last, current + steps);
        return history[current];
    }
}
