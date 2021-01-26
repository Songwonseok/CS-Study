# 비트 마스크



### 비트란?

- 특정 알고리즘으로 칭하진 않지만, bit를 활용한 프로그래밍 테크닉이라고 할 수 있다.

- 비트의 맨 왼쪽의 0 / 1 은 양수 음수를 판별한다. (1 == - | 0 == +)

- low level data가 아닌 경우에는 다룰 일은 없지만, 이해가 필요한 경우 다뤄야한다.

  > low level data(Physical data model) :  물리 데이터, 컴퓨터가 알아듣는 data의 형태 ex ) 이진수

- 비트(이진수) 란 컴퓨터에서 사용되는 데이터의 최소 단위이다.

  > 0 / 1 === true / false === on / off

- 1 1 0 1 (2) ㅡㅡ> 13 (10)



### 비트마스크란?

- 비트의 형태를 활용하여, 정수의 이진수 표현을 활용한 알고리즘 테크닉 기법이다.
- 비트마스크의 장점
  - **빠른 수행시간** : 비트마스크 연산은 O(1)에 구현되는 것이 많기 때문에, 적절히 사용할 경우 다른 자료구조를 사용하는 것보다 빠르게 동작한다.
  - **간결한 코드** : 다양한 집합 연산들을 반복문등을 사용하지 않고 비트 연산의 특성을 이용해 한 줄에 사용하기에 간결하게 코드를 작성할 수 있다.
  - **적은 메모리 사용** : 비트마스크를 이용하면 같은 데이터를 더 적은 메모리를 사용해 표현할 수 있다. 이 것이 비트마스크를 사용하는 가장 큰 이유이며 공간복잡도를 많이 줄일 수 있다.



### 비트연산자

- ![bitmask-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Algorithm/image/bitmask-1.png)

- ![bitmask-2](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Algorithm/image/bitmask-2.png)

- 시프트 연산 (<< . >>) : 왼쪽 또는 오른쪽으로 비트를 옮긴다.

  > 0000 1010 << 2 == 0010 1000
  >
  > 0000 1010 >> 2 == 0000 0010
  >
  > 옮길 비트를 꺽쇠 왼편, 옮길 횟수를 꺽쇠 오른편에 위치시킨다.
  >
  > 왼쪽 시프트는 a * 2 ^ b | 오른쪽 시프트는 a / 2 ^ b를 의미한다.

- 비트 연산을 통해 삽입, 삭제, 조회를 하는 방법

  > 초기값 1010 이 있을 때, 2번째 비트의 값을 1로 변경시키는 방법 return 1110
  >
  > 1010 | 1 << 2
  >
  > 1010 | 0100
  >
  > return 1110
  >
  > 1. 시프트 연산을 통해 2번째 비트만 1로 할당되어 있는 이진수를 만든다.
  > 2. 이 후 OR 연산을 통해 원하는 결과를 얻을 수 있다.
  >
  > 
  >
  >
  > 반대로 2번째 비트의 값을 0으로 변경시키는 방법 return 1010
  >
  > 1110 & ~1(1110) << 2
  >
  > 1110 & 1011
  >
  > return 1010
  >
  > 
  >
  >
  > i 번째 비트의 값을 알 수 있는 방법
  >
  > A & (1 << i)
  >
  > 2번째 비트 ㅡ> 1010 & (1 << 2) = 1010 & 0100  return 0
  >
  > 3번째 비트 ㅡ> 1010 & (1 << 3) = 1010 & 1000  return 1
  >
  >
  > AND연산과 시프트연산을 통해 i번째 비트의 값을 알 수 있다.

  

### 비트마스크를 이용한 집합의 구현

1. 꽉 찬 집합 구하기

   - ```java
     int set = (1<<20) - 1;
     System.out.println(Integer.toBinaryString(1 << 20));
     System.out.println(Integer.toBinaryString(set);
     
     // 100000000000000000000
     // 11111111111111111111
     ```

     

2. 원소 추가

   - ```java
     원소를 추가한다는 것은 해당 원소의 비트를 1로 만드는 것과 같다.
     p 번째 원소를 추가하고 싶다면,
     
     set |= (1 << p);
     // 결과값은 위 set과 동일합니다
     ```

   

