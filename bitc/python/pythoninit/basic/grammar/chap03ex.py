from tkinter import simpledialog

# 12
num = 0
if num > 0:
  print("케이스1", end=' ')
else:
  print("케이스2", end=' ')
print("케이스3", end='\n ')

# 13
# num = int(input("정수를 입력하세요 : "))
# num = simpledialog.askstring("Input", "Your Answer?", parent=None)
# num = int(num)
# if num % 5 != 0:
#   print("5의 배수가 아닙니다.")
# else:
#   print("5의 배수입니다.")

# 14
# score = int(input("점수를 입력하세요:"))
# if score >= 90:
#   print("장학생", end='')
# elif score >= 60:
#   print("합격", end='')
# else:
#   print("불합격", end='')
# print("입니다.")
# print()

# 15
num = 5
# if num % 2 == 0 :
#  res = '짝수'
# else :
#  res = '홀수'
res = '홀수' if num % 2 == 0 else '짝수'
# res = if num % 2 == 0 '짝수' else '홀수'
res = '짝수' if num % 2 == 0 else '홀수'
# res = if num % 2 == 0 '홀수' else '짝수'
if num % 2 == 0:
  res = 'odd'
else:
  res = 'even'
print(res)

# 18
hap = 0
for i in range(0, 1001, 5):
  hap += i
print(hap)

# 20
total = 0
cnt = 0
for i in range(3333, 10000, 1):
  cnt += 1
  # if (i % 1234 != 0):  # 민혜님 코드
  #   if (total < 100000):
  #     total += i
  #     # continue
  #   else:
  #     total -= i - 1
  #     break
  if i % 1234 == 0:
    continue
  if total + i > 100000:
    print("i: ", i)
    break
  total += i;

print(">>", total, "/", cnt)

# 재흥님 코드
# sum = 0
# cnt = 0
# for i in range(3333, 9999, 1):
#   cnt += 1
#   if (i % 1234 != 0):
#     if (sum + i < 100000):
#       sum += i
#     else:
#       break
#   # else:
#   #   continue
# print(sum, "/", cnt)

# 21
# 소수: 1과 자기 자신 만을 약수로 가지는 수
cnt  = 0
for i in range(3, 101, 1) :
  sosuChk = True
  for j in range(2, i, 1):
    cnt += 1
    if i%j == 0:
      sosuChk = False
      break # 4851 => 1133로 횟수가 줄어듬
  if sosuChk:
    print(i, end=' ')
print()
print("cnt: " , cnt)


print()
print()
print()
print()
print()
print()
print()
print()
print()
print()
print()
