import sqlite3

con = sqlite3.connect("C:/workspace/sqlite-tools-win-x64-3440000/naverDB")

def get_all():
  c = con.cursor()
  rs = c.execute("select * from student ")
  return rs.fetchall()

def insert_one(std):
  c = con.cursor()
  c.execute(f"insert into student (id, name, pass) "
            f"values('{std.id}','{std.name}','{std.pw}' )")
  con.commit()
  return c.lastrowid

def login_check(std):
  c = con.cursor()
  rs = c.execute(f"select  * from student "
            f"where id={std.id} and pass={std.pw}")
  return rs.fetchone()














