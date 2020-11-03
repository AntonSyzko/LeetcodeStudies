package CODILITY;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;


/*
Create a method, AddAndReturnValue, which takes an integer value, a string key and an array of existing values in the format "key:value".

For example:

[ Steve:100, JingJing:900, Swati:500 ]


Take the array of existing values and store in an appropriate structure.
Take the key and value parameters and either add it as a new entry or,
where a value with the same key already exists, sum the new value to the existing.
For example, adding JingJing:200 should return JingJing:1100.
Sort the results by value in descending order.
Return the results in the same format as originally provided, i.e. "key:value".


Numeric values which are not an integer should be regarded as invalid rather than rounded.
Negative values are invalid.
Keys in the input array will never contain a colon (:) character so you do not need to handle this.
Empty keys are valid.
Duplicate keys may exist within the input array and should be handled as a single entry with the values summed.

 */
public class Metro1 {

    public static String[] addAndReturn(int value, String key, String[] input) {

        List<String> inputAsList = Arrays.asList(input);

        Map<String, String> inputAsMap = inputAsList.stream().map(elem -> elem.split(":"))
                .collect(Collectors.toMap(e -> e[0], e -> e[1]));

        if (value < 0 || inputAsMap.values().stream().anyMatch(e -> !isInteger(e))
                || inputAsMap.values().stream().anyMatch(e -> Integer.parseInt(e) < 0)) {
            return new String[]{};
        }

        Map<String, Integer> kvs = inputAsMap.entrySet().stream().collect(
                Collectors.toMap(e -> e.getKey(), e -> Integer.parseInt(e.getValue())));

        kvs.merge(key, value, Integer::sum);

        String[] res = kvs.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::toString).collect(Collectors.toList()).stream()
                .map(e -> e.replace("=", ":")).toArray(String[]::new);

        return res;

    }

    //parse string to LONG of no false
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }


    @Test
    public void test1() {
        assertArrayEquals(new String[]{"JingJing:1100", "Swati:500", "Steve:100"},
                addAndReturn(200, "JingJing", new String[]{"Steve:100", "JingJing:900", "Swati:500"}));
    }

    @Test
    public void testNegativeValuePassed() {
        String[] testArray = {"Steve:100", "JingJing:900", "Swati:500"};
        String[] res = addAndReturn(-1, "negative", testArray);
        assertEquals(0, res.length);
        assertArrayEquals(res, new String[]{});
    }

    @Test
    public void testNegativeValusPresentInInitialArray() {
        String[] testArray = {"Steve:-100", "JingJing:-900", "Swati:500"};
        String[] res = addAndReturn(100, "test", testArray);
        assertEquals(0, res.length);
        assertArrayEquals(res, new String[]{});
    }

    @Test
    public void testNonIntegerValuesPresentInInitialArray() {
        String[] testArray = {"Steve:0.25", "JingJing:900", "Swati:500"};
        String[] res = addAndReturn(100, "test", testArray);
        assertEquals(0, res.length);
        assertArrayEquals(res, new String[]{});
    }

    @Test
    public void testLongValuesPresentInInitialArray() {
        String[] testArray = {"Steve:25L", "JingJing:900", "Swati:500"};
        String[] res = addAndReturn(100, "test", testArray);
        assertEquals(0, res.length);
        assertArrayEquals(res, new String[]{});

    }

    @Test
    public void testExponentialValuesPresentInInitialArray() {
        String[] testArray = {"Steve:25E8", "JingJing:900", "Swati:500"};
        String[] res = addAndReturn(100, "test", testArray);
        assertEquals(0, res.length);
        assertArrayEquals(res, new String[]{});

    }

    @Test
    public void testHexValuesPresentInInitialArray() {
        String[] testArray = {"Steve:1E240", "JingJing:900", "Swati:500"};
        String[] res = addAndReturn(100, "test", testArray);
        assertEquals(0, res.length);
        assertArrayEquals(res, new String[]{});

    }

    @Test
    public void testEmptyArrayPassed() {
        String[] testArray = {};
        String[] res = addAndReturn(100, "test", testArray);
        assertEquals(1, res.length);
        assertArrayEquals(res, new String[]{"test:100"});

    }

    @Test
    public void testEmptyKeyPassed() {
        String[] testArray = {"Steve:100", "JingJing:900", "Swati:500"};
        String[] res = addAndReturn(4, "", testArray);
        assertEquals(4, res.length);
        assertArrayEquals(res, new String[]{"JingJing:900", "Swati:500", "Steve:100", ":4"});
    }

    @Test
    public void testNewEntryAdded() {
        String[] testArray = {"Steve:100", "JingJing:900", "Swati:500"};
        String[] res = addAndReturn(10, "test", testArray);
        assertEquals(4, res.length);
        assertArrayEquals(res, new String[]{"JingJing:900", "Swati:500", "Steve:100", "test:10"});
    }

    @Test
    public void testDuplicatedKeysAggregated() {
        String[] testArray = {"Steve:100", "JingJing:900", "Swati:500"};
        String[] res = addAndReturn(1000, "JingJing", testArray);
        assertNotEquals(4, res.length);
        assertEquals(3, res.length);
        assertEquals("1900", res[0].split(":")[1]);
        assertArrayEquals(res, new String[]{"JingJing:1900", "Swati:500", "Steve:100"});
    }

    @Test
    public void testRetrunedInDescendingOrder() {
        String[] testArray = {"Steve:10", "JingJing:900", "Swati:500"};
        String[] res = addAndReturn(100000, "Test", testArray);
        assertEquals(4, res.length);
        assertEquals("100000", res[0].split(":")[1]);
        assertEquals("900", res[1].split(":")[1]);
        assertEquals("500", res[2].split(":")[1]);
        assertEquals("10", res[res.length - 1].split(":")[1]);
    }

    @Test
    public void testRetrunedIsOfArrayType() {
        String[] testArray = {"Steve:10"};
        assertTrue(addAndReturn(10, "Test", testArray).getClass().isArray());
    }

    @Test
    public void testRetrunedIsSemicolonSeparatedArray() {
        String[] testArray = {"Steve:10"};
        String[] res = addAndReturn(1, "Test", testArray);
        assertEquals(2, res.length);
        assertTrue(res[0].contains(":"));
        assertEquals(res[0].split(":")[0], "Steve");
        assertEquals(res[0].split(":")[1], "10");
    }
}
