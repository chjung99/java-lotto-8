package lotto.model.service;

import lotto.model.domain.MatchRecord;

import java.util.HashMap;
import java.util.Map;

public class LottoRankMapper {
    private final Map<MatchRecord, Integer> rankByMatchRecord;

    public LottoRankMapper() {
        this.rankByMatchRecord = createRankMatchRecord();
    }

    private Map<MatchRecord, Integer> createRankMatchRecord() {
        Map<MatchRecord, Integer> rankByMatchRecord = new HashMap<>();

        rankByMatchRecord.put(new MatchRecord(6, false), 1);
        rankByMatchRecord.put(new MatchRecord(5, true), 2);
        rankByMatchRecord.put(new MatchRecord(5, false), 3);
        rankByMatchRecord.put(new MatchRecord(4, false), 4);
        rankByMatchRecord.put(new MatchRecord(3, false), 5);

        return rankByMatchRecord;
    }

    public int getRankByMatchRecord(MatchRecord matchRecord) {
        Integer rank = rankByMatchRecord.get(matchRecord);
        if (rank == null) {
            throw new NullPointerException("[ERROR] 정의되지 않은 로또 결과입니다.");
        }
        return rank;
    }

}
