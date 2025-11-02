package lotto.model;

public class LottoOrderResult {
    public final int countOf1st;
    public final int countOf2nd;
    public final int countOf3rd;
    public final int countOf4th;
    public final int countOf5th;

    public LottoOrderResult(int countOf1st, int countOf2nd, int countOf3rd, int countOf4th, int countOf5th) {
        this.countOf1st = countOf1st;
        this.countOf2nd = countOf2nd;
        this.countOf3rd = countOf3rd;
        this.countOf4th = countOf4th;
        this.countOf5th = countOf5th;
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "countOf1st=" + countOf1st +
                ", countOf2nd=" + countOf2nd +
                ", countOf3rd=" + countOf3rd +
                ", countOf4th=" + countOf4th +
                ", countOf5th=" + countOf5th +
                '}';
    }
}
