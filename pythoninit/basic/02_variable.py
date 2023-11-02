# 변수이름 명명규칙
# 1) 예약어 안됨
# 2) _, 영문자, 숫자(시작 안됨)
# 3) 특수문자, 공백 안됨
# 4) 클래스는 Pascal case, 변수나 함수는 Snake case
# 5) Python에서는 null 대신해서 None을 사용

# 변수의 선언과 초기화(Assignment) => 동적 할당
a = 10
b = True
c = 3.14
d = "hello"
e = 'c'
f = {"name", "age", "email"}
print(type(a), type(b), type(c), type(d), type(e), type(f))

# 1. type Number(int, float)
a = 10
print(a)
print(type(a))
print("===============")
a = 12.345
print(a)
print(type(a))
print("===============")
a = 0b0101
print(a)
print(type(a))
print("===============")
a = 0o12
print(a)
print(type(a))
print("===============")
a = 0x2a
print(a)
print(type(a))
print("===============")
a = 123e2
print(a)
print(type(a))
print("===============")
a = 123E-2
print(a)
print(type(a))
print("===============")
a = 'a' + 'b' + \
    'c' + 'd'
print(a)
print(type(a))
print("===============")
a = ('a' + 'b'
    'c' + 'd')
print(a)
print(type(a))
print("===============")

print(format(10, 'b')) # 2진수
print(format(10, 'o')) # 8진수
print(format(10, 'x')) # 16진수 소문자
print(format(10, 'X')) # 16진수 대문자
print(format(10, 'd')) # 10진수
print(format(10, '#b')) # 문자열 2진수
print(format(10, '#o')) # 문자열 8진수
print(format(10, '#x')) # 문자열 16진수 소문자
print(format(10, '#X')) # 문자열 16진수 대문자
print(format(10, '#d')) # 문자열 10진수

print("\n\n")
# 2. type boolean :: bool
power = False
power = (1 > 2) or (2 < 5)
print(power)
print(type(power))