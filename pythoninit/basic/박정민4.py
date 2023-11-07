# 1.
nn = [100, 200, 300]
print(type(nn))

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
print(hap)

# 3.
ary1 = [1,2,3,4]
ary2 = []
for i in range(3, -1, -1):
    ary2.append(ary1[i])
print(ary1)
print(ary2)

# 4.
# (1) 리스트의 전체 개수를 센다. len()
# (2) 두 리스트를 연결한다. extend()
# (3) 리스트 맨 뒤의 항목을 추출한다. pop()
# (4) 지정한 값을 찾아서 위치를 알아낸다. count()
# (5) 리스트에서 특정 값의 개수를 센다. insert()

# 5.
# 4번 튜플은 insert()사용 불가능

# 6.
# 2번 딕셔너리에서 append()는 사용 불가능

# 7.
myData = [[n * m for n in range(1,3)] for m in range(2,4)]
print(myData) # [[2, 4], [3, 6]]

# 8.
# (1) aa = [] -> 나. 리스트
# (2) bb = {} -> 다. 딕셔너리
# (3) cc = () -> 가. 튜플
# (4) dd = None -> 라. 일반 변수

# 9.
# (1) 리스트의 뒤에 리스트를 추가한다. append()
# (2) 리스트에서 지정한 값을 제거한다. remove()
# (3) 리스트 항목의 순서를 역순으로 만든다. reverse()
# (4) 리스트 맨 뒤의 항목을 빼내고, 빼낸 항목은 삭제한다. pop()

# 10.
myList = [
    [1,2,3,4],
    [5,6,7,8],
    [9,10,11,12]
]
print(myList[0][1]) # 2
print(myList[1][3]) # 8
print(myList[2]) # [9, 10, 11, 12]

# 11. 1번
ss='IT_CookBook'
print(ss[0])
print(ss[1:2])
print(ss[0:-1])
print(ss[:4])

# 12.
inStr = 'IT_CookBook_Python'
outStr = ''
print(len(inStr))
tmp = inStr.pop()
print(inStr, tmp)

# for i in range(0, len(inStr)):
#     if i % 2 == 0:
#         outStr =
#     else:
#         outStr += '#'
# print("원본 내용 -->", inStr)
# print("변경 내용 -->", outStr)