package cn.xpbootcamp.gilded_rose;

public class Item {

    public static final int ZERO = 0;
    public static final int ELEVENT = 11;
    public static final int SIX = 6;
    public static final int FIFTY = 50;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sellIn = sell_in;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
    public void updateQuality() {
        if (isSpecialItems()) {
            updateSpecialItems();
        } else {
            updateRegularItem();
        }
        if (isSellInLessThan(ZERO)) {
            updateLessThanZeroSellInItems();
        }
    }

    private boolean isSellInLessThan(final int quantity) {
        return this.sellIn < quantity;
    }

    public void updateSellIn() {
        if (this.notSulfuras()) {
            this.decrementSellInByOne();
        }
    }

    public boolean isQualityGreaterThanZero() {
        return this.quality > 0;
    }

    public boolean isAgedBrie() {
        return this.name.equals("Aged Brie");
    }

    public boolean notSulfuras() {
        return !this.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isBackstagePassToConcert() {
        return this.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSpecialItems() {
      return this.isAgedBrie() || this.isBackstagePassToConcert();
    }

    public void incrementQualityByOne() {
      this.quality++;
    }

    public void decrementQualityByOne() {
      this.quality--;
    }
    public void decrementSellInByOne() {
      this.sellIn--;
    }

    public void updateSpecialItems() {
      if (isQualityLessThanFifty()) {
            this.incrementQualityByOne();
            if (this.isBackstagePassToConcert()) {
                if (isSellInLessThan(ELEVENT)) {
                    this.incrementQualityByOne();
                }
                if (isSellInLessThan(SIX)) {
                    this.incrementQualityByOne();
                }
            }
        }
    }

    private boolean isQualityLessThanFifty() {
        return this.quality < Item.FIFTY;
    }

    public void updateRegularItem() {
      if (this.quality > 0) {
            if (this.notSulfuras()) {
                this.decrementQualityByOne();
            }
        }
    }

    private void updateLessThanZeroSellInItems() {
      if (this.isAgedBrie()) {
            if (isQualityLessThanFifty()) {
                this.incrementQualityByOne();
            }
            return;
        }
        if (this.isBackstagePassToConcert()) {
            this.quality = 0;
            return;
        }
        if (this.isQualityGreaterThanZero() && this.notSulfuras()) {
            this.decrementQualityByOne();
        }
    }
}
