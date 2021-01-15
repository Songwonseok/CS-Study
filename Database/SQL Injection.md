# SQL Injection

### SQL Injection이란?
- 웹 사이트의 보안상 허점을 이용해 툭정 SQL 쿼리 문을 전송하여 공격자가 원하는 데이터베이스의 중요한 정보를 가져오는 해킹 기법.
- 클라이언트가 입력한 데이터를 제대로 필터링 하지 못하는 경우 발생.
- 공격 난이도가 쉬운데 비해 피해 규모가 큼.

![Sqlinjection-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Database/images/Sqlinjection-1.PNG)

<br>

### SQL Injection의 진행의 예

- 각 클라이언트가 자격증 번호를 조회할 수 있는 시스템.
- SQL 진행은 anjinma 클라이언트가 '자격증 번호 조회'를 클릭하여 anjinma 라는 이름이 웹서버에 전송되고 DB에 입력한 값과 일치하면 자격증 DB를 출력해준다.
- blackhat 클라이언트는 anjinma 클라이언트의 자격증 번호를 조회하기 위해서 SQL문을 수정하지만 권한이 없어서 자격증 정보를 가져올 수 없다.
- ex) http://license12345.com/mysearch?=anjinma url을 전송할때 anjinma가 로그인 되어있으면 정상적으로 자격증 번호를 조회할 수 있지만 blackhat이 로그인 되어있으면 자격증 번호를 조회할 수 없다.
- 공격자인 blackhat은 url뒤에 ' or '1'='1'을 넣어줘서 항상 참이 되게 만들어서 자격증 번호를 조회해 온다.

<br>

### SQL Injection 해킹 사례
**사례1) '여기어때' 해킹**
<br>
![Sqlinjection-2](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Database/images/Sqlinjection-2.png)
<br>
-> https://news.joins.com/article/21628794

- 2017년 3월, 유명한 숙박앱인 '여기 어때'가 해킹을 당했다. 대량의 고객 정보와 고객의 투숙정보가 해커에게 유출되었으며 이 중 수천명에게 '모텔서 즐거우셨나요?'라는 식의 협박성의 민망한 문자가 전송되었다고 한다.
- 기사에 따르면, 이 사건은 보안이 허술한 특정 웹 페이지를 대상으로 SQL 인젝션 공격을 시도해서 관리자 세션을 탈취하고 이 정보로 관리 페이지에 위장 로그인하여 고객의 개인정보를 유출했다고 한다.

**사례2) '뽐뿌' 해킹**
<br>
![Sqlinjection-3](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Database/images/Sqlinjection-3.png)
<br>
-> http://www.korea.kr/policy/pressReleaseView.do?newsId=156081058
- 커뮤니티 사이트로 유명한 '뽐뿌'에서도 SQL 인젝션 공격으로 200만명 가량 개인정보가 유출된 사례가 있었다.
<br>

### SQL Injection의 종류와 공격 방법

**1. Error based SQL Injection - 논리적 에러를 이용한 SQL Injection**
- 앞서 예를 들어 설명한 기법으로 해당 기법으로 SQL 인젝션에 대한 기본을 설명하는게 일반적이다. 

- [로그인 예]

  정상접근 -> Select * from cliend where name='anjinma' and password='12345'

  SQL Injection -> Select * from client where name='anjinma' and password=' or '1'='1'

  ' or '1'='1'를 넣어서 1과 1이 같아서 항상 참이므로 로그인에 성공하게 된다.

**2. UNION based SQL Injection = UNION 명령어를 이용한 SQL Injection**

- SQL UNION이란 여러개의 SQL문을 합쳐 하나의 SQL문으로 만들어주는 방법이다.

- UNION과 UNION ALL로 나뉘는데 중복 값을 제외하고 안하고의 차이다.

- [UNION의 예]
  select name from classa
  union
  select name from classb;
  하게 되면 클래스 A와 클래스 B 이름들이 합쳐져서 출력된다.
  UNION으로 합쳐지는 두 테이블은 컬럼 갯수가 일치해야만 오류가 나지 않는다.

- [외부 입력]

ID: test' UNION SELECT 1,1 --

PW: anything

- [실행 쿼리]

  select * from users where id='test' UNION select 1,1 -- and PW='anything'

- 쿼리가 실행되면 users 테이블에 등록된 id와 pw 목록을 전부 조회할 수 있게 된다.

