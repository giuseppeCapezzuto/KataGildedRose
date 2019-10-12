
package com.gildedrose;

    class UnknownItem extends ItemType {

        @Override
        protected void updateQuality(Item item) {
            decrementQuality(item);
        }

        @Override
        protected void updateQualityIfExpired(Item item) {
            decrementQuality(item);
        }

        @Override
        protected void updateSellIn(Item item) {
            item.decrementSellIn();
        }
    }
