with open("../data/new_singer1.csv", "r") as inFp:
    inStr = inFp.readline()
    print(inStr, end=" ")

    # 두 번째 라인을 읽어 들임, 첫번째 라인을 다시 읽기 위해서는 inFp를 다시한번 초기화하고 시작
    inStr = inFp.readline()
    print(inStr, end=" ")
    inFp.close()