package problems;

import runner.ProjectEulerRunner;

import java.util.LinkedList;

public class Problem014 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem014().run());
    }

    @Override
    public String run() {
        int result = longestCollatzChain(1000000);
        return Integer.toString(result);
    }

    private int longestCollatzChain(int limit)  {
        LinkedList<Long> list = new LinkedList<Long>();
        long length = 0;
        int result = 0;
        for (int j = 10; j < limit; j++) {
            long i = j;
            while (i != 1) {
                if (i % 2 == 0) {
                    i /= 2;
                } else {
                    i = (3 * i) + 1;
                }
                list.add(i);
            }
            if (list.size() > length) {
                length = list.size();
                result = j;
            }
            list.clear();
        }
        return result;
    }
}
