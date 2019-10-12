package com.gildedrose;

import static com.gildedrose.ItemTypeFactory.BACKSTAGE;
import static com.gildedrose.ItemTypeFactory.BRIE;
import static com.gildedrose.ItemTypeFactory.SULFURAS;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testUpdateSulfuraExpired() {
        Item[] items = new Item[]{new Item(SULFURAS, 0, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(SULFURAS, app.items[0].getName());
        assertEquals(0, app.items[0].getSellIn());
        assertEquals(40, app.items[0].getQuality());
    }

    @Test
    public void testUpdateSulfuraNotExpired() {
        Item[] items = new Item[]{new Item(SULFURAS, 10, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(SULFURAS, app.items[0].getName());
        assertEquals(10, app.items[0].getSellIn());
        assertEquals(40, app.items[0].getQuality());
    }

    @Test
    public void testUpdateBackstageAt11Days() {
        Item[] items = new Item[]{new Item(BACKSTAGE, 11, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE, app.items[0].getName());
        assertEquals(10, app.items[0].getSellIn());
        assertEquals(5, app.items[0].getQuality());
    }

    @Test
    public void testUpdateBackstageAt10Days() {
        Item[] items = new Item[]{new Item(BACKSTAGE, 10, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE, app.items[0].getName());
        assertEquals(9, app.items[0].getSellIn());
        assertEquals(6, app.items[0].getQuality());
    }

    @Test
    public void testUpdateBackstageAt6Days() {
        Item[] items = new Item[]{new Item(BACKSTAGE, 6, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE, app.items[0].getName());
        assertEquals(5, app.items[0].getSellIn());
        assertEquals(6, app.items[0].getQuality());
    }

    @Test
    public void testUpdateBackstageAt5Days() {
        Item[] items = new Item[]{new Item(BACKSTAGE, 5, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE, app.items[0].getName());
        assertEquals(4, app.items[0].getSellIn());
        assertEquals(7, app.items[0].getQuality());
    }

    @Test
    public void testUpdateBackstageAt0Days() {
        Item[] items = new Item[]{new Item(BACKSTAGE, 0, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE, app.items[0].getName());
        assertEquals(-1, app.items[0].getSellIn());
        assertEquals(0, app.items[0].getQuality());
    }

    @Test
    public void testUpdateBrieNotExpired() {
        Item[] items = new Item[]{new Item(BRIE, 10, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BRIE, app.items[0].getName());
        assertEquals(9, app.items[0].getSellIn());
        assertEquals(5, app.items[0].getQuality());
    }

    @Test
    public void testUpdateBrieExpired() {
        Item[] items = new Item[]{new Item(BRIE, 0, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BRIE, app.items[0].getName());
        assertEquals(-1, app.items[0].getSellIn());
        assertEquals(6, app.items[0].getQuality());
    }

    @Test
    public void testUpdateUknownNotExpired() {
        Item[] items = new Item[]{new Item("Uknown", 10, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Uknown", app.items[0].getName());
        assertEquals(9, app.items[0].getSellIn());
        assertEquals(3, app.items[0].getQuality());
    }

    @Test
    public void testUpdateUknownExpired() {
        Item[] items = new Item[]{new Item("Uknown", 0, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Uknown", app.items[0].getName());
        assertEquals(-1, app.items[0].getSellIn());
        assertEquals(2, app.items[0].getQuality());
    }

}
