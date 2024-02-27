import sqlite3
from tkinter import simpledialog

con, cur = None, None
data1, data2, data3, data4 = "","","",""
sql = ""

con = sqlite3.connect("C:/workspace/sqlite-tools-win-x64-3440000/naverDB")
cur = con.cursor()

while(True):
    data1 = input("사용자ID ==> ")
    if data1 == "" :
        break
    data2 = input("사용자이름 ==> ")
    data3 = input("이메일 ==> ")
    data4 = input("출생연도 ==> ")

    sql = f"insert into userTable values('{data1}', '{data2}', '{data3}', {data4}) "
    cur.execute(sql)

    tmp = input("중단하려면 'y'또는 'Y'를 입력하세요")
    if(tmp == 'y' or tmp == 'Y'): break
con.commit()
con.close()