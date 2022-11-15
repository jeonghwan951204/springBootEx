#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

function switch_proxy() {
    IDLE_PORT=$(find_idle_port)

    echo "> 전환할 Port: $IDLE_PORT"
    echo "> Port 전환"
    # 하나의 문장을 만들어 파이프라인으로 넘겨주기 위해 echo를 사용, 엔진엑스가 변경할 프록시 주소 생성. 쌍따옴표를 사용하지 않으면 $servuce_url을 그대로 인식하지 못하고 변수를 찾음
    # 앞에서 넘겨준 문장을 service_url.inc에 덮어씀
    echo "set \$service_url http://127.0.0.1:${IDLE_PORT};" | sudo tee /etc/nginx/conf.d/service_url.inc

    echo "> 엔진엑스 Reload"
    sudo service nginx reload
}
