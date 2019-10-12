package com.gildedrose;

    class BrieItem extends ItemType {

        @Override
        protected void updateQuality(Item item) {
            incrementQuality(item);
        }

        @Override
        protected void updateQualityIfExpired(Item item) {
            incrementQuality(item);
        }

        @Override
        protected void updateSellIn(Item item) {
            item.decrementSellIn();
        }

    }
