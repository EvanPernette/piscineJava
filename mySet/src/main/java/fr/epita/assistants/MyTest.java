package fr.epita.assistants;


import org.junit.jupiter.api.Test ;
import fr.epita.assistants.myset.GenericSet;
import fr.epita.assistants.myset.IntegerSet;
import static org.junit.jupiter.api.Assertions.*;

public class MyTest {
    @Test
    void testhas()
    {
        IntegerSet set = new IntegerSet();
        set.insert(1);
        set.insert(2);
        assertTrue(set.has(1));
    }
    
    @Test
    void testsize()
    {
        IntegerSet set = new IntegerSet();
        set.insert(1);
        set.insert(2);
        assertEquals(2, set.size());
    }

    @Test
    void testclear()
    {
        IntegerSet set = new IntegerSet();
        set.insert(1);
        set.insert(2);
        set.clear();
        assertEquals(0, set.size());
    }

    @Test
    void testunion()
    {
        IntegerSet set = new IntegerSet();
        set.insert(1);
        set.insert(2);
        IntegerSet set2 = new IntegerSet();
        set2.insert(3);
        set2.insert(4);
        IntegerSet set3 = set.union(set2);
        assertEquals(4, set3.size());
    }

    @Test
    void testintersection()
    {
        IntegerSet set = new IntegerSet();
        set.insert(1);
        set.insert(2);
        IntegerSet set2 = new IntegerSet();
        set2.insert(2);
        set2.insert(3);
        IntegerSet set3 = set.intersection(set2);
        assertEquals(1, set3.size());
    }

    @Test
    void testisEmpty()
    {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
    }

    @Test
    void testinsert()
    {
        IntegerSet set = new IntegerSet();
        set.insert(1);
        set.insert(2);
        assertEquals(2, set.size());
    }

    @Test
    void testremove()
    {
        IntegerSet set = new IntegerSet();
        set.insert(1);
        set.insert(2);
        set.remove(1);
        assertEquals(1, set.size());
    }
    
    @Test
    void testGenericSet()
    {
        GenericSet<Integer> set = new GenericSet<Integer>();
        set.insert(1);
        set.insert(2);
        assertEquals(2, set.size());
    }

    @Test
    void testGenericSet2()
    {
        GenericSet<String> set = new GenericSet<String>();
        set.insert("1");
        set.insert("2");
        set.remove("1");
        assertEquals(1, set.size());
    }

    @Test
    void testGenericSet3()
    {
        GenericSet<String> set = new GenericSet<String>();
        set.insert("1");
        set.insert("2");
        set.clear();
        assertEquals(0, set.size());
    }

    @Test
    void testGenericSet4()
    {
        GenericSet<String> set = new GenericSet<String>();
        set.insert("1");
        set.insert("2");
        assertTrue(set.has("1"));
    }

    @Test
    void testGenericSet5()
    {
        GenericSet<String> set = new GenericSet<String>();
        set.insert("1");
        set.insert("2");
        GenericSet<String> set2 = new GenericSet<String>();
        set2.insert("3");
        set2.insert("4");
        GenericSet<String> set3 = set.union(set2);
        assertEquals(4, set3.size());
    }

    @Test
    void testGenericSet6()
    {
        GenericSet<String> set = new GenericSet<String>();
        set.insert("1");
        set.insert("2");
        GenericSet<String> set2 = new GenericSet<String>();
        set2.insert("2");
        set2.insert("3");
        GenericSet<String> set3 = set.intersection(set2);
        assertEquals(1, set3.size());
    }

    @Test
    void testGenericSet7()
    {
        GenericSet<String> set = new GenericSet<String>();
        assertTrue(set.isEmpty());
    }

    @Test
    void testGenericSet8()
    {
        GenericSet<String> set = new GenericSet<String>();
        set.insert("1");
        set.insert("2");
        set.remove("1");
        assertEquals(1, set.size());
    }

    @Test
    void testGenericSetUnion()
    {
        GenericSet<String> set = new GenericSet<String>();
        set.insert("1");
        set.insert("2");
        GenericSet<String> set2 = new GenericSet<String>();
        set2.insert("3");
        set2.insert("4");
        GenericSet<String> set3 = set.union(set2);
        assertEquals(4, set3.size());
    }
}
