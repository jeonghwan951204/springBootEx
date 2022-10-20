# springBootEx

## 책과 다른 점

###1장 인텔리제이로 스프링부트 시작하기
- build.gradle에서 buildscript를 쓰지 않고 plugins에 선언
- jcenter는 사용하지 않음 제작사에서 지원 종료
- dependencies에서 compile부분을 implement로 변경


###2장 스프링부트에서 테스트 코드 작성하기
- build.gradle에서 lombok 의존성 주입할 때 compile이 아닌 compileOnly로 수정
- helloDtoTest에서 jsonPath(name,is())가 아닌 jsonPath(name,equalTo()) 수정
- sonarlint에서 테스트 코드는 public말고 default로 하라고 해서 수정