**3. Blind SQL Injection - Boolean based Blind SQL Injection**
- Blind SQL Injection은 데이터베이스로부터 특정한 값이나 데이터를 전달받지 않고, 단순히 참과 거짓의 정보만 알 수 있을 때 사용합니다. 로그인 폼에 SQL Injection이 가능하다고 가정 했을 때, 서버가 응답하는 로그인 성공과 로그인 실패 메시지를 이용하여, DB의 테이블 정보 등을 추출해 낼 수 있습니다.
![Sqlinjection-4](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Database/images/Sqlinjection-4.png)
- 위의 그림은 Blind Injection을 이용하여 데이터베이스의 테이블 명을 알아내는 방법입니다. (MySQL) 인젝션이 가능한 로그인 폼을 통하여 악의적인 사용자는 임의로 가입한 abc123 이라는 아이디와 함께 abc123’ and ASCII(SUBSTR(SELECT name From information_schema.tables WHERE table_type=’base table’ limit 0,1)1,1)) > 100 -- 이라는 구문을 주입합니다.
- 해당구문은 MySQL 에서 테이블 명을 조회하는 구문으로 limit 키워드를 통해 하나의 테이블만 조회하고, SUBSTR 함수로 첫 글자만, 그리고 마지막으로 ASCII 를 통해서 ascii 값으로 변환해줍니다. 만약에 조회되는 테이블 명이 Users 라면 ‘U’ 자가 ascii 값으로 조회가 될 것이고, 뒤의 100 이라는 숫자 값과 비교를 하게 됩니다.  거짓이면 로그인 실패가 될 것이고, 참이 될 때까지 뒤의 100이라는 숫자를 변경해 가면서 비교를 하면 됩니다.  공격자는 이 프로세스를 자동화 스크립트를 통하여 단기간 내에 테이블 명을 알아 낼 수 있습니다.

**4. Blind SQL Injection - Time based SQL Injection**
- Time Based SQL Injection 도 마찬가지로 서버로부터 특정한 응답 대신에 참 혹은 거짓의 응답을 통해서 데이터베이스의 정보를 유추하는 기법입니다. 사용되는 함수는 MySQL 기준으로 SLEEP 과 BENCHMARK 입니다.
  ![Sqlinjection-5](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Database/images/Sqlinjection-5.png)
  <br>

- 위의 그림은 Time based SQL Injection을 사용하여 현재 사용하고 있는 데이터베이스의 길이를 알아내는 방법입니다. 로그인 폼에 주입이 되었으며 임의로 abc123 이라는 계정을 생성해 두었습니다. 악의적인 사용자가 abc123’ OR (LENGTH(DATABASE())=1 AND SLEEP(2)) – 이라는 구문을 주입하였습니다. 여기서 LENGTH 함수는 문자열의 길이를 반환하고, DATABASE 함수는 데이터베이스의 이름을 반환합니다.

- 주입된 구문에서, LENGTH(DATABASE()) = 1 가 참이면 SLEEP(2) 가 동작하고, 거짓이면 동작하지 않습니다. 이를 통해서 숫자 1 부분을 조작하여 데이터베이스의 길이를 알아 낼 수 있습니다. 만약에 SLEEP 이라는 단어가 치환처리 되어있다면, 또 다른 방법으로 BENCHMARK 나 WAIT 함수를 사용 할 수 있습니다. BENCHMARK 는 BENCHMARK(1000000,AES_ENCRYPT('hello','goodbye')); 이런 식으로 사용이 가능합니다. 이 구문을 실행 하면 약 4.74초가 걸립니다.

**5. Stored Procedure SQL Injection - 저장된 프로시저 에서의 SQL Injection**
- 저장 프로시저(Stored Procedure) 은 일련의 쿼리들을 모아 하나의 함수처럼 사용하기 위한 것입니다. 공격에 사용되는 대표적인 저장 프로시저는 MS-SQL 에 있는 xp_cmdshell로 윈도우 명령어를 사용할 수 있게 됩니다. 단, 공격자가 시스템 권한을 획득 해야 하므로 공격난이도가 높으나 공격에 성공한다면, 서버에 직접적인 피해를 입힐 수 있는 공격 입니다.

**6. Mass SQL Injection - 다량의 SQL Injection 공격**

