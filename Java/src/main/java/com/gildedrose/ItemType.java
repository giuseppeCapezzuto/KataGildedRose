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
        if (item.getSellIn() < 0) {
            updateQualityIfExpired(item);
        }
    }

    protected void incrementQuality(Item item) {
        if (item.getQuality() < MAX_QUALITY_VALUE) {
            item.incrementQuality();
        }
    }

    protected void decrementQuality(Item item) {
        if (item.getQuality() > MIN_QUALITY_VALUE) {
            item.decrementQuality();
        }
    }
}
