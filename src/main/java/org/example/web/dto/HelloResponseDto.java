package org.example.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// getter 메서드 생성
@Getter
// 선언된 모든 final 필드가 포함된 생성자 생성
// final이 없는 필드는 포함x
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
