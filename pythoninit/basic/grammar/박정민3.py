# 1.
print("100")
print(100)
print(50+50)
# print("50+50") # 문자열이기 때문에 연산되지 않음.

# 2.
print("%04d" % 876) # 0876
print("%5s" % "CookBook") # CookBook
print("%1.1f" % 123.45) # 123.5

# 3.
# (1) 다음탭으로 이동 : \t
# (2) 뒤로 한 칸 이동 : \b
# (3) \를 출력 : \\

# 4.
# 불 : bool
# 정수 : int
# 실수 : float
# 문자 : str

# 5.
num1 = 100
# 100 = num1 # 오류발생
num1 = num2 = 100
num1 = num2 = num3 = 100

# 6.
# (1) 대입연산자 : =
# (2) 나누기(몫) : //
# (3) 나머지 값 :  %
# (4) 제곱 : **

# 7.
# (1) int()
# (2) float()
# (3) str()

# 8.
num = 100
num += 1
num -= 1
num *= 1
num /= 1
num = int(num)
print(num) # 100

# 9.
num1, num2 = -100, 100
print(num1==num2) # False
print(num1>=num2) # False
print(num1<=num2) # True
print(num1!=num2) # True

# 10.
print((num1==num2)and(num1!=num2)) # False
print((num1==num2)or(num1!=num2)) # True
print((num1>=num2)and(num1<=num2)) # False
print((num1>=num2)or(num1<=num2)) #True

# 11.
num=100
# if num=100:
if num is 100:
    print(num)
# if num equal 100:
# if num==100:

# 12.
num = 0
if num > 0:
    print("케이스1", end = ' ')
else:
    print("케이스2", end = ' ')
print("케이스3", end = ' ')
# 케이스2 케이스3 출력
# 조건식에 의해 케이스2가 출력되고 케이스3는 조건식과 상관없이 출력

print()

# 13.
num = (
    int(input("정수를 입력하세요 : ")))
if num % 5 != 0:
    print("5의 배수가 아닙니다.")
else:
    print("5의 배수입니다.")

# 14.
score = int(input("정수를 입력하세요 : "))
if score >= 90:
    print("장학생", end=' ')
elif score >= 60:
        print("합격", end=' ')
else:
    print("불합격", end=' ')
print("입니다. ^^")

# 15.
num = 5
if num % 2 == 0:
    res = '짝수'
else:
    res = '홀수'
print(res)
res = '짝수' if num % 2 == 0 else '홀수'
print(res)

# 16.
# 101번. i값이 0 ~ 100까지 반복
for i in range(0, 101, 1):
    print(i)

# 17. 5 ~ 0까지 출력
for i in range(5, -1, -1):
    print(i)

# 18.
hap = 0
for i in range(1, 1001, 5):
    hap += i
print(hap)

# 19.
# while(조건식)

# 20.
sum = 0
for i in range(3333, 10000, 1):
    if i % 1234 == 0:
        continue
    elif sum > 100000:
            sum -= (i-1)
            print(sum)
            break
    else:
        sum += i

# 21
for i in range(3, 101, 1):
    mod = 0
    for j in range(2, 101, 1):
        if i != j and i % j == 0:
            mod += 1
    if mod == 0:
        print(i, end=" ")