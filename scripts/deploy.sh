#!/bin/bash

REPOSITORY=/home/ubuntu/test
PROJECT_NAME=server

echo ">>> Build 파일 복사"

cp $REPOSITORY/deploy/*.jar $REPOSITORY/

echo ">>> 현재 구동중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -fl jenkins-springboot | grep java | awk '{print $1}')

echo ">> PID : " $CURRENT_PID

if [ -z "$CURRENT_PID" ]; then
  echo "구동중인 애플리케이션 없음."
else
  echo ">>> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 10
fi

echo ">>> 애플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo ">>> JAR NAME : $JAR_NAME"

chmod +x $JAR_NAME

echo ">>> $JAR_NAME 실행"

nohup java -jar -Dspring.config.location=/home/ubuntu/test/application-mysql.properties -Duser.timezone=Asia/Seoul $JAR_NAME >> $REPOSITORY/nohup.out 2>&1 &