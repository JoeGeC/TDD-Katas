package com.gildedrose;

class AgedBrie implements Product {
    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;
    }
}
