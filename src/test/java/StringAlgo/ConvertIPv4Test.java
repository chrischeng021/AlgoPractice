package StringAlgo;

import static org.junit.jupiter.api.Assertions.*;

class ConvertIPv4Test {

    @org.junit.jupiter.api.Test
    void convertIP2Int() {
        assertEquals(ConvertIPv4.convertIP2Int("127.0.0.1"), 1 +  127 * (int)Math.pow(2, 24));
        assertEquals(ConvertIPv4.convertIP2Int("172.168.5.1"), 2896692481L);
        assertEquals(ConvertIPv4.convertIP2Int("   172   .  168   .5.1"), 2896692481L);
        assertEquals(ConvertIPv4.convertIP2Int("      172.    168    .    5   .    1    "), 2896692481L);
        assertEquals(ConvertIPv4.convertIP2Int("1    72.168.5.1"), -1);
        assertEquals(ConvertIPv4.convertIP2Int("172.168..1"), -1);
        assertEquals(ConvertIPv4.convertIP2Int("172.168.05.1"), -1);
        assertEquals(ConvertIPv4.convertIP2Int(".168.5.1"), -1);
        assertEquals(ConvertIPv4.convertIP2Int("127.0.0.01"), -1);
        assertEquals(ConvertIPv4.convertIP2Int("0..."), -1);
        assertEquals(ConvertIPv4.convertIP2Int(".0.0.1"), -1);
        assertEquals(ConvertIPv4.convertIP2Int("256.127.0.1"), -1);
        assertEquals(ConvertIPv4.convertIP2Int("0.0.0.255"), 255);
    }
}