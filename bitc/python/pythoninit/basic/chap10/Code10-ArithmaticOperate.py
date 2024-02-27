import numpy as np

ary = np.random.randint(0, 255, size=(2,3))
print(ary.dtype)
print(ary.ndim) # 차원
print(ary.shape)

ary -= 100 # broadcasting 연산 발생
print(ary)
ary = ary + ary
print(ary)
print(ary)

print("==========================")
arr1 = np.array([[1, 2], [3, 4]])
arr2 = np.array([100, 200])
print(arr1 + arr2)

print("==========================")
ary = np.random.randint(0, 255, size=(2, 3))
print(ary)
ary = 1 / ary;
print(ary)

print("==========================")
ary = np.arange(10)
for item in ary:
    print(item, end='')
print()
for i in range(len(ary)):
    if i != 0 : print(",", end='')
    print(ary[i], end='')
print()
ary[0] = 100
# u.printArr(ary)
print(ary[2:5])
print(ary[-1])
print(ary[-2])
print(ary[:]) # print(ary[-10:-1] 결과와 동일
print(ary[:-1])
ary_sub = ary[3:7] #ary_sub는 주소값을 공유
ary_sub = ary[3:7].copy() #ary_sub 주소값 공유 X
print(ary_sub)
ary_sub[:] = 77
print(ary_sub)
print(ary)

print("=" * 30)
ary1 = np.arange(1, 26, True)
# ary1 = np.arange(1, 26, 2)
print(ary1)
ary2 = ary1.reshape(5,5)
print(ary2.reshape(25))

print("😎"*20)
ary = np.arange(1, 17) # 1차 행렬 생성
print(ary)
print(ary[1])
ary = ary.reshape(4,4) # 2차 행렬 생성
print(ary)
print(ary[1]) # 행 출력 (원소 출력시 ary[0, 1], ary[0][1] 둘다 가능)
print(ary[1, 0:2]) # 행 컬럼 별로 출력 가능
print(ary[1, :])
print(ary[2:])
print(ary[2:4, 0:2]) # 행과 열을 정해서 출력

print("👏"*20)
print(ary)
print(ary[:, 1]) # 열을 1차원으로 표현 [ 2  6 10 14]
print(ary[0:2, :1])
print(ary[:, 1:2]) # 열을 2차원으로 표현
print(ary[:, 2:]) # 열을 2차원으로 표현
print(ary[0:4, 1:3]) # 열을 2차원으로 표현
print(ary[1:3, 1:3])
print(ary)
print(ary[:, [1,3]]) # 인접하지 않는 행 또는 열을 출력
print(ary[[1, 3], :])

print("👍"*20)
ary1 = np.zeros((2,2), dtype=np.int8)
ary2 = np.ones((2,2), dtype=np.int8)
print(ary1, ary2, sep='\n')
print(np.concatenate((ary1, ary2), axis=0))
print(np.concatenate((ary1, ary2), axis=1))
ary = np.array([[1, 2, 3], [4, 5, 6]])
print(ary)
print(ary.transpose(1, 0))
print(ary.T)
print(ary.transpose(0, 1))
