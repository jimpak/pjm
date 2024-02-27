# Set (중복과 순서가 없는 자료형)
# 순서가 없기 때문에 인덱싱이 지원 안됨
import random

s = set()
print(s, type(s))
s = {1,2,3,4,5}
print(s, type(s))
s = set("Hello") # l은 중복 허용 안됨
print(s, type(s)) # str 군집형 자료형이기에 set으로 변환

s.add(6) # set은 순서가 없기 때문에 출력시 인덱싱 되지 않는다.
print(s, type(s))

lotto = set()
while len(lotto) < 6:
    ball = int(random.random() * 45) + 1
    lotto.add(ball)
lotto = sorted(lotto)
print(lotto)


print(f'{"합집합, 교집합, 차집합 구하기 ":=^30}')
s1 = {1,2,3,4,5}
s2 = {3,4,5,6,7}
print('합집합 : ', s1 | s2, s1.union(s2))
print('교집합 : ', s1 & s2, s1.intersection(s2))
print('차집합 : ', s1 - s2, s1.difference(s2))