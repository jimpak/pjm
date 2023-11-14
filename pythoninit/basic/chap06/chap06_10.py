from tkinter import *
import csv
## 함수 선언 부
def makeEmptySheet(r, w) :
    retList = []
    for i in range(0, rowNum):
        tmpList = []
        for k in range(0, colNum):
            ent = Entry(window, text='', width=10)
            ent.grid(row=i, column=k)
            tmpList.append(ent)
        retList.append(tmpList)
    return retList

## 전역 변수부
csvList = []
rowNum, colNum = 0, 0
workSheet = []

## 메인 코드부
window = Tk()

with open("data/singer1.csv", "r") as inFp :
    csvReader = csv.reader(inFp) # csv파일을 읽어드린 집합 객체
    header_list = next(csvReader) # 한줄 읽음
    csvList.append(header_list) # 제목 붙이기
    for row_list in csvReader: # 나머지 데이터 읽어서 추가하기
        csvList.append(row_list)

rowNum = len(csvList) # 2차원 list의 전체 행 길이
colNum = len(csvList[0]) # 첫번째 행의 열 길이
workSheet = makeEmptySheet(rowNum, colNum)

idx = 6 # 평균 키의 인덱스
for i in range(0, rowNum) : # 워크시트에 리스트값 채우기. (= 각 빈 셀에 값 넣기)
    for k in range(0, colNum) :
        # if ( csvList[i][idx].isnumeric() ) :
        #     if ( int(csvList[i][idx]) >= 167) :
        if (i > 0) :
            tmp = float(csvList[i][idx])
            if(tmp >= 167):
                ent = workSheet[i][k]
                ent.configure(bg='yellow')
        workSheet[i][k].insert(0, csvList[i][k])

window.mainloop()