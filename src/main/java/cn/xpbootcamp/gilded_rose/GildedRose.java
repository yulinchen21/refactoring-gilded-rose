package cn.xpbootcamp.gilded_rose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateItems() {
    for (Item item : items) {
      item.updateQuality();
      item.updateSellIn();
    }
  }
}
