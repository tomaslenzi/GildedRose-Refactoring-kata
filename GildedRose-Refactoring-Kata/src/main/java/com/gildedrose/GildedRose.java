package com.gildedrose;

class GildedRose {
	Item[] items;
	
	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			updateItemQuality(item);
			updateSellIn(item);
		}
	}

	private void updateItemQuality(Item item) {
		if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {// when is a normal item
			if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
				changeQuality(item, -1);
			}
		} else {// when item is aged brie or backstage increment quality +1
			changeQuality(item, 1);
			if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {// for backstage if sellin is <11, quality +1
				if (item.sellIn < 11) {
					changeQuality(item, 1);
				}
				if (item.sellIn < 6) {// for backstage, if sellin is<6, quality +1
					changeQuality(item, 1);
				}
			}
		}

	}

	private void updateSellIn(Item item) {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
			item.sellIn = item.sellIn - 1;
		}
		ifItemExpired(item);
	}

	private void ifItemExpired(Item item) {
		if (item.sellIn < 0)
			itemExpired(item);
	}

	private void itemExpired(Item item) {
		if (!item.name.equals("Aged Brie")) {
			if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
					changeQuality(item, -1);
				}
			} else {
				item.quality = item.quality - item.quality;
			}
		} else {
			changeQuality(item, 1);
		}
	}

	private void changeQuality(Item item, int qualityChange) {
		if (item.quality > 0 && item.quality < 50) {
			item.quality = item.quality + qualityChange;
		}
	}
}