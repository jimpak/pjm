import xlwt
import csv
import os

csvFileList = ["../chap06/data/singerA.csv", "../chap06/data/singerB.csv"]
outWorkbook = xlwt.Workbook() # 액셀파일로 출력하기 위한 객체

for csvFileName in csvFileList :
    rowCount = 0
    with open(csvFileName, "r") as inFp:
        csvReader = csv.reader(inFp) # 파일을 읽어들인 객체
        header_list = next(csvReader) # csv파일의 첫 행 읽기
        # os.path.basename()은 경로or파일에서 파일명만 추출
        outSheet = outWorkbook.add_sheet(os.path.basename(csvFileName).split(".")[0])

        for col in range(len(header_list)) :
            # 제목만 추출해서 입력
            outSheet.write(rowCount, col, header_list[col])
        for row_list in csvReader: # csv 파일에 데이터를 쓰는 작업
            rowCount += 1
            for col in range(len(row_list)):
                if row_list[col].isnumeric() :
                    outSheet.write(rowCount, col, float(row_list[col]))
                else :
                    outSheet.write(rowCount, col, row_list[col])

outWorkbook.save('./Excel/singerCSV.xls')
print("Save. OK~")