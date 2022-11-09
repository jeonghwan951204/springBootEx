# springBootEx

## 책과 다른 점

### 1장 인텔리제이로 스프링부트 시작하기
- build.gradle에서 buildscript를 쓰지 않고 plugins에 선언
- jcenter는 사용하지 않음 제작사에서 지원 종료
- dependencies에서 compile부분을 implement로 변경

---

### 2장 스프링부트에서 테스트 코드 작성하기
- build.gradle에서 lombok 의존성 주입할 때 compile이 아닌 compileOnly로 수정
- helloDtoTest에서 jsonPath(name,is())가 아닌 jsonPath(name,equalTo()) 수정
- sonarlint에서 테스트 코드는 public말고 default로 하라고 해서 수정
- @RunWith가 Junit5에서 @ExtendWith로 변경되어 수정 

---

### 3장 스프링 부트에서 JPA로 데이터베이스 다루기
- 스프링부트 버전에 따라 h2 쿼리로그를 mySql 쿼리로 변경하여 보여주는 옵션 수정(org.hibernate.dialect.MySQL57Dialect, datasource.hikari.jdbc-url=jdbc:h2:mem://localhost/~/testdb;MODE=MYSQL)

---

### 4장 머스테치로 화면 구성하기
- 머스테치가 스프링부트 2.7.x 버전에서 한글이 깨지는 이슈가 있어 2.6.7버전으로 다운
- jquery, bootstrap cdn 주소를 현행화
- devtools 라이브러리 추가(머스테치는 지원x)

---

### 5장 스프링 시큐리티와 OAuth 2.0으로 로그인 기능 구현하기
- indexController에서 userName을 넘기지만 화면에서 "owner"로 나오는 현상 userName을 환경변수에서 사용하고 있기 때문에
loginUserName으로 변경하여 해결













