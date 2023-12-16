import numpy as np

# 2차원 배열 생성
SIZE = 5
numpyArr = np.random.randint(0, 255, size=(SIZE, SIZE))

# 출력
print(numpyArr)
print()

# 배열에 100 더하기
numpyArr += 100

# 출력
print(numpyArr)

print()
print()

tot = 0
cnt = 0
for i in range(len(numpyArr)):
    for j in range(len(numpyArr)):
        tot += numpyArr[i][j]
        cnt += 1;
print(f'total: {tot} / average: {tot/cnt}')
print(numpyArr)