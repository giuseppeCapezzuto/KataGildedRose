package com.gildedrose;

abstract class ItemType {

    protected static final int MIN_QUALITY_VALUE = 0;
    protected static final int MAX_QUALITY_VALUE = 50;

    protected abstract void updateQuality(Item item);

    protected abstract void updateQualityIfExpired(Item item);

    protected abstract void updateSellIn(Item item);

    protected void updateItem(Item item) {
        updateQuality(item);
        updateSellIn(item);
        if (item.sellIn < 0) {
            updateQualityIfExpired(item);
        }
    }

    protected void incrementQuality(Item item) {
        if (item.quality < MAX_QUALITY_VALUE) {
            item.quality++;
        }
    }

    protected void decrementQuality(Item item) {
        if (item.quality > MIN_QUALITY_VALUE) {
            item.quality--;
        }
    }
}
