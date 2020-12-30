# Array & ArrayList & LinkedList



## Array (배열)

- 여러 데이터를 하나의 이름으로 그룹핑해서 관리 하기 위한 자료구조. `index`와 값의 쌍으로 구성

- index는 값에 대한 **유일무이한 식별자**

  ![array-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DataStructure/images/array-1.PNG)

- 논리적 저장 순서와 물리적 저장 순서가 일치 => index로 해당 원소에 접근할 수 있다. (`O(1)`)

- random access(비순차적 접근)가 가능

- **연속된 메모리의 공간** 으로 이루어져 있다

- 배열은 **정의와 동시에 길이를 지정** 하며 길이를 바꿀 수 없다.

-----

### 장점

- 인덱스를 통한 검색이 용이함.
- 연속적이므로 메모리 관리가 편하다.

### 단점

- 크기가 고정되어 있기 때문에 어떤 엘리먼트가 삭제되면, 삭제된 상태를 빈 공간으로 남겨두어야 한다. => `메모리 낭비`

- 정적이므로 배열의 크기를 컴파일 이전에 정해주어야 한다.

- 컴파일 이후 배열의 크기를 변동 할 수 없다.

- 삭제 시, 연속적 특징이 깨진다.

- 삭제한 원소보다 큰 인덱스 갖는 원소들을 shift 해줘야 하는 비용 발생 = 시간복잡도 O(n)

- Array 자료구조의 삭제 기능에 대한 time complexity --> worst case : O(n)삽입 시에도 첫번째에 원소를 추가하고 싶다면 1씩 shift해줘야 한다. --> O(n)

  

### Java의 배열 초기화

배열은 생성과 동시에 **자동초기화** 된다. 자동초기화란 자동으로 초기값을 주는 것.

- 타입별 자동 초기화 값
- 정수(int, long) : 0
- 실수(double, float) : 0.0
- 논리값(boolean) : false
- 문자(char) : 공백 ( 공백문자 \u0000)
- Object(String 포함) : null



-----

## List

- 리스트는 순서가 있는 엘리먼트의 모임으로 배열과는 다르게 빈 엘리먼트는 절대 허용하지 않는다.
- 리스트는 배열이 가지고 있는 인덱스라는 장점을 버리고 대신 **빈틈없는 데이터의 적재** 라는 장점을 취함
- 리스트에서 인덱스는 몇 번째 데이터인가 정도(순서)의 의미를 가진다. (배열-Array에서의 인덱스는 값에 대한 유일무이한 식별자)
- 빈 엘리먼트는 허용하지 않는다. => java에서는 허용하는 경우가 있음
- 순차성을 보장하지 못하기 때문에 **spacial locality** 보장이 되지 않아서 cash hit가 어렵다.(데이터 갯수가 확실하게 정해져 있고, 자주 사용된다면 array가 더 효율적이다.)
- 불연속적으로 메모리 공간을 차지.
- 포인터를 통한 접근

> ##### Spatical locality
>
> - 특정 클레스터의 기억 장소들에대해 참조가 집중적으로 이루어지는 경향.
> - 프로그램 실행시 접근하는 메모리의 영역은 이미 접근이 이루어진 영역의 근처일 확률이 높다는 프로그램 성격 표현.

### 장점

- 포인터를 통하여 다음 데이터의 위치를 가르켜고 있어 삽입 삭제의 용이.
- 동적이므로 크기가 정해져 있지 않다.
- 메모리의 재사용 편리
- 불연속적이므로 메모리 관리의 편리

### 단점

- 검색 성능이 좋지 않다.
- 포인터를 통해 다음 데이터를 가르키므로 추가적인 메모리 공간 발생.

|       | 추가/삭제 | 조회 |
| ----- | --------- | ---- |
| Array | 느림      | 빠름 |
| List  | 빠름      | 느림 |

- 배열 : 데이터의 크기가 정해져 있고, 추가적인 삽입 삭제가 일어 나지 않으며 검색을 필요로 할 때 유리.
- 리스트 : 데이터의 크기가 정해져 있지 않고, 삽입 삭제가 많이 일어나며, 검색이 적은 경우 유리.



