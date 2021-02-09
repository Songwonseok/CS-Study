# Index



### DB에서 Index란?

- Table에 어떤 데이터가 어디에 위치하였는지 위치 정보를 가진 주소록의 개념을 가진다.
- Table의 컬럼을 색인화(따로 파일을 저장)하여 Full Scan 하는 것이 아니라 색인화 되어있는 Index 파일을 검색하여 속도를 빠르게 하는 도구
- Index는 Tree 구조로 색인화를 진행한다. (RDBMS에서는 Balance Search Tree 사용 / 다른 Tree 선택 가능)



### Index 장점

- 키 값을 기초로 하여 테이블에서 검색과 정렬 속도를 향상시킨다.
-  질의나 보고서에서 그룹화 작업의 속도를 향상시킨다.
-  인덱스를 사용하면 테이블 행의 고유성을 강화시킬 수 있다.



### Index 단점

- 인덱스를 만들면 .mdb파일의 크기가 커진다.

  (.mdb파일 - Microsoft Database를 나타내는 Microsoft Access Database 파일)

- 여러 사용자 응용 프로그램에서의 여러 사용자가 한 페이지를 동시에 수정 할 수 있는 병행성이 줄어든다.

- 인덱스 된 필드에서 데이터를 업데이트하거나, 레코드를 추가 또는 삭제할 때 성능이 떨어진다.

- 인덱스가 데이터베이스 공간을 차지해 추가적인 공간이 필요해진다.(약 DB의 10%내외의 공간 필요)

- 즉 Index를 사용할 지에 대한 결정은 미리 시험을 해보고 결정하는 것이 가장 좋다.





### Index를 생성해야 하는 경우

- 외래키가 사용되는 열에는 되도록 인덱스를 생성해주는 것이 좋다.
- JOIN에 자주 사용되는 열에는 인덱스를 생성해주는 것이 좋다.



### Index를 생성하지 말아야 하는 경우

- 데이터의 중복도가 높은 열은 인덱스로 만들어도 효용이 없다.( ex) 성별, 타입이 별로 없는 경우 등 )

- INSERT, UPDATE, DELETE가 자주 일어나는 경우

  (인덱스는 SELECT쿼리의 검색속도를 빠르게 하는데에 목적이 있으므로, 이외의 쿼리에서는 느려진다.)



### Index 주의사항

- SELECT쿼리 경우에도 데이터 블록 수, 분포도 등에 따라 인덱스가 빠를수도 있고, Full Scan보다 느려질 수도 있다.



### DML(Data Manipulation Language)에 취약하다.

- INSERT 
  - Index split 현상이 발생 (인덱스의 Block들이 하나에서 두 개로 나누어지는 현상)
  - 성능면에서 매우 불리하다.

- DELETE
  - 테이블에서 데이터가 DELETE 될 경우 - 지워지고 다른 데이터가 그 공간을 사용할 수 있음
  - Index에서 데이터가 DELETE 될 경우 - 데이터가 지워지지 않고, 사용 안 됨 표시만 함
  - 즉, 테이블에서 데이터가 1만건이 있는 경우, 인덱스에는 2만건이 있을 수 있다는 뜻
  - 이런 경우 인덱스를 사용해도 수행속도를 기대하기 힘들다.
- UPDATE
  - 테이블에 UPDATE가 발생할 경우 인덱스에서는 DELETE가 먼저 발생한 후 새로운 작업의 INSERT 작업이 발생한다. **DELETE와 INSERT 두 개의 작업이 인덱스에 동시에 발생** 하여 다른 DML보다 더 큰 부하를 주어 성능을 저하시킨다.



### Index 생성 방법

- PK (Auto-Increasement)
- Unique제약을 정의할 경우 Unique Index



### 인덱스 종류

- 고유 인덱스 ( Unique Index )

  - 유일한 값을 갖는 컬럼에 대해서 생성하는 인덱스로, Unique 옵션을 지정해야 한다.

    CREATE UNIQUE INDEX idx_ukempno_emp ON emp(empno);

- 비고유 인덱스 ( NONUnique Index )

  - 고유 인덱스와 반대

  

- 단일 인덱스 ( Single Index )

  - 한 개의 컬럼으로 구성한 인덱스

    CREATE INDEX idx_ukempno_emp ON emp(empno);

- 결합 인덱스 ( Composite Index )

  - 두 개 이상의 컬럼으로 인덱스를 구성하는 것을 말한다. 예를들어 부서번호와 부서명을 결합하여 인덱스를 설정하는 것과 같다. ( CREATE INDEX idx_dept_com ON index_dept(deptno, dname) );

- 함수 기반 인덱스 ( Function Based Index )

  - 컬럼에 어떠한 산술식을 수행했을 때의 인덱스이다. 



### 참고 블로그

- [데이터베이스 인덱스-1](https://lalwr.blogspot.com/2016/02/db-index.html)
- [데이터베이스 인덱스-2](https://itholic.github.io/database-index/)



### 한 줄 요약

인덱스 : 데이터가 어디에 위치하였는지 위치 정보를 가진 제약있는 주소록