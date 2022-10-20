package org.example.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

 class HelloResponseDtoTest {

    @Test
    void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        // assertThat : 검증하고 싶은 대상을 메서드 인자로 받음
        // isEqualsTo : 값을 비교해서 같을 때 성공
        // assertj와 Junit의 비교적 장점   추가적인 라이브러리 필요x, 자동완성이 잘 됨
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
