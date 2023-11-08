# 1.
nn = [100, 200, 300]
print(type(nn))  # <class 'list'>




# 2.
import random

nn = []
for _ in range(10):
    num = random.randrange(1, 100)
    nn.append(num)
hap = 0
for i in range(10):
    num = nn[i]
    hap += num
print(hap)  # 306




# 3.
ary1 = [1, 2, 3, 4]
ary2 = []
for i in range(3, -1, -1):
    ary2.append(ary1[i])
print(ary1)  # [1, 2, 3, 4]
print(ary2)  # [4, 3, 2, 1]
ary2.reverse()
print(ary2)



# 4.
# (1) 리스트의 전체 개수를 센다. len()
# (2) 두 리스트를 연결한다. extend()
# (3) 리스트 맨 뒤의 항목을 추출한다. pop()
# (4) 지정한 값을 찾아서 위치를 알아낸다. insert()
# (5) 리스트에서 특정 값의 개수를 센다. count()




# 5.
# 4번 튜플은 insert()사용 불가능




# 6.
# 2번 딕셔너리에서 append()는 사용 불가능
d = {'a':1, 'b':2, 'c':3}
d['d'] = 4
print(d)



# 7.
myData = [[n * m for n in range(1, 3)] for m in range(2, 4)]
print(myData)  # [[2, 4], [3, 6]]




# 8.
# (1) aa = [] -> 나. 리스트
# (2) bb = {} -> 다. 딕셔너리
# (3) cc = () -> 가. 튜플
# (4) dd = None -> 라. 일반 변수




# 9.
# (1) 리스트의 뒤에 리스트를 추가한다. extend()
# (2) 리스트에서 지정한 값을 제거한다. remove()
# (3) 리스트 항목의 순서를 역순으로 만든다. reverse()
# (4) 리스트 맨 뒤의 항목을 빼내고, 빼낸 항목은 삭제한다. pop()




# 10.
myList = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12]
]
print(myList[0][1])  # 2
print(myList[1][3])  # 8
print(myList[2])  # [9, 10, 11, 12]




# 11. 1번
ss = 'IT_CookBook'
print(ss[0])  # I
print(ss[1:2])  # T
print(ss[0:-1])  # IT_CookBoo
print(ss[:4])  # IT_C




# 12.
inStr = 'IT_CookBook_Python'
outStr = ''
for i in range(0, len(inStr)):
    if i % 2 == 0:
        outStr += inStr[len(inStr) - (i + 1)]
    else:
        outStr += '#'
print("원본 내용 -->", inStr)
print("변경 내용 -->", outStr)




# 13.
# (1) 각 단어의 첫 글자를 대문자로 변경 : title()
# (2) 모두 영문 대문자로 변경 : upper()
# (3) 영문 대소문자를 상호 변경 : swapcase()
# (4) 모두 영문 소문자로 변경 : lower()
str = "Boys be Ambitious!"
print(str.upper())
print(str.lower())
print(str.swapcase())
print(str.title())

print(len(str))
print(str.count('i'))  # 글자별, 단어별 카운팅
print(str.find('A'))
print(str.find('o', 10, 18))
print(str.index('A'))
print(str.index('o', 10, 18))
print(str.split())
print(str.split()[1])
print(str.split('be'))
print('_'.join(str.split()))
print(str.replace(' ', '🦁'))
print('ABC'.isupper())
print('ABC'.islower())
str = '  😀Smile  '
print(str.strip())
print(str.rstrip())
print(str.lstrip())
str = '===title==='
print(str.strip('==='))
str = '12321abc111'
print(str.strip('123'))
print(str.lstrip('123'))
print(str.rstrip('123'))

print('abc'.zfill(10))
print('abc'.zfill(3))
print('abc'.ljust(10, '*'))
print('abc'.rjust(10, '*'))
print('abc'.center(10, '*'))


# 14.
str1 = "코딩 중에서 파이썬 코딩이 가장 즐거운 코딩"  # 총 24글자
print(str1.count('코딩'))  # 3
print(str1.rfind('코딩'))  # 22
print(str1.startswith('코딩'))  # True
print(str1.find('파이썬'))  # 7




# 15.
inStr = input("문자열을 입력하세요 :")
upper = ''
lower = ''
kor = ''
num = ''
etc = ''

for i in inStr:
    if ord('A') <= ord(i) <= ord('Z'):
        upper += i
    elif ord('a') <= ord(i) <= ord('z'):
        lower += i
    elif ord('0') <= ord(i) <= ord('9'):
        num += i
    elif ord('가') <= ord(i) <= ord('힣'):
        kor += i
    else:
        etc += i

print(outStr)
print("대문자:%s\n소문자:%s\n숫자:%s\n한글:%s\n기타:%s\n" % (upper, lower, num, kor, etc))

###########################################################################################

answer = ['', '', '', '', '']
inStr = input('문자열을 입력하세요 :')
outStr = ['대문자', '소문자', '숫자', '한글', '기타']

for c in inStr:
    if(c.isupper()): answer[0] += c;
    elif(c.islower()): answer[1] += c;
    elif(c.isnumeric()): answer[2] += c;
    elif(ord(c) >= ord('가') and ord(c) <= ord('힣')): answer[3] += c;
    else: answer[4] += c;

for i in range(0, len(answer)):
    print(outStr[i], ": ", answer[i])
for idx, val in enumerate(answer):
    print(outStr[idx], ": ", val)


# 16.
# 1번. 함수에 대괄호 []는 사용 불가능.
# 3번. 파이썬 내장함수 제공




# 17.
def plus(v1, v2, v3):
    result = 0
    result = v1 + v2 + v3
    return result


hap = plus(100, 200, 300)
print(hap)  # 600




# 18.
def f1(): print(var)

def f2(): var = 10; print(var)

def f3(inputVar):var = inputVar; print(var)

var = 100
f1()  # 100
f2()  # 10
f3(10000)
print(var) # 100


# 19.
# 3번. pass예약어는 그냥 아무 것도 하지 않고 비워 놓을 때 사용한다.
a = 1
if a in (1, 2, 3) and a != 0:
    # print('포함')
    pass # 나중에 정의하려고 지금은 패스
    # raise NotImplementedError
else:
    print('부제')



# 20.
# 2번.




# 21.
def sum(v1, v2):
    result = 0
    result = v1 + v2
    return result


print(sum(10, 20))




# 22.
def myFunc(p1=1, p2=2, p3=3):
    ret = p1 + p2 + p3
    return ret


print("매개변수 없이 호출 -->", myFunc())
print("매개변수가 1개로 호출 -->", myFunc(1))
print("매개변수가 2개로 호출 -->", myFunc(1, 2))
print("매개변수가 3개로 호출 -->", myFunc(1, 2, 3))




# 23.
def func(v1, v2=0, v3=0):
    result = 0
    result = v1 + v2 + v3
    return result


print(func(1))
print(func(1, 2))
print(func(0, 0, 0))
print(func()) # 오류발생
