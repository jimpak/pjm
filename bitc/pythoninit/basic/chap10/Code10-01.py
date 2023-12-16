# Numpy = Numeric Python
import random

import util.common_util as util

# 2차원 리스트 생성
SIZE = 5 # 상수
pythonList = [[random.randint(0, 255) for _ in range(SIZE)] for _ in range(SIZE)]

for i in range(len(pythonList)):
    for j in range(len(pythonList)):
        pythonList[i][j] += 100


# 리스트 출력
# def print2D():
#     for i in range(SIZE):
#         for k in range(SIZE):
#             print("%3d" % pythonList[i][k], end=' ')
#         print()
#     print()
util.print2D(pythonList)
