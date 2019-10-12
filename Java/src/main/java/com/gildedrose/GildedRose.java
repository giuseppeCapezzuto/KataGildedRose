package com.gildedrose;

class GildedRose {

    Item[] items;

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    private static final int MINIMUM_QUALITY_VALUE = 0;
    private static final int MAX_QUALITY_VALUE = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            performUpdate(item);
        }
    }

    private void performUpdate(Item item) {
        if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_TAFKAL80ETC)) {
            if (item.quality > MINIMUM_QUALITY_VALUE) {
                if (!item.name.equals(SULFURAS)) {
                    decrementQuality(item);
                }
            }
        } else {
            if (item.quality < MAX_QUALITY_VALUE) {
                incrementQuality(item);
                
                if (item.name.equals(BACKSTAGE_TAFKAL80ETC)) {
                    if (item.sellIn < 11) {
                        if (item.quality < MAX_QUALITY_VALUE) {
                            incrementQuality(item);
                        }
                    }
                    
                    if (item.sellIn < 6) {
                        if (item.quality < MAX_QUALITY_VALUE) {
                            incrementQuality(item);
                        }
                    }
                }
            }
        }
        
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
        
        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE_TAFKAL80ETC)) {
                    if (item.quality > MINIMUM_QUALITY_VALUE) {
                        if (!item.name.equals(SULFURAS)) {
                            decrementQuality(item);
                        }
                    }
                } else {
                    item.quality = MINIMUM_QUALITY_VALUE;
                }
            } else {
                if (item.quality < MAX_QUALITY_VALUE) {
                    incrementQuality(item);
                }
            }
        }
    }
    private void incrementQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void decrementQuality(Item item) {
        item.quality = item.quality - 1;
    }
}
