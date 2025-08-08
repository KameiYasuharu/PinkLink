package com.example.demo.demos.web.service;

import org.springframework.stereotype.Service;

import com.example.demo.demos.web.entity.PinDetail;
import com.example.demo.demos.web.repository.PinDetailRepository;

import lombok.RequiredArgsConstructor;

/**
 * PinDetailService の実装クラス。
 * レコード関連のビジネスロジックを実装します。
 */
@Service
@RequiredArgsConstructor
public class PinDetailServiceImpl implements PinDetailService {

    // RecordRepository を注入（コンストラクタインジェクションを使用）
    private final PinDetailRepository pinDetailRepository;

    /**
     * レコードのリストを取得します。
     *
     * @return ExampleTable エンティティのリスト
     */
    @Override
    public PinDetail findBySbNo(String sbNo) {
        //  PinDetailRepository を呼び出してレコードのリストを取得
		PinDetail pinDetail = pinDetailRepository.findBySbNo(sbNo);
        return pinDetail;
    }
}