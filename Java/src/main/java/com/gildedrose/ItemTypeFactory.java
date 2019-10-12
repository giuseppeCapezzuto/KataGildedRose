package com.gildedrose;

public class ItemTypeFactory {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String BRIE = "Aged Brie";

    public ItemType getItemType(String type) {
        switch (type) {
            case SULFURAS:
                return new SulfurasItem();
            case BACKSTAGE:
                return new BackstageItem();
            case BRIE:
                return new BrieItem();
            default:
                return new UnknownItem();
        }
    }
}
