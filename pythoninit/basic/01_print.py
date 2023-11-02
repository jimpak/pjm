# print()
import time

help(print)

print(52)
print(52, 273, "Hello", "Python")

a = 100
print(type(a))
b = 10
result = a + b
print(result)
a = "hello world"
print(type(a))

print("=== 특수문자 ===")
print("\\")
print("\t")
print("\'")
print('\"')
print('"Hello"', "'World'")
print("\"Hello\"", '\'World\'')
print("hello \n world")

# 여러문자열
print("""저 산자락에 긴 노을 지면
 걸음 걸음도 살며시 달님이 오시네
 """)
print("""큰 바다 있고 푸른 하늘 가진
 이 땅 위에 사는 나는 행복한 사람 아니냐
 """)

# print의 속성 : self, *args, sep=' ', end='\n', file=none
# range(시작숫자, 종료숫자, step)
print(1, 2, 3, 4, 5, sep="😎")
with open('./beautiful_country.txt', 'w') as f:
    print("""저 산자락에 긴 노을 지면 
걸음 걸음도 살며시 달님이 오시네""", file=f)

f = open('beautiful_country.txt', 'r')
lines = f.readlines()
for line in lines:
    print(line)

print("printf 처럼 사용하기")
print("%d %s %3.2f %c" % (100, "LGH", 1234.5678, 48, ), end='\n\n')
print("======================================")

# 들여쓰기로 인한 공백을 없애기 위한 방법
# 문자열이 길 때 \를 이용하여 다음줄에 표기
print('첫번째 줄 \
      두번째 줄 \
      세번째 줄')
print('''    첫번째 줄
    두번째 줄
    세번째 줄''')



# for i in range(10):
#     print(i, end=' ')
#     time.sleep(1)
