# 객체와 객체 상호작용

1. 사물
    1. 설명
       1. 문제를 사물로 분해하여 처리한다
    1. 제약
        1. 큰 문제를 사물로 분해한다
        1. 각 사물은 데이터의 캡슐이며, 프로시져를 드러낸다
        1. 데이터에 직접 접근하지 않는다
        1. 캡슐은 다른 캡슐의 프로시져를 사용할 수 있다
1. 우편함
    1. 설명
        1. 문제를 사물로 분해하여 처리한다
    1. 제약
        1. 사물은 단 하나의 프로시저를 드러낸다. 이 프로시저를 통해 메시지를 받고 처리 할 수 있다
        1. 메시지를 처리한 결과로 다른 캡슐에 메시지를 보낼 수 있다
1. 닫힌 맵 (프로토 타이핑)
    1. 설명
        1. 문제를 사물로 분해하여 처리한다
    1. 제약
        1. 사물은 키를 값을 맵핑하는 맵이며, 그 값은 변수/함수 이다
        1. 프로시저는 자신의 슬롯을 참조함으로써 맵 자체를 닫는다
1. 추상사물
1. 할리우드
1. 게시판