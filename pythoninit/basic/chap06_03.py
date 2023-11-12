def printList(pList):
    for data in pList:
        print(data, end="\t")
    print()

with open("../data/new_singer1.csv", "r") as inFp:
    # 헤더
    header = inFp.readline()
    header = header.strip()
    header_list = header.split(",")
    printList(header_list)

    #데이터 목록
    for inStr in inFp:
        inStr = inStr.strip()
        row_list = inStr.split(',')
        printList(row_list)
