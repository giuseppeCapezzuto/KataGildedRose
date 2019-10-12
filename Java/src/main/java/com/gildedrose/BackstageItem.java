package com.gildedrose;

import static com.gildedrose.ItemType.MIN_QUALITY_VALUE;

class BackstageItem extends ItemType {

    @Override
    protected void updateQuality(Item item) {
        incrementQuality(item);
        if (item.sellIn < 11) {
            incrementQuality(item);
        }
        if (item.sellIn < 6) {
            incrementQuality(item);
        }
    }

    @Override
    protected void updateQualityIfExpired(Item item) {
        item.quality = MIN_QUALITY_VALUE;
    }

    @Override
    protected void updateSellIn(Item item) {
        item.sellIn--;
    }

}
