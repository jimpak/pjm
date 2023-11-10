import csv

with open("../singer2.csv", "r") as inFp :
    csvReader = csv.reader(inFp) # csv 라이브러리를 사용한다.
    header_list = next(csvReader) # next는 iterator 개념, header_list = inFp.readline() 와 같은 개념
    print(header_list[1],header_list[6])
    for row_list in csvReader:
        youtube = int(row_list[6].replace(',',''))
        youtube = int(youtube/10000)
        print(row_list[1], str(youtube)+"만")