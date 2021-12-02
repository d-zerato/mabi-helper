# mabi-helper

### swagger 정리
swagger 3.0.0부터는 [springfox-boot-starter] 만으로 ui가 import 가능
접근 url : domain/{context-path}/swagger-ui/

### 서비스 관리

서비스 백그라운드 실행
- nohup java -jar -Dspring.profiles.active=prd ./mabi-helper-0.0.1-SNAPSHOT.jar > /mabi-helper-log.out $
- /mabi-helper-log.out에 로그 관리

서비스 확인
 - bg : background 서비스 확인
 - ps -ef | grep mabi-helper

백그라운드 서비스 종료 
 - kill -9 <프로세스 아이디>