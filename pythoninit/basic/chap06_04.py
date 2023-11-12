with open("../data/new_singer1.csv", "r") as inFp:
    with open("../data/out_singer1.csv", "w") as outFp:
        # 헤더
        header = inFp.readline()
        header = header.strip() # 공백 제거. strip():문자열 및 공백을 제거해 주는 함수.
        header_list = header.split(",") # ,로 구분하여 list 생성
        header_str = ','.join(map(str, header_list))
        outFp.write(header_str + '\n')

        #데이터 목록
        for inStr in inFp:
            inStr = inStr.strip()
            row_list = inStr.split(',')
            row_list[-1] = row_list[-1].replace('-', '/')
            height_str = "{0:.2f}".format(int(row_list[-2]))
            row_list[-2] = height_str
            row_str = ','.join(map(str, row_list))
            outFp.write(row_str + '\n')

print('Save. Finish!!')