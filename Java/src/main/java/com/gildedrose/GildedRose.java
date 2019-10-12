package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemTypeFactory itemTypeFactory = new ItemTypeFactory();
        for (Item item : items) {
            ItemType itemType = itemTypeFactory.getItemType(item.name);
            itemType.updateItem(item);
        }
    }
}
