package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                updateAgedBrie(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePass(item);
                break;
            default:
                if (item.name.contains("Conjured")) {
                    updateConjuredItem(item);
                } else {
                    updateRegularItem(item);
                }
                break;
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        item.sellIn -= 1;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality += 1;
        }
    }

    private void updateBackstagePass(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
            if (item.sellIn < 11) {
                item.quality += 1;
            }
            if (item.sellIn < 6) {
                item.quality += 1;
            }
        }
        item.sellIn -= 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateRegularItem(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
        item.sellIn -= 1;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void updateConjuredItem(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
        }
        item.sellIn -= 1;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 2;
        }
    }
}
