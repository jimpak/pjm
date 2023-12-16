# tuple : 다양한 자료형을 순차적으로 저장하는 집합 자료형
# list와 다르게 원소 변경이 불가능
# 상수적인 특징을 가지고 있기 때문에 list보다 연산이 빠르다.
t = tuple()
print(id(t))
t = (1, 2, 3)
print(id(t))
print(t, type(t), type(t[0]))
print(t[0], t[0:2])
# t[0] = 5 # 오류발생!! 튜플은 변형 불가능.

t1 = ('hello')
print(t1, type(t1)) # 원소가 1개면 튜플 X
t2 = 'a', 'b', 'c'
print(t2, type(t2)) # 소괄호를 적용 안해도 tuple로 적용
print(len(t2))
t3 = tuple()
print(len(t3), type(t3))
t4 = tuple(range(10)) # 0~9
print(t4, len(t4))
t5 = t2 + t3
print(t5, type(t5))