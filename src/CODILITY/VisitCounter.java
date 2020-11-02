package CODILITY;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class VisitCounter {
    
    @Test
    public void test() {
        Map<String, UserStats> mapa = new HashMap<>();
        mapa.put("12", new UserStats(Optional.of(12L)));
        mapa.put("-12", new UserStats(Optional.of(123L)));
        mapa.put("1254645456456", new UserStats(Optional.of(12L)));

        Map<Long, Long> res = count(mapa);
        assertEquals(res.size(), 3);
    }

    @Test
    public void testEmptyUserStatsCount() {
        Map<String, UserStats> mapa = new HashMap<>();
        mapa.put("12", new UserStats(Optional.empty()));
        mapa.put("-12", new UserStats(Optional.empty()));

        Map<Long, Long> res = count(mapa);
        assertEquals(res.size(), 0);
    }

    @Test
    public void testNullValue() {
        Map<String, UserStats> mapa = new HashMap<>();
        mapa.put("12", null);

        Map<Long, Long> res = count(mapa);
        assertEquals(res.size(), 0);
    }

    @Test
    public void testLongNotParseable() {
        Map<String, UserStats> mapa = new HashMap<>();
        mapa.put("", new UserStats(Optional.of(123L)));
        mapa.put("123TEST", new UserStats(Optional.of(125464563L)));
        mapa.put("12L", new UserStats(Optional.of(124563L)));

        Map<Long, Long> res = count(mapa);
        assertEquals(res.size(), 0);
    }

    //key - not parsable to long ?     skip!
    //value sometimes null, if null  - skip!
    //UserStats.getVisit  - never null but empty possible, if empty -  (SKIP)!!!
    public Map<Long, Long> count(Map<String, UserStats>... visits) {

        //flatten from Array of Maps to one map
        Map<String, UserStats> flattened = Arrays.stream(visits).collect(HashMap::new, Map::putAll, Map::putAll);

        return flattened.entrySet().stream()
                .filter(e -> isLong(e.getKey())) //key - not parsable to long - skip
                .filter(e -> Objects.nonNull(e.getValue())) //value  null - skip
                .filter(e -> e.getValue().getVisitCount().isPresent()) //UserStats.getVisist optional  - empty -  (SKIP)!!!
                .collect(Collectors.toMap(e -> Long.parseLong(e.getKey()),//parse KEY  to long
                        e -> e.getValue().getVisitCount().get()));//VALUE - from optional to str
    }

    //parse string to LONG of no false
    public boolean isLong(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
