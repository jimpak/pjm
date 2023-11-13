print("Input", end = " : ")
score = int(input())
print(score)
result = ''
if score >= 90:
    result = 'A'
elif score >= 80:
    result = 'B'
elif score >= 70:
    result = 'C'
elif score >= 60:
    result = 'D'
else:
    result = 'F'

print("당신의 학점은 {}".format(result) + " 입니다.")

a = 0
if a in(1,2,3) and a != 0:
    print("포함")
else:
    print("포함되지 않음")