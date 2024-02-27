import xlrd
import csv

workbook = xlrd.open_workbook('./Excel/singer.xls')

findColumn = ['이름', '주소', '유튜브 조회수']
findIndex = []

wsheetList = workbook.sheets() # 해당 액셀 파일의 모든 시트를 담은 객체
worksheet = wsheetList[0] # 시트의 0번째, senior워크시트.
header_list = worksheet.row_values(0) # senior워크시트의 첫번째 행을 선택
for name in findColumn :
    findIndex.append(header_list.index(name)) 
    #findColumn에 존재하는 값이 header_list에 존재하는 값만 출력
    # [1,3,6]의 인덱스값이 적용
print(findIndex)

wsheetList = workbook.sheets() # 워크북의 시트를 다시 열어서 초기화
with open("./Excel/singer_youtube.csv", "w", newline='') as outFp:
    csvWriter = csv.writer(outFp)
    csvWriter.writerow(findColumn)
    for worksheet in wsheetList :
        for row in range(1, worksheet.nrows) :
            findList = []
            for col in range(worksheet.ncols) :
                if col in findIndex :
                    findList.append(worksheet.row_values(row)[col])
            csvWriter.writerow(findList)

print("Save. OK~")