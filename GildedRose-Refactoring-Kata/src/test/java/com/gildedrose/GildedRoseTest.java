package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	@Test
	public void normalItemDecrementQuality() {
		int quality = 15;
		int expectedQuality = quality - 1;

		Item[] items = new Item[] { new Item("gouda", 10, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);

	}

	@Test
	public void itemAgedBrieIncrementQuality() {
		int quality = 15;
		int expectedQuality = quality + 1;

		Item[] items = new Item[] { new Item("Aged Brie", 10, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);

	}

	@Test
	public void normalItemDoubleDecrementQuality() {
		int quality = 15;
		int expectedQuality = quality - 2;

		Item[] items = new Item[] { new Item("gouda", 0, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);
	}

	@Test
	public void itemAgedBrieDoubleIncrementQuality() {
		int quality = 15;
		int expectedQuality = quality + 2;

		Item[] items = new Item[] { new Item("Aged Brie", 0, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);

	}

	@Test
	public void itemQualityIsNeverNegative() {
		int quality = 0;
		int expectedQuality = 0;

		Item[] items = new Item[] { new Item("gouda", 4, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);

	}

	@Test
	public void itemQualityNoGreaterThan50() {
		int quality = 50;
		int expectedQuality = 50;

		Item[] items = new Item[] { new Item("Aged Brie", 5, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);

	}

	@Test
	public void itemSulfurasLegendary() {
		int quality = 20;
		int expectedQuality = 20;

		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 4, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);

	}

	@Test
	public void backstagePassesQuality() {
		int quality = 20;
		int expectedQuality = quality + 1;

		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);

	}

	@Test
	public void backstagePassesDoubleIncrementQuality() {
		int quality = 20;
		int expectedQuality = quality + 2;

		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);

	}

	@Test
	public void backstagePassesTripleIncrementQuality() {
		int quality = 20;
		int expectedQuality = quality + 3;

		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);

	}

	@Test
	public void backstagePassesAfterTheConcert() {
		int quality = 25;
		int expectedQuality = 0;

		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(expectedQuality, app.items[0].quality);

	}

}
