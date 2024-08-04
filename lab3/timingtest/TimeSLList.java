package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import randomizedtest.AListNoResizing;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    private static void test(AList<Double> Time,AList<Integer> Ops,SLList<Integer> Test) {
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < 10000; i++) {
            Test.getLast();
        }
        Time.addLast(sw.elapsedTime());
        Ops.addLast(10000);
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> Time = new AList<>();
        AList<Integer> Ops = new AList<>();
        int a = 1000;
        for (int i = 0; i < 8; i++) {
            SLList<Integer> Test = new SLList<>();
            for (int j = 0; j < a; j++) {
                Test.addLast(j);
            }
            test(Time,Ops,Test);
            Ns.addLast(a);
            a *= 2;
        }
        printTimingTable(Ns,Time,Ops);

    }

}
