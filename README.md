# mabi-helper

### 서비스 관리

서비스 백그라운드 실행
- nohup java -jar -Dspring.profiles.active=prd ./mabi-helper-0.0.1-SNAPSHOT.jar > /mabi-helper-log.out $
- /mabi-helper-log.out에 로그 관리

서비스 확인
 - bg : background 서비스 확인
 - ps -ef | grep mabi-helper

백그라운드 서비스 종료 
 - kill -9 <프로세스 아이디>