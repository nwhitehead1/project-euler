package problems;

import helper.FutureAssertionHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class ProblemTest {

    private ExecutorService executorService;
    private Map<Callable<String>, String> callableMap;

    @Before
    public void setUp() {
        executorService = Executors.newWorkStealingPool();
        callableMap = populateTestCases();
    }

    @After
    public void tearDown() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    // TODO: Likely not worth multithreading here - sucks to make assertions waiting for assertions
    @Test
    public void problems() {
        List<FutureAssertionHelper<String>> futures = new ArrayList<>();

        for (Callable<String> c : callableMap.keySet()) {
            Future<String> future = executorService.submit(c);
            String assertion = callableMap.get(c);
            futures.add(new FutureAssertionHelper<>(future, assertion));
        }

        futures.forEach(future -> {
            try {
                String expected = future.getAssertion();
                String actual = future.getFuture().get();
                assertEquals(expected, actual);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private Map<Callable<String>, String> populateTestCases() {
        Map<Callable<String>, String> callableMap = new HashMap<>();
        callableMap.put(new Problem001(), "233168");
        callableMap.put(new Problem002(), "4613732");
        callableMap.put(new Problem003(), "6857");
        callableMap.put(new Problem004(), "906609");
        callableMap.put(new Problem005(), "232792560");
        callableMap.put(new Problem006(), "25164150");
        callableMap.put(new Problem007(), "104743");
        callableMap.put(new Problem008(), "23514624000");
        callableMap.put(new Problem009(), "31875000");
        callableMap.put(new Problem010(), "142913828922");
        callableMap.put(new Problem011(), "70600674");
        callableMap.put(new Problem012(), "76576500");
        callableMap.put(new Problem013(), "5537376230");
        callableMap.put(new Problem014(), "837799");
        callableMap.put(new Problem015(), "137846528820");
        callableMap.put(new Problem016(), "1366");
        callableMap.put(new Problem017(), "21124");
        callableMap.put(new Problem018(), "1074");
        callableMap.put(new Problem019(), "171");
        callableMap.put(new Problem020(), "648");
        callableMap.put(new Problem021(), "31626");
        callableMap.put(new Problem022(), "871198282");
        callableMap.put(new Problem023(), "4179871");
        callableMap.put(new Problem024(), "2783915460");
        callableMap.put(new Problem025(), "4782");
        callableMap.put(new Problem026(), "983");
        callableMap.put(new Problem027(), "-59231");
        callableMap.put(new Problem028(), "669171001");
        callableMap.put(new Problem029(), "9183");
        callableMap.put(new Problem030(), "443839");
        callableMap.put(new Problem031(), "73682");
        callableMap.put(new Problem032(), "45228");
        callableMap.put(new Problem033(), "100");
        callableMap.put(new Problem034(), "40730");
        callableMap.put(new Problem035(), "55");
        callableMap.put(new Problem036(), "872187");
        callableMap.put(new Problem037(), "748317");
        callableMap.put(new Problem038(), "932718654");
        callableMap.put(new Problem039(), "840");
        callableMap.put(new Problem040(), "210");
        callableMap.put(new Problem041(), "7652413");
        callableMap.put(new Problem042(), "162");
        callableMap.put(new Problem043(), "16695334890");
        callableMap.put(new Problem044(), "5482660");
        callableMap.put(new Problem045(), "1533776805");
        return callableMap;
    }
}
