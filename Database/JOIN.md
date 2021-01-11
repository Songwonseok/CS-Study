# JOIN

### JOIN 이란?

중복 데이터를 피하기 위해서 데이터를 쪼개 여러 테이블로 나눠서 저장된 관계형 데이터베이스에서 분리된 데이터를 원하는 결과로 도출하기 위해 여러 테이블을 조합하기 위해 컬럼 기준으로 행을 합쳐주는 연산이다.



### JOIN의 종류

- 내부 조인 (INNER JOIN)

  - 교차 조인 (CROSS JOIN)

    교차 조인은 두 테이블의 곱집합을 한 결과이다. 특별한 조건 없이 테이블 A의 각 행과 테이블 B의 각 행을 다 조합한 결과를 보여준다.

    ![JOIN-1](C:\Users\박민식\Desktop\MY문서\CS\CS-Study\Database\images\JOIN-1.JPG)

  - 내부 조인

    가장 많이 사용되는 조인 구문 중 하나이며, 조건문에 따라 2개의 테이블 (A,B)의 컬럼을 합쳐 새로운 테이블을 생성하며, 두 테이블의 교집합을 한 결과이다.

    ![JOIN-2](https://user-images.githubusercontent.com/7006837/90200386-93e11200-de12-11ea-831e-ae4ade219726.png)

- 외부 조인 (OUTER JOIN)

  - 왼쪽 조인 (LEFT OUTER JOIN)

    테이블 A의 모든 데이터와 테이블 A,B의 교집합 결과를 포함하는 조인이다.

    ![JOIN-2](C:\Users\박민식\Desktop\MY문서\CS\CS-Study\Database\images\JOIN-2.JPG)

    

    ![JOIN-2-1](C:\Users\박민식\Desktop\MY문서\CS\CS-Study\Database\images\JOIN-2-1.JPG)

    

  - 오른쪽 조인(RIGHT OUTER JOIN)

    테이블 B의 모든 데이터와 테이블 A,B의 교집합 결과를 포함하는 조인이다.

    ![JOIN-3](C:\Users\박민식\Desktop\MY문서\CS\CS-Study\Database\images\JOIN-3.JPG)

    ![JOIN-3-1](C:\Users\박민식\Desktop\MY문서\CS\CS-Study\Database\images\JOIN-3-1.JPG)

    

  - 완전 외부 조인 (FULL OUTER JOIN)

    LEFT OUTER JOIN과 RIGHT OUTER JOIN을 합친 것으로, 양쪽 모두 조건이 일치하지 않는 데이터까지 모두 결합해 출력한다.

    ![JOIN-4](C:\Users\박민식\Desktop\MY문서\CS\CS-Study\Database\images\JOIN-4.JPG)

    ![JOIN-4-1](C:\Users\박민식\Desktop\MY문서\CS\CS-Study\Database\images\JOIN-4-1.JPG)

    

- 셀프 조인 (SELF JOIN)

  자기 자신의 테이블과 조인하는 방법이다.

  ![셀프조인](https://user-images.githubusercontent.com/7006837/90200662-909a5600-de13-11ea-805b-091bd80710bc.png)

  ![JOIN-5](C:\Users\박민식\Desktop\MY문서\CS\CS-Study\Database\images\JOIN-5.JPG)