3.  원소의 포함 여부 확인

   - ```java
     해당 원소에 해당하는 비트값이 1이면 되므로 찾고자 하는 원소의 위치만큼 시프트 , AND연산
     0이면 해당 원소가 없는 뜻
     int p = 3;
     if(set & (1 << p)) System.out.println("OK");
     ```

     

4.  원소의 삭제

   - ```java
     단순히 해당 비트에 1을 빼주면 될 것 같지만, 해당 비트가 0인 상태라면 위험하다.
     이를 해결하기 위해 다음과 같이 해야함
     
     set &= ~(1 << p);
     이러면 문제 없이 해당원소를 제거 할 수 있다.
     ```

   

5.  원소의 토글

   - ```java
     토글 : 해당 비트가 꺼져있으면 켜고, 켜져있으면 끄는 방식
     XOR 방식을 이용한다. 둘 다 1이거나, 0이면 return 0 아니라면 return 1
         
     set ^= (1 << p);
     ```

   

6. 집합간의 연산

   - ```java
     비트마스크를 이용해 집합간의 연산을 간단히 할 수 있다.
     int a = 77;
     int b = 15;
     int added = (a | b);
     int intersection = (a & b);
     int removed = (a & ~b);
     int toggled = (a ^ b);
     System.out.print("a(2) : "+Integer.toBinaryString(a)+" b(2): "+Integer.toBinaryString(b)+"\n");
     		System.out.println(Integer.toBinaryString(added));
     		System.out.println(Integer.toBinaryString(intersection));
     		System.out.println(Integer.toBinaryString(removed));
     		System.out.println(Integer.toBinaryString(toggled));
     /*
         a(2) : 1001101 b(2): 1111
         1001111
         1101
         1000000
         1000010
     */
     ```

   - 

7. 집합의 크기 구하기

   - ```java
     비트마스크를 이용해 집합을 구현할 때 원소의 수를 구하는 방법은 딱히 없으므로, 모든 원소를 순회하며 비트가 켜져있는지 확인해야한다.
     
     public static int bitCount(int x) {
         if(x==0) return 0;
         return x%2 + bitcount(x/2);
     }
     
     public static void main(String[] args){
         int a = 10;
     	System.out.println(bitCount("a: "+a));
     }
     
     // a: 2
     ```

   - 

8. 최소 원소 찾기

   - ```java
     집합의 최소비트를 구하는 방법, 1010 1000에서 최소원소인 1000을 구하는 방법이다. 보수의 특성을 이용한다.
     
     int first = (set & -set);
     System.out.println(Integer.toBinaryString(first));
     System.out.println(Integer.toBinaryString(set));
     System.out.println(Integer.toBinaryString(-set));
     /*
     	1
     	11111111111111111111
     	11111111111100000000000000000001
     */
     
     1010 1000에 -를 붙이면 2의 보수를 취하게 되는데 0101 1000 꼴이 된다. 2의 보수의 특성상 최하위인 켜진비트부터 끝까지는 유지된 채 나머지 비트는 반전되어 있다.
     ```

   - **보수** : 어떤 수를 커다란 **2의** 제곱수에서 빼서 얻은 이진수이다. **2의 보수**는 대부분의 산술연산에서 원래 숫자의 음수처럼 취급된다.

   

9. 최소 원소 지우기

   - ```java
     set &= (set - 1);
     
     집합에 1을 빼주면 켜져있는 최하위 비트가 0이 되고 그 뒤는 전부 1이 된다. 
     0101 1000 - 1 = 0101 0111이 된다. 이 상태에서 AND연산을 해주면 0101 0000이 되고
     최소원소가 지워진다.
     ```



### 참고 블로그

- [Data Model의 개념](https://m.blog.naver.com/sjc02183/221634530501)
- [비트마스크1](https://mygumi.tistory.com/361)
- [비트마스크2](https://his2070.tistory.com/2)

 

## 한 줄 요약

비트마스크 : 계륵같은 존재, java에서는 많이 사용하지는 않지만 알고리즘 테크닉으로 알아둔다면 퍼포먼스를 업그레이드 할 수 있는 테크닉



비트연산을 통해 시간, 메모리를 절약할 수 있는 알고리즘 테크닉