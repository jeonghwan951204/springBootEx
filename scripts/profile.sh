#!/usr/bin/env bash

# 쉬고 있는 profile 찾기: real1이 사용 중이면 real2가 쉬고 있고, 반대면 real1이 쉬고 있음

function find_idle_profile() {
  # 현재 엔진엔스가 바라보고 있는 스프링 부트가 정상적으로 실행 중인지 체크
    RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/profile)

    if [ ${RESPONSE_CODE} -ge 400 ] # 400보다 크면 (즉, 40x/50x 에러 모두 포함)
    then
      CURRENT_PROFILE=real2
    else
      CURRENT_PROFILE=$(curl -s http://localhost/profile)
    fi

  # IDLE_PROFILE => 엔진엑스와 연결되지 않은 profile
    if [ "${CURRENT_PROFILE}" == real1 ]
    then
      IDLE_PROFILE=real2
    else
      IDLE_PROFILE=real1
    fi

    # bash는 값을 반환하는 기능이 없음 마지막 줄에 echo로 출력하여 클라이언트에서 그 값을 잡아 사용 중간에 echo사용 금지
    echo "${IDLE_PROFILE}"
}

# 쉬고 있는 profile의 포트 찾기
function find_idle_port() {
    IDLE_PROFILE=$(find_idle_profile)

    if [ "${IDLE_PROFILE}" == rea1 ]
    then
      echo "8081"
    else
      echo "8082"
    fi
}
