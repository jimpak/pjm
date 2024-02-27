# 변수이름 명명규칙
# 1) 예약어 안됨
# 2) _, 영문자, 숫자(시작 안됨)
# 3) 특수문자, 공백 안됨
# 4) 클래스는 Pascal case, 변수나 함수는 Snake case
# 5) Python에서는 null 대신해서 None을 사용
import random

# 변수의 선언과 초기화(Assignment) => 동적 할당
a = 10
b = True
c = 3.14
d = "hello"
e = 'c'
f = {"name", "age", "email"}
print(type(a), type(b), type(c), type(d), type(e), type(f), sep="\n")
print("===============================================")
# del : 변수를 사용하지 않을 경우
del f
del d, e
# print(d) # 오류발생!! del을 사용하여 d변수가 삭제되었기 때문에 조회 불가능

a = 1; b = 2
# temp = a; a = b; b = tmp
a, b = b, a
print("변수 교환: a=%d, b=%d" % (a, b))
print("===============================================")


# 1. type Number(int, long, float, complex)
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

a = random.random() * 100
print(a);
a = random.uniform(1,100)
print(a);

print("=============================================")
b = int(a)
try:
    b = float("a0.12") # 문자열, 수치자료를 int type로 변경
except:
    print("숫자가 아닌 문자열이 포함되어 있습니다.")
print(b)
print(type(b))
b = 10 + complex(2) # 문자열, 수치자료를 complex type로 변경
print("=============================================")

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
power = bool("")
power = bool(None)
power = bool(0)
power = bool(-10)
power = bool("PJM")

print(power)
print(type(power))

# 3. type string :: str
s = "Hello Python"
s = str(12345)
print(s)
print(type(s))

# 4. type character :: chr
c = chr(48)
c = 'A'
c = 'hello' + 'world'
print(c)
print(type(c))