### Java List Collection

List는 Collection 인터페이스를 확장한 자료형으로 동일한 데이터의 중복 입력이 가능하며 순차적이고 다량의 데이터를 입력할 때 주로 사용합니다. 종류는 Vector, Arraylist, Linkedlist가 있다.



## ArrayList

일반 배열과 ArrayList는 인덱스로 객체를 관리한다는 점에서 동일하지만, 크기를 동적으로 늘릴 수 있다는 점에서 차이점이 있다. ArrayList는 내부에서 처음 설정한 저장 용량(capacity)가 있다. 설정한 저장 용량 크기를 넘어서 더 많은 객체가 들어오게 되면, 배열 크기를 **1.5배**로 증가시킴

```null
// DEFAULT_CAPACITY=10
// 기본 저장용량 10으로 리스트 생성
List<String> list = new ArrayList<>(); 

// 저장 용량을 100으로 설정해 ArrayList 생성 
List<String> list = new ArrayList<>(100);
```

ArrayList에서 특정 인덱스의 객체를 제거하게 되면, 제거한 객체의 인덱스부터 마지막 인덱스까지 모두 앞으로 1칸씩 앞으로 이동한다. 객체를 추가하게 되면 1칸씩 뒤로 이동하게 된다. 인덱스 값을 유지하기 위해서 전체 객체가 위치가 이동한다.
따라서 **잦은 원소의 이동, 삭제가 발생할 경우 ArrayList보다 LinkedList를 사용하는 것이 좋다.**



### 배열과 ArrayList의 차이

- 배열은 크기가 고정되어있지만 arrayList는 사이즈가 동적인 배열이다.
- 배열은 primitive type(int, byte, char 등)과 object 모두를 담을 수 있지만, arrayList는 object element만 담을 수 있다.
- 배열은 제네릭을 사용할 수 없지만, arrayList는 타입 안정성을 보장해주는 제네릭을 사용할 수 있다.
- 길이에 대해 배열은 length 변수를 쓰고, arrayList는 size() 메서드를 써야한다.
- 배열은 element들을 할당하기 위해 assignment(할당) 연산자를 써야하고, arrayList는 add() 메서드를 통해 element를 삽입한다.

```java
// ArrayList.class

private Object[] grow(int minCapacity) {
        // newCapacity 길이의 새 배열에 기존 배열 복사
        return this.elementData = Arrays.copyOf(this.elementData, this.newCapacity(minCapacity));
    }
    
 private int newCapacity(int minCapacity) {
        int oldCapacity = this.elementData.length;
        // 기존 리스트 길이 + (기존리스트길이/2)
        // 길이가 부족할 경우 1.5배 길이를 늘린다
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (this.elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                return Math.max(10, minCapacity);
            } else if (minCapacity < 0) {
                throw new OutOfMemoryError();
            } else {
                return minCapacity;
            }
        } else {
            return newCapacity - 2147483639 <= 0 ? newCapacity : hugeCapacity(minCapacity);
        }
    }
```

### ArrayList의 삽입/삭제 과정

![img](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DataStructure/images/array-2.PNG)

![img](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DataStructure/images/array-6.PNG)



-----



## LinkedList

노드 간에 연결(link)을 통해서 리스트로 구현된 객체이다. 다음 노드의 위치 정보만 가지고 있으며 **인덱스를 가지고 있지 않기 때문에** 탐색시 `순차접근`만 가능 (노트 탐색 시 시간이 많이 소요될 수 있음)(randomAccess 불가능)
노드 추가/삭제는 위치정보의 수정만으로 가능하기 때문에 성능이 좋음

LinkedList는 ArrayList와는 달리 List 인터페이스를 구현한 AbstractList를 상속하지 않고 AbstractSequentialList를 상속한다.

![img](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DataStructure/images/array-3.PNG)

### LinkedList의 삽입/삭제 과정

![img](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DataStructure/images/array-4.PNG)

![img](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DataStructure/images/array-5.PNG)