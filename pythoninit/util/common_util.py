
# 2차원 배열 리스트 출력
def print2D(list2D):
    rows_len = len(list2D)
    for row in range(rows_len):
        col_len = len(list2D[row])
        for col in range(col_len):
            print('%3d' % list2D[row][col], end=' ')
        print()
    print()

def printArr(arr):
    print("[ ", end='')
    for row in range(len(arr)):
        tmp = len(arr[row]) if(type(arr[row]) == 'int') else 0
        if(tmp > 0):
            for col in range(len(arr[row])):
                print('%3d' % arr[row][col], end=' ')
            print()
        else: print(arr[row], end=' ')
    print("]")