package com.example.demo.demos.web.service;

import org.springframework.stereotype.Service;

import com.example.demo.demos.web.entity.PinDetail;

/**
 * PinDetailService インターフェース。
 * レコード関連のビジネスロジックを定義します。
 */
@Service
public interface PinDetailService {

    /**
     * レコードのリストを取得します。
     *
     * @return ExampleTable エンティティのリスト
     */
    PinDetail findBySbNo(String sbNo);
}