- 2008년에 처음 발견된 공격기법으로 기존 SQL Injection 과 달리 한번의 공격으로 다량의 데이터베이스가 조작되어 큰 피해를 입히는 것을 의미합니다. 보통 MS-SQL을 사용하는 ASP 기반 웹 애플리케이션에서 많이 사용되며, 쿼리문은 HEX 인코딩 방식으로 인코딩 하여 공격합니다. 보통 데이터베이스 값을 변조하여 데이터베이스에 악성스크립트를 삽입하고, 사용자들이 변조된 사이트에 접속 시 좀비PC로 감염되게 합니다. 이렇게 감염된 좀비 PC들은 DDoS 공격에 사용됩니다.

<br>

### SQL Injection 대응 방안

**1. 입력 값에 대한 검증**

- SQL Injection 에서 사용되는 기법과 키워드는 엄청나게 많습니다. 사용자의 입력 값에 대한 검증이 필요한데요. 서버 단에서 화이트리스트 기반으로 검증해야 합니다. 블랙리스트 기반으로 검증하게 되면 수많은 차단리스트를 등록해야 하고, 하나라도 빠지면 공격에 성공하게 되기 때문입니다. 공백으로 치환하는 방법도 많이 쓰이는데, 이 방법도 취약한 방법입니다. 예를 들어 공격자가 SESELECTLECT 라고 입력 시 중간의 SELECT가 공백으로 치환이 되면 SELECT 라는 키워드가 완성되게 됩니다. 공백 대신 공격 키워드와는 의미 없는 단어로 치환되어야 합니다.

**2. Prepared Statement 구문사용**

- 요즘에 쓰이는 거의 모든 데이터베이스 엔진은 유저 입력이 의도치 않은 동작을 하는 걸 방지하는 escape 함수와 prepared statement를 제공한다. prepared statement 는 변수를 문자열로 바꾸는것이라 안전하다.
- Prepared Statement 구문을 사용하게 되면, 사용자의 입력 값이 데이터베이스의 파라미터로 들어가기 전에DBMS가 미리 컴파일 하여 실행하지 않고 대기합니다. 그 후 사용자의 입력 값을 문자열로 인식하게 하여 공격쿼리가 들어간다고 하더라도, 사용자의 입력은 이미 의미 없는 단순 문자열 이기 때문에 전체 쿼리문도 공격자의 의도대로 작동하지 않습니다.

**3. Error Message 노출 금지**

- 공격자가 SQL Injection을 수행하기 위해서는 데이터베이스의 정보(테이블명, 컬럼명 등)가 필요합니다. 데이터베이스 에러 발생 시 따로 처리를 해주지 않았다면, 에러가 발생한 쿼리문과 함께 에러에 관한 내용을 반환헤 줍니다. 여기서 테이블명 및 컬럼명 그리고 쿼리문이 노출이 될 수 있기 때문에, 데이터 베이스에 대한 오류발생 시 사용자에게 보여줄 수 있는 페이지를 제작 혹은 메시지박스를 띄우도록 하여야 합니다.

**4. 웹 방화벽 사용**
- 웹 공격 방어에 특화되어있는 웹 방화벽을 사용하는 것도 하나의 방법입니다. 웹 방화벽은 소프트웨어 형, 하드웨어 형, 프록시 형 이렇게 세가지 종류로 나눌 수 있는데 소프트웨어 형은 서버 내에 직접 설치하는 방법이고, 하드웨어 형은 네트워크 상에서 서버 앞 단에 직접 하드웨어 장비로 구성하는 것이며 마지막으로 프록시 형은 DNS 서버 주소를 웹 방화벽으로 바꾸고 서버로 가는 트래픽이 웹 방화벽을 먼저 거치도록 하는 방법입니다.



### 요약

- SQL Injection이란 웹 사이트의 보안의 허점을 이용하여 SQL 쿼리문을 수정하여 데이터베이스의 중요한 정보를 가져오는 해킹 기법이다.
- 간단한 쿼리문 조작을 통한 기법부터 자동화 스크립트를 통해 핵심 정보를 빼내오는 기법, 다량의 SQL Injection을 통한 기법까지 다양한 기법이 존재한다.
- 대응 방안으로 입력값에 대해 철저하게 검증, 데이터베이스 엔진에서 제공하는 escape 함수와 prepared statement를 활용하여 대응하거나 웹 방화벽을 사용하기도 한다.



### 참고
- https://m.blog.naver.com/lstarrlodyl/221837243294
- https://namu.wiki/w/SQL%20injection
- https://noirstar.tistory.com/264
- https://m.mkexdev.net/427