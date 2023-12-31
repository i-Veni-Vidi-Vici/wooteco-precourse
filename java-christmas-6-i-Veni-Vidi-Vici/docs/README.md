# 🎄 크리스마스 프로모션

## 🔎 핵심 기능 
- 이벤트 혜택 적용

## 🔔 예외 처리
- 잘못된 값을 입력할 경우, `IllegalArgumentException` 발생
- 모든 에러 메시지는 **"[ERROR]"** 시작
- 에러 메시지 출력 후, 그 부분부터 재입력
- 제공된 에러 메시지는 해당 메시지로 사용

## 🔧 기능

### 예약 날짜
- 1~31 범위
#### 예외 처리
- 범위를 벗어날 때
---

### 예약 메뉴
#### 1. 예약된 메인 메뉴 개수 계산
- 주말 할인 계산에 사용

#### 2. 예약된 디저트 메뉴 개수 계산
- 평일 할인 계산에 사용

#### 3. 총 주문 금액 계산
- 할인 전 총 주문 금액 출력에 사용
- 할인 후 예상 결제 금액 계산에 사용

#### 예외 처리
- 예약한 메뉴 중 1개 미만인 메뉴가 있을 때
- 오직 음료만 예약할 때
- 예약한 메뉴 수 가 20개를 넘어갈 때
---

### ✨ 혜택 
#### 1. 총 혜택 금액 계산
- 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
#### 2. 할인 후 예상 결제 금액 계산
- 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액 합계
- 증정 이벤트는 할인 금액에서 제외
#### 3. 증정 이벤트 대상 확인
- 증정 메뉴 출력할 때 사용

#### 혜택 적용
- 총주문 금액 10,000원 이상부터 적용
##### 1. 크리스마스 디데이 할인
- 1~25일
- 1일, 할인 1000원으로 시작
- 2일 부터 25일까지, 매일 100원씩 증가
##### 2. 평일 할인
- 1~31일 중 일~목 요일
- 디저트 메뉴, 1개당 2,023원 할인
##### 3. 주말 할인
- 1~31일 중 금, 토 요일
- 메인 메뉴, 1개당 2,023원 할인
##### 4. 특별 할인
- 이벤트 달력에 별이 있을 때
  - (3,10,17,24,31) 12월 모든 일요일 + (25일) 크리스마스
- 총주문 금액에서 1,000원 할인
##### 5. 증정 이벤트
- 1~31일
- 할인 전 총 주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
##### 6. 이벤트 배지 
- 총 혜택 금액에 따라, 배지 부여
- 배지 종류
  - 0원 이상: 없음
  - 5천 원 이상: 별
  - 1만 원 이상: 트리
  - 2만 원 이상: 산타
---

### 유틸
#### 1. 문자열을 정수로 변환
##### 예외 처리
- 정수 이외의 값 일 때
  -  ex) 문자, 공백, 1.1 
- 숫자 앞에 0이 존재할 때
  - ex) 01, 00

#### 2. 문자열을 주문메뉴 자료형으로 변환
- 콤마(,)로 메뉴를 구분
- 하이픈(-)으로 음식과 수량을 구분
##### 예외 처리
- 문자열이 형식에서 벗어날 때
  - ex) 파스타--1
- 문자열 마지막에 콤마가 존재할 때
  - ex) 파스타-1,
- 중복된 문자열(메뉴)이 들어올 때
  - ex) 파스타-1,파스타-2
---

### 입력
- 제공된 라이브러리로 사용
  - Console.readLine()
#### 1. 예약 날짜 입력
##### 출력
```
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
```
#### 2. 예약 메뉴 입력
##### 출력
```
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
```
---

### 출력
#### 1. 12월 이벤트 플래너 시작 문구 출력
```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
```
#### 2. 예약한 날짜에 대한 첫 이벤트 문구 출력
```
12월 {예약한 날짜}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
```
#### 3. 예약한 메뉴 출력
- 주문한 메뉴와 수량 출력
- 주문 메뉴 출력 순서 자유
```
<주문 메뉴>
{예약한 메뉴} {수량}개
아이스크림 2개
```
#### 4. 할인 전 총 주문 금액 출력
- 금액을 쉼표(,)로 천 단위 구분
```
<할인 전 총주문 금액>
{금액}원
```
#### 5. 증정 메뉴 출력
- 증정 여부에 따라, 샴페인 1개 또는 없음 출력
```
<증정 메뉴>
{샴페인 1개 또는 없음}
```
#### 6. 혜택 내역 출력
- 금액을 쉼표(,)로 천 단위 구분
- 적용된 혜택 내역만 출력
- 적용된 혜택이 없을 경우, **"없음"** 출력
- 혜택 출력 순서는 자유
```
<혜택 내역>
{적용된 혜택}: -{혜택 금액}원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
```
#### 7. 총 헤택 금액 출력
- 금액을 쉼표(,)로 천 단위 구분
- 적용된 혜택이 없을 경우, **"없음"** 출력
```
<총혜택 금액>
-{총 혜택 금액}원
```
#### 8. 할인 후 예상 결제 금액
```
<할인 후 예상 결제 금액>
{예상 결제 금액}원
```
#### 9. 이벤트 배지 출력
```
<12월 이벤트 배지>
{이벤트 배지 또는 없음}
```
---

## 🎁 추가 기능
### 메뉴판 보기 
- 고객이 메뉴판을 보기 원할 수도 있기 때문에 기능 추가
- 메뉴판을 보기 원치 않을 때에는 스킵 가능
- 입력 값 1 = 메뉴판 보기, 2 = 스킵
- ApplicationTest로 인해, 주석처리 -> 사용시 주석 해제 
#### 예외 처리
- 입력된 값이 1 또는 2가 아닐 때

#### 메뉴판 옵션 입력
##### 출력
```
"우테코 메뉴를 보기 원하시면 1번, 원치 않으시면 2번을 눌러주세요."
```
#### 메뉴판 출력
- 금액을 쉼표(,)로 천 단위 구분
- 메뉴판 보기를 스킵할 경우, 다음 단계로 이동  
```
<애피타이저>
양송이수프(6,000원), 타파스(5,500원), 시저샐러드(8,000원)
      
<메인>
티본스테이크(55,000원), 바비큐립(54,000원), 해산물파스타(35,000원), 크리스마스파스타(25,000원)
      
<디저트>
초코케이크(15,000원), 아이스크림(5,000원)
      
<음료>
제로콜라(3,000원), 레드와인(60,000원), 샴페인(25,000원)
```




