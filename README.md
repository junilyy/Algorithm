# Algorithm

Java 알고리즘 문제풀이 저장소입니다. 하루 약 30분씩 꾸준히 문제를 풀며 Java 문법을 복습합니다.

## 문제풀이

- [BOJ](boj/solvedac/): 기존 백준 풀이 기록
- [Programmers](programmers/): 앞으로 추가할 프로그래머스 풀이 기록

프로그래머스 풀이는 `programmers/<유형>/<문제번호>_<문제명>/Solution.java`에 저장합니다.
유형 폴더(`implementation`, `data-structure`, `sorting`, `brute-force`, `search`, `greedy`, `dp`)는 해당 문제를 풀 때 생성합니다.
문제명의 공백은 `_`로 바꾸고, 코드 상단 주석에 원본 문제 URL을 남깁니다. 풀이를 저장한 뒤 커밋합니다.

## Java 문법 메모

새롭게 배웠거나 자주 헷갈리는 문법만 간단히 추가합니다.

| 문법 | 설명 |
| --- | --- |
| `ArrayList<Integer>`, `add(value)`, `get(i)`, `size()` | 크기가 변하는 정수 리스트 선언, 값 추가, 인덱스로 조회, 원소 개수 확인 |
| `list.get(list.size() - 1)` | 리스트의 마지막 값 조회. 비어 있으면 사용할 수 없음 |
| `list.stream().mapToInt(n -> n).toArray()` | 리스트를 스트림으로 처리하고, `Integer`를 `int`로 자동 언박싱해 `int[]`로 변환 |
| `Integer::intValue` | 각 `Integer`의 `int` 값을 꺼내는 메서드 참조. `n -> n.intValue()`와 같은 의미 |
| `Arrays.copyOfRange(array, from, to)` | 원본 배열의 일부를 새 배열로 복사. 시작 인덱스 `from`은 포함하고 끝 인덱스 `to`는 제외 |

## 다시 풀어볼 문제

혼자 해결하지 못했거나 복습이 필요한 문제만 추가하고, 혼자 다시 풀 수 있게 되면 제거합니다.
문제 이름에는 원본 문제 링크를 연결합니다.

| 문제 | 유형 | 복습할 내용 |
| --- | --- | --- |
