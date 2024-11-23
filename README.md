# 로또

## 입력
- [x] 로또 구입 금액을 입력 받는다
  - Exception 
  - [x] 공백을 입력할 경우, 예외를 발생시킨다.
  - [x] 양의 정수가 아닐경우, 예외를 발생시킨다.
  - [x] 구입 금액은 1,000원 단위가 아닐경우, 예외를 발생시킨다.
  
- [x] 당첨 번호를 입력받는다. 
  - Exception
  - [x] 입력받은 당첨번호가 숫자가 아닐경우, 예외를 발생시킨다.
  - [x] 입력받은 당첨번호가 6자리가 아닐경우, 예외를 발생시킨다.
  - [x] 중복된 당첨번호가 존재할 경우, 예외를 발생시킨다.
  - [x] 유효한 범위의 숫자가 아닐경우, 예외를 발생시킨다.


- [x] 보너스 번호를 입력받는다.
  - Exception
    - [x] 양의 정수가 아닐 경우, 예외를 발생시킨다.
    - [ ] 유효한 범위의 숫자가 아닐경우, 예외를 발생시킨다.
    - [ ] 당첨 번호에 보너스 번호가 이미 존재한다면, 예외를 발생시킨다.

## 랜덤 번호 생성
- [x] 6자리의 랜덤한 로또번호를 생성한다.
  - [x] 해당되는 숫자의 범위로 번호를 생성한다.
  - [x] 랜덤번호는 중복되어선 안 된다.

## 로또 생성
- [x] 생성된 랜덤 번호를 기준으로, 로또 객체를 생성한다.
  - Exception
  - [x] 랜덤번호가 6개가 아닐경우, 예외를 발생시킨다.

## 구매 수량 계산
- [x] 구입금액 / 로또 금액을 계산해 몇 개의 로또를 구매할 수 있는지 계산한다. 

## 구매
- [ ] 구입금액 / 로또 금액 계산 결과 만큼 반복해 랜덤 번호를 생성한다.

## 결과 계산
- [ ] 당첨 내역을 계산한다.

## 수익률 계산
- [ ] 총 당첨 금액 + 로또 구매 금액을 계산해 총 수익률을 계산한다.
  - [ ] 수깅률은 소수점 둘째 자리에서 반올림 한다.

## 출력
- [x] 구매한 로또수량만큼 로또 번호를 출력한다.
- [ ] 당첨 통계를 출력한다.
- [ ] 총 수익률을 출력한다.