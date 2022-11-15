#! /bin/bash

REPOSITORY=/home/ec2-user/app/step3
PROJECT_NAME=springBootEx

echo "> Build 파일 복사"

cp $REPOSITORY/zip/*.jar $REPOSITORY/
echo "> 현재 구동 중인 애플리케이션 pid 확인"

# 실행 중인 프로세스 id를 찾아 종료
CURRENT_PID=$(pgrep -fl springBootEx | awk '{print $1}')

echo "현재 구동 중인 애플리케이션 pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 새 애플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"
echo "> $JAR_NAME 에 실행권한 추가"

#jar 파일에는 실행권한이 없는 상태이므로 권한 부여
chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

nohup java -jar \
    -Dspring.config.location=classpath:/application.yml,/home/ec2-user/app/oauth.yml,/home/ec2-user/app/real-db.yml,classpath:/application-real.yml \
    -Dspring.profiles.active=real \
    $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
# nohup 실행 시 codedeploy는 무한 대기 상태 그래서 nohup.out 파일은 표준 입출력용으로 별도 사용 이렇게 하지 않으면 nohup.out파일은 생기지 않고 codedeploy 로그에 출력됨, nohup이 끝나기 전까지 codedeploy도 끝나지 않아서 꼭 해야함

