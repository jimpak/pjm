import sqlite3
from tkinter import simpledialog

con, cur = None, None
data1, data2, data3, data4 = "","","",""
sql = ""

con = sqlite3.connect("C:/workspace/sqlite-tools-win-x64-3440000/naverDB")
cur = con.cursor()

while(True):
    data1 = simpledialog.askstring("사용자ID ", "사용자 ID를 입력하세요", parent=None)
    if data1 == "" :
        break
    data2 = simpledialog.askstring("사용자이름", "사용자이름을 입력하세요", parent=None)
    data3 = simpledialog.askstring("이메일", "사용자 email을 입력하세요", parent=None)
    data4 = simpledialog.askstring("출생연도", "출생연도를 입력하세요", parent=None)
    # sql = "insert into userTable values('" + data1 + "','" + data2 + "','" + data3 + "'," + data4 + ")"
    sql = f"insert into userTable values('{data1}', '{data2}', '{data3}', {data4}) "
    cur.execute(sql)
con.commit()
con.close()